package com.ecole.Model.Etudiant;

import java.time.LocalDate;
import java.time.LocalDateTime;
import jakarta.persistence.*;

@Entity
@Table(name = "profils_professeurs")
public class profils_professeurs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "user_id", unique = true)
    private Integer userId;

    @ManyToOne
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private Users user;

    @Column(name = "matricule", length = 100, unique = true, nullable = false)
    private String matricule;

    @Column(name = "nom", length = 150, nullable = false)
    private String nom;

    @Column(name = "prenom", length = 150, nullable = false)
    private String prenom;

    @Column(name = "date_naissance")
    private LocalDate dateNaissance;

    @Column(name = "sexe", length = 1)
    private String sexe;

    @Column(name = "photo_url", length = 500)
    private String photoUrl;

    @Column(name = "telephone", length = 50)
    private String telephone;

    @Column(name = "adresse", columnDefinition = "TEXT")
    private String adresse;

    @Column(name = "specialite", length = 200)
    private String specialite;

    @Column(name = "type_contrat", length = 50)
    private String typeContrat;

    @Column(name = "date_debut_contrat")
    private LocalDate dateDebutContrat;

    @Column(name = "date_fin_contrat")
    private LocalDate dateFinContrat;

    @Column(name = "is_archived")
    private Boolean archived;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    public profils_professeurs() {
    }

    public profils_professeurs(Integer id, Integer userId, Users user, String matricule, String nom, String prenom,
                               LocalDate dateNaissance, String sexe, String photoUrl, String telephone,
                               String adresse, String specialite, String typeContrat, LocalDate dateDebutContrat,
                               LocalDate dateFinContrat, Boolean archived, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.userId = userId;
        this.user = user;
        this.matricule = matricule;
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.sexe = sexe;
        this.photoUrl = photoUrl;
        this.telephone = telephone;
        this.adresse = adresse;
        this.specialite = specialite;
        this.typeContrat = typeContrat;
        this.dateDebutContrat = dateDebutContrat;
        this.dateFinContrat = dateFinContrat;
        this.archived = archived;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public LocalDate getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(LocalDate dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getSpecialite() {
        return specialite;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }

    public String getTypeContrat() {
        return typeContrat;
    }

    public void setTypeContrat(String typeContrat) {
        this.typeContrat = typeContrat;
    }

    public LocalDate getDateDebutContrat() {
        return dateDebutContrat;
    }

    public void setDateDebutContrat(LocalDate dateDebutContrat) {
        this.dateDebutContrat = dateDebutContrat;
    }

    public LocalDate getDateFinContrat() {
        return dateFinContrat;
    }

    public void setDateFinContrat(LocalDate dateFinContrat) {
        this.dateFinContrat = dateFinContrat;
    }

    public Boolean getArchived() {
        return archived;
    }

    public void setArchived(Boolean archived) {
        this.archived = archived;
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
