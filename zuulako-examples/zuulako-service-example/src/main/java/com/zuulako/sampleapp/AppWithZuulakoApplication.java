package com.zuulako.sampleapp;

import com.zuulako.config.EnableZuulako;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@EnableZuulako
public class AppWithZuulakoApplication {

	@Autowired
	private DiscoveryClient discoveryClient;

	public static void main(String[] args) {
		SpringApplication.run(AppWithZuulakoApplication.class, args);
	}


}
