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
 * drop all tables
 * attributes, then entity
 */

/**
 * Common entity attributes
 */
drop table if exists ATTRIB;

/**
 * Work
 */
drop table if exists WORK_ATTRIB;
drop table if exists WORK_ENT;

/**
 * Expression
 */
drop table if exists EXPR_ATTRIB;
drop table if exists EXPR_ENT;

/**
 * Manifestation
 */
drop table if exists MANIF_PUB;
drop table if exists MANIF_PUB_ATTRIB;
drop table if exists MANIF_ATTRIB;
drop table if exists MANIF_ENT;

/**
 * Item
 */
drop table if exists ITEM_ATTRIB;
drop table if exists ITEM_ENT;

/**
 * ResponsibleParty (Group 2)
 */
drop table if exists RESPON_ATTRIB;
drop table if exists RESPON_ENT;

/**
 * Subjects (Group 3)
 */
drop table if exists SUBJ_ATTRIB;
drop table if exists SUBJ_ENT;

/**
 * Relationships
 */
-- Work sourced relations
drop table if exists WORK2WORK;
drop table if exists WORK2EXPR;
drop table if exists WORK2MANIF;
drop table if exists WORK2ITEM;
drop table if exists WORK2RESPON;
drop table if exists WORK2SUBJ;
-- Expression sourced relations
drop table if exists EXPR2WORK;
drop table if exists EXPR2EXPR;
drop table if exists EXPR2MANIF;
drop table if exists EXPR2RESPON;
-- Manifestation sourced relations
drop table if exists MANIF2MANIF;
drop table if exists MANIF2ITEM;
drop table if exists MANIF2RESPON;
-- Item sourced relations
drop table if exists ITEM2ITEM;
drop table if exists ITEM2RESPON;
-- ResponsibleParty sourced relations
drop table if exists RESPON2RESPON;
-- --
