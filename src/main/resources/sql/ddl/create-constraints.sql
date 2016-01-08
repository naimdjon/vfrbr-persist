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
 * alter tables to create constraints
 */

/**
 * Entity Attributes
 * *****************
 */

/*
 * Work attributes
 */
alter table WORK_ATTRIB
  add index FK_WORK_ATTRIB (WORK_ENT_ID),
  add constraint FK_WORK_ATTRIB
    foreign key (WORK_ENT_ID)
    references WORK_ENT(WORK_ENT_ID);
/*
 * Expression attributes
 */
alter table EXPR_ATTRIB
  add index FK_EXPR_ATTRIB (EXPR_ENT_ID),
  add constraint FK_EXPR_ATTRIB
    foreign key (EXPR_ENT_ID)
    references EXPR_ENT(EXPR_ENT_ID);
/*
 * Manifestation attributes
 */
alter table MANIF_ATTRIB
  add index FK_MANIF_ATTRIB (MANIF_ENT_ID),
  add constraint FK_MANIF_ATTRIB
    foreign key (MANIF_ENT_ID)
    references MANIF_ENT(MANIF_ENT_ID);
/*
 * ManifestationPublication attributes
 */
alter table MANIF_PUB_ATTRIB
  add index FK_MANIFPUB_ATTRIB (MANIF_PUB_ID),
  add constraint FK_MANIFPUB_ATTRIB
    foreign key (MANIF_PUB_ID)
    references MANIF_PUB(MANIF_PUB_ID);
/*
 * Item attributes
 */
alter table ITEM_ATTRIB
  add index FK_ITEM_ATTRIB (ITEM_ENT_ID),
  add constraint FK_ITEM_ATTRIB
    foreign key (ITEM_ENT_ID)
    references ITEM_ENT(ITEM_ENT_ID);
/*
 * ResponsibleParty attributes
 */
alter table RESPON_ATTRIB
  add index FK_RESPON_ATTRIB (RESPON_ENT_ID),
  add constraint FK_RESPON_ATTRIB
    foreign key (RESPON_ENT_ID)
    references RESPON_ENT(RESPON_ENT_ID);
alter table RESPON_ATTRIB
  add index IDX_RESPATTR_CLASS (RESPON_ATTRIB_CLASS);
alter table RESPON_ATTRIB
  add index IDX_RESPATTR_TEXT (TEXT_VAL);
alter table RESPON_ATTRIB
  add index IDX_RESPATTR_NORMAL (NORMAL_VAL);
/*
 * Subject attributes
 */
alter table SUBJ_ATTRIB
  add index FK_SUBJ_ATTRIB (SUBJ_ENT_ID),
  add constraint FK_SUBJ_ATTRIB
    foreign key (SUBJ_ENT_ID)
    references SUBJ_ENT(SUBJ_ENT_ID);

/**
 * Work
 */
alter table WORK_ENT
  add index IDX_WORK_AUTHIDENT (WORK_ENT_AUTHIDENT);
alter table WORK_ENT
  add index IDX_WORK_UNIFORM_TITLE (UNIFORM_TITLE);

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
  add index IDX_RESPON_CLASS (RESPON_CLASS);
alter table RESPON_ENT
  add index IDX_RESPON_AUTHIDENT (RESPON_ENT_AUTHIDENT);
alter table RESPON_ENT
  add index IDX_RESPON_AUTHORIZED_NAME (AUTHORIZED_NAME);

/**
 * Subjects (Group 3)
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
  add index FK_W2W_SOURCE (SOURCE_WORK_ID),
  add constraint FK_W2W_SOURCE
    foreign key (SOURCE_WORK_ID)
    references WORK_ENT(WORK_ENT_ID);
-- target Work
alter table WORK2WORK
  add index FK_W2W_TARGET (TARGET_WORK_ID),
  add constraint FK_W2W_TARGET
    foreign key (TARGET_WORK_ID)
    references WORK_ENT(WORK_ENT_ID);

/**
 * Work2Expr
 */
-- source Work
alter table WORK2EXPR
  add index FK_W2E_SOURCE (SOURCE_WORK_ID),
  add constraint FK_W2E_SOURCE
    foreign key (SOURCE_WORK_ID)
    references WORK_ENT(WORK_ENT_ID);
