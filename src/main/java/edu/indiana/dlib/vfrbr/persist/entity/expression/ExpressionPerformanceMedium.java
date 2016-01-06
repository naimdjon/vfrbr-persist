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
package edu.indiana.dlib.vfrbr.persist.entity.expression;

import edu.indiana.dlib.vfrbr.persist.entity.attrib.AttribVocabQuant;

import javax.persistence.*;

/**
 *  mediumOfPerformance
 */
@Entity
@DiscriminatorValue("ExpressionPerformanceMedium")
public class ExpressionPerformanceMedium
        extends ExpressionAttribSimple
        implements AttribVocabQuant {

    @Column(name = "VOCAB_VAL",
            length = 64)
    protected String vocabulary;

    @Column(name = "QUANT_VAL",
            length = 64)
    protected int quantity;

    public ExpressionPerformanceMedium() {
    }

    public ExpressionPerformanceMedium(ExpressionJpa expression) {
        this.setExpression(expression);
    }

    public ExpressionPerformanceMedium(ExpressionJpa expression,
                                       String text) {
        this.setExpression(expression);
        this.setText(text);
    }

    public ExpressionPerformanceMedium(ExpressionJpa expression,
                                       String text,
                                       int listOrder) {
        this.setExpression(expression);
        this.setText(text);
        this.setListOrder(listOrder);
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
     * @return the quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * @param quantity the quantity to set
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
