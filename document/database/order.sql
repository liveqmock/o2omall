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
   id                   bigint not null auto_increment comment '自增id',
   order_no             varchar(30) comment '订单号',
   voucher_no           varchar(30) comment '券号',
   type                 tinyint(4) comment '类型',
   status               tinyint comment '10:初始状态;20:使用;30:不使用',
   effective_time       timestamp comment '有效期',
   dead_line            timestamp comment '截止日期',
   generate_time        timestamp comment '生成时间',
   create_user          varchar(30) comment '创建人',
   create_time          timestamp comment '创建时间',
   update_user          varchar(30) comment '修改人',
   update_time          timestamp comment '修改时间',
   yn                   tinyint(4) comment '0:无效;1:有效',
   primary key (id)
);

alter table e_coupon comment '电子券表';

/*==============================================================*/
/* Table: order_cancel                                          */
/*==============================================================*/
create table order_cancel
(
   id                   bigint not null auto_increment comment '自增id',
   refund               varchar(30) comment '退款单号',
   status               tinyint comment '501:待审核;502:退款中;503:已退款;503:审核驳回;504:退款失败;',
   order_no             varchar(30) comment '订单编号',
   refund_amount        decimal(10,2) comment '退款金额',
   cancel_reason        varchar(30) comment '取消原因',
   cancel_type          tinyint(4) comment '取消类型',
   current_audit_name   varchar(30) comment '审核人姓名',
   current_audit_no     varchar(30) comment '审核人编号',
   is_auditing          bigint(4) comment '0：不通过；1：通过',
   auditing_time        timestamp comment '审核时间',
   finish_time          timestamp comment '退款完成时间',
   remark               varchar(100) comment '审核意见',
   is_refund            tinyint(4) comment '0:不需要;1需要',
   create_user          varchar(30) comment '创建人姓名',
   update_user          varchar(30) comment '修改人姓名',
   create_time          timestamp comment '创建时间',
   update_time          timestamp comment '修改时间',
   yn                   tinyint(4) comment '1:有效;0:无效',
   primary key (id)
);

alter table order_cancel comment '订单取消表';

/*==============================================================*/
/* Table: order_log                                             */
/*==============================================================*/
create table order_log
(
   id                   bigint not null auto_increment comment '自增id',
   order_no             varchar(30) comment '订单编号',
   status               tinyint(4) comment '订单状态',
   status_name          varchar(30) comment '状态名称',
   description          varchar(50) comment '订单描述',
   log_type             tinyint(4) comment '100:前台显示;200后台显示',
   create_time          timestamp comment '创建时间',
   create_user          varchar(50) comment '创建人',
   update_time          timestamp comment '修改时间',
   update_user          varchar(50) comment '修改人',
   yn                   tinyint(4) comment '是否有效',
   primary key (id)
);

alter table order_log comment '订单日志表';

/*==============================================================*/
/* Table: orders                                                */
/*==============================================================*/
create table orders
(
   id                   bigint not null auto_increment comment '自增id',
   order_no             varchar(30) comment '订单编号',
   order_type           tinyint(4) comment '100:事物订单;200:虚拟订单',
   user_id              bigint not null comment '用户ID',
   user_name            varchar(30) comment '下单用户账号',
   order_name           varchar(30) comment '下单姓名',
   consignee_name       varchar(30) comment '收货人姓名',
   consignee_phone      varchar(50) comment '收货人手机号',
   telephone            varchar(30) comment '固定电话',
   emil                 varchar(30) comment '邮箱',
   zip_code             varchar(30) comment '邮编',
   pay_name             varchar(30) comment '支付名称',
   order_date           tinyint(4) comment '1-只工作日送货(双休日、假日不用送)
            2-工作日、双休日与假日均可送货
            3-只双休日、假日送货(工作日不用送)
            ',
   is_tal_sure          tinyint(4) comment '0-否;1-确定',
   pay_way              tinyint(4) comment '1-现金;2-Pos刷卡',
   pay_type             tinyint(4) comment '1-货到付款;2-在线支付;3-公司转账;4-邮件汇款',
   is_invoice           tinyint(4) comment '0:不要;1:要',
   invoice_type         tinyint(4) comment '1-普通发票;2-增值税发票',
   invoice_title        tinyint(4) comment '1-个人;2-单位',
   invoice_content      tinyint(4) comment '1-明细;2-办公用品;3-电脑配件;4-耗材；',
   order_status         tinyint(4) comment '10-用户取消;20-用户删除;30-系统取消;40-待付款;50-已收款;60-已发货;70-已签收;80-订单完成;90-待拆单;100-拆单完成;110-订单审核;120-待退货;130-已退货;140-待换货;150-已换货;160-已退款;
            ',
   comm_amount          decimal(10,2) comment '总商品金额',
   ret_cash             decimal(10,2) comment '返现',
   expenses             decimal(10,2) comment '运费',
   amount_pay           decimal(10,2) comment '应付总额',
   parent_order_no      varchar(50) comment '父订单编号',
   province_name        varchar(30) comment '省份名称',
   province_no          varchar(30) comment '省份编号',
   city_name            varchar(30) comment '市名称',
   city_no              varchar(30) comment '市编号',
   county_name          varchar(30) comment '县名称',
   county_no            varchar(30) comment '县编码',
   address              varchar(100) comment '送货地址',
   pay_time             timestamp comment '支付时间',
   Integral             int(11) comment '积分',
   remark               varchar(100) comment '订单备注',
   create_time          timestamp comment '创建时间',
   update_time          timestamp comment '修改时间',
   create_user          varchar(50) comment '创建人',
   update_user          varchar(50) comment '修改人',
   yn                   tinyint(4) comment '0:无效;1有效',
   primary key (id)
);

alter table orders comment '订单表';

/*==============================================================*/
/* Table: orders_items                                          */
/*==============================================================*/
create table orders_items
(
   id                   bigint not null auto_increment comment '主键自增id',
   order_no             varchar(30) comment '订单编号',
   sku_no               varchar(30) comment 'sku编号',
   product_no           varchar(30) comment '商品编号',
   count                int comment '商品个数',
   sku_name             varchar(100) comment 'sku名称',
   img_url              varchar(100) comment '商品主图',
   discount             decimal(10,2) comment '商品优惠价',
   sku_price            decimal(10,2) comment '商品单价',
   final_price          decimal(10,2) comment '优惠后价格',
   create_user          varchar(50) comment '创建人',
   update_user          varchar(50) comment '修改人',
   create_time          timestamp comment '创建时间',
   update_time          timestamp comment '修改时间',
   yn                   tinyint(4) comment '0-无效;1-有效',
   primary key (id)
);

alter table orders_items comment '订单明细表';

/*==============================================================*/
/* Table: shopping_cart                                         */
/*==============================================================*/
create table shopping_cart
(
   id                   bigint not null auto_increment comment '自增id',
   user_no              varchar(50) comment '用户编号',
   sku_no               varchar(50) comment '商品编号',
   sku_count            tinyint(4) comment '商品数量',
   status               tinyint(4) comment '1:正常状态;2-删除;3-已下单',
   create_time          timestamp comment '创建时间',
   update_time          timestamp comment '更新时间',
   create_user          varchar(50) comment '创建人',
   update_user          varchar(50) comment '修改人',
   yn                   tinyint(4) comment '0:无效;1:有效',
   primary key (id)
);

alter table shopping_cart comment '购物车表';

