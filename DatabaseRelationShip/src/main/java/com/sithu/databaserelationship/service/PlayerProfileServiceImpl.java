package com.sithu.databaserelationship.service;

import com.sithu.databaserelationship.exception.PlayerNotFoundException;
import com.sithu.databaserelationship.onetoone.PlayerProfile;
import com.sithu.databaserelationship.repository.PlayerProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlayerProfileServiceImpl implements PlayerProfileService{

    @Autowired
    private PlayerProfileRepository playerProfileRepository;

    @Override
    public List<PlayerProfile> getAllPlayerProfile() {
        return playerProfileRepository.findAll();
    }

    @Override
    public PlayerProfile getPlayerProfileById(int id) {
        Optional<PlayerProfile> playerProfile = playerProfileRepository.findById(id);
        if(playerProfile.isPresent()) {
            return playerProfile.get();
        }else
            throw new PlayerNotFoundException("PlayerProfile not found");

    }

    @Override
    public PlayerProfile savePlayerProfile(PlayerProfile playerProfile) {
        playerProfileRepository.save(playerProfile);
        return playerProfile;
    }

    @Override
    public PlayerProfile updatePlayerProfile(PlayerProfile playerProfile, int id) {
        Optional<PlayerProfile> playerProfile1 = playerProfileRepository.findById(id);
        if(playerProfile1.isPresent()) {
            playerProfile1.get().setTwitter(playerProfile.getTwitter());
            playerProfileRepository.save(playerProfile1.get());
        }else
            throw new PlayerNotFoundException("PlayerProfile not found");

        return playerProfile1.get();
    }

    @Override
    public void deletePlayerProfile(int id) {
        Optional<PlayerProfile> playerProfile1 = playerProfileRepository.findById(id);

        if(playerProfile1.isPresent()) {
            playerProfile1.get().getPlayer().setPlayerProfile(null);
            playerProfile1.get().setPlayer(null);
            playerProfileRepository.save(playerProfile1.get());
            playerProfileRepository.deleteById(id);
        }else
            throw new PlayerNotFoundException("PlayerProfile not found");
    }
}
