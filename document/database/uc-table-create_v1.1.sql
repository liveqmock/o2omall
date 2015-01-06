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
   id                   BIGINT NOT NULL AUTO_INCREMENT COMMENT '����ID',
   parent_code          VARCHAR(30) COMMENT '�����',
   CODE                 VARCHAR(30) COMMENT '���',
   NAME                 VARCHAR(30) COMMENT '����',
   LEVEL                TINYINT(4) COMMENT '����',
   create_user          VARCHAR(30) COMMENT '������',
   create_time          TIMESTAMP COMMENT '����ʱ��',
   update_user          VARCHAR(30) COMMENT '�޸���',
   update_time          TIMESTAMP COMMENT '�޸�ʱ��',
   yn                   TINYINT(4) COMMENT '�Ƿ���Ч: 1-��Ч, 0-��Ч',
   PRIMARY KEY (id)
);

ALTER TABLE AREA COMMENT '������ַ��';

/*==============================================================*/
/* Table: user_account                                          */
/*==============================================================*/
CREATE TABLE user_account
(
   id                   BIGINT NOT NULL AUTO_INCREMENT COMMENT 'id����',
   username             VARCHAR(20) COMMENT '�˺�',
   PASSWORD             VARCHAR(50) COMMENT '����',
   login_times          INT(11) COMMENT '��¼����',
   last_login_ip        VARCHAR(15) COMMENT '�û��ϴε�¼IP',
   last_login_time      TIMESTAMP COMMENT '�û��ϴε�¼ʱ��',
   create_user          VARCHAR(30) COMMENT '������',
   update_user          VARCHAR(30) COMMENT '�޸���',
   create_time          TIMESTAMP COMMENT '����ʱ��',
   update_time          TIMESTAMP COMMENT '�޸�ʱ��',
   yn                   TINYINT(4) COMMENT '�Ƿ���Ч: 1-��Ч, 0-��Ч',
   PRIMARY KEY (id)
);

ALTER TABLE user_account COMMENT '�û��˺ű�';

/*==============================================================*/
/* Table: user_address                                          */
/*==============================================================*/
CREATE TABLE user_address
(
   id                   BIGINT NOT NULL AUTO_INCREMENT COMMENT '����Id',
   user_id              BIGINT COMMENT '�û�ID',
   NAME                 VARCHAR(50) COMMENT '�ջ�������',
   province_name        VARCHAR(30) COMMENT 'ʡ������',
   province_no          VARCHAR(30) COMMENT 'ʡ�ݱ���',
   city_name            VARCHAR(30) COMMENT '������',
   city_no              VARCHAR(30) COMMENT '�б��',
   county_name          VARCHAR(30) COMMENT '������',
   county_no            VARCHAR(30) COMMENT '�ر���',
   address              VARCHAR(500) COMMENT '��ϸ��ַ',
   mobile               VARCHAR(20) COMMENT '�ƶ��绰',
   phone                VARCHAR(30) COMMENT '�̶��绰',
   email                VARCHAR(30) COMMENT '�����ʼ�',
   isdefault            TINYINT DEFAULT 0 COMMENT 'Ĭ�ϵ�ַ:1:Ĭ��;0:��Ĭ��',
   zipcode              VARCHAR(10) COMMENT '�ʱ�',
   is_default           TINYINT(4) COMMENT '1:Ĭ��;0��Ĭ��',
   create_user          VARCHAR(30) COMMENT '������',
   update_user          VARCHAR(30) COMMENT '�޸���',
   create_time          TIMESTAMP COMMENT '����ʱ��',
   update_time          TIMESTAMP COMMENT '�޸�ʱ��',
   yn                   TINYINT(4) COMMENT '�Ƿ���Ч: 1-��Ч, 0-��Ч',
   PRIMARY KEY (id)
);

ALTER TABLE user_address COMMENT '�ջ���ַ��';

/*==============================================================*/
/* Table: user_profile                                          */
/*==============================================================*/
CREATE TABLE user_profile
(
   id                   BIGINT NOT NULL AUTO_INCREMENT COMMENT 'id����',
   user_id              BIGINT COMMENT '�û�ID',
   cn_name              VARCHAR(20) COMMENT '����',
   sex                  TINYINT(4) COMMENT '�Ա�',
   nickname             VARCHAR(50) COMMENT '�ǳ�',
   email                VARCHAR(50) COMMENT '����',
   email_validated      TINYINT(4) COMMENT '0Ϊδ��֤;1Ϊ���ڸ�������;2Ϊ����֤',
   birthday             DATETIME COMMENT '����',
   constellation        VARCHAR(20) COMMENT '����',
   user_photo           VARCHAR(100) COMMENT '�û�ͷ��',
   description          VARCHAR(200) COMMENT '���ҽ���',
   province_name        VARCHAR(30) COMMENT '����-ʡ��-����',
   province_no          VARCHAR(30) COMMENT '����-ʡ��-���',
   city_name            VARCHAR(30) COMMENT '����-��-����',
   city_no              VARCHAR(30) COMMENT '����-��-���',
   county_name          VARCHAR(30) COMMENT '����-��-����',
   county_no            VARCHAR(30) COMMENT '����-��-���',
   address              VARCHAR(500) COMMENT '��ϵ��ַ',
   mobile               VARCHAR(20) COMMENT '�ƶ��绰',
   phone                VARCHAR(20) COMMENT '�̶��绰',
   safe_question        VARCHAR(50) COMMENT '��ȫ����',
   safe_answer          VARCHAR(50) COMMENT '��ȫ�����',
   qq                   VARCHAR(20) COMMENT 'QQ',
   grade                INT(11) COMMENT '��Ա�ȼ�',
   pay_password         VARCHAR(50) COMMENT '֧������',
   score                INT(11) COMMENT '�ҵ�ʣ�����',
   create_time          TIMESTAMP COMMENT '����ʱ��',
   update_time          TIMESTAMP COMMENT '�޸�ʱ��',
   create_user          VARCHAR(30) COMMENT '������',
   update_user          VARCHAR(30) COMMENT '�޸���',
   yn                   TINYINT(4) COMMENT '�Ƿ���Ч: 1-��Ч, 0-��Ч',
   PRIMARY KEY (id)
);

ALTER TABLE user_profile COMMENT '�û�������Ϣ��';

