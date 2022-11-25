package com.kttkpm.product_type;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableCaching
@EnableEurekaClient
public class ProductTypeApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductTypeApplication.class, args);
	}

}
