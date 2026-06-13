package Model.Etudiant;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class echeanciers {
    private Integer id;
    private Integer inscriptionId;
    private inscriptions inscription;
    private Integer grilleId;
    private String type;
    private BigDecimal montantTotal;
    private LocalDateTime createdAt;

    public echeanciers() {
    }

    public echeanciers(Integer id, Integer inscriptionId, inscriptions inscription, Integer grilleId, String type,
                       BigDecimal montantTotal, LocalDateTime createdAt) {
        this.id = id;
        this.inscriptionId = inscriptionId;
        this.inscription = inscription;
        this.grilleId = grilleId;
        this.type = type;
        this.montantTotal = montantTotal;
        this.createdAt = createdAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getGrilleId() {
        return grilleId;
    }

    public void setGrilleId(Integer grilleId) {
        this.grilleId = grilleId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public BigDecimal getMontantTotal() {
        return montantTotal;
    }

    public void setMontantTotal(BigDecimal montantTotal) {
        this.montantTotal = montantTotal;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
