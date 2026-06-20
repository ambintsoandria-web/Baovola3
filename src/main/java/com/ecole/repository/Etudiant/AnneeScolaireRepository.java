// package com.ecole.repository.Etudiant;

// import java.util.List;

// import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.data.jpa.repository.Query;
// import org.springframework.data.repository.query.Param;

// import com.ecole.entity.Etudiant.Matiere;

// public interface AnneeScolaireRepository extends JpaRepository<Matiere, Integer> {
//     @Query("SELECT * FROM annees_scolaires JOIN inscriptions ON annees_scolaires.id = inscriptions.annee_scolaire_id WHERE etudiant_id = :etudiant_id")
//     Integer getAllAnneeScolaireEtudiant(@Param("etudiant_id") Integer etudiant_id);
// }