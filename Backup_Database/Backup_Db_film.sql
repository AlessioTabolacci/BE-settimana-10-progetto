PGDMP     $    2                z            film    14.1    14.1 	    �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            �           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            �           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            �           1262    17315    film    DATABASE     `   CREATE DATABASE film WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'Italian_Italy.1252';
    DROP DATABASE film;
                postgres    false            �            1259    17317    film    TABLE     �   CREATE TABLE public.film (
    id integer NOT NULL,
    anno integer,
    incasso character varying(255),
    regista character varying(255),
    genere character varying(255),
    titolo character varying(255)
);
    DROP TABLE public.film;
       public         heap    postgres    false            �            1259    17316    hibernate_sequence    SEQUENCE     {   CREATE SEQUENCE public.hibernate_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 )   DROP SEQUENCE public.hibernate_sequence;
       public          postgres    false            �          0    17317    film 
   TABLE DATA           J   COPY public.film (id, anno, incasso, regista, genere, titolo) FROM stdin;
    public          postgres    false    210   {       �           0    0    hibernate_sequence    SEQUENCE SET     A   SELECT pg_catalog.setval('public.hibernate_sequence', 12, true);
          public          postgres    false    209            ]           2606    17323    film film_pkey 
   CONSTRAINT     L   ALTER TABLE ONLY public.film
    ADD CONSTRAINT film_pkey PRIMARY KEY (id);
 8   ALTER TABLE ONLY public.film DROP CONSTRAINT film_pkey;
       public            postgres    false    210            �     x�}�M��8F��+Xt��TPD���6M[�	1$����^M�8���\U�&]����:�89%׳�; ��q�no��q`��m�����0��Wt��� v�O|��E�����'�R�w�BJ�d���B��ڋ�x��L�����u�ӽ
���.Iz/�A�@\�>���}�����y�R�h�x+�=%�TR��/���N�l�=��b7Z262��Χ����K�C�.���%ˎ��^J�"�8Pa� �
��D
@I�R"%G*�9�g�����0��ᒧܘ�l;m�, �^��q����S�\>Q+�7��JE v�i��g�� �
(�`ho�y�t+��P�ϯ�iIƣ()dj��YO�&r}˰����N�����K.S\BK�&]'t��&�W.L� ��7����l5�m\6mƧK='���t�́iւ����3��h�'�(����s$٤E�\�9y>��(b�a�ƫ#�8<.��p��a�'ôIVE�ߧ{�<����橀n����y��1��	V+� '�Km�*r��j�*o��P6_�7->i5�ԡ��i�Tn�ց���R��9:�,5�%MX|�,=?n}c.�1�Z�����Ţ��1RĀ�R�6�:y���ɸ����|�U�]<~.�v2�FY�dU[�����{}��1���6���/��� ��ˣ�������t4.�]�7,������
�o���M���X�H:���a%&_��=���fP�y�SDk�u ��,� ��`�     