package net.cryptonotifier.notifier.api.client;

import java.util.List;
import net.cryptonotifier.notifier.api.client.domain.BasicResponse;
import net.cryptonotifier.notifier.api.client.domain.NewSubscription;
import net.cryptonotifier.notifier.api.client.domain.SubscriptionResponse;

public interface CryptoNotifierRestApiClient {

  /**
   * Create Subscription
   *
   * @param newSubscription : New subscription of address to create.
   * @return new subscription details
   */
  SubscriptionResponse createSubscription(NewSubscription newSubscription);

  /**
   * Get Subscription
   *
   * @param subscriptionId : Subscription Id.
   * @return subscription details
   */
  SubscriptionResponse getSubscription(String subscriptionId);

  /**
   * Get Subscription List
   *
   * @param start : Starting index.
   * @param size  : The total items in the response
   * @return subscriptions details
   */
  List<SubscriptionResponse> getSubscriptions(int start, int size);

  /**
   * Update Subscription
   *
   * @param subscriptionId : Subscription Id.
   */

  BasicResponse deleteSubscription(String subscriptionId);

}
