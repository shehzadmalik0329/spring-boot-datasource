package com.example.demo.team;

import com.example.demo.exception.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeamService {
    private final TeamDAO teamDAO;

    public TeamService(TeamDAO teamDAO) {
        this.teamDAO = teamDAO;
    }

    public List<Team> getAllTeam() {
        return teamDAO.getAllTeam();
    }

    public Team getTeamById(Integer id) {
        return teamDAO.getTeamById(id)
                .orElseThrow(
                        () -> new NotFoundException(String.format("Team Not Found with id %d", id))
                );
    }

    public int createTeam(Team team) {
        return teamDAO.createTeam(team);
    }

    public int deleteTeamById(Integer id) {
        return teamDAO.deleteTeamById(id);
    }
}
