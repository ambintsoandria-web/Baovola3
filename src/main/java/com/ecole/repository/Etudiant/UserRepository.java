package com.ecole.repository.Etudiant;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ecole.entity.Etudiant.ProfilEtudiant;
import com.ecole.entity.Etudiant.User;

public interface UserRepository extends JpaRepository<User, Integer> {
   @Query("SELECT u FROM User u WHERE u.email = :email")
User findByEmail(@Param("email") String email);

    @Query("""
            SELECT r.nom
            FROM Role r
            JOIN UserRole ur ON ur.roleId = r.id
            WHERE ur.userId = :userId
            ORDER BY r.nom
            """)
    List<String> findRoleNamesByUserId(@Param("userId") Long userId);

    @Query("SELECT p FROM ProfilEtudiant p WHERE p.userId = :userId")
    ProfilEtudiant findProfilEtudiantByUserId(@Param("userId") Long userId);

    @Query(value = """
            SELECT salle_id FROM inscriptions
            JOIN classes ON inscriptions.classe_id = classes.id
            WHERE inscriptions.etudiant_id = :etudiant_id
            AND inscriptions.annee_scolaire_id = :annee_scolaire_id
            """, nativeQuery = true)
    Integer getSalleEtudiant(@Param("etudiant_id") Integer etudiant_id,
            @Param("annee_scolaire_id") Integer annee_scolaire_id);
}
