CREATE TABLE bus 
(
id          integer,
name        varchar(30) NOT NULL,--eg: 501 - Alto da boa vista
origin      varchar(30) NOT NULL,--eg: Avelino Vieira
destination varchar(30) NOT NULL,--eg: Terminal Central

CONSTRAINT pk_bus_id PRIMARY KEY(id),
CONSTRAINT uc_bus_name UNIQUE(name)
);

CREATE TABLE bus_stop
(
id        integer,
name      varchar(40) NOT NULL, --eg: Restaurante Universitário-UEL-Lado CCE
latitude  float NOT NULL,
longitude float NOT NULL,

CONSTRAINT pk_bus_stop_id PRIMARY KEY(id),
CONSTRAINT uc_bus_stop_name UNIQUE(name)
);

CREATE TABLE bus_nn_bus_stop
(
bus_id        integer,
bus_stop_id   integer,
moment        time,

CONSTRAINT pk_bus_nn_bus_stop PRIMARY KEY(bus_id, bus_stop_id, moment)
);