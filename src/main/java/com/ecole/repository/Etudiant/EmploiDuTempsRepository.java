package com.ecole.repository.Etudiant;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ecole.entity.Etudiant.EmploiDuTemps;

public interface EmploiDuTempsRepository extends JpaRepository<EmploiDuTemps, Integer> {

    @Query(value = """
            SELECT
                e.id,
                e.affectation_id,
                e.salle_id,
                e.jour_semaine,
                e.heure_debut,
                e.heure_fin,
                e.date_debut_validite,
                e.date_fin_validite,
                e.created_at,
                e.horaire_edt_id,
                e.periode_id,
                m.nom AS matiere_nom,
                p.nom AS professeur_nom,
                p.prenom AS professeur_prenom
            FROM emploi_du_temps e
            JOIN affectations_enseignement a ON e.affectation_id = a.id
            JOIN matieres m ON a.matiere_id = m.id
            JOIN profils_professeurs p ON a.professeur_id = p.id
            WHERE e.salle_id = :salleId
            AND e.periode_id = :periodeId
            ORDER BY e.jour_semaine, e.heure_debut
            """, nativeQuery = true)
    List<Object[]> findEmploiWithDetails(@Param("salleId") Long salleId, @Param("periodeId") Long periodeId);
}