USE lojarpg;

-- ARMAS
INSERT INTO arma (nome, tipo, dano, raridade, preco, quantidade) VALUES
('Adaga de Aço',               'Adaga',   '1d4',    'Comum',      2.00,     25),
('Machado de Batalha',         'Machado', '1d8',    'Comum',      10.00,    12),
('Arco Longo',                 'Arco',    '1d8',    'Comum',      50.00,    8),
('Martelo de Guerra',          'Martelo', '1d8',    'Comum',      15.00,    9),
('Lança de Cavaleiro',         'Lança',   '1d6',    'Comum',      5.00,     15),
('Cajado do Aprendiz',         'Cajado',  '1d6',    'Incomum',    75.00,    6),
('Besta Pesada',               'Besta',   '1d10',   'Incomum',    90.00,    5),
('Florete Élfico',             'Espada',  '1d8+1',  'Raro',       450.00,   3),
('Machado Rúnico dos Anões',   'Machado', '1d12',   'Raro',       800.00,   2),
('Arco Lunar',                 'Arco',    '1d8+2',  'Muito Raro', 2500.00,  1),
('Lâmina do Dragão Vermelho',  'Espada',  '2d6+3',  'Lendário',   15000.00, 1),
('Cajado do Arquimago',        'Cajado',  '1d6+3',  'Lendário',   20000.00, 1);

-- ITENS MÁGICOS (alguns ligados a uma arma, outros soltos)
INSERT INTO item_magico (nome, efeito, raridade, preco, arma_id) VALUES
('Runa de Gelo',
 'Causa +1d6 de dano de gelo e reduz o deslocamento do alvo',
 'Raro', 600.00,
 (SELECT id FROM arma WHERE nome = 'Florete Élfico' LIMIT 1)),

('Gema do Relâmpago',
 'Causa +1d6 de dano elétrico a cada ataque',
 'Raro', 550.00,
 (SELECT id FROM arma WHERE nome = 'Machado Rúnico dos Anões' LIMIT 1)),

('Encantamento de Precisão',
 'Concede +1 nas jogadas de ataque',
 'Incomum', 200.00,
 (SELECT id FROM arma WHERE nome = 'Arco Longo' LIMIT 1)),

('Aljava de Flechas Flamejantes',
 'As flechas pegam fogo e causam +1d4 de dano de fogo',
 'Incomum', 120.00,
 (SELECT id FROM arma WHERE nome = 'Arco Longo' LIMIT 1)),

('Cristal Arcano',
 'Aumenta em +1 a dificuldade para resistir às suas magias',
 'Raro', 700.00,
 (SELECT id FROM arma WHERE nome = 'Cajado do Aprendiz' LIMIT 1)),

('Óleo Venenoso',
 'A lâmina causa +2d4 de dano de veneno por 1 minuto',
 'Incomum', 180.00,
 (SELECT id FROM arma WHERE nome = 'Adaga de Aço' LIMIT 1)),

('Pedra de Afiar Eterna',
 'Mantém o fio sempre perfeito e concede +1 de dano',
 'Incomum', 250.00,
 (SELECT id FROM arma WHERE nome = 'Machado de Batalha' LIMIT 1)),

('Gema Lunar',
 'Brilha com luz prateada e causa +1d8 de dano radiante',
 'Muito Raro', 3000.00,
 (SELECT id FROM arma WHERE nome = 'Arco Lunar' LIMIT 1)),

('Olho de Dragão',
 'Concede resistência a fogo a quem empunha a lâmina',
 'Lendário', 12000.00,
 (SELECT id FROM arma WHERE nome = 'Lâmina do Dragão Vermelho' LIMIT 1)),

('Orbe do Arquimago',
 'Armazena até 3 magias para serem conjuradas depois',
 'Lendário', 18000.00,
 (SELECT id FROM arma WHERE nome = 'Cajado do Arquimago' LIMIT 1)),

-- itens sem arma (arma_id fica NULL)
('Poção de Cura Maior',
 'Recupera 4d4+4 pontos de vida',
 'Incomum', 150.00, NULL),

('Pergaminho de Bola de Fogo',
 'Conjura uma Bola de Fogo uma única vez',
 'Incomum', 300.00, NULL),

('Botas Velozes',
 'Dobra o deslocamento do usuário',
 'Incomum', 400.00, NULL),

('Amuleto da Sorte',
 'Permite repetir uma jogada de dado por dia',
 'Raro', 900.00, NULL),

('Anel de Proteção',
 'Concede +1 na Classe de Armadura',
 'Raro', 1200.00, NULL),

('Capa da Invisibilidade',
 'Torna o usuário invisível por 10 minutos, uma vez ao dia',
 'Muito Raro', 5000.00, NULL);