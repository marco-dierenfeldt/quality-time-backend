package de.dierenfeldt.qualitytime.qualitytimebackend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@SpringBootApplication
@EnableJpaRepositories
public class QualityTimeBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(QualityTimeBackendApplication.class, args);
	}

	@Autowired
	private Environment env;

}
