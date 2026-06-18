package com.ecole.repository.Etudiant;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ecole.entity.Etudiant.EmploiDuTemps;
import com.ecole.entity.Etudiant.ProfilEtudiant;
import com.ecole.entity.Etudiant.User;

public interface EmploiDuTempsRepository extends JpaRepository<EmploiDuTemps, Integer> {
    @Query("SELECT e FROM EmploiDuTemps e WHERE e.salleId = :salleId")
    List<EmploiDuTemps> findBySalleId(@Param("salleId") Long salleId);
}
