create table `test`
(
    `id`       bigint auto_increment not null comment 'id',
    `name`     varchar(50) comment '名称',
    `password` varchar(50) comment '密码',
    primary key (`id`)
)engine = innodb default charset = utf8mb4 comment '测试';