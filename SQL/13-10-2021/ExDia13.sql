-- create table professor
-- (codporf INT primary key,
-- nomeprof varchar(40)not null,
-- cpf varchar(11) not null unique,
-- areaprof varchar(12),
-- carga integer);

-- create table disciplina
-- (coddisc char(6) primary key,
-- nomedisc varchar(40) not null,
-- codprof integer);

-- insert into professor VALUES 
-- (1,'Lucas',11122244455,'BIOLOGICAS',20),
-- (2,'Maria',44466677788,'EXATAS',10),
-- (3,'Jonas',11144455532,'HUMANAS',15),
-- (4,'Ana',99900077745,'EXATAS',20),
-- (5,'Samuel',45663265462,'EXATAS',14)

-- insert into disciplina VALUES
-- ('190-E','ingles',3),
-- ('222-R','frances',3),
-- ('234-H','fisica',5),
-- ('432-I','matematica',5),
-- ('444-A','banco de dados',4),
-- ('673-B','biologia',1),
-- ('876-x','fisiologia',1),
-- ('887-W','java',4),
-- ('908-X','eletricidade',2)

-- 4.1
alter table disciplina
add constraint fkcodprof
foreign key (codprof)
references professor(codprof);

-- 4.2
alter table professor
add constraint ckcargaMaiorDez
check (carga >=10);

-- 4.3
alter table professor
add constraint ckarea
check (areaprof in('EXATAS','HUMANAS','BIOLOGICAS'));

-- 5.1
insert into professor values ('5','Luciana','35646637677','EXATAS',12);
-- id duplicado

-- 5.2
insert into professor values (6,'Lourdes','77777777889','HUMANAS',8);
-- carga menor que 10

-- 5.3
insert into professor values (7,'Sergio','55555554442','TI',12);
-- areaprof errada 

-- 5.5
insert into disciplina values ('888-A','filosofia',8);
-- sim, fkcroprof, é necessario a adição de outro professor com id 8 na tabela 'professor'

-- 5.7
select p.codprof, p.nomeprof, p.areaprof, p.carga, d.coddisc, d.nomedisc 
from professor p, disciplina d;

-- 5.9
-- não pois não está em cascata

-- 5.11
insert into disciplina values (955-A,'artes',NULL);
-- codprof não pode ser null