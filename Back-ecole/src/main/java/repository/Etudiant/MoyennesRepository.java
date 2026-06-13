package repository.Etudiant;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Model.Etudiant.moyennes;

@Repository
public interface MoyennesRepository extends JpaRepository<moyennes, Integer> {
    
}