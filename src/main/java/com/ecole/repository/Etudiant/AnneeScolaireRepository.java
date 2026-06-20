package com.ecole.repository.Etudiant;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ecole.entity.Etudiant.AnneeScolaire;

public interface AnneeScolaireRepository extends JpaRepository<AnneeScolaire, Integer> {

    @Query(value = """
            SELECT a.* FROM annees_scolaires a
            JOIN inscriptions i ON a.id = i.annee_scolaire_id
            WHERE i.etudiant_id = :etudiantId
            ORDER BY a.date_debut DESC
            """, nativeQuery = true)
    List<AnneeScolaire> getAnneesScolairesByEtudiant(@Param("etudiantId") Integer etudiantId);
}