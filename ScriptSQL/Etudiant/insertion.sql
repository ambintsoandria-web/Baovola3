-- ============================================================
-- SCRIPT COMPLET D'INSERTION AVEC HORAIRE_EDT (CORRIGÉ)
-- ============================================================

BEGIN;

-- 1. ETABLISSEMENTS
INSERT INTO etablissements (nom, adresse, telephone, email, logo_url, created_at) VALUES 
('Lycée Moderne Ambi', 'BP 123, Antananarivo, Madagascar', '+261 34 12 345 67', 'contact@lycee-ambi.mg', NULL, NOW());

-- 2. ANNEE SCOLAIRE
INSERT INTO annees_scolaires (etablissement_id, libelle, date_debut, date_fin, est_active, created_at) VALUES 
(1, '2025-2026', '2025-09-15', '2026-06-30', TRUE, NOW());

-- 3. NIVEAUX
INSERT INTO niveaux (etablissement_id, libelle, ordre, created_at) VALUES 
(1, 'Seconde', 1, NOW()),
(1, 'Première', 2, NOW()),
(1, 'Terminale', 3, NOW());

-- 4. CLASSES
INSERT INTO classes (niveau_id, annee_scolaire_id, nom, capacite_max, created_at) VALUES 
(1, 1, 'Seconde A', 35, NOW()),
(1, 1, 'Seconde B', 35, NOW()),
(2, 1, 'Première A', 35, NOW()),
(2, 1, 'Première B', 35, NOW()),
(3, 1, 'Terminale A', 35, NOW()),
(3, 1, 'Terminale B', 35, NOW());

-- 5. SALLES
INSERT INTO salles (etablissement_id, nom, capacite, type, is_active, created_at) VALUES 
(1, 'Salle 101', 40, 'cours', TRUE, NOW()),
(1, 'Salle 102', 40, 'cours', TRUE, NOW()),
(1, 'Salle 103', 45, 'cours', TRUE, NOW()),
(1, 'Laboratoire SVT', 30, 'laboratoire', TRUE, NOW()),
(1, 'Labo Physique', 30, 'laboratoire', TRUE, NOW()),
(1, 'Salle Info', 25, 'cours', TRUE, NOW()),
(1, 'Amphi A', 120, 'amphi', TRUE, NOW());

-- 6. MATIERES
INSERT INTO matieres (etablissement_id, nom, code, created_at) VALUES 
(1, 'Mathématiques', 'MATH', NOW()),
(1, 'Français', 'FRAN', NOW()),
(1, 'Anglais', 'ANGL', NOW()),
(1, 'Physique-Chimie', 'PC', NOW()),
(1, 'SVT', 'SVT', NOW()),
(1, 'Histoire-Géographie', 'HG', NOW()),
(1, 'Philosophie', 'PHIL', NOW()),
(1, 'EPS', 'EPS', NOW());

-- 7. COEFFICIENTS
INSERT INTO coefficients (matiere_id, niveau_id, valeur) VALUES 
(1, 3, 4.00),
(2, 3, 3.00),
(3, 3, 2.00),
(4, 3, 3.00),
(5, 3, 3.00),
(6, 3, 2.00),
(7, 3, 3.00),
(8, 3, 1.00);

-- 8. PERIODES
INSERT INTO periodes (annee_scolaire_id, libelle, type, ordre, date_debut, date_fin, date_publication_notes, est_cloturee) VALUES 
(1, '1er Trimestre', 'trimestre', 1, '2025-09-15', '2025-12-15', '2025-12-20', FALSE),
(1, '2ème Trimestre', 'trimestre', 2, '2025-12-16', '2026-03-15', '2026-03-20', FALSE),
(1, '3ème Trimestre', 'trimestre', 3, '2026-03-16', '2026-06-30', '2026-07-05', FALSE);

-- 9. ROLES
INSERT INTO roles (nom, description, created_at) VALUES 
('etudiant', 'Consultation notes, dossier, emploi du temps', NOW()),
('professeur', 'Saisie notes, absences, emploi du temps', NOW())
ON CONFLICT (nom) DO NOTHING;

