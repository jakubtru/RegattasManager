package com.sailing.regattas.Controllers;

import com.sailing.regattas.Entities.Regatta;
import com.sailing.regattas.Entities.User;
import com.sailing.regattas.Services.RegattasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/regattas")
public class RegattaController {
    RegattasService regattasService;

    @Autowired
    public RegattaController(RegattasService regattasService) {
        this.regattasService = regattasService;
    }

    @GetMapping
    public ResponseEntity<List<Regatta>> getAllRegattas() {
        List<Regatta> regattas = regattasService.getRegattas();
        return new ResponseEntity<>(regattas, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Regatta> getRegattaById(@PathVariable("id") Long id) {
        Regatta regatta = regattasService.findRegattaById(id);
        return new ResponseEntity<>(regatta, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Regatta> addRegatta(@RequestBody Regatta regatta) {
        Regatta newRegatta = regattasService.createRegatta(regatta);
        return new ResponseEntity<>(newRegatta, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Regatta> updateRegatta(@RequestBody Regatta regatta) {
        Regatta updateRegatta = regattasService.createRegatta(regatta);
        return new ResponseEntity<>(updateRegatta, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteRegatta(@PathVariable("id") Long id) {
        regattasService.deleteRegatta(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
