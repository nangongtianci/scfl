package com.scfl.dispatching.center;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class DispatchingCenterApplication {

	public static void main(String[] args) {
		SpringApplication.run(DispatchingCenterApplication.class, args);
	}
}
