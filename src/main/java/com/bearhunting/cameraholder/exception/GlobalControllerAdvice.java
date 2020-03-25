package com.bearhunting.cameraholder.exception;

import com.bearhunting.cameraholder.common.HttpResult;
import com.bearhunting.cameraholder.component.enums.HttpResultCode;
import com.bearhunting.cameraholder.utils.LocalDateTimeFormatter;
import javax.validation.ValidationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.async.AsyncRequestTimeoutException;


/***
 *  校验和异常捕捉处理
 *  @author scott
 */
@RestControllerAdvice
@Slf4j
public class GlobalControllerAdvice {
  /***
   * 注册StringTrimmerEditor
   * @param binder
   */
  @InitBinder
  public void initBinder(WebDataBinder binder) {
    StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
    binder.registerCustomEditor(String.class, stringTrimmerEditor);
    binder.addCustomFormatter(new LocalDateTimeFormatter());
  }

  @ExceptionHandler(MissingServletRequestParameterException.class)
  public HttpResult handleMissingRequestParameter(MissingServletRequestParameterException e) {
    log.error(e.getMessage(), e);
    return HttpResult.error(HttpResultCode.INVALID_PARAMETER);
  }

  /***
   * 用户捕获@Valid校验失败的异常
   */

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public HttpResult handleInvalidRequestParameter(MethodArgumentNotValidException e) {
    log.error(e.getMessage());
    StringBuilder stringBuilder = new StringBuilder();
    e.getBindingResult()
        .getAllErrors()
        .stream()
        .findFirst()
        .ifPresent(objectError -> stringBuilder.append(objectError.getDefaultMessage()).append("\n"));
    return HttpResult.error(10020, stringBuilder.toString());
  }

  /***
   * 捕获校验中抛出的异常
   */

  @ExceptionHandler(ValidationException.class)
  public HttpResult handleValidationException(ValidationException e) {
    Throwable t = e.getCause();
    log.error(t.getMessage());
    return HttpResult.error(10020, t.getMessage());
  }

  @ExceptionHandler(HttpMessageNotReadableException.class)
  public HttpResult handleHttpMessageNotReadableException(HttpMessageNotReadableException e) {
    log.error(e.getRootCause().getMessage(), e.getRootCause());
    return HttpResult.error(400, e.getRootCause().getMessage());
  }

  @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
  public HttpResult handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e) {
    log.error(e.getMessage(), e);
    return HttpResult.error(HttpResultCode.REQUEST_METHOD_ERROR);
  }

  @ExceptionHandler(AsyncRequestTimeoutException.class)
  public HttpResult handleAsyncRequestTimeoutException(AsyncRequestTimeoutException e) {
    log.error("异步请求超时");
    return HttpResult.error(HttpResultCode.REQUEST_TIME_OUT);
  }

  @ExceptionHandler(CustomException.class)
  public HttpResult handleCustomerException(CustomException e) {
    log.error(e.getMessage());
    return HttpResult.error(10000, e.getMessage());
  }

  @ExceptionHandler(Exception.class)
  public HttpResult handleBackendException(Exception e) {
    log.error(e.getMessage(), e);
    return HttpResult.error(HttpResultCode.INTERNAL_SERVER_ERROR);
  }
}
