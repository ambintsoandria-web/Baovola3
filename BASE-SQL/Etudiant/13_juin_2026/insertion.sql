-- ============================================================
-- INSERTION DES DONNÉES DE TEST (AVEC USER_ROLES)
-- ============================================================

BEGIN;

-- 1. ÉTABLISSEMENT
INSERT INTO etablissements (nom, adresse, telephone, email) VALUES
('Lycée Moderne Ambi', 'BP 123, Antananarivo, Madagascar', '+261 34 12 345 67', 'contact@lycee-ambi.mg');

-- 2. ANNÉE SCOLAIRE (active)
INSERT INTO annees_scolaires (etablissement_id, libelle, date_debut, date_fin, est_active) VALUES
(1, '2025-2026', '2025-09-15', '2026-06-30', TRUE);

-- 3. NIVEAUX (pour le lycée)
INSERT INTO niveaux (etablissement_id, libelle, ordre) VALUES
(1, 'Seconde', 1),
(1, 'Première', 2),
(1, 'Terminale', 3);

-- 4. CLASSES
INSERT INTO classes (niveau_id, annee_scolaire_id, nom, capacite_max) VALUES
(1, 1, 'Seconde A', 35),
(1, 1, 'Seconde B', 35),
(2, 1, 'Première A', 35),
(2, 1, 'Première B', 35),
(3, 1, 'Terminale A', 35),
(3, 1, 'Terminale B', 35);

-- 5. SALLES
INSERT INTO salles (etablissement_id, nom, capacite, type) VALUES
(1, 'Salle 101', 40, 'cours'),
(1, 'Salle 102', 40, 'cours'),
(1, 'Salle 103', 45, 'cours'),
(1, 'Laboratoire SVT', 30, 'laboratoire'),
(1, 'Labo Physique', 30, 'laboratoire'),
(1, 'Salle Info', 25, 'cours'),
(1, 'Amphi A', 120, 'amphi');

-- 6. MATIÈRES
INSERT INTO matieres (etablissement_id, nom, code) VALUES
(1, 'Mathématiques', 'MATH'),
(1, 'Français', 'FRAN'),
(1, 'Anglais', 'ANGL'),
(1, 'Physique-Chimie', 'PC'),
(1, 'Sciences de la Vie et de la Terre', 'SVT'),
(1, 'Histoire-Géographie', 'HG'),
(1, 'Philosophie', 'PHIL'),
(1, 'Éducation Physique et Sportive', 'EPS');

-- 7. PÉRIODES (trimestres)
INSERT INTO periodes (annee_scolaire_id, libelle, type, ordre, date_debut, date_fin, date_publication_notes) VALUES
(1, '1er Trimestre', 'trimestre', 1, '2025-09-15', '2025-12-15', '2025-12-20'),
(1, '2ème Trimestre', 'trimestre', 2, '2025-12-16', '2026-03-15', '2026-03-20'),
(1, '3ème Trimestre', 'trimestre', 3, '2026-03-16', '2026-06-30', '2026-07-05');

-- 8. COEFFICIENTS (pour Terminale)
INSERT INTO coefficients (matiere_id, niveau_id, valeur) VALUES
(1, 3, 4.00),
(2, 3, 3.00),
(3, 3, 2.00),
(4, 3, 3.00),
(5, 3, 3.00),
(6, 3, 2.00),
(7, 3, 3.00),
(8, 3, 1.00);

-- 9. COMPTES UTILISATEURS
INSERT INTO users (email, password, is_active) VALUES
('rakoto.jean@lycee.mg', '$2y$10$92IXUNpkjO0rOQ5byMi.Ye4oKoEa3Ro9llC/.og/at2.uheWG/igi', TRUE),
('randrianasolo.math@lycee.mg', '$2y$10$92IXUNpkjO0rOQ5byMi.Ye4oKoEa3Ro9llC/.og/at2.uheWG/igi', TRUE),
('razafindrakoto.francais@lycee.mg', '$2y$10$92IXUNpkjO0rOQ5byMi.Ye4oKoEa3Ro9llC/.og/at2.uheWG/igi', TRUE),
('rasoanirina.anglais@lycee.mg', '$2y$10$92IXUNpkjO0rOQ5byMi.Ye4oKoEa3Ro9llC/.og/at2.uheWG/igi', TRUE),
('rajaonarison.phychim@lycee.mg', '$2y$10$92IXUNpkjO0rOQ5byMi.Ye4oKoEa3Ro9llC/.og/at2.uheWG/igi', TRUE),
('raharison.svt@lycee.mg', '$2y$10$92IXUNpkjO0rOQ5byMi.Ye4oKoEa3Ro9llC/.og/at2.uheWG/igi', TRUE),
('andriamihaja.hg@lycee.mg', '$2y$10$92IXUNpkjO0rOQ5byMi.Ye4oKoEa3Ro9llC/.og/at2.uheWG/igi', TRUE),
('rakotomalala.philo@lycee.mg', '$2y$10$92IXUNpkjO0rOQ5byMi.Ye4oKoEa3Ro9llC/.og/at2.uheWG/igi', TRUE),
('ratovohery.eps@lycee.mg', '$2y$10$92IXUNpkjO0rOQ5byMi.Ye4oKoEa3Ro9llC/.og/at2.uheWG/igi', TRUE);

