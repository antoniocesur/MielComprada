package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class MielApplication {

	public static void main(String[] args) {
		String command = "C:\\xampp\\mysql\\bin\\mysqld.exe";
		try{
			Process process = Runtime.getRuntime().exec(command);
			//Process process1 = Runtime.getRuntime().exec("c:\\xampp\\apache")
		}catch (IOException e){
			e.printStackTrace();
		}
		SpringApplication.run(MielApplication.class, args);
	}

}
