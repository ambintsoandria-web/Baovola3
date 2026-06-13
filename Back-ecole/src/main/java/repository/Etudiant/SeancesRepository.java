package repository.Etudiant;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Model.Etudiant.seances;

@Repository
public interface SeancesRepository extends JpaRepository<seances, Integer> {
    
}