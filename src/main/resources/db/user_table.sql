DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
    `user_id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '用户编号',
    `user_name` VARCHAR(50) NOT NULL DEFAULT '' COMMENT '用户姓名',
    `user_password` VARCHAR(255) NOT NULL DEFAULT '' COMMENT '用户密码',
    `create_time` BIGINT UNSIGNED NOT NULL DEFAULT 0 COMMENT '创建时间',
    `update_time` BIGINT UNSIGNED NOT NULL DEFAULT 0 COMMENT '修改时间',
    PRIMARY KEY `pk_user_id` (`user_id`)
) ENGINE = INNODB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '用户表'