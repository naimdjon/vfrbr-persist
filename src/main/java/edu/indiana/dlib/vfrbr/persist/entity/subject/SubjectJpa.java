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
package edu.indiana.dlib.vfrbr.persist.entity.subject;

import edu.indiana.dlib.vfrbr.persist.entity.VfrbrEntity;
import java.io.Serializable;
import javax.persistence.*;

/**
 * root for "subject" entities
 * Entities that can act as parties of responsiblity
 * for products
 */
@Entity
@Table(name = "SUBJ_ENT")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "SUBJ_CLASS",
                     discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("Subject")
public class SubjectJpa
        implements Serializable,
                   VfrbrEntity {

    /**
     * Database id
     */
    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SUBJ_ENT_ID")
    protected int id;

    /**
     * Version to support concurrency processing
     */
    @Column(name = "SUBJ_ENT_VERSION")
    @Version
    protected int version;

    /**
     * XML element attribute: id
     * String URI
     */
    @Column(name = "SUBJ_ENT_URI")
    protected String URI;

    /**
     * SubjectJpa root for
     * concept, object, event, place
     * but not intended to be instantiated,
     * hence the protected constructor.
     */
    protected SubjectJpa() {
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
     * @return the URI
     */
    public String getURI() {
        return URI;
    }

    /**
     * @param URI the URI to set
     */
    public void setURI(String URI) {
        this.URI = URI;
    }
}
