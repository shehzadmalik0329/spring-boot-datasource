package com.example.demo.team;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TeamRowMapper implements RowMapper<Team> {
    @Override
    public Team mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Team(
                rs.getInt("id"),
                rs.getString("name"),
                rs.getInt("ranking")
        );
    }
}
