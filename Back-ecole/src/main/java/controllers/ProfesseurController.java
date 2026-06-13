package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/professeur")
public class ProfesseurController {

    @GetMapping("/emploi")
    public String emploi() {
        return "pages/Professeur/calendar";
    }

    @GetMapping("/notes")
    public String notes() {
        return "pages/Professeur/notes";
    }

    @GetMapping("/devoirs")
    public String devoirs() {
        return "pages/Professeur/devoirs";
    }

    @GetMapping("/bulletins")
    public String bulletins() {
        return "pages/Professeur/bulletin";
    }

    @GetMapping("/profil")
    public String profil() {
        return "pages/Professeur/profil";
    }
}
