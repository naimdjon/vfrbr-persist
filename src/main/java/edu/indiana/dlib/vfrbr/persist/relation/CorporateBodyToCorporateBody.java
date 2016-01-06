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

import edu.indiana.dlib.vfrbr.persist.entity.responsibleparty.CorporateBodyJpa;
import javax.persistence.*;

/**
 *  CorporateBodyToCorporateBody relation
 */
@Entity
@DiscriminatorValue("CorporateBodyToCorporateBody")
public class CorporateBodyToCorporateBody
        extends ResponsiblePartyToResponsibleParty {

    /** Source CorporateBodyJpa */
    @ManyToOne(cascade = {CascadeType.PERSIST,
                          CascadeType.MERGE,
                          CascadeType.REFRESH})
    @JoinColumn(name = "SOURCE_RESPON_ID",
                referencedColumnName = "RESPON_ENT_ID",
                nullable = false)
    protected CorporateBodyJpa sourceCorporateBody;

    /** Target CorporateBodyJpa */
    @ManyToOne(cascade = {CascadeType.PERSIST,
                          CascadeType.MERGE,
                          CascadeType.REFRESH})
    @JoinColumn(name = "TARGET_RESPON_ID",
                referencedColumnName = "RESPON_ENT_ID",
                nullable = false)
    protected CorporateBodyJpa targetCorporateBody;

    /**
     * Simple constructor.
     */
    public CorporateBodyToCorporateBody() {
    }

    /**
     * @return the sourceCorporateBody
     */
    public CorporateBodyJpa getSourceCorporateBody() {
        return sourceCorporateBody;
    }

    /**
     * @param sourceCorporateBody the sourceCorporateBody to set
     */
    public void setSourceCorporateBody(CorporateBodyJpa sourceCorporateBody) {
        this.sourceCorporateBody = sourceCorporateBody;
    }

    /**
     * @return the targetCorporateBody
     */
    public CorporateBodyJpa getTargetCorporateBody() {
        return targetCorporateBody;
    }

    /**
     * @param targetCorporateBody the targetCorporateBody to set
     */
    public void setTargetCorporateBody(CorporateBodyJpa targetCorporateBody) {
        this.targetCorporateBody = targetCorporateBody;
    }
}
