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

comment on table t_province is 'ʡ�ݱ�';
comment on column t_province.code is '����';
comment on column t_province.name is '����';

comment on table t_city is '���б�';
comment on column t_city.code is '����';
comment on column t_city.name is '����';
comment on column t_city.zip_code is '��������';
comment on column t_city.phone_code is '�绰����';
comment on column t_city.province_code is '����ʡ�ݱ���';

comment on table t_region is '������';
comment on column t_region.code is '����';
comment on column t_region.name is '����';
comment on column t_region.zip_code is '��������';
comment on column t_region.city_code is '�������б���';


insert into t_province (code,name) values('110000','������');
insert into t_city (code,name,zip_code,phone_code,province_code) values('110100','��Ͻ��','100000','010','110000'),
('110200','��','100000','010','110000');
insert into t_region (code,name,zip_code,city_code) values('110101','������','100000','110100'),
('110102','������','100000','110100'),('110105','������','100000','110100'),('110106','��̨��','100000','110100'),
('110107','ʯ��ɽ��','100000','110100'),('110108','������','100000','110100'),('110109','��ͷ����','100000','110100'),
('110111','��ɽ��','100000','110100'),('110112','ͨ����','100000','110100'),('110113','˳����','100000','110100'),
('110114','��ƽ��','100000','110100'),('110115','������','100000','110100'),('110116','������','100000','110100'),
('110117','ƽ����','100000','110100'),('110228','������','100000','110200'),('110229','������','100000','110200');




