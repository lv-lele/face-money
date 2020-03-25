package com.bearhunting.cameraholder.utils;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import org.springframework.format.Formatter;


/***
 * 自定义LocalDateTimeToString 转换器
 * @author scott
 */
public class LocalDateTimeFormatter implements Formatter<LocalDateTime> {

  private final DateTimeFormatter dateTimeFormatter;

  public LocalDateTimeFormatter() {
    dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
  }

  public LocalDateTimeFormatter(String pattern) {
    dateTimeFormatter = DateTimeFormatter.ofPattern(pattern);
  }

  @Override
  public LocalDateTime parse(String text, Locale locale) throws ParseException {
    return LocalDateTime.parse(text, dateTimeFormatter);
  }

  @Override
  public String print(LocalDateTime object, Locale locale) {
    return object.format(dateTimeFormatter);
  }
}
