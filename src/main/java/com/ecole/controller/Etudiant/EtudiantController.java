package com.ecole.controller.Etudiant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ecole.entity.Etudiant.ProfilEtudiant;
import com.ecole.entity.Etudiant.User;
import com.ecole.repository.Etudiant.UserRepository;
import com.ecole.service.Etudiant.UserService;
import jakarta.servlet.http.HttpSession;

@Controller
public class EtudiantController {

    @Autowired
    public UserRepository userRepository;

    @Autowired
    public UserService userService;

    // Méthode pour récupérer l'utilisateur depuis la session ou le charger
    private User getCurrentUser(HttpSession session) {
        User user = (User) session.getAttribute("userLoggedIn");
        
        if (user == null) {
            // Charger depuis la base une seule fois
            user = userRepository.findByEmailAndPassword("rakoto.jean@lycee.mg", "a");
            if (user != null) {
                session.setAttribute("userLoggedIn", user);
                
                // Charger aussi le profil
                ProfilEtudiant profil = userRepository.findProfilEtudiantByUserId(user.getId());
                session.setAttribute("profilEtudiant", profil);
            }
        }
        
        return user;
    }

    // Méthode pour récupérer le profil
    private ProfilEtudiant getCurrentProfil(HttpSession session) {
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

    @GetMapping("/etudiant/emploi")
    public String emploi(Model model, HttpSession session) {
        User userLoggedIn = getCurrentUser(session);
        ProfilEtudiant profilEtudiant = getCurrentProfil(session);
        
        if (userLoggedIn == null) {
            return "redirect:/login";
        }

        model.addAttribute("pageTitle", "Mon Emploi du Temps");
        model.addAttribute("currentRole", "etudiant");
        model.addAttribute("user", userLoggedIn);
        model.addAttribute("profilEtudiant", profilEtudiant);

        return "Etudiant/calendar";
    }

    @GetMapping("/etudiant/notes")
    public String notes(Model model, HttpSession session) {
        User userLoggedIn = getCurrentUser(session);
        ProfilEtudiant profilEtudiant = getCurrentProfil(session);
        
        if (userLoggedIn == null) {
            return "redirect:/login";
        }

        model.addAttribute("pageTitle", "Mes Notes");
        model.addAttribute("currentRole", "etudiant");
        model.addAttribute("user", userLoggedIn);
        model.addAttribute("profilEtudiant", profilEtudiant);

        return "Etudiant/notes";
    }

    @GetMapping("/etudiant/devoirs")
    public String devoirs(Model model, HttpSession session) {
        User userLoggedIn = getCurrentUser(session);
        ProfilEtudiant profilEtudiant = getCurrentProfil(session);
        
        if (userLoggedIn == null) {
            return "redirect:/login";
        }

        model.addAttribute("pageTitle", "Devoirs & Leçons");
        model.addAttribute("currentRole", "etudiant");
        model.addAttribute("user", userLoggedIn);
        model.addAttribute("profilEtudiant", profilEtudiant);

        return "Etudiant/devoirs";
    }

    @GetMapping("/etudiant/bulletin")
    public String bulletin(Model model, HttpSession session) {
        User userLoggedIn = getCurrentUser(session);
        ProfilEtudiant profilEtudiant = getCurrentProfil(session);
        
        if (userLoggedIn == null) {
            return "redirect:/login";
        }

        model.addAttribute("pageTitle", "Mon Bulletin");
        model.addAttribute("currentRole", "etudiant");
        model.addAttribute("user", userLoggedIn);
        model.addAttribute("profilEtudiant", profilEtudiant);

        return "Etudiant/bulletin";
    }
}