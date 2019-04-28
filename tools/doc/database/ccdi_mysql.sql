CREATE TABLE CCDI_REQ_ATTACHMENT
(
    ID varchar(19) not null primary key,
    REQ_ZIP_ID varchar(19),
    ATTACHMENT_TYPE varchar(4),
    FILE_PATH varchar(200),
    FILE_NAME varchar(100),
    GMT_CREATE datetime,
    GMT_MODIFIED datetime
);

CREATE TABLE CCDI_REQ_BASIC
(
    ID varchar(19) not null primary key,
    REQ_ZIP_ID varchar(19),
    ATTACHMENT_ID varchar(19),
    QQDBS varchar(30),
    QQCSLX varchar(2),
    SQJGDM varchar(20),
    SQJGMC varchar(50),
    MBJGDM varchar(20),
    ZTLB varchar(2),
    AJLX varchar(50),
    JJCD varchar(2),
    BEIZ varchar(200),
    FSSJ varchar(14),
    FLWSH varchar(50),
    GMT_CREATE datetime,
    GMT_MODIFIED datetime
);

CREATE TABLE CCDI_REQ_MAIN
(
    ID varchar(19) not null primary key,
    REQ_BASIC_ID varchar(19),
    FLDM varchar(4),
    SEQ_NO varchar(12),
    PROCESS_APPROVAL varchar(2),
    RESP_APPROVAL varchar(2),
    STATUS varchar(2),
    DYNAMICAL_STATUS varchar(2),
    RWLSH varchar(35),
    ZH varchar(40),
    ZZLXDM varchar(15),
    ZZHM varchar(30),
    ZTMC varchar(100),
    SJHM varchar(11),
    CXNR varchar(2),
    MXSDLX varchar(2),
    KSSJ varchar(8),
    JSSJ varchar(8),
    YRWLSH varchar(30),
    ZXSJQJ varchar(1),
    ZHXH varchar(14),
    DJFS varchar(2),
    JE decimal(20,2),
    BZ varchar(20),
    CXZL varchar(2),
    JYLSH varchar(50),
    CXFKJG varchar(50),
    CXFKJGYY varchar(100),
    FKSJHM varchar(30),
    GMT_CREATE datetime,
    GMT_MODIFIED datetime
);

CREATE TABLE CCDI_REQ_PERSON
(
    ID varchar(19) not null primary key,
    REQ_BASIC_ID varchar(19),
    QQRXM varchar(20),
    QQRZJLX varchar(20),
    QQRZJHM varchar(10),
    QQRDWMC varchar(100),
    QQRSJH varchar(30),
    XCRXM varchar(20),
    XCRZJLX varchar(20),
    XCRZJHM varchar(8),
    GMT_CREATE datetime,
    GMT_MODIFIED datetime
);

CREATE TABLE CCDI_REQ_ZIP
(
    ID varchar(19) not null primary key,
    SQJGDM varchar(20),
    MBJGDM varchar(20),
    QQDBS varchar(30),
    REQ_ZIP_PATH varchar(200),
    REQ_ZIP_NAME varchar(120),
    NESTED_STATUS varchar(1),
    PARENT_REQ_ZIP_ID varchar(19),
    STATUS varchar(2),
    HZDM varchar(5),
    HZSM varchar(200),
    HZ_ZIP_PATH varchar(200),
    HZ_ZIP_NAME varchar(120),
    GMT_CREATE datetime,
    GMT_MODIFIED datetime
);

CREATE TABLE CCDI_RESP_ACCOUNT
(
    ID varchar(19) not null primary key,
    REQ_MAIN_ID varchar(19),
    CUST_NO varchar(20),
    CXKH varchar(40),
    KH varchar(40),
    ZH varchar(30),
    WYZHMC varchar(30),
    ZHDLIP varchar(30),
    ZHDLSJ varchar(14),
    ZHLB varchar(20),
    ZHZT varchar(20),
    KHWD varchar(100),
    KHWDDM varchar(20),
    KHRQ varchar(8),
    XHRQ varchar(8),
    XHWD varchar(100),
    BZ varchar(20),
    CHBZ varchar(20),
    ZHYE decimal(20,2),
    KYYE decimal(20,2),
    ZHJYSJ varchar(14),
    BEIZ varchar(200),
    GMT_CREATE datetime,
    GMT_MODIFIED datetime
);

