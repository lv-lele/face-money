package com.bearhunting.cameraholder.exception;

/***
 *  自定义运行异常
 *  @author scott
 */
public class CustomException extends RuntimeException {

  private final transient Object data;

  public CustomException(String message) {
    super(message);
    data = null;
  }

  public CustomException(String message, Object data) {
    super(message);
    this.data = data;
  }

  public CustomException(Object data) {
    this.data = data;
  }

  public Object getData() {
    return data;
  }
}
