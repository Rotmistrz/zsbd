--------------------------------------------------------
--  File created - wtorek-października-27-2020   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table COUNTRIES
--------------------------------------------------------

  CREATE TABLE "COUNTRIES" 
   (    "COUNTRYID" NUMBER(*,0), 
    "NAME" VARCHAR2(64 BYTE)
   ) PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  ;
--------------------------------------------------------
--  DDL for Table EVENTS
--------------------------------------------------------

  CREATE TABLE "EVENTS" 
   (    "EVENTID" NUMBER(*,0), 
    "NAME" VARCHAR2(64 BYTE), 
    "DESCRIPTION" VARCHAR2(255 BYTE), 
    "EVENTDATE" DATE, 
    "PLACEID" NUMBER(*,0), 
    "GROUPID" NUMBER(*,0), 
    "OWNERID" NUMBER(*,0)
   ) PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  ;
--------------------------------------------------------
--  DDL for Table PARTICIPANTS
--------------------------------------------------------

  CREATE TABLE "PARTICIPANTS" 
   (    "PARTICIPANTID" NUMBER(*,0), 
    "NAME" VARCHAR2(64 BYTE), 
    "SURNAME" VARCHAR2(64 BYTE), 
    "BIRTHDATE" DATE, 
    "SEX" CHAR(1 BYTE)
   ) PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  ;
--------------------------------------------------------
--  DDL for Table PLACES
--------------------------------------------------------

  CREATE TABLE "PLACES" 
   (    "PLACEID" NUMBER(*,0), 
    "NAME" VARCHAR2(64 BYTE), 
    "ADDRESS" VARCHAR2(64 BYTE), 
    "CITY" VARCHAR2(64 BYTE), 
    "COLUMN1" NUMBER(*,0)
   ) PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  ;
--------------------------------------------------------
--  DDL for Table RESERVATIONS
--------------------------------------------------------

  CREATE TABLE "RESERVATIONS" 
   (    "RESERVATIONID" NUMBER(*,0), 
    "RESERVATIONDATE" DATE, 
    "ISPAID" NUMBER(1,0) DEFAULT 0, 
    "PARTICIPANTID" NUMBER(*,0), 
    "EVENTID" NUMBER(*,0)
   ) PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  ;
--------------------------------------------------------
--  DDL for Table RESERVATIONSSEATS
--------------------------------------------------------

  CREATE TABLE "RESERVATIONSSEATS" 
   (    "SEATID" NUMBER(*,0), 
    "RESERVATIONID" NUMBER(*,0)
   ) PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  ;
--------------------------------------------------------
--  DDL for Table SEATS
--------------------------------------------------------

  CREATE TABLE "SEATS" 
   (    "SEATID" NUMBER(*,0), 
    "SEATNUMBER" NUMBER(*,0), 
    "SEATROW" NUMBER(*,0), 
    "ISSTANDING" NUMBER(1,0) DEFAULT 0, 
    "SECTORID" NUMBER(*,0)
   ) PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  ;
--------------------------------------------------------
--  DDL for Table SECTORS
--------------------------------------------------------

  CREATE TABLE "SECTORS" 
   (    "SECTORID" NUMBER(*,0), 
    "NAME" VARCHAR2(64 BYTE), 
    "PLACEID" NUMBER(*,0), 
    "COLOURID" NUMBER(*,0)
   ) PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  ;
REM INSERTING into COUNTRIES
SET DEFINE OFF;

