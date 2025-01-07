package com.sithu.springrestfundamental.Service;

import com.sithu.springrestfundamental.Entity.Player;
import com.sithu.springrestfundamental.Repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {

    @Autowired
    PlayerRepository playerRepository;

    public List<Player> getAllPlayers(){
        return playerRepository.findAll();
    }

    public Player getPlayerById(int id){
        return playerRepository.findById(id).get();
    }

    public void addPlayer(Player player){
        playerRepository.save(player);
    }

}
