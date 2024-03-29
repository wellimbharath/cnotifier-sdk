package net.cryptonotifier.notifier.api.client.impl;

import com.fasterxml.jackson.databind.JsonNode;
import java.util.List;
import net.cryptonotifier.notifier.api.client.CryptoNotifierError;
import net.cryptonotifier.notifier.api.client.domain.BasicResponse;
import net.cryptonotifier.notifier.api.client.domain.ConfirmationResponse;
import net.cryptonotifier.notifier.api.client.domain.NewSubscription;
import net.cryptonotifier.notifier.api.client.domain.SubscriptionResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface CryptoNotifierService {

  @GET("/api/v1/subscriptions")
  Call<List<SubscriptionResponse>> getSubscriptionList(@Query("start") Integer start,
                                                       @Query("limit") Integer limit);

  @GET("/api/v1/subscriptions/{subscriptionId}")
  Call<SubscriptionResponse> getSubscription(@Path("subscriptionId") String subscriptionId);

  @Headers("Content-Type: application/json")
  @POST("/api/v1/subscriptions")
  Call<SubscriptionResponse> createSubscription(@Body JsonNode newSubscription)
      throws CryptoNotifierError;

  @DELETE("/api/v1/subscriptions/{subscriptionId}")
  Call<BasicResponse> deleteSubscription(@Path("subscriptionId") String subscriptionId);

  @GET("/api/v1/confirmations/{txnId}")
  Call<ConfirmationResponse> getConfirmation(String txnId);
}
