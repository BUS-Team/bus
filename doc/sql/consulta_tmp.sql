--recebo: <id_busao>, <destino>, <nome_ponto>
--query geral
SELECT rbs.moment
	FROM route r 
		INNER JOIN route_has_bus_stop rbs ON (r.id = rbs.route_id)
		INNER JOIN bus_stop bs ON (bs.id = rbs.bus_stop_id)
	WHERE r.bus_id = <id_busao>
	AND r.destination = '<destino>'
	AND bs.name LIKE '<nome_ponto>';
--query específica: <id_busao> = 307, <destino> = TERMINAL_CENTRAL, <nome_ponto> = ru_uel
SELECT rbs.moment
	FROM route r 
		INNER JOIN route_has_bus_stop rbs ON (r.id = rbs.route_id)
		INNER JOIN bus_stop bs ON (bs.id = rbs.bus_stop_id)
	WHERE r.bus_id = 307
	AND r.destination = 'TERMINAL_CENTRAL'
	AND bs.name LIKE 'ru_uel';