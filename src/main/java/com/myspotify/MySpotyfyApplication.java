package com.myspotify;

import java.util.Collections;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
public class MySpotyfyApplication {

	public static void main(String[] args) {
		SpringApplication.run(MySpotyfyApplication.class, args);
	}
	
	@Bean
    public Docket swaggerConfiguration() {

        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.myspotify.controller"))
                .build()
                .apiInfo(apiDetails());
    }

    private ApiInfo apiDetails() {
        return new ApiInfo(
                "My PlayList Music",
                "Api Documentation",
                "1.0",
                "",
                new springfox.documentation.service.Contact("Afdhalul Ihsan", "", "afdhalulhsn74@gmail.com"),
                "",
                "",
                Collections.emptyList());
    }

	
}
