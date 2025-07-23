--
-- PostgreSQL database dump
--

-- Dumped from database version 17.4
-- Dumped by pg_dump version 17.4

-- Started on 2025-07-21 21:53:14

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

--
-- TOC entry 4 (class 2615 OID 2200)
-- Name: public; Type: SCHEMA; Schema: -; Owner: pg_database_owner
--

CREATE SCHEMA public;


ALTER SCHEMA public OWNER TO pg_database_owner;

--
-- TOC entry 4855 (class 0 OID 0)
-- Dependencies: 4
-- Name: SCHEMA public; Type: COMMENT; Schema: -; Owner: pg_database_owner
--

COMMENT ON SCHEMA public IS 'standard public schema';


SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 217 (class 1259 OID 56256)
-- Name: chats_entity; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.chats_entity (
    fld_deleted boolean,
    fld_enabled boolean,
    fld_chat_id bigint NOT NULL,
    fld_created_date timestamp(6) without time zone,
    fld_deleted_date timestamp(6) without time zone,
    fld_join_sender_id bigint,
    fld_updated_date timestamp(6) without time zone,
    fld_chat_description character varying(255),
    fld_chat_title character varying(255),
    fld_created_by character varying(255),
    fld_updated_by character varying(255)
);


ALTER TABLE public.chats_entity OWNER TO postgres;

--
-- TOC entry 218 (class 1259 OID 56263)
-- Name: core_actions; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.core_actions (
    fld_deleted boolean,
    fld_enabled boolean,
    fld_action_id bigint NOT NULL,
    fld_created_date timestamp(6) without time zone,
    fld_deleted_date timestamp(6) without time zone,
    fld_updated_date timestamp(6) without time zone,
    action_name character varying(255),
    action_name_fa character varying(255),
    fld_created_by character varying(255),
    fld_updated_by character varying(255)
);


ALTER TABLE public.core_actions OWNER TO postgres;

--
-- TOC entry 219 (class 1259 OID 56270)
-- Name: core_combo; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.core_combo (
    fld_deleted boolean,
    fld_enabled boolean,
    fld_core_combo_id bigint NOT NULL,
    fld_created_date timestamp(6) without time zone,
    fld_deleted_date timestamp(6) without time zone,
    fld_updated_date timestamp(6) without time zone,
    fld_core_combo_name character varying(255),
    fld_core_combo_title character varying(255),
    fld_created_by character varying(255),
    fld_updated_by character varying(255)
);


ALTER TABLE public.core_combo OWNER TO postgres;

--
-- TOC entry 220 (class 1259 OID 56277)
-- Name: core_persons; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.core_persons (
    fld_deleted boolean,
    fld_enabled boolean,
    fld_created_date timestamp(6) without time zone,
    fld_deleted_date timestamp(6) without time zone,
    fld_person_id bigint NOT NULL,
    fld_updated_date timestamp(6) without time zone,
    fld_company_name character varying(255),
    fld_created_by character varying(255),
    fld_national_number character varying(255),
    fld_person_family character varying(255),
    fld_person_name character varying(255),
    fld_updated_by character varying(255)
);


ALTER TABLE public.core_persons OWNER TO postgres;

--
-- TOC entry 221 (class 1259 OID 56284)
-- Name: core_roles; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.core_roles (
    fld_deleted boolean,
    fld_enabled boolean,
    fld_created_date timestamp(6) without time zone,
    fld_deleted_date timestamp(6) without time zone,
    fld_role_id bigint NOT NULL,
    fld_updated_date timestamp(6) without time zone,
    fld_created_by character varying(255),
    fld_updated_by character varying(255),
    role_name character varying(255),
    role_name_title character varying(255)
);


ALTER TABLE public.core_roles OWNER TO postgres;

--
-- TOC entry 222 (class 1259 OID 56291)
-- Name: core_seq; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.core_seq (
    seq_count bigint,
    table_name character varying(255) NOT NULL
);


ALTER TABLE public.core_seq OWNER TO postgres;

--
-- TOC entry 223 (class 1259 OID 56296)
-- Name: core_users; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.core_users (
    fld_deleted boolean,
    fld_enabled boolean,
    fld_is_sys_admin boolean,
    fld_created_date timestamp(6) without time zone,
    fld_deleted_date timestamp(6) without time zone,
    fld_person_id bigint,
    fld_role_id bigint,
    fld_status bigint,
    fld_updated_date timestamp(6) without time zone,
    fld_user_id bigint NOT NULL,
    fld_created_by character varying(255),
    fld_updated_by character varying(255),
    fld_user_access character varying(255),
    fld_user_name character varying(255),
    fld_user_password character varying(255)
);


