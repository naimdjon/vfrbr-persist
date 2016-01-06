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
package edu.indiana.dlib.vfrbr.persist.entity.responsibleparty;

import java.util.List;
import java.util.ArrayList;
import javax.persistence.*;

/**
 *  FamilyJpa ResponsiblePartyJpa
 */
@Entity
@DiscriminatorValue("Family")
public class FamilyJpa
        extends ResponsiblePartyJpa {

    /*
     *     ------------------
     * ---- attribute fields
     *     ------------------
     */
    /**
     *  typeOfFamily
     * (FRAD).
     */
    @OneToOne(cascade = {CascadeType.ALL},
               mappedBy = "responsibleParty")
    protected FamilyType type;

    /**
     *  datesOfFamily
     * (FRAD).
     */
    @OneToMany(cascade = {CascadeType.ALL},
               mappedBy = "responsibleParty")
    @OrderBy("listOrder ASC")
    protected List<FamilyDate> dates =
            new ArrayList<FamilyDate>();

    /**
     *  placesAssociatedWithFamily
     * (FRAD).
     */
    @OneToMany(cascade = {CascadeType.ALL},
               mappedBy = "responsibleParty")
    @OrderBy("listOrder ASC")
    protected List<FamilyPlace> places =
            new ArrayList<FamilyPlace>();

    /**
     *  fieldOfActivity
     * (FRAD).
     */
    @OneToMany(cascade = {CascadeType.ALL},
               mappedBy = "responsibleParty")
    @OrderBy("listOrder ASC")
    protected List<FamilyActivityField> activityFields =
            new ArrayList<FamilyActivityField>();

    /**
     *  historyOfFamily
     * (FRAD).
     */
    @OneToMany(cascade = {CascadeType.ALL},
               mappedBy = "responsibleParty")
    @OrderBy("listOrder ASC")
    protected List<FamilyHistory> histories =
            new ArrayList<FamilyHistory>();

    /**
     *  note
     * (VFRBR).
     */
    @OneToMany(cascade = {CascadeType.ALL},
               mappedBy = "responsibleParty")
    @OrderBy("listOrder ASC")
    protected List<FamilyNote> notes =
            new ArrayList<FamilyNote>();

    /*
     *     ---------------------
     * ---- relationship fields
     *     ---------------------
     */

    public FamilyJpa() {
    }

    /**
     * @return the type
     */
    public FamilyType getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(FamilyType type) {
        this.type = type;
    }

    /**
     * @return the dates
     */
    public List<FamilyDate> getDates() {
        return dates;
    }

    /**
     * @param dates the dates to set
     */
    public void setDates(List<FamilyDate> dates) {
        this.dates = dates;
    }

    /**
     * @return the places
     */
    public List<FamilyPlace> getPlaces() {
        return places;
    }

    /**
     * @param places the places to set
     */
    public void setPlaces(List<FamilyPlace> places) {
        this.places = places;
    }

    /**
     * @return the activityFields
     */
    public List<FamilyActivityField> getActivityFields() {
        return activityFields;
    }

    /**
     * @param activityFields the activityFields to set
     */
    public void setActivityFields(List<FamilyActivityField> activityFields) {
        this.activityFields = activityFields;
    }

    /**
     * @return the histories
     */
    public List<FamilyHistory> getHistories() {
        return histories;
    }

    /**
     * @param histories the histories to set
     */
    public void setHistories(List<FamilyHistory> histories) {
        this.histories = histories;
    }

    /**
     * @return the notes
     */
    public List<FamilyNote> getNotes() {
        return notes;
    }

    /**
     * @param notes the notes to set
     */
    public void setNotes(List<FamilyNote> notes) {
        this.notes = notes;
    }
}
