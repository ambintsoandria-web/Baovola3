package com.ecole.Model.Etudiant;

import java.time.LocalDateTime;
import jakarta.persistence.*;

@Entity
@Table(name = "demandes_modification_dossier")
public class demandes_modification_dossier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "etudiant_id")
    private Integer etudiantId;

    @ManyToOne
    @JoinColumn(name = "etudiant_id", insertable = false, updatable = false)
    private profils_etudiants etudiant;

    @Column(name = "champ_modifie", length = 100)
    private String champModifie;

    @Column(name = "ancienne_valeur", columnDefinition = "TEXT")
    private String ancienneValeur;

    @Column(name = "nouvelle_valeur", columnDefinition = "TEXT")
    private String nouvelleValeur;

    @Column(name = "motif", columnDefinition = "TEXT")
    private String motif;

    @Column(name = "statut", length = 50)
    private String statut;

    @Column(name = "soumis_par")
    private Integer soumisPar;

    @ManyToOne
    @JoinColumn(name = "soumis_par", insertable = false, updatable = false)
    private Users soumisParUser;

    @Column(name = "traite_par")
    private Integer traitePar;

    @ManyToOne
    @JoinColumn(name = "traite_par", insertable = false, updatable = false)
    private Users traiteParUser;

    @Column(name = "date_traitement")
    private LocalDateTime dateTraitement;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    public demandes_modification_dossier() {
    }

    public demandes_modification_dossier(Integer id, Integer etudiantId, profils_etudiants etudiant, String champModifie,
                                         String ancienneValeur, String nouvelleValeur, String motif, String statut,
                                         Integer soumisPar, Users soumisParUser, Integer traitePar,
                                         Users traiteParUser, LocalDateTime dateTraitement, LocalDateTime createdAt) {
        this.id = id;
        this.etudiantId = etudiantId;
        this.etudiant = etudiant;
        this.champModifie = champModifie;
        this.ancienneValeur = ancienneValeur;
        this.nouvelleValeur = nouvelleValeur;
        this.motif = motif;
        this.statut = statut;
        this.soumisPar = soumisPar;
        this.soumisParUser = soumisParUser;
        this.traitePar = traitePar;
        this.traiteParUser = traiteParUser;
        this.dateTraitement = dateTraitement;
        this.createdAt = createdAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEtudiantId() {
        return etudiantId;
    }

    public void setEtudiantId(Integer etudiantId) {
        this.etudiantId = etudiantId;
    }

    public profils_etudiants getEtudiant() {
        return etudiant;
    }

    public void setEtudiant(profils_etudiants etudiant) {
        this.etudiant = etudiant;
    }

    public String getChampModifie() {
        return champModifie;
    }

    public void setChampModifie(String champModifie) {
        this.champModifie = champModifie;
    }

    public String getAncienneValeur() {
        return ancienneValeur;
    }

    public void setAncienneValeur(String ancienneValeur) {
        this.ancienneValeur = ancienneValeur;
    }

    public String getNouvelleValeur() {
        return nouvelleValeur;
    }

    public void setNouvelleValeur(String nouvelleValeur) {
        this.nouvelleValeur = nouvelleValeur;
    }

    public String getMotif() {
        return motif;
    }

    public void setMotif(String motif) {
        this.motif = motif;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public Integer getSoumisPar() {
        return soumisPar;
    }

    public void setSoumisPar(Integer soumisPar) {
        this.soumisPar = soumisPar;
    }

    public Users getSoumisParUser() {
        return soumisParUser;
    }

    public void setSoumisParUser(Users soumisParUser) {
        this.soumisParUser = soumisParUser;
    }

    public Integer getTraitePar() {
        return traitePar;
    }

    public void setTraitePar(Integer traitePar) {
        this.traitePar = traitePar;
    }

    public Users getTraiteParUser() {
        return traiteParUser;
    }

    public void setTraiteParUser(Users traiteParUser) {
        this.traiteParUser = traiteParUser;
    }

    public LocalDateTime getDateTraitement() {
        return dateTraitement;
    }

    public void setDateTraitement(LocalDateTime dateTraitement) {
        this.dateTraitement = dateTraitement;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
