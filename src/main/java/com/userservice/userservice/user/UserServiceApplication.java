package com.userservice.userservice.user;

import com.userservice.userservice.user.error.FeignErrorDecoder;
import feign.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignErrorDecoderFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class UserServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserServiceApplication.class, args);
	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}

	@Bean
	@LoadBalanced //마이크로서비스 네임값 사용
	public RestTemplate getRestTemplate(){
		return new RestTemplate();
	}

	@Bean // feign client 정ㅂ
	public Logger.Level feignLoggerLevel(){
		return Logger.Level.FULL;
	}
	/*@Bean @component로 등록 했기때문에 빈으로 등록 할 필요없음
	public FeignErrorDecoder getFeignDecoder(){
		return new FeignErrorDecoder();
	}*/
}
