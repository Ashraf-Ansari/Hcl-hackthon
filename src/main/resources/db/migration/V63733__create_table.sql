CREATE TABLE merchant_account (
	balance numeric(38, 2) NULL,
	is_deleted bool NULL DEFAULT false,
	created_on timestamp(6) NULL,
	id bigserial NOT NULL,
	last_updated timestamp(6) NULL,
	updated_on timestamp(6) NULL,
	account_number varchar(255) NULL,
	created_by varchar(255) NULL,
	currency varchar(255) NULL,
	merchant_name varchar(255) NULL,
	merchant_type varchar(255) NULL,
	updated_by varchar(255) NULL,
	CONSTRAINT merchant_account_pkey PRIMARY KEY (id)
);


CREATE TABLE merchant_transaction (
	amount numeric(38, 2) NULL,
	is_deleted bool NULL DEFAULT false,
	merchantid int4 NULL,
	productid int4 NULL,
	userid int4 NULL,
	created_on timestamp(6) NULL,
	id bigserial NOT NULL,
	"timestamp" timestamp(6) NULL,
	updated_on timestamp(6) NULL,
	created_by varchar(255) NULL,
	currency varchar(255) NULL,
	status varchar(255) NULL,
	transaction_description varchar(255) NULL,
	transaction_type varchar(255) NULL,
	transactionid varchar(255) NULL,
	updated_by varchar(255) NULL,
	CONSTRAINT merchant_transaction_pkey PRIMARY KEY (id)
);


CREATE TABLE product (
	age_restriction int4 NOT NULL,
	is_deleted bool NULL DEFAULT false,
	is_harmful bool NOT NULL,
	product_cost numeric(38, 2) NULL,
	created_on timestamp(6) NULL,
	id bigserial NOT NULL,
	updated_on timestamp(6) NULL,
	created_by varchar(255) NULL,
	currency varchar(255) NULL,
	product_name varchar(255) NULL,
	updated_by varchar(255) NULL,
	CONSTRAINT product_pkey PRIMARY KEY (id)
);



CREATE TABLE user_account (
	balance numeric(38, 2) NULL,
	is_deleted bool NULL DEFAULT false,
	user_id int4 NULL,
	created_on timestamp(6) NULL,
	id bigserial NOT NULL,
	last_updated timestamp(6) NULL,
	updated_on timestamp(6) NULL,
	account_number varchar(255) NULL,
	account_type varchar(255) NULL,
	created_by varchar(255) NULL,
	currency varchar(255) NULL,
	updated_by varchar(255) NULL,
	CONSTRAINT user_account_pkey PRIMARY KEY (id)
);



CREATE TABLE user_table (
	age int4 NULL,
	is_deleted bool NULL DEFAULT false,
	created_on timestamp(6) NULL,
	id bigserial NOT NULL,
	updated_on timestamp(6) NULL,
	country varchar(255) NULL,
	created_by varchar(255) NULL,
	email varchar(255) NULL,
	updated_by varchar(255) NULL,
	username varchar(255) NULL,
	CONSTRAINT user_table_pkey PRIMARY KEY (id)
);





CREATE TABLE user_transaction (
	amount numeric(38, 2) NULL,
	is_deleted bool NULL DEFAULT false,
	productid int4 NULL,
	userid int4 NULL,
	created_on timestamp(6) NULL,
	id bigserial NOT NULL,
	"timestamp" timestamp(6) NULL,
	updated_on timestamp(6) NULL,
	created_by varchar(255) NULL,
	currency varchar(255) NULL,
	status varchar(255) NULL,
	transaction_description varchar(255) NULL,
	transaction_type varchar(255) NULL,
	transactionid varchar(255) NULL,
	updated_by varchar(255) NULL,
	CONSTRAINT user_transaction_pkey PRIMARY KEY (id)
);



CREATE TABLE wallet (
	balance numeric(38, 2) NULL,
	is_deleted bool NULL DEFAULT false,
	user_id int4 NULL,
	created_on timestamp(6) NULL,
	id bigserial NOT NULL,
	last_updated timestamp(6) NULL,
	updated_on timestamp(6) NULL,
	created_by varchar(255) NULL,
	updated_by varchar(255) NULL,
	CONSTRAINT wallet_pkey PRIMARY KEY (id)
);