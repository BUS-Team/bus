--Cadastra rotas do 307
INSERT INTO route (bus_id, origin, destination) values (307, 'AVELINO_VIEIRA', 'TERMINAL_CENTRAL');
INSERT INTO route (bus_id, origin, destination) values (307, 'TERMINAL_CENTRAL', 'AVELINO_VIEIRA');
--Cadastra rotas do 305
INSERT INTO route (bus_id, origin, destination) values (305, 'UEL', 'TERMINAL_CENTRAL');
INSERT INTO route (bus_id, origin, destination) values (305, 'TERMINAL_CENTRAL', 'UEL');
--Cadastra ponto do ru 
--TODO: Mudar o id para serial (?), cadastrar latitude e longitude corretas
INSERT INTO bus_stop (id, latitude, longitude, name) values (1, 0, 0, 'ru_uel');
--horários do 307 (sentido terminal) no ponto do ru
INSERT INTO route_has_bus_stop (route_id, bus_stop_id, moment) VALUES (1, 1, '08:27');
INSERT INTO route_has_bus_stop (route_id, bus_stop_id, moment) VALUES (1, 1, '08:37');
INSERT INTO route_has_bus_stop (route_id, bus_stop_id, moment) VALUES (1, 1, '08:57');