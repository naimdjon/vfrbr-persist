--
-- Copyright 2009-2011, Trustees of Indiana University
-- All rights reserved.
--
-- Redistribution and use in source and binary forms, with or without
-- modification, are permitted provided that the following conditions are met:
--
--   Redistributions of source code must retain the above copyright notice,
--   this list of conditions and the following disclaimer.
--
--   Redistributions in binary form must reproduce the above copyright notice,
--   this list of conditions and the following disclaimer in the documentation
--   and/or other materials provided with the distribution.
--
--   Neither the name of Indiana University nor the names of its
--   contributors may be used to endorse or promote products derived from this
--   software without specific prior written permission.
--
-- THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
-- AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
-- IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
-- ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE
-- LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
-- CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
-- SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
-- INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
-- CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
-- ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
-- POSSIBILITY OF SUCH DAMAGE.
--

-- create tables

-- Group 1 --

/**
 * Work entity
 */
create table WORK_ENT (
  WORK_ENT_ID         int  auto_increment not null,
  WORK_ENT_VERSION    int,
  WORK_ENT_URI        varchar(512),
  WORK_ENT_AUTHIDENT  varchar(2048),
  UNIFORM_TITLE       varchar(2048),
  primary key (WORK_ENT_ID)
) ENGINE InnoDB
  CHARACTER SET utf8;

/**
 * Work attributes
 */
create table WORK_ATTRIB (
    -- persistence properties
    WORK_ATTRIB_ID        int   auto_increment not null,
    WORK_ATTRIB_VERSION   int,
    WORK_ATTRIB_CLASS     varchar(64), -- Class Discriminator
    -- simple properties, common to all attribute types
    ATTRIB_LIST_ORDER     int   default 0,
    TEXT_VAL              varchar(20480),
    -- extended properties
    AVAIL_VAL             varchar(64),
    FUNCT_VAL             varchar(64),
    JURIS_VAL             varchar(64),
    NORMAL_VAL            varchar(512),
    OFFSET_VAL            int,
    QUANT_VAL             int,
    TIME_VAL              varchar(64),
    TYPE_VAL              varchar(64),
    VOCAB_VAL             varchar(64),
    -- owning entity
    WORK_ENT_ID           int,
    primary key (WORK_ATTRIB_ID)
) ENGINE InnoDB
  CHARACTER SET utf8;

/**
 * Expression entity
 */
create table EXPR_ENT (
  EXPR_ENT_ID         int  auto_increment not null,
  EXPR_ENT_VERSION    int,
  EXPR_ENT_URI        varchar(512),
  primary key (EXPR_ENT_ID)
) ENGINE InnoDB
  CHARACTER SET utf8;

/**
 * Expression attributes
 */
create table EXPR_ATTRIB (
    -- persistence properties
    EXPR_ATTRIB_ID        int   auto_increment not null,
    EXPR_ATTRIB_VERSION   int,
    EXPR_ATTRIB_CLASS     varchar(64), -- Class Discriminator
    -- simple properties, common to all attribute types
    ATTRIB_LIST_ORDER     int   default 0,
    TEXT_VAL              varchar(20480),
    -- extended properties
    AVAIL_VAL             varchar(64),
    FUNCT_VAL             varchar(64),
    JURIS_VAL             varchar(64),
    NORMAL_VAL            varchar(512),
    OFFSET_VAL            int,
    QUANT_VAL             int,
    TIME_VAL              varchar(64),
    TYPE_VAL              varchar(64),
    VOCAB_VAL             varchar(64),
    -- owning entity
    EXPR_ENT_ID           int,
    primary key (EXPR_ATTRIB_ID)
) ENGINE InnoDB
  CHARACTER SET utf8;

/**
 * Manifestation entity
 */
create table MANIF_ENT (
  -- persistence properties
  MANIF_ENT_ID        int  auto_increment not null,
  MANIF_ENT_VERSION   int,
  -- entity properties
  MANIF_ENT_URI       varchar(512),
  -- ------
  -- formOfExpression denormalized into Manifestation
  -- for performance and Manifestation with no Work/Expression
  EXPR_FORM           varchar(64),
  primary key (MANIF_ENT_ID)
) ENGINE InnoDB
  CHARACTER SET utf8;

/**
 * Manifestation attributes
 */
