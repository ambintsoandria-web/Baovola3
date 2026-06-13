package com.ecole.Model.Etudiant;

import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.*;

@Entity
@Table(name = "bulletins")
public class bulletins {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    private profils_etudiants etudiant;

    @ManyToOne
    private inscriptions inscription;

    @ManyToOne
    private periodes periode;

    @Column(name = "libelle_periode", length = 100)
    private String libellePeriode;

    @Column(name = "annee_scolaire", length = 50)
    private String anneeScolaire;

    @Column(name = "etablissement", length = 255)
    private String etablissement;

    @Column(name = "appreciation", columnDefinition = "TEXT")
    private String appreciation;

    @Column(name = "moyenne_generale")
    private Double moyenneGenerale;

    @Column(name = "rang")
    private Integer rang;

    @Column(name = "effectif_classe")
    private Integer effectifClasse;

    @Transient
    private List<moyennes> lignesMoyennes = new ArrayList<>();

    public bulletins() {
    }

    public bulletins(Integer id, profils_etudiants etudiant, inscriptions inscription, periodes periode,
                     String libellePeriode, String anneeScolaire, String etablissement, String appreciation,
                     Double moyenneGenerale, Integer rang, Integer effectifClasse, List<moyennes> lignesMoyennes) {
        this.id = id;
        this.etudiant = etudiant;
        this.inscription = inscription;
        this.periode = periode;
        this.libellePeriode = libellePeriode;
        this.anneeScolaire = anneeScolaire;
        this.etablissement = etablissement;
        this.appreciation = appreciation;
        this.moyenneGenerale = moyenneGenerale;
        this.rang = rang;
        this.effectifClasse = effectifClasse;
        this.lignesMoyennes = lignesMoyennes != null ? lignesMoyennes : new ArrayList<>();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public profils_etudiants getEtudiant() {
        return etudiant;
    }

    public void setEtudiant(profils_etudiants etudiant) {
        this.etudiant = etudiant;
    }

    public inscriptions getInscription() {
        return inscription;
    }

    public void setInscription(inscriptions inscription) {
        this.inscription = inscription;
    }

    public periodes getPeriode() {
        return periode;
    }

    public void setPeriode(periodes periode) {
        this.periode = periode;
    }

    public String getLibellePeriode() {
        return libellePeriode;
    }

    public void setLibellePeriode(String libellePeriode) {
        this.libellePeriode = libellePeriode;
    }

    public String getAnneeScolaire() {
        return anneeScolaire;
    }

    public void setAnneeScolaire(String anneeScolaire) {
        this.anneeScolaire = anneeScolaire;
    }

    public String getEtablissement() {
        return etablissement;
    }

    public void setEtablissement(String etablissement) {
        this.etablissement = etablissement;
    }

    public String getAppreciation() {
        return appreciation;
    }

    public void setAppreciation(String appreciation) {
        this.appreciation = appreciation;
    }

    public Double getMoyenneGenerale() {
        return moyenneGenerale;
    }

    public void setMoyenneGenerale(Double moyenneGenerale) {
        this.moyenneGenerale = moyenneGenerale;
    }

    public Integer getRang() {
        return rang;
    }

    public void setRang(Integer rang) {
        this.rang = rang;
    }

    public Integer getEffectifClasse() {
        return effectifClasse;
    }

    public void setEffectifClasse(Integer effectifClasse) {
        this.effectifClasse = effectifClasse;
    }

    public List<moyennes> getLignesMoyennes() {
        return lignesMoyennes;
    }

    public void setLignesMoyennes(List<moyennes> lignesMoyennes) {
        this.lignesMoyennes = lignesMoyennes != null ? lignesMoyennes : new ArrayList<>();
    }
}
