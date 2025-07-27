CREATE DATABASE bd_locadora;
USE bd_locadora;

--tabela dos clientes
CREATE TABLE IF NOT EXISTS clientes (
    id_cliente INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    cpf VARCHAR(14) UNIQUE NOT NULL,
    telefone VARCHAR(20) NOT NULL,
    email VARCHAR(100) NOT NULL, 
    endereco VARCHAR(100) NOT NULL,
    data_nascimento DATE -- está no formato yyyy/MM/dd diferente da entrada do construtor
);

/* As linhas a seguir servem para:

Apresentar a lista dos clientes
SELECT*FROM clientes;

Inserir novos cliente a tabela clientes
INSERT INTO clientes (nome, cpf, telefone, email, endereco, data_nascimento)
VALUES (?, ?, ?, ?, ?, ?);

Att os dados que podem ser alterados dos clientes 
UPDATE clientes
SET  telefone = ?, email = ?, endereco = ?
WHERE id_cliente = ?;

E esse pra apagar o dado do cliente a partir do id dele
DELETE FROM clientes WHERE id_cliente = ?;

A mesma lógica servirá nas outras tabelas
*/


--tabela dos filmes
CREATE TABLE IF NOT EXISTS filmes (
    id_filme INT AUTO_INCREMENT PRIMARY KEY,
    nome_filme VARCHAR(100) NOT NULL,
    genero VARCHAR(100) NOT NULL,
    ano_lancamento INT NOT NULL,
    diretor VARCHAR(100) NOT NULL,
    duracao INT NOT NULL,
    qtd_estoque INT NOT NULL,
    alugados INT NOT NULL
);

/* SELECT*FROM filmes;

INSERT INTO filmes (nome_filme, genero, ano_lancamento, diretor, duracao, qtd_estoque, alugados)
VALUES (?, ?, ?, ?, ?, ?, ?);

UPDATE filmes
SET qtd_estoque = ?, alugados = ?
WHERE id_filme = ?;

DELETE FROM filmes WHERE id_filme = ?;
*/

--tabela dos funcionarios
CREATE TABLE IF NOT EXISTS funcionarios (
    id_funcionario INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    telefone VARCHAR(20) NOT NULL,
    funcao VARCHAR(100) NOT NULL,
    cpf VARCHAR(14) UNIQUE NOT NULL,
    endereco VARCHAR(100) NOT NULL   
);

/*
SELECT*FROM funcionarios;

INSERT INTO funcionarios (nome, telefone, funcao, cpf, endereco)
VALUES (?, ?, ?, ?, ?);

UPDATE funcionarios
SET telefone = ?, funcao = ? , endereco = ?
WHERE id_funcionario = ?;

DELETE FROM funcionarios WHERE id_funcionario = ?;
*/


-- tabela de locação
CREATE TABLE IF NOT EXISTS locacao (
    id_locacao INT AUTO_INCREMENT PRIMARY KEY,
    id_filme INT NOT NULL ,
    id_cliente INT NOT NULL,
    data_aluguel DATE,
    --data_devolucao DATE,
    FOREIGN KEY (id_filme) REFERENCES filmes(id_filme),
    FOREIGN KEY (id_cliente) REFERENCES clientes(id_cliente)
);

/*
SELECT*FROM locacao;

INSERT INTO locacao (id_filme, id_cliente, data_aluguel)
VALUES (?, ?, ?);

Não achei necessário fazer o update para esta tabela

DELETE FROM locacao WHERE id_locacao = ?;
*/