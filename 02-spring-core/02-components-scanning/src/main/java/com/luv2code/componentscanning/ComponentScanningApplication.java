package com.luv2code.componentscanning;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(
		scanBasePackages = {
				"com.luv2code.componentscanning",
				"com.luv2code.utils"
		}
)
public class ComponentScanningApplication {

	public static void main(String[] args) {
		SpringApplication.run(ComponentScanningApplication.class, args);
	}

}