-- target Expression
alter table WORK2EXPR
  add index FK_W2E_TARGET (TARGET_EXPR_ID),
  add constraint FK_W2E_TARGET
    foreign key (TARGET_EXPR_ID)
    references EXPR_ENT(EXPR_ENT_ID);

/**
 * Work2Manif
 */
-- source Work
alter table WORK2MANIF
  add index FK_W2M_SOURCE (SOURCE_WORK_ID),
  add constraint FK_W2M_SOURCE
    foreign key (SOURCE_WORK_ID)
    references WORK_ENT(WORK_ENT_ID);
-- target manifestation
alter table WORK2MANIF
  add index FK_W2M_TARGET (TARGET_MANIF_ID),
  add constraint FK_W2M_TARGET
    foreign key (TARGET_MANIF_ID)
    references MANIF_ENT(MANIF_ENT_ID);

/**
 * Work2Item
 */
-- source Work
alter table WORK2ITEM
  add index FK_W2I_SOURCE (SOURCE_WORK_ID),
  add constraint FK_W2I_SOURCE
    foreign key (SOURCE_WORK_ID)
    references WORK_ENT(WORK_ENT_ID);
-- target Item
alter table WORK2ITEM
  add index FK_W2I_TARGET (TARGET_ITEM_ID),
  add constraint FK_W2I_TARGET
    foreign key (TARGET_ITEM_ID)
    references ITEM_ENT(ITEM_ENT_ID);

/**
 * Work2Respon
 */
-- source Work
alter table WORK2RESPON
  add index FK_W2R_SOURCE (SOURCE_WORK_ID),
  add constraint FK_W2R_SOURCE
    foreign key (SOURCE_WORK_ID)
    references WORK_ENT(WORK_ENT_ID);
-- target ResponsibleParty
alter table WORK2RESPON
  add index FK_W2R_TARGET (TARGET_RESPON_ID),
  add constraint FK_W2R_TARGET
    foreign key (TARGET_RESPON_ID)
    references RESPON_ENT(RESPON_ENT_ID);

/**
 * Work2Subj
 */
-- source Work
alter table WORK2SUBJ
  add index FK_W2S_SOURCE (SOURCE_WORK_ID),
  add constraint FK_W2S_SOURCE
    foreign key (SOURCE_WORK_ID)
    references WORK_ENT(WORK_ENT_ID);
-- target Subject
alter table WORK2SUBJ
  add index FK_W2S_TARGET (TARGET_SUBJ_ID),
  add constraint FK_W2S_TARGET
    foreign key (TARGET_SUBJ_ID)
    references SUBJ_ENT(SUBJ_ENT_ID);

/**
 * Expr2Work
 */
-- source Expression
alter table EXPR2WORK
  add index FK_E2W_SOURCE (SOURCE_EXPR_ID),
  add constraint FK_E2W_SOURCE
    foreign key (SOURCE_EXPR_ID)
    references EXPR_ENT(EXPR_ENT_ID);
-- target Work
alter table EXPR2WORK
  add index FK_E2W_TARGET (TARGET_WORK_ID),
  add constraint FK_E2W_TARGET
    foreign key (TARGET_WORK_ID)
    references WORK_ENT(WORK_ENT_ID);

/**
 * Expr2Expr
 */
-- source Expression
alter table EXPR2EXPR
  add index FK_E2E_SOURCE (SOURCE_EXPR_ID),
  add constraint FK_E2E_SOURCE
    foreign key (SOURCE_EXPR_ID)
    references EXPR_ENT(EXPR_ENT_ID);
-- target Expression
alter table EXPR2EXPR
  add index FK_E2E_TARGET (TARGET_EXPR_ID),
  add constraint FK_E2E_TARGET
    foreign key (TARGET_EXPR_ID)
    references EXPR_ENT(EXPR_ENT_ID);

/**
 * Expr2Manif
 */
-- source Expression
alter table EXPR2MANIF
  add index FK_E2M_SOURCE (SOURCE_EXPR_ID),
  add constraint FK_E2M_SOURCE
    foreign key (SOURCE_EXPR_ID)
    references EXPR_ENT(EXPR_ENT_ID);
-- target Manifestation
alter table EXPR2MANIF
  add index FK_E2M_TARGET (TARGET_MANIF_ID),
  add constraint FK_E2M_TARGET
    foreign key (TARGET_MANIF_ID)
    references MANIF_ENT(MANIF_ENT_ID);

