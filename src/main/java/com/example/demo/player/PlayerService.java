package com.example.demo.player;

import com.example.demo.exception.NotFoundException;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlayerService {
    private final PlayerDAO playerDAO;

    public PlayerService(PlayerDAO playerDAO) {
        this.playerDAO = playerDAO;
    }

    public List<Player> getAllPlayer(){
        return playerDAO.getAll();
    }

    public Player getPlayerById(Integer id) {
        return playerDAO.getPlayerById(id)
                .orElseThrow(() -> new NotFoundException(String.format("Player with id %d not found", id)));
    }

    public int createPlayer(Player player) {
        return playerDAO.createPlayer(player);
    }

    public int deletePlayerById(Integer id) {
        Optional<Player> player = playerDAO.getPlayerById(id);
        player.ifPresentOrElse(deletePlayer -> {
            int result = playerDAO.deletePlayerById(id);
                    if(result != 1) {
                        throw new IllegalStateException("OOPS could not delete player");
                    }
                }, () -> new NotFoundException(String.format("Player Not Found with id %d", id))
        );
        return playerDAO.deletePlayerById(id);
    }
}