create table MANIF_ATTRIB (
    -- persistence properties
    MANIF_ATTRIB_ID        int   auto_increment not null,
    MANIF_ATTRIB_VERSION   int,
    MANIF_ATTRIB_CLASS     varchar(64), -- Class Discriminator
    -- simple properties, common to all attribute types
    ATTRIB_LIST_ORDER     int   default 0,
    TEXT_VAL              varchar(20480),
    -- extended properties
    AVAIL_VAL             varchar(64),
    FUNCT_VAL             varchar(64),
    JURIS_VAL             varchar(64),
    NORMAL_VAL            varchar(512),
    OFFSET_VAL            int,
    QUANT_VAL             int,
    TIME_VAL              varchar(64),
    TYPE_VAL              varchar(64),
    VOCAB_VAL             varchar(64),
    -- owning entity
    MANIF_ENT_ID           int,
    primary key (MANIF_ATTRIB_ID)
) ENGINE InnoDB
  CHARACTER SET utf8;

/**
 * Manifestation published
 */
create table MANIF_PUB (
  MANIF_PUB_ID              int auto_increment not null,
  MANIF_ENT_ID              int not null,
  MANIF_PUB_VERSION         int,
  MANIF_PUB_LIST_ORDER      int default 0,
  primary key (MANIF_PUB_ID)
) ENGINE InnoDB
  CHARACTER SET utf8;

/**
 * Manifestation published attributes
 */
create table MANIF_PUB_ATTRIB (
    -- persistence properties
    MANIF_PUB_ATTRIB_ID        int   auto_increment not null,
    MANIF_PUB_ATTRIB_VERSION   int,
    MANIF_PUB_ATTRIB_CLASS     varchar(64), -- Class Discriminator
    -- simple properties, common to all attribute types
    ATTRIB_LIST_ORDER     int   default 0,
    TEXT_VAL              varchar(20480),
    -- extended properties
    AVAIL_VAL             varchar(64),
    FUNCT_VAL             varchar(64),
    JURIS_VAL             varchar(64),
    NORMAL_VAL            varchar(64),
    OFFSET_VAL            int,
    QUANT_VAL             int,
    TIME_VAL              varchar(64),
    TYPE_VAL              varchar(64),
    VOCAB_VAL             varchar(64),
    -- owning entity
    MANIF_PUB_ID           int,
    primary key (MANIF_PUB_ATTRIB_ID)
) ENGINE InnoDB
  CHARACTER SET utf8;

/**
 * Item entity
 */
create table ITEM_ENT (
  ITEM_ENT_ID       int  auto_increment not null,
  ITEM_ENT_VERSION  int,
  ITEM_ENT_URI      varchar(512),
  primary key (ITEM_ENT_ID)
) ENGINE InnoDB
  CHARACTER SET utf8;

/**
 * Item attributes
 */
create table ITEM_ATTRIB (
    -- persistence properties
    ITEM_ATTRIB_ID        int   auto_increment not null,
    ITEM_ATTRIB_VERSION   int,
    ITEM_ATTRIB_CLASS     varchar(64), -- Class Discriminator
    -- simple properties, common to all attribute types
    ATTRIB_LIST_ORDER     int   default 0,
    TEXT_VAL              varchar(20480),
    -- extended properties
    AVAIL_VAL             varchar(64),
    FUNCT_VAL             varchar(64),
    JURIS_VAL             varchar(64),
    NORMAL_VAL            varchar(64),
    OFFSET_VAL            int,
    QUANT_VAL             int,
    TIME_VAL              varchar(64),
    TYPE_VAL              varchar(64),
    VOCAB_VAL             varchar(64),
    -- owning entity
    ITEM_ENT_ID           int,
    primary key (ITEM_ATTRIB_ID)
) ENGINE InnoDB
  CHARACTER SET utf8;

/**
 * ResponsibleParty entity
 *   Group 2
 *    Person
 *    CorporateBody
 *    Family
 */
create table RESPON_ENT (
  RESPON_ENT_ID         int  auto_increment not null,
  RESPON_ENT_VERSION    int,
  RESPON_CLASS          varchar(64), -- Class Discriminator
  RESPON_ENT_URI        varchar(512),
  RESPON_ENT_AUTHIDENT  varchar(2024),
  AUTHORIZED_NAME       varchar(2024),
  CATALOG_STATUS        varchar(64),
  CATALOG_SOURCE        varchar(64),
  primary key (RESPON_ENT_ID)
) ENGINE InnoDB
  CHARACTER SET utf8;

