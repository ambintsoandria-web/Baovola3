package repository.Etudiant;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Model.Etudiant.documents;

@Repository
public interface DocumentsRepository extends JpaRepository<documents, Integer> {
    
}