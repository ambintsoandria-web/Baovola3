package Model.Etudiant;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class moyennes {
    private Integer id;
    private Integer etudiantId;
    private profils_etudiants etudiant;
    private Integer inscriptionId;
    private inscriptions inscription;
    private Integer periodeId;
    private periodes periode;
    private Integer matiereId;
    private matieres matiere;
    private BigDecimal valeur;
    private Integer rang;
    private Integer effectifClasse;
    private LocalDateTime calculatedAt;

    public moyennes() {
    }

    public moyennes(Integer id, Integer etudiantId, profils_etudiants etudiant, Integer inscriptionId,
                    inscriptions inscription, Integer periodeId, periodes periode, Integer matiereId,
                    matieres matiere, BigDecimal valeur, Integer rang, Integer effectifClasse, LocalDateTime calculatedAt) {
        this.id = id;
        this.etudiantId = etudiantId;
        this.etudiant = etudiant;
        this.inscriptionId = inscriptionId;
        this.inscription = inscription;
        this.periodeId = periodeId;
        this.periode = periode;
        this.matiereId = matiereId;
        this.matiere = matiere;
        this.valeur = valeur;
        this.rang = rang;
        this.effectifClasse = effectifClasse;
        this.calculatedAt = calculatedAt;
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

    public Integer getInscriptionId() {
        return inscriptionId;
    }

    public void setInscriptionId(Integer inscriptionId) {
        this.inscriptionId = inscriptionId;
    }

    public inscriptions getInscription() {
        return inscription;
    }

    public void setInscription(inscriptions inscription) {
        this.inscription = inscription;
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

    public BigDecimal getValeur() {
        return valeur;
    }

    public void setValeur(BigDecimal valeur) {
        this.valeur = valeur;
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

    public LocalDateTime getCalculatedAt() {
        return calculatedAt;
    }

    public void setCalculatedAt(LocalDateTime calculatedAt) {
        this.calculatedAt = calculatedAt;
    }
}
