package com.sithu.databaserelationship.service;

import com.sithu.databaserelationship.onetomany.Registration;
import com.sithu.databaserelationship.onetomany.Tournament;

import java.util.List;

public interface TournamentService {
    public List<Tournament> allTournaments();
    public Tournament getTournament(int id);
    public Tournament addTournament(Tournament tournament);
    public void deleteTournament(int id);
    public Tournament addRegistration(int id, Registration registration);
    public Tournament removeRegistration(int id, Registration registration);
}
