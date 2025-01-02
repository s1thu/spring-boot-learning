package com.sithu.springdatajdbc;

import com.sithu.springdatajdbc.lesson.bean.Player;
import com.sithu.springdatajdbc.lesson.dao.PlayerDao;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.SimpleDateFormat;
import java.util.Date;

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
        logger.info("Get Player from where id = 1 : {}", dao.getPlayerId(1));
        logger.info("Insert Into Player 4: {}",dao.insertPlayer(
                new Player(4,"Sithu","Myanmar",new Date(System.currentTimeMillis()),17)
        ));

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = dateFormat.parse("2001-06-05");

        logger.info("Update Player Sithu to Sithu Win : {}",dao.updatePlayer(
                new Player(4,"SithuWin","Myanmar", date,17)
        ));
        logger.info("All players data: {}",dao.getAllPlayers());
        logger.info("Delete Player id : 4 {}", dao.deletePlayer(1));
    }


}
