package com.example.demo.controllers;

import com.example.demo.entities.ServiceEntity;
import com.example.demo.repositorues.ServiceRepository;
import com.example.demo.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class ServiceController {
    @Autowired
    ServiceRepository serviceRepository;

    @Autowired
    DateUtils dateUtils;

    ServiceEntity serviceEntity;

    @GetMapping("/getextid")
    public ResponseEntity<ServiceEntity> getAllTutorials(@RequestParam(required = true) Integer customerId) {
        try {
            Optional<ServiceEntity> serviceEntity = serviceRepository.findById(customerId);

            if (serviceEntity.isEmpty()) {
                return new ResponseEntity(serviceEntity, HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity(serviceEntity, HttpStatus.OK);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public ResponseEntity<ServiceEntity> createTutorial(@RequestBody ServiceEntity inServiceParams) {
        try {

            if (dateUtils.isFutureDate(inServiceParams.getCreatedAt())) {
                return new ResponseEntity<>(null, HttpStatus.NOT_ACCEPTABLE);
            }

            ServiceEntity svcEntity = serviceRepository.save(
                    new ServiceEntity(inServiceParams.getCustomerId(),
                                      UUID.randomUUID().toString(),
                                      inServiceParams.getCreatedAt()));

            return new ResponseEntity<>(svcEntity, HttpStatus.CREATED);
        } catch (Exception E) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }


    }
}

