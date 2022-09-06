/*Inner join*/
select 
    e.nome as "Estado",
    c.nome as "Cidade",
    e.regiao as "Região"
from estados e, cidades c
where e.id = c.estado_id

/*Inner join*/
select *
from cidades c
inner join prefeitos p on c.id = p.cidade_id 

/*left join*/
select *
from cidades c
left join prefeitos p on c.id = p.cidade_id 

/*Right join*/
select *
from cidades c
right join prefeitos p on c.id = p.cidade_id 

/*full join*/
select *
from cidades c
left join prefeitos p on c.id = p.cidade_id 
union
select *
from cidades c
right join prefeitos p on c.id = p.cidade_id 