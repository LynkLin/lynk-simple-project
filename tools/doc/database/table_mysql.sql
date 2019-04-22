DROP TABLE IF EXISTS SYS_USER;
create table SYS_USER
(
  ID           varchar(19)  not null primary key,
  NAME         varchar(8)   null,
  PASSWORD     varchar(100) null,
  SALT         varchar(10)  null,
  REAL_NAME    varchar(50)  null,
  IS_DELETED   tinyint(1)      null,
  GMT_CREATE   datetime     null,
  GMT_MODIFIED datetime     null
) engine = InnoDB;


DROP TABLE IF EXISTS SYS_ROLE;
create table SYS_ROLE
(
  ID           varchar(19) not null primary key,
  NAME         varchar(50) null,
  IS_ADMIN     tinyint(1)     null,
  GMT_CREATE   datetime    null,
  GMT_MODIFIED datetime    null
) engine = InnoDB;


DROP TABLE IF EXISTS SYS_PERMISSION;
create table SYS_PERMISSION
(
  ID           varchar(50)  not null primary key,
  NAME         varchar(100) null,
  IS_REQUEST   tinyint(1)       null,
  URL          varchar(100) null,
  METHOD       varchar(10)  null,
  SEQUENCE     int           null,
  PARENT_ID    varchar(50)  null,
  GMT_CREATE   datetime      null,
  GMT_MODIFIED datetime      null
);


DROP TABLE IF EXISTS SYS_USER_ROLE;
create table SYS_USER_ROLE
(
  ID           varchar(19) not null primary key,
  USER_ID      varchar(19) null,
  ROLE_ID      varchar(19) null,
  GMT_CREATE   datetime    null,
  GMT_MODIFIED datetime    null
) engine = InnoDB;


DROP TABLE IF EXISTS SYS_ROLE_PERMISSION;
create table SYS_ROLE_PERMISSION
(
  ID            varchar(19) not null primary key,
  ROLE_ID       varchar(19) null,
  PERMISSION_ID varchar(19) null,
  GMT_CREATE    datetime    null,
  GMT_MODIFIED  datetime    null
) engine = InnoDB;


DROP TABLE IF EXISTS SYS_PARAM;
create table SYS_PARAM
(
  ID           varchar(19)  not null primary key,
  CATEGORY     varchar(60)  null,
  CODE         varchar(60)  null,
  VALUE        varchar(200)  null,
  REMARK       varchar(200) null,
  GMT_CREATE   datetime     null,
  GMT_MODIFIED datetime     null
) engine = InnoDB;


DROP TABLE IF EXISTS SYS_TASK;
create table SYS_TASK
(
  ID              varchar(19)  not null primary key,
  CODE            varchar(120) null,
  NAME            varchar(120) null,
  CATEGORY        varchar(60)  null,
  CLASS_NAME      varchar(200) null,
  CRON_EXPRESSION varchar(200) null,
  SEQUENCE        int          null,
  IS_RUN          tinyint(1)     null,
  IS_PAUSE        tinyint(1)      null,
  IS_ENABLE       tinyint(1)      null,
  REMARK          varchar(200) null,
  GMT_CREATE      datetime     null,
  GMT_MODIFIED    datetime     null
) engine = InnoDB;

alter table CCDI_REQ_ATTACHMENT modify ID varchar(19) not null;
alter table CCDI_REQ_BASIC modify ID varchar(19) not null;
alter table CCDI_REQ_MAIN modify ID varchar(19) not null;
alter table CCDI_REQ_PERSON modify ID varchar(19) not null;
alter table CCDI_REQ_ZIP modify ID varchar(19) not null;
alter table CCDI_RESP_ACCOUNT modify ID varchar(19) not null;
alter table CCDI_RESP_CERTIFICATE modify ID varchar(19) not null;
alter table CCDI_RESP_CUST modify ID varchar(19) not null;
alter table CCDI_RESP_DYNAMIC modify ID varchar(19) not null;
alter table CCDI_RESP_FINANCIAL modify ID varchar(19) not null;
alter table CCDI_RESP_FREEZE modify ID varchar(19) not null;
alter table CCDI_RESP_MEASURE modify ID varchar(19) not null;
alter table CCDI_RESP_MESSAGE modify ID varchar(19) not null;
alter table CCDI_RESP_PROIORITY modify ID varchar(19) not null;
alter table CCDI_RESP_STOP modify ID varchar(19) not null;
alter table CCDI_RESP_SUBACCOUNT modify ID varchar(19) not null;
alter table CCDI_RESP_TRANS modify ID varchar(19) not null;
alter table CCDI_RESP_ZIP modify ID varchar(19) not null;
alter table SYS_PARAM modify ID varchar(19) not null;
alter table SYS_PERMISSION modify ID varchar(19) not null;
alter table SYS_ROLE modify ID varchar(19) not null;
alter table SYS_ROLE_PERMISSION modify ID varchar(19) not null;
alter table SYS_TASK modify ID varchar(19) not null;
alter table SYS_USER modify ID varchar(19) not null;
alter table SYS_USER_ROLE modify ID varchar(19) not null;