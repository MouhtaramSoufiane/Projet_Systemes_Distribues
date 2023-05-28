package org.sid.microserviceimmatri.Service;


import org.sid.microserviceimmatri.Entities.Proprietaire;
import org.sid.microserviceimmatri.Entities.Vehicule;
import org.sid.microserviceimmatri.Repository.ProprietaryRepository;
import org.sid.microserviceimmatri.Repository.VehiculeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
@Service
public class ServiceImpl implements ServiceP {
    @Autowired
    private VehiculeRepository vehiculeRepository;
    @Autowired
    private ProprietaryRepository proprietaryRepository;
    @Override
    public void addProprietaryToVehicule(Long idV, Long idP) {
        Vehicule vehicule = vehiculeRepository.findById(idV).orElse(null);
        Proprietaire proprietaire = proprietaryRepository.findById(idP).orElse(null);
        vehicule.setProprietary(proprietaire);
        vehiculeRepository.save(vehicule);




    }
}
