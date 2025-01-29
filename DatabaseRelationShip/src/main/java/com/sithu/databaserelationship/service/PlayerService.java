package com.sithu.databaserelationship.service;

import com.sithu.databaserelationship.onetomany.Registration;
import com.sithu.databaserelationship.onetoone.Player;
import com.sithu.databaserelationship.onetoone.PlayerProfile;

import java.util.List;

public interface PlayerService {
    public List<Player> getAllPlayers();
    public Player getPlayerById(Integer playerId);
    public void addPlayer(Player player);
    public void updatePlayer(Player player,int playerId);
    public void deletePlayer(int playerId);
    public Player assignProfile(int id, PlayerProfile playerProfile);
    public Player assignRegistration(int id, Registration registration);
}
