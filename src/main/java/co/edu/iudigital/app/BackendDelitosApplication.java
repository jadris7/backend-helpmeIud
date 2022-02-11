package co.edu.iudigital.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class BackendDelitosApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendDelitosApplication.class, args);
		System.out.println("API Cargada...");
	}

}
