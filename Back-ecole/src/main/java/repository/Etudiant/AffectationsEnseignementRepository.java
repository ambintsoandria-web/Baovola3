package repository.Etudiant;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Model.Etudiant.affectations_enseignement;

@Repository
public interface AffectationsEnseignementRepository extends JpaRepository<affectations_enseignement, Integer> {
    
}