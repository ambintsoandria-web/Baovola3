package com.ecole.repository.Etudiant;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ecole.entity.Etudiant.Coefficient;

public interface CoefficientRepository extends JpaRepository<Coefficient, Long> {
    @Query("""
        SELECT c
        FROM Coefficient c
        WHERE c.matiereId = :matiereId
        AND c.niveauId = :niveauId
    """)
    List<Coefficient> findCoefficientsParMatiere(@Param("matiereId") Long matiereId,
            @Param("niveauId") Long niveauId);

    @Query("""
        SELECT c
        FROM Coefficient c
        WHERE c.niveauId = :niveauId
    """)
    List<Coefficient> findByNiveauId(@Param("niveauId") Long niveauId);

    default Map<Long, BigDecimal> findCoefficientsMapByNiveau(Long niveauId) {
        return findByNiveauId(niveauId).stream()
                .collect(Collectors.toMap(Coefficient::getMatiereId, Coefficient::getValeur));
    }
}