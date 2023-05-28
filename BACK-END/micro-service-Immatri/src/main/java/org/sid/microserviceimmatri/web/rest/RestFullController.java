package org.sid.microserviceimmatri.web.rest;

import org.sid.microserviceimmatri.Entities.Proprietaire;
import org.sid.microserviceimmatri.Entities.Vehicule;
import org.sid.microserviceimmatri.Repository.ProprietaryRepository;
import org.sid.microserviceimmatri.Repository.VehiculeRepository;

import org.sid.microserviceimmatri.Service.ServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping("/api")
@RestController

public class RestFullController {
    private ProprietaryRepository proprietaryRepository;

    private VehiculeRepository vehiculeRepository;
    private ServiceImpl service;

    public RestFullController(ProprietaryRepository proprietaryRepository, VehiculeRepository vehiculeRepository,ServiceImpl service) {
        this.proprietaryRepository = proprietaryRepository;
        this.vehiculeRepository = vehiculeRepository;
        this.service=service;
    }


    @GetMapping("/proprietaires")
    public List<Proprietaire> proprietariesList(){
        return proprietaryRepository.findAll();
    }
    @GetMapping("/proprietaires/{id}")
    public Proprietaire proprietaryById(@PathVariable Long id){
        Proprietaire proprietary = proprietaryRepository.findById(id).get();
        return proprietary;
    }
    @PostMapping("/proprietaires")
    public Proprietaire saveProprietary(@RequestBody Proprietaire proprietary){
        return proprietaryRepository.save(proprietary);
    }
    @PutMapping("/proprietaires/{id}")
    public Proprietaire updateProprietary(@RequestBody Proprietaire proprietary, @PathVariable Long id){
        proprietary.setId(id);
        return proprietaryRepository.save(proprietary);
    }
    @DeleteMapping("/proprietaires/{id}")
    public void deleteProprietary(@PathVariable Long id){
        proprietaryRepository.deleteById(id);
    }
    @GetMapping("/vehicles")
    public List<Vehicule> vehiclesList(){
        return vehiculeRepository.findAll();
    }
    @GetMapping("/vehicles/{id}")
    public Vehicule vehicleById(@PathVariable Long id){
        Vehicule vehicule = vehiculeRepository.findById(id).get();
        return vehicule;
    }
    @PostMapping("/vehicles")
    public Vehicule saveVehicle(@RequestBody Vehicule vehicule){
        return vehiculeRepository.save(vehicule);
    }
    @PutMapping("/vehicles/{id}")
    public Vehicule updateVehicle(@RequestBody Vehicule vehicule, @PathVariable Long id){
        vehicule.setId(id);
        return vehiculeRepository.save(vehicule);
    }
    @DeleteMapping("/vehicles/")
    public void deleteVehcicle(@PathVariable Long id){
        vehiculeRepository.deleteById(id);
    }

    @PostMapping("/full/{idV}/{idP}")
    public void addProToVeh(@PathVariable Long idV ,@PathVariable Long idP){
        service.addProprietaryToVehicule(idV, idP);
    }
}
