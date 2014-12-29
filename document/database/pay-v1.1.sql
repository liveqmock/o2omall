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
   id                   bigint not null auto_increment comment 'id����',
   channel_no           bigint comment 'ͨ�����',
   channel_name         varchar(50) comment 'ͨ������',
   channel_category_no  bigint comment 'ͨ��������',
   channel_category_name varchar(50) comment 'ͨ����������',
   is_default           tinyint comment '�Ƿ�Ĭ��',
   priority             int comment '���ȼ�',
   create_time          timestamp comment '����ʱ��',
   update_time          timestamp comment '����ʱ��',
   create_user_id       bigint comment '������id',
   create_user          varchar(30) comment '������',
   update_user_id       bigint comment '������id',
   update_user          varchar(30) comment '������',
   yn                   tinyint default 1 comment '�Ƿ���Ч:1��Ч;0:��Ч',
   primary key (id)
);

alter table channel comment '֧��ͨ��';

/*==============================================================*/
/* Table: refund                                                */
/*==============================================================*/
create table refund
(
   id                   bigint not null auto_increment comment 'id����',
   service_no           varchar(30) comment '�ۺ󵥺�:�˻�T��ͷ;����H��ͷ;ά��X��ͷ',
   order_no             varchar(30) comment '������',
   business_no          varchar(30) comment '�̼ұ��',
   business_name        varchar(100) comment '�̼�����',
   refund_amount        double(10,2) comment '�˿���',
   account_no           varchar(30) comment '�˿��˺�',
   account_name         varchar(30) comment '�˿��˻�',
   refund_date          datetime comment '�����˿�����',
   serial_no            varchar(30) comment '������ˮ��',
   status               int comment '�˿��״̬',
   create_time          timestamp comment '����ʱ��',
   update_time          timestamp comment '����ʱ��',
   create_user_id       bigint comment '������id',
   create_user          varchar(30) comment '������',
   update_user_id       bigint comment '������id',
   update_user          varchar(30) comment '������',
   yn                   tinyint default 1 comment '�Ƿ���Ч:1��Ч;0:��Ч',
   primary key (id)
);

alter table refund comment '�����˿�';

/*==============================================================*/
/* Table: trade                                                 */
/*==============================================================*/
create table trade
(
   id                   bigint not null auto_increment comment 'id����',
   login_no             varchar(0) comment '�˺�',
   login_name           varchar(0) comment '�˺�����',
   channel_no           bigint comment 'ͨ�����',
   channel_name         varchar(50) comment 'ͨ������',
   order_no             varchar(30) comment '������',
   business_no          varchar(30) comment '�̼ұ��',
   business_name        varchar(100) comment '�̼�����',
   amount               double(10,2) comment '���׽��',
   trade_time           datetime comment '����ʱ��',
   serial_no            varchar(30) comment '������ˮ��',
   status               int comment '����״̬',
   account_no           varchar(30) comment '֧���ʺ�',
   account_name         varchar(30) comment '֧��������',
   create_time          timestamp comment '����ʱ��',
   update_time          timestamp comment '����ʱ��',
   create_user_id       bigint comment '������id',
   create_user          varchar(30) comment '������',
   update_user_id       bigint comment '������id',
   update_user          varchar(30) comment '������',
   yn                   tinyint default 1 comment '�Ƿ���Ч:1��Ч;0:��Ч',
   primary key (id)
);

alter table trade comment '������';

/*==============================================================*/
/* Table: trade_refund_fail                                     */
/*==============================================================*/
create table trade_refund_fail
(
   id                   bigint not null auto_increment comment 'id����',
   order_no             bigint comment '������',
   pay_type             int comment '��������10:������;20:�����˿�',
   status               int comment 'ִ��״̬',
   execute_count        int comment 'ִ�д���',
   create_time          timestamp comment '����ʱ��',
   update_time          timestamp comment '����ʱ��',
   create_user          varchar(30) comment '������',
   update_user          varchar(30) comment '������',
   yn                   tinyint default 1 comment '�Ƿ���Ч:1��Ч;0:��Ч',
   primary key (id)
);

alter table trade_refund_fail comment '�����׼������˿�ʧ�ܱ� ';

