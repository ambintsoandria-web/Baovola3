package com.ecole.Model.Etudiant;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import jakarta.persistence.*;

@Entity
@Table(name = "affectations_enseignement")
public class affectations_enseignement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "professeur_id")
    private Integer professeurId;

    @ManyToOne
    @JoinColumn(name = "professeur_id", insertable = false, updatable = false)
    private profils_professeurs professeur;

    @Column(name = "matiere_id")
    private Integer matiereId;

    @ManyToOne
    @JoinColumn(name = "matiere_id", insertable = false, updatable = false)
    private matieres matiere;

    @Column(name = "classe_id")
    private Integer classeId;

    @ManyToOne
    @JoinColumn(name = "classe_id", insertable = false, updatable = false)
    private classes classe;

    @Column(name = "annee_scolaire_id")
    private Integer anneeScolaireId;

    @ManyToOne
    @JoinColumn(name = "annee_scolaire_id", insertable = false, updatable = false)
    private annees_scolaires anneeScolaire;

    @Column(name = "heures_hebdo", precision = 4, scale = 1)
    private BigDecimal heuresHebdo;

    @Column(name = "created_at")
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
