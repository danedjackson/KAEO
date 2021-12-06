package com.nb.kaeo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class KaeoApplication {

	public static void main(String[] args) {
		SpringApplication.run(KaeoApplication.class, args);
	}
}
