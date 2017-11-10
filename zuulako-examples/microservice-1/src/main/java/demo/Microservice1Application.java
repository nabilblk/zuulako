package demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
public class Microservice1Application {

    public static void main(String[] args) {
        SpringApplication.run(Microservice1Application.class, args);
    }

    @RestController
    class ExampleController {
        @RequestMapping(value="/stuff")
        public String sayHello() {
            return "<h1>Stuff from service 1</h1>";
        }
    }

}
