package org.sid.microserviceimmatri;


import org.sid.microserviceimmatri.Entities.Proprietaire;
import org.sid.microserviceimmatri.Entities.Vehicule;
import org.sid.microserviceimmatri.Repository.ProprietaryRepository;
import org.sid.microserviceimmatri.Repository.VehiculeRepository;
import org.sid.microserviceimmatri.web.soap.OwnerSoapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;


import java.util.Date;

@SpringBootApplication
public class MicroServiceImmatriApplication {

    public MicroServiceImmatriApplication(ProprietaryRepository proprietaryRepository, VehiculeRepository vehiculeRepository, RepositoryRestConfiguration repositoryRestConfiguration) {
        this.proprietaryRepository = proprietaryRepository;
        this.vehiculeRepository = vehiculeRepository;
        this.repositoryRestConfiguration = repositoryRestConfiguration;
    }

    private ProprietaryRepository proprietaryRepository;
   private VehiculeRepository vehiculeRepository;
   private RepositoryRestConfiguration repositoryRestConfiguration;
   @Autowired
   private OwnerSoapService wsSoap;

    public static void main(String[] args) {
        SpringApplication.run(MicroServiceImmatriApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(){
        return args -> {
            repositoryRestConfiguration.exposeIdsFor(Vehicule.class);
                repositoryRestConfiguration.exposeIdsFor(Proprietaire.class);

         proprietaryRepository.save(new Proprietaire(null,"soufiane",new Date(),"soufiane@gmail.com",null));
         proprietaryRepository.save(new Proprietaire(null,"mehdi",new Date(),"mehdi@gmail.com",null));

         vehiculeRepository.save(new Vehicule(null,"10/ب/898657","BMW","82CH","2017",130,proprietaryRepository.findById(1L).get()));
         vehiculeRepository.save(new Vehicule(null,"15/و/127643","RANGE_ROVER","72CH","2019",90,proprietaryRepository.findById(2L).get()));
         vehiculeRepository.save(new Vehicule(null,"ش/797479","CADI","92CH","2022",70,proprietaryRepository.findById(1L).get()));




        };
    }

}
