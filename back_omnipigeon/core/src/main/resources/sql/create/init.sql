CREATE DEFINER=`pigeonDev`@`%` PROCEDURE `pigeonbdd`.`init`()
begin
/**
 *  SPRING SESSIONS
 */
	drop
		table
			if exists SPRING_SESSION_ATTRIBUTES;

drop
	table
		if exists SPRING_SESSION;

create
	table
		SPRING_SESSION (SESSION_ID char(36) not null,
		CREATION_TIME bigint not null,
		LAST_ACCESS_TIME bigint not null,
		MAX_INACTIVE_INTERVAL int not null,
		PRINCIPAL_NAME varchar(100),
		constraint SPRING_SESSION_PK primary key (SESSION_ID));

create
	index SPRING_SESSION_IX1 on
	SPRING_SESSION (LAST_ACCESS_TIME);

create
	index SPRING_SESSION_IX2 on
	SPRING_SESSION (PRINCIPAL_NAME);

create
	table
		SPRING_SESSION_ATTRIBUTES (SESSION_ID char(36) not null,
		ATTRIBUTE_NAME varchar(200) not null,
		ATTRIBUTE_BYTES blob not null,
		constraint SPRING_SESSION_ATTRIBUTES_PK primary key (SESSION_ID,
		ATTRIBUTE_NAME),
		constraint SPRING_SESSION_ATTRIBUTES_FK foreign key (SESSION_ID) references SPRING_SESSION(SESSION_ID) on
		delete
			cascade);

create
	index SPRING_SESSION_ATTRIBUTES_IX1 on
	SPRING_SESSION_ATTRIBUTES (SESSION_ID);




end