package repository.Etudiant;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Model.Etudiant.classes;

@Repository
public interface ClassesRepository extends JpaRepository<classes, Integer> {
    
}