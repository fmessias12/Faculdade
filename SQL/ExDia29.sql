select * from cargos;


select funcionario_id, pre_nome, sobre_nome
from funcionarios
WHERE cargo IN (SELECT cargo_id FROM cargos
					WHERE min_salario > 4000 AND min_salario < 9000);

select cargo, sobre_nome, departamento_id
from funcionarios
where departamento_id in (select departamento_id from departamentos
							where departamento_nome = "Executivo");

select funcionario_id, sobre_nome, salario 
from funcionarios
where salario > (select avg(salario) from funcionarios);

select f.sobre_nome, f.departamento_id, f.funcionario_id, d.local_id
from funcionarios f, departamentos d
where d.local_id in (select local_id from departamentos
							where local_id = 1700);
                            
select f.sobre_nome, f.funcionario_id, l.cidade
from funcionarios f, locais l
where local_id in (select local_id from locais
						where cidade = "Toronto");
                        
select f.pre_nome, f.dt_admiss, f.salario, l.pais_id
from funcionarios f, locais l
where dt_admiss between "1998-01-01" and "1999-01-01"
and local_id in (select local_id from locais
						where pais_id = "CA" or "US");
                        
select f.sobre_nome, f.cargo, c.cargo_desc
from funcionarios f, cargos c
where cargo_desc in (select cargo_desc from cargos
						where cargo_desc = "Estoquista" or cargo_desc = "Vendedor");