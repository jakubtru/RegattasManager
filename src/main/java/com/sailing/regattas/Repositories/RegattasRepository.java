package com.sailing.regattas.Repositories;

import com.sailing.regattas.Entities.Regatta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegattasRepository extends JpaRepository<Regatta, Long> {
}
