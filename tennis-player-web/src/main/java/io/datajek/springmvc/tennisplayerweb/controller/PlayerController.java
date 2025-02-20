package io.datajek.springmvc.tennisplayerweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PlayerController {

    @RequestMapping("/")
    public String welcome() {
        return "welcome";
    }

    @RequestMapping("/searchPlayerform")
    public String searchPlayerForm() {
        return "searchPlayer";
    }

    @RequestMapping("/welcome")
    public String welcome2() {
        return "welcome";
    }

    @RequestMapping("/playerDetail")
    public String playerDetail(@RequestParam("playerName")String playerName, Model model) {
        System.out.println(playerName);
        model.addAttribute("playerName", playerName);
        return "playerDetail";
    }
}
