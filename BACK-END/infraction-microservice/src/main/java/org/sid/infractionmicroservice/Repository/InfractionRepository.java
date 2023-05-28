package org.sid.infractionmicroservice.Repository;

import org.sid.infractionmicroservice.Entities.Infraction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface InfractionRepository extends JpaRepository<Infraction,Long> {
}
