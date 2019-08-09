CREATE TABLE membergrade (
    gradeno number primary key,
    membergrade varchar2(20) unique
);
INSERT INTO membergrade values(10, 'client');
INSERT INTO membergrade values(20, 'manager');
INSERT INTO membergrade values(30, 'master');
CREATE TABLE picarmember (
    membernum number primary key,
    id varchar2(20) unique,
    password varchar2(20) not null,
    name varchar2(20) not null,
    phone varchar2(20) unique,
    license number unique,
    validdate date not null,
    gradeno number default 10 REFERENCES membergrade(gradeno) not null
);
INSERT INTO picarmember values(1, 'admin', 'admin', 'master', '00000000000', '000000000', '11111111', 30);
CREATE TABLE car (
    cartype number primary key,
    carname varchar2(20) not null,
    fueltype varchar2(20) not null,
    colortype varchar2(20) not null,
    people number not null,
    carimage varchar2(1000)
);
CREATE TABLE location(
    carloc number primary key,
    location varchar2(20) not null
);
CREATE TABLE carlist (
    carnum varchar2(20) primary key,
    cartype number REFERENCES car(cartype) not null,
    cost number not null,
    carloc number REFERENCES location(carloc) not null,
    validrent varchar2(4) CHECK (validrent in ('n', 'y', 'N', 'Y')),
    driverange number not null,
    usedtime number not null
);
CREATE TABLE rentinfo (
    rentnum number primary key,
    rentstart date not null,
    renttime number not null,
    rentend date not null,
    totalcost number not null,
    membernum REFERENCES picarmember(membernum) not null,
    carnum REFERENCES carlist(carnum) not null
);
CREATE TABLE question (
    questnum number primary key,
    questtitle varchar2(100) not null,
    questtext varchar2(1000) not null,
    questdate date not null,
    answer varchar2(4) CHECK (answer in ('n', 'y', 'N', 'Y')),
    membernum REFERENCES picarmember(membernum) not null
);
CREATE TABLE commlist (
    commnum number primary key,
    commtext varchar2(1000) not null,
    commdate date not null,
    membernum REFERENCES picarmember(membernum) not null,
    questnum REFERENCES question(questnum) not null
); 
CREATE SEQUENCE SEQ_MEMBERNUM;
CREATE SEQUENCE SEQ_RENTNUM;
CREATE SEQUENCE SEQ_QUESTNUM;
CREATE SEQUENCE SEQ_COMMNUM;
commit;