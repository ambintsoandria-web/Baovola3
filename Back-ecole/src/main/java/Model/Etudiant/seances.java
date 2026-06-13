package Model.Etudiant;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import jakarta.persistence.*;

@Entity
@Table(name = "seances")
public class seances {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "emploi_du_temps_id")
    private Integer emploiDuTempsId;

    @ManyToOne
    @JoinColumn(name = "emploi_du_temps_id", insertable = false, updatable = false)
    private horaire_edt emploiDuTemps;

    @Column(name = "date_seance", nullable = false)
    private LocalDate dateSeance;

    @Column(name = "heure_debut")
    private LocalTime heureDebut;

    @Column(name = "heure_fin")
    private LocalTime heureFin;

    @Column(name = "a_eu_lieu")
    private Boolean euLieu;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    public seances() {
    }

    public seances(Integer id, Integer emploiDuTempsId, horaire_edt emploiDuTemps, LocalDate dateSeance,
                   LocalTime heureDebut, LocalTime heureFin, Boolean euLieu, LocalDateTime createdAt) {
        this.id = id;
        this.emploiDuTempsId = emploiDuTempsId;
        this.emploiDuTemps = emploiDuTemps;
        this.dateSeance = dateSeance;
        this.heureDebut = heureDebut;
        this.heureFin = heureFin;
        this.euLieu = euLieu;
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

    public LocalDate getDateSeance() {
        return dateSeance;
    }

    public void setDateSeance(LocalDate dateSeance) {
        this.dateSeance = dateSeance;
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

    public Boolean getEuLieu() {
        return euLieu;
    }

    public void setEuLieu(Boolean euLieu) {
        this.euLieu = euLieu;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
