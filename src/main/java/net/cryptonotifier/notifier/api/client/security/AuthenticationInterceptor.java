package net.cryptonotifier.notifier.api.client.security;

import java.io.IOException;
import java.util.Objects;
import net.cryptonotifier.notifier.api.client.constant.CryptoNotifierApiConstant;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okio.Buffer;

/**
 * A request interceptor that injects the API Key Header into requests, and signs messages, whenever required.
 */
public class AuthenticationInterceptor implements Interceptor {

  private final String apiKey;

  public AuthenticationInterceptor(String apiKey) {
    this.apiKey = apiKey;
  }

  @Override
  public Response intercept(Chain chain) throws IOException {
    Request original = chain.request();
    Request.Builder newRequestBuilder = original.newBuilder();
    newRequestBuilder.addHeader(CryptoNotifierApiConstant.API_KEY_HEADER, this.apiKey);
    Request newRequest = newRequestBuilder.build();
    return chain.proceed(newRequest);
  }

  /**
   * Extracts the request body into a String.
   *
   * @return request body as a string
   */
  @SuppressWarnings("unused")
  private static String bodyToString(RequestBody request) {
    try (final Buffer buffer = new Buffer()) {
      final RequestBody copy = request;
      if (copy != null) {
        copy.writeTo(buffer);
      } else {
        return "";
      }
      return buffer.readUtf8();
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    final AuthenticationInterceptor that = (AuthenticationInterceptor) o;
    return Objects.equals(apiKey, that.apiKey);
  }

  @Override
  public int hashCode() {
    return Objects.hash(apiKey);
  }
}