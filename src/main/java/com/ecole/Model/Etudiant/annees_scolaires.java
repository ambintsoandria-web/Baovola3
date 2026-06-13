package com.ecole.Model.Etudiant;

import java.time.LocalDate;
import java.time.LocalDateTime;
import jakarta.persistence.*;

@Entity
@Table(name = "annees_scolaires")
public class annees_scolaires {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "etablissement_id")
    private Integer etablissementId;

    @Column(name = "libelle", length = 50, nullable = false)
    private String libelle;

    @Column(name = "date_debut")
    private LocalDate dateDebut;

    @Column(name = "date_fin")
    private LocalDate dateFin;

    @Column(name = "est_active")
    private Boolean active;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    public annees_scolaires() {
    }

    public annees_scolaires(Integer id, Integer etablissementId, String libelle, LocalDate dateDebut, LocalDate dateFin,
            Boolean active, LocalDateTime createdAt) {
        this.id = id;
        this.etablissementId = etablissementId;
        this.libelle = libelle;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
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

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public LocalDate getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(LocalDate dateDebut) {
        this.dateDebut = dateDebut;
    }

    public LocalDate getDateFin() {
        return dateFin;
    }

    public void setDateFin(LocalDate dateFin) {
        this.dateFin = dateFin;
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
