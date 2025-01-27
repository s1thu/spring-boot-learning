package com.sithu.databaserelationship.service;

import com.sithu.databaserelationship.onetomany.Registration;

import java.util.List;

public interface RegistrationService {
    public List<Registration> allRegistration();
    public Registration getRegistrationById(int id);
    public Registration addRegistration(Registration registration);
    public void deleteRegistration(int id);
}
