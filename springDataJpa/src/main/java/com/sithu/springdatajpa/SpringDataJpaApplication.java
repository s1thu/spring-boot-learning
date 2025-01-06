package com.sithu.springdatajpa;

import com.sithu.springdatajpa.entities.Player;
import com.sithu.springdatajpa.repository.PlayerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootApplication
public class SpringDataJpaApplication implements CommandLineRunner {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    PlayerRepository playerRepository;

    public static void main(String[] args) {
        SpringApplication.run(SpringDataJpaApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = sdf.parse("2001-05-06");
        logger.info("Inserting Player: {}",playerRepository.insertPlayer(
                new Player("Sithu","MYN",date,100)
        ));
        logger.info("Inserting Player: {}",playerRepository.insertPlayer(
                new Player("Win","THA",date,100)
        ));
        logger.info("List of Players : {}", playerRepository.getAllPlayers());
        logger.info("Finding Player By Id 1: {}",playerRepository.getPlayerById(1));

        logger.info("Updating Player Id 2: {}",playerRepository.updatePlayer(
                new Player(2,"Jack","MYN",date,100)
        ));
        playerRepository.deletePlayerById(2);

    }
}
