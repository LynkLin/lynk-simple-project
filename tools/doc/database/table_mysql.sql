DROP TABLE IF EXISTS SYS_USER;
create table SYS_USER
(
  ID           varchar(18)  not null primary key,
  NAME         varchar(8)   null,
  PASSWORD     varchar(100) null,
  SALT         varchar(10)  null,
  REAL_NAME    varchar(50)  null,
  IS_DELETED   tinyint      null,
  GMT_CREATE   datetime     null,
  GMT_MODIFIED datetime     null
) engine = InnoDB;


DROP TABLE IF EXISTS SYS_ROLE;
create table SYS_ROLE
(
  ID           varchar(18) not null primary key,
  NAME         varchar(50) null,
  IS_ADMIN     tinyint     null,
  GMT_CREATE   datetime    null,
  GMT_MODIFIED datetime    null
) engine = InnoDB;


DROP TABLE IF EXISTS SYS_PERMISSION;
create table SYS_PERMISSION
(
  ID           varchar(50)  not null primary key,
  NAME         varchar(100) null,
  IS_REQUEST   tinyint       null,
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
  ID           varchar(18) not null primary key,
  USER_ID      varchar(18) null,
  ROLE_ID      varchar(18) null,
  GMT_CREATE   datetime    null,
  GMT_MODIFIED datetime    null
) engine = InnoDB;


DROP TABLE IF EXISTS SYS_ROLE_PERMISSION;
create table SYS_ROLE_PERMISSION
(
  ID            varchar(18) not null primary key,
  ROLE_ID       varchar(18) null,
  PERMISSION_ID varchar(18) null,
  GMT_CREATE    datetime    null,
  GMT_MODIFIED  datetime    null
) engine = InnoDB;


DROP TABLE IF EXISTS SYS_PARAM;
create table SYS_PARAM
(
  ID           varchar(18)  not null primary key,
  CATEGORY     varchar(60)  null,
  CODE         varchar(60)  null,
  VALUE        varchar(60)  null,
  REMARK       varchar(200) null,
  GMT_CREATE   datetime     null,
  GMT_MODIFIED datetime     null
) engine = InnoDB;


DROP TABLE IF EXISTS SYS_TASK;
create table SYS_TASK
(
  ID              varchar(18)  not null primary key,
  CODE            varchar(120) null,
  NAME            varchar(120) null,
  CATEGORY        varchar(60)  null,
  CLASS_NAME      varchar(200) null,
  CRON_EXPRESSION varchar(200) null,
  SEQUENCE        int          null,
  IS_RUN          tinyint      null,
  IS_PAUSE        tinyint      null,
  IS_ENABLE       tinyint      null,
  REMARK          varchar(200) null,
  GMT_CREATE      datetime     null,
  GMT_MODIFIED    datetime     null
) engine = InnoDB;