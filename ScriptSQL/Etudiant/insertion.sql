-- ============================================================
-- SCRIPT D'INSERTION CORRIGÉ — aligné avec le schéma PostgreSQL
-- ============================================================

BEGIN;

-- ============================================================
-- ÉTAPE 0 — Corrections de schéma à appliquer d'abord
-- (si pas encore fait)
-- ============================================================

-- Ajouter horaire_edt_id dans emploi_du_temps (colonne manquante dans le schéma original)
DO $$ BEGIN
    IF NOT EXISTS (
        SELECT 1 FROM information_schema.columns
        WHERE table_name='emploi_du_temps' AND column_name='horaire_edt_id'
    ) THEN
        -- Créer la table horaire_edt si elle n'existe pas
        CREATE TABLE IF NOT EXISTS horaire_edt (
            id         SERIAL PRIMARY KEY,
            libelle    VARCHAR(100),
            heure_debut TIME NOT NULL,
            heure_fin   TIME NOT NULL,
            ordre       INT,
            is_active   BOOLEAN DEFAULT TRUE,
            created_at  TIMESTAMP DEFAULT NOW()
        );
        ALTER TABLE emploi_du_temps ADD COLUMN horaire_edt_id INT REFERENCES horaire_edt(id);
    END IF;
END $$;

-- Ajouter periode_id dans emploi_du_temps (si pas encore fait)
DO $$ BEGIN
    IF NOT EXISTS (
        SELECT 1 FROM information_schema.columns
        WHERE table_name='emploi_du_temps' AND column_name='periode_id'
    ) THEN
        ALTER TABLE emploi_du_temps ADD COLUMN periode_id INT REFERENCES periodes(id);
    END IF;
END $$;

-- Corriger la faute de frappe dans notes (corrige_par INT REFERENCES users(id)s)
-- Vérifier si la colonne existe déjà correctement
DO $$ BEGIN
    IF NOT EXISTS (
        SELECT 1 FROM information_schema.columns
        WHERE table_name='notes' AND column_name='corrige_par'
    ) THEN
        ALTER TABLE notes ADD COLUMN corrige_par INT REFERENCES users(id);
    END IF;
END $$;

-- ============================================================
-- 1. ETABLISSEMENTS
-- ============================================================
INSERT INTO etablissements (nom, adresse, telephone, email, logo_url, created_at) VALUES 
('Lycée Moderne Ambi', 'BP 123, Antananarivo, Madagascar', '+261 34 12 345 67', 'contact@lycee-ambi.mg', NULL, NOW());

-- ============================================================
-- 2. ANNEE SCOLAIRE
-- ============================================================
INSERT INTO annees_scolaires (etablissement_id, libelle, date_debut, date_fin, est_active, created_at) VALUES 
(1, '2025-2026', '2025-09-15', '2026-06-30', TRUE, NOW());

-- ============================================================
-- 3. NIVEAUX
-- ============================================================
INSERT INTO niveaux (etablissement_id, libelle, ordre, created_at) VALUES 
(1, 'Seconde',   1, NOW()),
(1, 'Première',  2, NOW()),
(1, 'Terminale', 3, NOW());

-- ============================================================
-- 4. CLASSES
-- ============================================================
INSERT INTO classes (niveau_id, annee_scolaire_id, nom, capacite_max, created_at) VALUES 
(1, 1, 'Seconde A',   35, NOW()),
(1, 1, 'Seconde B',   35, NOW()),
(2, 1, 'Première A',  35, NOW()),
(2, 1, 'Première B',  35, NOW()),
(3, 1, 'Terminale A', 35, NOW()),
(3, 1, 'Terminale B', 35, NOW());

