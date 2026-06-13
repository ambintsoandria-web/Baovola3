package Model.Etudiant;

import java.time.LocalDateTime;
import jakarta.persistence.*;

@Entity
@Table(name = "profils_parents")
public class profils_parents {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "user_id")
    private Integer userId;

    @ManyToOne
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private Users user;

    @Column(name = "nom", length = 150, nullable = false)
    private String nom;

    @Column(name = "prenom", length = 150, nullable = false)
    private String prenom;

    @Column(name = "telephone", length = 50)
    private String telephone;

    @Column(name = "email", length = 255)
    private String email;

    @Column(name = "profession", length = 200)
    private String profession;

    @Column(name = "lien_parente", length = 100)
    private String lienParente;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    public profils_parents() {
    }

    public profils_parents(Integer id, Integer userId, Users user, String nom, String prenom, String telephone,
                           String email, String profession, String lienParente, LocalDateTime createdAt) {
        this.id = id;
        this.userId = userId;
        this.user = user;
        this.nom = nom;
        this.prenom = prenom;
        this.telephone = telephone;
        this.email = email;
        this.profession = profession;
        this.lienParente = lienParente;
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

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getLienParente() {
        return lienParente;
    }

    public void setLienParente(String lienParente) {
        this.lienParente = lienParente;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
