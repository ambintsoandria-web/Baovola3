package com.ecole.controller.Etudiant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
        User userLoggedIn = (User) session.getAttribute("userLoggedIn");

        if (userLoggedIn == null) {
            userLoggedIn = userRepository.findByEmailAndPassword("rakoto.jean@lycee.mg", "a");
            session.setAttribute("userLoggedIn", userLoggedIn);
        }

        model.addAttribute("pageTitle", "Mon Emploi du Temps");
        model.addAttribute("currentRole", "etudiant");
        model.addAttribute("user", userLoggedIn);

        return "Etudiant/calendar";
    }

    @GetMapping("/etudiant/notes")
    public String notes(Model model) {
        model.addAttribute("pageTitle", "Mes Notes");
        model.addAttribute("currentRole", "etudiant");
        return "Etudiant/notes";
    }

    @GetMapping("/etudiant/devoirs")
    public String devoirs(Model model) {
        model.addAttribute("pageTitle", "Devoirs & Leçons");
        model.addAttribute("currentRole", "etudiant");
        return "Etudiant/devoirs";
    }

    @GetMapping("/etudiant/bulletin")
    public String bulletin(Model model) {
        model.addAttribute("pageTitle", "Mon Bulletin");
        model.addAttribute("currentRole", "etudiant");
        return "Etudiant/bulletin";
    }
}
