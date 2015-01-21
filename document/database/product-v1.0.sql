/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2015/1/21 10:39:28                           */
/*==============================================================*/


drop table if exists business_audit;

drop table if exists business_info;

drop table if exists product;

drop table if exists product_brand;

drop table if exists product_category;

drop table if exists product_dict;

drop table if exists product_select;

drop table if exists product_sku;

drop table if exists product_tax_rate;

drop table if exists sku_images;

/*==============================================================*/
/* Table: business_audit                                        */
/*==============================================================*/
create table business_audit
(
   id                   bigint not null auto_increment comment '主键',
   business_no          varchar(30) comment '商家编号',
   business_name        varchar(100) comment '商家名称',
   operator             varchar(30) comment '操作人',
   operate_time         timestamp default NULL comment '操作时间',
   check_result         tinyint comment '审核结果',
   features             varchar(200) comment '审核描述',
   create_time          timestamp default NULL comment '创建时间',
   update_time          timestamp default NULL comment '修改时间',
   create_user          varchar(30) comment '创建人',
   update_user          varchar(30) comment '修改人',
   yn                   tinyint comment '是否有效',
   primary key (id)
);

alter table business_audit comment '审核商家流水表';

/*==============================================================*/
/* Table: business_info                                         */
/*==============================================================*/
create table business_info
(
   id                   bigint not null auto_increment comment '主键',
   business_no          varchar(30) comment '商家编号',
   business_name        varchar(100) comment '商家名称',
   en_name              varchar(100) comment '商家英文名称',
   business_abbr        varchar(30) comment '名称缩写',
   type                 tinyint comment '类型（国内、进口）',
   type_name            varchar(20) comment '类型名称',
   category_one_id      bigint comment '一级分类',
   category_one         varchar(50) comment '一级分类名称',
   category_two_id      bigint comment '二级分类',
   category_two         varchar(50) comment '二级分类名称',
   category_three_id    bigint comment '三级分类',
   category_three       varchar(50) comment '三级分类名称',
   province_name        varchar(30) comment '地区-省份-名称',
   province_no          varchar(30) comment '地区-省份-编号',
   city_name            varchar(30) comment '地区-市-名称',
   city_no              varchar(30) comment '地区-市-编号',
   county_name          varchar(30) comment '地区-县-名称',
   county_no            varchar(30) comment '地区-县-编号',
   contactor            varchar(30) comment '联系人',
   mobile_phone         varchar(20) comment '手机',
   tele_phone           varchar(20) comment '联系人电话',
   address              varchar(100) comment '地址',
   post_code            varchar(20) comment '邮编',
   features             varchar(2000) comment '描述',
   remark               varchar(2000) comment '备注',
   check_status         tinyint comment '审核状态',
   enter_time           timestamp default NULL comment '入驻时间',
   contract_time_start  timestamp default NULL comment '有效合同开始时间',
   contract_time_end    timestamp default NULL comment '有效合同结束时间',
   level                tinyint comment '商家级别',
   has_card             tinyint comment '是否有证件',
   legal_person         varchar(100) comment '法定人身份证（图片地址）',
   company_register     varchar(100) comment '公司注册信息（扫描件）',
   earnest_money        double comment '保证金',
   credit_level         tinyint comment '信用等级',
   credit_limit         double comment '信用额度',
   priority             tinyint comment '优先级',
   create_time          timestamp default NULL comment '创建时间',
   update_time          timestamp default NULL comment '修改时间',
   create_user          varchar(30) comment '创建人',
   update_user          varchar(30) comment '修改人',
   yn                   tinyint comment '是否有效',
   primary key (id)
);

alter table business_info comment '商家信息';

