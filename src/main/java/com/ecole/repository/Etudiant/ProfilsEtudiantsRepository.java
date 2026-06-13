package com.ecole.repository.Etudiant;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecole.Model.Etudiant.profils_etudiants;

@Repository
public interface ProfilsEtudiantsRepository extends JpaRepository<profils_etudiants, Integer> {
    
}