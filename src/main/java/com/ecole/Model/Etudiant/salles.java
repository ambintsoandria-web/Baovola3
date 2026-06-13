package com.ecole.Model.Etudiant;

import java.time.LocalDateTime;
import jakarta.persistence.*;

@Entity
@Table(name = "salles")
public class salles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "etablissement_id")
    private Integer etablissementId;

    @Column(name = "nom", length = 100, nullable = false)
    private String nom;

    @Column(name = "capacite")
    private Integer capacite;

    @Column(name = "type", length = 50)
    private String type;

    @Column(name = "is_active")
    private Boolean active;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    public salles() {
    }

    public salles(Integer id, Integer etablissementId, String nom, Integer capacite, String type, Boolean active, LocalDateTime createdAt) {
        this.id = id;
        this.etablissementId = etablissementId;
        this.nom = nom;
        this.capacite = capacite;
        this.type = type;
        this.active = active;
        this.createdAt = createdAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEtablissementId() {
        return etablissementId;
    }

    public void setEtablissementId(Integer etablissementId) {
        this.etablissementId = etablissementId;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Integer getCapacite() {
        return capacite;
    }

    public void setCapacite(Integer capacite) {
        this.capacite = capacite;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