-- ============================================================
-- 5. SALLES
-- ============================================================
INSERT INTO salles (etablissement_id, nom, capacite, type, is_active, created_at) VALUES 
(1, 'Salle 101',       40,  'cours',       TRUE, NOW()),
(1, 'Salle 102',       40,  'cours',       TRUE, NOW()),
(1, 'Salle 103',       45,  'cours',       TRUE, NOW()),
(1, 'Laboratoire SVT', 30,  'laboratoire', TRUE, NOW()),
(1, 'Labo Physique',   30,  'laboratoire', TRUE, NOW()),
(1, 'Salle Info',      25,  'cours',       TRUE, NOW()),
(1, 'Amphi A',         120, 'amphi',       TRUE, NOW());

-- ============================================================
-- 6. MATIERES
-- ============================================================
INSERT INTO matieres (etablissement_id, nom, code, created_at) VALUES 
(1, 'Mathématiques',       'MATH', NOW()),
(1, 'Français',            'FRAN', NOW()),
(1, 'Anglais',             'ANGL', NOW()),
(1, 'Physique-Chimie',     'PC',   NOW()),
(1, 'SVT',                 'SVT',  NOW()),
(1, 'Histoire-Géographie', 'HG',   NOW()),
(1, 'Philosophie',         'PHIL', NOW()),
(1, 'EPS',                 'EPS',  NOW());

-- ============================================================
-- 7. COEFFICIENTS (niveau_id=3 = Terminale)
-- ============================================================
INSERT INTO coefficients (matiere_id, niveau_id, valeur) VALUES 
(9, 3, 4.00),  -- Maths coeff 4
(10, 3, 3.00),  -- Français coeff 3
(11, 3, 2.00),  -- Anglais coeff 2
(12, 3, 3.00),  -- Physique-Chimie coeff 3
(13, 3, 3.00),  -- SVT coeff 3
(14, 3, 2.00),  -- Histoire-Géo coeff 2
(15, 3, 3.00),  -- Philosophie coeff 3
(16, 3, 1.00);  -- EPS coeff 1

-- ============================================================
-- 8. PERIODES
-- ============================================================
INSERT INTO periodes (annee_scolaire_id, libelle, type, ordre, date_debut, date_fin, date_publication_notes, est_cloturee) VALUES 
(1, '1er Trimestre',   'trimestre', 1, '2025-09-15', '2025-12-15', '2025-12-20', FALSE),
(1, '2ème Trimestre',  'trimestre', 2, '2025-12-16', '2026-03-15', '2026-03-20', FALSE),
(1, '3ème Trimestre',  'trimestre', 3, '2026-03-16', '2026-06-30', '2026-07-05', FALSE);

-- ============================================================
-- 9. ROLES
-- Le schéma seed crée déjà 7 rôles. ON CONFLICT évite les doublons.
-- ============================================================
INSERT INTO roles (nom, description, created_at) VALUES 
('etudiant',   'Consultation notes, dossier, emploi du temps', NOW()),
('professeur', 'Saisie notes, absences, emploi du temps',      NOW())
ON CONFLICT (nom) DO NOTHING;

