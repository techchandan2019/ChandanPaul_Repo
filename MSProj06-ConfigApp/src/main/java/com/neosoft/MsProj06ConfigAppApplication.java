package com.neosoft;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class MsProj06ConfigAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsProj06ConfigAppApplication.class, args);
	}

}
