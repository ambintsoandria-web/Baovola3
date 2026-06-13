package repository.Etudiant;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Model.Etudiant.devoirs;

@Repository
public interface DevoirsRepository extends JpaRepository<devoirs, Integer> {
    
}