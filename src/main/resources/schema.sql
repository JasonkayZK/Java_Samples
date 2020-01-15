-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user`
(
    `id`       bigint(20)  NOT NULL AUTO_INCREMENT,
    `username` varchar(50) NOT NULL COMMENT '用户名',
    `password` varchar(32) NOT NULL COMMENT '密码，加密存储',
    `phone`    varchar(20) DEFAULT NULL COMMENT '注册手机号',
    `email`    varchar(50) DEFAULT NULL COMMENT '注册邮箱',
    `created`  datetime    NOT NULL,
    `updated`  datetime    NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE KEY `username` (`username`) USING BTREE,
    UNIQUE KEY `phone` (`phone`) USING BTREE,
    UNIQUE KEY `email` (`email`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8 COMMENT ='用户表';

-- ----------------------------
-- Table structure for t_item
-- ----------------------------
DROP TABLE IF EXISTS `t_item`;
CREATE TABLE `t_item`
(
    `id`         bigint(20)   NOT NULL COMMENT '商品id，同时也是商品编号',
    `title`      varchar(100) NOT NULL COMMENT '商品标题',
    `sell_point` varchar(500)          DEFAULT NULL COMMENT '商品卖点',
    `price`      bigint(20)   NOT NULL COMMENT '商品价格，单位为：分',
    `num`        int(10)      NOT NULL COMMENT '库存数量',
    `barcode`    varchar(30)           DEFAULT NULL COMMENT '商品条形码',
    `image`      varchar(500)          DEFAULT NULL COMMENT '商品图片',
    `cid`        bigint(10)   NOT NULL COMMENT '所属类目，叶子类目',
    `status`     tinyint(4)   NOT NULL DEFAULT '1' COMMENT '商品状态，1-正常，2-下架，3-删除',
    `created`    datetime     NOT NULL COMMENT '创建时间',
    `updated`    datetime     NOT NULL COMMENT '更新时间',
    PRIMARY KEY (`id`),
    KEY `cid` (`cid`),
    KEY `status` (`status`),
    KEY `updated` (`updated`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8 COMMENT ='商品表';

-- ----------------------------
-- Table structure for t_item_cat
-- ----------------------------
DROP TABLE IF EXISTS `t_item_cat`;
CREATE TABLE `t_item_cat`
(
    `id`         bigint(20) NOT NULL AUTO_INCREMENT COMMENT '类目ID',
    `parent_id`  bigint(20)  DEFAULT NULL COMMENT '父类目ID=0时，代表的是一级的类目',
    `name`       varchar(50) DEFAULT NULL COMMENT '类目名称',
    `status`     int(1)      DEFAULT '1' COMMENT '状态。可选值:1(正常),2(删除)',
    `sort_order` int(4)      DEFAULT NULL COMMENT '排列序号，表示同级类目的展现次序，如数值相等则按名称次序排列。取值范围:大于零的整数',
    `is_parent`  tinyint(1)  DEFAULT '1' COMMENT '该类目是否为父类目，1为true，0为false',
    `created`    datetime    DEFAULT NULL COMMENT '创建时间',
    `updated`    datetime    DEFAULT NULL COMMENT '创建时间',
    PRIMARY KEY (`id`),
    KEY `parent_id` (`parent_id`, `status`) USING BTREE,
    KEY `sort_order` (`sort_order`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8 COMMENT ='商品类目';

-- ----------------------------
-- Table structure for t_item_desc
-- ----------------------------
DROP TABLE IF EXISTS `t_item_desc`;
CREATE TABLE `t_item_desc`
(
    `item_id`   bigint(20) NOT NULL COMMENT '商品ID',
    `item_desc` text COMMENT '商品描述',
    `created`   datetime DEFAULT NULL COMMENT '创建时间',
    `updated`   datetime DEFAULT NULL COMMENT '更新时间',
    PRIMARY KEY (`item_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8 COMMENT ='商品描述表';
