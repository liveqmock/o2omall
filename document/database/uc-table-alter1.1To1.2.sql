use awe_uc;
ALTER TABLE user_address ADD isdefault TINYINT COMMENT '默认地址:1:默认;0:非默认' DEFAULT '0';
