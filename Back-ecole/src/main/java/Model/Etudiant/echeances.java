package Model.Etudiant;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class echeances {
    private Integer id;
    private Integer echeancierId;
    private echeanciers echeancier;
    private Integer numeroTranche;
    private BigDecimal montantAttendu;
    private LocalDate dateLimite;
    private Boolean soldee;
    private LocalDateTime createdAt;

    public echeances() {
    }

    public echeances(Integer id, Integer echeancierId, echeanciers echeancier, Integer numeroTranche,
                     BigDecimal montantAttendu, LocalDate dateLimite, Boolean soldee, LocalDateTime createdAt) {
        this.id = id;
        this.echeancierId = echeancierId;
        this.echeancier = echeancier;
        this.numeroTranche = numeroTranche;
        this.montantAttendu = montantAttendu;
        this.dateLimite = dateLimite;
        this.soldee = soldee;
        this.createdAt = createdAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEcheancierId() {
        return echeancierId;
    }

    public void setEcheancierId(Integer echeancierId) {
        this.echeancierId = echeancierId;
    }

    public echeanciers getEcheancier() {
        return echeancier;
    }

    public void setEcheancier(echeanciers echeancier) {
        this.echeancier = echeancier;
    }

    public Integer getNumeroTranche() {
        return numeroTranche;
    }

    public void setNumeroTranche(Integer numeroTranche) {
        this.numeroTranche = numeroTranche;
    }

    public BigDecimal getMontantAttendu() {
        return montantAttendu;
    }

    public void setMontantAttendu(BigDecimal montantAttendu) {
        this.montantAttendu = montantAttendu;
    }

    public LocalDate getDateLimite() {
        return dateLimite;
    }

    public void setDateLimite(LocalDate dateLimite) {
        this.dateLimite = dateLimite;
    }

    public Boolean getSoldee() {
        return soldee;
    }

    public void setSoldee(Boolean soldee) {
        this.soldee = soldee;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
