package com.ecole.repository.Etudiant;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ecole.entity.Etudiant.Periode;

public interface PeriodeRepository extends JpaRepository<Periode, Integer> {

    @Query("SELECT p FROM Periode p WHERE p.anneeScolaireId = :anneeScolaireId ORDER BY p.ordre")
    List<Periode> findByAnneeScolaireId(@Param("anneeScolaireId") Long anneeScolaireId);
}