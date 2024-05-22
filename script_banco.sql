create database fiap;
use fiap;

create table t_produto(
	cd_produto int primary key auto_increment,
    nm_produto varchar(60) not null,
    vl_produto int not null
);

drop table t_produto;

insert into t_produto (nm_produto, vl_produto) values('Maça','3');	
update t_produto set vl_produto = 2 where cd_produto = 1;
select * from t_produto;
select vl_produto from t_produto where cd_produto = 3;
delete from t_produto where cd_produto = 1;


delimiter $$
	CREATE procedure spInsertProduto(vProduto varchar(200), vValor int)
    BEGIN
		INSERT INTO t_produto (nm_produto, vl_produto) VALUE (vProduto, vValor);
	END
$$

