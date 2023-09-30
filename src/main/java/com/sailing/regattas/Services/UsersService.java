package com.sailing.regattas.Services;

import com.sailing.regattas.Entities.User;
import com.sailing.regattas.Exceptions.UserNotFoundException;
import com.sailing.regattas.Repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersService {
    @Autowired
    UsersRepository usersRepository;

    public List<User> getUsers() {
        return usersRepository.findAll();
    }

    public User findPlayerById(Long id) {
        return usersRepository.findById(id).orElseThrow(() -> new UserNotFoundException("Player with id " + id + " was not found"));
    }

    public User createUser(User user) {
        return usersRepository.save(user);
    }

    public void deleteUser(Long id) {
        usersRepository.deleteById(id);
    }

    public boolean registerUser(User user) {
        try {
            usersRepository.save(user);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean authenticateUser(User user) {
        try {
            User userFromDb = usersRepository.findByEmail(user.getEmail());
            return userFromDb.getPassword().equals(user.getPassword());
        } catch (Exception e) {
            return false;
        }
    }

    public User findUserByEmail(String email) {
        return usersRepository.findByEmail(email);
    }
}
