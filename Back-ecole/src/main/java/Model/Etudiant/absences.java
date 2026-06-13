package Model.Etudiant;

import java.time.LocalDateTime;
import jakarta.persistence.*;

@Entity
@Table(name = "absences")
public class absences {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "seance_id")
    private Integer seanceId;

    @ManyToOne
    @JoinColumn(name = "seance_id", insertable = false, updatable = false)
    private seances seance;

    @Column(name = "etudiant_id")
    private Integer etudiantId;

    @ManyToOne
    @JoinColumn(name = "etudiant_id", insertable = false, updatable = false)
    private profils_etudiants etudiant;

    @Column(name = "type", length = 50)
    private String type;

    @Column(name = "motif", columnDefinition = "TEXT")
    private String motif;

    @Column(name = "justificatif_url", length = 500)
    private String justificatifUrl;

    @Column(name = "saisi_par")
    private Integer saisiPar;

    @ManyToOne
    @JoinColumn(name = "saisi_par", insertable = false, updatable = false)
    private Users saisiParUser;

    @Column(name = "valide_par")
    private Integer validePar;

    @ManyToOne
    @JoinColumn(name = "valide_par", insertable = false, updatable = false)
    private Users valideParUser;

    @Column(name = "date_validation")
    private LocalDateTime dateValidation;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    public absences() {
    }

    public absences(Integer id, Integer seanceId, seances seance, Integer etudiantId, profils_etudiants etudiant,
                    String type, String motif, String justificatifUrl, Integer saisiPar, Users saisiParUser,
                    Integer validePar, Users valideParUser, LocalDateTime dateValidation, LocalDateTime createdAt,
                    LocalDateTime updatedAt) {
        this.id = id;
        this.seanceId = seanceId;
        this.seance = seance;
        this.etudiantId = etudiantId;
        this.etudiant = etudiant;
        this.type = type;
        this.motif = motif;
        this.justificatifUrl = justificatifUrl;
        this.saisiPar = saisiPar;
        this.saisiParUser = saisiParUser;
        this.validePar = validePar;
        this.valideParUser = valideParUser;
        this.dateValidation = dateValidation;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSeanceId() {
        return seanceId;
    }

    public void setSeanceId(Integer seanceId) {
        this.seanceId = seanceId;
    }

    public seances getSeance() {
        return seance;
    }

    public void setSeance(seances seance) {
        this.seance = seance;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMotif() {
        return motif;
    }

    public void setMotif(String motif) {
        this.motif = motif;
    }

    public String getJustificatifUrl() {
        return justificatifUrl;
    }

    public void setJustificatifUrl(String justificatifUrl) {
        this.justificatifUrl = justificatifUrl;
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

    public Integer getValidePar() {
        return validePar;
    }

    public void setValidePar(Integer validePar) {
        this.validePar = validePar;
    }

    public Users getValideParUser() {
        return valideParUser;
    }

    public void setValideParUser(Users valideParUser) {
        this.valideParUser = valideParUser;
    }

    public LocalDateTime getDateValidation() {
        return dateValidation;
    }

    public void setDateValidation(LocalDateTime dateValidation) {
        this.dateValidation = dateValidation;
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
