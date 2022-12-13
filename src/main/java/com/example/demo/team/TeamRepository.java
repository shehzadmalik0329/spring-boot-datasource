package com.example.demo.team;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public class TeamRepository implements TeamDAO{
    private final JdbcTemplate jdbcTemplate;

    public TeamRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Team> getAllTeam() {
        var sql = """
                SELECT * FROM team;
                """;
        return jdbcTemplate.query(sql, new TeamRowMapper());
    }

    @Override
    public Optional<Team> getTeamById(Integer id) {
        var sql = """
                SELECT * FROM team WHERE id = ?;
                """;
        return jdbcTemplate.query(sql, new TeamRowMapper(), id).stream().findFirst();
    }

    @Override
    public int createTeam(Team team) {
        var sql = """
                INSERT INTO team(name, ranking) 
                VALUES(?, ?);
                """;
        return jdbcTemplate.update(sql, team.name(), team.ranking());
    }

    @Override
    public int deleteTeamById(Integer id) {
        var sql = """
                DELETE FROM team WHERE id = ?;
                """;
        return jdbcTemplate.update(sql, id);
    }
}
