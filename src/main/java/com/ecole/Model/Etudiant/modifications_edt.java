package com.ecole.Model.Etudiant;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;
import jakarta.persistence.*;

@Entity
@Table(name = "modifications_edt")
public class modifications_edt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "emploi_du_temps_id")
    private Integer emploiDuTempsId;

    @ManyToOne
    @JoinColumn(name = "emploi_du_temps_id", insertable = false, updatable = false)
    private horaire_edt emploiDuTemps;

    @Column(name = "date_concernee", nullable = false)
    private LocalDate dateConcernee;

    @Column(name = "portee", length = 20)
    private String portee;

    @Column(name = "type_modification", length = 50, nullable = false)
    private String typeModification;

    @Column(name = "motif", length = 500)
    private String motif;

    @Column(name = "nouvelle_salle_id")
    private Integer nouvelleSalleId;

    @ManyToOne
    @JoinColumn(name = "nouvelle_salle_id", insertable = false, updatable = false)
    private salles nouvelleSalle;

    @Column(name = "nouvelle_heure_debut")
    private LocalTime nouvelleHeureDebut;

    @Column(name = "nouvelle_heure_fin")
    private LocalTime nouvelleHeureFin;

    @Column(name = "remplacant_id")
    private Integer remplacantId;

    @ManyToOne
    @JoinColumn(name = "remplacant_id", insertable = false, updatable = false)
    private profils_professeurs remplacant;

    @Column(name = "cree_par")
    private Integer creePar;

    @ManyToOne
    @JoinColumn(name = "cree_par", insertable = false, updatable = false)
    private Users creeParUser;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    public modifications_edt() {
    }

    public modifications_edt(Integer id, Integer emploiDuTempsId, horaire_edt emploiDuTemps, LocalDate dateConcernee,
                             String portee, String typeModification, String motif, Integer nouvelleSalleId,
                             salles nouvelleSalle, LocalTime nouvelleHeureDebut, LocalTime nouvelleHeureFin,
                             Integer remplacantId, profils_professeurs remplacant, Integer creePar,
                             Users creeParUser, LocalDateTime createdAt) {
        this.id = id;
        this.emploiDuTempsId = emploiDuTempsId;
        this.emploiDuTemps = emploiDuTemps;
        this.dateConcernee = dateConcernee;
        this.portee = portee;
        this.typeModification = typeModification;
        this.motif = motif;
        this.nouvelleSalleId = nouvelleSalleId;
        this.nouvelleSalle = nouvelleSalle;
        this.nouvelleHeureDebut = nouvelleHeureDebut;
        this.nouvelleHeureFin = nouvelleHeureFin;
        this.remplacantId = remplacantId;
        this.remplacant = remplacant;
        this.creePar = creePar;
        this.creeParUser = creeParUser;
        this.createdAt = createdAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEmploiDuTempsId() {
        return emploiDuTempsId;
    }

    public void setEmploiDuTempsId(Integer emploiDuTempsId) {
        this.emploiDuTempsId = emploiDuTempsId;
    }

    public horaire_edt getEmploiDuTemps() {
        return emploiDuTemps;
    }

    public void setEmploiDuTemps(horaire_edt emploiDuTemps) {
        this.emploiDuTemps = emploiDuTemps;
    }

    public LocalDate getDateConcernee() {
        return dateConcernee;
    }

    public void setDateConcernee(LocalDate dateConcernee) {
        this.dateConcernee = dateConcernee;
    }

    public String getPortee() {
        return portee;
    }

    public void setPortee(String portee) {
        this.portee = portee;
    }

    public String getTypeModification() {
        return typeModification;
    }

    public void setTypeModification(String typeModification) {
        this.typeModification = typeModification;
    }

    public String getMotif() {
        return motif;
    }

    public void setMotif(String motif) {
        this.motif = motif;
    }

    public Integer getNouvelleSalleId() {
        return nouvelleSalleId;
    }

    public void setNouvelleSalleId(Integer nouvelleSalleId) {
        this.nouvelleSalleId = nouvelleSalleId;
    }

    public salles getNouvelleSalle() {
        return nouvelleSalle;
    }

    public void setNouvelleSalle(salles nouvelleSalle) {
        this.nouvelleSalle = nouvelleSalle;
    }

    public LocalTime getNouvelleHeureDebut() {
        return nouvelleHeureDebut;
    }

    public void setNouvelleHeureDebut(LocalTime nouvelleHeureDebut) {
        this.nouvelleHeureDebut = nouvelleHeureDebut;
    }

    public LocalTime getNouvelleHeureFin() {
        return nouvelleHeureFin;
    }

    public void setNouvelleHeureFin(LocalTime nouvelleHeureFin) {
        this.nouvelleHeureFin = nouvelleHeureFin;
    }

    public Integer getRemplacantId() {
        return remplacantId;
    }

    public void setRemplacantId(Integer remplacantId) {
        this.remplacantId = remplacantId;
    }

    public profils_professeurs getRemplacant() {
        return remplacant;
    }

    public void setRemplacant(profils_professeurs remplacant) {
        this.remplacant = remplacant;
    }

    public Integer getCreePar() {
        return creePar;
    }

    public void setCreePar(Integer creePar) {
        this.creePar = creePar;
    }

    public Users getCreeParUser() {
        return creeParUser;
    }

    public void setCreeParUser(Users creeParUser) {
        this.creeParUser = creeParUser;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
