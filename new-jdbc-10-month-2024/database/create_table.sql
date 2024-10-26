use newjava09month2024;

create table role(
	id bigint not null primary key auto_increment,
    name varchar(150) not null,
    code varchar(150) not null,
    createddate timestamp null,
    modifieddate timestamp null,
	createdby varchar(150) null,
    modifiedby varchar(150) null
);

create table user(
	id bigint not null primary key auto_increment,
	roleid bigint not null,
    username varchar(150) not null,
    password varchar(150) not null,
    fullname varchar(150) not null,
    status int not null,	
    createddate timestamp null,
    modifieddate timestamp null,
	createdby varchar(150) null,
    modifiedby varchar(150) null
);

alter table user add constraint fk_user_role foreign key (roleid) references role(id);

create table news (
    id bigint not null primary key auto_increment,
    title varchar(150) null,
    thumbnail varchar(150) null,
    shortdescription text null,
    content text null,
    createddate timestamp null,
    modifieddate timestamp null,
    createdby varchar(150) null,
    modifiedby varchar(150) null,
    categoryid bigint not null
);

create table category (
    id bigint not null primary key auto_increment,
    name varchar(255) not null,
    code varchar(255) not null,
    createddate timestamp null,
    modifieddate timestamp null,
    createdby varchar(150) null,
    modifiedby varchar(150) null
);

alter table news add constraint fk_news_category foreign key (categoryid) references category(id);


create table comment (
    id bigint not null primary key auto_increment,
    content text not null,
	user_id bigint not null,
    new_id bigint not null,
    createddate timestamp null,
    modifieddate timestamp null,
    createdby varchar(150) null,
    modifiedby varchar(150) null
);

alter table comment add constraint fk_comment_user foreign key (user_id) references user(id);
alter table comment add constraint fk_comment_news foreign key (new_id) references news(id);
