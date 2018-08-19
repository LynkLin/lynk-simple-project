DROP TABLE IF EXISTS MPS_REQ_ZIP;
DROP TABLE IF EXISTS MPS_ATTACHMENT;
DROP TABLE IF EXISTS MPS_RESP_ZIP;
DROP TABLE IF EXISTS MPS_REQ_BASIC;
DROP TABLE IF EXISTS MPS_REQ_PERSON;
DROP TABLE IF EXISTS MPS_REQ_QUERY;
DROP TABLE IF EXISTS MPS_REQ_DYNAMIC;
DROP TABLE IF EXISTS MPS_REQ_CONTROL;
DROP TABLE IF EXISTS MPS_RESP_CUSTOMER;
DROP TABLE IF EXISTS MPS_RESP_ACCOUNT;
DROP TABLE IF EXISTS MPS_RESP_MEASURE;
DROP TABLE IF EXISTS MPS_RESP_PRIORIT;
DROP TABLE IF EXISTS MPS_RESP_SUBACCOUNT;
DROP TABLE IF EXISTS MPS_RESP_TRANSACTION;
DROP TABLE IF EXISTS MPS_RESP_DYNAMIC_RESULT;
DROP TABLE IF EXISTS MPS_RESP_DYNAMIC;
DROP TABLE IF EXISTS MPS_RESP_FREEZE_RESULT;
DROP TABLE IF EXISTS MPS_RESP_FREEZE_DETAIL;
DROP TABLE IF EXISTS MPS_RESP_STOP_RESULT;
DROP TABLE IF EXISTS MPS_RESP_STOP_DETAIL;

CREATE TABLE MPS_REQ_ZIP (
  ID varchar(18) not null primary key,
  POLICE_ORG_ID varchar(6),
  BANK_ID varchar(17),
  QQDBS varchar(30),
  FILE varchar(200),
  NESTED_STATUS varchar(1),
  PARENT_ZIP_ID varchar(18),
  STATUS varchar(1),
  HZDM varchar(5),
  GMT_CREATE datetime,
  GMT_MODIFIED datetime
) engine = InnoDB;

CREATE TABLE MPS_ATTACHMENT (
  ID varchar(18) not null primary key,
  REQ_ID varchar(18),
  ATTACHMENT_TYPE varchar(2),
  FILE varchar(200),
  GMT_CREATE datetime,
  GMT_MODIFIED datetime
) engine = InnoDB;

CREATE TABLE MPS_RESP_ZIP (
  ID varchar(18) not null primary key,
  REQ_ID varchar(18),
  POLICE_ORG_ID varchar(6),
  BANK_ID varchar(30),
  QQDBS varchar(30),
  SEQ_NO varchar(12),
  REQUEST_TYPE varchar(4),
  FILE varchar(200),
  STATUS varchar(1),
  GMT_CREATE datetime,
  GMT_MODIFIED datetime
) engine = InnoDB;

CREATE TABLE MPS_REQ_BASIC (
  ID varchar(18) not null primary key,
  REQ_ID varchar(18),
  REQ_TYPE varchar(4),
  REQ_FILE varchar(200),
  QQDBS varchar(30),
  QQCSLX varchar(2),
  SQJGDM varchar(20),
  MBJGDM varchar(20),
  CKZTLB varchar(2),
  AJLX varchar(200),
  JJCD varchar(2),
  BEIZ varchar(200),
  FSSJ varchar(14),
  GMT_CREATE datetime,
  GMT_MODIFIED datetime
) engine = InnoDB;

CREATE TABLE MPS_REQ_PERSON (
  ID varchar(18) not null primary key,
  REQ_BASIC_INFO_ID varchar(18),
  REQ_TYPE varchar(4),
  QQRXM varchar(20),
  QQRZJLX varchar(6),
  QQRZJHM varchar(8),
  QQRDWMC varchar(100),
  QQRSJH varchar(30),
  XCRXM varchar(20),
  XCRZJLX varchar(6),
  XCRZJHM varchar(8),
  GMT_CREATE datetime,
  GMT_MODIFIED datetime
) engine = InnoDB;

