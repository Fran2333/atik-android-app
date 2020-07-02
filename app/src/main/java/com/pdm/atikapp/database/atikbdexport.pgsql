--
-- PostgreSQL database dump
--

-- Dumped from database version 12.3 (Debian 12.3-1.pgdg100+1)
-- Dumped by pg_dump version 12.3 (Debian 12.3-1.pgdg100+1)

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
-- Name: pgcrypto; Type: EXTENSION; Schema: -; Owner: -
--

CREATE EXTENSION IF NOT EXISTS pgcrypto WITH SCHEMA public;


--
-- Name: EXTENSION pgcrypto; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION pgcrypto IS 'cryptographic functions';


SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: categoria; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.categoria (
    id_categoria integer NOT NULL,
    nombre character varying(50),
    descripcion character varying(200)
);


ALTER TABLE public.categoria OWNER TO postgres;

--
-- Name: categoria_id_categoria_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.categoria_id_categoria_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.categoria_id_categoria_seq OWNER TO postgres;

--
-- Name: categoria_id_categoria_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.categoria_id_categoria_seq OWNED BY public.categoria.id_categoria;


--
-- Name: orden; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.orden (
    id_orden integer NOT NULL,
    id_cliente integer NOT NULL,
    tipo character varying(30),
    fecha_entrega date,
    hora_entrega time without time zone,
    subtotal double precision,
    total double precision,
    fecha_pedido date,
    id_ubicacion integer NOT NULL,
    id_promocion integer NOT NULL,
    estado character varying(15)
);


ALTER TABLE public.orden OWNER TO postgres;

--
-- Name: orden_id_cliente_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.orden_id_cliente_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.orden_id_cliente_seq OWNER TO postgres;

--
-- Name: orden_id_cliente_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.orden_id_cliente_seq OWNED BY public.orden.id_cliente;


--
-- Name: orden_id_orden_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.orden_id_orden_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.orden_id_orden_seq OWNER TO postgres;

--
-- Name: orden_id_orden_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.orden_id_orden_seq OWNED BY public.orden.id_orden;


--
-- Name: orden_id_promocion_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.orden_id_promocion_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.orden_id_promocion_seq OWNER TO postgres;

--
-- Name: orden_id_promocion_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.orden_id_promocion_seq OWNED BY public.orden.id_promocion;


--
-- Name: orden_id_ubicacion_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.orden_id_ubicacion_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.orden_id_ubicacion_seq OWNER TO postgres;

--
-- Name: orden_id_ubicacion_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.orden_id_ubicacion_seq OWNED BY public.orden.id_ubicacion;


--
-- Name: producto; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.producto (
    id_producto integer NOT NULL,
    nombre character varying(50),
    precio double precision,
    descripcion character varying(200),
    sabor character varying(20),
    tamanio double precision,
    indicaciones character varying(100),
    imagen bytea
);


ALTER TABLE public.producto OWNER TO postgres;

--
-- Name: producto_id_producto_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.producto_id_producto_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.producto_id_producto_seq OWNER TO postgres;

--
-- Name: producto_id_producto_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.producto_id_producto_seq OWNED BY public.producto.id_producto;


--
-- Name: productoxcategoria; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.productoxcategoria (
    id_categoria integer NOT NULL,
    id_producto integer NOT NULL
);


ALTER TABLE public.productoxcategoria OWNER TO postgres;

--
-- Name: productoxorden; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.productoxorden (
    id_producto integer NOT NULL,
    id_orden integer NOT NULL,
    cantidad double precision
);


ALTER TABLE public.productoxorden OWNER TO postgres;

--
-- Name: productoxorden_id_orden_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.productoxorden_id_orden_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.productoxorden_id_orden_seq OWNER TO postgres;

--
-- Name: productoxorden_id_orden_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.productoxorden_id_orden_seq OWNED BY public.productoxorden.id_orden;


--
-- Name: productoxorden_id_producto_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.productoxorden_id_producto_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.productoxorden_id_producto_seq OWNER TO postgres;

--
-- Name: productoxorden_id_producto_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.productoxorden_id_producto_seq OWNED BY public.productoxorden.id_producto;


--
-- Name: promocion; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.promocion (
    id_promocion integer NOT NULL,
    nombre character varying(50),
    descuento double precision
);


ALTER TABLE public.promocion OWNER TO postgres;

--
-- Name: promocion_id_promocion_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.promocion_id_promocion_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.promocion_id_promocion_seq OWNER TO postgres;

--
-- Name: promocion_id_promocion_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.promocion_id_promocion_seq OWNED BY public.promocion.id_promocion;


--
-- Name: rol; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.rol (
    id_rol integer NOT NULL,
    rol character varying(30)
);


ALTER TABLE public.rol OWNER TO postgres;

