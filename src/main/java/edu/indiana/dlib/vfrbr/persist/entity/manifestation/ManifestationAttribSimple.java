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
package edu.indiana.dlib.vfrbr.persist.entity.manifestation;

import edu.indiana.dlib.vfrbr.persist.entity.attrib.AttribSimple;

import java.io.Serializable;
import javax.persistence.*;

/**
 *  Simple attribute type for Manifestation entity.
 */
@Entity
@Table(name = "MANIF_ATTRIB")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "MANIF_ATTRIB_CLASS",
                     discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("Simple")
public class ManifestationAttribSimple
        implements Serializable,
                   AttribSimple {

    /*
     * fields intended to be inherited
     * are declared protected
     * to allow inheritable field access
     */
    /*
     * --------- persistence fields
     */
    /**
     * The persistence identifier for this attribute.
     */
    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MANIF_ATTRIB_ID")
    protected int id;

    /**
     * Version support to concurrency protection
     */
    @Column(name = "MANIF_ATTRIB_VERSION")
    @Version
    protected int version;

    /*
     * --------- generic (simple) property fields
     */
    /**
     * Order for the list of attributes.
     */
    @Column(name = "ATTRIB_LIST_ORDER")
    protected int listOrder;

    /**
     *  The text content of the attribute.
     */
    @Column(name = "TEXT_VAL",
            length = 20480)
    protected String text;

    /*
     * --------- owning entity backlink
     */
    /**
     * The Manifestation entity owner of this attribute.
     */
    @ManyToOne
    @JoinColumn(name = "MANIF_ENT_ID",
                referencedColumnName = "MANIF_ENT_ID")
    protected ManifestationJpa manifestation;

    /**
     * not intended to be instantiated
     */
    protected ManifestationAttribSimple() {
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
     * @return the text
     */
    public String getText() {
        return text;
    }

    /**
     * @param text the text to set
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * @return the manifestation
     */
    public ManifestationJpa getManifestation() {
        return manifestation;
    }

    /**
     * @param manifestation the manifestation to set
     */
    public void setManifestation(ManifestationJpa manifestation) {
        this.manifestation = manifestation;
    }
    // TODO implement equals()
    // TODO implement hashcode()
}
