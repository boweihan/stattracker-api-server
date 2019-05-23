package com.boweihan.stattracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class StattrackerApplication {

	public static void main(String[] args) {
		SpringApplication.run(StattrackerApplication.class, args);
	}

}
