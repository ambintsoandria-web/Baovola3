package Model.Etudiant;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class evenements_instances {
    private Integer id;
    private Integer evenementId;
    private Integer anneeScolaireId;
    private annees_scolaires anneeScolaire;
    private Integer classeId;
    private classes classe;
    private LocalDate dateDebut;
    private LocalDate dateFin;
    private LocalTime heureDebut;
    private LocalTime heureFin;
    private Integer salleId;
    private salles salle;
    private String lieuExterne;
    private String statut;
    private String notes;
    private Integer creePar;
    private Users creeParUser;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public evenements_instances() {
    }

    public evenements_instances(Integer id, Integer evenementId, Integer anneeScolaireId, annees_scolaires anneeScolaire,
                                Integer classeId, classes classe, LocalDate dateDebut, LocalDate dateFin,
                                LocalTime heureDebut, LocalTime heureFin, Integer salleId, salles salle,
                                String lieuExterne, String statut, String notes, Integer creePar, Users creeParUser,
                                LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.evenementId = evenementId;
        this.anneeScolaireId = anneeScolaireId;
        this.anneeScolaire = anneeScolaire;
        this.classeId = classeId;
        this.classe = classe;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.heureDebut = heureDebut;
        this.heureFin = heureFin;
        this.salleId = salleId;
        this.salle = salle;
        this.lieuExterne = lieuExterne;
        this.statut = statut;
        this.notes = notes;
        this.creePar = creePar;
        this.creeParUser = creeParUser;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEvenementId() {
        return evenementId;
    }

    public void setEvenementId(Integer evenementId) {
        this.evenementId = evenementId;
    }

    public Integer getAnneeScolaireId() {
        return anneeScolaireId;
    }

    public void setAnneeScolaireId(Integer anneeScolaireId) {
        this.anneeScolaireId = anneeScolaireId;
    }

    public annees_scolaires getAnneeScolaire() {
        return anneeScolaire;
    }

    public void setAnneeScolaire(annees_scolaires anneeScolaire) {
        this.anneeScolaire = anneeScolaire;
    }

    public Integer getClasseId() {
        return classeId;
    }

    public void setClasseId(Integer classeId) {
        this.classeId = classeId;
    }

    public classes getClasse() {
        return classe;
    }

    public void setClasse(classes classe) {
        this.classe = classe;
    }

    public LocalDate getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(LocalDate dateDebut) {
        this.dateDebut = dateDebut;
    }

    public LocalDate getDateFin() {
        return dateFin;
    }

    public void setDateFin(LocalDate dateFin) {
        this.dateFin = dateFin;
    }

    public LocalTime getHeureDebut() {
        return heureDebut;
    }

    public void setHeureDebut(LocalTime heureDebut) {
        this.heureDebut = heureDebut;
    }

    public LocalTime getHeureFin() {
        return heureFin;
    }

    public void setHeureFin(LocalTime heureFin) {
        this.heureFin = heureFin;
    }

    public Integer getSalleId() {
        return salleId;
    }

    public void setSalleId(Integer salleId) {
        this.salleId = salleId;
    }

    public salles getSalle() {
        return salle;
    }

    public void setSalle(salles salle) {
        this.salle = salle;
    }

    public String getLieuExterne() {
        return lieuExterne;
    }

    public void setLieuExterne(String lieuExterne) {
        this.lieuExterne = lieuExterne;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
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

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
