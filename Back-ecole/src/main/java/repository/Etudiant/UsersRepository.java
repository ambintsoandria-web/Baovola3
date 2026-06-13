package repository.Etudiant;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Model.Etudiant.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users, Integer> {
    
}
