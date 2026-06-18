package com.ecole.repository.Etudiant;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ecole.entity.Etudiant.Inscription;

public interface InscriptionRepository extends JpaRepository<Inscription, Long> {

    @Query("""
            SELECT i
            FROM Inscription i
            WHERE i.etudiantId = :etudiantId
              AND i.statut = 'active'
            """)
    List<Inscription> findActiveByEtudiant(@Param("etudiantId") Long etudiantId);
}
