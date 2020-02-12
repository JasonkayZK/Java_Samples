CREATE TABLE `t_user`
(
    `id`              BIGINT(10)  NOT NULL AUTO_INCREMENT,
    `username`        VARCHAR(35) NOT NULL UNIQUE,
    `password`        VARCHAR(35) NOT NULL,
    `secret`          VARCHAR(50) NOT NULL COMMENT '密码加密秘钥',
    `create_time`     DATETIME    NOT NULL COMMENT '创建时间',
    `last_login_time` DATETIME DEFAULT NULL,

    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB,
  CHARSET = UTF8;

CREATE TABLE `t_domain`
(
    `id`          BIGINT(10)   NOT NULL AUTO_INCREMENT,
    `domain`      VARCHAR(255) NOT NULL COMMENT 'SSO域名',
    `description` VARCHAR(255) DEFAULT NULL COMMENT '域名所在系统信息描述',
    `remark`      VARCHAR(255) DEFAULT NULL COMMENT '备注',

    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB,
  CHARSET = UTF8;

INSERT INTO t_domain (domain, description)
VALUES ('a.com', 'a.com的域名记录');

INSERT INTO t_domain (domain, description)
VALUES ('b.com', 'b.com的域名记录');