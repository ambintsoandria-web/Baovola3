-- ============================================================
-- SUPPRESSION DES DONNÉES DE TEST
-- Ordre inverse des insertions pour respecter les FK
-- ============================================================

BEGIN;

-- 1. Supprimer les notes
DELETE FROM notes;

-- 2. Supprimer les absences
DELETE FROM absences;

-- 3. Supprimer les séances
DELETE FROM seances;

-- 4. Supprimer l'emploi du temps
DELETE FROM emploi_du_temps;

-- 5. Supprimer les horaires EDT
DELETE FROM horaire_edt;

-- 6. Supprimer les affectations d'enseignement
DELETE FROM affectations_enseignement;

-- 7. Supprimer les inscriptions
DELETE FROM inscriptions;

-- 8. Supprimer les profils professeurs
DELETE FROM profils_professeurs;

-- 9. Supprimer le profil étudiant
DELETE FROM profils_etudiants;

-- 10. Supprimer les user_roles
DELETE FROM user_roles WHERE user_id IN (1, 2, 3, 4, 5, 6, 7, 8, 9);

-- 11. Supprimer les users
DELETE FROM users WHERE id IN (1, 2, 3, 4, 5, 6, 7, 8, 9);

-- 12. Supprimer les coefficients
DELETE FROM coefficients;

-- 13. Supprimer les périodes
DELETE FROM periodes;

-- 14. Supprimer les matières
DELETE FROM matieres;

-- 15. Supprimer les salles
DELETE FROM salles;

-- 16. Supprimer les classes
DELETE FROM classes;

-- 17. Supprimer les niveaux
DELETE FROM niveaux;

-- 18. Supprimer l'année scolaire
DELETE FROM annees_scolaires;

-- 19. Supprimer l'établissement
DELETE FROM etablissements;

-- 20. Réinitialiser les séquences (optionnel)
ALTER SEQUENCE etablissements_id_seq RESTART WITH 1;
ALTER SEQUENCE annees_scolaires_id_seq RESTART WITH 1;
ALTER SEQUENCE niveaux_id_seq RESTART WITH 1;
ALTER SEQUENCE classes_id_seq RESTART WITH 1;
ALTER SEQUENCE salles_id_seq RESTART WITH 1;
ALTER SEQUENCE matieres_id_seq RESTART WITH 1;
ALTER SEQUENCE periodes_id_seq RESTART WITH 1;
ALTER SEQUENCE coefficients_id_seq RESTART WITH 1;
ALTER SEQUENCE users_id_seq RESTART WITH 1;
ALTER SEQUENCE profils_etudiants_id_seq RESTART WITH 1;
ALTER SEQUENCE profils_professeurs_id_seq RESTART WITH 1;
ALTER SEQUENCE inscriptions_id_seq RESTART WITH 1;
ALTER SEQUENCE affectations_enseignement_id_seq RESTART WITH 1;
ALTER SEQUENCE emploi_du_temps_id_seq RESTART WITH 1;
ALTER SEQUENCE horaire_edt_id_seq RESTART WITH 1;
ALTER SEQUENCE seances_id_seq RESTART WITH 1;
ALTER SEQUENCE notes_id_seq RESTART WITH 1;
ALTER SEQUENCE absences_id_seq RESTART WITH 1;

COMMIT;

-- Vérification
SELECT 'Tables nettoyées !' as status;
SELECT 
    (SELECT COUNT(*) FROM etablissements) as etablissements,
    (SELECT COUNT(*) FROM users) as users,
    (SELECT COUNT(*) FROM profils_etudiants) as etudiants,
    (SELECT COUNT(*) FROM profils_professeurs) as professeurs;