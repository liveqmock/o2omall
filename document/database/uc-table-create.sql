/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2014/12/23 15:02:37                          */
/*==============================================================*/


drop table if exists area;

drop table if exists user_account;

drop table if exists user_address;

drop table if exists user_profile;

/*==============================================================*/
/* Table: area                                                  */
/*==============================================================*/
create table area
(
   id                   bigint not null auto_increment comment '自增ID',
   parent_code          varchar(30) comment '父编号',
   code                 varchar(30) comment '编号',
   name                 varchar(30) comment '名称',
   level                tinyint(4) comment '级别',
   create_user          varchar(30) comment '创建人',
   create_time          timestamp comment '创建时间',
   update_user          varchar(30) comment '修改人',
   update_time          timestamp comment '修改时间',
   yn                   tinyint(4) comment '是否有效: 1-有效, 0-无效',
   primary key (id)
);

alter table area comment '三级地址表';

/*==============================================================*/
/* Table: user_account                                          */
/*==============================================================*/
create table user_account
(
   id                   bigint not null auto_increment comment 'id自增',
   username             varchar(20) comment '账号',
   password             varchar(50) comment '密码',
   login_times          int(11) comment '登录次数',
   last_login_ip        varchar(15) comment '用户上次登录IP',
   last_login_time      timestamp comment '用户上次登录时间',
   create_user          varchar(30) comment '创建人',
   update_user          varchar(30) comment '修改人',
   create_time          timestamp comment '创建时间',
   update_time          timestamp comment '修改时间',
   yn                   tinyint(4) comment '是否有效: 1-有效, 0-无效',
   primary key (id)
);

alter table user_account comment '用户账号表';

/*==============================================================*/
/* Table: user_address                                          */
/*==============================================================*/
create table user_address
(
   id                   bigint not null auto_increment comment '自增Id',
   user_id              bigint comment '用户ID',
   name                 varchar(50) comment '收货人姓名',
   province_name        varchar(30) comment '省份名称',
   province_no          varchar(30) comment '省份编码',
   city_name            varchar(30) comment '市名称',
   city_no              varchar(30) comment '市编号',
   county_name          varchar(30) comment '县名称',
   county_no            varchar(30) comment '县编码',
   address              varchar(500) comment '详细地址',
   mobile               varchar(20) comment '移动电话',
   phone                varchar(30) comment '固定电话',
   email                varchar(30) comment '电子邮件',
   zipcode              varchar(10) comment '邮编',
   create_user          varchar(30) comment '创建人',
   update_user          varchar(30) comment '修改人',
   create_time          timestamp comment '创建时间',
   update_time          timestamp comment '修改时间',
   yn                   tinyint(4) comment '是否有效: 1-有效, 0-无效',
   primary key (id)
);

alter table user_address comment '收货地址表';

/*==============================================================*/
/* Table: user_profile                                          */
/*==============================================================*/
create table user_profile
(
   id                   bigint not null auto_increment comment 'id自增',
   user_id              bigint comment '用户ID',
   cn_name               varchar(20) comment '姓名',
   sex                  tinyint(4) comment '性别',
   nickname             varchar(50) comment '昵称',
   email                varchar(50) comment '邮箱',
   email_validated      tinyint(4) comment '0为未验证;1为正在更换邮箱;2为已验证',
   birthday             datetime comment '生日',
   constellation        varchar(20) comment '星座',
   user_photo           varchar(100) comment '用户头像',
   description          varchar(200) comment '自我介绍',
   province_name        varchar(30) comment '地区-省份-名称',
   province_no          varchar(30) comment '地区-省份-编号',
   city_name            varchar(30) comment '地区-市-名称',
   city_no              varchar(30) comment '地区-市-编号',
   county_name          varchar(30) comment '地区-县-名称',
   county_no            varchar(30) comment '地区-县-编号',
   address              varchar(500) comment '联系地址',
   mobile               varchar(20) comment '移动电话',
   phone                varchar(20) comment '固定电话',
   safe_question        varchar(50) comment '安全问题',
   safe_answer          varchar(50) comment '安全问题答案',
   qq                   varchar(20) comment 'QQ',
   grade                int(11) comment '会员等级',
   pay_password         varchar(50) comment '支付密码',
   score                int(11) comment '我的剩余积分',
   create_time          timestamp comment '创建时间',
   update_time          timestamp comment '修改时间',
   create_user          varchar(30) comment '创建人',
   update_user          varchar(30) comment '修改人',
   yn                   tinyint(4) comment '是否有效: 1-有效, 0-无效',
   primary key (id)
);

alter table user_profile comment '用户基本信息表';

