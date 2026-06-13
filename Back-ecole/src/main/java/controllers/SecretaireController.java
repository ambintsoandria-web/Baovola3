package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/secretaire")
public class SecretaireController {

    @GetMapping("/paiements")
    public String paiements() {
        return "pages/Secretaire/paiement";
    }

    @GetMapping("/bilan")
    public String bilan() {
        return "pages/Secretaire/bilan";
    }

    @GetMapping("/eleves")
    public String eleves() {
        return "pages/Secretaire/eleves";
    }

    @GetMapping("/profil-eleve")
    public String profilEleve() {
        return "pages/Secretaire/profil_eleve";
    }
}
