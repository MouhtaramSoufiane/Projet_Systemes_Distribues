package org.sid.microserviceimmatri.web.soap;


import org.sid.microserviceimmatri.Entities.Proprietaire;
import org.sid.microserviceimmatri.Repository.ProprietaryRepository;
import org.sid.microserviceimmatri.dto.OwnerRequest;
import org.sid.microserviceimmatri.mappers.OwnerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import jakarta.jws.*;


import java.util.List;

@Component
@WebService(serviceName = "OwnerWS")
public class OwnerSoapService {
    @Autowired
    private ProprietaryRepository proprietaryRepository;
    @Autowired
    private OwnerMapper ownerMapper;



    @WebMethod
    public Proprietaire ownerById(@WebParam(name = "id") Long id) {
        return proprietaryRepository.findById(id).orElse(null);

    }

    @WebMethod
    public List<Proprietaire> owners() {
        return proprietaryRepository.findAll();
    }

    @WebMethod
    public Proprietaire SaveOwner(@WebParam(name = "owner") OwnerRequest ownerRequest) {
        Proprietaire proprietaire=ownerMapper.from(ownerRequest);
        return proprietaryRepository.save(proprietaire);
    }


}