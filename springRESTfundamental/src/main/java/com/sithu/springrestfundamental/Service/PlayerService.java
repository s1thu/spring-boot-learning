package com.sithu.springrestfundamental.Service;

import com.sithu.springrestfundamental.Entity.Player;
import com.sithu.springrestfundamental.Repository.PlayerRepository;
import com.sithu.springrestfundamental.exception.PlayerNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
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

        if(player.isPresent())
            return player.get();
        else
            throw new PlayerNotFoundException("Player not found with id " + id);
    }

    public void addPlayer(Player player){
        playerRepository.save(player);
    }

    public Player updatePlayer(int id,Player player){
        Optional<Player> p1 = playerRepository.findById(id);
        Player p = null;
        if(p1.isPresent()){
            p = p1.get();
        }else{
            throw new PlayerNotFoundException("Player not found with id " + id);
        }

        p.setName(player.getName());
        p.setBirthDate(player.getBirthDate());
        p.setNationality(player.getNationality());
        p.setTitles(player.getTitles());
        logger.info("Player updated {}",p);
        addPlayer(p);
        return p;
    }

    public String deletePlayer(int id){
        Optional<Player> player = playerRepository.findById(id);
        if(player.isPresent()){
            playerRepository.delete(player.get());
            return "Player deleted";
        }else
            throw new PlayerNotFoundException("Player not found with id " + id);
    }

    public Player patchPlayer(int id,Map<String,Object> playerPatch){
        Optional<Player> player = playerRepository.findById(id);
        if (player.isPresent()){
            playerPatch.forEach((key, object) -> {
                Field field = ReflectionUtils.findField(Player.class,key);
                ReflectionUtils.makeAccessible(field);
                ReflectionUtils.setField(field,player.get(),object);
            });
        }
        playerRepository.save(player.get());
        return player.get();


    }
}
