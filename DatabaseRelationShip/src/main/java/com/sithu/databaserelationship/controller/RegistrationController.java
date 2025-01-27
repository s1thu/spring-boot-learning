package com.sithu.databaserelationship.controller;

import com.sithu.databaserelationship.onetomany.Registration;
import com.sithu.databaserelationship.service.RegistrationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/registrations")
public class RegistrationController {

    @Autowired
    RegistrationServiceImpl service;

    @GetMapping
    public List<Registration> allRegistrations() {
        return service.allRegistration();
    }

    @GetMapping("/{id}")
    public Registration getRegistration(@PathVariable int id){
        return service.getRegistrationById(id);
    }

    @PostMapping
    public Registration addRegistration(@RequestBody Registration registration) {
        return service.addRegistration(registration);
    }

    @DeleteMapping("/{id}")
    public void deleteRegistration(@PathVariable int id) {
        service.deleteRegistration(id);
    }
}