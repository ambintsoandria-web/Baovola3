package Model.Etudiant;

import java.math.BigDecimal;

public class coefficients {
    private Integer id;
    private Integer matiereId;
    private matieres matiere;
    private Integer niveauId;
    private niveaux niveau;
    private BigDecimal valeur;

    public coefficients() {
    }

    public coefficients(Integer id, Integer matiereId, matieres matiere, Integer niveauId, niveaux niveau, BigDecimal valeur) {
        this.id = id;
        this.matiereId = matiereId;
        this.matiere = matiere;
        this.niveauId = niveauId;
        this.niveau = niveau;
        this.valeur = valeur;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMatiereId() {
        return matiereId;
    }

    public void setMatiereId(Integer matiereId) {
        this.matiereId = matiereId;
    }

    public matieres getMatiere() {
        return matiere;
    }

    public void setMatiere(matieres matiere) {
        this.matiere = matiere;
    }

    public Integer getNiveauId() {
        return niveauId;
    }

    public void setNiveauId(Integer niveauId) {
        this.niveauId = niveauId;
    }

    public niveaux getNiveau() {
        return niveau;
    }

    public void setNiveau(niveaux niveau) {
        this.niveau = niveau;
    }

    public BigDecimal getValeur() {
        return valeur;
    }

    public void setValeur(BigDecimal valeur) {
        this.valeur = valeur;
    }
}
