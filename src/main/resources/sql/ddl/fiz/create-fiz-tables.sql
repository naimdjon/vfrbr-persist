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

-- create tables for frbrization (fiz) reports

/*
 * Denormalized content from MARC frbrization
 * in support of Group2 entities reports.
 */
create table FIZ_REP_G2BIB (
  DB_ID             int not null,
  CONTRIB_TYPE      varchar(16),
  CONTRIB_NAME      varchar(2048),
  CONTRIB_DATE      varchar(512),
  CONTRIB_AUTHIDENT varchar(2048),
  BIBREC_IDENT      varchar(32),
  BIBFIELD_TAG      varchar(8),
  BIBFIELD_STRING   varchar(2048),
  --
  primary key (DB_ID)
) ENGINE InnoDB
  CHARACTER SET utf8;

/*
 * Denormalized content from MARC frbrization 
 * in support of Work reports.
 */
create table FIZ_REP_WORK (
  DB_ID           int not null,   -- work.id
  UNIFORM_TITLE   varchar(2048),  -- work.uniformTitle
  CMP_AUTH_NAME   varchar(2048),  -- work.composers(0).authorizedName
  DATE_TEXT       varchar(1024),  -- work.dates(0).text
  IDENT_GROUP     varchar(32),    -- work identification (marcRec) group
  IDENT_ALGOR     varchar(16),    -- work identification algorithim step
  BIBREC_ID       varchar(32),    -- MARC bib rec control number
  BIBFIELD_TAG    varchar(8),     -- MARC bib rec field tag (work field)
  AUTHREC_ID      varchar(32),    -- MARC auth rec control number
  MARC_FILENAME   varchar(1024),  -- MARC source file name
  MARC_RECNUM     int,            -- MARC record number in source file
  --
  primary key (DB_ID)
) ENGINE InnoDB
  CHARACTER SET utf8;

/*
 * Denormalized content from MARC frbrization
 * in support of report for
 * Manifestation with no associated Works.
 */
create table FIZ_REP_MANIFNOWORK (
  DB_ID               int not null,   -- manif.id
  TITLE               varchar(2048),  -- manif.titles(0).text
  CONTRIB_TYPE        varchar(16),
  CONTRIB_AUTHNAME    varchar(2048),
  CONTRIB_AUTHIDENT   varchar(2048),
  CONTRIB_ROLE        varchar(64),
  BIBREC_ID           varchar(32),    -- MARC bib rec control number
  BIBREC_GROUP        varchar(32),    -- MARC bib rec group
  MARC_FILENAME       varchar(1024),  -- MARC source file name
  MARC_RECNUM         int,
  --
  primary key (DB_ID)
) ENGINE InnoDB
  CHARACTER SET utf8;
--