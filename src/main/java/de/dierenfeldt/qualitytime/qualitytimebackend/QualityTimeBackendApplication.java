package de.dierenfeldt.qualitytime.qualitytimebackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

//
// Spring Security für Test ausgehebelt: Please don't do this ;-)
// Quelle: https://stackoverflow.com/questions/23894010/spring-boot-security-disable-security
// spring.security.user=user
// spring.security.password= generiert beim Hochfahren von Spring Boot, wenn die exclude Anweisung auskommentiert wird
//
@Configuration
@SpringBootApplication(
		exclude = {
				org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class,
				org.springframework.boot.actuate.autoconfigure.security.servlet.ManagementWebSecurityAutoConfiguration.class
		}
)
@EnableJpaRepositories
public class QualityTimeBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(QualityTimeBackendApplication.class, args);
	}

}
