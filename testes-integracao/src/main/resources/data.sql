INSERT INTO `usuario` (`id_usuario`, `email`, `username`,  `password`) VALUES
(1,	'fulano@gmail.com', 'fulano',	'123'),
(2,	'ciclano@gmail.com', 'ciclano',	'123'),
(3,	'beltrano@gmail.com',	'beltrano',	'123');


INSERT INTO `produto` (`id_produto`, `nome`, `valor_diaria`) VALUES
(1,	'Onix 1.0', 110.00),
(2,	'Ford Ka', 120.00),
(3,	'Cruze', 180.00);


INSERT INTO `aluguel` (`id_aluguel`, `valor`, `data_inicial`, `data_final`, `usuario_id_usuario`, `produto_id_produto`) VALUES
(1,	440.00, '2021-07-21 10:00:00', '2021-07-25 10:00:00', 1, 1);

