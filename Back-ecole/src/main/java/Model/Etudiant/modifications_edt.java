package Model.Etudiant;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;

public class modifications_edt {
    private Integer id;
    private Integer emploiDuTempsId;
    private horaire_edt emploiDuTemps;
    private LocalDate dateConcernee;
    private String portee;
    private String typeModification;
    private String motif;
    private Integer nouvelleSalleId;
    private salles nouvelleSalle;
    private LocalTime nouvelleHeureDebut;
    private LocalTime nouvelleHeureFin;
    private Integer remplacantId;
    private profils_professeurs remplacant;
    private Integer creePar;
    private Users creeParUser;
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
