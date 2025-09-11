package org.example.springboottdd.service;

import lombok.RequiredArgsConstructor;
import org.example.springboottdd.entity.User;
import org.example.springboottdd.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User createUser(String name, String password) {
        User user = new User(name, password);
        return userRepository.save(user);
    }
}
