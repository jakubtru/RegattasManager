package com.sailing.regattas.Controllers;

import com.sailing.regattas.Controllers.TeamController;
import com.sailing.regattas.Entities.Regatta;
import com.sailing.regattas.Entities.Team;
import com.sailing.regattas.Services.RegattasService;
import com.sailing.regattas.Services.TeamsService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class TeamControllerTest {

    @InjectMocks
    private TeamController teamController;

    @Mock
    private TeamsService teamsService;

    @Mock
    private RegattasService regattasService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetAllTeams() {
        List<Team> teams = new ArrayList<>();
        when(teamsService.getTeams()).thenReturn(teams);

        ResponseEntity<List<Team>> response = teamController.getAllTeams();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(teams, response.getBody());
    }

    @Test
    public void testGetTeamById() {
        Long teamId = 1L;
        Team team = new Team();
        when(teamsService.findTeamById(teamId)).thenReturn(team);

        ResponseEntity<Team> response = teamController.getTeamById(teamId);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(team, response.getBody());
    }

    @Test
    public void testGetTeamByRegatteId() {
        Long regattaId = 1L;
        List<Team> teams = new ArrayList<>();
        when(teamsService.findTeamsByRegattaId(regattaId)).thenReturn(teams);

        ResponseEntity<List<Team>> response = teamController.getTeamByRegatteId(regattaId);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(teams, response.getBody());
    }

    @Test
    public void testUpdateTeam() {
        Team team = new Team();
        when(teamsService.updateTeam(team)).thenReturn(team);

        ResponseEntity<Team> response = teamController.updateTeam(team);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(team, response.getBody());
    }

    @Test
    public void testDeleteTeam() {
        Long teamId = 1L;
        ResponseEntity<?> response = teamController.deleteTeam(teamId);

        verify(teamsService, times(1)).deleteTeam(teamId);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }
}
