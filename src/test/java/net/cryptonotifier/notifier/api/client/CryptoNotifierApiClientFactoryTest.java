package net.cryptonotifier.notifier.api.client;

import com.fasterxml.jackson.core.JsonProcessingException;
import java.util.Collections;
import junit.framework.TestCase;
import net.cryptonotifier.notifier.api.client.domain.NewSubscription;
import net.cryptonotifier.notifier.api.client.domain.SubscriptionResponse;
import net.cryptonotifier.notifier.api.client.impl.CryptoNotifierRestApiClientImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
public class CryptoNotifierApiClientFactoryTest extends TestCase {

//  @Test
//  public void testSubscription() {
//    String apikey = "";
//
//    CryptoNotifierApiClientFactory cryptoNotifierRestApiFactory = CryptoNotifierApiClientFactory.newInstance(apikey);
//
//    CryptoNotifierRestApiClient cryptoNotifierRestApiClient = cryptoNotifierRestApiFactory.newRestClient();
//
//    NewSubscription
//        newSubscription = new NewSubscription(Collections.singletonList("TNaRAoLUyYEV2uF7GUrzSjRQTU8v5ZJ5VR"),"TRX","MAINNET","https://webhook.site/f65be83b-e316-4591-ab7c-73b92c99d05d",6);
//
//    try {
//      SubscriptionResponse exception = cryptoNotifierRestApiClient.createSubscription(newSubscription);
//    } catch (CryptoNotifierError | JsonProcessingException e) {
//      Assertions.assertEquals(e.getMessage(),"Invalid api key.");
//    }
//  }
}