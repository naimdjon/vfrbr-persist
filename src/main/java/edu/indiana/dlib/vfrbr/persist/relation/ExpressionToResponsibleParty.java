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

import edu.indiana.dlib.vfrbr.persist.entity.expression.ExpressionJpa;
import edu.indiana.dlib.vfrbr.persist.entity.responsibleparty.ResponsiblePartyJpa;
import java.io.Serializable;
import javax.persistence.*;

/**
 *  ExpressionToResponsibleParty relation.
 * ResponsiblePartyJpa should be realized by subclasses
 * of Person, CorporateBody, or Family.
 */
@Entity
@Table(name = "EXPR2RESPON")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "REL_CLASS",
                     discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("ExpressionToResponsibleParty")
public class ExpressionToResponsibleParty
        implements Serializable,
                   VfrbrRelation {

    /*
     * Initially, "realizedBy" is the only type of this relationship.
     * If further types are developed, see WorkToResponsibleParty
     * for the pattern for subclassing for multiple relation types.
     */

    /** Persistence id */
    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "EXPR2RESPON_ID")
    protected int id;

    /** Persistence version */
    @Version
    @Column(name = "EXPR2RESPON_VERSION")
    protected int version;

    /** the "has" type of relation */
    @Column(name = "REL_TYPE")
    protected String relType;

    /** responsiblity role within the relation type */
    @Column(name = "REL_ROLE")
    protected String relRole;

    /** category within the relation type */
    @Column(name = "REL_CATEGORY")
    protected String relCategory;

    /** Listing order of List of ExpressionToWork */
    @Column(name = "REL_LIST_ORDER")
    protected int listOrder;

    /** Source ExpressionJpa */
    @ManyToOne(cascade = {CascadeType.PERSIST,
                          CascadeType.MERGE,
                          CascadeType.REFRESH})
    @JoinColumn(name = "SOURCE_EXPR_ID",
                referencedColumnName = "EXPR_ENT_ID")
    protected ExpressionJpa sourceExpression;

    /** Target ResponsiblePartyJpa */
    @ManyToOne(cascade = {CascadeType.PERSIST,
                          CascadeType.MERGE,
                          CascadeType.REFRESH})
    @JoinColumn(name = "TARGET_RESPON_ID",
                referencedColumnName = "RESPON_ENT_ID")
    protected ResponsiblePartyJpa targetResponsibleParty;

    /**
     * Simple constructor.
     */
    public ExpressionToResponsibleParty() {

        this.relType = "realizedBy";
    }

    /**
     *  Parametered constructor.
     * @param expr ExpressionJpa source expression.
     * @param respon ResponsiblePartyJpa target responsible party.
     * @param listOrder int list order.
     * @param relType String relation type.
     */
    public ExpressionToResponsibleParty(ExpressionJpa expr,
                                        ResponsiblePartyJpa respon,
                                        int listOrder,
                                        String relRole) {

        this.sourceExpression = expr;
        this.targetResponsibleParty = respon;
        this.listOrder = listOrder;
        this.relType = "realizedBy";
        this.relRole = relRole;
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
     * @return the sourceExpression
     */
    public ExpressionJpa getSourceExpression() {
        return sourceExpression;
    }

    /**
     * @param sourceExpression the sourceExpression to set
     */
    public void setSourceExpression(ExpressionJpa sourceExpression) {
        this.sourceExpression = sourceExpression;
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
