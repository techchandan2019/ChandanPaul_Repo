package com.neosoft;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

import brave.sampler.Sampler;

@SpringBootApplication
@EnableEurekaClient
public class MsProj01UserServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsProj01UserServiceApplication.class, args);
	}

	@Bean
	public Sampler createSampler() {
		return Sampler.ALWAYS_SAMPLE;
	}
}