/**
 * Expr2Respon
 */
-- source Expression
alter table EXPR2RESPON
  add index FK_E2R_SOURCE (SOURCE_EXPR_ID),
  add constraint FK_E2R_SOURCE
    foreign key (SOURCE_EXPR_ID)
    references EXPR_ENT(EXPR_ENT_ID);
-- target ResponsibleParty
alter table EXPR2RESPON
  add index FK_E2R_TARGET (TARGET_RESPON_ID),
  add constraint FK_E2R_TARGET
    foreign key (TARGET_RESPON_ID)
    references RESPON_ENT(RESPON_ENT_ID);

/**
 * Manif2Manif
 */
-- source Manifestation
alter table MANIF2MANIF
  add index FK_M2M_SOURCE (SOURCE_MANIF_ID),
  add constrainT FK_M2M_SOURCE
    foreign key (SOURCE_MANIF_ID)
    references MANIF_ENT(MANIF_ENT_ID);
-- target Manifestation
alter table MANIF2MANIF
  add index FK_M2M_TARGET (TARGET_MANIF_ID),
  add constraint FK_M2M_TARGET
    foreign key (TARGET_MANIF_ID)
    references MANIF_ENT(MANIF_ENT_ID);

/**
 * Manif2Item
 */
-- source Manifestation
alter table MANIF2ITEM
  add index FK_M2I_SOURCE (SOURCE_MANIF_ID),
  add constraint FK_M2I_SOURCE
    foreign key (SOURCE_MANIF_ID)
    references MANIF_ENT(MANIF_ENT_ID);
-- target Item
alter table MANIF2ITEM
  add index FK_M2I_TARGET (TARGET_ITEM_ID),
  add constraint FK_M2I_TARGET
    foreign key (TARGET_ITEM_ID)
    references ITEM_ENT(ITEM_ENT_ID);

/**
 * Manif2Respon
 */
-- source Manifestation
alter table MANIF2RESPON
  add index FK_M2R_SOURCE (SOURCE_MANIF_ID),
  add constraint FK_M2R_SOURCE
    foreign key (SOURCE_MANIF_ID)
    references MANIF_ENT(MANIF_ENT_ID);
-- target ResponsibleParty
alter table MANIF2RESPON
  add index FK_M2R_TARGET (TARGET_RESPON_ID),
  add constraint FK_M2R_TARGET
    foreign key (TARGET_RESPON_ID)
    references RESPON_ENT(RESPON_ENT_ID);

/**
 * Item2Item
 */
-- source Item
alter table ITEM2ITEM
  add index FK_I2I_SOURCE (SOURCE_ITEM_ID),
  add constraint FK_I2I_SOURCE
    foreign key (SOURCE_ITEM_ID)
    references ITEM_ENT(ITEM_ENT_ID);
-- target Item
alter table ITEM2ITEM
  add index FK_I2I_TARGET (TARGET_ITEM_ID),
  add constraint FK_I2I_TARGET
    foreign key (TARGET_ITEM_ID)
    references ITEM_ENT(ITEM_ENT_ID);

/**
 * Item2Respon
 */
-- source Item
alter table ITEM2RESPON
  add index FK_I2R_SOURCE (SOURCE_ITEM_ID),
  add constraint FK_I2R_SOURCE
    foreign key (SOURCE_ITEM_ID)
    references ITEM_ENT(ITEM_ENT_ID);
-- target ResponsibleParty
alter table ITEM2RESPON
  add index FK_I2R_TARGET (TARGET_RESPON_ID),
  add constraint FK_I2R_TARGET
    foreign key (TARGET_RESPON_ID)
    references RESPON_ENT(RESPON_ENT_ID);

/**
 * Respon2Respon
 */
-- source ResponsibleParty
alter table RESPON2RESPON
  add index FK_R2R_SOURCE (SOURCE_RESPON_ID),
  add constraint FK_R2R_SOURCE
    foreign key (SOURCE_RESPON_ID)
    references RESPON_ENT(RESPON_ENT_ID);
-- target ResponsibleParty
alter table RESPON2RESPON
  add index FK_R2R_TARGET (TARGET_RESPON_ID),
  add constraint FK_R2R_TARGET
    foreign key (TARGET_RESPON_ID)
    references RESPON_ENT(RESPON_ENT_ID);
-- --
