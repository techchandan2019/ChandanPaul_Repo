package com.neosoft;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

import brave.sampler.Sampler;

@SpringBootApplication
@EnableEurekaClient
public class MsProj01ProductServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsProj01ProductServiceApplication.class, args);
	}
	
	@Bean
	public Sampler createSampler() {
		return Sampler.ALWAYS_SAMPLE;
	}

}
