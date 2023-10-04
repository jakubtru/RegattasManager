package com.sailing.regattas.Services;

import com.sailing.regattas.Entities.Team;
import com.sailing.regattas.Repositories.TeamsRepository;
import com.sailing.regattas.Repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Service
public class TeamsService {
    TeamsRepository teamsRepository;
    RegattasService regattasRepository;

    @Autowired
    public TeamsService(TeamsRepository teamsRepository) {
        this.teamsRepository = teamsRepository;
    }

    @Autowired
    public void setRegattasRepository(RegattasService regattasRepository) {
        this.regattasRepository = regattasRepository;
    }

    public List<Team> getTeams() {
        return teamsRepository.findAll();
    }

    public Team createTeam(Team team) {
        //team.setRegatta(regattasRepository.findRegattaById(team.getRegatta().getId()));
        return teamsRepository.save(team);
    }

    public Team findTeamById(Long id) {
        return teamsRepository.findById(id).orElseThrow(() -> new RuntimeException("Team with id " + id + " was not found"));
    }

    public List<Team> findTeamsByRegattaId(Long regatteId) {
        return teamsRepository.findByRegattaId(regatteId);
    }

    public void deleteTeam(Long id) {
        teamsRepository.deleteById(id);
    }

    public Team updateTeam(Team team) {

        //team.setRegatta(regattasRepository.findRegattaById(team.getRegatta().getId()));
        return teamsRepository.save(team);
    }
}
