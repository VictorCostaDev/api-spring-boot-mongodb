package com.api.mongodb.projectSB.services;

import com.api.mongodb.projectSB.domain.User;
import com.api.mongodb.projectSB.repositories.UserRepository;
import com.api.mongodb.projectSB.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(String id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty()) throw new ObjectNotFoundException("Objeto não encontrado");
        return user.get();
    }
}
