package com.example.demo.player;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/players")
public class PlayerWeb {

    private final PlayerService playerService;

    public PlayerWeb(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping("/")
    public List<Player> getAllPlayer() {
        return playerService.getAllPlayer();
    }

    @GetMapping("{id}")
    public Player getPlayerById(@PathVariable("id") Integer id) {
        return playerService.getPlayerById(id);
    }

    @PostMapping
    public int createPlayer(@RequestBody Player player) {
        return playerService.createPlayer(player);
    }

    @DeleteMapping("{id}")
    public int deletePlayerById(@PathVariable("id") Integer id) {
        return playerService.deletePlayerById(id);
    }

}
