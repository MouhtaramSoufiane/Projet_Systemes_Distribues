package org.sid.microserviceimmatri.mappers;

import org.sid.microserviceimmatri.Entities.Proprietaire;
import org.sid.microserviceimmatri.dto.OwnerRequest;
import org.springframework.stereotype.Component;

@Component
public class OwnerMapper {
    public Proprietaire from(OwnerRequest ownerRequest){
        Proprietaire proprietaire=Proprietaire.builder()
                .nom(ownerRequest.getNom())
                .email(ownerRequest.getEmail())
                .build();
        return proprietaire;
    }
}
