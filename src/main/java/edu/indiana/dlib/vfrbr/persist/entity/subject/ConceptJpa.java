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

import java.util.List;
import java.util.ArrayList;
import javax.persistence.*;

/**
 *  Concept type of SubjectJpa
 */
@Entity
@DiscriminatorValue("Concept")
public class ConceptJpa
        extends SubjectJpa {

    /**
     *  termForTheConcept
     * (FRBR).
     */
    @OneToMany(cascade = {CascadeType.ALL},
               mappedBy = "subject")
    @OrderBy("listOrder ASC")
    private List<ConceptTerm> terms =
            new ArrayList<ConceptTerm>();

    /**
     *  note
     * (VFRBR).
     */
    @OneToMany(cascade = {CascadeType.ALL},
               mappedBy = "subject")
    @OrderBy("listOrder ASC")
    private List<ConceptNote> notes =
            new ArrayList<ConceptNote>();

    public ConceptJpa() {
    }

    /**
     * @return the terms
     */
    public List<ConceptTerm> getTerms() {
        return terms;
    }

    /**
     * @param terms the terms to List
     */
    public void ListTerms(List<ConceptTerm> terms) {
        this.terms = terms;
    }

    /**
     * @return the notes
     */
    public List<ConceptNote> getNotes() {
        return notes;
    }

    /**
     * @param notes the notes to List
     */
    public void ListNotes(List<ConceptNote> notes) {
        this.notes = notes;
    }
}
