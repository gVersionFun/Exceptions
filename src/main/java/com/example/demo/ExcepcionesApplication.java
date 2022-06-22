package com.example.demo;

import com.example.demo.repositories.MongoUserRepo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories(basePackageClasses = MongoUserRepo.class)
@EnableJpaRepositories(excludeFilters =
@ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, value = MongoUserRepo.class))
@SpringBootApplication
public class ExcepcionesApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExcepcionesApplication.class, args);
	}

}
