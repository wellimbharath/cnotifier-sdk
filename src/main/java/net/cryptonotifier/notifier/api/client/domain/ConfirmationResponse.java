package net.cryptonotifier.notifier.api.client.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.checkerframework.checker.units.qual.A;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConfirmationResponse {
    String network;
    String txnHash;
    long blockNumber;
    long currentHeight;
    long confirmations;
}
