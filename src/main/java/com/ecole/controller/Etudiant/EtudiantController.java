package com.ecole.controller.Etudiant;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ecole.entity.Etudiant.AnneeScolaire;
import com.ecole.entity.Etudiant.EmploiDuTemps;
import com.ecole.entity.Etudiant.ProfilEtudiant;
import com.ecole.entity.Etudiant.User;
import com.ecole.entity.Etudiant.HoraireEdt;
import com.ecole.entity.Etudiant.Periode;
import com.ecole.repository.Etudiant.AnneeScolaireRepository;
import com.ecole.repository.Etudiant.EmploiDuTempsRepository;
import com.ecole.repository.Etudiant.HoraireEdtRepository;
import com.ecole.repository.Etudiant.PeriodeRepository;
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
    public EmploiDuTempsRepository emploiDuTempsRepository;

    @Autowired
    public HoraireEdtRepository horaireEdtRepository;

    @Autowired
    public AnneeScolaireRepository anneeScolaireRepository;

    @Autowired
    public PeriodeRepository periodeRepository;

    private final List<String> JOURS = Arrays.asList("Lundi", "Mardi", "Mercredi", "Jeudi", "Vendredi");

    @GetMapping("/etudiant/emploi")
    public String emploi(
            Model model,
            HttpSession session,
            @RequestParam(required = false) Integer anneeScolaireId,
            @RequestParam(required = false) Integer periodeId) {

        User userLoggedIn = userService.getCurrentUser(session);
        ProfilEtudiant profilEtudiant = userService.getCurrentProfil(session);

        if (userLoggedIn == null) {
            return "redirect:/login";
        }

        List<AnneeScolaire> anneesScolaires = anneeScolaireRepository.getAnneesScolairesByEtudiant(
                userLoggedIn.getId().intValue());

        if (anneeScolaireId == null && !anneesScolaires.isEmpty()) {
            anneeScolaireId = anneesScolaires.get(0).getId().intValue();
        }

        List<Periode> periodes = new ArrayList<>();
        if (anneeScolaireId != null) {
            periodes = periodeRepository.findByAnneeScolaireId(anneeScolaireId.longValue());
        }

        if (periodeId == null && !periodes.isEmpty()) {
            periodeId = periodes.get(0).getId().intValue();
        }

        Integer salleId = userService.getSalleEtudiant(userLoggedIn.getId().intValue());

        List<EmploiDuTemps> emploiDuTemps = new ArrayList<>();
        List<HoraireEdt> horaires = new ArrayList<>();

        if (salleId != null && periodeId != null) {
            List<Object[]> results = emploiDuTempsRepository.findEmploiWithDetails(
                    salleId.longValue(), periodeId.longValue());

            for (Object[] row : results) {
                EmploiDuTemps e = new EmploiDuTemps();
                e.setId(((Number) row[0]).longValue());
                e.setAffectationId(((Number) row[1]).longValue());
                e.setSalleId(((Number) row[2]).longValue());
                e.setJourSemaine((Integer) row[3]);

                if (row[4] != null) {
                    e.setHeureDebut(((Time) row[4]).toLocalTime());
                }
                if (row[5] != null) {
                    e.setHeureFin(((Time) row[5]).toLocalTime());
                }

                if (row[6] != null) {
                    e.setDateDebutValidite(((java.sql.Date) row[6]).toLocalDate());
                }
                if (row[7] != null) {
                    e.setDateFinValidite(((java.sql.Date) row[7]).toLocalDate());
                }
                if (row[8] != null) {
                    e.setCreatedAt(((Timestamp) row[8]).toLocalDateTime());
                }

                e.setHoraireEdtId(((Number) row[9]).longValue());
                e.setPeriodeId(((Number) row[10]).longValue());
                e.setMatiereNom((String) row[11]);
                e.setProfesseurNom((String) row[12]);
                e.setProfesseurPrenom((String) row[13]);

                emploiDuTemps.add(e);
            }

            horaires = horaireEdtRepository.findAllOrderByOrdre();
        }

        model.addAttribute("pageTitle", "Mon Emploi du Temps");
        model.addAttribute("currentRole", "etudiant");
        model.addAttribute("user", userLoggedIn);
        model.addAttribute("profilEtudiant", profilEtudiant);
        model.addAttribute("emploiDuTemps", emploiDuTemps);
        model.addAttribute("horaires", horaires);
        model.addAttribute("jours", JOURS);
        model.addAttribute("anneesScolaires", anneesScolaires);
        model.addAttribute("anneeScolaireId", anneeScolaireId);
        model.addAttribute("periodes", periodes);
        model.addAttribute("periodeId", periodeId);

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
}