package net.cryptonotifier.notifier.api.client.impl;

import java.util.List;
import net.cryptonotifier.notifier.api.client.constant.CryptoNotifierApiConstant;
import net.cryptonotifier.notifier.api.client.domain.BasicResponse;
import net.cryptonotifier.notifier.api.client.domain.NewSubscription;
import net.cryptonotifier.notifier.api.client.domain.SubscriptionResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface CryptoNotifierService {

  @Headers(CryptoNotifierApiConstant.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER)
  @GET("/api/v1/subscriptions")
  Call<List<SubscriptionResponse>> getSubscriptionList(@Query("start") Integer start,
                                                       @Query("limit") Integer limit);

  @Headers(CryptoNotifierApiConstant.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER)
  @GET("/api/v1/subscriptions/{subscriptionId}")
  Call<SubscriptionResponse> getSubscription(@Path("subscriptionId") String subscriptionId);

  @Headers(CryptoNotifierApiConstant.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER)
  @GET("/api/v1/subscriptions")
  Call<SubscriptionResponse> createSubscription(@Body NewSubscription newSubscription);

  @Headers(CryptoNotifierApiConstant.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER)
  @GET("/api/v1/subscriptions/{subscriptionId}")
  Call<BasicResponse> deleteSubscription(@Path("subscriptionId") String subscriptionId);

}
