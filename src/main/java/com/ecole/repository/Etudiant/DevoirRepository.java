package com.ecole.repository.Etudiant;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ecole.entity.Etudiant.AffectationEnseignement;
import com.ecole.entity.Etudiant.Devoir;

public interface DevoirRepository extends JpaRepository<Devoir, Long> {

    List<Devoir> findByAffectationId(AffectationEnseignement affectationId);

    List<Devoir> findByEstActifTrue();

    List<Devoir> findByDateLimiteAfter(LocalDate date);

    List<Devoir> findByAffectationIdAndEstActifTrue(AffectationEnseignement affectationId);



    @Query("""
                SELECT DISTINCT d
                FROM Devoir d
                JOIN FETCH d.affectationId a
                JOIN FETCH a.professeur p
                JOIN FETCH a.matiere m
                WHERE a.classeId = :classeId
                AND d.estActif = true
                ORDER BY d.datePublication DESC
            """)
    List<Devoir> findByClasse(@Param("classeId") Long classeId);

}
