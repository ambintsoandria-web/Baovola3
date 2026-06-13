package com.ecole.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String index() {
        return "Etudiant/calendar";
    }

    // --- ROUTES ETUDIANT ---
    @GetMapping("/etudiant/emploi")
    public String etuEmploi() {
        return "Etudiant/emploi_fragment"; // On va créer ce fichier avec juste la grille
    }

    @GetMapping("/etudiant/notes")
    public String etuNotes() {
        return "Etudiant/notes";
    }

    @GetMapping("/etudiant/bulletin")
    public String etuBulletin() {
        return "Etudiant/bulletin";
    }

    @GetMapping("/etudiant/devoirs")
    public String etuDevoirs() {
        return "Etudiant/devoirs";
    }

    // --- ROUTES PROFESSEUR ---
    @GetMapping("/professeur/emploi")
    public String profEmploi() {
        return "Professeur/calendar";
    }

    @GetMapping("/professeur/notes")
    public String profNotes() {
        return "Professeur/notes";
    }

    @GetMapping("/professeur/devoirs")
    public String profDevoirs() {
        return "Professeur/devoirs";
    }

    @GetMapping("/professeur/bulletins")
    public String profBulletins() {
        return "Professeur/bulletin";
    }

    @GetMapping("/professeur/profil")
    public String profProfil() {
        return "Professeur/profil";
    }

    // --- ROUTES COMMUNES ---
    @GetMapping("/actualites")
    public String actualites() {
        return "communs/actualites";
    }

    @GetMapping("/notifications")
    public String notifications() {
        return "communs/notifications";
    }

    // --- ROUTES DIRECTEUR ---
    @GetMapping("/directeur/dashboard")
    public String dirDashboard() {
        return "Directeur/dashboard";
    }

    @GetMapping("/directeur/finances")
    public String dirFinances() {
        return "Directeur/finances";
    }

    @GetMapping("/directeur/professeurs")
    public String dirProfs() {
        return "Directeur/professeurs";
    }

    @GetMapping("/directeur/profil-professeur")
    public String dirProfProfil() {
        return "Directeur/profil_professeur";
    }

    @GetMapping("/directeur/ecolages")
    public String dirEcolages() {
        return "Directeur/ecolages";
    }

    // --- ROUTES SECRETARIAT ---
    @GetMapping("/secretaire/paiements")
    public String secPaiements() {
        return "Secretaire/paiement";
    }

    @GetMapping("/secretaire/bilan")
    public String secBilan() {
        return "Secretaire/bilan";
    }

    @GetMapping("/secretaire/eleves")
    public String secEleves() {
        return "Secretaire/eleves";
    }

    @GetMapping("/secretaire/profil-eleve")
    public String secProfilEleve() {
        return "Secretaire/profil_eleve";
    }

    @GetMapping("/error")
    public String error() {
        return "error";
    }
}