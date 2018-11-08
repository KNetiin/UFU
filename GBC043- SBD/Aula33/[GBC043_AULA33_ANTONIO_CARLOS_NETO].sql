/* ALUNOS:
	ANTONIO CARLOS NETO
	HIGOR EMANUEL SOUZA SILVA
	MARCELO MENDONCA BORGES */

--drop schema Historico cascade;
create schema Historico;
set search_path to Historico;

-------------------------------------------------------------------------------------------------------------------------------------

create table Aluno 
(
	NumAluno integer primary key, 
	Nome char(20)
);

create table Disciplina 
(
	NumDisp integer primary key, 
	Nome char(40), 
	QuantCreditos integer
);

create table Matricula 
(
	NumAluno integer, 
	NumDisp integer, 
	Semestre integer, 
	Nota integer, 
	Faltas integer, 
	
	primary key(NumAluno, NumDisp, Semestre), 
	foreign key (NumAluno) references Aluno(NumAluno), 
	foreign key (NumDisp) references Disciplina(NumDisp)
);

create table Historico 
(
	NumAluno integer, 
	NumDisp integer, 
	Semestre integer, 
	Nota integer, 
	Faltas integer, 
	Usuario char(20), 
	DataHora Timestamp, 

	primary key(NumAluno, NumDisp)
);

insert into Aluno values (1,'Marco Nanini');
insert into Aluno values (2,'Marieta Severo');
insert into Aluno values (3,'Pedro Cardoso');
insert into Aluno values (4,'Rogerio Cardoso');
insert into Aluno values (5,'Lucio Mauro Filho');
insert into Aluno values (6,'Evandro Mesquita');
insert into Aluno values (7,'Andrea Beltrao');
insert into Aluno values (8,'Natalia Lage');
insert into Aluno values (9,'Guta Stresser');
insert into Aluno values (10,'Tonico Pereira');

insert into Disciplina values (100,'Improvisação',6);
insert into Disciplina values (101,'História do Teatro',4);
insert into Disciplina values (102,'Fundamentos da Linguagem Teatral',4);
insert into Disciplina values (103,'Expressão Corporal',4);
insert into Disciplina values (104,'Teatro na Educação',4);
insert into Disciplina values (105,'Expressão Vocal',4);
insert into Disciplina values (106,'Interpretação Teatral',4);
insert into Disciplina values (107,'Estética Teatral',4);
insert into Disciplina values (108,'Dramaturgia',4);
insert into Disciplina values (109,'Crítica Teatral',4);

insert into Matricula values (7,100,201502,0,0);
insert into Matricula values (10,107,200601,0,0);
insert into Matricula values (7,101,201301,0,0);
insert into Matricula values (1,106,200501,0,0);
insert into Matricula values (10,109,200901,0,0);
insert into Matricula values (6,106,200402,0,0);
insert into Matricula values (9,105,201001,0,0);
insert into Matricula values (7,102,201402,0,0);
insert into Matricula values (4,100,201302,0,0);
insert into Matricula values (7,103,200702,0,0);
insert into Matricula values (7,104,200801,0,0);
insert into Matricula values (10,101,200301,0,0);
insert into Matricula values (9,103,201102,0,0);
insert into Matricula values (3,106,200101,0,0);
insert into Matricula values (3,104,200801,0,0);
insert into Matricula values (1,102,201302,0,0);
insert into Matricula values (1,103,201501,0,0);
insert into Matricula values (1,106,201302,0,0);
insert into Matricula values (8,109,201001,0,0);
insert into Matricula values (8,101,200402,0,0);
insert into Matricula values (9,103,201301,0,0);
insert into Matricula values (1,100,200601,0,0);
insert into Matricula values (3,102,201201,0,0);
insert into Matricula values (7,105,200202,0,0);
insert into Matricula values (2,105,200202,0,0);
insert into Matricula values (9,104,200802,0,0);
insert into Matricula values (8,106,200202,0,0);
insert into Matricula values (1,109,200701,0,0);
insert into Matricula values (4,102,201302,0,0);
insert into Matricula values (9,104,201101,0,0);
insert into Matricula values (8,101,201202,0,0);
insert into Matricula values (9,100,201202,0,0);
insert into Matricula values (8,105,200602,0,0);
insert into Matricula values (4,102,201001,0,0);
insert into Matricula values (2,102,201001,0,0);
insert into Matricula values (2,102,200802,0,0);
insert into Matricula values (7,109,201302,0,0);
insert into Matricula values (2,102,201202,0,0);
insert into Matricula values (6,103,201001,0,0);
insert into Matricula values (6,100,201001,0,0);
insert into Matricula values (7,106,200801,0,0);
insert into Matricula values (4,105,200702,0,0);
insert into Matricula values (7,108,200602,0,0);
insert into Matricula values (7,107,200201,0,0);

