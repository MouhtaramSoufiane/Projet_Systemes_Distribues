package org.sid.infractionmicroservice.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.util.Date;

@Entity @Data
@AllArgsConstructor @NoArgsConstructor @ToString @Builder
public class Infraction {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date date;
    private Long numero_radar;
   private String matricule_v;
   private double vitesse;
   private double vitesse_maximale;
   private double montant;
}