-- 10. USERS
INSERT INTO users (email, password, is_active, last_login, created_at, updated_at) VALUES 
('rakoto.jean@lycee.mg', '$2y$10$92IXUNpkjO0rOQ5byMi.Ye4oKoEa3Ro9llC/.og/at2.uheWG/igi', TRUE, NULL, NOW(), NOW()),
('randrianasolo.math@lycee.mg', '$2y$10$92IXUNpkjO0rOQ5byMi.Ye4oKoEa3Ro9llC/.og/at2.uheWG/igi', TRUE, NULL, NOW(), NOW()),
('razafindrakoto.francais@lycee.mg', '$2y$10$92IXUNpkjO0rOQ5byMi.Ye4oKoEa3Ro9llC/.og/at2.uheWG/igi', TRUE, NULL, NOW(), NOW()),
('rasoanirina.anglais@lycee.mg', '$2y$10$92IXUNpkjO0rOQ5byMi.Ye4oKoEa3Ro9llC/.og/at2.uheWG/igi', TRUE, NULL, NOW(), NOW()),
('rajaonarison.phychim@lycee.mg', '$2y$10$92IXUNpkjO0rOQ5byMi.Ye4oKoEa3Ro9llC/.og/at2.uheWG/igi', TRUE, NULL, NOW(), NOW()),
('raharison.svt@lycee.mg', '$2y$10$92IXUNpkjO0rOQ5byMi.Ye4oKoEa3Ro9llC/.og/at2.uheWG/igi', TRUE, NULL, NOW(), NOW()),
('andriamihaja.hg@lycee.mg', '$2y$10$92IXUNpkjO0rOQ5byMi.Ye4oKoEa3Ro9llC/.og/at2.uheWG/igi', TRUE, NULL, NOW(), NOW()),
('rakotomalala.philo@lycee.mg', '$2y$10$92IXUNpkjO0rOQ5byMi.Ye4oKoEa3Ro9llC/.og/at2.uheWG/igi', TRUE, NULL, NOW(), NOW()),
('ratovohery.eps@lycee.mg', '$2y$10$92IXUNpkjO0rOQ5byMi.Ye4oKoEa3Ro9llC/.og/at2.uheWG/igi', TRUE, NULL, NOW(), NOW());

-- 11. USER_ROLES
INSERT INTO user_roles (user_id, role_id) VALUES 
(1, (SELECT id FROM roles WHERE nom = 'etudiant')),
(2, (SELECT id FROM roles WHERE nom = 'professeur')),
(3, (SELECT id FROM roles WHERE nom = 'professeur')),
(4, (SELECT id FROM roles WHERE nom = 'professeur')),
(5, (SELECT id FROM roles WHERE nom = 'professeur')),
(6, (SELECT id FROM roles WHERE nom = 'professeur')),
(7, (SELECT id FROM roles WHERE nom = 'professeur')),
(8, (SELECT id FROM roles WHERE nom = 'professeur')),
(9, (SELECT id FROM roles WHERE nom = 'professeur'));

-- 12. PROFIL_ETUDIANTS
INSERT INTO profils_etudiants (user_id, matricule, nom, prenom, date_naissance, lieu_naissance, sexe, adresse, commune, region, nationalite, telephone, is_archived, created_at, updated_at) VALUES 
(1, 'ETU-2025-001', 'RAKOTO', 'Jean Michel', '2008-03-15', 'Antananarivo', 'M', 'Lot IV 123 Andoharanofotsy', 'Andoharanofotsy', 'Analamanga', 'Malgache', '034 12 345 67', FALSE, NOW(), NOW());

-- 13. PROFIL_PROFESSEURS
INSERT INTO profils_professeurs (user_id, matricule, nom, prenom, date_naissance, sexe, telephone, adresse, specialite, type_contrat, date_debut_contrat, id_matiere, created_at, updated_at) VALUES 
(2, 'PROF-001', 'RANDRIANASOLO', 'Hery', '1980-05-20', 'M', '032 11 111 11', 'Antananarivo', 'Mathématiques', 'permanent', '2010-09-01', 1, NOW(), NOW()),
(3, 'PROF-002', 'RAZAFINDRAKOTO', 'Claire', '1985-02-10', 'F', '032 22 222 22', 'Antananarivo', 'Français', 'permanent', '2012-09-01', 2, NOW(), NOW()),
(4, 'PROF-003', 'RASOANIRINA', 'Mamy', '1990-07-15', 'M', '032 33 333 33', 'Antananarivo', 'Anglais', 'permanent', '2015-09-01', 3, NOW(), NOW()),
(5, 'PROF-004', 'RAJAONARISON', 'Rivo', '1982-11-25', 'M', '032 44 444 44', 'Antananarivo', 'Physique-Chimie', 'permanent', '2008-09-01', 4, NOW(), NOW()),
(6, 'PROF-005', 'RAHARISON', 'Lanto', '1988-09-30', 'M', '032 55 555 55', 'Antananarivo', 'SVT', 'permanent', '2013-09-01', 5, NOW(), NOW()),
(7, 'PROF-006', 'ANDRIAMIHAJA', 'Voahangy', '1986-04-12', 'F', '032 66 666 66', 'Antananarivo', 'Histoire-Géographie', 'permanent', '2011-09-01', 6, NOW(), NOW()),
(8, 'PROF-007', 'RAKOTOMALALA', 'Herilala', '1979-08-05', 'M', '032 77 777 77', 'Antananarivo', 'Philosophie', 'permanent', '2005-09-01', 7, NOW(), NOW()),
(9, 'PROF-008', 'RATOVOHERY', 'Faly', '1992-12-18', 'M', '032 88 888 88', 'Antananarivo', 'EPS', 'vacataire', '2020-09-01', 8, NOW(), NOW());

