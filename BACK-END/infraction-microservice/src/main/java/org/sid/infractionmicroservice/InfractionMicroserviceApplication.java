package org.sid.infractionmicroservice;

import org.sid.infractionmicroservice.Entities.Infraction;
import org.sid.infractionmicroservice.Repository.InfractionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import java.util.Date;

@SpringBootApplication
public class InfractionMicroserviceApplication {
	@Autowired
	private InfractionRepository infractionRepository;

	public static void main(String[] args) {
		SpringApplication.run(InfractionMicroserviceApplication.class, args);
	}

//    @Bean
	CommandLineRunner start(InfractionRepository infractionRepository){
		return args -> {
			infractionRepository.save(new Infraction(null,new Date(),1L,"1/ا/898657",290,120,400.5));

		};

	}
}


