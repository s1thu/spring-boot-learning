package com.sithu.databaserelationship.repository;

import com.sithu.databaserelationship.onetomany.Tournament;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TournamentRepository extends JpaRepository<Tournament,Integer> {
}
