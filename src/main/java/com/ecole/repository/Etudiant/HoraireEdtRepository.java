package com.ecole.repository.Etudiant;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ecole.entity.Etudiant.HoraireEdt;

public interface HoraireEdtRepository extends JpaRepository<HoraireEdt, Integer> {
    
    @Query("SELECT h FROM HoraireEdt h ORDER BY h.ordre")
    List<HoraireEdt> findAllOrderByOrdre();
}