CREATE TABLE MPS_REQ_QUERY (
  ID varchar(18) not null primary key,
  REQ_BASIC_INFO_ID varchar(18),
  REQ_TYPE varchar(4),
  RWLSH varchar(35),
  ZZLX varchar(15),
  ZZHM varchar(30),
  ZTMC varchar(100),
  CXZH varchar(50),
  CXNR varchar(2),
  MXSDLX varchar(2),
  MXQSSJ varchar(8),
  MXJZSJ varchar(8),
  GMT_CREATE datetime,
  GMT_MODIFIED datetime
) engine = InnoDB;

CREATE TABLE MPS_REQ_DYNAMIC (
  ID varchar(18) not null primary key,
  REQ_BASIC_INFO_ID varchar(18),
  REQ_TYPE varchar(4),
  RWLSH varchar(35),
  YRWLSH varchar(30),
  ZH varchar(50),
  KSSJ varchar(8),
  ZXSJQJ varchar(1),
  JSSJ varchar(8),
  GMT_CREATE datetime,
  GMT_MODIFIED datetime
) engine = InnoDB;

CREATE TABLE MPS_REQ_CONTROL (
  ID varchar(18) not null primary key,
  REQ_BASIC_INFO_ID varchar(18),
  REQ_TYPE varchar(4),
  RWLSH varchar(35),
  YRWLSH varchar(30),
  DJZHHZ varchar(100),
  ZZLXDM varchar(15),
  ZZHM varchar(30),
  ZH varchar(50),
  ZHXH varchar(50),
  DJFS varchar(2),
  JE varchar(23),
  BZ varchar(20),
  KSSJ varchar(8),
  JSSJ varchar(8),
  GMT_CREATE datetime,
  GMT_MODIFIED datetime
) engine = InnoDB;

CREATE TABLE MPS_RESP_CUSTOMER (
  ID varchar(18) not null primary key,
  REQ_BASIC_INFO_ID varchar(18),
  REQ_TYPE varchar(4),
  RWLSH varchar(36),
  CXFKJG varchar(2),
  CXFKJGYY varchar(100),
  ZZLX varchar(15),
  ZZHM varchar(30),
  KHMC varchar(100),
  LXDH varchar(20),
  LXSJ varchar(20),
  DBRXM varchar(100),
  DBRZJLX varchar(15),
  DBRZJHM varchar(30),
  ZZDZ varchar(100),
  ZZDH varchar(20),
  GZDW varchar(100),
  DWDZ varchar(100),
  DWDH varchar(20),
  YXDZ varchar(60),
  FRDB varchar(60),
  FRDBZJLX varchar(15),
  FRDBZJHM varchar(30),
  KHGSZZHM varchar(18),
  GSNSH varchar(20),
  DSNSH varchar(21),
  GMT_CREATE datetime,
  GMT_MODIFIED datetime
) engine = InnoDB;

CREATE TABLE MPS_RESP_ACCOUNT (
  ID varchar(18) not null primary key,
  REQ_BASIC_INFO_ID varchar(18),
  REQ_TYPE varchar(4),
  RESP_CUSTOMER_ID varchar(18),
  KH varchar(50),
  ZH varchar(50),
  ZHLB varchar(20),
  ZHZT varchar(20),
  KHWD varchar(100),
  KHWDDM varchar(20),
  KHRQ varchar(8),
  XHRQ varchar(8),
  XHWD varchar(100),
  BZ varchar(20),
  CHBZ varchar(20),
  ZHYE varchar(23),
  KYYE varchar(23),
  ZHJYSJ varchar(14),
  BEIZ varchar(200),
  GMT_CREATE datetime,
  GMT_MODIFIED datetime
) engine = InnoDB;

