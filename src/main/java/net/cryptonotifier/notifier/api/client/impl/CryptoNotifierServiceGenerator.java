package net.cryptonotifier.notifier.api.client.impl;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.util.concurrent.TimeUnit;
import net.cryptonotifier.notifier.api.client.CryptoNotifierError;
import net.cryptonotifier.notifier.api.client.config.CryptoNotifierApiConfig;
import net.cryptonotifier.notifier.api.client.exception.CryptoNotifierException;
import net.cryptonotifier.notifier.api.client.security.AuthenticationInterceptor;
import okhttp3.Dispatcher;
import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import org.apache.commons.lang3.StringUtils;
import retrofit2.Call;
import retrofit2.Converter;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class CryptoNotifierServiceGenerator {

  private static final OkHttpClient sharedClient;
  private static final Converter.Factory converterFactory = JacksonConverterFactory.create();

  static {
    Dispatcher dispatcher = new Dispatcher();
    dispatcher.setMaxRequestsPerHost(500);
    dispatcher.setMaxRequests(500);
    sharedClient = new OkHttpClient.Builder()
        .dispatcher(dispatcher)
        .pingInterval(20, TimeUnit.SECONDS)
        .build();
  }

  @SuppressWarnings("unchecked")
  private static final Converter<ResponseBody, CryptoNotifierError> errorBodyConverter =
      (Converter<ResponseBody, CryptoNotifierError>) converterFactory.responseBodyConverter(
          CryptoNotifierError.class, new Annotation[0], null);

  public static <S> S createService(Class<S> serviceClass) {
    return createService(serviceClass, null);
  }


  /**
   * Create a Crypto notifier API service.
   *
   * @param serviceClass the type of service.
   * @param apiKey       Crypto notifier API key.
   * @return a new implementation of the API endpoints for the Crypto notifier API service.
   */
  public static <S> S createService(Class<S> serviceClass, String apiKey) {
    String baseUrl = CryptoNotifierApiConfig.getApiBaseUrl();

    Retrofit.Builder retrofitBuilder = new Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(converterFactory);

    if (StringUtils.isEmpty(apiKey)) {
      retrofitBuilder.client(sharedClient);
    } else {
      // `adaptedClient` will use its own interceptor, but share thread pool etc with the 'parent' client
      AuthenticationInterceptor interceptor = new AuthenticationInterceptor(apiKey);;
      OkHttpClient adaptedClient = sharedClient.newBuilder().addInterceptor(interceptor).build();
      retrofitBuilder.client(adaptedClient);
    }
    Retrofit retrofit = retrofitBuilder.build();
    return retrofit.create(serviceClass);
  }

  /**
   * Execute a REST call and block until the response is received.
   */
  public static <T> T executeSync(Call<T> call) {
    try {
      Response<T> response = call.execute();
      if (response.isSuccessful()) {
        return response.body();
      } else {
        CryptoNotifierError apiError = getCryptoNotifierError(response);
        throw new CryptoNotifierException(apiError);
      }
    } catch (IOException e) {
      e.printStackTrace();
      throw new CryptoNotifierException(e);
    }
  }

  /**
   * Extracts and converts the response error body into an object.
   */
  public static CryptoNotifierError getCryptoNotifierError(Response<?> response) throws IOException,
      CryptoNotifierException {
    return errorBodyConverter.convert(response.errorBody());
  }

  /**
   * Returns the shared OkHttpClient instance.
   */
  public static OkHttpClient getSharedClient() {
    return sharedClient;
  }

}