-- ============================================================
-- 10. USERS
-- IMPORTANT : hash $2y$ (PHP) remplacé par $2a$ (Java BCrypt)
-- Mot de passe : "password"
-- ============================================================
INSERT INTO users (email, password, is_active, last_login, created_at, updated_at) VALUES 
('rakoto.jean@lycee.mg',               '$2a$10$92IXUNpkjO0rOQ5byMi.Ye4oKoEa3Ro9llC/.og/at2.uheWG/igi', TRUE, NULL, NOW(), NOW()),
('randrianasolo.math@lycee.mg',        '$2a$10$92IXUNpkjO0rOQ5byMi.Ye4oKoEa3Ro9llC/.og/at2.uheWG/igi', TRUE, NULL, NOW(), NOW()),
('razafindrakoto.francais@lycee.mg',   '$2a$10$92IXUNpkjO0rOQ5byMi.Ye4oKoEa3Ro9llC/.og/at2.uheWG/igi', TRUE, NULL, NOW(), NOW()),
('rasoanirina.anglais@lycee.mg',       '$2a$10$92IXUNpkjO0rOQ5byMi.Ye4oKoEa3Ro9llC/.og/at2.uheWG/igi', TRUE, NULL, NOW(), NOW()),
('rajaonarison.phychim@lycee.mg',      '$2a$10$92IXUNpkjO0rOQ5byMi.Ye4oKoEa3Ro9llC/.og/at2.uheWG/igi', TRUE, NULL, NOW(), NOW()),
('raharison.svt@lycee.mg',             '$2a$10$92IXUNpkjO0rOQ5byMi.Ye4oKoEa3Ro9llC/.og/at2.uheWG/igi', TRUE, NULL, NOW(), NOW()),
('andriamihaja.hg@lycee.mg',           '$2a$10$92IXUNpkjO0rOQ5byMi.Ye4oKoEa3Ro9llC/.og/at2.uheWG/igi', TRUE, NULL, NOW(), NOW()),
('rakotomalala.philo@lycee.mg',        '$2a$10$92IXUNpkjO0rOQ5byMi.Ye4oKoEa3Ro9llC/.og/at2.uheWG/igi', TRUE, NULL, NOW(), NOW()),
('ratovohery.eps@lycee.mg',            '$2a$10$92IXUNpkjO0rOQ5byMi.Ye4oKoEa3Ro9llC/.og/at2.uheWG/igi', TRUE, NULL, NOW(), NOW());

-- ============================================================
-- 11. USER_ROLES
-- ============================================================
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

-- ============================================================
-- 12. PROFILS ETUDIANTS
-- ============================================================
INSERT INTO profils_etudiants (
    user_id, matricule, nom, prenom, date_naissance, lieu_naissance,
    sexe, adresse, commune, region, nationalite, telephone, is_archived, created_at, updated_at
) VALUES (
    1, 'ETU-2025-001', 'RAKOTO', 'Jean Michel', '2008-03-15', 'Antananarivo',
    'M', 'Lot IV 123 Andoharanofotsy', 'Andoharanofotsy', 'Analamanga', 'Malgache',
    '034 12 345 67', FALSE, NOW(), NOW()
);

-- ============================================================
-- 13. PROFILS PROFESSEURS
-- CORRECTION : suppression de "id_matiere" (colonne inexistante dans le schéma)
-- ============================================================
INSERT INTO profils_professeurs (
    user_id, matricule, nom, prenom, date_naissance,
    sexe, telephone, adresse, specialite, type_contrat, date_debut_contrat,
    is_archived, created_at, updated_at
) VALUES 
(2, 'PROF-001', 'RANDRIANASOLO', 'Hery',       '1980-05-20', 'M', '032 11 111 11', 'Antananarivo', 'Mathématiques',       'permanent',  '2010-09-01', FALSE, NOW(), NOW()),
(3, 'PROF-002', 'RAZAFINDRAKOTO','Claire',      '1985-02-10', 'F', '032 22 222 22', 'Antananarivo', 'Français',            'permanent',  '2012-09-01', FALSE, NOW(), NOW()),
(4, 'PROF-003', 'RASOANIRINA',  'Mamy',         '1990-07-15', 'M', '032 33 333 33', 'Antananarivo', 'Anglais',             'permanent',  '2015-09-01', FALSE, NOW(), NOW()),
(5, 'PROF-004', 'RAJAONARISON', 'Rivo',         '1982-11-25', 'M', '032 44 444 44', 'Antananarivo', 'Physique-Chimie',     'permanent',  '2008-09-01', FALSE, NOW(), NOW()),
(6, 'PROF-005', 'RAHARISON',    'Lanto',        '1988-09-30', 'M', '032 55 555 55', 'Antananarivo', 'SVT',                 'permanent',  '2013-09-01', FALSE, NOW(), NOW()),
(7, 'PROF-006', 'ANDRIAMIHAJA', 'Voahangy',     '1986-04-12', 'F', '032 66 666 66', 'Antananarivo', 'Histoire-Géographie', 'permanent',  '2011-09-01', FALSE, NOW(), NOW()),
(8, 'PROF-007', 'RAKOTOMALALA', 'Herilala',     '1979-08-05', 'M', '032 77 777 77', 'Antananarivo', 'Philosophie',         'permanent',  '2005-09-01', FALSE, NOW(), NOW()),
(9, 'PROF-008', 'RATOVOHERY',   'Faly',         '1992-12-18', 'M', '032 88 888 88', 'Antananarivo', 'EPS',                 'vacataire',  '2020-09-01', FALSE, NOW(), NOW());

