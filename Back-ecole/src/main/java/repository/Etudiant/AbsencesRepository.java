package repository.Etudiant;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Model.Etudiant.absences;

@Repository
public interface AbsencesRepository extends JpaRepository<absences, Integer> {
    
}