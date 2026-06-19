package com.ecole.repository.Etudiant;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ecole.entity.Etudiant.AffectationEnseignement;
import com.ecole.entity.Etudiant.Lecon;

public interface LeconRepository extends JpaRepository<Lecon, Long> {

    List<Lecon> findByAffectation(AffectationEnseignement affectation);

    List<Lecon> findByAffectationOrderByDatePublicationDesc(AffectationEnseignement affectation);

    List<Lecon> findByDatePublicationBeforeOrderByDatePublicationDesc(LocalDate date);

    List<Lecon> findByAffectationAndDatePublicationBefore(
            AffectationEnseignement affectation,
            LocalDate date);

    @Query("SELECT l FROM Lecon l WHERE l.affectation = :affectation AND l.datePublication <= :date ORDER BY l.datePublication DESC")
    List<Lecon> findPublieeesParAffectation(
            @Param("affectation") AffectationEnseignement affectation,
            @Param("date") LocalDate date);
}
