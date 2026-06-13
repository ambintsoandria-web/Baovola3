package com.ecole.Model.Etudiant;

import java.time.LocalDateTime;
import jakarta.persistence.*;

@Entity
@Table(name = "niveaux")
public class niveaux {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "etablissement_id")
    private Integer etablissementId;

    @Column(name = "libelle", length = 100, nullable = false)
    private String libelle;

    @Column(name = "ordre", nullable = false)
    private Integer ordre;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    public niveaux() {
    }

    public niveaux(Integer id, Integer etablissementId, String libelle, Integer ordre, LocalDateTime createdAt) {
        this.id = id;
        this.etablissementId = etablissementId;
        this.libelle = libelle;
        this.ordre = ordre;
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

    public Integer getOrdre() {
        return ordre;
    }

    public void setOrdre(Integer ordre) {
        this.ordre = ordre;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