-- 14. INSCRIPTIONS
INSERT INTO inscriptions (etudiant_id, classe_id, annee_scolaire_id, type_inscription, date_inscription, statut, created_at, updated_at) VALUES 
(1, 5, 1, 'reinscription', '2025-09-10', 'active', NOW(), NOW());

-- 15. AFFECTATIONS ENSEIGNEMENT
INSERT INTO affectations_enseignement (professeur_id, matiere_id, classe_id, annee_scolaire_id, heures_hebdo, created_at) VALUES 
(1, 1, 5, 1, 6.0, NOW()),
(2, 2, 5, 1, 5.0, NOW()),
(3, 3, 5, 1, 4.0, NOW()),
(4, 4, 5, 1, 5.0, NOW()),
(5, 5, 5, 1, 5.0, NOW()),
(6, 6, 5, 1, 4.0, NOW()),
(7, 7, 5, 1, 4.0, NOW()),
(8, 8, 5, 1, 2.0, NOW());

-- 16. HORAIRE_EDT (SANS ON CONFLICT)
INSERT INTO horaire_edt (libelle, heure_debut, heure_fin, ordre, is_active, created_at) VALUES 
('07h30 - 09h00', '07:30:00', '09:00:00', 1, TRUE, NOW()),
('09h15 - 10h45', '09:15:00', '10:45:00', 2, TRUE, NOW()),
('11h00 - 12h30', '11:00:00', '12:30:00', 3, TRUE, NOW()),
('13h30 - 15h00', '13:30:00', '15:00:00', 4, TRUE, NOW()),
('15h15 - 16h45', '15:15:00', '16:45:00', 5, TRUE, NOW());

-- 17. EMPLOI DU TEMPS (avec horaire_edt_id)
INSERT INTO emploi_du_temps (affectation_id, salle_id, horaire_edt_id, jour_semaine, heure_debut, heure_fin, date_debut_validite, created_at) VALUES 
(1, 1, 1, 1, '07:30:00', '09:00:00', '2025-09-15', NOW()),
(1, 1, 1, 3, '07:30:00', '09:00:00', '2025-09-15', NOW()),
(2, 2, 2, 1, '09:15:00', '10:45:00', '2025-09-15', NOW()),
(2, 2, 2, 4, '09:15:00', '10:45:00', '2025-09-15', NOW()),
(3, 3, 3, 2, '11:00:00', '12:30:00', '2025-09-15', NOW()),
(3, 3, 3, 4, '11:00:00', '12:30:00', '2025-09-15', NOW()),
(4, 5, 2, 3, '09:15:00', '10:45:00', '2025-09-15', NOW()),
(4, 5, 2, 5, '09:15:00', '10:45:00', '2025-09-15', NOW()),
(5, 4, 1, 2, '07:30:00', '09:00:00', '2025-09-15', NOW()),
(5, 4, 1, 4, '07:30:00', '09:00:00', '2025-09-15', NOW()),
(6, 6, 4, 1, '13:30:00', '15:00:00', '2025-09-15', NOW()),
(6, 6, 4, 3, '13:30:00', '15:00:00', '2025-09-15', NOW()),
(7, 2, 4, 2, '13:30:00', '15:00:00', '2025-09-15', NOW()),
(8, 1, 4, 5, '13:30:00', '15:00:00', '2025-09-15', NOW());

