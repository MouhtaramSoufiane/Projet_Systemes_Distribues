package org.sid.microserviceimmatri.Entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.*;

import jakarta.persistence.Entity;


@Entity
@Builder
@Data @NoArgsConstructor @AllArgsConstructor @ToString

public class Vehicule{
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String num_matricule;
    private String marque;
    private String puissance;
    private String modele;
    private double vitesse;
    @ManyToOne
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Proprietaire proprietary;

}