REM INSERTING into EVENTS
SET DEFINE OFF;
REM INSERTING into PARTICIPANTS
SET DEFINE OFF;
REM INSERTING into PLACES
SET DEFINE OFF;
REM INSERTING into RESERVATIONS
SET DEFINE OFF;
REM INSERTING into RESERVATIONSSEATS
SET DEFINE OFF;
REM INSERTING into SEATS
SET DEFINE OFF;
REM INSERTING into SECTORS
SET DEFINE OFF;
--------------------------------------------------------
--  Constraints for Table COUNTRIES
--------------------------------------------------------

  ALTER TABLE "COUNTRIES" MODIFY ("COUNTRYID" NOT NULL ENABLE);
  ALTER TABLE "COUNTRIES" MODIFY ("NAME" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table EVENTS
--------------------------------------------------------

  ALTER TABLE "EVENTS" MODIFY ("EVENTID" NOT NULL ENABLE);
  ALTER TABLE "EVENTS" MODIFY ("NAME" NOT NULL ENABLE);
  ALTER TABLE "EVENTS" MODIFY ("EVENTDATE" NOT NULL ENABLE);
  ALTER TABLE "EVENTS" MODIFY ("PLACEID" NOT NULL ENABLE);
  ALTER TABLE "EVENTS" MODIFY ("GROUPID" NOT NULL ENABLE);
  ALTER TABLE "EVENTS" MODIFY ("OWNERID" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table PARTICIPANTS
--------------------------------------------------------

  ALTER TABLE "PARTICIPANTS" MODIFY ("PARTICIPANTID" NOT NULL ENABLE);
  ALTER TABLE "PARTICIPANTS" MODIFY ("NAME" NOT NULL ENABLE);
  ALTER TABLE "PARTICIPANTS" MODIFY ("SURNAME" NOT NULL ENABLE);
  ALTER TABLE "PARTICIPANTS" MODIFY ("BIRTHDATE" NOT NULL ENABLE);
  ALTER TABLE "PARTICIPANTS" MODIFY ("SEX" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table PLACES
--------------------------------------------------------

  ALTER TABLE "PLACES" MODIFY ("PLACEID" NOT NULL ENABLE);
  ALTER TABLE "PLACES" MODIFY ("NAME" NOT NULL ENABLE);
  ALTER TABLE "PLACES" MODIFY ("ADDRESS" NOT NULL ENABLE);
  ALTER TABLE "PLACES" MODIFY ("CITY" NOT NULL ENABLE);
  ALTER TABLE "PLACES" MODIFY ("COLUMN1" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table RESERVATIONS
--------------------------------------------------------

  ALTER TABLE "RESERVATIONS" MODIFY ("RESERVATIONID" NOT NULL ENABLE);
  ALTER TABLE "RESERVATIONS" MODIFY ("RESERVATIONDATE" NOT NULL ENABLE);
  ALTER TABLE "RESERVATIONS" MODIFY ("ISPAID" NOT NULL ENABLE);
  ALTER TABLE "RESERVATIONS" MODIFY ("PARTICIPANTID" NOT NULL ENABLE);
  ALTER TABLE "RESERVATIONS" MODIFY ("EVENTID" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table RESERVATIONSSEATS
--------------------------------------------------------

  ALTER TABLE "RESERVATIONSSEATS" MODIFY ("SEATID" NOT NULL ENABLE);
  ALTER TABLE "RESERVATIONSSEATS" MODIFY ("RESERVATIONID" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table SEATS
--------------------------------------------------------

  ALTER TABLE "SEATS" MODIFY ("SEATID" NOT NULL ENABLE);
  ALTER TABLE "SEATS" MODIFY ("SEATNUMBER" NOT NULL ENABLE);
  ALTER TABLE "SEATS" MODIFY ("SEATROW" NOT NULL ENABLE);
  ALTER TABLE "SEATS" MODIFY ("ISSTANDING" NOT NULL ENABLE);
  ALTER TABLE "SEATS" MODIFY ("SECTORID" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table SECTORS
--------------------------------------------------------

  ALTER TABLE "SECTORS" MODIFY ("SECTORID" NOT NULL ENABLE);
  ALTER TABLE "SECTORS" MODIFY ("NAME" NOT NULL ENABLE);
  ALTER TABLE "SECTORS" MODIFY ("PLACEID" NOT NULL ENABLE);
