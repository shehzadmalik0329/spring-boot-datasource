package com.example.demo.player;

import com.example.demo.exception.NotFoundException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PlayerRepository implements PlayerDAO{

    private final JdbcTemplate jdbcTemplate;

    public PlayerRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Player> getAll() {
        var sql = """
                SELECT * FROM player;
                """;
        return jdbcTemplate.query(sql, new PlayerRowMapper());
    }

    @Override
    public Optional<Player> getPlayerById(Integer id) {
        var sql = """
                SELECT * FROM player WHERE id = ?;
                """;
        return jdbcTemplate.query(sql, new PlayerRowMapper(), id).stream().findFirst();
    }

    @Override
    public int createPlayer(Player player) {
        var sql = """
                INSERT INTO player(name, team, ranking, age)
                VALUES(?, ?, ?, ?);
                """;
        return jdbcTemplate.update(sql, player.name(), player.team(), player.ranking(), player.age());
    }

    @Override
    public int deletePlayerById(Integer id) {
        var sql = """
                DELETE FROM player WHERE id = ?
                """;
        return jdbcTemplate.update(sql, id);
    }
}
