package com.ecole.controller.Etudiant;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ecole.entity.Etudiant.Classe;
import com.ecole.entity.Etudiant.Coefficient;
import com.ecole.entity.Etudiant.Devoir;
import com.ecole.entity.Etudiant.Inscription;
import com.ecole.entity.Etudiant.Lecon;
import com.ecole.entity.Etudiant.Note;
import com.ecole.entity.Etudiant.ProfilEtudiant;
import com.ecole.entity.Etudiant.User;
import com.ecole.repository.Etudiant.CoefficientRepository;
import com.ecole.repository.Etudiant.DevoirRepository;
import com.ecole.repository.Etudiant.InscriptionRepository;
import com.ecole.repository.Etudiant.LeconRepository;
import com.ecole.repository.Etudiant.NoteRepository;
import com.ecole.repository.Etudiant.UserRepository;
import com.ecole.repository.Etudiant.classeRepository;
import com.ecole.service.Etudiant.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class EtudiantController {

    @Autowired
    public UserRepository userRepository;

    @Autowired
    public UserService userService;

    @Autowired
    public DevoirRepository devoirRepository;

    @Autowired
    public InscriptionRepository inscriptionRepository;

    @Autowired
    public LeconRepository leconRepository;

    @Autowired
    public NoteRepository noteRepository;

    @Autowired
    public classeRepository classeRepository;

    @Autowired
    public CoefficientRepository coefficientRepository;

    @GetMapping("/etudiant/emploi")
    public String emploi(Model model, HttpSession session) {

        User userLoggedIn = userService.getCurrentUser(session);
        ProfilEtudiant profilEtudiant = userService.getCurrentProfil(session);

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

        Long etudiantId = profilEtudiant.getId();

        List<Note> notes = (etudiantId != null) ? noteRepository.findNotesParEtudiant(etudiantId) : List.of();
        
        List<Inscription> inscriptions = inscriptionRepository.findActiveByEtudiant(etudiantId);

        Long classeId = inscriptions.get(0).getClasseId();

        Classe classe = classeRepository.findById(classeId).orElseThrow(() -> new RuntimeException("Classe introuvable"));

        Long niveau = classe.getNiveauId();

        Map<Long, java.math.BigDecimal> coefficientsMap = coefficientRepository.findCoefficientsMapByNiveau(niveau);
        model.addAttribute("pageTitle", "Mes Notes");
        model.addAttribute("currentRole", "etudiant");
        model.addAttribute("user", userLoggedIn);
        model.addAttribute("profilEtudiant", profilEtudiant);
        model.addAttribute("notes", notes);
        model.addAttribute("coefficientsMap", coefficientsMap);
        return "Etudiant/notes";
    }

    @GetMapping("/etudiant/devoirs")
    public String devoirs(Model model, HttpSession session) {
        User userLoggedIn = userService.getCurrentUser(session);
        ProfilEtudiant profilEtudiant = userService.getCurrentProfil(session);

        if (userLoggedIn == null) {
            return "redirect:/login";
        }

        List<Inscription> inscriptions = inscriptionRepository.findActiveByEtudiant(profilEtudiant.getUserId());

        Long classeId = null;
        if (!inscriptions.isEmpty()) {
            classeId = inscriptions.get(0).getClasseId();
        }

        List<Devoir> devoirs = (classeId != null)
                ? devoirRepository.findByClasse(classeId)
                : List.of();

        List<Lecon> lecons = leconRepository.findByClasseId(classeId);

        model.addAttribute("pageTitle", "Devoirs");
        model.addAttribute("currentRole", "etudiant");
        model.addAttribute("user", userLoggedIn);
        model.addAttribute("profilEtudiant", profilEtudiant);
        model.addAttribute("devoirs", devoirs);
        model.addAttribute("lecons", lecons);
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