package repository.Etudiant;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Model.Etudiant.annees_scolaires;

@Repository
public interface AnneesScolairesRepository extends JpaRepository<annees_scolaires, Integer> {
    
}