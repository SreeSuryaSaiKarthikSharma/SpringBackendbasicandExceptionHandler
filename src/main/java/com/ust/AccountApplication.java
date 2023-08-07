package com.ust;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ust.testGenerator.TestGeneration;

@SpringBootApplication
public class AccountApplication {

	public static void main(String[] args) {
		TestGeneration generation = new TestGeneration();
		generation.generateTestCases("com.ust");
		SpringApplication.run(AccountApplication.class, args);
		
	}

}
