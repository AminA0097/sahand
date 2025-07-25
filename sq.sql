COPY public.core_seq (seq_count, table_name) FROM stdin;
3	CoreComboEntitySeq
12	ActionsEntitySeq
7       RolesEntitySeq
\.

COPY public.core_roles (fld_deleted, fld_enabled, fld_created_date, fld_deleted_date, fld_role_id, fld_updated_date, fld_created_by, fld_updated_by, role_name, role_name_title) FROM stdin;
f	t	2025-06-30 17:39:59.386	\N	3	\N	Amin	\N	SimpleRole	کارکنان
f	t	2025-06-30 17:40:22.194	\N	4	\N	Amin	\N	SimpleRole	نمایندگان
f	t	2025-06-30 17:40:34.678	\N	5	\N	Amin	\N	SimpleRole	شرکت بیمه ایران
f	t	2025-06-30 17:40:53.222	\N	6	\N	Amin	\N	SpecialRole	کاربران خاص
f	t	2025-06-30 17:40:53.222	\N	7	\N	Amin	\N	SpecialRole	مدیرسامانه
\.

COPY public.core_combo (fld_deleted, fld_enabled, fld_core_combo_id, fld_created_date, fld_deleted_date, fld_updated_date, fld_core_combo_name, fld_core_combo_title, fld_created_by, fld_updated_by) FROM stdin;
f	t	1	2025-06-30 17:18:51.774	\N	\N	userStatus	فعال	Amin	\N
f	t	2	2025-06-30 17:19:06.108	\N	\N	userStatus	غیرفعال	Amin	\N
f	t	3	2025-06-30 17:19:21.77	\N	\N	userStatus	بلاک شده	Amin	\N
\.

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
