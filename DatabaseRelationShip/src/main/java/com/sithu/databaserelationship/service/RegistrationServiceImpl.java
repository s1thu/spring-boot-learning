package com.sithu.databaserelationship.service;

import com.sithu.databaserelationship.onetomany.Registration;
import com.sithu.databaserelationship.repository.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegistrationServiceImpl implements RegistrationService {

    @Autowired
    private RegistrationRepository repo;

    @Override
    public List<Registration> allRegistration() {
        return repo.findAll();
    }

    @Override
    public Registration getRegistrationById(int id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public Registration addRegistration(Registration registration) {
        return repo.save(registration);
    }

    @Override
    public void deleteRegistration(int id) {
        repo.deleteById(id);
    }
}
