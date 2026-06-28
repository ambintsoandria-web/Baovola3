package com.ecole.controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ecole.entity.Etudiant.ProfilEtudiant;
import com.ecole.entity.Etudiant.User;
import com.ecole.repository.Etudiant.UserRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public LoginController(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String login(
            @RequestParam(defaultValue = "") String email,
            @RequestParam(defaultValue = "") String password,
            HttpSession session) {

        String normalizedEmail = email.trim().toLowerCase();

        if (normalizedEmail.isEmpty() || password.isEmpty()) {
            return "redirect:/login?error=true";
        }

        // 1. Chercher l'utilisateur par email seulement
        User user = userRepository.findByEmail(normalizedEmail);

        // 2. Vérifier le mot de passe avec BCrypt
        if (user == null || !passwordEncoder.matches(password, user.getPassword())) {
            return "redirect:/login?error=true";
        }

        if (Boolean.FALSE.equals(user.getIsActive())) {
            return "redirect:/login?error=true";
        }

        List<String> roles = userRepository.findRoleNamesByUserId(user.getId());
        if (roles.isEmpty()) {
            return "redirect:/login?error=role";
        }

        user.setLastLogin(LocalDateTime.now());
        userRepository.save(user);

        session.setAttribute("userLoggedIn", user);
        session.setAttribute("userRoles", roles);

        ProfilEtudiant profilEtudiant = userRepository.findProfilEtudiantByUserId(user.getId());
        if (profilEtudiant != null) {
            session.setAttribute("profilEtudiant", profilEtudiant);
        }

        return "redirect:" + redirectForRoles(roles);
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }

    private String redirectForRoles(List<String> roles) {
        Set<String> normalizedRoles = roles.stream()
                .map(String::toLowerCase)
                .collect(Collectors.toSet());

        if (normalizedRoles.contains("super_admin") || normalizedRoles.contains("directeur"))
            return "/directeur/dashboard";
        if (normalizedRoles.contains("secretariat") || normalizedRoles.contains("comptable"))
            return "/secretariat/paiement";
        if (normalizedRoles.contains("professeur"))
            return "/professeur/emploi";
        if (normalizedRoles.contains("etudiant"))
            return "/etudiant/emploi";

        return "/login?error=role";
    }
}