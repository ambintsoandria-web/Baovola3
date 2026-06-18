package com.ecole.repository.Etudiant;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ecole.entity.Etudiant.ProfilEtudiant;
import com.ecole.entity.Etudiant.User;

public interface UserRepository extends JpaRepository<User, Integer> {
    @Query("SELECT u FROM User u WHERE u.email = :email AND u.password = :password")
    User findByEmailAndPassword(@Param("email") String email, @Param("password") String password);

    @Query("SELECT p FROM ProfilEtudiant p WHERE p.userId = :userId")
    ProfilEtudiant findProfilEtudiantByUserId(@Param("userId") Long userId);

    // @Query(value = """
    //         SELECT salle_id FROM inscriptions
    //         JOIN classes ON inscriptions.classe_id = classes.id
    //         WHERE inscriptions.etudiant_id = :etudiant_id
    //         AND inscriptions.annee_scolaire_id = :annee_scolaire_id
    //         """, nativeQuery = true)
    // Integer getClasseEtudiant(@Param("id_annee_scolaire") Integer id_annee_scolaire);
}
