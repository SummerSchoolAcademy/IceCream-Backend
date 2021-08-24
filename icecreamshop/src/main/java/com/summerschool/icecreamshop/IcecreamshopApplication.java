package com.summerschool.icecreamshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class IcecreamshopApplication {

	public static void main(String[] args) {
		SpringApplication.run(IcecreamshopApplication.class, args);
	}
}
