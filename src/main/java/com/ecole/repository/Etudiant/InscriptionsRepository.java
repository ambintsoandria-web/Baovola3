package com.ecole.repository.Etudiant;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecole.Model.Etudiant.inscriptions;

@Repository
public interface InscriptionsRepository extends JpaRepository<inscriptions, Integer> {
    
}