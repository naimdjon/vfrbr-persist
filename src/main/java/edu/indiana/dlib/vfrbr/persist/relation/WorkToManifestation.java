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
import edu.indiana.dlib.vfrbr.persist.entity.work.WorkJpa;
import java.io.Serializable;
import javax.persistence.*;

/**
 *  A WorkToManifestation relation.
 */
@Entity
@Table(name = "WORK2MANIF")
public class WorkToManifestation
        implements Serializable,
                   VfrbrRelation {

    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "WORK2MANIF_ID")
    protected int id;

    @Version
    @Column(name = "WORK2MANIF_VERSION")
    protected int version;

    /** The "has" type of relation. */
    @Column(name = "REL_TYPE")
    protected String relType;

    /** Responsiblity role within the relation type. */
    @Column(name = "REL_ROLE")
    protected String relRole;

    /** Caegory within the relation type. */
    @Column(name = "REL_CATEGORY")
    protected String relCategory;

    @Column(name = "REL_LIST_ORDER")
    protected int listOrder;

    @ManyToOne(cascade = {CascadeType.PERSIST,
                          CascadeType.MERGE,
                          CascadeType.REFRESH})
    @JoinColumn(name = "SOURCE_WORK_ID",
                referencedColumnName = "WORK_ENT_ID")
    protected WorkJpa sourceWork;

    @ManyToOne(cascade = {CascadeType.PERSIST,
                          CascadeType.MERGE,
                          CascadeType.REFRESH})
    @JoinColumn(name = "TARGET_MANIF_ID",
                referencedColumnName = "MANIF_ENT_ID")
    protected ManifestationJpa targetManifestation;

    /**
     * Simple constructor.
     */
    public WorkToManifestation() {
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
     * @return the sourceWork
     */
    public WorkJpa getSourceWork() {
        return sourceWork;
    }

    /**
     * @param sourceWork the sourceWork to set
     */
    public void setSourceWork(WorkJpa sourceWork) {
        this.sourceWork = sourceWork;
    }

    /**
     * @return the targetManifestation
     */
    public ManifestationJpa getTargetManifestation() {
        return targetManifestation;
    }

    /**
     * @param targetManifestation the targetManifestation to set
     */
    public void setTargetManifestation(ManifestationJpa targetManifestation) {
        this.targetManifestation = targetManifestation;
    }
}