CREATE TABLE CCDI_RESP_CERTIFICATE
(
    ID varchar(19) not null primary key,
    REQ_MAIN_ID varchar(19),
    CXZH varchar(40),
    CXZL varchar(2),
    JYLSH varchar(50),
    PZTXLX varchar(6),
    PZTXXH varchar(1),
    FILE_PATH varchar(200),
    PZTXMC varchar(60),
    BEIZ varchar(200),
    GMT_CREATE datetime,
    GMT_MODIFIED datetime
);

CREATE TABLE CCDI_RESP_CUST
(
    ID varchar(19) not null primary key,
    REQ_MAIN_ID varchar(19),
    CUST_NO varchar(20),
    ZZLXDM varchar(15),
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
    ZDDZ varchar(100),
    FRDB varchar(60),
    FRDBZJLX varchar(15),
    FRDBZJHM varchar(30),
    KHGSZZHM varchar(19),
    GSNSH varchar(20),
    DSNSH varchar(21),
    GMT_CREATE datetime,
    GMT_MODIFIED datetime
);

CREATE TABLE CCDI_RESP_DYNAMIC
(
    ID varchar(19) not null primary key,
    REQ_MAIN_ID varchar(19),
    ZH varchar(30),
    KH varchar(40),
    ZHMC varchar(60),
    ZHBZ varchar(10),
    ZHDYKH varchar(40),
    JYCZ varchar(100),
    CZSJ varchar(14),
    JYDD varchar(100),
    JYJE decimal(20,2),
    JYBZ varchar(10),
    ZHXYED decimal(20,2),
    KHZJLX varchar(10),
    KHZJHM varchar(20),
    DFZH varchar(20),
    DFZHMC varchar(60),
    DFZHBZ varchar(10),
    DFZHDYKH varchar(40),
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
);

CREATE TABLE CCDI_RESP_FINANCIAL
(
    ID varchar(19) not null primary key,
    REQ_MAIN_ID varchar(19),
    KH varchar(40),
    ZH varchar(30),
    JRZCXH varchar(10),
    JRZCMC varchar(100),
    JRZCLX varchar(20),
    CPXSZL varchar(20),
    JRCPBH varchar(30),
    ZCGLR varchar(50),
    ZCKFTGYHJY varchar(10),
    ZCJYXZLX varchar(50),
    ZCJYXZXCSJ varchar(19),
    CPZT varchar(10),
    ZYQR varchar(100),
    TGR varchar(100),
    SYR varchar(100),
    CLR varchar(8),
    SHR varchar(8),
    TGZH varchar(40),
    JLDW varchar(20),
    BZ varchar(20),
    ZCDWJG decimal(16,4),
    SE decimal(16,4),
    KYSE decimal(16,4),
    ZCZSE decimal(16,4),
    KKZCZSE decimal(16,4),
    BEIZ varchar(1000),
    GMT_CREATE datetime,
    GMT_MODIFIED datetime
);

CREATE TABLE CCDI_RESP_FREEZE
(
    ID varchar(19) not null primary key,
    REQ_MAIN_ID varchar(19),
    ZH varchar(30),
    KH varchar(40),
    ZXJG varchar(2),
    SQDJXE decimal(20,2),
    SDJE decimal(20,2),
    YE decimal(20,2),
    ZXQSSJ varchar(14),
    DJJSRQ varchar(14),
    WNDJYY varchar(1000),
    DJJG varchar(50),
    DJJE decimal(20,2),
    DJJZRQ varchar(8),
    WDJJE decimal(14,2),
    ZHKYYE decimal(20,2),
    BEIZ varchar(30),
    GMT_CREATE datetime,
    GMT_MODIFIED datetime
);

