package repository.Etudiant;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Model.Etudiant.periodes;

@Repository
public interface PeriodesRepository extends JpaRepository<periodes, Integer> {
    
}