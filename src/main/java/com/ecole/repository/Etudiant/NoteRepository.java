package com.ecole.repository.Etudiant;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ecole.entity.Etudiant.Note;

public interface NoteRepository extends JpaRepository<Note, Long> {
    @Query("""
                SELECT n
                FROM Note n
                JOIN FETCH n.affectation a
                JOIN FETCH a.matiere m
                JOIN FETCH a.professeur p
                WHERE n.etudiantId = :etudiantId
                ORDER BY n.dateSaisie DESC
            """)
    List<Note> findNotesParEtudiant(@Param("etudiantId") Long etudiantId);

    @Query("""
            SELECT n
            FROM Note n
            JOIN FETCH n.affectation a
            JOIN FETCH a.matiere m
            JOIN FETCH a.professeur p
            WHERE n.etudiantId = :etudiantId
            AND n.periodeId = :periodeId
            """)
    List<Note> findNotesParEtudiantParTrimestre(@Param("etudiantId") Long etudiantId,
            @Param("periodeId") Long periodeId);

}
