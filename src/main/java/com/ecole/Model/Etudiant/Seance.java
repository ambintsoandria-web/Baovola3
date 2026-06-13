package com.ecole.Model.Etudiant;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "seances")
public class Seance {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "emploi_du_temps_id")
    private Long emploiDuTempsId;
    
    @Column(name = "date_seance")
    private LocalDate dateSeance;
    
    @Column(name = "heure_debut")
    private LocalTime heureDebut;
    
    @Column(name = "heure_fin")
    private LocalTime heureFin;
    
    @Column(name = "a_eu_lieu")
    private Boolean aEuLieu;
    
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    
    // Getters et Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getEmploiDuTempsId() { return emploiDuTempsId; }
    public void setEmploiDuTempsId(Long emploiDuTempsId) { this.emploiDuTempsId = emploiDuTempsId; }
    public LocalDate getDateSeance() { return dateSeance; }
    public void setDateSeance(LocalDate dateSeance) { this.dateSeance = dateSeance; }
    public LocalTime getHeureDebut() { return heureDebut; }
    public void setHeureDebut(LocalTime heureDebut) { this.heureDebut = heureDebut; }
    public LocalTime getHeureFin() { return heureFin; }
    public void setHeureFin(LocalTime heureFin) { this.heureFin = heureFin; }
    public Boolean getAEuLieu() { return aEuLieu; }
    public void setAEuLieu(Boolean aEuLieu) { this.aEuLieu = aEuLieu; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}