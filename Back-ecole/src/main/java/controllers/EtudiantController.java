package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/etudiant")
public class EtudiantController {

    @GetMapping("/emploi")
    public String emploi() {
        return "pages/Etudiant/calendar";
    }

    @GetMapping("/notes")
    public String notes() {
        return "pages/Etudiant/notes";
    }

    @GetMapping("/bulletin")
    public String bulletin() {
        return "pages/Etudiant/bulletin";
    }

    @GetMapping("/devoirs")
    public String devoirs() {
        return "pages/Etudiant/devoirs";
    }
}
