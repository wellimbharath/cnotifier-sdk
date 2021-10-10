Cryptonotifier Java SDK

**_cryptonotifier-sdk_** is a lightweight Java library for interacting with the [Cryptonotifier API](https://www.cryptonotifier.net), providing complete API coverage, and supporting REST api requests.

Features
---
---

- Support for synchronous REST requests to all Account endpoints.

Installation
---
---

- Install library into your Maven's local repository by running mvn install
- Add the following dependency to your project


```
# build.gradle
implementation group: 'com.liferay', name: 'com.liferay.adaptive.media.test.util', version: '4.0.3'
```

Example: 
---
---



```

package com.example.in.cryptonotifier.demo;

import lombok.extern.slf4j.Slf4j;
import net.cryptonotifier.notifier.api.client.CryptoNotifierApiClientFactory;
import net.cryptonotifier.notifier.api.client.CryptoNotifierRestApiClient;
import net.cryptonotifier.notifier.api.client.domain.NewSubscription;
import net.cryptonotifier.notifier.api.client.domain.SubscriptionResponse;
import org.springframework.beans.factory.annotation.Value;

@Slf4j
public class CryptoNotifierWrapper {

    @Value("${secret.crypto-notifier-api-key}")
    private String apiKey;
    
    // Create Subscription 
    
    public SubscriptionResponse createSubscription(NewSubscription newSubscription){
        final CryptoNotifierApiClientFactory factory = CryptoNotifierApiClientFactory.newInstance(apiKey);
        final CryptoNotifierRestApiClient client = factory.newRestClient();
        SubscriptionResponse subscriptionResponse = client.createSubscription(newSubscription);
        return subscriptionResponse;
    }
    
}
```


** substitute _apiKey_ with your **api token** from the site.

