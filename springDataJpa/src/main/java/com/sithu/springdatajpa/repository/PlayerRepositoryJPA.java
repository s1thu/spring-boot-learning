package com.sithu.springdatajpa.repository;

import com.sithu.springdatajpa.entities.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepositoryJPA extends JpaRepository<Player, Integer> {

}
