INSERT INTO "user" (id, ref, first_name, last_name, email, phone) VALUES
                                                                        ('usr_1', 'REF001', 'Jean', 'Dupont', 'jean.dupont@email.com', '+33612345678'),
                                                                        ('usr_2', 'REF002', 'Marie', 'Curie', 'marie.curie@email.com', '+33623456789'),
                                                                        ('usr_3', 'REF003', 'Paul', 'Martin', 'paul.martin@email.com', '+33634567890'),
                                                                        ('usr_4', 'REF004', 'Alice', 'Bernard', 'alice.bernard@email.com', '+33645678901'),
                                                                        ('usr_5', 'REF005', 'Thomas', 'Dubois', 'thomas.dubois@email.com', '+33656789012');

INSERT INTO cash_flow (id, created_at, amount, user_id) VALUES
                                                            ('cf_1', '2026-01-10 10:30:00+00', 100.00, 'usr_1'),
                                                            ('cf_2', '2026-01-12 14:15:00+00', 250.50, 'usr_2'),
                                                            ('cf_3', '2026-01-15 09:00:00+00', 50.00, 'usr_3'),
                                                            ('cf_4', '2026-01-18 16:45:00+00', 80.00, 'usr_1'),
                                                            ('cf_5', '2026-01-20 11:20:00+00', 1200.00, 'usr_4');

INSERT INTO donation (id, comment) VALUES
                                       ('cf_1', 'Don ponctuel pour le projet A'),
                                       ('cf_2', 'Soutien mensuel à l''association'),
                                       ('cf_3', NULL),
                                       ('cf_4', 'Contribution événement caritatif'),
                                       ('cf_5', 'Don anonyme de début d''année');

INSERT INTO expense (id, reason, frequency) VALUES
                                                ('cf_1', 'Abonnement internet du bureau', 'MONTHLY'),
                                                ('cf_2', 'Achat de fournitures de bureau', 'NONE'),
                                                ('cf_3', 'Assurance annuelle des locaux', 'YEARLY'),
                                                ('cf_4', 'Frais d''hébergement serveur web', 'MONTHLY'),
                                                ('cf_5', 'Abonnement journalier presse', 'WEEKLY');