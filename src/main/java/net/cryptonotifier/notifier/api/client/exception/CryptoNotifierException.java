package net.cryptonotifier.notifier.api.client.exception;

import net.cryptonotifier.notifier.api.client.CryptoNotifierError;

/**
 * An exception which can occur while invoking methods of the Crypto Notifier API.
 */
public class CryptoNotifierException extends RuntimeException {

  private static final long serialVersionUID = 3788669840036201041L;
  /**
   * Error response object returned by Crypto notifier API.
   */
  private CryptoNotifierError error;

  /**
   * Instantiates a new Crypto notifier api exception.
   *
   * @param error an error response object
   */
  public CryptoNotifierException(CryptoNotifierError error) {
    this.error = error;
  }

  /**
   * Instantiates a new Crypto notifier api exception.
   */
  public CryptoNotifierException() {
    super();
  }

  /**
   * Instantiates a new Crypto notifier api exception.
   *
   * @param message the message
   */
  public CryptoNotifierException(String message) {
    super(message);
  }

  /**
   * Instantiates a new Crypto notifier api exception.
   *
   * @param cause the cause
   */
  public CryptoNotifierException(Throwable cause) {
    super(cause);
  }

  /**
   * Instantiates a new Crypto notifier api exception.
   *
   * @param message the message
   * @param cause   the cause
   */
  public CryptoNotifierException(String message, Throwable cause) {
    super(message, cause);
  }

  /**
   * @return the response error object from Crypto notifier API, or null if no response object was returned (e.g. server returned 500).
   */
  public CryptoNotifierError getError() {
    return error;
  }

  @Override
  public String getMessage() {
    if (error != null) {
      return error.getMsg();
    }
    return super.getMessage();
  }


}