ALTER TABLE public.core_users OWNER TO postgres;

--
-- TOC entry 224 (class 1259 OID 56303)
-- Name: core_users_actions; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.core_users_actions (
    fld_action_id bigint NOT NULL,
    fld_user_id bigint NOT NULL
);


ALTER TABLE public.core_users_actions OWNER TO postgres;

--
-- TOC entry 225 (class 1259 OID 56308)
-- Name: m2m_for_chats; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.m2m_for_chats (
    fld_chat_id bigint NOT NULL,
    fld_receiver_id bigint NOT NULL
);


ALTER TABLE public.m2m_for_chats OWNER TO postgres;

--
-- TOC entry 4841 (class 0 OID 56256)
-- Dependencies: 217
-- Data for Name: chats_entity; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.chats_entity (fld_deleted, fld_enabled, fld_chat_id, fld_created_date, fld_deleted_date, fld_join_sender_id, fld_updated_date, fld_chat_description, fld_chat_title, fld_created_by, fld_updated_by) FROM stdin;
\.


--
-- TOC entry 4842 (class 0 OID 56263)
-- Dependencies: 218
-- Data for Name: core_actions; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.core_actions (fld_deleted, fld_enabled, fld_action_id, fld_created_date, fld_deleted_date, fld_updated_date, action_name, action_name_fa, fld_created_by, fld_updated_by) FROM stdin;
f	t	1	2025-06-30 17:21:10.726	\N	\N	SimpleName	مدیرسیستم	Amin	\N
f	t	2	2025-06-30 17:21:29.977	\N	\N	SimpleName	ثبت بیمه نامه عمر و زندگی	Amin	\N
f	t	3	2025-06-30 17:21:37.082	\N	\N	SimpleName	ثبت اخبار	Amin	\N
f	t	4	2025-06-30 17:21:44.197	\N	\N	SimpleName	ثبت اسلاید	Amin	\N
f	t	5	2025-06-30 17:21:53.058	\N	\N	SimpleName	ثبت جشنواره ها	Amin	\N
f	t	6	2025-06-30 17:22:01.454	\N	\N	SimpleName	گفتگو	Amin	\N
f	t	7	2025-06-30 17:22:10.384	\N	\N	SimpleName	اتوماسیون	Amin	\N
f	t	8	2025-06-30 17:22:22.517	\N	\N	SimpleName	پیام رسان	Amin	\N
f	t	9	2025-06-30 17:22:32.34	\N	\N	SimpleName	ثبت نمایندگان	Amin	\N
f	t	10	2025-06-30 17:22:38.519	\N	\N	SimpleName	تائید صدور بیمه نامه عمر و زندگی	Amin	\N
f	t	11	2025-06-30 17:22:47.041	\N	\N	SimpleName	بارگزاری شماره بیمه نامه های صادره	Amin	\N
f	t	12	2025-06-30 17:22:53.199	\N	\N	SimpleName	ایجاد و بارگزاری فایل کسورات	Amin	\N
\.


--
-- TOC entry 4843 (class 0 OID 56270)
-- Dependencies: 219
-- Data for Name: core_combo; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.core_combo (fld_deleted, fld_enabled, fld_core_combo_id, fld_created_date, fld_deleted_date, fld_updated_date, fld_core_combo_name, fld_core_combo_title, fld_created_by, fld_updated_by) FROM stdin;
f	t	1	2025-06-30 17:18:51.774	\N	\N	userStatus	فعال	Amin	\N
f	t	2	2025-06-30 17:19:06.108	\N	\N	userStatus	غیرفعال	Amin	\N
f	t	3	2025-06-30 17:19:21.77	\N	\N	userStatus	بلاک شده	Amin	\N
\.


--
-- TOC entry 4844 (class 0 OID 56277)
-- Dependencies: 220
-- Data for Name: core_persons; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.core_persons (fld_deleted, fld_enabled, fld_created_date, fld_deleted_date, fld_person_id, fld_updated_date, fld_company_name, fld_created_by, fld_national_number, fld_person_family, fld_person_name, fld_updated_by) FROM stdin;
f	t	2025-07-03 00:00:12.829	\N	7	\N	Undefined	Amin	1234567891	Akhondi	Amin	\N
f	t	2025-07-12 22:20:16.049	\N	8	\N	AminCo	Amin	1234566666890	AminTest	Amin0076	\N
f	t	2025-07-16 21:44:26.424	\N	15	\N	Sahand-Moshaver	Amin	0020000000	Heydari	Sam	\N
\.