-- ============================================================
-- 14. INSCRIPTIONS
-- etudiant_id=1 (Jean Michel), classe_id=5 (Terminale A), annee_id=1
-- ============================================================
INSERT INTO inscriptions (
    etudiant_id, classe_id, annee_scolaire_id,
    type_inscription, date_inscription, statut, created_at, updated_at
) VALUES (
    1, 13, 1, 'reinscription', '2025-09-10', 'active', NOW(), NOW()
);

-- ============================================================
-- 15. AFFECTATIONS ENSEIGNEMENT
-- professeur_id = id dans profils_professeurs (1 à 8)
-- classe_id=5 = Terminale A
-- ============================================================
INSERT INTO affectations_enseignement (
    professeur_id, matiere_id, classe_id, annee_scolaire_id, heures_hebdo, created_at
) VALUES 
(1, 9, 17, 1, 6.0, NOW()),  -- RANDRIANASOLO → Maths
(2, 10, 17, 1, 5.0, NOW()),  -- RAZAFINDRAKOTO → Français
(3, 11, 17, 1, 4.0, NOW()),  -- RASOANIRINA → Anglais
(4, 12, 17, 1, 5.0, NOW()),  -- RAJAONARISON → Physique-Chimie
(5, 13, 17, 1, 5.0, NOW()),  -- RAHARISON → SVT
(6, 14, 17, 1, 4.0, NOW()),  -- ANDRIAMIHAJA → Histoire-Géo
(7, 15, 17, 1, 4.0, NOW()),  -- RAKOTOMALALA → Philosophie
(8, 16, 17, 1, 2.0, NOW());  -- RATOVOHERY → EPS

-- ============================================================
-- 16. HORAIRE_EDT
-- Table créée dans l'étape 0 ci-dessus
-- ============================================================
INSERT INTO horaire_edt (libelle, heure_debut, heure_fin, ordre, is_active, created_at) VALUES 
('07h30 - 09h00', '07:30:00', '09:00:00', 1, TRUE, NOW()),
('09h15 - 10h45', '09:15:00', '10:45:00', 2, TRUE, NOW()),
('11h00 - 12h30', '11:00:00', '12:30:00', 3, TRUE, NOW()),
('13h30 - 15h00', '13:30:00', '15:00:00', 4, TRUE, NOW()),
('15h15 - 16h45', '15:15:00', '16:45:00', 5, TRUE, NOW());

-- ============================================================
-- 17. EMPLOI DU TEMPS
-- Colonnes du schéma : affectation_id, salle_id, jour_semaine,
--                      heure_debut, heure_fin, date_debut_validite, created_at
-- + colonnes ajoutées : horaire_edt_id, periode_id
-- ============================================================
INSERT INTO emploi_du_temps (
    affectation_id, salle_id, jour_semaine,
    heure_debut, heure_fin,
    date_debut_validite, date_fin_validite
) VALUES 

-- LUNDI
(41, 1, 1, '07:30:00', '09:00:00', NULL, NULL), -- Maths
(42,1, 1, '09:15:00', '10:45:00', NULL, NULL), -- Français
(43,1, 1, '11:00:00', '12:30:00', NULL, NULL), -- Anglais

