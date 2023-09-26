package com.sailing.regattas.Controllers;

import com.sailing.regattas.Entities.Team;
import com.sailing.regattas.Entities.User;
import com.sailing.regattas.Services.TeamsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/teams")
public class TeamController {
    TeamsService teamsService;

    @Autowired
    public TeamController(TeamsService teamsService) {
        this.teamsService = teamsService;
    }

    @GetMapping
    public ResponseEntity<List<Team>> getAllTeams() {
        List<Team> teams = teamsService.getTeams();
        return new ResponseEntity<>(teams, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Team> getTeamById(@PathVariable("id") Long id) {
        Team team = teamsService.findTeamById(id);
        return new ResponseEntity<>(team, HttpStatus.OK);
    }

    @GetMapping("/regatte/{id}")
    public ResponseEntity<List<Team>> getTeamByRegatteId(@PathVariable("id") Long id) {
        List<Team> teams = teamsService.findTeamsByRegattaId(id);
        return new ResponseEntity<>(teams, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Team> addTeam(@RequestBody Team team) {
        Team newTeam = teamsService.createTeam(team);
        return new ResponseEntity<>(newTeam, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Team> updateTeam(@RequestBody Team team) {
        Team updatedTeam = teamsService.updateTeam(team);
        return new ResponseEntity<>(updatedTeam, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTeam(@PathVariable("id") Long id) {
        teamsService.deleteTeam(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
