--
-- PostgreSQL database dump
--

-- Dumped from database version 14.5 (Debian 14.5-1.pgdg110+1)
-- Dumped by pg_dump version 14.5 (Debian 14.5-1.pgdg110+1)

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

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: books; Type: TABLE; Schema: public; Owner: root
--

CREATE TABLE public.books (
    id bigint NOT NULL,
    peminjam character varying(255),
    penerbit character varying(255),
    pengarang character varying(255),
    status_buku character varying(255),
    tanggal_kembali date,
    tanggal_pinjam date,
    tanggal_terbit date,
    tebal_buku integer,
    title character varying(255)
);


ALTER TABLE public.books OWNER TO root;

--
-- Name: books_id_seq; Type: SEQUENCE; Schema: public; Owner: root
--

CREATE SEQUENCE public.books_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.books_id_seq OWNER TO root;

--
-- Name: books_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: root
--

ALTER SEQUENCE public.books_id_seq OWNED BY public.books.id;


--
-- Name: books id; Type: DEFAULT; Schema: public; Owner: root
--

ALTER TABLE ONLY public.books ALTER COLUMN id SET DEFAULT nextval('public.books_id_seq'::regclass);


--
-- Data for Name: books; Type: TABLE DATA; Schema: public; Owner: root
--

COPY public.books (id, peminjam, penerbit, pengarang, status_buku, tanggal_kembali, tanggal_pinjam, tanggal_terbit, tebal_buku, title) FROM stdin;
3	Despa	Bloomsbury	J.K Rowling	1	2023-08-10	2023-05-10	2003-06-21	766	Harry Potter and the Order of the Phoenix
2	-	Gramedia	J.K Rowling	0	\N	\N	1998-02-07	436	Harry Potter dan Kamar Rahasia
1	Donny	Gramedia	J.K Rowling	1	2022-10-20	2022-10-13	1999-05-06	384	Harry Potter dan Batu Bertuah
\.


--
-- Name: books_id_seq; Type: SEQUENCE SET; Schema: public; Owner: root
--

SELECT pg_catalog.setval('public.books_id_seq', 4, true);


--
-- Name: books books_pkey; Type: CONSTRAINT; Schema: public; Owner: root
--

ALTER TABLE ONLY public.books
    ADD CONSTRAINT books_pkey PRIMARY KEY (id);


--
-- PostgreSQL database dump complete
--

