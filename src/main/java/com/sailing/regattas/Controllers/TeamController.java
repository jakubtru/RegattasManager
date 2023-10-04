package com.sailing.regattas.Controllers;

import com.sailing.regattas.Entities.Team;
import com.sailing.regattas.Entities.User;
import com.sailing.regattas.Services.RegattasService;
import com.sailing.regattas.Services.TeamsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@RestController
@RequestMapping("/teams")
public class TeamController {
    TeamsService teamsService;
    RegattasService regattaService;

    @Autowired
    public TeamController(TeamsService teamsService) {
        this.teamsService = teamsService;
    }

    @Autowired
    public void setRegattaService(RegattasService regattaService) {
        this.regattaService = regattaService;
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

    @GetMapping("/regatta/{id}")
    public ResponseEntity<List<Team>> getTeamByRegatteId(@PathVariable("id") Long id) {
        List<Team> teams = teamsService.findTeamsByRegattaId(id);
        return new ResponseEntity<>(teams, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Team> addTeam(@RequestBody Team team, @RequestParam("regattaId") Long regattaId) {
        team.setRegatta(regattaService.findRegattaById(regattaId));
        team.setPoints(0);
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
