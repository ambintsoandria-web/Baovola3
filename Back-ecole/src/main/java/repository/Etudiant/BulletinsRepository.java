package repository.Etudiant;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Model.Etudiant.bulletins;

@Repository
public interface BulletinsRepository extends JpaRepository<bulletins, Integer> {
    
}