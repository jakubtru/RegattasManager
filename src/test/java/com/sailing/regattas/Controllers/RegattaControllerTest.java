package com.sailing.regattas.Controllers;

import com.sailing.regattas.Controllers.RegattaController;
import com.sailing.regattas.Entities.Regatta;
import com.sailing.regattas.Entities.User;
import com.sailing.regattas.Services.RegattasService;
import com.sailing.regattas.Services.UsersService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class RegattaControllerTest {

    @InjectMocks
    private RegattaController regattaController;

    @Mock
    private RegattasService regattasService;

    @Mock
    private UsersService usersService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetAllRegattas() {
        List<Regatta> regattas = new ArrayList<>();
        when(regattasService.getRegattas()).thenReturn(regattas);

        ResponseEntity<List<Regatta>> response = regattaController.getAllRegattas();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(regattas, response.getBody());
    }

    @Test
    public void testGetRegattaById() {
        Long regattaId = 1L;
        Regatta regatta = new Regatta();
        when(regattasService.findRegattaById(regattaId)).thenReturn(regatta);

        ResponseEntity<Regatta> response = regattaController.getRegattaById(regattaId);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(regatta, response.getBody());
    }

    @Test
    public void testGetRegattaByUserId() {
        Long userId = 1L;
        List<Regatta> regattas = new ArrayList<>();
        when(regattasService.findRegattasByUserId(userId)).thenReturn(regattas);

        ResponseEntity<List<Regatta>> response = regattaController.getRegattaByUserId(userId);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(regattas, response.getBody());
    }

    @Test
    public void testAddRegatta() {
        Regatta regatta = new Regatta();
        when(regattasService.createRegatta(regatta)).thenReturn(regatta);

        ResponseEntity<Regatta> response = regattaController.addRegatta(regatta);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(regatta, response.getBody());
    }

    @Test
    public void testAddRegattaWithUserId() {
        Long userId = 1L;
        User user = new User();
        Regatta regatta = new Regatta();

        when(usersService.findUserById(userId)).thenReturn(user);
        when(regattasService.createRegatta(regatta)).thenReturn(regatta);

        ResponseEntity<Regatta> response = regattaController.addRegatta(regatta, userId);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(regatta, response.getBody());
        assertEquals(user, regatta.getUser());
    }

    @Test
    public void testUpdateRegatta() {
        Regatta regatta = new Regatta();
        when(regattasService.createRegatta(regatta)).thenReturn(regatta);

        ResponseEntity<Regatta> response = regattaController.updateRegatta(regatta);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(regatta, response.getBody());
    }

    @Test
    public void testUpdateRegattaWithUserId() {
        Long userId = 1L;
        User user = new User();
        Regatta regatta = new Regatta();

        when(usersService.findUserById(userId)).thenReturn(user);
        when(regattasService.createRegatta(regatta)).thenReturn(regatta);

        ResponseEntity<Regatta> response = regattaController.updateRegatta(regatta, userId);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(regatta, response.getBody());
        assertEquals(user, regatta.getUser());
    }

    @Test
    public void testDeleteRegatta() {
        Long regattaId = 1L;
        ResponseEntity<?> response = regattaController.deleteRegatta(regattaId);

        verify(regattasService, times(1)).deleteRegatta(regattaId);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }
}
