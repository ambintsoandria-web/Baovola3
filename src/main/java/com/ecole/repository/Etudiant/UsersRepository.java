package com.ecole.repository.Etudiant;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecole.Model.Etudiant.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users, Integer> {
    
}
