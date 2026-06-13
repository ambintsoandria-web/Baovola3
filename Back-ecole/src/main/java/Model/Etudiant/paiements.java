package Model.Etudiant;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class paiements {
    private Integer id;
    private Integer echeanceId;
    private echeances echeance;
    private Integer inscriptionId;
    private inscriptions inscription;
    private BigDecimal montant;
    private LocalDate datePaiement;
    private String modePaiement;
    private String referenceTransaction;
    private Integer saisiPar;
    private Users saisiParUser;
    private String notes;
    private LocalDateTime createdAt;

    public paiements() {
    }

    public paiements(Integer id, Integer echeanceId, echeances echeance, Integer inscriptionId, inscriptions inscription,
                     BigDecimal montant, LocalDate datePaiement, String modePaiement, String referenceTransaction,
                     Integer saisiPar, Users saisiParUser, String notes, LocalDateTime createdAt) {
        this.id = id;
        this.echeanceId = echeanceId;
        this.echeance = echeance;
        this.inscriptionId = inscriptionId;
        this.inscription = inscription;
        this.montant = montant;
        this.datePaiement = datePaiement;
        this.modePaiement = modePaiement;
        this.referenceTransaction = referenceTransaction;
        this.saisiPar = saisiPar;
        this.saisiParUser = saisiParUser;
        this.notes = notes;
        this.createdAt = createdAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEcheanceId() {
        return echeanceId;
    }

    public void setEcheanceId(Integer echeanceId) {
        this.echeanceId = echeanceId;
    }

    public echeances getEcheance() {
        return echeance;
    }

    public void setEcheance(echeances echeance) {
        this.echeance = echeance;
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

    public BigDecimal getMontant() {
        return montant;
    }

    public void setMontant(BigDecimal montant) {
        this.montant = montant;
    }

    public LocalDate getDatePaiement() {
        return datePaiement;
    }

    public void setDatePaiement(LocalDate datePaiement) {
        this.datePaiement = datePaiement;
    }

    public String getModePaiement() {
        return modePaiement;
    }

    public void setModePaiement(String modePaiement) {
        this.modePaiement = modePaiement;
    }

    public String getReferenceTransaction() {
        return referenceTransaction;
    }

    public void setReferenceTransaction(String referenceTransaction) {
        this.referenceTransaction = referenceTransaction;
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

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