/**
 * ResponsibleParty attributes
 */
create table RESPON_ATTRIB (
    -- persistence properties
    RESPON_ATTRIB_ID        int   auto_increment not null,
    RESPON_ATTRIB_VERSION   int,
    RESPON_ATTRIB_CLASS     varchar(64), -- Class Discriminator
    -- simple properties, common to all attribute types
    ATTRIB_LIST_ORDER     int   default 0,
    TEXT_VAL              varchar(20480),
    -- extended properties
    AVAIL_VAL             varchar(64),
    FUNCT_VAL             varchar(64),
    JURIS_VAL             varchar(64),
    NORMAL_VAL            varchar(512),
    OFFSET_VAL            int,
    QUANT_VAL             int,
    TIME_VAL              varchar(64),
    TYPE_VAL              varchar(64),
    VOCAB_VAL             varchar(64),
    -- owning entity
    RESPON_ENT_ID           int,
    primary key (RESPON_ATTRIB_ID)
) ENGINE InnoDB
  CHARACTER SET utf8;

/**
 * Subjects entity
 *  Group 3
 *    Concept
 *    Event
 *    Object
 *    Place
 */
create table SUBJ_ENT (
  SUBJ_ENT_ID       int  auto_increment not null,
  SUBJ_ENT_VERSION  int,
  SUBJ_CLASS        varchar(256), -- Class Discriminator
  SUBJ_ENT_URI      varchar(2024),
  primary key (SUBJ_ENT_ID)
) ENGINE InnoDB
  CHARACTER SET utf8;

/**
 * Subjects attributes
 */
create table SUBJ_ATTRIB (
    -- persistence properties
    SUBJ_ATTRIB_ID        int   auto_increment not null,
    SUBJ_ATTRIB_VERSION   int,
    SUBJ_ATTRIB_CLASS     varchar(256), -- Class Discriminator
    -- simple properties, common to all attribute types
    ATTRIB_LIST_ORDER     int   default 0,
    TEXT_VAL              varchar(2024),
    -- extended properties
    AVAIL_VAL             varchar(2024),
    FUNCT_VAL             varchar(2024),
    JURIS_VAL             varchar(2024),
    NORMAL_VAL            varchar(2024),
    OFFSET_VAL            int,
    QUANT_VAL             int,
    TIME_VAL              varchar(2024),
    TYPE_VAL              varchar(2024),
    VOCAB_VAL             varchar(2024),
    -- owning entity
    SUBJ_ENT_ID           int,
    primary key (SUBJ_ATTRIB_ID)
) ENGINE InnoDB
  CHARACTER SET utf8;

/**
 * Relation Classes
 * -- common attributes
 *  REL_TYPE        -- createdBy ("has" type of relation)
 *  REL_ROLE        -- composer (responsibility role for the type)
 *  REL_CATEGORY    -- wholePart (category of the type)
 *  REL_LIST_ORDER  -- 0 (ordering of list)
 */

/**
 * WorkToWork Relationships
 */
create table WORK2WORK (
  WORK2WORK_ID        int auto_increment not null,
  WORK2WORK_VERSION   int,
  REL_TYPE            varchar(32),
  REL_ROLE            varchar(32),
  REL_CATEGORY        varchar(32),
  REL_LIST_ORDER      int default 0,
  SOURCE_WORK_ID      int not null, -- FK(WORK_ENT_ID)
  TARGET_WORK_ID      int not null, -- FK(WORK_ENT_ID)
  primary key (WORK2WORK_ID)
) ENGINE InnoDB
  CHARACTER SET utf8;

/**
 * WorkToExpression Relationships
 */
create table WORK2EXPR (
  WORK2EXPR_ID        int auto_increment not null,
  WORK2EXPR_VERSION   int,
  REL_TYPE            varchar(32),
  REL_ROLE            varchar(32),
  REL_CATEGORY        varchar(32),
  REL_LIST_ORDER      int default 0,
  SOURCE_WORK_ID      int not null,
  TARGET_EXPR_ID      int not null,
  primary key (WORK2EXPR_ID)
) ENGINE InnoDB
  CHARACTER SET utf8;

