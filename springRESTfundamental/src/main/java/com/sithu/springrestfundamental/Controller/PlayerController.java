package com.sithu.springrestfundamental.Controller;

import com.sithu.springrestfundamental.Entity.Player;
import com.sithu.springrestfundamental.Service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @GetMapping("/welcome")
    public String welcome(){
        return "Welcome to Spring REST Fundamental!";
    }

    @GetMapping("/players")
    public List<Player> getPlayers(){
        return playerService.getAllPlayers();
    }

    @GetMapping("/players/{id}")
    public Player getPlayerById(@PathVariable("id") int id){
        return playerService.getPlayerById(id);
    }

}
