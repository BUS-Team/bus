CREATE TABLE route
(
id          integer,
origin      varchar(30) NOT NULL,--eg: Avelino Vieira
destination varchar(30) NOT NULL,--eg: Terminal Central
CONSTRAINT pk_route_id PRIMARY KEY(id, origin, destination)
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
bus_id        integer,
bus_stop_id   integer,
moment        time,

CONSTRAINT pk_route_has_bus_stop PRIMARY KEY(bus_id, bus_stop_id, moment)
);
