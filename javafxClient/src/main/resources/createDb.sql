create schema `student2`;
use student2;
create table student2
(
    username char(20) primary key,
    password char(30)
);
insert into student2
values ('gehanchen', '123456');
select *
from student2
where username = 'gehanchen';
alter table student2
    add isManager boolean;
drop table student2;
create table student2
(
    username  varchar(20) primary key,
    password  varchar(30),
    isManager boolean
);
insert into student2
values ('gehanchen', '123456', true);

create table car
(
    id       bigint primary key auto_increment,
    start    varchar(50),
    end      varchar(50),
    username varchar(20),
    constraint fk_username foreign key (username) references student2.student2(username)
);

insert into car values (1,'Beijing','Fuyang','gehanchen');
insert into car values (2,'London','Paris','gehanchen');
insert into car values (3,'NewYork','Rio','gehanchen');

select * from car;