--
-- Name: rol_id_rol_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.rol_id_rol_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.rol_id_rol_seq OWNER TO postgres;

--
-- Name: rol_id_rol_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.rol_id_rol_seq OWNED BY public.rol.id_rol;


--
-- Name: ubicacion; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.ubicacion (
    id_ubicacion integer NOT NULL,
    nombre character varying(50),
    direccion character varying(150)
);


ALTER TABLE public.ubicacion OWNER TO postgres;

--
-- Name: ubicacion_id_ubicacion_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.ubicacion_id_ubicacion_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.ubicacion_id_ubicacion_seq OWNER TO postgres;

--
-- Name: ubicacion_id_ubicacion_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.ubicacion_id_ubicacion_seq OWNED BY public.ubicacion.id_ubicacion;


--
-- Name: usuario; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.usuario (
    id_usuario integer NOT NULL,
    nombre character varying(20),
    apellido character varying(20),
    telefono integer,
    correo character varying(50),
    nombre_usuario character varying(20),
    contrasenia character varying(50),
    id_rol integer NOT NULL
);


ALTER TABLE public.usuario OWNER TO postgres;

--
-- Name: usuario_id_rol_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.usuario_id_rol_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.usuario_id_rol_seq OWNER TO postgres;

--
-- Name: usuario_id_rol_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.usuario_id_rol_seq OWNED BY public.usuario.id_rol;


--
-- Name: usuario_id_usuario_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.usuario_id_usuario_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.usuario_id_usuario_seq OWNER TO postgres;

--
-- Name: usuario_id_usuario_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.usuario_id_usuario_seq OWNED BY public.usuario.id_usuario;


--
-- Name: categoria id_categoria; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.categoria ALTER COLUMN id_categoria SET DEFAULT nextval('public.categoria_id_categoria_seq'::regclass);


--
-- Name: orden id_orden; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.orden ALTER COLUMN id_orden SET DEFAULT nextval('public.orden_id_orden_seq'::regclass);


--
-- Name: orden id_cliente; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.orden ALTER COLUMN id_cliente SET DEFAULT nextval('public.orden_id_cliente_seq'::regclass);


--
-- Name: orden id_ubicacion; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.orden ALTER COLUMN id_ubicacion SET DEFAULT nextval('public.orden_id_ubicacion_seq'::regclass);


--
-- Name: orden id_promocion; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.orden ALTER COLUMN id_promocion SET DEFAULT nextval('public.orden_id_promocion_seq'::regclass);


--
-- Name: producto id_producto; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.producto ALTER COLUMN id_producto SET DEFAULT nextval('public.producto_id_producto_seq'::regclass);


--
-- Name: productoxorden id_producto; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.productoxorden ALTER COLUMN id_producto SET DEFAULT nextval('public.productoxorden_id_producto_seq'::regclass);


--
-- Name: productoxorden id_orden; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.productoxorden ALTER COLUMN id_orden SET DEFAULT nextval('public.productoxorden_id_orden_seq'::regclass);


--
-- Name: promocion id_promocion; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.promocion ALTER COLUMN id_promocion SET DEFAULT nextval('public.promocion_id_promocion_seq'::regclass);


--
-- Name: rol id_rol; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.rol ALTER COLUMN id_rol SET DEFAULT nextval('public.rol_id_rol_seq'::regclass);


--
-- Name: ubicacion id_ubicacion; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.ubicacion ALTER COLUMN id_ubicacion SET DEFAULT nextval('public.ubicacion_id_ubicacion_seq'::regclass);


--
-- Name: usuario id_usuario; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.usuario ALTER COLUMN id_usuario SET DEFAULT nextval('public.usuario_id_usuario_seq'::regclass);


--
-- Name: usuario id_rol; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.usuario ALTER COLUMN id_rol SET DEFAULT nextval('public.usuario_id_rol_seq'::regclass);


--
-- Data for Name: categoria; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.categoria (id_categoria, nombre, descripcion) FROM stdin;
1	Galletas	
2	Cupcakes	\N
3	Pasteles	\N
4	Salados	\N
5	Ocasiones Especiales	\N
6	Veganos y Gluten Free	\N
\.


--
-- Data for Name: orden; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.orden (id_orden, id_cliente, tipo, fecha_entrega, hora_entrega, subtotal, total, fecha_pedido, id_ubicacion, id_promocion, estado) FROM stdin;
\.


