package com.ecole.Model.Etudiant;

import java.time.LocalDate;
import java.time.LocalDateTime;
import jakarta.persistence.*;

@Entity
@Table(name = "devoirs")
public class devoirs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "affectation_id")
    private Integer affectationId;

    @ManyToOne
    @JoinColumn(name = "affectation_id", insertable = false, updatable = false)
    private affectations_enseignement affectation;

    @Column(name = "periode_id")
    private Integer periodeId;

    @ManyToOne
    @JoinColumn(name = "periode_id", insertable = false, updatable = false)
    private periodes periode;

    @Column(name = "titre", length = 255)
    private String titre;

    @Column(name = "consigne", columnDefinition = "TEXT")
    private String consigne;

    @Column(name = "date_publication")
    private LocalDate datePublication;

    @Column(name = "date_limite")
    private LocalDate dateLimite;

    @Column(name = "statut", length = 50)
    private String statut;

    @Column(name = "piece_jointe_url", length = 500)
    private String pieceJointeUrl;

    @Column(name = "saisi_par")
    private Integer saisiPar;

    @ManyToOne
    @JoinColumn(name = "saisi_par", insertable = false, updatable = false)
    private Users saisiParUser;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    public devoirs() {
    }

    public devoirs(Integer id, Integer affectationId, affectations_enseignement affectation, Integer periodeId,
            periodes periode, String titre, String consigne, LocalDate datePublication, LocalDate dateLimite,
            String statut, String pieceJointeUrl, Integer saisiPar, Users saisiParUser,
            LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.affectationId = affectationId;
        this.affectation = affectation;
        this.periodeId = periodeId;
        this.periode = periode;
        this.titre = titre;
        this.consigne = consigne;
        this.datePublication = datePublication;
        this.dateLimite = dateLimite;
        this.statut = statut;
        this.pieceJointeUrl = pieceJointeUrl;
        this.saisiPar = saisiPar;
        this.saisiParUser = saisiParUser;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
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

    public Integer getPeriodeId() {
        return periodeId;
    }

    public void setPeriodeId(Integer periodeId) {
        this.periodeId = periodeId;
    }

    public periodes getPeriode() {
        return periode;
    }

    public void setPeriode(periodes periode) {
        this.periode = periode;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getConsigne() {
        return consigne;
    }

    public void setConsigne(String consigne) {
        this.consigne = consigne;
    }

    public LocalDate getDatePublication() {
        return datePublication;
    }

    public void setDatePublication(LocalDate datePublication) {
        this.datePublication = datePublication;
    }

    public LocalDate getDateLimite() {
        return dateLimite;
    }

    public void setDateLimite(LocalDate dateLimite) {
        this.dateLimite = dateLimite;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public String getPieceJointeUrl() {
        return pieceJointeUrl;
    }

    public void setPieceJointeUrl(String pieceJointeUrl) {
        this.pieceJointeUrl = pieceJointeUrl;
    }

    public Integer getSaisiPar() {
        return saisiPar;
    }

    public void setSaisiPar(Integer saisiPar) {
        this.saisiPar = saisiPar;
    }

    public Users getSaisiParUser() {
        return saisiParUser;
    }

    public void setSaisiParUser(Users saisiParUser) {
        this.saisiParUser = saisiParUser;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
