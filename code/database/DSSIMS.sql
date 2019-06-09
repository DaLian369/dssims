/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2019/6/9 16:02:12                            */
/*==============================================================*/


/*==============================================================*/
/* Table: ADMINISTRATOR                                         */
/*==============================================================*/
create table ADMINISTRATOR
(
   A_ID                 int not null auto_increment,
   A_PASSWORD           varchar(20) not null,
   A_NAME               varchar(20),
   A_PHONE              varchar(11) UNIQUE,
   primary key (A_ID),
   key AK_A_PHONE (A_PHONE)
);

/*==============================================================*/
/* Table: CUSTOMER                                              */
/*==============================================================*/
create table CUSTOMER
(
   C_ID                 int not null auto_increment,
   C_PASSWORD           varchar(20) not null,
   C_NAME               varchar(20),
   C_PHONE              varchar(11) UNIQUE,
   primary key (C_ID),
   key AK_C_PHONE (C_PHONE)
);

/*==============================================================*/
/* Table: INVENTORY                                             */
/*==============================================================*/
create table INVENTORY
(
   A_ID                 int not null,
   M_ID                 int not null,
   S_ID                 int not null,
   COUNT                int not null,
   primary key (A_ID, M_ID, S_ID)
);

/*==============================================================*/
/* Table: MEDICINE                                              */
/*==============================================================*/
create table MEDICINE
(
   M_ID                 int not null auto_increment,
   M_NAME               varchar(20) not null,
   M_TYPE               varchar(20) not null,
   M_PRICE              float not null,
   M_PRODUCTION_DATE    date not null,
   M_QUALITY_GUARANTEE_PERIOD varchar(10) not null,
   primary key (M_ID)
);

/*==============================================================*/
/* Table: "ORDER"                                               */
/*==============================================================*/
create table `ORDER`
(
   O_ID                 int not null auto_increment,
   C_ID                 int,
   A_ID                 int,
   M_ID                 int,
   S_ID                 int,
   O_QTY                int not null,
   O_DOLLARS            float not null,
   O_TRANSACTION_DATE   date not null,
   O_STATE              int not null default 2,
   primary key (O_ID)
);

/*==============================================================*/
/* Table: PURCHASE                                              */
/*==============================================================*/
create table PURCHASE
(
   P_ID                 int not null auto_increment,
   A_ID                 int,
   M_ID                 int,
   S_ID                 int,
   P_QTY                int not null,
   P_DOLLARS            float not null,
   P_TRANSACTION_DATE   date not null,
   P_STATE              int not null default 2,
   primary key (P_ID)
);

/*==============================================================*/
/* Table: SUPPLIER                                              */
/*==============================================================*/
create table SUPPLIER
(
   S_ID                 int not null auto_increment,
   S_PASSWORD           varchar(20) not null,
   S_NAME               varchar(20),
   S_PHONE              varchar(11) UNIQUE,
   S_CITY               varchar(20),
   primary key (S_ID),
   key AK_S_PHONE (S_PHONE)
);

alter table INVENTORY add constraint FK_Reference_10 foreign key (M_ID)
      references MEDICINE (M_ID) on delete restrict on update restrict;

alter table INVENTORY add constraint FK_Reference_13 foreign key (S_ID)
      references SUPPLIER (S_ID) on delete restrict on update restrict;

alter table INVENTORY add constraint FK_Reference_9 foreign key (A_ID)
      references ADMINISTRATOR (A_ID) on delete restrict on update restrict;

alter table `ORDER` add constraint FK_Reference_12 foreign key (S_ID)
      references SUPPLIER (S_ID) on delete restrict on update restrict;

alter table `ORDER` add constraint FK_Reference_2 foreign key (C_ID)
      references CUSTOMER (C_ID) on delete restrict on update restrict;

alter table `ORDER` add constraint FK_Reference_3 foreign key (A_ID)
      references ADMINISTRATOR (A_ID) on delete restrict on update restrict;

alter table `ORDER` add constraint FK_Reference_6 foreign key (M_ID)
      references MEDICINE (M_ID) on delete restrict on update restrict;

alter table PURCHASE add constraint FK_Reference_11 foreign key (S_ID)
      references SUPPLIER (S_ID) on delete restrict on update restrict;

alter table PURCHASE add constraint FK_Reference_7 foreign key (A_ID)
      references ADMINISTRATOR (A_ID) on delete restrict on update restrict;

alter table PURCHASE add constraint FK_Reference_8 foreign key (M_ID)
      references MEDICINE (M_ID) on delete restrict on update restrict;

