BEGIN;
INSERT INTO localization.point (id, name) VALUES (1, 'RU - Bairro-Centro');
INSERT INTO localization.point (id, name) VALUES (2, 'RU - Centro-Bairro');
INSERT INTO localization.point (id, name) VALUES (3, 'RU - CCH');
INSERT INTO localization.point (id, name) VALUES (4, 'RU - CCB');
INSERT INTO localization.point (id, name) VALUES (5, 'RU - CCA');

INSERT INTO localization.route (id, name) VALUES (1, '307');
INSERT INTO localization.route (id, name) VALUES (2, '305');
INSERT INTO localization.route (id, name) VALUES (3, '501 Parador');
INSERT INTO localization.route (id, name) VALUES (4, '307 Alto da boa vista');
INSERT INTO localization.route (id, name) VALUES (5, '109');

INSERT INTO localization.destination (id, name) VALUES (1, 'Centro-Bairro');
INSERT INTO localization.destination (id, name) VALUES (2, 'Bairro-Centro');
INSERT INTO localization.destination (id, name) VALUES (3, 'Ouro Verde - Vivi Xavier');
INSERT INTO localization.destination (id, name) VALUES (4, 'Vivi Xavier - Terminal Central');

INSERT INTO localization.route_destination (route_id, destination_id) VALUES (1, 1);
INSERT INTO localization.route_destination (route_id, destination_id) VALUES (1, 2);
INSERT INTO localization.route_destination (route_id, destination_id) VALUES (1, 3);
INSERT INTO localization.route_destination (route_id, destination_id) VALUES (1, 4);
INSERT INTO localization.route_destination (route_id, destination_id) VALUES (2, 2);
INSERT INTO localization.route_destination (route_id, destination_id) VALUES (3, 2);
INSERT INTO localization.route_destination (route_id, destination_id) VALUES (4, 2);
INSERT INTO localization.route_destination (route_id, destination_id) VALUES (5, 2);

INSERT INTO localization.route_point (route_id, point_id) VALUES (1, 1);
INSERT INTO localization.route_point (route_id, point_id) VALUES (1, 2);
INSERT INTO localization.route_point (route_id, point_id) VALUES (1, 3);
INSERT INTO localization.route_point (route_id, point_id) VALUES (1, 4);
INSERT INTO localization.route_point (route_id, point_id) VALUES (2, 2);
INSERT INTO localization.route_point (route_id, point_id) VALUES (3, 2);
INSERT INTO localization.route_point (route_id, point_id) VALUES (4, 2);

END;