package Model.Etudiant;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class affectations_enseignement {
    private Integer id;
    private Integer professeurId;
    private profils_professeurs professeur;
    private Integer matiereId;
    private matieres matiere;
    private Integer classeId;
    private classes classe;
    private Integer anneeScolaireId;
    private annees_scolaires anneeScolaire;
    private BigDecimal heuresHebdo;
    private LocalDateTime createdAt;

    public affectations_enseignement() {
    }

    public affectations_enseignement(Integer id, Integer professeurId, profils_professeurs professeur, Integer matiereId,
                                     matieres matiere, Integer classeId, classes classe, Integer anneeScolaireId,
                                     annees_scolaires anneeScolaire, BigDecimal heuresHebdo, LocalDateTime createdAt) {
        this.id = id;
        this.professeurId = professeurId;
        this.professeur = professeur;
        this.matiereId = matiereId;
        this.matiere = matiere;
        this.classeId = classeId;
        this.classe = classe;
        this.anneeScolaireId = anneeScolaireId;
        this.anneeScolaire = anneeScolaire;
        this.heuresHebdo = heuresHebdo;
        this.createdAt = createdAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProfesseurId() {
        return professeurId;
    }

    public void setProfesseurId(Integer professeurId) {
        this.professeurId = professeurId;
    }

    public profils_professeurs getProfesseur() {
        return professeur;
    }

    public void setProfesseur(profils_professeurs professeur) {
        this.professeur = professeur;
    }

    public Integer getMatiereId() {
        return matiereId;
    }

    public void setMatiereId(Integer matiereId) {
        this.matiereId = matiereId;
    }

    public matieres getMatiere() {
        return matiere;
    }

    public void setMatiere(matieres matiere) {
        this.matiere = matiere;
    }

    public Integer getClasseId() {
        return classeId;
    }

    public void setClasseId(Integer classeId) {
        this.classeId = classeId;
    }

    public classes getClasse() {
        return classe;
    }

    public void setClasse(classes classe) {
        this.classe = classe;
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

    public BigDecimal getHeuresHebdo() {
        return heuresHebdo;
    }

    public void setHeuresHebdo(BigDecimal heuresHebdo) {
        this.heuresHebdo = heuresHebdo;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