/*==============================================================*/
/* Table: product                                               */
/*==============================================================*/
create table product
(
   id                   bigint not null auto_increment comment '主键',
   product_no           varchar(30) comment '商品编号',
   product_name         varchar(100) comment '商品名称',
   en_name              varchar(50) comment '商品英文名称',
   keyword              varchar(200) comment '关键字',
   category_one_id      bigint comment '一级分类',
   category_one         varchar(50) comment '一级分类名称',
   category_two_id      bigint comment '二级分类',
   category_two         varchar(50) comment '二级分类名称',
   category_three_id    bigint comment '三级分类',
   category_three       varchar(50) comment '三级分类名称',
   sku_attr_name        varchar(30) comment '商品SKU属性值',
   score                varchar(20) comment '商品评分',
   level                tinyint comment '推荐级别',
   brand_code           varchar(50) comment '品牌编号',
   brand_name           varchar(100) comment '品牌名称',
   type                 tinyint comment '商品类型（国内、进口）',
   type_name            varchar(20) comment '商品类型名称',
   mode                 tinyint comment '经营模式（自营。。）',
   mode_name            varchar(20) comment '经营模式名称',
   business_no          varchar(30) comment '商家编号',
   business_name        varchar(100) comment '商家名称',
   method               bigint comment '食用方式（枚举）',
   origin_place         varchar(30) comment '商品产地',
   sale_time_start      timestamp default NULL comment '商品上架时间',
   applicable_crowd     varchar(30) comment '适用人群（配置表）',
   applicable_age       varchar(30) comment '适用年龄（配置表）',
   applicable_step      tinyint comment '适用阶段',
   features             text comment '商品描述',
   introduce            varchar(2000) comment '介绍',
   service              varchar(50) comment '服务（配送信息等）',
   weight               double comment '商品净重',
   gross_weight         double comment '毛重',
   length               double comment '长',
   width                double comment '宽',
   height               double comment '高',
   diameter             double comment '直径',
   pack_type            tinyint comment '包装类型（桶装等）',
   pack_length          double comment '包装长',
   pack_width           double comment '包装宽',
   pack_height          double comment '包装高',
   support_return       tinyint comment '是否支持退货',
   distribution         varchar(50) comment '配送信息',
   freight_free         tinyint comment '是否免运费',
   freight              double comment '运费',
   material             varchar(50) comment '材质',
   packing_list         varchar(200) comment '包装清单',
   sale_guarantee       varchar(200) comment '售后保障',
   kindly_reminder      varchar(200) comment '温馨提示',
   create_time          timestamp default NULL comment '创建时间',
   update_time          timestamp default NULL comment '修改时间',
   create_user          varchar(30) comment '创建人',
   update_user          varchar(30) comment '修改人',
   yn                   tinyint comment '是否有效',
   primary key (id)
);

alter table product comment '商品信息';

/*==============================================================*/
/* Table: product_brand                                         */
/*==============================================================*/
create table product_brand
(
   id                   bigint not null auto_increment comment '主键',
   category_one_id      bigint comment '一级分类',
   category_one         varchar(50) comment '一级分类名称',
   category_two_id      bigint comment '二级分类',
   category_two         varchar(50) comment '二级分类名称',
   category_three_id    bigint comment '三级分类',
   category_three       varchar(50) comment '三级分类名称',
   brand_code           varchar(50) comment '品牌编号',
   brand_name           varchar(100) comment '品牌名称',
   en_name              varchar(50) comment '品牌英文名称',
   brand_abbr           varchar(30) comment '品牌简称',
   brand_img            varchar(200) comment '品牌图片',
   keyword              varchar(200) comment '关键字',
   type                 tinyint comment '商品类型（国内、进口）',
   type_name            varchar(20) comment '商品类型名称',
   province_name        varchar(30) comment '地区-省份-名称',
   province_no          varchar(30) comment '地区-省份-编号',
   city_name            varchar(30) comment '地区-市-名称',
   city_no              varchar(30) comment '地区-市-编号',
   priority             tinyint comment '优先级',
   create_time          timestamp default NULL comment '创建时间',
   update_time          timestamp default NULL comment '修改时间',
   create_user          varchar(30) comment '创建人',
   update_user          varchar(30) comment '修改人',
   yn                   tinyint comment '是否有效',
   primary key (id)
);

alter table product_brand comment '商品类别品牌';

/*==============================================================*/
/* Table: product_category                                      */
/*==============================================================*/
create table product_category
(
   id                   bigint not null auto_increment comment '主键',
   fid                  bigint comment '父ID',
   name                 varchar(50) comment '类目名称',
   en_name              varchar(50) comment '类目英文名称',
   keyword              varchar(100) comment '关键字',
   features             varchar(2000) comment '描述',
   level                tinyint comment '级别',
   priority             tinyint comment '优先级',
   create_time          timestamp default NULL comment '创建时间',
   update_time          timestamp default NULL comment '修改时间',
   create_user          varchar(30) comment '创建人',
   update_user          varchar(30) comment '修改人',
   yn                   tinyint comment '是否有效',
   primary key (id)
);

alter table product_category comment '商品类别-分类';

/*==============================================================*/
/* Table: product_dict                                          */
/*==============================================================*/
create table product_dict
(
   id                   bigint not null auto_increment comment '主键标识',
   type                 tinyint comment '类型',
   attr                 varchar(32) comment '属性',
   value                varchar(128) comment '值',
   remark               varchar(256) comment '备注',
   create_time          timestamp default NULL comment '创建时间',
   update_time          timestamp default NULL comment '修改时间',
   create_user          varchar(30) comment '创建人',
   update_user          varchar(30) comment '修改人',
   yn                   tinyint comment '是否有效',
   primary key (id)
);

alter table product_dict comment '商品信息配置表';

