package com.bearhunting.cameraholder.common;

import com.bearhunting.cameraholder.component.enums.HttpResultCode;


/**
 * ClassName:HttpResultCode
 * Package:com.bearhunting.cameraholder.common
 * Description: 返回的结果集
 * @date:
 * @author:
 */
public class HttpResult<T> {
  private int code;
  private String message;
  private T data;

  private HttpResult(T data) {
    this.code = 200;
    this.message = "ok";
    this.data = data;
  }

  private HttpResult(HttpResultCode code) {
    if (code == null) {
      return;
    }
    this.code = code.getCode();
    this.message = code.getMessage();
  }

  private HttpResult(int code, String message) {
    this.code = code;
    this.message = message;
  }

  private HttpResult(String message) {
    this.message = message;
  }

  /**
   * 成功时候的调用
   * @return
   */
  public static <T> HttpResult<T> success(T data) {
    return new HttpResult<T>(data);
  }

  /**
   * 成功，不需要传入参数
   * @return
   */
  @SuppressWarnings("unchecked")
  public static <T> HttpResult<T> success() {
    return (HttpResult<T>) success("");
  }

  /**
   * 失败时候的调用
   * @return
   */
  public static <T> HttpResult<T> error(HttpResultCode code) {
    return new HttpResult<T>(code);
  }

  /**
   * 失败时候传递参数
   * @return
   */
  public static <T> HttpResult<T> error(int code, String message) {
    return new HttpResult<T>(code, message);
  }

  /**
   * 失败时候传递参数
   * @return
   */
  public static <T> HttpResult<T> error(String message) {
    return new HttpResult<T>(message);
  }

  public T getData() {
    return data;
  }

  public String getMessage() {
    return message;
  }

  public int getCode() {
    return code;
  }
}
