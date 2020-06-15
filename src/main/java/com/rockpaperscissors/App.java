
package com.rockpaperscissors;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages="com.rockpaperscissors.controller")
@ComponentScan(basePackages="com.rockpaperscissors.delegate")
@ComponentScan(basePackages="com.rockpaperscissors.filter")
@ComponentScan(basePackages="com.rockpaperscissors.domain")
public class App {

	public static void main(String[] args) {
		
		SpringApplication.run(App.class, args);
    
	}
	

}