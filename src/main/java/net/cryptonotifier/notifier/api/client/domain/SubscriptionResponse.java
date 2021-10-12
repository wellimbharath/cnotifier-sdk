package net.cryptonotifier.notifier.api.client.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.LinkedHashMap;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubscriptionResponse {
  LinkedHashMap<String,String> data;
  int code;
  String msg;
}
