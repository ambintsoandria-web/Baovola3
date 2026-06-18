package com.ecole.service.Etudiant;

import com.ecole.entity.Etudiant.User;
import com.ecole.repository.Etudiant.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User authenticate(String email, String password) {
        return userRepository.findByEmailAndPassword(email, password);
    }
}