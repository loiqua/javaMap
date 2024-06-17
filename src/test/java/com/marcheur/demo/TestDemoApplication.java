package com.marcheur.demo;

import com.marcheur.marcheurApplication;
import org.springframework.boot.SpringApplication;

public class TestDemoApplication {

	public static void main(String[] args) {
		SpringApplication.from(marcheurApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