/**
 * WorkToManifestation Relationships
 */
create table WORK2MANIF (
  WORK2MANIF_ID       int auto_increment not null,
  WORK2MANIF_VERSION  int,
  REL_TYPE            varchar(32),
  REL_ROLE            varchar(32),
  REL_CATEGORY        varchar(32),
  REL_LIST_ORDER      int default 0,
  SOURCE_WORK_ID      int not null,
  TARGET_MANIF_ID     int not null,
  primary key (WORK2MANIF_ID)
) ENGINE InnoDB
  CHARACTER SET utf8;

/**
 * WorkToItem Relationships
 */
create table WORK2ITEM (
  WORK2ITEM_ID        int auto_increment not null,
  WORK2ITEM_VERSION   int,
  REL_TYPE            varchar(32),
  REL_ROLE            varchar(32),
  REL_CATEGORY        varchar(32),
  REL_LIST_ORDER      int default 0,
  SOURCE_WORK_ID      int not null,
  TARGET_ITEM_ID      int not null,
  primary key (WORK2ITEM_ID)
) ENGINE InnoDB
  CHARACTER SET utf8;

/**
 * WorkToResponsibleParty Relationships
 */
create table WORK2RESPON (
  WORK2RESPON_ID      int auto_increment not null,
  WORK2RESPON_VERSION int,
  REL_CLASS           varchar(256), -- discrim for respon types
  REL_TYPE            varchar(32),
  REL_ROLE            varchar(32),
  REL_CATEGORY        varchar(32),
  REL_LIST_ORDER      int default 0,
  SOURCE_WORK_ID      int not null,
  TARGET_RESPON_ID    int not null,
  primary key (WORK2RESPON_ID)
) ENGINE InnoDB
  CHARACTER SET utf8;

/**
 * WorkToSubject Relationships
 */
create table WORK2SUBJ (
  WORK2SUBJ_ID        int auto_increment not null,
  WORK2SUBJ_VERSION   int,
  REL_CLASS           varchar(256), -- discrim for subject types
  REL_TYPE            varchar(32),
  REL_ROLE            varchar(32),
  REL_CATEGORY        varchar(32),
  REL_LIST_ORDER      int default 0,
  SOURCE_WORK_ID      int not null,
  TARGET_SUBJ_ID      int not null,
  primary key (WORK2SUBJ_ID)
) ENGINE InnoDB
  CHARACTER SET utf8;

/**
 * ExpressionToWork Relationships
 */
create table EXPR2WORK (
  EXPR2WORK_ID        int auto_increment not null,
  EXPR2WORK_VERSION   int,
  REL_TYPE            varchar(32),
  REL_ROLE            varchar(32),
  REL_CATEGORY        varchar(32),
  REL_LIST_ORDER      int default 0,
  SOURCE_EXPR_ID      int not null,
  TARGET_WORK_ID      int not null,
  primary key (EXPR2WORK_ID)
) ENGINE InnoDB
  CHARACTER SET utf8;

/**
 * ExpressionToExpression Relationships
 */
create table EXPR2EXPR (
  EXPR2EXPR_ID        int auto_increment not null,
  EXPR2EXPR_VERSION   int,
  REL_TYPE            varchar(32),
  REL_ROLE            varchar(32),
  REL_CATEGORY        varchar(32),
  REL_LIST_ORDER      int default 0,
  SOURCE_EXPR_ID      int not null,
  TARGET_EXPR_ID      int not null,
  primary key (EXPR2EXPR_ID)
) ENGINE InnoDB
  CHARACTER SET utf8;

/**
 * ExpressionToManifestation Relationships
 */
create table EXPR2MANIF (
  EXPR2MANIF_ID       int auto_increment not null,
  EXPR2MANIF_VERSION  int,
  REL_TYPE            varchar(32),
  REL_ROLE            varchar(32),
  REL_CATEGORY        varchar(32),
  REL_LIST_ORDER      int default 0,
  SOURCE_EXPR_ID      int not null,
  TARGET_MANIF_ID     int not null,
  primary key (EXPR2MANIF_ID)
) ENGINE InnoDB
  CHARACTER SET utf8;

/**
 * ExpressionToResponsibleParty Relationships
 */
