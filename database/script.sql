CREATE DATABASE IF NOT EXISTS lojarpg CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE lojarpg;

CREATE TABLE IF NOT EXISTS arma (
    id          INT AUTO_INCREMENT PRIMARY KEY,
    nome        VARCHAR(100)  NOT NULL,
    tipo        VARCHAR(50)   NOT NULL,
    dano        VARCHAR(20),
    raridade    VARCHAR(30)   NOT NULL,
    preco       DECIMAL(10,2) NOT NULL,
    quantidade  INT           NOT NULL DEFAULT 0
);

CREATE TABLE IF NOT EXISTS item_magico (
    id        INT AUTO_INCREMENT PRIMARY KEY,
    nome      VARCHAR(100)  NOT NULL,
    efeito    VARCHAR(255)  NOT NULL,
    raridade  VARCHAR(30)   NOT NULL,
    preco     DECIMAL(10,2) NOT NULL,
    arma_id   INT NULL,
    CONSTRAINT fk_item_arma FOREIGN KEY (arma_id)
        REFERENCES arma(id) ON DELETE SET NULL
);