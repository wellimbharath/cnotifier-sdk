package net.cryptonotifier.notifier.api.client;

import lombok.AllArgsConstructor;
import lombok.Data;
import net.cryptonotifier.notifier.api.client.impl.CryptoNotifierRestApiClientImpl;

@Data
@AllArgsConstructor

public class CryptoNotifierApiClientFactory {
  private String apiKey;

  public static CryptoNotifierApiClientFactory newInstance(String apiKey) {
    return new CryptoNotifierApiClientFactory(apiKey);
  }

  /**
   * Creates a new synchronous/blocking REST client.
   */

  public CryptoNotifierRestApiClient newRestClient() {
    return new CryptoNotifierRestApiClientImpl(this.apiKey);
  }

}
