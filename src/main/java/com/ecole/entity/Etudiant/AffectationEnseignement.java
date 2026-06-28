package com.ecole.entity.Etudiant;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "affectations_enseignement")
public class AffectationEnseignement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "professeur_id")
    private ProfilProfesseur professeur;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "matiere_id")
    private Matiere matiere;

    @Column(name = "classe_id")
    private Long classeId;

    @Column(name = "annee_scolaire_id")
    private Long anneeScolaireId;

    @Column(name = "heures_hebdo")
    private BigDecimal heuresHebdo;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ProfilProfesseur getProfesseur() {
        return professeur;
    }

    public void setProfesseur(ProfilProfesseur professeur) {
        this.professeur = professeur;
    }

    public Matiere getMatiere() {
        return matiere;
    }

    public void setMatiere(Matiere matiere) {
        this.matiere = matiere;
    }

    // Méthodes pour compatibilité avec l'ancien nom (professeurId/matiereId)
    public ProfilProfesseur getProfesseurId() {
        return professeur;
    }

    public void setProfesseurId(ProfilProfesseur professeur) {
        this.professeur = professeur;
    }

    public Matiere getMatiereId() {
        return matiere;
    }

    public void setMatiereId(Matiere matiere) {
        this.matiere = matiere;
    }

    public Long getClasseId() {
        return classeId;
    }

    public void setClasseId(Long classeId) {
        this.classeId = classeId;
    }

    public Long getAnneeScolaireId() {
        return anneeScolaireId;
    }

    public void setAnneeScolaireId(Long anneeScolaireId) {
        this.anneeScolaireId = anneeScolaireId;
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