package net.cryptonotifier.notifier.api.client.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class NewSubscription {
  String address;
  String token;
  String network;
  String webhookUrl;
  int confirmation;
}
