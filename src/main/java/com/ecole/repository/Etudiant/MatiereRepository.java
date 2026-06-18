package com.ecole.repository.Etudiant;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ecole.entity.Etudiant.Matiere;

public interface MatiereRepository extends JpaRepository<Matiere, Integer> {

    @Query("SELECT m FROM Matiere m WHERE m.etablissementId = :etablissementId")
    List<Matiere> findByEtablissementId(Long etablissementId);
}