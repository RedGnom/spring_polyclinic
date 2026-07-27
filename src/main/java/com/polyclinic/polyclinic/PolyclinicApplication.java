package com.polyclinic.polyclinic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import me.paulschwarz.springdotenv.spring.DotenvApplicationInitializer;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PolyclinicApplication {

	public static void main(String[] args) {
		new SpringApplicationBuilder(PolyclinicApplication.class)
				.initializers(new DotenvApplicationInitializer())
				.run(args);
	}

}
