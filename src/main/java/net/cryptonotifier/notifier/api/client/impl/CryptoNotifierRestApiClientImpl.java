package net.cryptonotifier.notifier.api.client.impl;

import static net.cryptonotifier.notifier.api.client.impl.CryptoNotifierServiceGenerator.createService;
import static net.cryptonotifier.notifier.api.client.impl.CryptoNotifierServiceGenerator.executeSync;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import net.cryptonotifier.notifier.api.client.CryptoNotifierError;
import net.cryptonotifier.notifier.api.client.CryptoNotifierRestApiClient;
import net.cryptonotifier.notifier.api.client.domain.BasicResponse;
import net.cryptonotifier.notifier.api.client.domain.ConfirmationResponse;
import net.cryptonotifier.notifier.api.client.domain.NewSubscription;
import net.cryptonotifier.notifier.api.client.domain.SubscriptionResponse;
import retrofit2.Call;


public class CryptoNotifierRestApiClientImpl implements CryptoNotifierRestApiClient {


    private final CryptoNotifierService cryptoNotifierService;

    public CryptoNotifierRestApiClientImpl(String apiKey) {
        cryptoNotifierService = createService(CryptoNotifierService.class, apiKey);
    }


    @Override
    public SubscriptionResponse createSubscription(NewSubscription newSubscription) throws
        CryptoNotifierError, JsonProcessingException {
        final Call<SubscriptionResponse> call;
        ObjectMapper objectMapper = new ObjectMapper();
        call = cryptoNotifierService.createSubscription(objectMapper.convertValue(newSubscription,
            JsonNode.class));
        return executeSync(call);
    }

    @Override
    public SubscriptionResponse getSubscription(String subscriptionId) {
        final Call<SubscriptionResponse> call;
        call = cryptoNotifierService.getSubscription(subscriptionId);
        return executeSync(call);
    }

    @Override
    public List<SubscriptionResponse> getSubscriptions(int start, int size) {
        final Call<List<SubscriptionResponse>> call;
        call = cryptoNotifierService.getSubscriptionList(start, size);
        return executeSync(call);
    }

    @Override
    public BasicResponse deleteSubscription(String subscriptionId) {
        final Call<BasicResponse> call;
        call = cryptoNotifierService.deleteSubscription(subscriptionId);
        return executeSync(call);
    }

    @Override
    public ConfirmationResponse getConfirmations(String txnId) {
        final Call<ConfirmationResponse> call = cryptoNotifierService.getConfirmation(txnId);
        return executeSync(call);
    }
}
