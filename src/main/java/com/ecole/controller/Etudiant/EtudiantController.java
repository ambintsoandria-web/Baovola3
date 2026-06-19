package com.ecole.controller.Etudiant;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ecole.entity.Etudiant.Devoir;
import com.ecole.entity.Etudiant.Inscription;
import com.ecole.entity.Etudiant.Lecon;
import com.ecole.entity.Etudiant.Note;
import com.ecole.entity.Etudiant.ProfilEtudiant;
import com.ecole.entity.Etudiant.User;
import com.ecole.repository.Etudiant.DevoirRepository;
import com.ecole.repository.Etudiant.InscriptionRepository;
import com.ecole.repository.Etudiant.LeconRepository;
import com.ecole.repository.Etudiant.NoteRepository;
import com.ecole.repository.Etudiant.UserRepository;
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
      
      // L'ID étudiant est l'ID du profil étudiant lui-même
      Long etudiantId = profilEtudiant.getId();

      List<Note> notes = (etudiantId != null) ? noteRepository.findNotesParEtudiant(etudiantId):List.of();
          


        
        model.addAttribute("pageTitle", "Mes Notes");
        model.addAttribute("currentRole", "etudiant");
        model.addAttribute("user", userLoggedIn);
        model.addAttribute("profilEtudiant", profilEtudiant);
        model.addAttribute("notes", notes);
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

        List<Lecon> lecons = leconRepository.findAll();

        model.addAttribute("pageTitle", "Devoirs & Leçons");
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