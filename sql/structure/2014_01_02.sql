BEGIN;

CREATE TABLE localization.route (
	id	INTEGER,
	name	VARCHAR(30) NOT NULL,

	CONSTRAINT pk_route_id PRIMARY KEY (id)
);

CREATE TABLE localization.point (
	id	INTEGER,
	name	VARCHAR(30) NOT NULL,

	CONSTRAINT pk_point_id PRIMARY KEY (id)
);

CREATE TABLE localization.destination (
	id	INTEGER,
	name	VARCHAR(30) NOT NULL,

	CONSTRAINT pk_destination_id PRIMARY KEY (id)
);

CREATE TABLE localization.route_point (
	route_id	INTEGER,
	point_id	INTEGER,

	CONSTRAINT pk_route_point PRIMARY KEY (route_id, point_id),

	CONSTRAINT fk_route_point_route_id 
	FOREIGN KEY (route_id) REFERENCES localization.route(id)
	ON DELETE CASCADE,

	CONSTRAINT fk_route_point_point_id
	FOREIGN KEY (point_id) REFERENCES localization.point(id)
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