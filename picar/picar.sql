CREATE TABLE picarmember (
    membernum number primary key,
    id varchar2(20) unique,
    password varchar2(20) not null,
    name varchar2(20) not null,
    phone varchar2(20) unique,
    license number unique,
    validdate date not null,
    grade varchar2(20) CHECK (grade in ('client', 'manager'))
);
CREATE TABLE carlist (
    carnum varchar2(20) primary key,
    cartype varchar2(20) not null,
    carcolor varchar2(20) not null,
    usefuel varchar2(20) CHECK (usefuel in ('diesel', 'gasoline', 'gas', 'electric')),
    cost number not null,
    location varchar2(100) not null,
    carimage varchar2(1000) not null,
    people number not null,
    validrent varchar2(4) CHECK (validrent in ('n', 'y', 'N', 'Y')),
    driverange number not null,
    usedtime number not null
);
CREATE TABLE rentinfo (
    rentnum number primary key,
    rentstart date not null,
    renttime date not null,
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