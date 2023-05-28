package org.sid.microserviceimmatri.Repository;

import org.sid.microserviceimmatri.Entities.Proprietaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ProprietaryRepository extends JpaRepository<Proprietaire,Long> {

}
