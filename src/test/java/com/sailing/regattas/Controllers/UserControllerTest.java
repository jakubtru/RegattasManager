package com.sailing.regattas.Controllers;

import com.sailing.regattas.Controllers.UserController;
import com.sailing.regattas.Entities.User;
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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class UserControllerTest {

    @InjectMocks
    private UserController userController;

    @Mock
    private UsersService usersService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetAllPlayers() {
        List<User> users = new ArrayList<>();
        when(usersService.getUsers()).thenReturn(users);

        ResponseEntity<List<User>> response = userController.getAllPlayers();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(users, response.getBody());
    }

    @Test
    public void testGetPlayerById() {
        Long userId = 1L;
        User user = new User();
        when(usersService.findUserById(userId)).thenReturn(user);

        ResponseEntity<User> response = userController.getPlayerById(userId);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(user, response.getBody());
    }

    @Test
    public void testAddUser() {
        User user = new User();
        when(usersService.createUser(user)).thenReturn(user);

        ResponseEntity<User> response = userController.addUser(user);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(user, response.getBody());
    }

    @Test
    public void testUpdateUser() {
        User user = new User();
        when(usersService.createUser(user)).thenReturn(user);

        ResponseEntity<User> response = userController.updateUser(user);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(user, response.getBody());
    }

    @Test
    public void testDeleteUser() {
        Long userId = 1L;
        ResponseEntity<?> response = userController.deleteUser(userId);

        verify(usersService, times(1)).deleteUser(userId);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void testGetUserByEmail() {
        String email = "test@example.com";
        User user = new User();
        when(usersService.findUserByEmail(email)).thenReturn(user);

        ResponseEntity<User> response = userController.getUserByEmail(email);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(user, response.getBody());
    }
}

