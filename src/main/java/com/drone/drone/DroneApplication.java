package com.drone.drone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DroneApplication {

	/**
	 * Initial class
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(DroneApplication.class, args);
		System.out.print("Application is running on port: 8082");
	}

}
