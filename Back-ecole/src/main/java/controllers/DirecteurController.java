package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/directeur")
public class DirecteurController {

    @GetMapping("/dashboard")
    public String dashboard() {
        return "pages/Directeur/dashboard";
    }

    @GetMapping("/finances")
    public String finances() {
        return "pages/Directeur/finances";
    }

    @GetMapping("/professeurs")
    public String professeurs() {
        return "pages/Directeur/professeurs";
    }

    @GetMapping("/profil-professeur")
    public String profilProfesseur() {
        return "pages/Directeur/profil_professeur";
    }

    @GetMapping("/ecolages")
    public String ecolages() {
        return "pages/Directeur/ecolages";
    }
}
