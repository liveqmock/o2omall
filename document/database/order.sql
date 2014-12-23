/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2014/12/23 11:37:40                          */
/*==============================================================*/


drop table if exists e_coupon;

drop table if exists order_cancel;

drop table if exists order_log;

drop table if exists orders;

drop table if exists orders_items;

drop table if exists shopping_cart;

/*==============================================================*/
/* Table: e_coupon                                              */
/*==============================================================*/
create table e_coupon
(
   id                   bigint not null auto_increment comment '����id',
   order_no             varchar(30) comment '������',
   voucher_no           varchar(30) comment 'ȯ��',
   type                 tinyint(4) comment '����',
   status               tinyint comment '10:��ʼ״̬;20:ʹ��;30:��ʹ��',
   effective_time       timestamp comment '��Ч��',
   dead_line            timestamp comment '��ֹ����',
   generate_time        timestamp comment '����ʱ��',
   create_user          varchar(30) comment '������',
   create_time          timestamp comment '����ʱ��',
   update_user          varchar(30) comment '�޸���',
   update_time          timestamp comment '�޸�ʱ��',
   yn                   tinyint(4) comment '0:��Ч;1:��Ч',
   primary key (id)
);

alter table e_coupon comment '����ȯ��';

/*==============================================================*/
/* Table: order_cancel                                          */
/*==============================================================*/
create table order_cancel
(
   id                   bigint not null auto_increment comment '����id',
   refund               varchar(30) comment '�˿��',
   status               tinyint comment '501:�����;502:�˿���;503:���˿�;503:��˲���;504:�˿�ʧ��;',
   order_no             varchar(30) comment '�������',
   refund_amount        decimal(10,2) comment '�˿���',
   cancel_reason        varchar(30) comment 'ȡ��ԭ��',
   cancel_type          tinyint(4) comment 'ȡ������',
   current_audit_name   varchar(30) comment '���������',
   current_audit_no     varchar(30) comment '����˱��',
   is_auditing          bigint(4) comment '0����ͨ����1��ͨ��',
   auditing_time        timestamp comment '���ʱ��',
   finish_time          timestamp comment '�˿����ʱ��',
   remark               varchar(100) comment '������',
   is_refund            tinyint(4) comment '0:����Ҫ;1��Ҫ',
   create_user          varchar(30) comment '����������',
   update_user          varchar(30) comment '�޸�������',
   create_time          timestamp comment '����ʱ��',
   update_time          timestamp comment '�޸�ʱ��',
   yn                   tinyint(4) comment '1:��Ч;0:��Ч',
   primary key (id)
);

alter table order_cancel comment '����ȡ����';

/*==============================================================*/
/* Table: order_log                                             */
/*==============================================================*/
create table order_log
(
   id                   bigint not null auto_increment comment '����id',
   order_no             varchar(30) comment '�������',
   status               tinyint(4) comment '����״̬',
   status_name          varchar(30) comment '״̬����',
   description          varchar(50) comment '��������',
   log_type             tinyint(4) comment '100:ǰ̨��ʾ;200��̨��ʾ',
   create_time          timestamp comment '����ʱ��',
   create_user          varchar(50) comment '������',
   update_time          timestamp comment '�޸�ʱ��',
   update_user          varchar(50) comment '�޸���',
   yn                   tinyint(4) comment '�Ƿ���Ч',
   primary key (id)
);

alter table order_log comment '������־��';

