-- Selects
select * from estados;

select nome, sigla from estados
where regiao = 'Sul'

-- Updates
UPDATE estados 
SET nome = 'Maranhão' 
WHERE sigla = 'MA';

UPDATE estados 
SET nome = 'Paraná',
    populacao = 11.32
WHERE sigla = 'PR';