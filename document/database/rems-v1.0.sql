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
   id                   bigint not null auto_increment comment 'id自增',
   service_no           varchar(30) comment '售后单号:退货T开头;换货H开头;维修X开头',
   order_no             varchar(30) comment '订单号',
   refund_amount        double(10,2) comment '退款金额',
   account_no           varchar(30) comment '退款账号',
   account_name         varchar(30) comment '退款账户',
   refund_date          datetime comment '发起退款日期',
   create_time          timestamp comment '创建时间',
   update_time          timestamp comment '更新时间',
   create_user_id       bigint comment '创建人id',
   create_user          varchar(30) comment '创建人',
   update_user_id       bigint comment '更新人id',
   update_user          varchar(30) comment '更新人',
   yn                   tinyint default 1 comment '是否有效:1有效;0:无效',
   return_exchange_id   bigint comment '主表id',
   primary key (id)
);

alter table refund comment '退款表';

/*==============================================================*/
/* Table: return_exchange                                       */
/*==============================================================*/
create table return_exchange
(
   id                   bigint not null auto_increment comment 'id自增',
   service_no           varchar(30) comment '售后单号:退货T开头;换货H开头;维修X开头',
   pickup_no            varchar(30) comment '取件单号:对应的快递的取件单号',
   service_audit_status smallint comment '售后单审核状态',
   order_no             varchar(30) comment '订单号',
   category_id          bigint comment '商品分类编号',
   product_id           bigint comment '产品id',
   sku_no               bigint comment '商品编号',
   sku_name             varchar(50) comment '商品名称',
   service_type         int comment '服务类型:1:退货:2:换货:3维修',
   quantity             bigint comment '申请的商品数量',
   evidence_type        int comment '凭据类型:1:发票:2:检测报告',
   problem_description  varchar(200) comment '问题描述',
   pickup_type          int comment '取件类型:1:上门取件',
   pickup_province_no   varchar(20) comment '取件省编码',
   pickup_province_name varchar(30) comment '取件省名称',
   pickup_city_no       varchar(20) comment '取件市编码',
   pickup_city_name     varchar(30) comment '取件市名字',
   pickup_county_no     varchar(20) comment '取件县编码',
   pickup_cuounty_name  varchar(30) comment '取件县名称',
   pickup_detailed_address varchar(100) comment '取件详细地址',
   reservation_pickup_time datetime comment '预约取件时间',
   province_no          varchar(20) comment '收货省编码',
   province_name        varchar(30) comment '收货省名称',
   city_no              varchar(20) comment '收货市编码',
   city_name            varchar(30) comment '收货市名字',
   county_no            varchar(20) comment '收货县编码',
   cuounty_name         varchar(30) comment '收货县名称',
   detailed_address     varchar(100) comment '收货详细地址',
   consignee            varchar(30) comment '收货人',
   mobile_no            varchar(20) comment '收货人手机号',
   telephone_no         varchar(20) comment '固定电话',
   express_name         varchar(50) comment '快递公司名称',
   express_no           varchar(20) comment '快递公司编号',
   waybill_no           varchar(20) comment '快递单号',
   create_time          timestamp comment '创建时间',
   update_time          timestamp comment '更新时间',
   create_user_id       bigint comment '创建人id',
   create_user          varchar(30) comment '创建人',
   update_user_id       bigint comment '更新人id',
   update_user          varchar(30) comment '更新人',
   yn                   tinyint default 1 comment '是否有效:1有效;0:无效',
   primary key (id)
);

alter table return_exchange comment '退换货';

/*==============================================================*/
/* Table: return_exchange_image                                 */
/*==============================================================*/
create table return_exchange_image
(
   id                   bigint not null auto_increment comment 'id自增',
   return_exchange_id   bigint comment '主表id',
   service_no           varchar(30) comment '售后单号:退货T开头;换货H开头;维修X开头',
   order_no             varchar(30) comment '订单号',
   image_url            varchar(100) comment '退换货图片URL',
   create_time          timestamp comment '创建时间',
   update_time          timestamp comment '更新时间',
   create_user_id       bigint comment '创建人id',
   create_user          varchar(30) comment '创建人',
   update_user_id       bigint comment '更新人id',
   update_user          varchar(30) comment '更新人',
   yn                   tinyint default 1 comment '是否有效:1有效;0:无效',
   primary key (id)
);

alter table return_exchange_image comment '退换货图片表';

/*==============================================================*/
/* Table: service_audit                                         */
/*==============================================================*/
create table service_audit
(
   id                   bigint not null auto_increment comment 'id自增',
   return_exchange_id   bigint comment '主表id',
   service_no           varchar(30) comment '售后单号:退货T开头;换货H开头;维修X开头',
   order_no             varchar(30) comment '订单号',
   status               int comment '服务单状态:10:客户提交:20:售后审核;30:售后收货;40:退款;50:完成',
   comment              varchar(200) comment '审核备注',
   create_time          timestamp comment '创建时间',
   update_time          timestamp comment '更新时间',
   create_user_id       bigint comment '创建人id',
   create_user          varchar(30) comment '创建人',
   update_user_id       bigint comment '更新人id',
   update_user          varchar(30) comment '更新人',
   yn                   tinyint default 1 comment '是否有效:1有效;0:无效',
   primary key (id)
);

alter table service_audit comment '对于审核异常结果增加审核结点';

