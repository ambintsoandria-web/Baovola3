package repository.Etudiant;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Model.Etudiant.matieres;

@Repository
public interface MatieresRepository extends JpaRepository<matieres, Integer> {
    
}