-------------------------------------------------------------------------------------------------------------------------------------
--LETRA a
CREATE OR REPLACE FUNCTION ATUALIZACAO_H()
RETURNS trigger AS $$ 
DECLARE aux integer;
	cont record;
BEGIN
	aux := 0;
	FOR cont IN SELECT * FROM HISTORICO 
		LOOP
			IF ((CONT.NumAluno = new.NumAluno) AND (CONT.NumDisp = new.NumDisp)) THEN
				aux := 1;
				--CONT.Semestre = new.Semestre;
				CONT.Nota := new.Nota;
				CONT.Faltas := new.Faltas;
				CONT.Usuario := current_user;
				CONT.DataHora := now();
			END IF;
		END LOOP;
	--END FOR;
	
	IF aux = 0 THEN
		INSERT INTO HISTORICO (NumAluno, NumDisp, Semestre, Nota, Faltas, Usuario, DataHora)
			VALUES (new.NumAluno, new.NumDisp, new.Semestre, new.Nota, new.Faltas, current_user, now());
	END IF;
	RETURN NULL;
END $$ LANGUAGE 'plpgsql';

CREATE TRIGGER AFTER_ATUALIZACAO_M
AFTER UPDATE OF Nota, Faltas ON MATRICULA
FOR EACH ROW
WHEN (( new.Nota  >= 70 ) AND ( new.Faltas <= 18 ))
EXECUTE PROCEDURE ATUALIZACAO_H();

-------------------------------------------------------------------------------------------------------------------------------------

