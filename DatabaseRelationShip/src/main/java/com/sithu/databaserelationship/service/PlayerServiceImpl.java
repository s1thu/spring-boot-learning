package com.sithu.databaserelationship.service;

import com.sithu.databaserelationship.exception.PlayerNotFoundException;
import com.sithu.databaserelationship.onetomany.Registration;
import com.sithu.databaserelationship.onetoone.Player;
import com.sithu.databaserelationship.onetoone.PlayerProfile;
import com.sithu.databaserelationship.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlayerServiceImpl implements PlayerService{

    @Autowired
    private PlayerRepository playerRepository;

    @Override
    public List<Player> getAllPlayers() {
       return  playerRepository.findAll();
    }

    @Override
    public Player getPlayerById(Integer playerId) {
        Optional<Player> player = playerRepository.findById(playerId);
        if (player.isPresent()){
            return player.get();
        }else
            throw new PlayerNotFoundException("Player not found");
    }

    @Override
    public void addPlayer(Player player) {
       playerRepository.save(player);
    }

    @Override
    public void updatePlayer(Player player,int playerId) {
       Optional<Player> player1 = playerRepository.findById(playerId);

       if(player1.isPresent()) {
           player1.get().setName(player.getName());
       }else
           throw new PlayerNotFoundException("Player not found with id "+ playerId);

    }

    @Override
    public void deletePlayer(int playerId) {
        Optional<Player> player = playerRepository.findById(playerId);

        if(player.isPresent()) {
            playerRepository.deleteById(playerId);
        }else
            throw new PlayerNotFoundException("Player not found with id "+ playerId);
    }

    @Override
    public Player assignProfile(int id, PlayerProfile playerProfile) {
        Player player = playerRepository.findById(id).get();
        player.setPlayerProfile(playerProfile);
        playerRepository.save(player);
        return player;
    }

    @Override
    public Player assignRegistration(int id, Registration registration) {
        Player player = playerRepository.findById(id).get();
        player.registerPlayer(registration);
        return playerRepository.save(player);
    }
}
