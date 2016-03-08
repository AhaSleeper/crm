/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2016/3/9 0:43:15                             */
/*==============================================================*/


drop table if exists t_contact;

drop table if exists t_contact_history;

drop table if exists t_customer;

drop table if exists t_customer_dev_plan;

drop table if exists t_customer_loss;

drop table if exists t_data_dictionary;

drop table if exists t_menu;

drop table if exists t_organization;

drop table if exists t_role;

drop table if exists t_role_prilivage;

drop table if exists t_sales_opptunity;

drop table if exists t_services;

drop table if exists t_user;

drop table if exists t_user_organization;

drop table if exists t_user_role;

/*==============================================================*/
/* Table: t_contact                                             */
/*==============================================================*/
create table t_contact
(
   CONTACT_ID           varchar(32) not null,
   CUSTOMER_ID          varchar(32),
   NAME                 varchar(32),
   NICK_NAME            varchar(64),
   GENDER               integer,
   BIRTHDAY             date,
   CODE                 varchar(32),
   DEPARTMENT           varchar(64),
   JOB                  varchar(32),
   IS_DEFAULT_CONTACT   boolean,
   OFFICE_PHONE_NO      varchar(16),
   HOUSE_PHONE_NO       integer(16),
   MOBILE_PHONE         varchar(16),
   EMAIL                varchar(64),
   ADDRESS              varchar(100),
   POSTCODE             varchar(16),
   QQ                   varchar(16),
   MSN                  varchar(16),
   REMARK               varchar(100),
   primary key (CONTACT_ID)
);

/*==============================================================*/
/* Table: t_contact_history                                     */
/*==============================================================*/
create table t_contact_history
(
   CONTACT_HIST_ID      varchar(32) not null,
   CUSTOMER_ID          varchar(32),
   CONTACT_CONTENT      varchar(600),
   CONTACT_CUSTOMER     varchar(32),
   CONTACT_PERSON       varchar(32),
   CONTACT_TYPE         integer(0),
   CONTACT_WAY          varchar(32),
   OUR_PERSON           varchar(32),
   NOTE_DATE            date,
   NOTE_BY              varchar(32),
   primary key (CONTACT_HIST_ID)
);

/*==============================================================*/
/* Table: t_customer                                            */
/*==============================================================*/
create table t_customer
(
   CUSTOMER_ID          varchar(32) not null,
   CUSTOMER_CODE        varchar(64),
   CUSTOMER_NAME        varchar(100),
   LEGAL_REPRESENTATIVE varchar(32),
   ADDRESS              varchar(100),
   POST_CODE            varchar(32),
   PHONE_ONE            varchar(16),
   PHONE_TWO            varchar(16),
   FAX                  varchar(32),
   EMAIL                varchar(32),
   WEB_SITE             varchar(100),
   REGISTER_DATE        date,
   NEXT_CONTACT_TIME    timestamp,
   TRACKING_CURVE       integer,
   BELONG_TO            varchar(32),
   RANK                 varchar(32),
   SOURCE               varchar(64),
   TYPE                 varchar(32),
   STATE                integer,
   PROPERTIES           integer,
   AREA                 varchar(32),
   BANK                 varchar(0),
   BANK_ACCOUNT         varchar(16),
   TAX_NO               varchar(32),
   CREDIT               integer,
   INTEGRAL             integer,
   REMARK               varchar(100),
   primary key (CUSTOMER_ID)
);

/*==============================================================*/
/* Table: t_customer_dev_plan                                   */
/*==============================================================*/
create table t_customer_dev_plan
(
   CUSTOMER_DEV_PLAN_ID varchar(32) not null,
   SALE_OPP_ID          varchar(32),
   PLAN_ITEM            varchar(300),
   PLAN_DATE            timestamp,
   EXEC_RESULT          varchar(200),
   primary key (CUSTOMER_DEV_PLAN_ID)
);

/*==============================================================*/
/* Table: t_customer_loss                                       */
/*==============================================================*/
create table t_customer_loss
(
   CUSTOMER_LOSS_ID     varchar(32) not null,
   USER_ID              varchar(32),
   CUSTOMER_ID          varchar(32),
   DATE_LAST_ORDER      timestamp,
   CONFIRM_LOSS_DATE    timestamp,
   STATE                integer,
   SLOW_LOSS_ACTION     varchar(1000),
   LOSS_REASON          varchar(300),
   primary key (CUSTOMER_LOSS_ID)
);

/*==============================================================*/
/* Table: t_data_dictionary                                     */
/*==============================================================*/
create table t_data_dictionary
(
   DATA_DICTIONARY_ID   varchar(32) not null,
   CODE                 integer,
   TYPE                 varchar(64),
   ITEM                 varchar(32),
   VALUE                varchar(32),
   IS_EDITABLE          boolean,
   primary key (DATA_DICTIONARY_ID)
);

/*==============================================================*/
/* Table: t_menu                                                */
/*==============================================================*/
create table t_menu
(
   MENU_ID              varchar(32) not null,
   PID                  varchar(32),
   MENU_NAME            varchar(64),
   MENU_URL             varchar(100),
   MENU_TYPE            integer,
   MENU_ICON            varchar(32),
   SEQ                  integer,
   primary key (MENU_ID)
);

/*==============================================================*/
/* Table: t_organization                                        */
/*==============================================================*/
create table t_organization
(
   ORGANIZATION_ID      varbinary(32) not null,
   ORGANIZATION_NAME    varchar(64),
   ORGANIZATION_NUM     varchar(64),
   ORGANIZATION_DESC    varchar(100),
   primary key (ORGANIZATION_ID)
);

