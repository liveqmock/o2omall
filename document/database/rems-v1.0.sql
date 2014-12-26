/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2014/12/26 16:36:33                          */
/*==============================================================*/


drop table if exists refund;

drop table if exists return_exchange;

drop table if exists return_exchange_image;

drop table if exists service_audit;

/*==============================================================*/
/* Table: refund                                                */
/*==============================================================*/
create table refund
(
   id                   bigint not null auto_increment comment 'id����',
   service_no           varchar(30) comment '�ۺ󵥺�:�˻�T��ͷ;����H��ͷ;ά��X��ͷ',
   order_no             varchar(30) comment '������',
   refund_amount        double(10,2) comment '�˿���',
   account_no           varchar(30) comment '�˿��˺�',
   account_name         varchar(30) comment '�˿��˻�',
   refund_date          datetime comment '�����˿�����',
   create_time          timestamp comment '����ʱ��',
   update_time          timestamp comment '����ʱ��',
   create_user_id       bigint comment '������id',
   create_user          varchar(30) comment '������',
   update_user_id       bigint comment '������id',
   update_user          varchar(30) comment '������',
   yn                   tinyint default 1 comment '�Ƿ���Ч:1��Ч;0:��Ч',
   return_exchange_id   bigint comment '����id',
   primary key (id)
);

alter table refund comment '�˿��';

/*==============================================================*/
/* Table: return_exchange                                       */
/*==============================================================*/
create table return_exchange
(
   id                   bigint not null auto_increment comment 'id����',
   service_no           varchar(30) comment '�ۺ󵥺�:�˻�T��ͷ;����H��ͷ;ά��X��ͷ',
   pickup_no            varchar(30) comment 'ȡ������:��Ӧ�Ŀ�ݵ�ȡ������',
   service_audit_status smallint comment '�ۺ����״̬',
   order_no             varchar(30) comment '������',
   category_id          bigint comment '��Ʒ������',
   product_id           bigint comment '��Ʒid',
   sku_no               bigint comment '��Ʒ���',
   sku_name             varchar(50) comment '��Ʒ����',
   service_type         int comment '��������:1:�˻�:2:����:3ά��',
   quantity             bigint comment '�������Ʒ����',
   evidence_type        int comment 'ƾ������:1:��Ʊ:2:��ⱨ��',
   problem_description  varchar(200) comment '��������',
   pickup_type          int comment 'ȡ������:1:����ȡ��',
   pickup_province_no   varchar(20) comment 'ȡ��ʡ����',
   pickup_province_name varchar(30) comment 'ȡ��ʡ����',
   pickup_city_no       varchar(20) comment 'ȡ���б���',
   pickup_city_name     varchar(30) comment 'ȡ��������',
   pickup_county_no     varchar(20) comment 'ȡ���ر���',
   pickup_cuounty_name  varchar(30) comment 'ȡ��������',
   pickup_detailed_address varchar(100) comment 'ȡ����ϸ��ַ',
   reservation_pickup_time datetime comment 'ԤԼȡ��ʱ��',
   province_no          varchar(20) comment '�ջ�ʡ����',
   province_name        varchar(30) comment '�ջ�ʡ����',
   city_no              varchar(20) comment '�ջ��б���',
   city_name            varchar(30) comment '�ջ�������',
   county_no            varchar(20) comment '�ջ��ر���',
   cuounty_name         varchar(30) comment '�ջ�������',
   detailed_address     varchar(100) comment '�ջ���ϸ��ַ',
   consignee            varchar(30) comment '�ջ���',
   mobile_no            varchar(20) comment '�ջ����ֻ���',
   telephone_no         varchar(20) comment '�̶��绰',
   express_name         varchar(50) comment '��ݹ�˾����',
   express_no           varchar(20) comment '��ݹ�˾���',
   waybill_no           varchar(20) comment '��ݵ���',
   create_time          timestamp comment '����ʱ��',
   update_time          timestamp comment '����ʱ��',
   create_user_id       bigint comment '������id',
   create_user          varchar(30) comment '������',
   update_user_id       bigint comment '������id',
   update_user          varchar(30) comment '������',
   yn                   tinyint default 1 comment '�Ƿ���Ч:1��Ч;0:��Ч',
   primary key (id)
);

alter table return_exchange comment '�˻���';

/*==============================================================*/
/* Table: return_exchange_image                                 */
/*==============================================================*/
create table return_exchange_image
(
   id                   bigint not null auto_increment comment 'id����',
   return_exchange_id   bigint comment '����id',
   service_no           varchar(30) comment '�ۺ󵥺�:�˻�T��ͷ;����H��ͷ;ά��X��ͷ',
   order_no             varchar(30) comment '������',
   image_url            varchar(100) comment '�˻���ͼƬURL',
   create_time          timestamp comment '����ʱ��',
   update_time          timestamp comment '����ʱ��',
   create_user_id       bigint comment '������id',
   create_user          varchar(30) comment '������',
   update_user_id       bigint comment '������id',
   update_user          varchar(30) comment '������',
   yn                   tinyint default 1 comment '�Ƿ���Ч:1��Ч;0:��Ч',
   primary key (id)
);

alter table return_exchange_image comment '�˻���ͼƬ��';

/*==============================================================*/
/* Table: service_audit                                         */
/*==============================================================*/
create table service_audit
(
   id                   bigint not null auto_increment comment 'id����',
   return_exchange_id   bigint comment '����id',
   service_no           varchar(30) comment '�ۺ󵥺�:�˻�T��ͷ;����H��ͷ;ά��X��ͷ',
   order_no             varchar(30) comment '������',
   status               int comment '����״̬:10:�ͻ��ύ:20:�ۺ����;30:�ۺ��ջ�;40:�˿�;50:���',
   comment              varchar(200) comment '��˱�ע',
   create_time          timestamp comment '����ʱ��',
   update_time          timestamp comment '����ʱ��',
   create_user_id       bigint comment '������id',
   create_user          varchar(30) comment '������',
   update_user_id       bigint comment '������id',
   update_user          varchar(30) comment '������',
   yn                   tinyint default 1 comment '�Ƿ���Ч:1��Ч;0:��Ч',
   primary key (id)
);

alter table service_audit comment '��������쳣���������˽��';

