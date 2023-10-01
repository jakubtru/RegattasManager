package com.sailing.regattas.Repositories;

import com.sailing.regattas.Entities.Regatta;
import com.sailing.regattas.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RegattasRepository extends JpaRepository<Regatta, Long> {
    List<Regatta> findRegattasByUser(User user);

}
