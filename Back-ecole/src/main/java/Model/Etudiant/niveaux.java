package Model.Etudiant;

import java.time.LocalDateTime;

public class niveaux {
    private Integer id;
    private Integer etablissementId;
    private String libelle;
    private Integer ordre;
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
