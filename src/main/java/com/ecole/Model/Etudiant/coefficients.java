package com.ecole.Model.Etudiant;

import java.math.BigDecimal;
import jakarta.persistence.*;

@Entity
@Table(name = "coefficients")
public class coefficients {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "matiere_id")
    private Integer matiereId;

    @ManyToOne
    @JoinColumn(name = "matiere_id", insertable = false, updatable = false)
    private matieres matiere;

    @Column(name = "niveau_id")
    private Integer niveauId;

    @ManyToOne
    @JoinColumn(name = "niveau_id", insertable = false, updatable = false)
    private niveaux niveau;

    @Column(name = "valeur", precision = 4, scale = 2, nullable = false)
    private BigDecimal valeur;

    public coefficients() {
    }

    public coefficients(Integer id, Integer matiereId, matieres matiere, Integer niveauId, niveaux niveau, BigDecimal valeur) {
        this.id = id;
        this.matiereId = matiereId;
        this.matiere = matiere;
        this.niveauId = niveauId;
        this.niveau = niveau;
        this.valeur = valeur;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public BigDecimal getValeur() {
        return valeur;
    }

    public void setValeur(BigDecimal valeur) {
        this.valeur = valeur;
    }
}
