package com.sithu.databaserelationship.controller;

import com.sithu.databaserelationship.onetomany.Registration;
import com.sithu.databaserelationship.onetomany.Tournament;
import com.sithu.databaserelationship.service.RegistrationServiceImpl;
import com.sithu.databaserelationship.service.TournamentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tournaments")
public class TournamentController {
    @Autowired
    TournamentServiceImpl service;

    @Autowired
    RegistrationServiceImpl registrationService;

    @GetMapping
    public List<Tournament> allTournaments() {
        return service.allTournaments();
    }

    @GetMapping("/{id}")
    public Tournament getTournament(@PathVariable int id){
        return service.getTournament(id);
    }

    @PostMapping
    public Tournament addTournament(@RequestBody Tournament tournament) {
        return service.addTournament(tournament);
    }

    @DeleteMapping("/{id}")
    public void deleteTournament(@PathVariable int id) {
        service.deleteTournament(id);
    }

    @PutMapping("/{id}/registrations/{reg_id}")
    public Tournament addRegistrationToTournament(@PathVariable int id, @PathVariable int reg_id) {
        Registration registration = registrationService.getRegistrationById(reg_id);
        return service.addRegistration(id,registration);
    }

    @PutMapping("/{id}/remove_registrations/{reg_id}")
    public Tournament removeRegistrationFromTournament(@PathVariable int id, @PathVariable int reg_id) {
        Registration registration = registrationService.getRegistrationById(reg_id);
        return service.removeRegistration(id,registration);
    }
}
