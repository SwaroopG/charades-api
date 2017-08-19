package com.poorjar.charades;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CharadesClientApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(PoorjarCharadesApiApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(PoorjarCharadesClientApplication.class, args);
	}
}