--
-- Data for Name: producto; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.producto (id_producto, nombre, precio, descripcion, sabor, tamanio, indicaciones, imagen) FROM stdin;
1	Choco-Chips	0.8	Galletas con chispas de chocolate	\N	\N	\N	\N
2	Galletas de Avena	0.8	Galletas de avena con chispas de chocolate	\N	\N	\N	\N
3	Galletas de Almendras	1	Galletas de almendras con jalea de fresas	\N	\N	\N	\N
4	Alfajores (Caja de 4)	2.75	Alfajores de dulce de leche	\N	\N	\N	\N
5	Macaroon	1.3	Gluten Free	\N	\N	\N	\N
6	Black and White	1.1	Galletas cubiertas mitad y mitad con glaseado de chocolate y vainilla	\N	\N	\N	\N
7	Galleta de chocolate blanco	0.9	Galletas de chocolate blanco	\N	\N	\N	\N
8	Galleta de mantequilla	0.8	Galletas de mantequilla en formas variadas	\N	\N	\N	\N
20	Pastel de chocolate	17	Pastel de chocolate con relleno de caramelo	Chocolate	12	\N	\N
21	Pastel de zanahoria	19	Pastel de zanahoria con cubierta de queso crema	Zanahoria	12	\N	\N
22	Cheesecake	22	Cheesecake	\N	12	\N	\N
23	Pie de manzana	19	Pie de manzana con caramelo	Manzana	12	\N	\N
24	Brownie	10	Brownie de doble chocolate	Chocolate	10	\N	\N
25	Mini pastel de chocolate	7	Pastel de chocolate con relleno de caramelo	Chocolate	6	\N	\N
26	Mini pastel de zanahoria	10	Pastel de zanahoria con cubierta de queso crema	Zanahoria	6	\N	\N
27	Pastel de Nutella	17.5	Pastel de vainilla con relleno de nutella y cubierto con ganache de chocolate blanco	Vainilla	16		\N
9	Galleta de jengibre	0.95	Galletas de jengibre	Jengibre	\N	\N	\N
10	Galletas de avena y fresa	1.1	Galletas de avena con trozos de fresas	Avena	\N	\N	\N
11	Galletas de limón 	1.1	Galletas de limón craqueladas de chocolate	Limón	\N	\N	\N
12	Cupcake de naranja	1.1	Cupcake de vainilla con mermelada de naranja	Vainilla	\N	\N	\N
13	Cupcake red velvet	1.1	Cupcake red velvet con cubierta de crema	Red Velvet	\N	\N	\N
14	Cupcake de vainilla con flores	1.8	Cupcake de vainilla decorado con flores comestibles	Vainilla	\N	\N	\N
15	Cupcake de chocolate	1	Cupcake de chocolate con cubierta de crema	Chocolate	\N	\N	\N
16	Cupcake de cajeta	1.75	Cupcake de chocolate relleno de cajeta	Chocolate	\N	\N	\N
17	Cupcake de zanahoria	1.75	Cupcake de zanahoria con cubierta de queso crema	Zanahoria	\N	\N	\N
18	Cupcake de limón	1.9	Cupcake de limón, rellenos con crema de limón y cubiertos con crema de mantequilla	Limón	\N	\N	\N
19	Cupcake de vainilla	1	Cupcake de vainilla con cubierta de chocolate	Vainilla	\N	\N	\N
28	Empanada chilena	1	Empanada chilena de queso	\N	\N	\N	\N
29	Croissant	1	Croissant relleno de jamon y queso	\N	\N	\N	\N
30	Focaccia 	0.9	Focaccia italiana servida con mezcla de quesos	\N	\N	\N	\N
31	Pastel de cumpleaños 	18.5	Torta de vainilla relleno de caramelo con mensaje especial de cumpleaños	Vainilla	16	\N	\N
32	Pastel con rosas	18.5	Torta de vainilla relleno de mermelada decorado con rosas	\N	\N	\N	\N
33	Pastel de chocolate Gluten-Free	19	Torta de chocolate vegana y sin gluten	Chocolate	14	\N	\N
34	Brownie Gluten-Free	13.5	Brownie vegano y libre de gluten	Chocolate	10	\N	\N
35	Pastel de fresas Gluten-Free	15	Torta con trozos de fresas gluten-free	Fresa	14	\N	\N
\.


--
-- Data for Name: productoxcategoria; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.productoxcategoria (id_categoria, id_producto) FROM stdin;
1	1
1	2
1	3
1	4
1	5
6	5
1	6
1	7
1	8
1	9
1	10
1	11
2	12
2	13
2	14
2	15
2	16
2	17
2	18
2	19
3	20
3	21
3	22
3	23
3	24
3	25
3	26
3	27
4	28
4	29
4	30
5	31
5	32
6	33
6	34
6	35
\.


--
-- Data for Name: productoxorden; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.productoxorden (id_producto, id_orden, cantidad) FROM stdin;
\.


--
-- Data for Name: promocion; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.promocion (id_promocion, nombre, descuento) FROM stdin;
\.


--
-- Data for Name: rol; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.rol (id_rol, rol) FROM stdin;
1	Administrador
2	Cliente
\.