CREATE TABLE MPS_RESP_MEASURE (
  ID varchar(18) not null primary key,
  REQ_BASIC_INFO_ID varchar(18),
  REQ_TYPE varchar(4),
  RESP_CUSTOMER_ID varchar(18),
  ZH varchar(50),
  CSXH varchar(2),
  DJKSRQ varchar(8),
  DJJZRQ varchar(8),
  DJJGMC varchar(50),
  DJJE varchar(23),
  BEIZ varchar(1000),
  DJCSLX varchar(2),
  GMT_CREATE datetime,
  GMT_MODIFIED datetime
) engine = InnoDB;

CREATE TABLE MPS_RESP_PRIORIT (
  ID varchar(18) not null primary key,
  REQ_BASIC_INFO_ID varchar(18),
  REQ_TYPE varchar(4),
  RESP_CUSTOMER_ID varchar(18),
  ZH varchar(50),
  XH varchar(1),
  QLLX varchar(50),
  ZZLXDM varchar(15),
  ZZHM varchar(30),
  QLRXM varchar(60),
  QLJE varchar(23),
  QLRDZ varchar(100),
  QLRLXFS varchar(50),
  GMT_CREATE datetime,
  GMT_MODIFIED datetime
) engine = InnoDB;

CREATE TABLE MPS_RESP_SUBACCOUNT (
  ID varchar(18) not null primary key,
  REQ_BASIC_INFO_ID varchar(18),
  REQ_TYPE varchar(4),
  RESP_CUSTOMER_ID varchar(18),
  ZH varchar(50),
  ZZHXH varchar(50),
  ZZHLB varchar(20),
  ZZHZH varchar(50),
  BZ varchar(20),
  CHBZ varchar(20),
  ZHYE varchar(23),
  ZHZT varchar(20),
  KYYE varchar(23),
  GMT_CREATE datetime,
  GMT_MODIFIED datetime
) engine = InnoDB;

CREATE TABLE MPS_RESP_TRANSACTION (
  ID varchar(18) not null primary key,
  REQ_BASIC_INFO_ID varchar(18),
  REQ_TYPE varchar(4),
  RWLSH varchar(35),
  CXFKJG varchar(2),
  CXFKJGYY varchar(100),
  CXZH varchar(50),
  CXKH varchar(50),
  JYLX varchar(50),
  JDBZ varchar(4),
  BZ varchar(10),
  JE varchar(23),
  YE varchar(23),
  JYSJ varchar(14),
  JYLSH varchar(50),
  JYDFXM varchar(60),
  JYDFZKH varchar(50),
  JYDFZKHLX varchar(10),
  JYDFZJHM varchar(30),
  JYDSYE varchar(23),
  JYDFZHKHH varchar(100),
  JYZY varchar(200),
  JYWDMC varchar(100),
  JYWDDM varchar(20),
  RZH varchar(30),
  CPH varchar(30),
  PZZL varchar(10),
  PZH varchar(30),
  XJBZ varchar(2),
  ZDH varchar(30),
  JYSFCG varchar(2),
  JYFSD varchar(100),
  SHMC varchar(50),
  SHH varchar(30),
  IP varchar(40),
  MAC varchar(50),
  JYGYH varchar(20),
  BEIZ varchar(200),
  GMT_CREATE datetime,
  GMT_MODIFIED datetime
) engine = InnoDB;

CREATE TABLE MPS_RESP_DYNAMIC_RESULT (
  ID varchar(18) not null primary key,
  REQ_BASIC_INFO_ID varchar(18),
  REQ_TYPE varchar(4),
  RWLSH varchar(35),
  ZH varchar(50),
  KH varchar(50),
  ZXJG varchar(2),
  SBYY varchar(200),
  FKSJHM varchar(11),
  ZXQSSJ varchar(14),
  ZXSJQJ varchar(1),
  JSSJ varchar(8),
  GMT_CREATE datetime,
  GMT_MODIFIED datetime
) engine = InnoDB;

