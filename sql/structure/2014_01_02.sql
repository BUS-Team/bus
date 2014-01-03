BEGIN;

CREATE TABLE localization.route (
	id	SERIAL,
	name	VARCHAR(30) NOT NULL,

	CONSTRAINT pk_route_id PRIMARY KEY (id)
);

CREATE TABLE localization.bus_stop (
	id	SERIAL,
	name	VARCHAR(30) NOT NULL,

	CONSTRAINT pk_bus_stop_id PRIMARY KEY (id)
);

CREATE TABLE localization.destination (
	id	SERIAL,
	name	VARCHAR(30) NOT NULL,

	CONSTRAINT pk_destination_id PRIMARY KEY (id)
);

CREATE TABLE localization.route_bus_stop (
	route_id	INTEGER,
	bus_stop_id	INTEGER,

	CONSTRAINT pk_route_bus_stop PRIMARY KEY (route_id, bus_stop_id),

	CONSTRAINT fk_route_bus_stop_route_id 
	FOREIGN KEY (route_id) REFERENCES localization.route(id)
	ON DELETE CASCADE,

	CONSTRAINT fk_route_bus_stop_bus_stop_id
	FOREIGN KEY (bus_stop_id) REFERENCES localization.bus_stop(id)
	ON DELETE CASCADE
);

CREATE TABLE localization.route_destination (
	route_id	INTEGER,
	destination_id	INTEGER,

	CONSTRAINT pk_route_destination PRIMARY KEY (route_id, destination_id),

	CONSTRAINT fk_route_destination_route_id
	FOREIGN KEY (route_id) REFERENCES localization.route(id)
	ON DELETE CASCADE,
	
	CONSTRAINT fk_route_destination_destination_id
	FOREIGN KEY (destination_id) REFERENCES localization.destination(id)
	ON DELETE CASCADE
);
END;
