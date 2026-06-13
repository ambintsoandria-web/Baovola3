package repository.Etudiant;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Model.Etudiant.notifications;

@Repository
public interface NotificationsRepository extends JpaRepository<notifications, Integer> {
    
}