package com.sithu.databaserelationship.controller;

import com.sithu.databaserelationship.onetomany.Registration;
import com.sithu.databaserelationship.onetoone.Player;
import com.sithu.databaserelationship.onetoone.PlayerProfile;
import com.sithu.databaserelationship.service.PlayerProfileServiceImpl;
import com.sithu.databaserelationship.service.PlayerService;
import com.sithu.databaserelationship.service.PlayerServiceImpl;
import com.sithu.databaserelationship.service.RegistrationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/players")
public class PlayerController {

    @Autowired
    PlayerServiceImpl service;

    @Autowired
    PlayerProfileServiceImpl profileService;

    @Autowired
    RegistrationServiceImpl registrationService;

    @GetMapping
    public List<Player> allPlayers() {
        return service.getAllPlayers();
    }

    @GetMapping("/{id}")
    public Player getPlayer(@PathVariable int id){
        return service.getPlayerById(id);
    }

    @PostMapping
    public Player addPlayer(@RequestBody Player player) {
        service.addPlayer(player);
        return player;
    }

    @PutMapping("/{id}")
    public Player updatePlayer(@RequestBody Player player, @PathVariable int id) {
        service.updatePlayer(player,id);
        return player;
    }

    @PutMapping("/{id}/profiles/{profile_id}")
    public Player updateProfile(@PathVariable int id, @PathVariable int profile_id) {
        PlayerProfile profile = profileService.getPlayerProfileById(profile_id);
        return service.assignProfile(id,profile);
    }
    @DeleteMapping("/{id}")
    public void deletePlayer(@PathVariable int id) {
        service.deletePlayer(id);
    }

    @PutMapping("/{id}/registrations/{reg_id}")
    public Player assignRegistration(@PathVariable int id,@PathVariable int reg_id){
        Registration registration = registrationService.getRegistrationById(reg_id);
        return service.assignRegistration(id,registration);
    }
}
