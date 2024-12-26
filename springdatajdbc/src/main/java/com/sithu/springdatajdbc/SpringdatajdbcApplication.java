package com.sithu.springdatajdbc;

import com.sithu.springdatajdbc.lesson.dao.PlayerDao;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringdatajdbcApplication implements CommandLineRunner {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    PlayerDao dao;

    public static void main(String[] args) {
        SpringApplication.run(SpringdatajdbcApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        logger.info("All players data: {}",dao.getAllPlayers());
    }
}
