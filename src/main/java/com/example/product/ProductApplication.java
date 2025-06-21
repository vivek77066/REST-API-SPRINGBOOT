package com.example.product;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(
		info=@Info(
				title = "Product service Rest api documentation",
				description = "Products service Rest api",
				version="v1",
				contact = @Contact(
						name="Vivek jethava",
						email = "jethavavivek77@gmail.com"
				)
		),
		externalDocs = @ExternalDocumentation(
				description = "Hello clients",
				url = "example.com"
		)
)
@SpringBootApplication
public class ProductApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductApplication.class, args);
	}

}