/*==============================================================*/
/* Table: product_select                                        */
/*==============================================================*/
create table product_select
(
   id                   bigint not null auto_increment comment '主键',
   product_no           varchar(30) comment '商品编号',
   product_name         varchar(100) comment '商品名称',
   sku_no               varchar(30) comment 'sku编号',
   sku_name             varchar(100) comment 'SKU名称',
   category_one_id      bigint comment '一级分类',
   category_two_id      bigint comment '二级分类',
   category_three_id    bigint comment '三级分类',
   applicable_step      tinyint comment '适用阶段',
   brand_code           varchar(50) comment '品牌编号',
   mode                 tinyint comment '经营模式（自营、三方）',
   sale_price           double comment '销售价',
   price                double comment '市场价',
   img_path             varchar(100) comment 'Sku主图',
   sale_quantity_total  bigint comment '总销售量',
   sale_quantity_week   bigint comment '每周销售量',
   recommend_amount     bigint comment '推荐数量（客户）',
   is_recommend         tinyint comment '是否推荐（专家）',
   is_hot               tinyint comment '是否热门',
   hit_count_total      bigint comment '浏览次数',
   sale_status          tinyint comment '上下架状态',
   hit_count_week       bigint comment '每周浏览次数',
   create_time          timestamp default NULL comment '创建时间',
   update_time          timestamp default NULL comment '修改时间',
   create_user          varchar(30) comment '创建人',
   update_user          varchar(30) comment '修改人',
   yn                   tinyint comment '是否有效',
   primary key (id)
);

alter table product_select comment '商品查询综合表';

/*==============================================================*/
/* Table: product_sku                                           */
/*==============================================================*/
create table product_sku
(
   id                   bigint not null auto_increment comment '主键',
   product_no           varchar(30) comment '商品编号',
   sku_no               varchar(30) comment 'sku编号',
   sku_name             varchar(100) comment 'SKU名称',
   color                tinyint comment '颜色',
   color_desc           varchar(100) comment '颜色描述',
   color_order          tinyint comment '颜色顺序',
   size                 varchar(20) comment '尺码',
   size_desc            varchar(100) comment '尺码描述',
   size_order           tinyint comment '尺码顺序',
   product_ad           varchar(100) comment '商品广告词',
   sales_promotion      varchar(500) comment '商品促销信息（赠品，多个可分割保存）',
   durability_period    varchar(20) comment '商品保质期',
   production_date      timestamp default NULL comment '商品生产日期',
   sale_status          tinyint comment '上下架状态',
   sale_time            timestamp default NULL comment '上下架时间',
   img_path             varchar(100) comment 'Sku主图',
   price                double comment '市场价',
   sale_price           double comment '销售价',
   sale_quantity        bigint comment '可售数量',
   discount             double comment '折扣（会员）',
   features             varchar(2000) comment '描述',
   dimension_code_one   varchar(2000) comment '一维码',
   dimension_code_two   varchar(2000) comment '二维码',
   priority             tinyint comment '优先级',
   create_time          timestamp default NULL comment '创建时间',
   update_time          timestamp default NULL comment '修改时间',
   create_user          varchar(30) comment '创建人',
   update_user          varchar(30) comment '修改人',
   yn                   tinyint comment '是否有效',
   primary key (id)
);

alter table product_sku comment '商品SKU';

/*==============================================================*/
/* Table: product_tax_rate                                      */
/*==============================================================*/
create table product_tax_rate
(
   id                   bigint not null auto_increment comment '主键',
   category_one_id      bigint comment '一级分类',
   category_one         varchar(50) comment '一级分类名称',
   category_two_id      bigint comment '二级分类',
   category_two         varchar(50) comment '二级分类名称',
   category_three_id    bigint comment '三级分类',
   category_three       varchar(50) comment '三级分类名称',
   product_id           bigint comment '商品ID',
   product_name         varchar(100) comment '商品名称',
   tax_rate_type        tinyint comment '税率设置类型',
   status               tinyint comment '状态',
   tax_rate             double comment '税率',
   features             varchar(2000) comment '描述',
   priority             tinyint comment '优先级',
   create_time          timestamp default NULL comment '创建时间',
   update_time          timestamp default NULL comment '修改时间',
   create_user          varchar(30) comment '创建人',
   update_user          varchar(30) comment '修改人',
   yn                   tinyint comment '是否有效',
   primary key (id)
);

alter table product_tax_rate comment '税率';

/*==============================================================*/
/* Table: sku_images                                            */
/*==============================================================*/
create table sku_images
(
   id                   bigint not null auto_increment comment '主键',
   sku_no               varchar(30) comment 'sku编号',
   img_type             tinyint comment '图片类型',
   img_path             varchar(200) comment '图片路径',
   is_primary_path      tinyint comment '是否主图',
   features             varchar(2000) comment '描述',
   priority             tinyint comment '优先级',
   create_time          timestamp default NULL comment '创建时间',
   update_time          timestamp default NULL comment '修改时间',
   create_user          varchar(30) comment '创建人',
   update_user          varchar(30) comment '修改人',
   yn                   tinyint comment '是否有效',
   primary key (id)
);

alter table sku_images comment 'sku图片';

