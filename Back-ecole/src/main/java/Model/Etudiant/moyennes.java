package Model.Etudiant;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import jakarta.persistence.*;

@Entity
@Table(name = "moyennes")
public class moyennes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "etudiant_id")
    private Integer etudiantId;

    @ManyToOne
    @JoinColumn(name = "etudiant_id", insertable = false, updatable = false)
    private profils_etudiants etudiant;

    @Column(name = "inscription_id")
    private Integer inscriptionId;

    @ManyToOne
    @JoinColumn(name = "inscription_id", insertable = false, updatable = false)
    private inscriptions inscription;

    @Column(name = "periode_id")
    private Integer periodeId;

    @ManyToOne
    @JoinColumn(name = "periode_id", insertable = false, updatable = false)
    private periodes periode;

    @Column(name = "matiere_id")
    private Integer matiereId;

    @ManyToOne
    @JoinColumn(name = "matiere_id", insertable = false, updatable = false)
    private matieres matiere;

    @Column(name = "valeur", precision = 5, scale = 2)
    private BigDecimal valeur;

    @Column(name = "rang")
    private Integer rang;

    @Column(name = "effectif_classe")
    private Integer effectifClasse;

    @Column(name = "calculated_at")
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
