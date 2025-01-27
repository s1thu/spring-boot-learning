package com.sithu.databaserelationship.service;

import com.sithu.databaserelationship.onetomany.Registration;
import com.sithu.databaserelationship.onetomany.Tournament;
import com.sithu.databaserelationship.repository.RegistrationRepository;
import com.sithu.databaserelationship.repository.TournamentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TournamentServiceImpl implements TournamentService{

    @Autowired
    private TournamentRepository repo;

    @Override
    public List<Tournament> allTournaments() {
        return repo.findAll();
    }

    @Override
    public Tournament getTournament(int id) {
        return repo.findById(id).get();
    }

    @Override
    public Tournament addTournament(Tournament tournament) {
        tournament.setId(0);
        return repo.save(tournament);
    }

    @Override
    public void deleteTournament(int id) {
        repo.deleteById(id);
    }

    @Override
    public Tournament addRegistration(int id, Registration registration) {
        Tournament tournament = repo.findById(id).get();
        if(tournament != null) {
            tournament.addRegistration(registration);
        }
        return repo.save(tournament);
    }

    @Override
    public Tournament removeRegistration(int id, Registration registration) {
        Tournament tournament = repo.findById(id).get();
        if(tournament != null) {
            tournament.removeRegistration(registration);
        }
        return repo.save(tournament);
    }
}
