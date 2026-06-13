package Model.Etudiant;

import java.time.LocalDateTime;

public class classes {
    private Integer id;
    private Integer niveauId;
    private niveaux niveau;
    private Integer anneeScolaireId;
    private annees_scolaires anneeScolaire;
    private String nom;
    private Integer capaciteMax;
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
