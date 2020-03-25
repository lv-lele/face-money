package com.bearhunting.cameraholder.component.enums;

/**
 * ClassName:HttpResultCode
 * Package:com.bearhunting.cameraholder.component.enums
 * Description: 响应码表
 * @date:2019/11/15 9:39
 * @author:
 */
public enum HttpResultCode {

  INTERNAL_SERVER_ERROR(500, "服务器错误!"),
  REQUEST_METHOD_ERROR(503, "请求方法错误"),
  REQUEST_TIME_OUT(504, "请求超时"),
  INVALID_PARAMETER(10020, "不合法参数!"),
  NO_CONTENT(10030, "查询结果为空!");

  private final int code;
  private final String message;

  HttpResultCode(int value, String msg) {
    this.code = value;
    this.message = msg;
  }

  public int getCode() {
    return this.code;
  }

  public String getMessage() {
    return this.message;
  }

  @Override
  public String toString() {
    return Integer.toString(code);
  }
}
