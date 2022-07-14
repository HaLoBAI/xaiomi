package com.mashang.xiaomi;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@MapperScan("com.mashang.xiaomi.mapper")
@EnableWebMvc
public class XaiomiApplication {

	public static void main(String[] args) {
		SpringApplication.run(XaiomiApplication.class, args);
	}

}
