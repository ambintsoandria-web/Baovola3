package com.ecole.repository.Etudiant;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecole.Model.Etudiant.documents;

@Repository
public interface DocumentsRepository extends JpaRepository<documents, Integer> {
    
}