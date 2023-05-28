package org.sid.microserviceimmatri.Entities;

import jakarta.persistence.*;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlTransient;
import lombok.*;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

@Entity
@Builder
@Data @NoArgsConstructor @AllArgsConstructor @ToString
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Proprietaire {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private Date date_naissance;
    private String email;
    @OneToMany(mappedBy = "proprietary",fetch = FetchType.LAZY)
    @XmlTransient
    private Collection<Vehicule> vehicules;

}
