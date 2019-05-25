/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2019/5/25 23:05:48                           */
/*==============================================================*/


drop table if exists ADMINISTRATORS;

drop table if exists CUSTOMERS;

drop table if exists MEDICINES;

drop table if exists ORDERS;

drop table if exists PRODUCT;

drop table if exists SUPPLIERS;

/*==============================================================*/
/* Table: ADMINISTRATORS                                        */
/*==============================================================*/
create table ADMINISTRATORS
(
   A_ID                 int not null auto_increment,
   A_PASSWORD           varchar(20),
   primary key (A_ID)
);

/*==============================================================*/
/* Table: CUSTOMERS                                             */
/*==============================================================*/
create table CUSTOMERS
(
   C_ID                 int not null auto_increment,
   C_PASSWORD           varchar(20),
   C_NAME               varchar(20),
   C_DISCOUNT           float default 1,
   C_PHONE              varchar(11),
   C_CITY               varchar(20),
   primary key (C_ID)
);

/*==============================================================*/
/* Table: MEDICINES                                             */
/*==============================================================*/
create table MEDICINES
(
   M_ID                 int not null auto_increment,
   M_NAME               varchar(20),
   M_TYPE               varchar(20),
   M_PRICE              float,
   M_QUANTITY           int default 1,
   M_PRODUCTION_DATE    varchar(20),
   M_QUALITY_GUARANTEE_PERIOD varchar(10),
   primary key (M_ID)
);

/*==============================================================*/
/* Table: ORDERS                                                */
/*==============================================================*/
create table ORDERS
(
   O_ID                 int not null auto_increment,
   M_ID                 int,
   S_ID                 int,
   C_ID                 int,
   A_ID                 int,
   QTY                  int,
   DOLLARS              float,
   TANSACTION_DATE      date,
   STATE                int default 2,
   primary key (O_ID)
);

/*==============================================================*/
/* Table: PRODUCT                                               */
/*==============================================================*/
create table PRODUCT
(
   M_ID                 int not null,
   S_ID                 int not null,
   primary key (M_ID, S_ID)
);

/*==============================================================*/
/* Table: SUPPLIERS                                             */
/*==============================================================*/
create table SUPPLIERS
(
   S_ID                 int not null auto_increment,
   S_PASSWORD           varchar(20),
   S_NAME               varchar(20),
   S_DISCOUNT           float default 1,
   S_PHONE              varchar(11),
   S_CITY               varchar(20),
   primary key (S_ID)
);

alter table ORDERS add constraint FK_Reference_1 foreign key (M_ID, S_ID)
      references PRODUCT (M_ID, S_ID) on delete restrict on update restrict;

alter table ORDERS add constraint FK_Reference_2 foreign key (C_ID)
      references CUSTOMERS (C_ID) on delete restrict on update restrict;

alter table ORDERS add constraint FK_Reference_3 foreign key (A_ID)
      references ADMINISTRATORS (A_ID) on delete restrict on update restrict;

alter table PRODUCT add constraint FK_Reference_4 foreign key (M_ID)
      references MEDICINES (M_ID) on delete restrict on update restrict;

alter table PRODUCT add constraint FK_Reference_5 foreign key (S_ID)
      references SUPPLIERS (S_ID) on delete restrict on update restrict;

