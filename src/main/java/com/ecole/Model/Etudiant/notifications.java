package com.ecole.Model.Etudiant;

import java.time.LocalDateTime;
import jakarta.persistence.*;

@Entity
@Table(name = "notifications")
public class notifications {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "user_id")
    private Integer userId;

    @ManyToOne
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private Users user;

    @Column(name = "type_id")
    private Integer typeId;

    @Column(name = "titre", length = 255)
    private String titre;

    @Column(name = "message", columnDefinition = "TEXT")
    private String message;

    @Column(name = "lien_action", length = 500)
    private String lienAction;

    @Column(name = "lu")
    private Boolean lu;

    @Column(name = "date_lecture")
    private LocalDateTime dateLecture;

    @Column(name = "entite_type", length = 100)
    private String entiteType;

    @Column(name = "entite_id")
    private Integer entiteId;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    public notifications() {
    }

    public notifications(Integer id, Integer userId, Users user, Integer typeId, String titre, String message,
                         String lienAction, Boolean lu, LocalDateTime dateLecture, String entiteType,
                         Integer entiteId, LocalDateTime createdAt) {
        this.id = id;
        this.userId = userId;
        this.user = user;
        this.typeId = typeId;
        this.titre = titre;
        this.message = message;
        this.lienAction = lienAction;
        this.lu = lu;
        this.dateLecture = dateLecture;
        this.entiteType = entiteType;
        this.entiteId = entiteId;
        this.createdAt = createdAt;
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

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getLienAction() {
        return lienAction;
    }

    public void setLienAction(String lienAction) {
        this.lienAction = lienAction;
    }

    public Boolean getLu() {
        return lu;
    }

    public void setLu(Boolean lu) {
        this.lu = lu;
    }

    public LocalDateTime getDateLecture() {
        return dateLecture;
    }

    public void setDateLecture(LocalDateTime dateLecture) {
        this.dateLecture = dateLecture;
    }

    public String getEntiteType() {
        return entiteType;
    }

    public void setEntiteType(String entiteType) {
        this.entiteType = entiteType;
    }

    public Integer getEntiteId() {
        return entiteId;
    }

    public void setEntiteId(Integer entiteId) {
        this.entiteId = entiteId;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
