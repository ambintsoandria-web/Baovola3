package com.ecole.entity.Etudiant;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "emploi_du_temps")
public class EmploiDuTemps {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "affectation_id")
    private Long affectationId;
    
    @Column(name = "salle_id")
    private Long salleId;
    
    @Column(name = "jour_semaine")
    private Integer jourSemaine;
    
    @Column(name = "heure_debut")
    private LocalTime heureDebut;
    
    @Column(name = "heure_fin")
    private LocalTime heureFin;
    
    @Column(name = "date_debut_validite")
    private LocalDate dateDebutValidite;
    
    @Column(name = "date_fin_validite")
    private LocalDate dateFinValidite;
    
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    
    // Getters et Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getAffectationId() { return affectationId; }
    public void setAffectationId(Long affectationId) { this.affectationId = affectationId; }
    public Long getSalleId() { return salleId; }
    public void setSalleId(Long salleId) { this.salleId = salleId; }
    public Integer getJourSemaine() { return jourSemaine; }
    public void setJourSemaine(Integer jourSemaine) { this.jourSemaine = jourSemaine; }
    public LocalTime getHeureDebut() { return heureDebut; }
    public void setHeureDebut(LocalTime heureDebut) { this.heureDebut = heureDebut; }
    public LocalTime getHeureFin() { return heureFin; }
    public void setHeureFin(LocalTime heureFin) { this.heureFin = heureFin; }
    public LocalDate getDateDebutValidite() { return dateDebutValidite; }
    public void setDateDebutValidite(LocalDate dateDebutValidite) { this.dateDebutValidite = dateDebutValidite; }
    public LocalDate getDateFinValidite() { return dateFinValidite; }
    public void setDateFinValidite(LocalDate dateFinValidite) { this.dateFinValidite = dateFinValidite; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}