package Model.Etudiant;

import java.time.LocalDate;
import java.time.LocalDateTime;
import jakarta.persistence.*;

@Entity
@Table(name = "periodes")
public class periodes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "annee_scolaire_id")
    private Integer anneeScolaireId;

    @ManyToOne
    @JoinColumn(name = "annee_scolaire_id", insertable = false, updatable = false)
    private annees_scolaires anneeScolaire;

    @Column(name = "libelle", length = 100, nullable = false)
    private String libelle;

    @Column(name = "type", length = 20)
    private String type;

    @Column(name = "ordre", nullable = false)
    private Integer ordre;

    @Column(name = "date_debut")
    private LocalDate dateDebut;

    @Column(name = "date_fin")
    private LocalDate dateFin;

    @Column(name = "date_publication_notes")
    private LocalDate datePublicationNotes;

    @Column(name = "est_cloturee")
    private Boolean cloturee;

    public periodes() {
    }

    public periodes(Integer id, Integer anneeScolaireId, annees_scolaires anneeScolaire, String libelle, String type,
                    Integer ordre, LocalDate dateDebut, LocalDate dateFin, LocalDate datePublicationNotes, Boolean cloturee) {
        this.id = id;
        this.anneeScolaireId = anneeScolaireId;
        this.anneeScolaire = anneeScolaire;
        this.libelle = libelle;
        this.type = type;
        this.ordre = ordre;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.datePublicationNotes = datePublicationNotes;
        this.cloturee = cloturee;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getOrdre() {
        return ordre;
    }

    public void setOrdre(Integer ordre) {
        this.ordre = ordre;
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

    public LocalDate getDatePublicationNotes() {
        return datePublicationNotes;
    }

    public void setDatePublicationNotes(LocalDate datePublicationNotes) {
        this.datePublicationNotes = datePublicationNotes;
    }

    public Boolean getCloturee() {
        return cloturee;
    }

    public void setCloturee(Boolean cloturee) {
        this.cloturee = cloturee;
    }
}
