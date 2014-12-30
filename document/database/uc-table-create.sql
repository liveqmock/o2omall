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
   id                   bigint not null auto_increment comment '����ID',
   parent_code          varchar(30) comment '�����',
   code                 varchar(30) comment '���',
   name                 varchar(30) comment '����',
   level                tinyint(4) comment '����',
   create_user          varchar(30) comment '������',
   create_time          timestamp comment '����ʱ��',
   update_user          varchar(30) comment '�޸���',
   update_time          timestamp comment '�޸�ʱ��',
   yn                   tinyint(4) comment '�Ƿ���Ч: 1-��Ч, 0-��Ч',
   primary key (id)
);

alter table area comment '������ַ��';

/*==============================================================*/
/* Table: user_account                                          */
/*==============================================================*/
create table user_account
(
   id                   bigint not null auto_increment comment 'id����',
   username             varchar(20) comment '�˺�',
   password             varchar(50) comment '����',
   login_times          int(11) comment '��¼����',
   last_login_ip        varchar(15) comment '�û��ϴε�¼IP',
   last_login_time      timestamp comment '�û��ϴε�¼ʱ��',
   create_user          varchar(30) comment '������',
   update_user          varchar(30) comment '�޸���',
   create_time          timestamp comment '����ʱ��',
   update_time          timestamp comment '�޸�ʱ��',
   yn                   tinyint(4) comment '�Ƿ���Ч: 1-��Ч, 0-��Ч',
   primary key (id)
);

alter table user_account comment '�û��˺ű�';

/*==============================================================*/
/* Table: user_address                                          */
/*==============================================================*/
create table user_address
(
   id                   bigint not null auto_increment comment '����Id',
   user_id              bigint comment '�û�ID',
   name                 varchar(50) comment '�ջ�������',
   province_name        varchar(30) comment 'ʡ������',
   province_no          varchar(30) comment 'ʡ�ݱ���',
   city_name            varchar(30) comment '������',
   city_no              varchar(30) comment '�б��',
   county_name          varchar(30) comment '������',
   county_no            varchar(30) comment '�ر���',
   address              varchar(500) comment '��ϸ��ַ',
   mobile               varchar(20) comment '�ƶ��绰',
   phone                varchar(30) comment '�̶��绰',
   email                varchar(30) comment '�����ʼ�',
   zipcode              varchar(10) comment '�ʱ�',
   create_user          varchar(30) comment '������',
   update_user          varchar(30) comment '�޸���',
   create_time          timestamp comment '����ʱ��',
   update_time          timestamp comment '�޸�ʱ��',
   yn                   tinyint(4) comment '�Ƿ���Ч: 1-��Ч, 0-��Ч',
   primary key (id)
);

alter table user_address comment '�ջ���ַ��';

/*==============================================================*/
/* Table: user_profile                                          */
/*==============================================================*/
create table user_profile
(
   id                   bigint not null auto_increment comment 'id����',
   user_id              bigint comment '�û�ID',
   cn_name               varchar(20) comment '����',
   sex                  tinyint(4) comment '�Ա�',
   nickname             varchar(50) comment '�ǳ�',
   email                varchar(50) comment '����',
   email_validated      tinyint(4) comment '0Ϊδ��֤;1Ϊ���ڸ�������;2Ϊ����֤',
   birthday             datetime comment '����',
   constellation        varchar(20) comment '����',
   user_photo           varchar(100) comment '�û�ͷ��',
   description          varchar(200) comment '���ҽ���',
   province_name        varchar(30) comment '����-ʡ��-����',
   province_no          varchar(30) comment '����-ʡ��-���',
   city_name            varchar(30) comment '����-��-����',
   city_no              varchar(30) comment '����-��-���',
   county_name          varchar(30) comment '����-��-����',
   county_no            varchar(30) comment '����-��-���',
   address              varchar(500) comment '��ϵ��ַ',
   mobile               varchar(20) comment '�ƶ��绰',
   phone                varchar(20) comment '�̶��绰',
   safe_question        varchar(50) comment '��ȫ����',
   safe_answer          varchar(50) comment '��ȫ�����',
   qq                   varchar(20) comment 'QQ',
   grade                int(11) comment '��Ա�ȼ�',
   pay_password         varchar(50) comment '֧������',
   score                int(11) comment '�ҵ�ʣ�����',
   create_time          timestamp comment '����ʱ��',
   update_time          timestamp comment '�޸�ʱ��',
   create_user          varchar(30) comment '������',
   update_user          varchar(30) comment '�޸���',
   yn                   tinyint(4) comment '�Ƿ���Ч: 1-��Ч, 0-��Ч',
   primary key (id)
);

alter table user_profile comment '�û�������Ϣ��';

