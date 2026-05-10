--
-- PostgreSQL database dump
--

\restrict GP8VyqJoMdfR1JWWZ13QHtuJ4jnT9DLE7X9ALfrVjQyI0obQQoda06Anm3Fbo7y

-- Dumped from database version 18.3
-- Dumped by pg_dump version 18.3

-- Started on 2026-05-10 10:06:43

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET transaction_timeout = 0;
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
-- TOC entry 224 (class 1259 OID 16519)
-- Name: ACCOUNT; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."ACCOUNT" (
    "ACCOUNT_ID" integer NOT NULL,
    "ACCOUNT_NUMBER" character varying(255),
    "ACCOUNT_TYPE" character varying(255),
    "ACCOUNT_BEGIN_BALANCE" double precision,
    "ACCOUNT_STATUS" boolean DEFAULT true,
    "CLIENT_ID" integer
);


ALTER TABLE public."ACCOUNT" OWNER TO postgres;

--
-- TOC entry 223 (class 1259 OID 16518)
-- Name: ACCOUNT_ACCOUNT_ID_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public."ACCOUNT_ACCOUNT_ID_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public."ACCOUNT_ACCOUNT_ID_seq" OWNER TO postgres;

--
-- TOC entry 5055 (class 0 OID 0)
-- Dependencies: 223
-- Name: ACCOUNT_ACCOUNT_ID_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public."ACCOUNT_ACCOUNT_ID_seq" OWNED BY public."ACCOUNT"."ACCOUNT_ID";


--
-- TOC entry 222 (class 1259 OID 16503)
-- Name: CLIENT; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."CLIENT" (
    "CLIENT_ID" integer NOT NULL,
    "CLIENT_PASSWORD" character varying(255),
    "CLIENT_STATUS" boolean DEFAULT true,
    "PERSON_ID" integer
);


ALTER TABLE public."CLIENT" OWNER TO postgres;

--
-- TOC entry 221 (class 1259 OID 16502)
-- Name: CLIENT_CLIENT_ID_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public."CLIENT_CLIENT_ID_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public."CLIENT_CLIENT_ID_seq" OWNER TO postgres;

--
-- TOC entry 5056 (class 0 OID 0)
-- Dependencies: 221
-- Name: CLIENT_CLIENT_ID_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public."CLIENT_CLIENT_ID_seq" OWNED BY public."CLIENT"."CLIENT_ID";


--
-- TOC entry 226 (class 1259 OID 16535)
-- Name: MOVEMENT; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."MOVEMENT" (
    "MOVEMENT_ID" integer NOT NULL,
    "MOVEMENT_DATE" timestamp(6) without time zone,
    "MOVEMENT_TYPE" character varying(255),
    "MOVEMENT_VALUE" double precision,
    "MOVEMENT_BALANCE" double precision,
    "ACCOUNT_ID" integer
);


ALTER TABLE public."MOVEMENT" OWNER TO postgres;

--
-- TOC entry 225 (class 1259 OID 16534)
-- Name: MOVEMENT_MOVEMENT_ID_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public."MOVEMENT_MOVEMENT_ID_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public."MOVEMENT_MOVEMENT_ID_seq" OWNER TO postgres;

--
-- TOC entry 5057 (class 0 OID 0)
-- Dependencies: 225
-- Name: MOVEMENT_MOVEMENT_ID_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public."MOVEMENT_MOVEMENT_ID_seq" OWNED BY public."MOVEMENT"."MOVEMENT_ID";


--
-- TOC entry 227 (class 1259 OID 32942)
-- Name: PARAMETER; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."PARAMETER" (
    "PARAMETER_CODE" character varying(255) NOT NULL,
    "PARAMETER_VALUE" character varying(255)
);


ALTER TABLE public."PARAMETER" OWNER TO postgres;

--
-- TOC entry 220 (class 1259 OID 16492)
-- Name: PERSON; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."PERSON" (
    "PERSON_ID" integer NOT NULL,
    "PERSON_NAME" character varying(255),
    "PERSON_GENDER" character varying(255),
    "PERSON_AGE" integer,
    "PERSON_IDENTIFICATION" character varying(255),
    "PERSON_ADDRESS" character varying(255),
    "PERSON_PHONE" character varying(255)
);


ALTER TABLE public."PERSON" OWNER TO postgres;

--
-- TOC entry 219 (class 1259 OID 16491)
-- Name: PERSON_PERSON_ID_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public."PERSON_PERSON_ID_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public."PERSON_PERSON_ID_seq" OWNER TO postgres;

--
-- TOC entry 5058 (class 0 OID 0)
-- Dependencies: 219
-- Name: PERSON_PERSON_ID_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public."PERSON_PERSON_ID_seq" OWNED BY public."PERSON"."PERSON_ID";


--
-- TOC entry 4878 (class 2604 OID 16522)
-- Name: ACCOUNT ACCOUNT_ID; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."ACCOUNT" ALTER COLUMN "ACCOUNT_ID" SET DEFAULT nextval('public."ACCOUNT_ACCOUNT_ID_seq"'::regclass);


--
-- TOC entry 4876 (class 2604 OID 16506)
-- Name: CLIENT CLIENT_ID; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."CLIENT" ALTER COLUMN "CLIENT_ID" SET DEFAULT nextval('public."CLIENT_CLIENT_ID_seq"'::regclass);


--
-- TOC entry 4880 (class 2604 OID 16538)
-- Name: MOVEMENT MOVEMENT_ID; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."MOVEMENT" ALTER COLUMN "MOVEMENT_ID" SET DEFAULT nextval('public."MOVEMENT_MOVEMENT_ID_seq"'::regclass);


