package com.springevenings.springdatarestsample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import springfox.documentation.spring.data.rest.configuration.SpringDataRestConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

// use
// http://localhost:8080/springdatarestsample/swagger-ui.html
// to see swagger documentation
// source: https://reflectoring.io/documenting-spring-data-rest-api-with-springfox/

@SpringBootApplication
@EnableSwagger2
@Import(SpringDataRestConfiguration.class)
public class SpringDataRestSampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDataRestSampleApplication.class, args);
	}
}
