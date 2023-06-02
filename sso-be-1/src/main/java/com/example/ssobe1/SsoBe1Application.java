package com.example.ssobe1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

@EnableRedisHttpSession
@SpringBootApplication
public class SsoBe1Application {

	public static void main(String[] args) {
		SpringApplication.run(SsoBe1Application.class, args);
	}

}
