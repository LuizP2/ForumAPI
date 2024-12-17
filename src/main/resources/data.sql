create table if not exists curso(
        idcurso int,
        nome varchar,
        categoria varchar
);
create table if not exists usuario(
        iduser int,
        nome varchar,
        email varchar
);

insert into curso (idcurso, nome, categoria) values (1, "kotlin", "Programação");
insert into usuario( iduser, nome, email) values (1, "Vitola do luizinho", "Vitola@teamo.com")