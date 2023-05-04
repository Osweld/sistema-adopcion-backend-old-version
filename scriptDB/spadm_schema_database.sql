-- SCRIPT 1 DATABASE____________________________________________________________________________________

-- Dumped from database version 15.2
-- Dumped by pg_dump version 15.2

-- Started on 2023-05-03 16:33:24

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

DROP DATABASE spadm_schema;
--
-- TOC entry 3367 (class 1262 OID 16399)
-- Name: spadm_schema; Type: DATABASE; Schema: -; Owner: postgres
--

CREATE DATABASE spadm_schema WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'Spanish_Spain.1252';


ALTER DATABASE spadm_schema OWNER TO postgres;

-- \connect spadm_schema
SET search_path TO spadm_schema;

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_table_access_method = heap;


--
-- SCRIPT 1 DATABASE FIN______________________________________________________________________________________