-- MARDI
(44,1, 2, '07:30:00', '09:00:00', NULL, NULL), -- Physique
(45,1, 2, '09:15:00', '10:45:00', NULL, NULL), -- SVT
(46,1, 2, '11:00:00', '12:30:00', NULL, NULL), -- Histoire-Géo

-- MERCREDI
(47, 1, 3, '07:30:00', '09:00:00', NULL, NULL), -- Maths
(48,1, 3, '09:15:00', '10:45:00', NULL, NULL), -- Philosophie

-- JEUDI
(41,1, 4, '07:30:00', '09:00:00', NULL, NULL), -- Français
(44,1, 4, '09:15:00', '10:45:00', NULL, NULL), -- Anglais
(46,1, 4, '11:00:00', '12:30:00', NULL, NULL), -- EPS

-- VENDREDI
(47,1, 5, '07:30:00', '09:00:00', NULL, NULL), -- Physique
(48,1, 5, '09:15:00', '10:45:00', NULL, NULL), -- SVT

-- SAMEDI
(44,1, 6, '07:30:00', '09:00:00', NULL, NULL); -- Histoire-Géo
-- ============================================================
-- 18. SEANCES
-- Une occurrence réelle par créneau emploi_du_temps
-- ============================================================
INSERT INTO seances (emploi_du_temps_id, date_seance, heure_debut, heure_fin, a_eu_lieu, created_at) VALUES 
(15,  '2025-09-15', '07:30:00', '09:00:00', TRUE, NOW()),
(16,  '2025-09-17', '07:30:00', '09:00:00', TRUE, NOW()),
(17,  '2025-09-15', '09:15:00', '10:45:00', TRUE, NOW()),
(18,  '2025-09-18', '09:15:00', '10:45:00', TRUE, NOW()),
(19,  '2025-09-16', '11:00:00', '12:30:00', TRUE, NOW()),
(20,  '2025-09-18', '11:00:00', '12:30:00', TRUE, NOW()),
(21,  '2025-09-17', '09:15:00', '10:45:00', TRUE, NOW()),
(22,  '2025-09-19', '09:15:00', '10:45:00', TRUE, NOW()),
(23,  '2025-09-16', '07:30:00', '09:00:00', TRUE, NOW()),
(15, '2025-09-18', '07:30:00', '09:00:00', TRUE, NOW()),
(16, '2025-09-15', '13:30:00', '15:00:00', TRUE, NOW()),
(17, '2025-09-17', '13:30:00', '15:00:00', TRUE, NOW()),
(18, '2025-09-16', '13:30:00', '15:00:00', TRUE, NOW()),
(19, '2025-09-19', '13:30:00', '15:00:00', TRUE, NOW());

-- ============================================================
-- 19. NOTES
-- saisi_par = user_id du professeur (2 à 6 selon la matière)
-- CORRECTION : suppression de "saisi_par=1" (user 1 = étudiant, pas prof)
-- ============================================================
INSERT INTO notes (
    etudiant_id, affectation_id, periode_id,
    type_evaluation, valeur, sur, saisi_par, created_at, updated_at
) VALUES 
(1, 41, 1, 'devoir_1', 15.50, 20, 2, NOW(), NOW()),  -- Maths D1 — saisi par prof Maths (user 2)
(1, 42, 1, 'devoir_2', 17.00, 20, 2, NOW(), NOW()),  -- Maths D2 — saisi par prof Maths (user 2)
(1, 43, 1, 'devoir_1', 14.00, 20, 3, NOW(), NOW()),  -- Français D1 — prof Français (user 3)
(1, 44, 1, 'devoir_1', 16.50, 20, 4, NOW(), NOW()),  -- Anglais D1 — prof Anglais (user 4)
(1, 45, 1, 'devoir_1', 15.00, 20, 5, NOW(), NOW()),  -- Physique D1 — prof Physique (user 5)
(1, 46, 1, 'devoir_1', 18.00, 20, 6, NOW(), NOW());  -- selSVT D1 — prof SVT (user 6)

