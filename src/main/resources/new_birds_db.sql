--
-- PostgreSQL database dump
--

-- Dumped from database version 12.3
-- Dumped by pg_dump version 12.3

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

--
-- Name: bird_color; Type: TYPE; Schema: public; Owner: ornithologist
--

CREATE TYPE public.bird_color AS ENUM (
    'black',
    'white',
    'black & white',
    'grey',
    'red',
    'red & white'
);


ALTER TYPE public.bird_color OWNER TO ornithologist;

--
-- Name: bird_species; Type: TYPE; Schema: public; Owner: ornithologist
--

CREATE TYPE public.bird_species AS ENUM (
    'pigeon',
    'sparrow',
    'magpie',
    'crow',
    'titmouse'
);


ALTER TYPE public.bird_species OWNER TO ornithologist;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: bird_colors_info; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.bird_colors_info (
    color public.bird_color,
    count integer
);


ALTER TABLE public.bird_colors_info OWNER TO postgres;

--
-- Name: bird_species_info; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.bird_species_info (
    species public.bird_species,
    count integer
);


ALTER TABLE public.bird_species_info OWNER TO postgres;

--
-- Name: birds; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.birds (
    species public.bird_species,
    name character varying NOT NULL,
    color public.bird_color,
    body_length integer,
    wingspan integer
);


ALTER TABLE public.birds OWNER TO postgres;

--
-- Name: birds_stat; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.birds_stat (
    body_length_mean numeric,
    body_length_median numeric,
    body_length_mode integer[],
    wingspan_mean numeric,
    wingspan_median numeric,
    wingspan_mode integer[]
);


ALTER TABLE public.birds_stat OWNER TO postgres;

--
-- Data for Name: bird_colors_info; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.bird_colors_info (color, count) FROM stdin;
grey	3
red	3
white	1
red & white	9
black	5
black & white	6
\.


--
-- Data for Name: bird_species_info; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.bird_species_info (species, count) FROM stdin;
\.


--
-- Data for Name: birds; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.birds (species, name, color, body_length, wingspan) FROM stdin;
pigeon	Ptichek	red & white	29	50
sparrow	Tima	black & white	14	23
magpie	Belka	black	44	52
pigeon	Kadu	grey	30	56
pigeon	Ptusha	red & white	31	63
crow	Cown	black & white	56	100
crow	Koul	red & white	78	95
sparrow	Like	black	18	24
magpie	Clod	red & white	45	54
titmouse	Birdy	red	12	22
crow	Nord	black	72	110
crow	Aska	red & white	68	120
titmouse	Hloya	white	14	24
pigeon	Taimy	red & white	32	67
titmouse	Klod	black & white	13	26
titmouse	Mikky	black	15	23
crow	Fanny	grey	61	98
pigeon	Loyd	black & white	33	60
magpie	Jim	red & white	46	56
magpie	Point	black & white	46	59
sparrow	Fleyk	red	17	26
sparrow	Viola	red & white	16	24
pigeon	Monika	black	34	55
pigeon	Hope	grey	35	53
crow	Sun	black & white	65	127
magpie	Moon	red & white	44	62
sparrow	Reyna	red	15	25
crow	Alan	black	68	120
crow		black	68	120
\.


--
-- Data for Name: birds_stat; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.birds_stat (body_length_mean, body_length_median, body_length_mode, wingspan_mean, wingspan_median, wingspan_mode) FROM stdin;
36.4074074074074074	33	{14}	57.5555555555555556	55	{24}
\.


--
-- Name: bird_colors_info bird_colors_info_color_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.bird_colors_info
    ADD CONSTRAINT bird_colors_info_color_key UNIQUE (color);


--
-- Name: bird_species_info bird_species_info_species_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.bird_species_info
    ADD CONSTRAINT bird_species_info_species_key UNIQUE (species);


--
-- Name: birds birds_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.birds
    ADD CONSTRAINT birds_pkey PRIMARY KEY (name);


--
-- Name: SCHEMA public; Type: ACL; Schema: -; Owner: ornithologist
--

REVOKE ALL ON SCHEMA public FROM postgres;
REVOKE ALL ON SCHEMA public FROM PUBLIC;
GRANT ALL ON SCHEMA public TO ornithologist;
GRANT ALL ON SCHEMA public TO PUBLIC;


--
-- Name: TABLE bird_colors_info; Type: ACL; Schema: public; Owner: postgres
--

GRANT SELECT ON TABLE public.bird_colors_info TO ornithologist;


--
-- Name: TABLE bird_species_info; Type: ACL; Schema: public; Owner: postgres
--

GRANT SELECT ON TABLE public.bird_species_info TO ornithologist;


--
-- Name: TABLE birds; Type: ACL; Schema: public; Owner: postgres
--

GRANT SELECT ON TABLE public.birds TO ornithologist;


--
-- Name: TABLE birds_stat; Type: ACL; Schema: public; Owner: postgres
--

GRANT SELECT ON TABLE public.birds_stat TO ornithologist;


--
-- Name: DEFAULT PRIVILEGES FOR TABLES; Type: DEFAULT ACL; Schema: public; Owner: ornithologist
--

ALTER DEFAULT PRIVILEGES FOR ROLE ornithologist IN SCHEMA public REVOKE ALL ON TABLES  FROM ornithologist;
ALTER DEFAULT PRIVILEGES FOR ROLE ornithologist IN SCHEMA public GRANT SELECT ON TABLES  TO ornithologist;


--
-- PostgreSQL database dump complete
--

