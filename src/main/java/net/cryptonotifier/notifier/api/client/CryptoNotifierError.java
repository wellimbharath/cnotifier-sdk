package net.cryptonotifier.notifier.api.client;

import lombok.Data;
import lombok.EqualsAndHashCode;
import net.cryptonotifier.notifier.api.client.constant.CryptoNotifierApiConstant;
import org.apache.commons.lang3.builder.ToStringBuilder;

@EqualsAndHashCode(callSuper = true)
@Data
public class CryptoNotifierError extends Throwable {

  /**
   * Error code.
   */
  private int code;

  /**
   * Error message.
   */
  private String message;

  private String timestamp;

  private String status;

  private String error;

  private String path;

  @Override
  public String toString() {
    return new ToStringBuilder(this, CryptoNotifierApiConstant.TO_STRING_BUILDER_STYLE)
        .append("code", code)
        .append("msg", message)
        .append("timestamp",timestamp)
        .toString();
  }
}
