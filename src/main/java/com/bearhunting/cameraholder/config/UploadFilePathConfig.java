package com.bearhunting.cameraholder.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;


/**
 * Author: scott
 * Description: 外部资源映射
 * @author
 */
@Configuration
public class UploadFilePathConfig extends WebMvcConfigurationSupport {
  /**
   * 存放在这个路径下：该路径是该工程目录下的static文件下
   * 放在static下的原因是，存放的是静态文件资源，即通过浏览器输入本地服务器地址，加文件名时是可以访问到的
   * @param registry
   */

  @Override
  public void addResourceHandlers(ResourceHandlerRegistry registry) {
    registry.addResourceHandler("/index/**").addResourceLocations("file:E:\\DevInstall\\GitRepository\\api\\zkapi\\");
    super.addResourceHandlers(registry);
  }
}