create table EXPR2RESPON (
  EXPR2RESPON_ID      int auto_increment not null,
  EXPR2RESPON_VERSION int,
  REL_CLASS           varchar(256), -- discrim for respon types
  REL_TYPE            varchar(32),
  REL_ROLE            varchar(32),
  REL_CATEGORY        varchar(32),
  REL_LIST_ORDER      int default 0,
  SOURCE_EXPR_ID      int not null,
  TARGET_RESPON_ID    int not null,
  primary key (EXPR2RESPON_ID)
) ENGINE InnoDB
  CHARACTER SET utf8;

/**
 * ManifestationToManifestation Relationships
 */
create table MANIF2MANIF (
  MANIF2MANIF_ID        int auto_increment not null,
  MANIF2MANIF_VERSION   int,
  REL_TYPE              varchar(32),
  REL_ROLE              varchar(32),
  REL_CATEGORY          varchar(32),
  REL_LIST_ORDER        int default 0,
  SOURCE_MANIF_ID       int not null,
  TARGET_MANIF_ID       int not null,
  primary key (MANIF2MANIF_ID)
) ENGINE InnoDB
  CHARACTER SET utf8;

/**
 * ManifestationToItem Relationships
 */
create table MANIF2ITEM (
  MANIF2ITEM_ID         int auto_increment not null,
  MANIF2ITEM_VERSION    int,
  REL_TYPE              varchar(32),
  REL_ROLE              varchar(32),
  REL_CATEGORY          varchar(32),
  REL_LIST_ORDER        int default 0,
  SOURCE_MANIF_ID       int not null,
  TARGET_ITEM_ID        int not null,
  primary key (MANIF2ITEM_ID)
) ENGINE InnoDB
  CHARACTER SET utf8;

/**
 * ManifestationToResponsibleParty Relationships
 */
create table MANIF2RESPON (
  MANIF2RESPON_ID       int auto_increment not null,
  MANIF2RESPON_VERSION  int,
  REL_CLASS             varchar(256), -- discrim for respon types
  REL_TYPE              varchar(32),
  REL_ROLE              varchar(32),
  REL_CATEGORY          varchar(32),
  REL_LIST_ORDER        int default 0,
  SOURCE_MANIF_ID       int not null,
  TARGET_RESPON_ID      int not null,
  primary key (MANIF2RESPON_ID)
) ENGINE InnoDB
  CHARACTER SET utf8;

/**
 * ItemToItem Relationships
 */
create table ITEM2ITEM (
  ITEM2ITEM_ID        int auto_increment not null,
  ITEM2ITEM_VERSION   int,
  REL_TYPE            varchar(32),
  REL_ROLE            varchar(32),
  REL_CATEGORY        varchar(32),
  REL_LIST_ORDER      int default 0,
  SOURCE_ITEM_ID      int not null,
  TARGET_ITEM_ID      int not null,
  primary key (ITEM2ITEM_ID)
) ENGINE InnoDB
  CHARACTER SET utf8;

/**
 * ItemToResponsibleParty Relationships
 */
create table ITEM2RESPON (
  ITEM2RESPON_ID        int auto_increment not null,
  ITEM2RESPON_VERSION   int,
  REL_CLASS             varchar(256), -- discrim for respon types
  REL_TYPE              varchar(32),
  REL_ROLE              varchar(32),
  REL_CATEGORY          varchar(32),
  REL_LIST_ORDER        int default 0,
  SOURCE_ITEM_ID        int not null,
  TARGET_RESPON_ID      int not null,
  primary key (ITEM2RESPON_ID)
) ENGINE InnoDB
  CHARACTER SET utf8;

/**
 * ResponsiblePartyToResponsibleParty Relationships
 */
create table RESPON2RESPON (
  RESPON2RESPON_ID        int auto_increment not null,
  RESPON2RESPON_VERSION   int,
  REL_CLASS               varchar(256), -- discrim for respon types
  REL_TYPE                varchar(32),
  REL_ROLE                varchar(32),
  REL_CATEGORY            varchar(32),
  REL_LIST_ORDER          int default 0,
  SOURCE_RESPON_ID        int not null,
  TARGET_RESPON_ID        int not null,
  primary key (RESPON2RESPON_ID)
) ENGINE InnoDB
  CHARACTER SET utf8;
-- --