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

import edu.indiana.dlib.vfrbr.persist.entity.attrib.AttribVocabNormal;

import javax.persistence.*;

/**
 *  callNumber
 * (VFRBR)
 */
@Entity
@DiscriminatorValue("ItemCallNumber")
public class ItemCallNumber
        extends ItemAttribSimple
        implements AttribVocabNormal {

    @Column(name = "VOCAB_VAL",
            length = 64)
    private String vocabulary;

    @Column(name = "NORMAL_VAL",
            length = 64)
    private String normal;

    public ItemCallNumber() {
    }

    public ItemCallNumber(ItemJpa item) {
        this.setItem(item);
    }

    public ItemCallNumber(ItemJpa item,
                          String text) {
        this.setItem(item);
        this.setText(text);
    }

    /**
     * @return the vocabulary
     */
    public String getVocabulary() {
        return vocabulary;
    }

    /**
     * @param vocabulary the vocabulary to set
     */
    public void setVocabulary(String vocabulary) {
        this.vocabulary = vocabulary;
    }

    /**
     * @return the normal
     */
    public String getNormal() {
        return normal;
    }

    /**
     * @param normal the normal to set
     */
    public void setNormal(String normal) {
        this.normal = normal;
    }
    /*
     * cardinality for this attribute is 0-1
     * hence no constructor with listOrder
     */
}