--
-- TOC entry 4845 (class 0 OID 56284)
-- Dependencies: 221
-- Data for Name: core_roles; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.core_roles (fld_deleted, fld_enabled, fld_created_date, fld_deleted_date, fld_role_id, fld_updated_date, fld_created_by, fld_updated_by, role_name, role_name_title) FROM stdin;
f	t	2025-06-30 17:39:59.386	\N	3	\N	Amin	\N	SimpleRole	کارکنان
f	t	2025-06-30 17:40:22.194	\N	4	\N	Amin	\N	SimpleRole	نمایندگان
f	t	2025-06-30 17:40:34.678	\N	5	\N	Amin	\N	SimpleRole	شرکت بیمه ایران
f	t	2025-06-30 17:40:53.222	\N	6	\N	Amin	\N	SpecialRole	کاربران خاص
f	t	2025-06-30 17:40:53.222	\N	7	\N	Amin	\N	SpecialRole	مدیرسامانه
\.


--
-- TOC entry 4846 (class 0 OID 56291)
-- Dependencies: 222
-- Data for Name: core_seq; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.core_seq (seq_count, table_name) FROM stdin;
0	ChatsEntitySeq
3	CoreComboEntitySeq
15	PersonsEntitySeq
31	UsersEntitySeq
12	ActionsEntitySeq
\.


--
-- TOC entry 4847 (class 0 OID 56296)
-- Dependencies: 223
-- Data for Name: core_users; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.core_users (fld_deleted, fld_enabled, fld_is_sys_admin, fld_created_date, fld_deleted_date, fld_person_id, fld_role_id, fld_status, fld_updated_date, fld_user_id, fld_created_by, fld_updated_by, fld_user_access, fld_user_name, fld_user_password) FROM stdin;
f	t	f	2025-07-16 14:06:40.739	\N	8	\N	1	\N	18	Amin	\N	\N	\N	\N
f	t	f	2025-07-16 15:40:38.622	\N	8	6	1	\N	25	Amin	\N	\N	\N	\N
f	t	t	\N	\N	7	3	\N	\N	1	\N	\N	\N	sam	$2a$10$ZDjIWqhwLGysSmdgZO9/3eQN7Qg.gT..H3T8B1ST49EkbDwe9Sb1O
f	t	f	2025-07-16 18:26:56.369	\N	8	6	1	\N	26	Amin	\N	\N	\N	\N
f	t	f	2025-07-16 18:38:10.449	\N	8	6	1	\N	27	Amin	\N	\N	\N	\N
f	t	f	2025-07-16 18:44:24.969	\N	8	6	1	\N	28	Amin	\N	\N	\N	\N
f	t	f	2025-07-16 20:07:37.954	\N	8	6	1	\N	29	Amin	\N	\N	\N	\N
f	t	f	2025-07-16 21:11:37.329	\N	8	6	1	\N	30	Amin	\N		1	$2a$10$dcN1BOg89xIJKz7y6j65deayXES50DKaxdwVnyPEg5xr/Zrpph/vO
f	t	f	2025-07-16 22:07:40.962	\N	15	7	1	\N	31	Amin	\N		admin	$2a$10$7VohhEcZLlab.lljZg9g5O4s5MeZN/drQ6rc0u6ds4zEOEi8280YW
\.


--
-- TOC entry 4848 (class 0 OID 56303)
-- Dependencies: 224
-- Data for Name: core_users_actions; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.core_users_actions (fld_action_id, fld_user_id) FROM stdin;
9	1
8	1
2	27
1	27
2	28
1	28
1	29
2	29
2	30
1	30
4	31
6	31
2	31
8	31
1	31
10	31
12	31
3	31
9	31
5	31
11	31
7	31
\.


--
-- TOC entry 4849 (class 0 OID 56308)
-- Dependencies: 225
-- Data for Name: m2m_for_chats; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.m2m_for_chats (fld_chat_id, fld_receiver_id) FROM stdin;
\.


--
-- TOC entry 4673 (class 2606 OID 56262)
-- Name: chats_entity chats_entity_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.chats_entity
    ADD CONSTRAINT chats_entity_pkey PRIMARY KEY (fld_chat_id);


