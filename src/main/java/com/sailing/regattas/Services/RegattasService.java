package com.sailing.regattas.Services;

import com.sailing.regattas.Entities.Regatta;
import com.sailing.regattas.Entities.User;
import com.sailing.regattas.Repositories.RegattasRepository;
import com.sailing.regattas.Repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RegattasService {
    RegattasRepository regattasRepository;
    UsersRepository usersRepository;

    @Autowired
    public RegattasService(RegattasRepository regattasRepository, UsersRepository usersRepository) {
        this.regattasRepository = regattasRepository;
        this.usersRepository = usersRepository;
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

    public List<Regatta> findRegattasByUserId(Long id) {
        Optional<User> user = usersRepository.findById(id);
        return user.map(value -> regattasRepository.findRegattasByUser(value)).orElse(null);
    }
}


