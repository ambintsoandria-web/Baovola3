package com.ecole.repository.Etudiant;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecole.Model.Etudiant.bulletins;

@Repository
public interface BulletinsRepository extends JpaRepository<bulletins, Integer> {
    
}