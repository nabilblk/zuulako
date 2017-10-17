package com.zuulako.sampleapp;

import com.zuulako.config.EnableZuulako;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableZuulako
public class SampleAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(SampleAppApplication.class, args);
	}

	@RestController
	class ExampleController {
		@RequestMapping(value="/api/hello")
		public String sayHello() {
			return "Hello";
		}
	}

}
