package net.cryptonotifier.notifier.api.client.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class NewSubscription {
  List<String> addresses;
  String token;
  String network;
  String webhookUrl;
  int confirmation;
}