UPDATE Matricula SET  Nota = 87, Faltas = 12 where NumAluno =7 and NumDisp = 100 and Semestre = 201502;
UPDATE Matricula SET  Nota = 87, Faltas = 2 where NumAluno =10 and NumDisp = 107 and Semestre = 200601;
UPDATE Matricula SET  Nota = 81, Faltas = 2 where NumAluno =7 and NumDisp = 101 and Semestre = 201301;
UPDATE Matricula SET  Nota = 92, Faltas = 16 where NumAluno =1 and NumDisp = 106 and Semestre = 200501;
UPDATE Matricula SET  Nota = 97, Faltas = 8 where NumAluno =10 and NumDisp = 109 and Semestre = 200901;
UPDATE Matricula SET  Nota = 79, Faltas = 12 where NumAluno =6 and NumDisp = 106 and Semestre = 200402;
UPDATE Matricula SET  Nota = 79, Faltas = 10 where NumAluno =9 and NumDisp = 105 and Semestre = 201001;
UPDATE Matricula SET  Nota = 90, Faltas = 10 where NumAluno =7 and NumDisp = 102 and Semestre = 201402;
UPDATE Matricula SET  Nota = 78, Faltas = 16 where NumAluno =4 and NumDisp = 100 and Semestre = 201302;
UPDATE Matricula SET  Nota = 85, Faltas = 0 where NumAluno =7 and NumDisp = 103 and Semestre = 200702;
UPDATE Matricula SET  Nota = 97, Faltas = 2 where NumAluno =7 and NumDisp = 104 and Semestre = 200801;
UPDATE Matricula SET  Nota = 75, Faltas = 12 where NumAluno =10 and NumDisp = 101 and Semestre = 200301;
UPDATE Matricula SET  Nota = 96, Faltas = 2 where NumAluno =9 and NumDisp = 103 and Semestre = 201102;
UPDATE Matricula SET  Nota = 55, Faltas = 20 where NumAluno =3 and NumDisp = 106 and Semestre = 200101;
UPDATE Matricula SET  Nota = 40, Faltas = 28 where NumAluno =3 and NumDisp = 104 and Semestre = 200801;
UPDATE Matricula SET  Nota = 82, Faltas = 8 where NumAluno =1 and NumDisp = 102 and Semestre = 201302;
UPDATE Matricula SET  Nota = 97, Faltas = 0 where NumAluno =1 and NumDisp = 103 and Semestre = 201501;
UPDATE Matricula SET  Nota = 96, Faltas = 4 where NumAluno =1 and NumDisp = 106 and Semestre = 201302;
UPDATE Matricula SET  Nota = 74, Faltas = 4 where NumAluno =8 and NumDisp = 109 and Semestre = 201001;
UPDATE Matricula SET  Nota = 73, Faltas = 4 where NumAluno =8 and NumDisp = 101 and Semestre = 200402;
UPDATE Matricula SET  Nota = 91, Faltas = 0 where NumAluno =9 and NumDisp = 103 and Semestre = 201301;
UPDATE Matricula SET  Nota = 90, Faltas = 8 where NumAluno =1 and NumDisp = 100 and Semestre = 200601;
UPDATE Matricula SET  Nota = 30, Faltas = 28 where NumAluno =3 and NumDisp = 102 and Semestre = 201201;
UPDATE Matricula SET  Nota = 84, Faltas = 2 where NumAluno =7 and NumDisp = 105 and Semestre = 200202;
UPDATE Matricula SET  Nota = 95, Faltas = 6 where NumAluno =2 and NumDisp = 105 and Semestre = 200202;
UPDATE Matricula SET  Nota = 83, Faltas = 16 where NumAluno =9 and NumDisp = 104 and Semestre = 200802;
UPDATE Matricula SET  Nota = 88, Faltas = 12 where NumAluno =8 and NumDisp = 106 and Semestre = 200202;
UPDATE Matricula SET  Nota = 94, Faltas = 14 where NumAluno =1 and NumDisp = 109 and Semestre = 200701;
UPDATE Matricula SET  Nota = 74, Faltas = 16 where NumAluno =4 and NumDisp = 102 and Semestre = 201302;
UPDATE Matricula SET  Nota = 98, Faltas = 14 where NumAluno =9 and NumDisp = 104 and Semestre = 201101;
UPDATE Matricula SET  Nota = 81, Faltas = 14 where NumAluno =8 and NumDisp = 101 and Semestre = 201202;
UPDATE Matricula SET  Nota = 93, Faltas = 16 where NumAluno =9 and NumDisp = 100 and Semestre = 201202;
UPDATE Matricula SET  Nota = 96, Faltas = 14 where NumAluno =8 and NumDisp = 105 and Semestre = 200602;
UPDATE Matricula SET  Nota = 86, Faltas = 14 where NumAluno =4 and NumDisp = 102 and Semestre = 201001;
UPDATE Matricula SET  Nota = 88, Faltas = 8 where NumAluno =2 and NumDisp = 102 and Semestre = 201001;
UPDATE Matricula SET  Nota = 75, Faltas = 10 where NumAluno =2 and NumDisp = 102 and Semestre = 200802;
UPDATE Matricula SET  Nota = 82, Faltas = 0 where NumAluno =7 and NumDisp = 109 and Semestre = 201302;
UPDATE Matricula SET  Nota = 90, Faltas = 10 where NumAluno =2 and NumDisp = 102 and Semestre = 201202;
UPDATE Matricula SET  Nota = 98, Faltas = 4 where NumAluno =6 and NumDisp = 103 and Semestre = 201001;
UPDATE Matricula SET  Nota = 96, Faltas = 4 where NumAluno =6 and NumDisp = 100 and Semestre = 201001;
UPDATE Matricula SET  Nota = 72, Faltas = 12 where NumAluno =7 and NumDisp = 106 and Semestre = 200801;
UPDATE Matricula SET  Nota = 93, Faltas = 14 where NumAluno =4 and NumDisp = 105 and Semestre = 200702;
UPDATE Matricula SET  Nota = 89, Faltas = 12 where NumAluno =7 and NumDisp = 108 and Semestre = 200602;
UPDATE Matricula SET  Nota = 85, Faltas = 12 where NumAluno =7 and NumDisp = 107 and Semestre = 200201;

-------------------------------------------------------------------------------------------------------------------------------------
--LETRA b
--DROP FUNCTION gerahistorico(integer);
CREATE OR REPLACE FUNCTION GeraHistorico
(
	IN Aluno MATRICULA.NumAluno%TYPE
)
RETURNS setof HISTORICO AS $$
BEGIN
	RETURN QUERY 	
	SELECT *
	FROM HISTORICO
	WHERE NumAluno = Aluno
	ORDER BY Semestre;
END $$ LANGUAGE 'plpgsql';

--TESTANDO LETRA b
SELECT* FROM GeraHistorico(10);

-------------------------------------------------------------------------------------------------------------------------------------
--LETRA c
CREATE OR REPLACE FUNCTION Formatura
(
	IN Aluno MATRICULA.NumAluno%TYPE
)
RETURNS BOOLEAN AS $$
BEGIN

IF((SELECT COUNT(*) FROM DISCIPLINA) = (SELECT COUNT(*) FROM HISTORICO WHERE NumAluno = Aluno)) THEN RETURN TRUE;
ELSE RETURN FALSE;
END IF;

END $$ LANGUAGE 'plpgsql';

--TESTANDO LETRA c
SELECT Formatura(10);
SELECT Formatura(7);

SELECT COUNT(*)
FROM HISTORICO
WHERE NumAluno = 7;

-------------------------------------------------------------------------------------------------------------------------------------
