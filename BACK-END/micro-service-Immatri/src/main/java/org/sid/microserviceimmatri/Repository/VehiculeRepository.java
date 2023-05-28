package org.sid.microserviceimmatri.Repository;

import org.sid.microserviceimmatri.Entities.Vehicule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface VehiculeRepository extends JpaRepository<Vehicule,Long> {
}
