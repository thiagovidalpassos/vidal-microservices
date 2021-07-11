package br.com.vidal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class VidalConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(VidalConfigServerApplication.class, args);
	}

}
