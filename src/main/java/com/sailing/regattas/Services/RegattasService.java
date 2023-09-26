package com.sailing.regattas.Services;

import com.sailing.regattas.Entities.Regatta;
import com.sailing.regattas.Repositories.RegattasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegattasService {
    RegattasRepository regattasRepository;

    @Autowired
    public RegattasService(RegattasRepository regattasRepository) {
        this.regattasRepository = regattasRepository;
    }

    public void deleteRegatta(Long id) {
        regattasRepository.deleteById(id);
    }

    public Regatta createRegatta(Regatta regatta) {
        return regattasRepository.save(regatta);
    }

    public Regatta findRegattaById(Long id) {
        return regattasRepository.findById(id).orElseThrow(() -> new RuntimeException("Regatta with id " + id + " was not found"));
    }


    public List<Regatta> getRegattas() {
        return regattasRepository.findAll();
    }
}
