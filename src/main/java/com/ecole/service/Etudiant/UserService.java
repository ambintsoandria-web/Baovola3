package com.ecole.service.Etudiant;

import com.ecole.entity.Etudiant.ProfilEtudiant;
import com.ecole.entity.Etudiant.User;
import com.ecole.repository.Etudiant.UserRepository;

import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    public UserRepository userRepository;

    public User getCurrentUser(HttpSession session) {
        User user = (User) session.getAttribute("userLoggedIn");

        if (user == null) {
            user = userRepository.findByEmailAndPassword("rakoto.jean@lycee.mg", "a");
            if (user != null) {
                session.setAttribute("userLoggedIn", user);

                ProfilEtudiant profil = userRepository.findProfilEtudiantByUserId(user.getId());
                session.setAttribute("profilEtudiant", profil);
            }
        }

        return user;
    }

    public ProfilEtudiant getCurrentProfil(HttpSession session) {
        ProfilEtudiant profil = (ProfilEtudiant) session.getAttribute("profilEtudiant");

        if (profil == null) {
            User user = getCurrentUser(session);
            if (user != null) {
                profil = userRepository.findProfilEtudiantByUserId(user.getId());
                session.setAttribute("profilEtudiant", profil);
            }
        }

        return profil;
    }

}