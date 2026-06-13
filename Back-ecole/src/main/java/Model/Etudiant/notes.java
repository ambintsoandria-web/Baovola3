package Model.Etudiant;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import jakarta.persistence.*;

@Entity
@Table(name = "notes")
public class notes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "etudiant_id")
    private Integer etudiantId;

    @ManyToOne
    @JoinColumn(name = "etudiant_id", insertable = false, updatable = false)
    private profils_etudiants etudiant;

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

    @Column(name = "type_evaluation", length = 100)
    private String typeEvaluation;

    @Column(name = "valeur", precision = 5, scale = 2, nullable = false)
    private BigDecimal valeur;

    @Column(name = "sur", precision = 5, scale = 2)
    private BigDecimal sur;

    @Column(name = "commentaire", columnDefinition = "TEXT")
    private String commentaire;

    @Column(name = "saisi_par")
    private Integer saisiPar;

    @ManyToOne
    @JoinColumn(name = "saisi_par", insertable = false, updatable = false)
    private Users saisiParUser;

    @Column(name = "date_saisie")
    private LocalDateTime dateSaisie;

    @Column(name = "est_valide")
    private Boolean valide;

    @Column(name = "ancienne_valeur", precision = 5, scale = 2)
    private BigDecimal ancienneValeur;

    @Column(name = "corrige_par")
    private Integer corrigePar;

    @ManyToOne
    @JoinColumn(name = "corrige_par", insertable = false, updatable = false)
    private Users corrigeParUser;

    @Column(name = "date_correction")
    private LocalDateTime dateCorrection;

    @Column(name = "motif_correction", columnDefinition = "TEXT")
    private String motifCorrection;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    public notes() {
    }

    public notes(Integer id, Integer etudiantId, profils_etudiants etudiant, Integer affectationId,
                 affectations_enseignement affectation, Integer periodeId, periodes periode, String typeEvaluation,
                 BigDecimal valeur, BigDecimal sur, String commentaire, Integer saisiPar, Users saisiParUser,
                 LocalDateTime dateSaisie, Boolean valide, BigDecimal ancienneValeur, Integer corrigePar,
                 Users corrigeParUser, LocalDateTime dateCorrection, String motifCorrection,
                 LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.etudiantId = etudiantId;
        this.etudiant = etudiant;
        this.affectationId = affectationId;
        this.affectation = affectation;
        this.periodeId = periodeId;
        this.periode = periode;
        this.typeEvaluation = typeEvaluation;
        this.valeur = valeur;
        this.sur = sur;
        this.commentaire = commentaire;
        this.saisiPar = saisiPar;
        this.saisiParUser = saisiParUser;
        this.dateSaisie = dateSaisie;
        this.valide = valide;
        this.ancienneValeur = ancienneValeur;
        this.corrigePar = corrigePar;
        this.corrigeParUser = corrigeParUser;
        this.dateCorrection = dateCorrection;
        this.motifCorrection = motifCorrection;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
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

    public String getTypeEvaluation() {
        return typeEvaluation;
    }

    public void setTypeEvaluation(String typeEvaluation) {
        this.typeEvaluation = typeEvaluation;
    }

    public BigDecimal getValeur() {
        return valeur;
    }

    public void setValeur(BigDecimal valeur) {
        this.valeur = valeur;
    }

    public BigDecimal getSur() {
        return sur;
    }

    public void setSur(BigDecimal sur) {
        this.sur = sur;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
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

    public LocalDateTime getDateSaisie() {
        return dateSaisie;
    }

    public void setDateSaisie(LocalDateTime dateSaisie) {
        this.dateSaisie = dateSaisie;
    }

    public Boolean getValide() {
        return valide;
    }

    public void setValide(Boolean valide) {
        this.valide = valide;
    }

    public BigDecimal getAncienneValeur() {
        return ancienneValeur;
    }

    public void setAncienneValeur(BigDecimal ancienneValeur) {
        this.ancienneValeur = ancienneValeur;
    }

    public Integer getCorrigePar() {
        return corrigePar;
    }

    public void setCorrigePar(Integer corrigePar) {
        this.corrigePar = corrigePar;
    }

    public Users getCorrigeParUser() {
        return corrigeParUser;
    }

    public void setCorrigeParUser(Users corrigeParUser) {
        this.corrigeParUser = corrigeParUser;
    }

    public LocalDateTime getDateCorrection() {
        return dateCorrection;
    }

    public void setDateCorrection(LocalDateTime dateCorrection) {
        this.dateCorrection = dateCorrection;
    }

    public String getMotifCorrection() {
        return motifCorrection;
    }

    public void setMotifCorrection(String motifCorrection) {
        this.motifCorrection = motifCorrection;
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
