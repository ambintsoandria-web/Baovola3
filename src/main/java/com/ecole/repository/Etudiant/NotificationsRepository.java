package com.ecole.repository.Etudiant;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecole.Model.Etudiant.notifications;

@Repository
public interface NotificationsRepository extends JpaRepository<notifications, Integer> {
    
}