package Model.Etudiant;

import java.time.LocalDateTime;

public class documents {
    private Integer id;
    private Integer etudiantId;
    private profils_etudiants etudiant;
    private String typeDocument;
    private String titre;
    private String fichierUrl;
    private Integer anneeScolaireId;
    private annees_scolaires anneeScolaire;
    private Integer periodeId;
    private periodes periode;
    private Integer generePar;
    private Users genereParUser;
    private LocalDateTime genereLe;
    private Boolean valide;

    public documents() {
    }

    public documents(Integer id, Integer etudiantId, profils_etudiants etudiant, String typeDocument, String titre,
                     String fichierUrl, Integer anneeScolaireId, annees_scolaires anneeScolaire, Integer periodeId,
                     periodes periode, Integer generePar, Users genereParUser, LocalDateTime genereLe, Boolean valide) {
        this.id = id;
        this.etudiantId = etudiantId;
        this.etudiant = etudiant;
        this.typeDocument = typeDocument;
        this.titre = titre;
        this.fichierUrl = fichierUrl;
        this.anneeScolaireId = anneeScolaireId;
        this.anneeScolaire = anneeScolaire;
        this.periodeId = periodeId;
        this.periode = periode;
        this.generePar = generePar;
        this.genereParUser = genereParUser;
        this.genereLe = genereLe;
        this.valide = valide;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEtudiantId() {
        return etudiantId;
    }

    public void setEtudiantId(Integer etudiantId) {
        this.etudiantId = etudiantId;
    }

    public profils_etudiants getEtudiant() {
        return etudiant;
    }

    public void setEtudiant(profils_etudiants etudiant) {
        this.etudiant = etudiant;
    }

    public String getTypeDocument() {
        return typeDocument;
    }

    public void setTypeDocument(String typeDocument) {
        this.typeDocument = typeDocument;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getFichierUrl() {
        return fichierUrl;
    }

    public void setFichierUrl(String fichierUrl) {
        this.fichierUrl = fichierUrl;
    }

    public Integer getAnneeScolaireId() {
        return anneeScolaireId;
    }

    public void setAnneeScolaireId(Integer anneeScolaireId) {
        this.anneeScolaireId = anneeScolaireId;
    }

    public annees_scolaires getAnneeScolaire() {
        return anneeScolaire;
    }

    public void setAnneeScolaire(annees_scolaires anneeScolaire) {
        this.anneeScolaire = anneeScolaire;
    }

    public Integer getPeriodeId() {
        return periodeId;
    }

    public void setPeriodeId(Integer periodeId) {
        this.periodeId = periodeId;
    }

    public periodes getPeriode() {
        return periode;
    }

    public void setPeriode(periodes periode) {
        this.periode = periode;
    }

    public Integer getGenerePar() {
        return generePar;
    }

    public void setGenerePar(Integer generePar) {
        this.generePar = generePar;
    }

    public Users getGenereParUser() {
        return genereParUser;
    }

    public void setGenereParUser(Users genereParUser) {
        this.genereParUser = genereParUser;
    }

    public LocalDateTime getGenereLe() {
        return genereLe;
    }

    public void setGenereLe(LocalDateTime genereLe) {
        this.genereLe = genereLe;
    }

    public Boolean getValide() {
        return valide;
    }

    public void setValide(Boolean valide) {
        this.valide = valide;
    }
}
