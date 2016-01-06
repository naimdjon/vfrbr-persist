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
package edu.indiana.dlib.vfrbr.persist.entity.item;

import edu.indiana.dlib.vfrbr.persist.entity.attrib.AttribSimple;

import java.io.Serializable;
import javax.persistence.*;

/**
 *  Simple attribute type for Work entity.
 */
@Entity
@Table(name = "ITEM_ATTRIB")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "ITEM_ATTRIB_CLASS",
                     discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("Simple")
public class ItemAttribSimple
        implements Serializable,
                   AttribSimple {

    /*
     * --------- owning entity backlink
     */
    /**
     * The Item entity owner of this attribute.
     */
    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ITEM_ATTRIB_ID")
    private int id;

    @Column(name = "ITEM_ATTRIB_VERSION")
    @Version
    private int version;

    @Column(name = "ATTRIB_LIST_ORDER")
    private int listOrder;

    @Column(name = "TEXT_VAL",
            length = 20480)
    private String text;

    @ManyToOne
    @JoinColumn(name = "ITEM_ENT_ID",
                referencedColumnName = "ITEM_ENT_ID")
    private ItemJpa item;

    /**
     * not intended to be instantiated
     */
    protected ItemAttribSimple() {
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
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @param version the version to set
     */
    public void setVersion(int version) {
        this.version = version;
    }

    /**
     * @return the item
     */
    public ItemJpa getItem() {
        return item;
    }

    /**
     * @param item the item to set
     */
    public void setItem(ItemJpa item) {
        this.item = item;
    }
    // TODO implement equals()
    // TODO implement hashcode()
}
