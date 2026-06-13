-- ============================================================
-- SCRIPT COMPLET DE SUPPRESSION (CORRIGÉ)
-- ============================================================

BEGIN;

-- 1. Supprimer les données liées aux étudiants
DELETE FROM absences;
DELETE FROM moyennes;
DELETE FROM notes;
DELETE FROM seances;
DELETE FROM emploi_du_temps;
DELETE FROM modifications_edt;

-- 2. Supprimer les affectations et inscriptions
DELETE FROM affectations_enseignement;
DELETE FROM inscriptions;

-- 3. Supprimer les profils
DELETE FROM profils_professeurs;
DELETE FROM profils_etudiants;
DELETE FROM profils_directeurs;
DELETE FROM profils_secretariat;
DELETE FROM profils_comptables;
DELETE FROM profils_parents;
DELETE FROM etudiants_parents;

-- 4. Supprimer les users et leurs rôles
DELETE FROM user_roles;
DELETE FROM users;

-- 5. Supprimer les périodes et coefficients
DELETE FROM periodes;
DELETE FROM coefficients;

-- 6. Supprimer les matières et salles
DELETE FROM matieres;
DELETE FROM salles;

-- 7. Supprimer les classes
DELETE FROM classes;

-- 8. Supprimer les niveaux
DELETE FROM niveaux;

-- 9. Supprimer les années scolaires
DELETE FROM annees_scolaires;

-- 10. Supprimer l'établissement
DELETE FROM etablissements;

-- 11. Supprimer les rôles
DELETE FROM roles;

-- 12. Réinitialiser les séquences (seulement celles qui existent)
ALTER SEQUENCE IF EXISTS etablissements_id_seq RESTART WITH 1;
ALTER SEQUENCE IF EXISTS annees_scolaires_id_seq RESTART WITH 1;
ALTER SEQUENCE IF EXISTS niveaux_id_seq RESTART WITH 1;
ALTER SEQUENCE IF EXISTS classes_id_seq RESTART WITH 1;
ALTER SEQUENCE IF EXISTS salles_id_seq RESTART WITH 1;
ALTER SEQUENCE IF EXISTS matieres_id_seq RESTART WITH 1;
ALTER SEQUENCE IF EXISTS coefficients_id_seq RESTART WITH 1;
ALTER SEQUENCE IF EXISTS periodes_id_seq RESTART WITH 1;
ALTER SEQUENCE IF EXISTS users_id_seq RESTART WITH 1;
ALTER SEQUENCE IF EXISTS roles_id_seq RESTART WITH 1;
ALTER SEQUENCE IF EXISTS profils_etudiants_id_seq RESTART WITH 1;
ALTER SEQUENCE IF EXISTS profils_professeurs_id_seq RESTART WITH 1;
ALTER SEQUENCE IF EXISTS inscriptions_id_seq RESTART WITH 1;
ALTER SEQUENCE IF EXISTS affectations_enseignement_id_seq RESTART WITH 1;
ALTER SEQUENCE IF EXISTS emploi_du_temps_id_seq RESTART WITH 1;
ALTER SEQUENCE IF EXISTS seances_id_seq RESTART WITH 1;
ALTER SEQUENCE IF EXISTS notes_id_seq RESTART WITH 1;
ALTER SEQUENCE IF EXISTS moyennes_id_seq RESTART WITH 1;
ALTER SEQUENCE IF EXISTS absences_id_seq RESTART WITH 1;

COMMIT;

-- Vérification finale
SELECT '=== TOUTES LES DONNÉES SUPPRIMÉES ===' as status;
SELECT COUNT(*) as etablissements FROM etablissements;
SELECT COUNT(*) as users FROM users;
SELECT COUNT(*) as etudiants FROM profils_etudiants;
SELECT COUNT(*) as professeurs FROM profils_professeurs;