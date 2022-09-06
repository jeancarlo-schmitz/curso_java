INSERT INTO cidades 
    (nome, area, estado_id)
VALUES
    ('Campinas', 795, (select id from estados where sigla = 'SP')),
    ('Niterói', 133.96, (select id from estados where sigla = 'RJ')),
    ('Caruaru', 920.26, (select id from estados where sigla = 'PE')),
    ('Juazeiro do Norte', 248.36, (select id from estados where sigla = 'CE'));