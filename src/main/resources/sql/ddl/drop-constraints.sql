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

/**
 * alter tables to drop fk constraints
 */

/**
 * entity attribute foreign keys
 */
-- WORK
alter table WORK_ATTRIB
  drop foreign key FK_WORK_ATTRIB,
  drop index FK_WORK_ATTRIB;
-- EXPR
alter table EXPR_ATTRIB
  drop foreign key FK_EXPR_ATTRIB,
  drop index FK_EXPR_ATTRIB;
-- MANIF
alter table MANIF_ATTRIB
  drop foreign key FK_MANIF_ATTRIB,
  drop index FK_MANIF_ATTRIB;
-- MANIF_PUB
alter table MANIF_PUB_ATTRIB
  drop foreign key FK_MANIFPUB_ATTRIB,
  drop index FK_MANIFPUB_ATTRIB;
-- ITEM
alter table ITEM_ATTRIB
  drop foreign key FK_ITEM_ATTRIB,
  drop index FK_ITEM_ATTRIB;
-- RESPON
alter table RESPON_ATTRIB
  drop foreign key FK_RESPON_ATTRIB,
  drop index FK_RESPON_ATTRIB;
-- SUBJ_ENT_ID
alter table SUBJ_ATTRIB
  drop foreign key FK_SUBJ_ATTRIB,
  drop index FK_SUBJ_ATTRIB;

/**
 * Work
 */
alter table WORK_ENT
  drop index IDX_WORK_AUTHIDENT;
alter table WORK_ENT
  drop index IDX_WORK_UNIFORM_TITLE;

/**
 * Expression
 */

/**
 * Manifestation
 */

/**
 * Item
 */

/**
 * ResponsibleParty (Group 2)
 */
alter table RESPON_ENT
  drop index IDX_RESPON_CLASS;
alter table RESPON_ENT
  drop index IDX_RESPON_AUTHIDENT;
alter table RESPON_ENT
  drop index IDX_RESPON_AUTHORIZED_NAME;

alter table RESPON_ATTRIB
  drop index IDX_RESPATTR_CLASS;
alter table RESPON_ATTRIB
  drop index IDX_RESPATTR_TEXT;
alter table RESPON_ATTRIB
  drop index IDX_RESPATTR_NORMAL;

/**
 * Subject (Group 3)
 */

/**
 * Relationships
 * *************
 */

/**
 * Work2Work
 */
-- source Work
alter table WORK2WORK
  drop foreign key FK_W2W_SOURCE,
  drop index FK_W2W_SOURCE;
-- target Work
alter table WORK2WORK
  drop foreign key FK_W2W_TARGET,
  drop index FK_W2W_TARGET;

/**
 * Work2Expr
 */
-- source Work
alter table WORK2EXPR
  drop foreign key FK_W2E_SOURCE,
  drop index FK_W2E_SOURCE;
-- target Expression
alter table WORK2EXPR
  drop foreign key FK_W2E_TARGET,
  drop index FK_W2E_TARGET;

/**
 * Work2Manif
 */
-- source Work
alter table WORK2MANIF
  drop foreign key FK_W2M_SOURCE,
  drop index FK_W2M_SOURCE;
-- target Manifestation
alter table WORK2MANIF
  drop foreign key FK_W2M_TARGET,
  drop index FK_W2M_TARGET;

/**
 * Work2Item
 */
-- source Work
alter table WORK2ITEM
  drop foreign key FK_W2I_SOURCE,
  drop index FK_W2I_SOURCE;
-- target Item
alter table WORK2ITEM
  drop foreign key FK_W2I_TARGET,
  drop index FK_W2I_TARGET;

/**
 * Work2Respon
 */
-- source Work
alter table WORK2RESPON
  drop foreign key FK_W2R_SOURCE,
  drop index FK_W2R_SOURCE;
-- target ResponsibleParty
alter table WORK2RESPON
  drop foreign key FK_W2R_TARGET,
  drop index FK_W2R_TARGET;

/**
 * Work2Subj
 */
-- source Work
alter table WORK2SUBJ
  drop foreign key FK_W2S_SOURCE,
  drop index FK_W2S_SOURCE;
-- target Subject
alter table WORK2SUBJ
  drop foreign key FK_W2S_TARGET,
  drop index FK_W2S_TARGET;

/**
 * Expr2Work
 */
-- source Expression
alter table EXPR2WORK
  drop foreign key FK_E2W_SOURCE,
  drop index FK_E2W_SOURCE;
-- target Work
alter table EXPR2WORK
  drop foreign key FK_E2W_TARGET,
  drop index FK_E2W_TARGET;

/**
 * Expr2Expr
 */
-- source Expression
alter table EXPR2EXPR
  drop foreign key FK_E2E_SOURCE,
  drop index FK_E2E_SOURCE;
-- target Expression
alter table EXPR2EXPR
  drop foreign key FK_E2E_TARGET,
  drop index FK_E2E_TARGET;

/**
 * Expr2Manif
 */
-- source Expression
alter table EXPR2MANIF
  drop foreign key FK_E2M_SOURCE,
  drop index FK_E2M_SOURCE;
-- target Manifestation
alter table EXPR2MANIF
  drop foreign key FK_E2M_TARGET,
  drop index FK_E2M_TARGET;

/**
 * Expr2Respon
 */
-- source Expression
alter table EXPR2RESPON
  drop foreign key FK_E2R_SOURCE,
  drop index FK_E2R_SOURCE;
-- target ResponsibleParty
alter table EXPR2RESPON
  drop foreign key FK_E2R_TARGET,
  drop index FK_E2R_TARGET;

/**
 * Manif2Manif
 */
-- source Manifestation
alter table MANIF2MANIF
  drop foreign key FK_M2M_SOURCE,
  drop index FK_M2M_SOURCE;
-- target Manifestation
alter table MANIF2MANIF
  drop foreign key FK_M2M_TARGET,
  drop index FK_M2M_TARGET;

/**
 * Manif2Item
 */
-- source Manifestation
alter table MANIF2ITEM
  drop foreign key FK_M2I_SOURCE,
  drop index FK_M2I_SOURCE;
-- target Item
alter table MANIF2ITEM
  drop foreign key FK_M2I_TARGET,
  drop index FK_M2I_TARGET;

/**
 * Manif2Respon
 */
-- source Manifestation
alter table MANIF2RESPON
  drop foreign key FK_M2R_SOURCE,
  drop index FK_M2R_SOURCE;
-- target ResponsibleParty
alter table MANIF2RESPON
  drop foreign key FK_M2R_TARGET,
  drop index FK_M2R_TARGET;

/**
 * Item2Item
 */
-- source Item
alter table ITEM2ITEM
  drop foreign key FK_I2I_SOURCE,
  drop index FK_I2I_SOURCE;
-- target Item
alter table ITEM2ITEM
  drop foreign key FK_I2I_TARGET,
  drop index FK_I2I_TARGET;

/**
 * Item2Respon
 */
-- source Item
alter table ITEM2RESPON
  drop foreign key FK_I2R_SOURCE,
  drop index FK_I2R_SOURCE;
-- target ResponsibleParty
alter table ITEM2RESPON
  drop foreign key FK_I2R_TARGET,
  drop index FK_I2R_TARGET;

/**
 * Respon2Respon
 */
-- source ResponsibleParty
alter table RESPON2RESPON
  drop foreign key FK_R2R_SOURCE,
  drop index FK_R2R_SOURCE;
-- target ResponsibleParty
alter table RESPON2RESPON
  drop foreign key FK_R2R_TARGET,
  drop index FK_R2R_TARGET;
-- --