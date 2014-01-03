--
-- PostgreSQL database dump
--

-- Dumped from database version 9.1.11
-- Dumped by pg_dump version 9.1.11
-- Started on 2014-01-02 15:02:35 BRST

SET statement_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

--
-- TOC entry 6 (class 2615 OID 16386)
-- Name: localization; Type: SCHEMA; Schema: -; Owner: admin
--

CREATE SCHEMA localization;


ALTER SCHEMA localization OWNER TO admin;

--
-- TOC entry 1887 (class 0 OID 0)
-- Dependencies: 6
-- Name: SCHEMA localization; Type: COMMENT; Schema: -; Owner: admin
--

COMMENT ON SCHEMA localization IS 'This schema is related just to localization, bus stops and times. Data releted to publicity, for exemple, must be storeged in other schema.';


--
-- TOC entry 161 (class 3079 OID 11680)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 1888 (class 0 OID 0)
-- Dependencies: 161
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


-- Completed on 2014-01-02 15:02:35 BRST

--
-- PostgreSQL database dump complete
--

