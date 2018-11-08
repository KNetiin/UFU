/*
Antonio Carlos Neto
Higor Emanuel Souza Silva
Marcelo Mendonça Borges */

SET search_path TO locadora;
SET datestyle TO 'DMY';

--1) Qual é a quantidade de filmes alugados antes do dia dd/mm/aaaa (escolha uma data) 

SELECT COUNT(E.numfilme)
FROM EMPRESTIMO E
WHERE E.dataret < '15/06/2013';

--2) Qual a quantidade de filmes de cada categoria a locadora possui (listar o nome da
--categoria e a quantidade) 

SELECT categoria, COUNT(categoria)
FROM filme
GROUP BY categoria;

--3) Quantos filmes da locadora cada ator estrelou (listar a quantidade juntamente com o
--nome artístico dos atores em ordem alfabética) 

SELECT nomeartistico, COUNT(E.numfilme)
FROM  ESTRELA E, ATOR A
WHERE E.codator = A.cod
GROUP BY nomeartistico
ORDER BY nomeartistico ASC;

--4) Qual é a data de lançamento mais recente entre os filmes disponíveis na locadora

SELECT MAX(data_lancamento)
FROM FILME;

--5) Qual é o título original e a categoria do filme que possui a data de lançamento mais
--antiga da locadora

SELECT titulo_original, categoria
FROM FILME
WHERE data_lancamento = (SELECT MIN(data_lancamento) FROM FILME);

--6) Quanto o cliente X (escolha um nome) gastou na locadora em empréstimos até hoje

SELECT C.nome, SUM(E.valor_pg)
FROM CLIENTE C, EMPRESTIMO E
WHERE C.nome LIKE 'Gab%' AND E.cliente = C.numcliente
GROUP BY C.nome;

--7) Qual a duração média dos filmes da classificação ACERVO 

SELECT C.nome, AVG(F.duracao)
FROM FILME F, CLASSIFICACAO C
WHERE C.cod = F.classificacao AND C.nome = 'Acervo'
GROUP BY C.nome;

--8) Quais são os nomes das classificações cujo total de filmes do acervo da locadora é maior do que 5

SELECT C.nome
FROM CLASSIFICACAO C,FILME F
WHERE F.classificacao = C.cod
GROUP BY C.nome
HAVING COUNT(*) > 5;

--9) Quais são os nomes artísticos dos atores que estrelaram mais do que 3 filmes dos disponíveis no acervo da locadora. 

SELECT nomeartistico
FROM ATOR, ESTRELA
WHERE ESTRELA.codator = ATOR.cod
GROUP BY nomeartistico
HAVING COUNT(*) > 3;

--10) Quais são os nomes artísticos dos atores que estrelaram mais do que 2 filmes dos
--disponíveis no acervo da locadora com a classificação LANÇAMENTO.

SELECT nomeartistico 
FROM FILME F, ATOR A, ESTRELA E, CLASSIFICACAO C
WHERE E.codator = A.cod AND E.numfilme = F.numfilme AND UPPER(C.nome) = 'LANÇAMENTO' AND F.classificacao = C.cod
GROUP BY nomeartistico
HAVING COUNT(*) >= 2;

--11) Quantas nacionalidades diferentes existem na tabela ator 

SELECT  COUNT(DISTINCT nacionalidade)
FROM ATOR;

--12) Qual a nacionalidade que possui o maior número de atores registrados no BD da locadora

SELECT nacionalidade
FROM ATOR
GROUP BY nacionalidade
ORDER BY COUNT(nacionalidade) DESC
LIMIT 1;

--13) Quantos filmes o cliente Y (escolher um nome) já alugou e devolveu

SELECT COUNT(E.numfilme)
FROM CLIENTE C, EMPRESTIMO E
WHERE C.numcliente = E.cliente AND C.nome LIKE 'Gab%';  
