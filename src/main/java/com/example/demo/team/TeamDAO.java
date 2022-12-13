package com.example.demo.team;

import java.util.List;
import java.util.Optional;

public interface TeamDAO {
    List<Team> getAllTeam();
    Optional<Team> getTeamById(Integer id);
    int createTeam(Team team);
    int deleteTeamById(Integer id);
}
