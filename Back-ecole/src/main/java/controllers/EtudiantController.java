package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ch.qos.logback.core.model.Model;
import repository.Etudiant.MatieresRepository;

@Controller

public class EtudiantController {

    @Autowired
    private MatieresRepository matieresRepository;
    // @GetMapping("/emploi")
    // public String emploi() {
    //     return "pages/Etudiant/calendar";
    // }

    // @GetMapping("/notes")
    // public String notes() {
    //     return "pages/Etudiant/notes";
    // }

    // @GetMapping("/bulletin")
    // public String bulletin() {
    //     return "pages/Etudiant/bulletin";
    // }

    // @GetMapping("/devoirs")
    // public String devoirs() {
    //     return "pages/Etudiant/devoirs";
    // }

    
}