CREATE TABLE CCDI_RESP_MEASURE
(
    ID varchar(19) not null primary key,
    REQ_MAIN_ID varchar(19),
    ZH varchar(30),
    CSXH varchar(10),
    DJKSRQ varchar(8),
    DJJZRQ varchar(8),
    DJJGMC varchar(50),
    DJJE decimal(20,2),
    BEIZ varchar(1000),
    DJCSLX varchar(2),
    GMT_CREATE datetime,
    GMT_MODIFIED datetime
);

CREATE TABLE CCDI_RESP_MESSAGE
(
    ID varchar(19) not null primary key,
    REQ_MAIN_ID varchar(19),
    MOBILE_NO varchar(20),
    MSG_TYPE varchar(2),
    MESSAGE varchar(1000),
    GMT_CREATE datetime,
    GMT_MODIFIED datetime
);

CREATE TABLE CCDI_RESP_PROIORITY
(
    ID varchar(19) not null primary key,
    REQ_MAIN_ID varchar(19),
    ZH varchar(30),
    XH varchar(10),
    QLLX varchar(50),
    ZZLXDM varchar(15),
    ZZHM varchar(30),
    QLRXM varchar(60),
    QLJE decimal(20,2),
    QLRDZ varchar(100),
    QLRLXFS varchar(50),
    GMT_CREATE datetime,
    GMT_MODIFIED datetime
);

CREATE TABLE CCDI_RESP_STOP
(
    ID varchar(19) not null primary key,
    REQ_MAIN_ID varchar(19),
    ZH varchar(40),
    KH varchar(40),
    ZXJG varchar(2),
    SBYY varchar(200),
    ZXQSSJ varchar(14),
    GMT_CREATE datetime,
    GMT_MODIFIED datetime
);

CREATE TABLE CCDI_RESP_SUBACCOUNT
(
    ID varchar(19) not null primary key,
    REQ_MAIN_ID varchar(19),
    ZH varchar(40),
    ZZHXH varchar(10),
    ZZHLB varchar(20),
    ZZHZH varchar(30),
    BZ varchar(20),
    CHBZ varchar(20),
    ZHYE decimal(20,2),
    ZHZT varchar(20),
    KYYE decimal(20,2),
    GMT_CREATE datetime,
    GMT_MODIFIED datetime
);

CREATE TABLE CCDI_RESP_TRANS
(
    ID varchar(19) not null primary key,
    REQ_MAIN_ID varchar(19),
    CXKH varchar(40),
    JYLX varchar(50),
    JDBZ varchar(4),
    BZ varchar(10),
    JE decimal(20,2),
    YE decimal(20,2),
    JYSJ varchar(14),
    JYLSH varchar(50),
    JYDFXM varchar(60),
    JYDFZH varchar(30),
    JYDFKH varchar(40),
    JYDFZJHM varchar(30),
    JYDSYE decimal(20,2),
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
    BFZH varchar(30),
    BFKH varchar(40),
    GMT_CREATE datetime,
    GMT_MODIFIED datetime
);

CREATE TABLE CCDI_RESP_ZIP
(
    ID varchar(19) not null primary key,
    SQJGDM varchar(20),
    MBJGDM varchar(20),
    QQDBS varchar(30),
    REQ_ZIP_PATH varchar(200),
    REQ_ZIP_NAME varchar(120),
    NESTED_STATUS varchar(1),
    PARENT_REQ_ZIP_ID varchar(19),
    STATUS varchar(2),
    HZDM varchar(5),
    HZSM varchar(200),
    HZ_ZIP_PATH varchar(200),
    HZ_ZIP_NAME varchar(120),
    GMT_CREATE datetime,
    GMT_MODIFIED datetime
);

