create table `test`
(
    `id`       bigint auto_increment not null comment 'id',
    `name`     varchar(50) comment '名称',
    `password` varchar(50) comment '密码',
    primary key (`id`)
)engine = innodb default charset = utf8mb4 comment '测试';


insert into `test` (`id`,`name`, `password`) values ('1','admin', '123456');

create table `demo`(
                       `id` bigint auto_increment not null comment 'id',
                       `name` varchar(50) not null comment '名称',
                       primary key (`id`)
) engine = innodb default charset = utf8mb4 comment = '测试';