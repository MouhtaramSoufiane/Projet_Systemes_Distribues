package org.sid.microserviceimmatri.web.graphQl;


import lombok.AllArgsConstructor;
import org.sid.microserviceimmatri.Entities.Proprietaire;
import org.sid.microserviceimmatri.Repository.ProprietaryRepository;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller @AllArgsConstructor

public class graphqlController {
    private ProprietaryRepository proprietaryRepository;


    @QueryMapping
    public List<Proprietaire> proprietaireList(){

        return proprietaryRepository.findAll();
    }
}
