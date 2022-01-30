-- Se limpia la bd para evitar conflictos en creación e inserción a las tablas
drop all objects;

-- Creación de la tabla colegio
create table colegio (
    id bigint primary key,
    nombre varchar(100) not null
);

-- Creación de la tabla curso
create table curso (
    id bigint primary key,
    grado smallint not null,
    salon varchar(10) not null,
    id_colegio bigint not null
);

-- Creación de la tabla profesor
create table profesor (
    id bigint primary key,
    nombre varchar(100) not null
);

-- Creación de la tabla estudiante
create table estudiante (
    id bigint primary key,
    nombre varchar(100) not null
);

-- Creación de la tabla asignatura
create table asignatura (
    id bigint primary key,
    nombre varchar(100) not null,
    id_profesor bigint not null,
    id_curso bigint not null
);

-- Creación de la tabla estudiante_asignatura
create table estudiante_asignatura (
    id_estudiante bigint,
    id_asignatura bigint
);

-- Asociación de la llave foránea de colegio en la tabla curso
alter table curso add foreign key (id_colegio) references colegio(id);

-- Asociación de la llave foránea de profesor en la tabla asignatura
alter table asignatura add foreign key (id_profesor) references profesor(id);

-- Asociación de la llave foránea de curso en la tabla asignatura
alter table asignatura add foreign key (id_curso) references curso(id);

-- Asociación de la llave foránea de estudiante en la tabla estudiante_asignatura
alter table estudiante_asignatura add foreign key (id_estudiante) references estudiante(id);

-- Asociación de la llave foránea de asignatura en la tabla estudiante_asignatura
alter table estudiante_asignatura add foreign key (id_asignatura) references asignatura(id);

-- Inserciones para la tabla colegio
insert into colegio (id, nombre) values (1, 'El colegio del Olimpo');

-- Inserciones para la tabla curso
insert into curso (id, grado, salon, id_colegio)
values (1, 10, 'A', 1), (2, 10, 'B', 1), (3, 11, 'A', 1), (4, 11, 'B', 1);

-- Inserciones para la tabla profesor
insert into profesor (id, nombre)
values (1, 'Némesis'), (2, 'Príapo'), (3, 'Iris');

-- Inserciones para la tabla estudiante
insert into estudiante (id, nombre)
values (1, 'Afrodita'), (2, 'Apolo'), (3, 'Ares'), (4, 'Artemisa'),
       (5, 'Atenea'), (6, 'Dionisio'), (7, 'Hefesto'), (8, 'Hera'),
       (9, 'Hermes'), (10, 'Hades'), (11, 'Poseidón'), (12, 'Zeus');

-- Inserciones para la tabla asignatura
insert into asignatura (id, nombre, id_profesor, id_curso)
values (1, 'Matemáticas', 1, 1), (2, 'Español', 2, 1),
       (3, 'Inglés básico', 3, 1), (4, 'Matemáticas', 1, 2),
       (5, 'Español', 2, 2), (6, 'Inglés avanzado', 3, 2),
       (7, 'Matemáticas', 1, 3), (8, 'Pre Icfes', 1, 3),
       (9, 'Matemáticas', 1, 4), (10, 'Pre Icfes', 1, 4);

-- Inserciones para la tabla estudiante_asignatura
insert into estudiante_asignatura (id_estudiante, id_asignatura)
select e.id, a.id
from asignatura a
inner join curso c on a.id_curso = c.id, estudiante e
where c.grado = 10
and salon = 'A'
and e.nombre in ('Afrodita', 'Apolo', 'Ares');

insert into estudiante_asignatura (id_estudiante, id_asignatura)
select e.id, a.id
from asignatura a
inner join curso c on a.id_curso = c.id, estudiante e
where c.grado = 10
and salon = 'B'
and e.nombre in ('Artemisa', 'Atenea', 'Dionisio');

insert into estudiante_asignatura (id_estudiante, id_asignatura)
select e.id, a.id
from asignatura a
inner join curso c on a.id_curso = c.id, estudiante e
where c.grado = 11
and salon = 'A'
and e.nombre in ('Hefesto', 'Hera');

insert into estudiante_asignatura (id_estudiante, id_asignatura)
select e.id, a.id
from asignatura a
inner join curso c on a.id_curso = c.id, estudiante e
where c.grado = 11
and salon = 'B'
and e.nombre in ('Hermes', 'Hades', 'Poseidón', 'Zeus');