CREATE TABLE MPS_RESP_DYNAMIC (
  ID varchar(18) not null primary key,
  REQ_BASIC_INFO_ID varchar(18),
  REQ_TYPE varchar(4),
  RWLSH varchar(35),
  ZH varchar(50),
  KH varchar(50),
  ZHMC varchar(60),
  ZHBZ varchar(10),
  ZHDYKH varchar(50),
  JYCZ varchar(100),
  CZSJ varchar(14),
  JYDD varchar(100),
  AJLX varchar(200),
  JYJE varchar(23),
  JDBZ varchar(4),
  JYBZ varchar(10),
  ZHXYED varchar(23),
  KHZJLX varchar(10),
  KHZJHM varchar(20),
  JYDFZKH varchar(50),
  JYDFZKHLX varchar(40),
  DFZHMC varchar(60),
  DFZHBZ varchar(10),
  PZZL varchar(20),
  PZH varchar(20),
  XJBZ varchar(10),
  FWJM varchar(50),
  ZDH varchar(20),
  KYXQ varchar(10),
  JYLXYHK varchar(20),
  JYLXGJK varchar(20),
  SHH varchar(50),
  SHMC varchar(100),
  WDMS varchar(50),
  WDDZ varchar(100),
  WDDH varchar(20),
  GYH varchar(20),
  SQGYH varchar(20),
  JYDM varchar(20),
  FJYBZ varchar(10),
  CZJYBS varchar(10),
  GMT_CREATE datetime,
  GMT_MODIFIED datetime
) engine = InnoDB;

CREATE TABLE MPS_RESP_FREEZE_RESULT (
  ID varchar(18) not null primary key,
  REQ_BASIC_INFO_ID varchar(18),
  REQ_TYPE varchar(4),
  RWLSH varchar(35),
  ZH varchar(50),
  KH varchar(50),
  ZXJG varchar(2),
  SQDJXE varchar(23),
  SDJE varchar(23),
  YE varchar(23),
  ZXQSSJ varchar(14),
  DJJSRQ varchar(14),
  WNDJYY varchar(1000),
  DJJG varchar(1000),
  DJJE varchar(23),
  DJJZRQ varchar(8),
  WDJJE varchar(23),
  ZHKYYE varchar(23),
  BEIZ varchar(30),
  GMT_CREATE datetime,
  GMT_MODIFIED datetime
) engine = InnoDB;

CREATE TABLE MPS_RESP_FREEZE_DETAIL (
  ID varchar(18) not null primary key,
  REQ_BASIC_INFO_ID varchar(18),
  REQ_TYPE varchar(4),
  RWLSH varchar(35),
  ZH varchar(50),
  ZHZZH varchar(50),
  ZZHXH varchar(50),
  ZZHYE varchar(23),
  ZXJG varchar(2),
  ZXJGYY varchar(500),
  DJJG varchar(1000),
  ZXDJJE varchar(23),
  DJJZRQ varchar(8),
  DJJE varchar(23),
  DJKSSJ varchar(14),
  WDJJE varchar(23),
  DJJSSJ varchar(14),
  BZ varchar(10),
  CHBZ varchar(20),
  GMT_CREATE datetime,
  GMT_MODIFIED datetime
) engine = InnoDB;

CREATE TABLE MPS_RESP_STOP_RESULT (
  ID varchar(18) not null primary key,
  REQ_BASIC_INFO_ID varchar(18),
  REQ_TYPE varchar(4),
  RWLSH varchar(35),
  ZH varchar(50),
  ZXJG varchar(2),
  SBYY varchar(200),
  ZXQSSJ varchar(14),
  GMT_CREATE datetime,
  GMT_MODIFIED datetime
) engine = InnoDB;

CREATE TABLE MPS_RESP_STOP_DETAIL (
  ID varchar(18) not null primary key,
  REQ_BASIC_INFO_ID varchar(18),
  REQ_TYPE varchar(4),
  RWLSH varchar(35),
  ZH varchar(50),
  ZHZZH varchar(50),
  ZZHXH varchar(50),
  ZZHYE varchar(23),
  ZXJG varchar(2),
  ZXJGYY varchar(500),
  ZFKSSJ varchar(14),
  ZFJSSJ varchar(14),
  BZ varchar(10),
  CHBZ varchar(20),
  GMT_CREATE datetime,
  GMT_MODIFIED datetime
) engine = InnoDB;