--
-- TOC entry 4875 (class 2604 OID 16495)
-- Name: PERSON PERSON_ID; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."PERSON" ALTER COLUMN "PERSON_ID" SET DEFAULT nextval('public."PERSON_PERSON_ID_seq"'::regclass);


--
-- TOC entry 5046 (class 0 OID 16519)
-- Dependencies: 224
-- Data for Name: ACCOUNT; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public."ACCOUNT" ("ACCOUNT_ID", "ACCOUNT_NUMBER", "ACCOUNT_TYPE", "ACCOUNT_BEGIN_BALANCE", "ACCOUNT_STATUS", "CLIENT_ID") FROM stdin;
\.


--
-- TOC entry 5044 (class 0 OID 16503)
-- Dependencies: 222
-- Data for Name: CLIENT; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public."CLIENT" ("CLIENT_ID", "CLIENT_PASSWORD", "CLIENT_STATUS", "PERSON_ID") FROM stdin;
\.


--
-- TOC entry 5048 (class 0 OID 16535)
-- Dependencies: 226
-- Data for Name: MOVEMENT; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public."MOVEMENT" ("MOVEMENT_ID", "MOVEMENT_DATE", "MOVEMENT_TYPE", "MOVEMENT_VALUE", "MOVEMENT_BALANCE", "ACCOUNT_ID") FROM stdin;
\.


--
-- TOC entry 5049 (class 0 OID 32942)
-- Dependencies: 227
-- Data for Name: PARAMETER; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public."PARAMETER" ("PARAMETER_CODE", "PARAMETER_VALUE") FROM stdin;
BA1	2000
\.


--
-- TOC entry 5042 (class 0 OID 16492)
-- Dependencies: 220
-- Data for Name: PERSON; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public."PERSON" ("PERSON_ID", "PERSON_NAME", "PERSON_GENDER", "PERSON_AGE", "PERSON_IDENTIFICATION", "PERSON_ADDRESS", "PERSON_PHONE") FROM stdin;
\.


--
-- TOC entry 5059 (class 0 OID 0)
-- Dependencies: 223
-- Name: ACCOUNT_ACCOUNT_ID_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public."ACCOUNT_ACCOUNT_ID_seq"', 2, true);


--
-- TOC entry 5060 (class 0 OID 0)
-- Dependencies: 221
-- Name: CLIENT_CLIENT_ID_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public."CLIENT_CLIENT_ID_seq"', 2, true);


--
-- TOC entry 5061 (class 0 OID 0)
-- Dependencies: 225
-- Name: MOVEMENT_MOVEMENT_ID_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public."MOVEMENT_MOVEMENT_ID_seq"', 9, true);


--
-- TOC entry 5062 (class 0 OID 0)
-- Dependencies: 219
-- Name: PERSON_PERSON_ID_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public."PERSON_PERSON_ID_seq"', 6, true);


--
-- TOC entry 4886 (class 2606 OID 16528)
-- Name: ACCOUNT PK_ACCOUNT_ID; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."ACCOUNT"
    ADD CONSTRAINT "PK_ACCOUNT_ID" PRIMARY KEY ("ACCOUNT_ID");


--
-- TOC entry 4884 (class 2606 OID 16512)
-- Name: CLIENT PK_CLIENT_ID; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."CLIENT"
    ADD CONSTRAINT "PK_CLIENT_ID" PRIMARY KEY ("CLIENT_ID");


--
-- TOC entry 4888 (class 2606 OID 16543)
-- Name: MOVEMENT PK_MOVEMENT_ID; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."MOVEMENT"
    ADD CONSTRAINT "PK_MOVEMENT_ID" PRIMARY KEY ("MOVEMENT_ID");


--
-- TOC entry 4890 (class 2606 OID 32955)
-- Name: PARAMETER PK_PARAMETER_CODE; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."PARAMETER"
    ADD CONSTRAINT "PK_PARAMETER_CODE" PRIMARY KEY ("PARAMETER_CODE");


--
-- TOC entry 4882 (class 2606 OID 16500)
-- Name: PERSON PK_PERSON_ID; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."PERSON"
    ADD CONSTRAINT "PK_PERSON_ID" PRIMARY KEY ("PERSON_ID");


--
-- TOC entry 4893 (class 2606 OID 16544)
-- Name: MOVEMENT FK_ACCOUNT_ID; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."MOVEMENT"
    ADD CONSTRAINT "FK_ACCOUNT_ID" FOREIGN KEY ("ACCOUNT_ID") REFERENCES public."ACCOUNT"("ACCOUNT_ID") ON UPDATE CASCADE ON DELETE CASCADE;


--
-- TOC entry 4892 (class 2606 OID 16529)
-- Name: ACCOUNT FK_CLIENT_ID; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."ACCOUNT"
    ADD CONSTRAINT "FK_CLIENT_ID" FOREIGN KEY ("CLIENT_ID") REFERENCES public."CLIENT"("CLIENT_ID");


--
-- TOC entry 4891 (class 2606 OID 16513)
-- Name: CLIENT FK_PERSON_ID; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."CLIENT"
    ADD CONSTRAINT "FK_PERSON_ID" FOREIGN KEY ("PERSON_ID") REFERENCES public."PERSON"("PERSON_ID") ON UPDATE CASCADE ON DELETE CASCADE;


-- Completed on 2026-05-10 10:06:43

--
-- PostgreSQL database dump complete
--

\unrestrict GP8VyqJoMdfR1JWWZ13QHtuJ4jnT9DLE7X9ALfrVjQyI0obQQoda06Anm3Fbo7y

