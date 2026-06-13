package Model.Etudiant;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class inscriptions {
    private Integer id;
    private Integer etudiantId;
    private profils_etudiants etudiant;
    private Integer classeId;
    private classes classe;
    private Integer anneeScolaireId;
    private annees_scolaires anneeScolaire;
    private String typeInscription;
    private LocalDate dateInscription;
    private String statut;
    private Integer rangFinal;
    private Boolean admis;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public inscriptions() {
    }

    public inscriptions(Integer id, Integer etudiantId, profils_etudiants etudiant, Integer classeId, classes classe,
                        Integer anneeScolaireId, annees_scolaires anneeScolaire, String typeInscription,
                        LocalDate dateInscription, String statut, Integer rangFinal, Boolean admis,
                        LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.etudiantId = etudiantId;
        this.etudiant = etudiant;
        this.classeId = classeId;
        this.classe = classe;
        this.anneeScolaireId = anneeScolaireId;
        this.anneeScolaire = anneeScolaire;
        this.typeInscription = typeInscription;
        this.dateInscription = dateInscription;
        this.statut = statut;
        this.rangFinal = rangFinal;
        this.admis = admis;
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

    public String getTypeInscription() {
        return typeInscription;
    }

    public void setTypeInscription(String typeInscription) {
        this.typeInscription = typeInscription;
    }

    public LocalDate getDateInscription() {
        return dateInscription;
    }

    public void setDateInscription(LocalDate dateInscription) {
        this.dateInscription = dateInscription;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public Integer getRangFinal() {
        return rangFinal;
    }

    public void setRangFinal(Integer rangFinal) {
        this.rangFinal = rangFinal;
    }

    public Boolean getAdmis() {
        return admis;
    }

    public void setAdmis(Boolean admis) {
        this.admis = admis;
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
