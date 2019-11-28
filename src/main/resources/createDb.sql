create schema student;
use student;
create table car
(
    id       bigint primary key auto_increment,
    start    varchar(50),
    arrival  varchar(50),
    belonger varchar(50)
);
create table journey
(
    id         bigint primary key auto_increment,
    carId      bigint,
    start      timestamp,
    arrival    timestamp,
    gain       bigint,
    passengers int,
    remark     varchar(1000),
    foreign key fk_carId (carId) references student.car (id)
);
create table driver
(
    id       bigint primary key auto_increment,
    name     varchar(50),
    username varchar(50),
    password varchar(50)
);
alter table car
    modify belonger bigint;
alter table car
    add foreign key fk_belonger (belonger) references student.driver (id);
insert into driver(name, username, password)
values ('张三', '李四', '123456');

insert into driver(username, password) values ('gehanchen','123456');
insert into car(belonger)values (1);
select * from driver;
select * from student.car;

## 以下为Hibernate生成的建库语句
drop table if exists car;
drop table if exists driver;
drop table if exists journey;
create table car
(
    id       bigint not null,
    arrival  varchar(50),
    start    varchar(50),
    belonger bigint,
    primary key (id)
) engine = MyISAM;
create table driver
(
    id       bigint not null,
    name     varchar(50),
    password varchar(50),
    username varchar(50),
    primary key (id)
) engine = MyISAM;
create table journey
(
    id         bigint not null,
    arrival    datetime,
    gain       bigint,
    passengers integer,
    remark     varchar(1000),
    start      datetime,
    car_id     bigint,
    primary key (id)
) engine = MyISAM;
alter table car
    add constraint FK46cnyiddqav27jtbdqqb7c3t7 foreign key (belonger) references driver (id);
alter table journey
    add constraint FKrlltp6b8yr5fckdtdvwg4mffs foreign key (car_id) references car (id);

