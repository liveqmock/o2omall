/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2014/12/28 11:46:53                          */
/*==============================================================*/


drop table if exists channel;

drop table if exists refund;

drop table if exists trade;

drop table if exists trade_refund_fail;

/*==============================================================*/
/* Table: channel                                               */
/*==============================================================*/
create table channel
(
   id                   bigint not null auto_increment comment 'id自增',
   channel_no           bigint comment '通道编号',
   channel_name         varchar(50) comment '通道名称',
   channel_category_no  bigint comment '通道分类编号',
   channel_category_name varchar(50) comment '通道分类名称',
   is_default           tinyint comment '是否默认',
   priority             int comment '优先级',
   create_time          timestamp comment '创建时间',
   update_time          timestamp comment '更新时间',
   create_user_id       bigint comment '创建人id',
   create_user          varchar(30) comment '创建人',
   update_user_id       bigint comment '更新人id',
   update_user          varchar(30) comment '更新人',
   yn                   tinyint default 1 comment '是否有效:1有效;0:无效',
   primary key (id)
);

alter table channel comment '支付通道';

/*==============================================================*/
/* Table: refund                                                */
/*==============================================================*/
create table refund
(
   id                   bigint not null auto_increment comment 'id自增',
   service_no           varchar(30) comment '售后单号:退货T开头;换货H开头;维修X开头',
   order_no             varchar(30) comment '订单号',
   business_no          varchar(30) comment '商家编号',
   business_name        varchar(100) comment '商家名称',
   refund_amount        double(10,2) comment '退款金额',
   account_no           varchar(30) comment '退款账号',
   account_name         varchar(30) comment '退款账户',
   refund_date          datetime comment '发起退款日期',
   serial_no            varchar(30) comment '交易流水号',
   status               int comment '退款交易状态',
   create_time          timestamp comment '创建时间',
   update_time          timestamp comment '更新时间',
   create_user_id       bigint comment '创建人id',
   create_user          varchar(30) comment '创建人',
   update_user_id       bigint comment '更新人id',
   update_user          varchar(30) comment '更新人',
   yn                   tinyint default 1 comment '是否有效:1有效;0:无效',
   primary key (id)
);

alter table refund comment '逆向退款';

/*==============================================================*/
/* Table: trade                                                 */
/*==============================================================*/
create table trade
(
   id                   bigint not null auto_increment comment 'id自增',
   login_no             varchar(0) comment '账号',
   login_name           varchar(0) comment '账号姓名',
   channel_no           bigint comment '通道编号',
   channel_name         varchar(50) comment '通道名称',
   order_no             varchar(30) comment '订单号',
   business_no          varchar(30) comment '商家编号',
   business_name        varchar(100) comment '商家名称',
   amount               double(10,2) comment '交易金额',
   trade_time           datetime comment '交易时间',
   serial_no            varchar(30) comment '交易流水号',
   status               int comment '交易状态',
   account_no           varchar(30) comment '支付帐号',
   account_name         varchar(30) comment '支付人姓名',
   create_time          timestamp comment '创建时间',
   update_time          timestamp comment '更新时间',
   create_user_id       bigint comment '创建人id',
   create_user          varchar(30) comment '创建人',
   update_user_id       bigint comment '更新人id',
   update_user          varchar(30) comment '更新人',
   yn                   tinyint default 1 comment '是否有效:1有效;0:无效',
   primary key (id)
);

alter table trade comment '正向交易';

/*==============================================================*/
/* Table: trade_refund_fail                                     */
/*==============================================================*/
create table trade_refund_fail
(
   id                   bigint not null auto_increment comment 'id自增',
   order_no             bigint comment '订单号',
   pay_type             int comment '交易类型10:正向交易;20:逆向退款',
   status               int comment '执行状态',
   execute_count        int comment '执行次数',
   create_time          timestamp comment '创建时间',
   update_time          timestamp comment '更新时间',
   create_user          varchar(30) comment '创建人',
   update_user          varchar(30) comment '更新人',
   yn                   tinyint default 1 comment '是否有效:1有效;0:无效',
   primary key (id)
);

alter table trade_refund_fail comment '正向交易及逆向退款失败表 ';

