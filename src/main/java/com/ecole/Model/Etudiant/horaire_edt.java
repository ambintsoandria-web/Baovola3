package com.ecole.Model.Etudiant;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import jakarta.persistence.*;

@Entity
@Table(name = "horaire_edt")
public class horaire_edt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "affectation_id")
    private Integer affectationId;

    @ManyToOne
    @JoinColumn(name = "affectation_id", insertable = false, updatable = false)
    private affectations_enseignement affectation;

    @Column(name = "salle_id")
    private Integer salleId;

    @ManyToOne
    @JoinColumn(name = "salle_id", insertable = false, updatable = false)
    private salles salle;

    @Column(name = "jour_semaine", nullable = false)
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

    public horaire_edt() {
    }

    public horaire_edt(Integer id, Integer affectationId, affectations_enseignement affectation, Integer salleId,
                       salles salle, Integer jourSemaine, LocalTime heureDebut, LocalTime heureFin,
                       LocalDate dateDebutValidite, LocalDate dateFinValidite, LocalDateTime createdAt) {
        this.id = id;
        this.affectationId = affectationId;
        this.affectation = affectation;
        this.salleId = salleId;
        this.salle = salle;
        this.jourSemaine = jourSemaine;
        this.heureDebut = heureDebut;
        this.heureFin = heureFin;
        this.dateDebutValidite = dateDebutValidite;
        this.dateFinValidite = dateFinValidite;
        this.createdAt = createdAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAffectationId() {
        return affectationId;
    }

    public void setAffectationId(Integer affectationId) {
        this.affectationId = affectationId;
    }

    public affectations_enseignement getAffectation() {
        return affectation;
    }

    public void setAffectation(affectations_enseignement affectation) {
        this.affectation = affectation;
    }

    public Integer getSalleId() {
        return salleId;
    }

    public void setSalleId(Integer salleId) {
        this.salleId = salleId;
    }

    public salles getSalle() {
        return salle;
    }

    public void setSalle(salles salle) {
        this.salle = salle;
    }

    public Integer getJourSemaine() {
        return jourSemaine;
    }

    public void setJourSemaine(Integer jourSemaine) {
        this.jourSemaine = jourSemaine;
    }

    public LocalTime getHeureDebut() {
        return heureDebut;
    }

    public void setHeureDebut(LocalTime heureDebut) {
        this.heureDebut = heureDebut;
    }

    public LocalTime getHeureFin() {
        return heureFin;
    }

    public void setHeureFin(LocalTime heureFin) {
        this.heureFin = heureFin;
    }

    public LocalDate getDateDebutValidite() {
        return dateDebutValidite;
    }

    public void setDateDebutValidite(LocalDate dateDebutValidite) {
        this.dateDebutValidite = dateDebutValidite;
    }

    public LocalDate getDateFinValidite() {
        return dateFinValidite;
    }

    public void setDateFinValidite(LocalDate dateFinValidite) {
        this.dateFinValidite = dateFinValidite;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