-- 10. RÔLES (s'assurer qu'ils existent)
INSERT INTO roles (nom, description) VALUES
('etudiant', 'Consultation notes, dossier, emploi du temps'),
('professeur', 'Saisie notes, absences, emploi du temps')
ON CONFLICT (nom) DO NOTHING;

-- 11. USER_ROLES (liaison utilisateurs ↔ rôles)
INSERT INTO user_roles (user_id, role_id) VALUES
-- Étudiant (user_id 1)
(1, (SELECT id FROM roles WHERE nom = 'etudiant')),
-- Professeurs (user_id 2 à 9)
(2, (SELECT id FROM roles WHERE nom = 'professeur')),
(3, (SELECT id FROM roles WHERE nom = 'professeur')),
(4, (SELECT id FROM roles WHERE nom = 'professeur')),
(5, (SELECT id FROM roles WHERE nom = 'professeur')),
(6, (SELECT id FROM roles WHERE nom = 'professeur')),
(7, (SELECT id FROM roles WHERE nom = 'professeur')),
(8, (SELECT id FROM roles WHERE nom = 'professeur')),
(9, (SELECT id FROM roles WHERE nom = 'professeur'));

-- 12. PROFIL ÉTUDIANT
INSERT INTO profils_etudiants (user_id, matricule, nom, prenom, date_naissance, lieu_naissance, sexe, adresse, commune, region, nationalite, telephone) VALUES
(1, 'ETU-2025-001', 'RAKOTO', 'Jean Michel', '2008-03-15', 'Antananarivo', 'M', 'Lot IV 123 Andoharanofotsy', 'Andoharanofotsy', 'Analamanga', 'Malgache', '034 12 345 67');

-- 13. PROFIL PROFESSEURS (8)
INSERT INTO profils_professeurs (user_id, matricule, nom, prenom, date_naissance, sexe, telephone, adresse, specialite, type_contrat, date_debut_contrat, id_matiere) VALUES
(2, 'PROF-001', 'RANDRIANASOLO', 'Hery', '1980-05-20', 'M', '032 11 111 11', 'Antananarivo', 'Mathématiques', 'permanent', '2010-09-01', 1),
(3, 'PROF-002', 'RAZAFINDRAKOTO', 'Claire', '1985-02-10', 'F', '032 22 222 22', 'Antananarivo', 'Français', 'permanent', '2012-09-01', 2),
(4, 'PROF-003', 'RASOANIRINA', 'Mamy', '1990-07-15', 'M', '032 33 333 33', 'Antananarivo', 'Anglais', 'permanent', '2015-09-01', 3),
(5, 'PROF-004', 'RAJAONARISON', 'Rivo', '1982-11-25', 'M', '032 44 444 44', 'Antananarivo', 'Physique-Chimie', 'permanent', '2008-09-01', 4),
(6, 'PROF-005', 'RAHARISON', 'Lanto', '1988-09-30', 'M', '032 55 555 55', 'Antananarivo', 'SVT', 'permanent', '2013-09-01', 5),
(7, 'PROF-006', 'ANDRIAMIHAJA', 'Voahangy', '1986-04-12', 'F', '032 66 666 66', 'Antananarivo', 'Histoire-Géographie', 'permanent', '2011-09-01', 6),
(8, 'PROF-007', 'RAKOTOMALALA', 'Herilala', '1979-08-05', 'M', '032 77 777 77', 'Antananarivo', 'Philosophie', 'permanent', '2005-09-01', 7),
(9, 'PROF-008', 'RATOVOHERY', 'Faly', '1992-12-18', 'M', '032 88 888 88', 'Antananarivo', 'EPS', 'vacataire', '2020-09-01', 8);

-- 14. INSCRIPTION (élève en Terminale A)
INSERT INTO inscriptions (etudiant_id, classe_id, annee_scolaire_id, type_inscription, statut, date_inscription) VALUES
(1, 5, 1, 'reinscription', 'active', '2025-09-10');

-- 15. AFFECTATIONS ENSEIGNEMENT
INSERT INTO affectations_enseignement (professeur_id, matiere_id, classe_id, annee_scolaire_id, heures_hebdo) VALUES
(1, 1, 5, 1, 6.0),
(2, 2, 5, 1, 5.0),
(3, 3, 5, 1, 4.0),
(4, 4, 5, 1, 5.0),
(5, 5, 5, 1, 5.0),
(6, 6, 5, 1, 4.0),
(7, 7, 5, 1, 4.0),
(8, 8, 5, 1, 2.0);

-- 16. HORAIRES EDT
INSERT INTO horaire_edt (libelle, heure_debut, heure_fin, ordre) VALUES
('07h30 - 09h00', '07:30:00', '09:00:00', 1),
('09h15 - 10h45', '09:15:00', '10:45:00', 2),
('11h00 - 12h30', '11:00:00', '12:30:00', 3),
('13h30 - 15h00', '13:30:00', '15:00:00', 4),
('15h15 - 16h45', '15:15:00', '16:45:00', 5);

