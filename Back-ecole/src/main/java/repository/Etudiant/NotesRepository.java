package repository.Etudiant;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Model.Etudiant.notes;

@Repository
public interface NotesRepository extends JpaRepository<notes, Integer> {
    
}