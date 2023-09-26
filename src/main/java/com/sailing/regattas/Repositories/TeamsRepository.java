package com.sailing.regattas.Repositories;

import com.sailing.regattas.Entities.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamsRepository extends JpaRepository<Team, Long> {
}
