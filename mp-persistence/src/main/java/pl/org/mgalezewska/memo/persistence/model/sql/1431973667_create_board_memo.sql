create table memo (
  memo_id number(19),
  spelling varchar2(50),
  reading varchar2(50),
  translation varchar2(50),
  score number(8,0),
  example varchar2(300),
  date_created date,
  date_updated date
);

alter table memo add constraint pk_memo primary key (memo_id);
create sequence seq_memo;

create table board (
  board_id number(19),
  name varchar2(50),
  description varchar2(100),
  date_created date,
  date_updated date
);

alter table board add constraint pk_board primary key (board_id);
create sequence seq_board;

create table board_memo (
  board_id number(19),
  memo_id number(19)
);

alter table board_memo add constraint pk_board_memo primary key (board_id, memo_id);
alter table board_memo add constraint fk_board_memo_board_id
  foreign key (board_id) references board (board_id);
alter table board_memo add constraint fk_board_memo_memo_id
  foreign key (memo_id) references memo (memo_id);