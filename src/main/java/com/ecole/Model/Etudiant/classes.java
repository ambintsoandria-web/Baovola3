package com.ecole.Model.Etudiant;

import java.time.LocalDateTime;
import jakarta.persistence.*;

@Entity
@Table(name = "classes")
public class classes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "niveau_id")
    private Integer niveauId;

    @ManyToOne
    @JoinColumn(name = "niveau_id", insertable = false, updatable = false)
    private niveaux niveau;

    @Column(name = "annee_scolaire_id")
    private Integer anneeScolaireId;

    @ManyToOne
    @JoinColumn(name = "annee_scolaire_id", insertable = false, updatable = false)
    private annees_scolaires anneeScolaire;

    @Column(name = "nom", length = 100, nullable = false)
    private String nom;

    @Column(name = "capacite_max")
    private Integer capaciteMax;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    public classes() {
    }

    public classes(Integer id, Integer niveauId, niveaux niveau, Integer anneeScolaireId, annees_scolaires anneeScolaire,
                   String nom, Integer capaciteMax, LocalDateTime createdAt) {
        this.id = id;
        this.niveauId = niveauId;
        this.niveau = niveau;
        this.anneeScolaireId = anneeScolaireId;
        this.anneeScolaire = anneeScolaire;
        this.nom = nom;
        this.capaciteMax = capaciteMax;
        this.createdAt = createdAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNiveauId() {
        return niveauId;
    }

    public void setNiveauId(Integer niveauId) {
        this.niveauId = niveauId;
    }

    public niveaux getNiveau() {
        return niveau;
    }

    public void setNiveau(niveaux niveau) {
        this.niveau = niveau;
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

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Integer getCapaciteMax() {
        return capaciteMax;
    }

    public void setCapaciteMax(Integer capaciteMax) {
        this.capaciteMax = capaciteMax;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
