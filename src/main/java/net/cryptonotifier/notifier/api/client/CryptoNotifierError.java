package net.cryptonotifier.notifier.api.client;

import lombok.Data;
import net.cryptonotifier.notifier.api.client.constant.CryptoNotifierApiConstant;
import org.apache.commons.lang3.builder.ToStringBuilder;

@Data
public class CryptoNotifierError {

  /**
   * Error code.
   */
  private int code;

  /**
   * Error message.
   */
  private String msg;


  @Override
  public String toString() {
    return new ToStringBuilder(this, CryptoNotifierApiConstant.TO_STRING_BUILDER_STYLE)
        .append("code", code)
        .append("msg", msg)
        .toString();
  }
}