/*==============================================================*/
/* Table: t_role                                                */
/*==============================================================*/
create table t_role
(
   ROLE_ID              varchar(32) not null,
   ROLE_NAME            varchar(64),
   ROLE_DESC            varchar(100),
   primary key (ROLE_ID)
);

/*==============================================================*/
/* Table: t_role_prilivage                                      */
/*==============================================================*/
create table t_role_prilivage
(
   PRIV__ROLE_ID        varchar(32) not null,
   ROLE_ID              varchar(32),
   PRIV_ID              varchar(32),
   primary key (PRIV__ROLE_ID)
);

/*==============================================================*/
/* Table: t_sales_opptunity                                     */
/*==============================================================*/
create table t_sales_opptunity
(
   SALE_OPP_ID          varchar(32) not null,
   CODE                 varchar(16),
   OPP_FROM             varchar(64),
   CUSTOMER_NAME        varchar(64),
   SUCCESS_RATE         double precision(4,2),
   BRIEF                varchar(100),
   CONTACT              varchar(16),
   CONTACT_PHONE        varchar(16),
   OPP_DESC             varchar(300),
   CREATE_BY            varchar(32),
   CREATE_TIME          timestamp,
   ASSIGN_TO            varchar(32),
   ASSIGN_DATE          timestamp,
   STATE                integer comment '0开发失败，1开成功，2开发中',
   primary key (SALE_OPP_ID)
);

/*==============================================================*/
/* Table: t_services                                            */
/*==============================================================*/
create table t_services
(
   SERVICE_ID           varchar(32) not null,
   CODE                 integer,
   SERVICE_TYPE         varchar(32),
   BRIEF                varchar(300),
   STATE                integer comment '0未分配，1已分配，2已归档',
   CUSTOMER             varchar(64),
   SERVICE_REQUIREMENT  varchar(300),
   CREATE_BY            varchar(32),
   CREATE_DATE          timestamp,
   ASSIGN_TO            varchar(32),
   ASSIGN_DATE          timestamp,
   SERVICE_HANDLING     varchar(100),
   HANDLE_BY            varchar(32),
   HANDLE_DATE          timestamp,
   HANDLE_RESULT        varchar(100),
   SATISFY_RATE         varchar(32),
   primary key (SERVICE_ID)
);

/*==============================================================*/
/* Table: t_user                                                */
/*==============================================================*/
create table t_user
(
   USER_ID              varchar(32) not null,
   USER_NAME            varchar(64),
   PASSWORD             varchar(21),
   primary key (USER_ID)
);

/*==============================================================*/
/* Table: t_user_organization                                   */
/*==============================================================*/
create table t_user_organization
(
   USER_ORG_ID          varchar(32) not null,
   ORGANIZTION_ID       varbinary(32),
   USER_ID              varchar(32),
   primary key (USER_ORG_ID)
);

/*==============================================================*/
/* Table: t_user_role                                           */
/*==============================================================*/
create table t_user_role
(
   USER_ROLE_ID         varchar(32) not null,
   USER_ID              varchar(32),
   ROLE_ID              varchar(32),
   primary key (USER_ROLE_ID)
);

alter table t_contact add constraint FK_Reference_1 foreign key (CUSTOMER_ID)
      references t_customer (CUSTOMER_ID) on delete restrict on update restrict;

alter table t_contact_history add constraint FK_Reference_2 foreign key (CUSTOMER_ID)
      references t_customer (CUSTOMER_ID) on delete restrict on update restrict;

alter table t_customer add constraint FK_Reference_15 foreign key (BELONG_TO)
      references t_user (USER_ID) on delete restrict on update restrict;

alter table t_customer_dev_plan add constraint FK_Reference_13 foreign key (SALE_OPP_ID)
      references t_sales_opptunity (SALE_OPP_ID) on delete restrict on update restrict;

alter table t_customer_loss add constraint FK_Reference_11 foreign key (USER_ID)
      references t_user (USER_ID) on delete restrict on update restrict;

alter table t_customer_loss add constraint FK_Reference_12 foreign key (CUSTOMER_ID)
      references t_customer (CUSTOMER_ID) on delete restrict on update restrict;

alter table t_role_prilivage add constraint FK_Reference_16 foreign key (PRIV_ID)
      references t_menu (MENU_ID) on delete restrict on update restrict;

alter table t_role_prilivage add constraint FK_Reference_4 foreign key (ROLE_ID)
      references t_role (ROLE_ID) on delete restrict on update restrict;

alter table t_sales_opptunity add constraint FK_Reference_14 foreign key (ASSIGN_TO)
      references t_user (USER_ID) on delete restrict on update restrict;

alter table t_services add constraint FK_Reference_17 foreign key (ASSIGN_TO)
      references t_user (USER_ID) on delete restrict on update restrict;

alter table t_user_organization add constraint FK_Reference_5 foreign key (ORGANIZTION_ID)
      references t_organization (ORGANIZATION_ID) on delete restrict on update restrict;

alter table t_user_organization add constraint FK_Reference_6 foreign key (USER_ID)
      references t_user (USER_ID) on delete restrict on update restrict;

alter table t_user_role add constraint FK_Reference_1 foreign key (USER_ID)
      references t_user (USER_ID) on delete restrict on update restrict;

alter table t_user_role add constraint FK_Reference_2 foreign key (ROLE_ID)
      references t_role (ROLE_ID) on delete restrict on update restrict;

