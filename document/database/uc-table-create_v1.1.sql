/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2015/1/6 15:18:09                            */
/*==============================================================*/


DROP TABLE IF EXISTS AREA;

DROP TABLE IF EXISTS user_account;

DROP TABLE IF EXISTS user_address;

DROP TABLE IF EXISTS user_profile;

/*==============================================================*/
/* Table: area                                                  */
/*==============================================================*/
CREATE TABLE AREA
(
   id                   BIGINT NOT NULL AUTO_INCREMENT COMMENT '自增ID',
   parent_code          VARCHAR(30) COMMENT '父编号',
   CODE                 VARCHAR(30) COMMENT '编号',
   NAME                 VARCHAR(30) COMMENT '名称',
   LEVEL                TINYINT(4) COMMENT '级别',
   create_user          VARCHAR(30) COMMENT '创建人',
   create_time          TIMESTAMP COMMENT '创建时间',
   update_user          VARCHAR(30) COMMENT '修改人',
   update_time          TIMESTAMP COMMENT '修改时间',
   yn                   TINYINT(4) COMMENT '是否有效: 1-有效, 0-无效',
   PRIMARY KEY (id)
);

ALTER TABLE AREA COMMENT '三级地址表';

/*==============================================================*/
/* Table: user_account                                          */
/*==============================================================*/
CREATE TABLE user_account
(
   id                   BIGINT NOT NULL AUTO_INCREMENT COMMENT 'id自增',
   username             VARCHAR(20) COMMENT '账号',
   PASSWORD             VARCHAR(50) COMMENT '密码',
   login_times          INT(11) COMMENT '登录次数',
   last_login_ip        VARCHAR(15) COMMENT '用户上次登录IP',
   last_login_time      TIMESTAMP COMMENT '用户上次登录时间',
   create_user          VARCHAR(30) COMMENT '创建人',
   update_user          VARCHAR(30) COMMENT '修改人',
   create_time          TIMESTAMP COMMENT '创建时间',
   update_time          TIMESTAMP COMMENT '修改时间',
   yn                   TINYINT(4) COMMENT '是否有效: 1-有效, 0-无效',
   PRIMARY KEY (id)
);

ALTER TABLE user_account COMMENT '用户账号表';

/*==============================================================*/
/* Table: user_address                                          */
/*==============================================================*/
CREATE TABLE user_address
(
   id                   BIGINT NOT NULL AUTO_INCREMENT COMMENT '自增Id',
   user_id              BIGINT COMMENT '用户ID',
   NAME                 VARCHAR(50) COMMENT '收货人姓名',
   province_name        VARCHAR(30) COMMENT '省份名称',
   province_no          VARCHAR(30) COMMENT '省份编码',
   city_name            VARCHAR(30) COMMENT '市名称',
   city_no              VARCHAR(30) COMMENT '市编号',
   county_name          VARCHAR(30) COMMENT '县名称',
   county_no            VARCHAR(30) COMMENT '县编码',
   address              VARCHAR(500) COMMENT '详细地址',
   mobile               VARCHAR(20) COMMENT '移动电话',
   phone                VARCHAR(30) COMMENT '固定电话',
   email                VARCHAR(30) COMMENT '电子邮件',
   isdefault            TINYINT DEFAULT 0 COMMENT '默认地址:1:默认;0:非默认',
   zipcode              VARCHAR(10) COMMENT '邮编',
   is_default           TINYINT(4) COMMENT '1:默认;0不默认',
   create_user          VARCHAR(30) COMMENT '创建人',
   update_user          VARCHAR(30) COMMENT '修改人',
   create_time          TIMESTAMP COMMENT '创建时间',
   update_time          TIMESTAMP COMMENT '修改时间',
   yn                   TINYINT(4) COMMENT '是否有效: 1-有效, 0-无效',
   PRIMARY KEY (id)
);

ALTER TABLE user_address COMMENT '收货地址表';

/*==============================================================*/
/* Table: user_profile                                          */
/*==============================================================*/
CREATE TABLE user_profile
(
   id                   BIGINT NOT NULL AUTO_INCREMENT COMMENT 'id自增',
   user_id              BIGINT COMMENT '用户ID',
   cn_name              VARCHAR(20) COMMENT '姓名',
   sex                  TINYINT(4) COMMENT '性别',
   nickname             VARCHAR(50) COMMENT '昵称',
   email                VARCHAR(50) COMMENT '邮箱',
   email_validated      TINYINT(4) COMMENT '0为未验证;1为正在更换邮箱;2为已验证',
   birthday             DATETIME COMMENT '生日',
   constellation        VARCHAR(20) COMMENT '星座',
   user_photo           VARCHAR(100) COMMENT '用户头像',
   description          VARCHAR(200) COMMENT '自我介绍',
   province_name        VARCHAR(30) COMMENT '地区-省份-名称',
   province_no          VARCHAR(30) COMMENT '地区-省份-编号',
   city_name            VARCHAR(30) COMMENT '地区-市-名称',
   city_no              VARCHAR(30) COMMENT '地区-市-编号',
   county_name          VARCHAR(30) COMMENT '地区-县-名称',
   county_no            VARCHAR(30) COMMENT '地区-县-编号',
   address              VARCHAR(500) COMMENT '联系地址',
   mobile               VARCHAR(20) COMMENT '移动电话',
   phone                VARCHAR(20) COMMENT '固定电话',
   safe_question        VARCHAR(50) COMMENT '安全问题',
   safe_answer          VARCHAR(50) COMMENT '安全问题答案',
   qq                   VARCHAR(20) COMMENT 'QQ',
   grade                INT(11) COMMENT '会员等级',
   pay_password         VARCHAR(50) COMMENT '支付密码',
   score                INT(11) COMMENT '我的剩余积分',
   create_time          TIMESTAMP COMMENT '创建时间',
   update_time          TIMESTAMP COMMENT '修改时间',
   create_user          VARCHAR(30) COMMENT '创建人',
   update_user          VARCHAR(30) COMMENT '修改人',
   yn                   TINYINT(4) COMMENT '是否有效: 1-有效, 0-无效',
   PRIMARY KEY (id)
);

ALTER TABLE user_profile COMMENT '用户基本信息表';

