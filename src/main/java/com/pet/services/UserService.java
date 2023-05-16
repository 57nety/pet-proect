package com.pet.services;

import org.springframework.stereotype.Service;
import com.pet.entities.User;
import com.pet.repositories.UserRepository;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public User createUser(User user) {
        List<User> users = userRepository.findByLogin(user.getLogin());
        if (!users.isEmpty())
            throw new IllegalArgumentException("Пользователь с таким логином уже существует");
        return userRepository.save(user);
    }
}