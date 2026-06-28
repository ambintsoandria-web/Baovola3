package com.ecole.repository.Etudiant;
import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ecole.entity.Etudiant.AffectationEnseignement;
import com.ecole.entity.Etudiant.Periode;

public interface PeriodeRepository extends JpaRepository<Periode , Long>
{
      
}
