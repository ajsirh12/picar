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
ALTER TABLE picarmember modify license varchar2(20);
ALTER TABLE picarmember ADD rented varchar2(4) CHECK (rented in ('n', 'y', 'N', 'Y'));
ALTER TABLE rentinfo DROP COLUMN totalcost;
INSERT INTO picarmember values(1, 'admin', 'admin', 'master', '00000000000', '000000000', '11111111', 30);
CREATE TABLE car (
    cartype number primary key,
    carname varchar2(20) not null,
    fueltype varchar2(20) not null,
    colortype varchar2(20) not null,
    people number not null,
    carimage varchar2(1000)
);
ALTER TABLE car MODIFY carname varchar2(40);
ALTER TABLE car MODIFY colortype varchar2(40);
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
ALTER TABLE carlist ADD carinfo varchar2(1000);
ALTER TABLE carlist DROP COLUMN driverange;
CREATE TABLE rentinfo (
    rentnum number primary key,
    rentstart date not null,
    renttime number not null,
    rentend date not null,
    totalcost number not null,
    membernum REFERENCES picarmember(membernum) not null,
    carnum REFERENCES carlist(carnum) not null
);
ALTER TABLE rentinfo DROP COLUMN renttime;
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
ALTER TABLE commlist DROP COLUMN questnum;
ALTER TABLE commlist ADD questnum REFERENCES question(questnum) ON DELETE CASCADE;

CREATE SEQUENCE SEQ_MEMBERNUM;
CREATE SEQUENCE SEQ_RENTNUM;
CREATE SEQUENCE SEQ_QUESTNUM;
CREATE SEQUENCE SEQ_COMMNUM;
CREATE SEQUENCE SEQ_CAR;
CREATE SEQUENCE SEQ_LOCATION;
commit;

DELETE FROM carlist;
DELETE FROM car;
DELETE FROM commlist;
DELETE FROM location;
DELETE FROM rentinfo;
DELETE FROM question;
DELETE FROM picarmember;

INSERT INTO picarmember values(1, 'admin', 'admin', 'master', '00000000000', '000000000', '11111111', 30, 'N');

INSERT INTO car values(SEQ_CAR.nextval, '제네시스_그레이', '가솔린', '그레이스풀 그레이', 5, 'img/genesis_gray.png');
INSERT INTO car values(SEQ_CAR.nextval, '제네시스_블랙', '가솔린', '티타늄 블랙', 5, 'img/genesis_black.png');
INSERT INTO car values(SEQ_CAR.nextval, '소나타_레드', '가솔린', '플레임 레드', 5, 'img/sonata_red.png');
INSERT INTO car values(SEQ_CAR.nextval, '소나타_실버', '가솔린', '쉬머링 실버', 5, 'img/sonata_silver.png');
INSERT INTO car values(SEQ_CAR.nextval, '소나타_블랙', '가솔린', '미드나잇 블랙', 5, 'img/sonata_black.png');
INSERT INTO car values(SEQ_CAR.nextval, '산타페_블랙', '가솔린', '팬텀 블랙', 7, 'img/santafe_black.png');
INSERT INTO car values(SEQ_CAR.nextval, '산타페_블랙(디젤)', '디젤', '팬텀 블랙', 7, 'img/santafe_black.png');
INSERT INTO car values(SEQ_CAR.nextval, '산타페_블루', '가솔린', '스토미 씨', 7, 'img/santafe_blue.png');
INSERT INTO car values(SEQ_CAR.nextval, '임팔라_화이트', '가솔린', '아발론 화이트 펄', 5, 'img/impala_black.png');
INSERT INTO car values(SEQ_CAR.nextval, '임팔라_블랙', '가솔린', '미드나이트 블랙', 5, 'img/impala_white.png');
INSERT INTO car values(SEQ_CAR.nextval, '트레버스_블루', '가솔린', '다크 문 블루', 7, 'img/traverse_blue.png');

INSERT INTO location values(SEQ_LOCATION.nextval, '강남점');
INSERT INTO location values(SEQ_LOCATION.nextval, '영등포점');
INSERT INTO location values(SEQ_LOCATION.nextval, '종로점');
INSERT INTO location values(SEQ_LOCATION.nextval, '홍대점');

commit;
