package com.telusko;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;


@SpringBootApplication
@OpenAPIDefinition(
		info=@Info(title="Question Service API",
		version="1.0",
		description="This API is to perform question related operations"),
		servers=@Server(
				url="http://localhost:9091/QuestionService",
				description="This API URL will help to perform question related operations"
				
				)
		)

public class QuestionServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuestionServiceApplication.class, args);
	}

}
