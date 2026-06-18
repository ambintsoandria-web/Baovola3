package com.ecole.controller.Etudiant;

import java.util.List;

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

    @GetMapping("/etudiant/emploi")
    public String emploi(Model model, HttpSession session) {
        User userLoggedIn = userService.getCurrentUser(session);
        ProfilEtudiant profilEtudiant = userService.getCurrentProfil(session);
        // List<EmploiDuTemps> emploiDuTemps = emploiDuTempsRepository.findBySalleId(userRepository);

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
        User userLoggedIn = userService.getCurrentUser(session);
        ProfilEtudiant profilEtudiant = userService.getCurrentProfil(session);

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
        User userLoggedIn = userService.getCurrentUser(session);
        ProfilEtudiant profilEtudiant = userService.getCurrentProfil(session);

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
        User userLoggedIn = userService.getCurrentUser(session);
        ProfilEtudiant profilEtudiant = userService.getCurrentProfil(session);

        if (userLoggedIn == null) {
            return "redirect:/login";
        }

        model.addAttribute("pageTitle", "Mon Bulletin");
        model.addAttribute("currentRole", "etudiant");
        model.addAttribute("user", userLoggedIn);
        model.addAttribute("profilEtudiant", profilEtudiant);

        return "Etudiant/bulletin";
    }

    @GetMapping("/etudiant/profil")
    public String profil(Model model, HttpSession session) {
        User userLoggedIn = userService.getCurrentUser(session);
        ProfilEtudiant profilEtudiant = userService.getCurrentProfil(session);

        if (userLoggedIn == null) {
            return "redirect:/login";
        }

        model.addAttribute("pageTitle", "Mon Profil");
        model.addAttribute("currentRole", "etudiant");
        model.addAttribute("user", userLoggedIn);
        model.addAttribute("profilEtudiant", profilEtudiant);

        return "Etudiant/profil";
    }
}