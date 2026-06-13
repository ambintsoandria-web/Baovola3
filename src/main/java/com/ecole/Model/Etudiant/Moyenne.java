package com.ecole.Model.Etudiant;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "moyennes")
public class Moyenne {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "etudiant_id")
    private Long etudiantId;
    
    @Column(name = "inscription_id")
    private Long inscriptionId;
    
    @Column(name = "periode_id")
    private Long periodeId;
    
    @Column(name = "matiere_id")
    private Long matiereId;
    
    @Column(name = "valeur")
    private BigDecimal valeur;
    
    @Column(name = "rang")
    private Integer rang;
    
    @Column(name = "effectif_classe")
    private Integer effectifClasse;
    
    @Column(name = "calculated_at")
    private LocalDateTime calculatedAt;
    
    // Getters et Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getEtudiantId() { return etudiantId; }
    public void setEtudiantId(Long etudiantId) { this.etudiantId = etudiantId; }
    public Long getInscriptionId() { return inscriptionId; }
    public void setInscriptionId(Long inscriptionId) { this.inscriptionId = inscriptionId; }
    public Long getPeriodeId() { return periodeId; }
    public void setPeriodeId(Long periodeId) { this.periodeId = periodeId; }
    public Long getMatiereId() { return matiereId; }
    public void setMatiereId(Long matiereId) { this.matiereId = matiereId; }
    public BigDecimal getValeur() { return valeur; }
    public void setValeur(BigDecimal valeur) { this.valeur = valeur; }
    public Integer getRang() { return rang; }
    public void setRang(Integer rang) { this.rang = rang; }
    public Integer getEffectifClasse() { return effectifClasse; }
    public void setEffectifClasse(Integer effectifClasse) { this.effectifClasse = effectifClasse; }
    public LocalDateTime getCalculatedAt() { return calculatedAt; }
    public void setCalculatedAt(LocalDateTime calculatedAt) { this.calculatedAt = calculatedAt; }
}