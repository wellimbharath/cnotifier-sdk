package net.cryptonotifier.notifier.api.client.constant;

import org.apache.commons.lang3.builder.ToStringStyle;

public class CryptoNotifierApiConstant {


  public static final String API_KEY_HEADER = "X-APIKEY";

  public static final String ENDPOINT_SECURITY_TYPE_APIKEY = "X-APIKEY";
  public static final String ENDPOINT_SECURITY_TYPE_APIKEY_HEADER =
      ENDPOINT_SECURITY_TYPE_APIKEY + ": #";


  public static ToStringStyle TO_STRING_BUILDER_STYLE = ToStringStyle.SHORT_PREFIX_STYLE;
}
