package com.sithu.springrestfundamental.Service;

import com.sithu.springrestfundamental.Entity.Player;
import com.sithu.springrestfundamental.Repository.PlayerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@Service
public class PlayerService {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    PlayerRepository playerRepository;

    public List<Player> getAllPlayers(){
        return playerRepository.findAll();
    }

    public Player getPlayerById(int id){
        Optional<Player> player = playerRepository.findById(id);

        if(!player.isEmpty())
            return player.get();

        return null;
    }

    public void addPlayer(Player player){
        playerRepository.save(player);
    }

    public Player updatePlayer(int id,Player player){
        Player p = getPlayerById(id);
        p.setName(player.getName());
        p.setBirthDate(player.getBirthDate());
        p.setNationality(player.getNationality());
        p.setTitles(player.getTitles());
        logger.info("Player updated {}",p);
        addPlayer(p);
        return p;
    }

    public String deletePlayer(int id){
        try {
            playerRepository.deleteById(id);
        } catch(Exception e) {
            return "Player with id " + id + "not found";
        }

        return "Deleted player with id: " + id;
    }
}