INSERT INTO devoirs (
    matiere_id, professeur_id, titre, affectation_id,
    description, date_limite
) VALUES 

-- Maths
(9, 8, 'Devoir 1 - Fonctions', 41,
 'Étudier les fonctions affines et résoudre les exercices 1 à 10',
 '2026-02-10'),

(9, 8, 'Devoir 2 - Équations', 41,
 'Résolution des équations du second degré',
 '2026-02-20'),

-- Français
(10, 1, 'Dissertation', 42,
 'Rédiger une dissertation sur un thème littéraire',
 '2026-02-15'),

-- Anglais
(11, 2, 'Essay writing', 43,
 'Write a 200-word essay about technology',
 '2026-02-18'),

-- Physique
(12, 3, 'Exercices mécanique', 44,
 'Travail sur les lois de Newton',
 '2026-02-22'),

-- SVT
(13, 6, 'Schéma cellule', 45,
 'Réaliser un schéma annoté de la cellule',
 '2026-02-25');

 INSERT INTO lecons (
    affectation_id, titre, contenu, document_url
) VALUES 

-- Maths
(41, 'Les fonctions affines',
 'Cours sur les fonctions affines : définition, représentation graphique...',
 'https://ecole.com/docs/fonctions.pdf'),

-- Français
(42, 'Introduction à la dissertation',
 'Méthodologie pour rédiger une dissertation',
 'https://ecole.com/docs/dissertation.pdf'),

-- Anglais
(43, 'Present Simple',
 'Utilisation du present simple en anglais',
 'https://ecole.com/docs/present_simple.pdf'),

-- Physique
(44, 'Les lois de Newton',
 'Étude des forces et du mouvement',
 'https://ecole.com/docs/newton.pdf'),

-- SVT
(45, 'La cellule',
 'Structure et fonctionnement de la cellule',
 'https://ecole.com/docs/cellule.pdf');
COMMIT;

-- ============================================================
-- VÉRIFICATIONS
-- ============================================================
SELECT '=== INSERTION RÉUSSIE ===' AS status;
SELECT COUNT(*) AS etablissements         FROM etablissements;
SELECT COUNT(*) AS annees_scolaires       FROM annees_scolaires;
SELECT COUNT(*) AS niveaux                FROM niveaux;
SELECT COUNT(*) AS classes                FROM classes;
SELECT COUNT(*) AS salles                 FROM salles;
SELECT COUNT(*) AS matieres               FROM matieres;
SELECT COUNT(*) AS coefficients           FROM coefficients;
SELECT COUNT(*) AS periodes               FROM periodes;
SELECT COUNT(*) AS roles                  FROM roles;
SELECT COUNT(*) AS users                  FROM users;
SELECT COUNT(*) AS profils_etudiants      FROM profils_etudiants;
SELECT COUNT(*) AS profils_professeurs    FROM profils_professeurs;
SELECT COUNT(*) AS inscriptions           FROM inscriptions;
SELECT COUNT(*) AS affectations           FROM affectations_enseignement;
SELECT COUNT(*) AS horaire_edt            FROM horaire_edt;
SELECT COUNT(*) AS emploi_du_temps        FROM emploi_du_temps;
SELECT COUNT(*) AS seances                FROM seances;
SELECT COUNT(*) AS notes                  FROM notes;

-- Emploi du temps complet avec horaires
SELECT 
    e.id,
    e.jour_semaine,
    h.libelle      AS horaire,
    m.nom          AS matiere,
    p.nom          AS professeur,
    s.nom          AS salle
FROM emploi_du_temps e
JOIN horaire_edt h                 ON e.horaire_edt_id = h.id
JOIN affectations_enseignement a   ON e.affectation_id  = a.id
JOIN matieres m                    ON a.matiere_id       = m.id
JOIN profils_professeurs p         ON a.professeur_id    = p.id
JOIN salles s                      ON e.salle_id         = s.id
ORDER BY e.jour_semaine, h.ordre;