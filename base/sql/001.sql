drop table if exists t_province;
drop table if exists t_city;
drop table if exists t_region;

create table if not exists t_province (
	code char(6) primary key,
	name varchar(255)
);
create table if not exists t_city (
	code char(6) primary key,
	name varchar(255),
	zip_code char(6),
	phone_code char(6),
	province_code char(6)
);
create table if not exists t_region (
	code char(6) primary key,
	name varchar(255),
	zip_code char(6),
	--phone_code char(6),
	city_code char(6)
);
create index idx_province_code on t_city(province_code);
create index idx_city_code on t_region(city_code);

comment on table t_province is '省份表';
comment on column t_province.code is '编码';
comment on column t_province.name is '名称';

comment on table t_city is '城市表';
comment on column t_city.code is '编码';
comment on column t_city.name is '名称';
comment on column t_city.zip_code is '邮政编码';
comment on column t_city.phone_code is '电话区号';
comment on column t_city.province_code is '隶属省份编码';

comment on table t_region is '地区表';
comment on column t_region.code is '编码';
comment on column t_region.name is '名称';
comment on column t_region.zip_code is '邮政编码';
comment on column t_region.city_code is '隶属城市编码';


insert into t_province (code,name) values('110000','北京市');
insert into t_city (code,name,zip_code,phone_code,province_code) values('110100','市辖区','100000','010','110000'),
('110200','县','100000','010','110000');
insert into t_region (code,name,zip_code,city_code) values('110101','东城区','100000','110100'),
('110102','西城区','100000','110100'),('110105','朝阳区','100000','110100'),('110106','丰台区','100000','110100'),
('110107','石景山区','100000','110100'),('110108','海淀区','100000','110100'),('110109','门头沟区','100000','110100'),
('110111','房山区','100000','110100'),('110112','通州区','100000','110100'),('110113','顺义区','100000','110100'),
('110114','昌平区','100000','110100'),('110115','大兴区','100000','110100'),('110116','怀柔区','100000','110100'),
('110117','平谷区','100000','110100'),('110228','密云县','100000','110200'),('110229','延庆县','100000','110200');