-- 18. SEANCES
INSERT INTO seances (emploi_du_temps_id, date_seance, heure_debut, heure_fin, a_eu_lieu, created_at) VALUES 
(1, '2025-09-15', '07:30:00', '09:00:00', TRUE, NOW()),
(2, '2025-09-17', '07:30:00', '09:00:00', TRUE, NOW()),
(3, '2025-09-15', '09:15:00', '10:45:00', TRUE, NOW()),
(4, '2025-09-18', '09:15:00', '10:45:00', TRUE, NOW()),
(5, '2025-09-16', '11:00:00', '12:30:00', TRUE, NOW()),
(6, '2025-09-18', '11:00:00', '12:30:00', TRUE, NOW()),
(7, '2025-09-17', '09:15:00', '10:45:00', TRUE, NOW()),
(8, '2025-09-19', '09:15:00', '10:45:00', TRUE, NOW()),
(9, '2025-09-16', '07:30:00', '09:00:00', TRUE, NOW()),
(10, '2025-09-18', '07:30:00', '09:00:00', TRUE, NOW()),
(11, '2025-09-15', '13:30:00', '15:00:00', TRUE, NOW()),
(12, '2025-09-17', '13:30:00', '15:00:00', TRUE, NOW()),
(13, '2025-09-16', '13:30:00', '15:00:00', TRUE, NOW()),
(14, '2025-09-19', '13:30:00', '15:00:00', TRUE, NOW());

-- 19. NOTES
INSERT INTO notes (etudiant_id, affectation_id, periode_id, type_evaluation, valeur, sur, saisi_par, created_at, updated_at) VALUES 
(1, 1, 1, 'devoir_1', 15.50, 20, 1, NOW(), NOW()),
(1, 1, 1, 'devoir_2', 17.00, 20, 1, NOW(), NOW()),
(1, 2, 1, 'devoir_1', 14.00, 20, 2, NOW(), NOW()),
(1, 3, 1, 'devoir_1', 16.50, 20, 3, NOW(), NOW()),
(1, 4, 1, 'devoir_1', 15.00, 20, 4, NOW(), NOW()),
(1, 5, 1, 'devoir_1', 18.00, 20, 5, NOW(), NOW());

COMMIT;

-- Vérification finale
SELECT '=== INSERTION RÉUSSIE ===' as status;
SELECT COUNT(*) as etablissements FROM etablissements;
SELECT COUNT(*) as annees_scolaires FROM annees_scolaires;
SELECT COUNT(*) as niveaux FROM niveaux;
SELECT COUNT(*) as classes FROM classes;
SELECT COUNT(*) as salles FROM salles;
SELECT COUNT(*) as matieres FROM matieres;
SELECT COUNT(*) as coefficients FROM coefficients;
SELECT COUNT(*) as periodes FROM periodes;
SELECT COUNT(*) as roles FROM roles;
SELECT COUNT(*) as users FROM users;
SELECT COUNT(*) as prof_etudiants FROM profils_etudiants;
SELECT COUNT(*) as prof_professeurs FROM profils_professeurs;
SELECT COUNT(*) as inscriptions FROM inscriptions;
SELECT COUNT(*) as affectations FROM affectations_enseignement;
SELECT COUNT(*) as horaire_edt FROM horaire_edt;
SELECT COUNT(*) as emploi_du_temps FROM emploi_du_temps;
SELECT COUNT(*) as seances FROM seances;
SELECT COUNT(*) as notes FROM notes;

-- Vérification de l'emploi du temps avec horaires
SELECT 
    e.id,
    e.jour_semaine,
    h.libelle AS horaire,
    m.nom AS matiere,
    p.nom AS professeur,
    s.nom AS salle
FROM emploi_du_temps e
JOIN horaire_edt h ON e.horaire_edt_id = h.id
JOIN affectations_enseignement a ON e.affectation_id = a.id
JOIN matieres m ON a.matiere_id = m.id
JOIN profils_professeurs p ON a.professeur_id = p.id
JOIN salles s ON e.salle_id = s.id
ORDER BY e.jour_semaine, h.ordre;


SELECT * FROM inscriptions JOIN classes ON inscriptions.classe_id = classes.id 


SELECT classe_id FROM inscriptions  WHERE etudiant_id = 1 AND annee_scolaire_id = 1;

SELECT salle_id FROM inscriptions JOIN classes ON inscriptions.classe_id = classes.id WHERE inscriptions.etudiant_id = 1 AND inscriptions.annee_scolaire_id = 1;


SELECT * FROM emploi_du_temps WHERE salle_id = 1 ;


ALTER TABLE emploi_du_temps ADD COLUMN periode_id INT;