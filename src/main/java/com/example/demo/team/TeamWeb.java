package com.example.demo.team;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/teams/")
public class TeamWeb {
    private final TeamService teamService;

    public TeamWeb(TeamService teamService) {
        this.teamService = teamService;
    }

    @GetMapping
    public List<Team> getAllTeam() {
        return teamService.getAllTeam();
    }

    @GetMapping("{id}")
    public Team getTeamById(@PathVariable("id") Integer id) {
        return teamService.getTeamById(id);
    }

    @PostMapping
    public int createTeam(@RequestBody Team team) {
        return teamService.createTeam(team);
    }

    @DeleteMapping("{id}")
    public int deleteTeamById(@PathVariable("id") Integer id) {
        return teamService.deleteTeamById(id);
    }
}
