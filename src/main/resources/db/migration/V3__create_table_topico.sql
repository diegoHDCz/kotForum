create table topico(
    id bigint not null auto_increment,
    titulo varchar(50) null,
    mensagem varchar(300) null,
    data_criacao datetime null,
    status varchar(20) null,
    curso_id bigint not null,
    autor_id bigint not null,
    primary key(id),
    foreign key(curso_id) references curso(id),
    foreign key(autor_id) references usuario(id)
);



