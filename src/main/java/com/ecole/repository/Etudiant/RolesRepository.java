package com.ecole.repository.Etudiant;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecole.Model.Etudiant.roles;

@Repository
public interface RolesRepository extends JpaRepository<roles, Integer> {
    
}