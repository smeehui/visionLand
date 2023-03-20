create table vision_land.user
(
    id         int auto_increment
        primary key,
    created_at datetime(6)          null,
    created_by bigint               null,
    deleted    tinyint(1) default 0 null,
    updated_at datetime(6)          null,
    updated_by bigint               null,
    email      varchar(255)         null,
    full_name  varchar(255)         null,
    phone      varchar(255)         null,
    user_role  int                  not null,
    constraint FK9i2me7h8o3hgco150rkrgtw0h
        foreign key (user_role) references vision_land.user_role (id)
);