-- 17. EMPLOI DU TEMPS
INSERT INTO emploi_du_temps (affectation_id, salle_id, jour_semaine, heure_debut, heure_fin, date_debut_validite) VALUES
(1, 1, 1, '07:30:00', '09:00:00', '2025-09-15'),
(1, 1, 3, '07:30:00', '09:00:00', '2025-09-15'),
(2, 2, 1, '09:15:00', '10:45:00', '2025-09-15'),
(2, 2, 4, '09:15:00', '10:45:00', '2025-09-15'),
(3, 3, 2, '11:00:00', '12:30:00', '2025-09-15'),
(3, 3, 4, '11:00:00', '12:30:00', '2025-09-15'),
(4, 5, 3, '09:15:00', '10:45:00', '2025-09-15'),
(4, 5, 5, '09:15:00', '10:45:00', '2025-09-15'),
(5, 4, 2, '07:30:00', '09:00:00', '2025-09-15'),
(5, 4, 4, '07:30:00', '09:00:00', '2025-09-15'),
(6, 6, 1, '13:30:00', '15:00:00', '2025-09-15'),
(6, 6, 3, '13:30:00', '15:00:00', '2025-09-15'),
(7, 2, 2, '13:30:00', '15:00:00', '2025-09-15'),
(8, 1, 5, '13:30:00', '15:00:00', '2025-09-15');

-- 18. SÉANCES
INSERT INTO seances (emploi_du_temps_id, date_seance, heure_debut, heure_fin, a_eu_lieu) VALUES
(1, '2025-09-15', '07:30:00', '09:00:00', TRUE),
(2, '2025-09-17', '07:30:00', '09:00:00', TRUE),
(3, '2025-09-15', '09:15:00', '10:45:00', TRUE),
(4, '2025-09-18', '09:15:00', '10:45:00', TRUE),
(5, '2025-09-16', '11:00:00', '12:30:00', TRUE),
(6, '2025-09-18', '11:00:00', '12:30:00', TRUE),
(7, '2025-09-17', '09:15:00', '10:45:00', TRUE),
(8, '2025-09-19', '09:15:00', '10:45:00', TRUE),
(9, '2025-09-16', '07:30:00', '09:00:00', TRUE),
(10, '2025-09-18', '07:30:00', '09:00:00', TRUE),
(11, '2025-09-15', '13:30:00', '15:00:00', TRUE),
(12, '2025-09-17', '13:30:00', '15:00:00', TRUE),
(13, '2025-09-16', '13:30:00', '15:00:00', TRUE),
(14, '2025-09-19', '13:30:00', '15:00:00', TRUE);

-- 19. NOTES
INSERT INTO notes (etudiant_id, affectation_id, periode_id, type_evaluation, valeur, sur, saisi_par) VALUES
(1, 1, 1, 'devoir_1', 15.50, 20, 1),
(1, 1, 1, 'devoir_2', 17.00, 20, 1),
(1, 2, 1, 'devoir_1', 14.00, 20, 2),
(1, 3, 1, 'devoir_1', 16.50, 20, 3),
(1, 4, 1, 'devoir_1', 15.00, 20, 4),
(1, 5, 1, 'devoir_1', 18.00, 20, 5);

-- 20. ABSENCES
INSERT INTO absences (seance_id, etudiant_id, type, motif, saisi_par) VALUES
(8, 1, 'justifiee', 'Maladie, certificat médical fourni', 4);

COMMIT;

-- Vérification finale
SELECT '=== RÉSULTAT FINAL ===' as info;
SELECT 'Établissements' as table_name, COUNT(*) FROM etablissements
UNION ALL SELECT 'Années scolaires', COUNT(*) FROM annees_scolaires
UNION ALL SELECT 'Niveaux', COUNT(*) FROM niveaux
UNION ALL SELECT 'Classes', COUNT(*) FROM classes
UNION ALL SELECT 'Salles', COUNT(*) FROM salles
UNION ALL SELECT 'Matières', COUNT(*) FROM matieres
UNION ALL SELECT 'Périodes', COUNT(*) FROM periodes
UNION ALL SELECT 'Coefficients', COUNT(*) FROM coefficients
UNION ALL SELECT 'Users', COUNT(*) FROM users
UNION ALL SELECT 'Rôles', COUNT(*) FROM roles
UNION ALL SELECT 'User_Roles', COUNT(*) FROM user_roles
UNION ALL SELECT 'Étudiants', COUNT(*) FROM profils_etudiants
UNION ALL SELECT 'Professeurs', COUNT(*) FROM profils_professeurs
UNION ALL SELECT 'Inscriptions', COUNT(*) FROM inscriptions
UNION ALL SELECT 'Affectations', COUNT(*) FROM affectations_enseignement
UNION ALL SELECT 'EDT', COUNT(*) FROM emploi_du_temps
UNION ALL SELECT 'Séances', COUNT(*) FROM seances
UNION ALL SELECT 'Notes', COUNT(*) FROM notes
UNION ALL SELECT 'Absences', COUNT(*) FROM absences;