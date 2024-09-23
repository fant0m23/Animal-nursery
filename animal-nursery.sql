-- CREATE SCHEMA `human_friends` ;
drop table if exists pets;
create table pets(
id int primary key auto_increment,
name varchar(20) not null,
type varchar(20) not null,
birthdate TIMESTAMP not null,
commands varchar(100)
);
drop table if exists pack_animals;
create table pack_animals (
id int primary key auto_increment,
name varchar(20) not null,
type varchar(20) not null,
birthdate TIMESTAMP not null,
commands varchar(100)
);

insert into pets(name, type, birthdate, commands) values
('Fido', 'Dog', '2020-01-01', 'Sit, Stay, Fetch'),
('Whiskers', 'Cat', '2015-05-15', 'Sit, Pounce'),
('Hammy', 'Hamster', '2023-03-10', 'Roll, Hide'),
('Buddy', 'Dog', '2012-12-10', 'Sit, Paw, Bark'),
('Smudge', 'Cat', '2019-02-20', 'Sit, Pounce, Scratch'),
('Peanut', 'Hamster', '2021-10-01', 'Roll, Spin'),
('Bella', 'Dog', '2018-11-11', 'Sit, Stay, Roll'),
('Oliver', 'Cat', '2022-06-30', 'Meow, Scratch, Jump');

insert into pack_animals(name, type, birthdate, commands) values
('Thunder', 'Horse', '2020-07-21', 'Trot, Canter, Gallop'),
('Sandy', 'Camel', '2018-11-03', 'Walk, Carry Load'),
('Eeyore', 'Donkey', '2017-09-18', 'Walk, Carry Load, Bray'),
('Storm', 'Horse', '2014-05-05', 'Trot, Canter'),
('Dune', 'Camel', '2016-12-12', 'Walk, Sit'),
('Burro', 'Donkey', '2022-01-23', 'Walk, Bray, Kick'),
('Blaze', 'Horse', '2021-02-28', 'Trot, Jump, Gallop'),
('Sahara', 'Camel', '2023-04-14', 'Walk, Run');

select * from pets;
select * from pack_animals;

-- Удалить записи о верблюдах и объединить таблицы лошадей и ослов
delete from pack_animals where type='Camel';

-- Создать новую таблицу для животных в возрасте от 1 до 3 лет и вычислить их возраст с точностью до месяца
drop table if exists young_animals;
create table young_animals(
id int primary key auto_increment,
name varchar(20) not null,
type varchar(20) not null,
age varchar(40) not null,
commands varchar(100)
);

drop function if exists age_in_month;
delimiter //
create function age_in_month(months int)
returns varchar(40) deterministic
begin
declare age varchar(40) default '';
set age = concat(floor(months/12), ' years and ');
set months = months % 12;
set age = concat(age, months, ' months');
return age;
end //
delimiter ;

insert into young_animals(name, type, age, commands)
select name, type, age_in_month(timestampdiff(MONTH, birthdate, now())), commands
from pets where timestampdiff(MONTH, birthdate, now()) between 12 and 36
union
select name, type, age_in_month(timestampdiff(MONTH, birthdate, now())), commands
from pack_animals where timestampdiff(MONTH, birthdate, now()) between 12 and 36;

-- truncate table young_animals;
select * from young_animals;

-- Объединить все созданные таблицы в одну, сохраняя информацию о принадлежности к исходным таблицам
select *, 'pets' as from_table from pets where type='Dog' or type='Cat' or type='Hamster'
union
select *, 'pack_animals' as from_table from pack_animals where type='Donkey' or type='Horse' or type='Camel'
union
select *, 'pets' as from_table from young_animals where type='Dog' or type='Cat' or type='Hamster'
union
select *, 'pack_animals' as from_table from young_animals where type='Donkey' or type='Horse' or type='Camel';


