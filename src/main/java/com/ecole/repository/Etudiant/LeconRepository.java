package com.ecole.repository.Etudiant;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ecole.entity.Etudiant.AffectationEnseignement;
import com.ecole.entity.Etudiant.Lecon;

public interface LeconRepository extends JpaRepository<Lecon, Long> {

    List<Lecon> findByAffectationId(AffectationEnseignement affectationId);

    List<Lecon> findByAffectationIdOrderByDatePublicationDesc(AffectationEnseignement affectationId);

    List<Lecon> findByDatePublicationBeforeOrderByDatePublicationDesc(LocalDate date);

    List<Lecon> findByAffectationIdAndDatePublicationBefore(
            AffectationEnseignement affectationId,
            LocalDate date);

    @Query("SELECT l FROM Lecon l WHERE l.affectationId = :affectationId AND l.datePublication <= :date ORDER BY l.datePublication DESC")
    List<Lecon> findPublieeesParAffectation(
            @Param("affectationId") AffectationEnseignement affectationId,
            @Param("date") LocalDate date);
}
