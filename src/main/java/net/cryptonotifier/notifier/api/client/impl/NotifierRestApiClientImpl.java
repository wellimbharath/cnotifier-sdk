package net.cryptonotifier.notifier.api.client.impl;

import java.util.List;
import net.cryptonotifier.notifier.api.client.NotifierRestApiClient;
import net.cryptonotifier.notifier.api.client.domain.NewSubscription;
import net.cryptonotifier.notifier.api.client.domain.SubscriptionResponse;

public class NotifierRestApiClientImpl implements NotifierRestApiClient {


  @Override
  public SubscriptionResponse createSubscription(NewSubscription newSubscription) {
    return null;
  }

  @Override
  public SubscriptionResponse getSubscription(String subscriptionId) {
    return null;
  }

  @Override
  public List<SubscriptionResponse> getSubscriptions(int start, int size) {
    return null;
  }

  @Override
  public void deleteSubscription(NewSubscription newSubscription) {

  }
}
