package com.sailing.regattas.Controllers;

import com.sailing.regattas.Controllers.LoginController;
import com.sailing.regattas.Entities.User;
import com.sailing.regattas.Services.UsersService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class LoginControllerTest {

    @InjectMocks
    private LoginController loginController;

    @Mock
    private UsersService usersService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSuccessfulLogin() {
        User user = new User();
        when(usersService.authenticateUser(user)).thenReturn(true);

        ResponseEntity<String> response = loginController.login(user);
        System.out.println(response);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Login successful", response.getBody());
    }

    @Test
    public void testFailedLogin() {
        User user = new User();
        when(usersService.authenticateUser(user)).thenReturn(false);

        ResponseEntity<String> response = loginController.login(user);
        System.out.println(response);

        assertEquals(HttpStatus.UNAUTHORIZED, response.getStatusCode());
        assertEquals("Login failed", response.getBody());
    }
}
