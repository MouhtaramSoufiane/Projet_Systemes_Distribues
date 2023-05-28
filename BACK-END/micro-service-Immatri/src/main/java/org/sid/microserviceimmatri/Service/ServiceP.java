package org.sid.microserviceimmatri.Service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@Service
public interface ServiceP {
    public void addProprietaryToVehicule(Long idV,Long idP);

}