--
-- TOC entry 4675 (class 2606 OID 56269)
-- Name: core_actions core_actions_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.core_actions
    ADD CONSTRAINT core_actions_pkey PRIMARY KEY (fld_action_id);


--
-- TOC entry 4677 (class 2606 OID 56276)
-- Name: core_combo core_combo_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.core_combo
    ADD CONSTRAINT core_combo_pkey PRIMARY KEY (fld_core_combo_id);


--
-- TOC entry 4679 (class 2606 OID 56283)
-- Name: core_persons core_persons_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.core_persons
    ADD CONSTRAINT core_persons_pkey PRIMARY KEY (fld_person_id);


--
-- TOC entry 4681 (class 2606 OID 56290)
-- Name: core_roles core_roles_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.core_roles
    ADD CONSTRAINT core_roles_pkey PRIMARY KEY (fld_role_id);


--
-- TOC entry 4683 (class 2606 OID 56295)
-- Name: core_seq core_seq_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.core_seq
    ADD CONSTRAINT core_seq_pkey PRIMARY KEY (table_name);


--
-- TOC entry 4687 (class 2606 OID 56307)
-- Name: core_users_actions core_users_actions_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.core_users_actions
    ADD CONSTRAINT core_users_actions_pkey PRIMARY KEY (fld_action_id, fld_user_id);


--
-- TOC entry 4685 (class 2606 OID 56302)
-- Name: core_users core_users_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.core_users
    ADD CONSTRAINT core_users_pkey PRIMARY KEY (fld_user_id);


--
-- TOC entry 4692 (class 2606 OID 56331)
-- Name: core_users_actions fk5fm6xsrf4r6o1nxmtfbcxqqjd; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.core_users_actions
    ADD CONSTRAINT fk5fm6xsrf4r6o1nxmtfbcxqqjd FOREIGN KEY (fld_action_id) REFERENCES public.core_actions(fld_action_id);


--
-- TOC entry 4689 (class 2606 OID 56321)
-- Name: core_users fk7t073gov3vq9a6nm8qudre8ry; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.core_users
    ADD CONSTRAINT fk7t073gov3vq9a6nm8qudre8ry FOREIGN KEY (fld_role_id) REFERENCES public.core_roles(fld_role_id);


--
-- TOC entry 4690 (class 2606 OID 56316)
-- Name: core_users fkay0wjbou8kbbbuxmlje411tti; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.core_users
    ADD CONSTRAINT fkay0wjbou8kbbbuxmlje411tti FOREIGN KEY (fld_person_id) REFERENCES public.core_persons(fld_person_id);


--
-- TOC entry 4694 (class 2606 OID 56346)
-- Name: m2m_for_chats fkd450iag2w9aa7g6x86he4lwnc; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.m2m_for_chats
    ADD CONSTRAINT fkd450iag2w9aa7g6x86he4lwnc FOREIGN KEY (fld_chat_id) REFERENCES public.chats_entity(fld_chat_id);


--
-- TOC entry 4695 (class 2606 OID 56341)
-- Name: m2m_for_chats fkddx20vk8tfi3gmlmqpy3mya2t; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.m2m_for_chats
    ADD CONSTRAINT fkddx20vk8tfi3gmlmqpy3mya2t FOREIGN KEY (fld_receiver_id) REFERENCES public.core_users(fld_user_id);


--
-- TOC entry 4688 (class 2606 OID 56311)
-- Name: chats_entity fkkgkient28iw4jyvdcowmkxrca; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.chats_entity
    ADD CONSTRAINT fkkgkient28iw4jyvdcowmkxrca FOREIGN KEY (fld_join_sender_id) REFERENCES public.core_users(fld_user_id);


--
-- TOC entry 4693 (class 2606 OID 56336)
-- Name: core_users_actions fkkrdhu7yyt2i71v7rvu4yc2f04; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.core_users_actions
    ADD CONSTRAINT fkkrdhu7yyt2i71v7rvu4yc2f04 FOREIGN KEY (fld_user_id) REFERENCES public.core_users(fld_user_id);


--
-- TOC entry 4691 (class 2606 OID 56326)
-- Name: core_users fkpfx0rusutfv2ttvj8j6erb67p; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.core_users
    ADD CONSTRAINT fkpfx0rusutfv2ttvj8j6erb67p FOREIGN KEY (fld_status) REFERENCES public.core_combo(fld_core_combo_id);


-- Completed on 2025-07-21 21:53:14

--
-- PostgreSQL database dump complete
--

