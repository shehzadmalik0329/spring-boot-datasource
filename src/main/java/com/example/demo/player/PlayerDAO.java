package com.example.demo.player;

import java.util.List;
import java.util.Optional;

public interface PlayerDAO {
    List<Player> getAll();
    Optional<Player> getPlayerById(Integer id);
    int createPlayer(Player player);
    int deletePlayerById(Integer id);
}
