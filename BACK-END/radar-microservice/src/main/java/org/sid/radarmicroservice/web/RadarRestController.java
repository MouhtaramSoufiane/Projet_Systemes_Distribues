package org.sid.radarmicroservice.web;


import org.sid.radarmicroservice.Entities.Radar;
import org.sid.radarmicroservice.Repository.RadarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RadarRestController {
    @Autowired
    private RadarRepository radarRepository;

    @GetMapping("/radars")
    public List<Radar> radares(){
        return radarRepository.findAll();
    }
    @GetMapping("/radars/{id}")
    public Radar radarById(@PathVariable(name = "id") Long id){
        return radarRepository.findById(id).get();
    }



}
