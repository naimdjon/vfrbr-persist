/**
 * Copyright 2009-2011, Trustees of Indiana University
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 *   Redistributions of source code must retain the above copyright notice,
 *   this list of conditions and the following disclaimer.
 *
 *   Redistributions in binary form must reproduce the above copyright notice,
 *   this list of conditions and the following disclaimer in the documentation
 *   and/or other materials provided with the distribution.
 *
 *   Neither the name of Indiana University nor the names of its
 *   contributors may be used to endorse or promote products derived from this
 *   software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 */
package edu.indiana.dlib.vfrbr.persist.relation;

import edu.indiana.dlib.vfrbr.persist.entity.manifestation.ManifestationJpa;
import edu.indiana.dlib.vfrbr.persist.entity.responsibleparty.ResponsiblePartyJpa;
import java.io.Serializable;
import javax.persistence.*;

/**
 *  ManifestationToResponsibleParty relation.
 * ResponsiblePartyJpa should be realized by subclasses
 * of Person, CorporateBody, or Family.
 */
@Entity
@Table(name = "MANIF2RESPON")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "REL_CLASS",
                     discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("ManifestationToResponsibleParty")
public class ManifestationToResponsibleParty
        implements Serializable,
                   VfrbrRelation {

    /*
     * Initially, "producedBy" is the only type of this relationship.
     * If further types are developed, see WorkToResponsibleParty
     * for the pattern for subclassing for multiple relation types.
     */

    /** Persistence id */
    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MANIF2RESPON_ID")
    protected int id;

    /** Persistence version */
    @Version
    @Column(name = "MANIF2RESPON_VERSION")
    protected int version;

    /** The "has" type of relation. */
    @Column(name = "REL_TYPE")
    protected String relType;

    /** Responsiblity role within the relation type. */
    @Column(name = "REL_ROLE")
    protected String relRole;

    /** Category of relationship type. */
    @Column(name = "REL_CATEGORY")
    protected String relCategory;

    /** Listing order */
    @Column(name = "REL_LIST_ORDER")
    protected int listOrder;

    /** Source ManifestationJpa */
    @ManyToOne(cascade = {CascadeType.PERSIST,
                          CascadeType.MERGE,
                          CascadeType.REFRESH})
    @JoinColumn(name = "SOURCE_MANIF_ID",
                referencedColumnName = "MANIF_ENT_ID",
                nullable = false)
    protected ManifestationJpa sourceManifestation;

    /** Target ResponsiblePartyJpa */
    @ManyToOne(cascade = {CascadeType.PERSIST,
                          CascadeType.MERGE,
                          CascadeType.REFRESH})
    @JoinColumn(name = "TARGET_RESPON_ID",
                referencedColumnName = "RESPON_ENT_ID",
                nullable = false)
    protected ResponsiblePartyJpa targetResponsibleParty;

    /**
     * Simple constructor.
     */
    public ManifestationToResponsibleParty() {

        this.relType = "producedBy";
    }

    public ManifestationToResponsibleParty(ManifestationJpa manif,
                                           ResponsiblePartyJpa respon,
                                           int listOrder,
                                           String relType) {
        this.sourceManifestation = manif;
        this.targetResponsibleParty = respon;
        this.listOrder = listOrder;
        this.relType = relType;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @return the version
     */
    public int getVersion() {
        return version;
    }

    /**
     * @return the relType
     */
    public String getRelType() {
        return relType;
    }

    /**
     * @param relType the relType to set
     */
    public void setRelType(String relType) {
        this.relType = relType;
    }

    /**
     * @return the relRole
     */
    public String getRelRole() {
        return relRole;
    }

    /**
     * @param relRole the relRole to set
     */
    public void setRelRole(String relRole) {
        this.relRole = relRole;
    }

    /**
     * @return the relCategory
     */
    public String getRelCategory() {
        return relCategory;
    }

    /**
     * @param relCategory the relCategory to set
     */
    public void setRelCategory(String relCategory) {
        this.relCategory = relCategory;
    }

    /**
     * @return the listOrder
     */
    public int getListOrder() {
        return listOrder;
    }

    /**
     * @param listOrder the listOrder to set
     */
    public void setListOrder(int listOrder) {
        this.listOrder = listOrder;
    }

    /**
     * @return the sourceManifestation
     */
    public ManifestationJpa getSourceManifestation() {
        return sourceManifestation;
    }

    /**
     * @param sourceManifestation the sourceManifestation to set
     */
    public void setSourceManifestation(ManifestationJpa sourceManifestation) {
        this.sourceManifestation = sourceManifestation;
    }

    /**
     * @return the targetResponsibleParty
     */
    public ResponsiblePartyJpa getTargetResponsibleParty() {
        return targetResponsibleParty;
    }

    /**
     * @param targetResponsibleParty the targetResponsibleParty to set
     */
    public void setTargetResponsibleParty(
            ResponsiblePartyJpa targetResponsibleParty) {
        this.targetResponsibleParty = targetResponsibleParty;
    }
}
