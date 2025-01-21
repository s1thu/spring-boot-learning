package com.sithu.databaserelationship.controller;

import com.sithu.databaserelationship.onetoone.PlayerProfile;
import com.sithu.databaserelationship.service.PlayerProfileService;
import com.sithu.databaserelationship.service.PlayerProfileServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/playerprofiles")
public class PlayerProfileController {

    @Autowired
    private PlayerProfileServiceImpl service;

    @GetMapping
    public List<PlayerProfile> allPlayerProfiles() {
        return service.getAllPlayerProfile();
    }

    @GetMapping("/{id}")
    public PlayerProfile getPlayerProfile(@PathVariable int id){
        return service.getPlayerProfileById(id);
    }

    @PostMapping
    public PlayerProfile addPlayerProfile(@RequestBody PlayerProfile playerProfile) {
        return service.savePlayerProfile(playerProfile);
    }

    @DeleteMapping("/{id}")
    public void deletePlayerProfile(@PathVariable int id) {
        service.deletePlayerProfile(id);
    }
}
