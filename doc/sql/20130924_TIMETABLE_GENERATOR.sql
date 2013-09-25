CREATE TABLE route
(
id          serial,
bus_id      integer,
origin      varchar(30) NOT NULL,--eg: Avelino Vieira
destination varchar(30) NOT NULL,--eg: Terminal Central
CONSTRAINT pk_route_id PRIMARY KEY(id)
);

CREATE TABLE bus_stop
(
id        integer,
latitude  float NOT NULL,
longitude float NOT NULL,

CONSTRAINT pk_bus_stop_id PRIMARY KEY(id)
);

CREATE TABLE route_has_bus_stop
(
route_id        integer,
bus_stop_id   integer,
moment        time,

CONSTRAINT pk_route_has_bus_stop PRIMARY KEY(route_id, bus_stop_id, moment),
CONSTRAINT fk_route FOREIGN KEY (route_id) REFERENCES route(id),
CONSTRAINT fk_bus_stop FOREIGN KEY (bus_stop_id) REFERENCES bus_stop(id)
);
