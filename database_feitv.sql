--  FEItv -- Script para criar o banco de dados

-- Cria o banco de dados
CREATE DATABASE feitv;

-- Conecta no bd
\c feitv;

-- Cria bd de usuários
CREATE TABLE usuario (
    id      SERIAL PRIMARY KEY,
    nome    VARCHAR(100) NOT NULL,
    email   VARCHAR(100) NOT NULL UNIQUE,
    senha   VARCHAR(100) NOT NULL
);

-- Cria bd de vídeos
CREATE TABLE video (
    id        SERIAL PRIMARY KEY,
    titulo    VARCHAR(30)  NOT NULL,
    descricao VARCHAR(250),
    canal     VARCHAR(30)  NOT NULL,
    curtidas  INT DEFAULT 0,
    thumbnail VARCHAR(200)
);

-- Cria bd de curtidas
CREATE TABLE curtida (
    id_usuario INT,
    id_video   INT,
    PRIMARY KEY (id_usuario, id_video)
);

-- Cria bd de listas de reprodução
CREATE TABLE lista_reproducao (
    id         SERIAL PRIMARY KEY,
    nome       VARCHAR(100) NOT NULL,
    id_usuario INT NOT NULL
);

-- Cria bd de vídeos e listas
CREATE TABLE video_lista (
    id_lista INT,
    id_video INT,
    PRIMARY KEY (id_lista, id_video)
);

-- Insere os vídeos de exemplo com título, descrição e canal
INSERT INTO video (titulo, descricao, canal) VALUES
('Montando um pc do zero', 'Mostrando como montar um computador', 'TerabyteShop'),
('Fim das taxas das blusinhas', 'Noticia do suposto fim das taxas das blusinhas', 'Fraguas84'),
('Warzone no ps4', 'Jogando warzone no ps4', 'Bladexzd'),
('Indo para argentina', 'Mostrando dia a dia de uma viagem', 'Nomade Raiz'),
('Como emagrecer rapido', 'Receita para emagrecer', 'Renato Cariani'),
('Novo forza horizon 6', 'Testando rtx 5050 no forza', 'Tito Tech');

-- Atualiza as thumb dos vídeos no diretorio corrreto
UPDATE video SET thumbnail = 'imagens/montandopc.jfif' WHERE id = 1;
UPDATE video SET thumbnail = 'imagens/blusinhas.jfif' WHERE id = 2;
UPDATE video SET thumbnail = 'imagens/warzone.jfif' WHERE id = 3;
UPDATE video SET thumbnail = 'imagens/argentina.jfif' WHERE id = 4;
UPDATE video SET thumbnail = 'imagens/emagrecer.jfif' WHERE id = 5;
UPDATE video SET thumbnail = 'imagens/forzah6.jfif' WHERE id = 6;