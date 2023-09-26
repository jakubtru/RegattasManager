package com.sailing.regattas.Repositories;

import com.sailing.regattas.Entities.Team;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TeamsRepository extends JpaRepository<Team, Long> {
    List<Team> findByRegattaId(long regatteId);
}
