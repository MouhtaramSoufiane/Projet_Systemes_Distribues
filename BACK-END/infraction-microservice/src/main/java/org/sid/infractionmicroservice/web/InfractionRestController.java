package org.sid.infractionmicroservice.web;

import org.sid.infractionmicroservice.Entities.Infraction;
import org.sid.infractionmicroservice.Repository.InfractionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class InfractionRestController {
    @Autowired
    private InfractionRepository infractionRepository;
    @GetMapping("/infractions")
    public List<Infraction> infractions(){
        return infractionRepository.findAll();
    }
    @GetMapping("/infractions/{id}")
    public Infraction infractionById(@PathVariable("id") Long id){
        return infractionRepository.findById(id).get();
    }
    @PostMapping("/infractions")
    public Infraction addInfraction(@RequestBody Infraction infraction){
        return infractionRepository.save(infraction);
    }
}