--
-- Data for Name: ubicacion; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.ubicacion (id_ubicacion, nombre, direccion) FROM stdin;
1	Buena Vista	Res. Buena Vista 1, Pasaje 13 casa #19, Santa Tecla
2	Alpes Suizos	Res. Alpes Suizos 1, Senda Lourdes casa #17, Santa Tecla.
\.


--
-- Data for Name: usuario; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.usuario (id_usuario, nombre, apellido, telefono, correo, nombre_usuario, contrasenia, id_rol) FROM stdin;
2	cliente	cliente 	12345678	cliente@cliente.com	cliente	cliente	2
1	admin	admin 	12345678	admin@admin.com	admin	admin	1
\.


--
-- Name: categoria_id_categoria_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.categoria_id_categoria_seq', 1, false);


--
-- Name: orden_id_cliente_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.orden_id_cliente_seq', 1, false);


--
-- Name: orden_id_orden_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.orden_id_orden_seq', 1, false);


--
-- Name: orden_id_promocion_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.orden_id_promocion_seq', 1, false);


--
-- Name: orden_id_ubicacion_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.orden_id_ubicacion_seq', 1, false);


--
-- Name: producto_id_producto_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.producto_id_producto_seq', 1, false);


--
-- Name: productoxorden_id_orden_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.productoxorden_id_orden_seq', 1, false);


--
-- Name: productoxorden_id_producto_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.productoxorden_id_producto_seq', 1, false);


--
-- Name: promocion_id_promocion_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.promocion_id_promocion_seq', 1, false);


--
-- Name: rol_id_rol_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.rol_id_rol_seq', 1, false);


--
-- Name: ubicacion_id_ubicacion_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.ubicacion_id_ubicacion_seq', 1, false);


--
-- Name: usuario_id_rol_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.usuario_id_rol_seq', 1, false);


--
-- Name: usuario_id_usuario_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.usuario_id_usuario_seq', 1, false);


--
-- Name: categoria categoria_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.categoria
    ADD CONSTRAINT categoria_pkey PRIMARY KEY (id_categoria);


--
-- Name: orden orden_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.orden
    ADD CONSTRAINT orden_pkey PRIMARY KEY (id_orden);


--
-- Name: producto producto_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.producto
    ADD CONSTRAINT producto_pkey PRIMARY KEY (id_producto);


--
-- Name: productoxcategoria productoxcategoria_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.productoxcategoria
    ADD CONSTRAINT productoxcategoria_pk PRIMARY KEY (id_categoria, id_producto);


--
-- Name: productoxorden productoxorden_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.productoxorden
    ADD CONSTRAINT productoxorden_pkey PRIMARY KEY (id_producto);


--
-- Name: promocion promocion_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.promocion
    ADD CONSTRAINT promocion_pkey PRIMARY KEY (id_promocion);


--
-- Name: rol rol_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.rol
    ADD CONSTRAINT rol_pkey PRIMARY KEY (id_rol);


--
-- Name: ubicacion ubicacion_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.ubicacion
    ADD CONSTRAINT ubicacion_pkey PRIMARY KEY (id_ubicacion);


--
-- Name: usuario usuario_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.usuario
    ADD CONSTRAINT usuario_pkey PRIMARY KEY (id_usuario);


--
-- Name: productoxcategoria categoria_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.productoxcategoria
    ADD CONSTRAINT categoria_fk FOREIGN KEY (id_categoria) REFERENCES public.categoria(id_categoria);


--
-- Name: productoxorden id_orden; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.productoxorden
    ADD CONSTRAINT id_orden FOREIGN KEY (id_orden) REFERENCES public.orden(id_orden);


--
-- Name: productoxorden id_producto; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.productoxorden
    ADD CONSTRAINT id_producto FOREIGN KEY (id_producto) REFERENCES public.producto(id_producto);


--
-- Name: orden id_promocion; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.orden
    ADD CONSTRAINT id_promocion FOREIGN KEY (id_promocion) REFERENCES public.promocion(id_promocion);


--
-- Name: usuario id_rol; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.usuario
    ADD CONSTRAINT id_rol FOREIGN KEY (id_rol) REFERENCES public.rol(id_rol);


--
-- Name: orden id_ubicacion; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.orden
    ADD CONSTRAINT id_ubicacion FOREIGN KEY (id_ubicacion) REFERENCES public.ubicacion(id_ubicacion);


--
-- Name: orden id_usuario; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.orden
    ADD CONSTRAINT id_usuario FOREIGN KEY (id_cliente) REFERENCES public.usuario(id_usuario);


--
-- Name: productoxcategoria prodcuto_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.productoxcategoria
    ADD CONSTRAINT prodcuto_fk FOREIGN KEY (id_producto) REFERENCES public.producto(id_producto);


--
-- PostgreSQL database dump complete
--