/*==============================================================*/
/* Table: orders                                                */
/*==============================================================*/
create table orders
(
   id                   bigint not null auto_increment comment '����id',
   order_no             varchar(30) comment '�������',
   order_type           tinyint(4) comment '100:���ﶩ��;200:���ⶩ��',
   user_id              bigint not null comment '�û�ID',
   user_name            varchar(30) comment '�µ��û��˺�',
   order_name           varchar(30) comment '�µ�����',
   consignee_name       varchar(30) comment '�ջ�������',
   consignee_phone      varchar(50) comment '�ջ����ֻ���',
   telephone            varchar(30) comment '�̶��绰',
   emil                 varchar(30) comment '����',
   zip_code             varchar(30) comment '�ʱ�',
   pay_name             varchar(30) comment '֧������',
   order_date           tinyint(4) comment '1-ֻ�������ͻ�(˫���ա����ղ�����)
            2-�����ա�˫��������վ����ͻ�
            3-ֻ˫���ա������ͻ�(�����ղ�����)
            ',
   is_tal_sure          tinyint(4) comment '0-��;1-ȷ��',
   pay_way              tinyint(4) comment '1-�ֽ�;2-Posˢ��',
   pay_type             tinyint(4) comment '1-��������;2-����֧��;3-��˾ת��;4-�ʼ����',
   is_invoice           tinyint(4) comment '0:��Ҫ;1:Ҫ',
   invoice_type         tinyint(4) comment '1-��ͨ��Ʊ;2-��ֵ˰��Ʊ',
   invoice_title        tinyint(4) comment '1-����;2-��λ',
   invoice_content      tinyint(4) comment '1-��ϸ;2-�칫��Ʒ;3-�������;4-�Ĳģ�',
   order_status         tinyint(4) comment '10-�û�ȡ��;20-�û�ɾ��;30-ϵͳȡ��;40-������;50-���տ�;60-�ѷ���;70-��ǩ��;80-�������;90-����;100-�����;110-�������;120-���˻�;130-���˻�;140-������;150-�ѻ���;160-���˿�;
            ',
   comm_amount          decimal(10,2) comment '����Ʒ���',
   ret_cash             decimal(10,2) comment '����',
   expenses             decimal(10,2) comment '�˷�',
   amount_pay           decimal(10,2) comment 'Ӧ���ܶ�',
   parent_order_no      varchar(50) comment '���������',
   province_name        varchar(30) comment 'ʡ������',
   province_no          varchar(30) comment 'ʡ�ݱ��',
   city_name            varchar(30) comment '������',
   city_no              varchar(30) comment '�б��',
   county_name          varchar(30) comment '������',
   county_no            varchar(30) comment '�ر���',
   address              varchar(100) comment '�ͻ���ַ',
   pay_time             timestamp comment '֧��ʱ��',
   Integral             int(11) comment '����',
   remark               varchar(100) comment '������ע',
   create_time          timestamp comment '����ʱ��',
   update_time          timestamp comment '�޸�ʱ��',
   create_user          varchar(50) comment '������',
   update_user          varchar(50) comment '�޸���',
   yn                   tinyint(4) comment '0:��Ч;1��Ч',
   primary key (id)
);

alter table orders comment '������';

/*==============================================================*/
/* Table: orders_items                                          */
/*==============================================================*/
create table orders_items
(
   id                   bigint not null auto_increment comment '��������id',
   order_no             varchar(30) comment '�������',
   sku_no               varchar(30) comment 'sku���',
   product_no           varchar(30) comment '��Ʒ���',
   count                int comment '��Ʒ����',
   sku_name             varchar(100) comment 'sku����',
   img_url              varchar(100) comment '��Ʒ��ͼ',
   discount             decimal(10,2) comment '��Ʒ�Żݼ�',
   sku_price            decimal(10,2) comment '��Ʒ����',
   final_price          decimal(10,2) comment '�Żݺ�۸�',
   create_user          varchar(50) comment '������',
   update_user          varchar(50) comment '�޸���',
   create_time          timestamp comment '����ʱ��',
   update_time          timestamp comment '�޸�ʱ��',
   yn                   tinyint(4) comment '0-��Ч;1-��Ч',
   primary key (id)
);

alter table orders_items comment '������ϸ��';

/*==============================================================*/
/* Table: shopping_cart                                         */
/*==============================================================*/
create table shopping_cart
(
   id                   bigint not null auto_increment comment '����id',
   user_no              varchar(50) comment '�û����',
   sku_no               varchar(50) comment '��Ʒ���',
   sku_count            tinyint(4) comment '��Ʒ����',
   status               tinyint(4) comment '1:����״̬;2-ɾ��;3-���µ�',
   create_time          timestamp comment '����ʱ��',
   update_time          timestamp comment '����ʱ��',
   create_user          varchar(50) comment '������',
   update_user          varchar(50) comment '�޸���',
   yn                   tinyint(4) comment '0:��Ч;1:��Ч',
   primary key (id)
);

alter table shopping_cart comment '���ﳵ��';

