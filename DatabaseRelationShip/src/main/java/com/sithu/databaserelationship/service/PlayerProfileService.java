package com.sithu.databaserelationship.service;

import com.sithu.databaserelationship.onetoone.PlayerProfile;

import java.util.List;

public interface PlayerProfileService {
    public List<PlayerProfile> getAllPlayerProfile();
    public PlayerProfile getPlayerProfileById(int id);
    public PlayerProfile savePlayerProfile(PlayerProfile playerProfile);
    public PlayerProfile updatePlayerProfile(PlayerProfile playerProfile,int id);
    public void deletePlayerProfile(int id);
}
