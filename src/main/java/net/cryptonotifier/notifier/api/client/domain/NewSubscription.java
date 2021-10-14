package net.cryptonotifier.notifier.api.client.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class NewSubscription {
  @JsonProperty("addresses")
  List<String> addresses;
  String token;
  String network;
  String webhookUrl;
  int confirmation;
}
