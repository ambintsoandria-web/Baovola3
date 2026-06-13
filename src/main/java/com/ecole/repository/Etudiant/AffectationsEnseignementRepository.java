package com.ecole.repository.Etudiant;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecole.Model.Etudiant.affectations_enseignement;

@Repository
public interface AffectationsEnseignementRepository extends JpaRepository<affectations_enseignement, Integer> {
    
}