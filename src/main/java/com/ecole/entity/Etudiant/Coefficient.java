package com.ecole.entity.Etudiant;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "coefficients")
public class Coefficient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "matiere_id")
    private Long matiereId;
    
    @Column(name = "niveau_id")
    private Long niveauId;
    
    private BigDecimal valeur;
    
    // Getters et Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getMatiereId() { return matiereId; }
    public void setMatiereId(Long matiereId) { this.matiereId = matiereId; }
    public Long getNiveauId() { return niveauId; }
    public void setNiveauId(Long niveauId) { this.niveauId = niveauId; }
    public BigDecimal getValeur() { return valeur; }
    public void setValeur(BigDecimal valeur) { this.valeur = valeur; }
}