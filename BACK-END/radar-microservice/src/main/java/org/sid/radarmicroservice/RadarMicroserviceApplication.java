package org.sid.radarmicroservice;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.sid.radarmicroservice.Entities.Radar;
import org.sid.radarmicroservice.Repository.RadarRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Date;


@SpringBootApplication
@EnableFeignClients
public class RadarMicroserviceApplication {


	public static void main(String[] args) {
		SpringApplication.run(RadarMicroserviceApplication.class, args);
	}

	@Bean
	CommandLineRunner start(InfractionnServiceClient infractionnServiceClient,RadarRepository radarRepository,MatriculationServiceClient matriculationServiceClient){
		return args -> {
			Radar radar = radarRepository.save(new Radar(null, 120L, Math.random() * 100, Math.random() * 100));
//			Radar radar1 = radarRepository.save(new Radar(null, 123L, Math.random() * 100, Math.random() * 100));

			PagedModel<Vehicule> allVehicles = matriculationServiceClient.findAllVehicles();
			allVehicles.forEach(vehicule -> {
				if(vehicule.vitesse> radar.getVitesse_maximale()){
					Proprietaire proprietaire = matriculationServiceClient.findProprietaire(vehicule.id);
					System.out.println(proprietaire.nom);
					infractionnServiceClient.saveInfraction(new Infraction(null,new Date(),radar.getId(),vehicule.num_matricule,vehicule.vitesse,radar.getVitesse_maximale(),500.5));


				}
			});

		};
}

@FeignClient(name = "MATRICULATION-SERVICE")
interface MatriculationServiceClient{

	 @GetMapping("/proprietaires/{id}")
	 Proprietaire findProprietaryById(@PathVariable(name = "id") Long id);

	@GetMapping("/proprietaires/{id}/vehicules")
	PagedModel<Vehicule> findVehiclesOfProprietary(@PathVariable(name = "id") Long id);

	@GetMapping("/vehicules")
	PagedModel<Vehicule> findAllVehicles();

	@GetMapping("/vehicules/{id}")
	Vehicule findVehicleById(@PathVariable(name = "id") Long id);
	@GetMapping("/vehicules/{id}/proprietary")
	Proprietaire findProprietaire(@PathVariable(name = "id") Long id);
}


@FeignClient(name = "INFRACTION-SERVICE")
interface InfractionnServiceClient{
		@PostMapping("/infractions")
		Infraction saveInfraction(@RequestBody Infraction infraction);
}

@Data
static class Proprietaire{
	private Long id;
	private String nom;
	private Date date_naissance;
	private String email;
	private PagedModel<Vehicule> vehicules;


}
@Data @AllArgsConstructor
static class Vehicule{
	private Long id;
	private String num_matricule;
	private String marque;
	private String puissance;
	private String modele;
	private double vitesse;
	private Proprietaire proprietary;


}
@Data @AllArgsConstructor
static class Infraction{
	private Long id;
	private Date date;
	private Long numero_radar;
	private String matricule_v;
	private double vitesse;
	private double vitesse_maximale;
	private double montant;
}
}