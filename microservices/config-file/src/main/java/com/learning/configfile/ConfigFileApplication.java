package com.learning.configfile;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class ConfigFileApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigFileApplication.class, args);
	}

}
