package com.bearhunting.cameraholder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


@SpringBootApplication
@EnableJpaAuditing
public class CameraHolderApplication {

  public static void main(String[] args) {
    SpringApplication.run(CameraHolderApplication.class, args);
  }
}
