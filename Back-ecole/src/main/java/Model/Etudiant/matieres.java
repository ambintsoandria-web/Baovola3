package Model.Etudiant;

import java.time.LocalDateTime;

public class matieres {
    private Integer id;
    private Integer etablissementId;
    private String nom;
    private String code;
    private LocalDateTime createdAt;

    public matieres() {
    }

    public matieres(Integer id, Integer etablissementId, String nom, String code, LocalDateTime createdAt) {
        this.id = id;
        this.etablissementId = etablissementId;
        this.nom = nom;
        this.code = code;
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
