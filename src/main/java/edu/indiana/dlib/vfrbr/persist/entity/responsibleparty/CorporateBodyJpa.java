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

import edu.indiana.dlib.vfrbr.persist.relation.ExpressionToResponsibleParty;
import edu.indiana.dlib.vfrbr.persist.relation.ManifestationToResponsibleParty;
import edu.indiana.dlib.vfrbr.persist.relation.WorkToResponsibleParty;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

/**
 *  CorporateBodyJpa ResponsiblePartyJpa
 */
@Entity
@DiscriminatorValue("CorporateBody")
public class CorporateBodyJpa
        extends ResponsiblePartyJpa {

    /*
     *     ------------------
     * ---- attribute fields
     *     ------------------
     */
    /**
     *  nameOfTheCorporateBody
     * (FRBR).
     */
    @OneToMany(cascade = {CascadeType.ALL},
               mappedBy = "responsibleParty")
    @OrderBy("listOrder ASC")
    protected List<CorporateBodyName> names =
            new ArrayList<CorporateBodyName>();

    /**
     *  numberAssociatedWithTheCorporateBody
     * (FRBR).
     */
    @OneToMany(cascade = {CascadeType.ALL},
               mappedBy = "responsibleParty")
    @OrderBy("listOrder ASC")
    protected List<CorporateBodyNumber> numbers =
            new ArrayList<CorporateBodyNumber>();

    /**
     *  placeAssociatedWithTheCorporateBody
     * (FRBR).
     */
    @OneToMany(cascade = {CascadeType.ALL},
               mappedBy = "responsibleParty")
    @OrderBy("listOrder ASC")
    protected List<CorporateBodyPlace> places =
            new ArrayList<CorporateBodyPlace>();

    /**
     *  dateAssociatedWithTheCorporateBody
     * (FRBR).
     */
    @OneToMany(cascade = {CascadeType.ALL},
               mappedBy = "responsibleParty")
    @OrderBy("listOrder ASC")
    protected List<CorporateBodyDate> dates =
            new ArrayList<CorporateBodyDate>();

    /**
     *  otherDesignationAssociatedWithTheCorporateBody
     * (FRBR).
     */
    @OneToMany(cascade = {CascadeType.ALL},
               mappedBy = "responsibleParty")
    @OrderBy("listOrder ASC")
    protected List<CorporateBodyDesignation> designations =
            new ArrayList<CorporateBodyDesignation>();

    /**
     *  lanaguageOfTheCorporateBody
     * (FRAD).
     */
    @OneToMany(cascade = {CascadeType.ALL},
               mappedBy = "responsibleParty")
    @OrderBy("listOrder ASC")
    protected List<CorporateBodyLanguage> languages =
            new ArrayList<CorporateBodyLanguage>();

    /**
     *  address
     * (FRAD).
     */
    @OneToMany(cascade = {CascadeType.ALL},
               mappedBy = "responsibleParty")
    @OrderBy("listOrder ASC")
    protected List<CorporateBodyAddress> addresses =
            new ArrayList<CorporateBodyAddress>();

    /**
     *  fieldOfActivity
     * (FRAD).
     */
    @OneToMany(cascade = {CascadeType.ALL},
               mappedBy = "responsibleParty")
    @OrderBy("listOrder ASC")
    protected List<CorporateBodyActivityField> activityFields =
            new ArrayList<CorporateBodyActivityField>();

    /**
     *  history
     * (FRAD).
     */
    @OneToMany(cascade = {CascadeType.ALL},
               mappedBy = "responsibleParty")
    @OrderBy("listOrder ASC")
    protected List<CorporateBodyHistory> histories =
            new ArrayList<CorporateBodyHistory>();

    /**
     *  note
     * (VFRBR).
     */
    @OneToMany(cascade = {CascadeType.ALL},
               mappedBy = "responsibleParty")
    @OrderBy("listOrder ASC")
    protected List<CorporateBodyNote> notes =
            new ArrayList<CorporateBodyNote>();

    /*
     *     ---------------------
     * ---- relationship fields
     *     ---------------------
     */

    /* -- creator --
     *  WorkToResponsibleParty
     * Work to <CorporateBodyJpa>
     */
    /**
     * CorporateBodyJpa isCreator for Work.
     * Target side of Creator
     * WorkToResponsibilityParty relationship
     * for CorporateBodyJpa.
     */
    // TODO -- CorporateBodyJpa isCreator for Work
    //

    /* -- composer --
     *  WorkToResponsibleParty
     * Work to CorporateBodyJpa
     */
    /**
     * CorporateBodyJpa isComposer for Work.
     * Target end of Composer
     * WorkToResponsibleParty relationship
     * for CorporteBodyJpa.
     */
    @OneToMany(cascade = {CascadeType.PERSIST,
                          CascadeType.MERGE,
                          CascadeType.REFRESH},
               mappedBy = "targetResponsibleParty")
    @OrderBy("listOrder ASC")
    protected List<WorkToResponsibleParty> isComposerOfWorks =
            new ArrayList<WorkToResponsibleParty>();

    /* -- member --
     *  CorporateBodyToPerson
     */
    /**
     * CorporateBodyJpa hasMember of Person./
     * Owner side of Member
     * CorporateBodyToPerson relationship.
     */
    // TODO -- CorporateBodyJpa hasMember of Person
    //

    /* -- owner --
     *  ItemToResponsibleParty
     * Item to <CorporateBodyJpa>
     */
    /**
     * CorporateBodyJpa isOwner for Item.
     * Target end of Owner
     * ItemToResponsibileParty relationship
     * for CorporateBodyJpa.
     */
    // TODO -- CorporateBodyJpa isOwner from Item
    //

    /* -- part --
     *  CorporateBodyToCorporateBody
     */
    /**
     * CorporateBodyJpa hasPart of CorporateBodyJpa.
     * Source side of Part
     * CorporateBodyToCorporateBody relationship.
     */
    // TODO -- CorporateBodyJpa hasPart of CorporateBodyJpa
    //
    /**
     * CorporateBodyJpa isPart for CorporateBodyJpa.
     * Target side of Part
     * CorporateBodyToCorporateBody relationship.
     */
    // TODO -- CorporateBodyJpa isPart for CorporateBodyJpa

    /* -- producer --
     *  ManifestationToResponsibleParty
     * Manifestation to <CorporateBodyJpa>
     */
    /**
     * CorporateBodyJpa isProducer for Manifestation.
     * Target end of Producer
     * ManifestationToResponsibleParty relationship
     * for CorporateBodyJpa.
     */
    @OneToMany(cascade = {CascadeType.PERSIST,
                          CascadeType.MERGE,
                          CascadeType.REFRESH},
               mappedBy = "targetResponsibleParty")
    @OrderBy("listOrder ASC")
    protected List<ManifestationToResponsibleParty> isProducerOfManifestations =
            new ArrayList<ManifestationToResponsibleParty>();

    /* -- realizer --
     *  ExpressionToResponsibleParty
     * Expression to <CorporateBodyJpa>
     */
    /**
     * CorporateBodyJpa isRealizer for Expression.
     * Target end of Realizer
     * ExpressionToResponsibleParty relationship
     * for CorporateBodyJpa.
     */
    @OneToMany(cascade = {CascadeType.PERSIST,
                          CascadeType.MERGE,
                          CascadeType.REFRESH},
               mappedBy = "targetResponsibleParty")
    @OrderBy("listOrder ASC")
    protected List<ExpressionToResponsibleParty> isRealizerOfExpressions =
            new ArrayList<ExpressionToResponsibleParty>();

    /* -- subject --
     *  WorkToResponsibleParty
     * Work to <CorporateBodyJpa>
     */
    /**
     * CorporateBodyJpa isSubject for Work.
     * Target end of Subject
     * WorkToResponsibleParty relationship
     * for CorporateBodyJpa.
     */
    // TODO -- CorporateBodyJpa isSubject for Work
    //

    /* -- successor --
     *  CorporateBodyToCorporateBody
     */
    /**
     * CorporateBodyJpa hasSuccessor of CorporateBodyJpa.
     * Source side of Successor
     * CorporateBodyToCorporateBody relationship.
     */
    // TODO -- CorporateBodyJpa hasSuccesor of CorporateBodyJpa
    //
    /**
     * CorporateBodyJpa isSuccessor for CorporateBodyJpa.
     * Target side of Successor
     * CorporateBodyToCorporateBody relationship.
     */
    // TODO -- CorporateBodyJpa isSuccessor for CorporateBodyJpa
    //
    /**
     * Simple constructor
     */
    public CorporateBodyJpa() {
    }

    /**
     * @return the names
     */
    public List<CorporateBodyName> getNames() {
        return names;
    }

    /**
     * @param names the names to set
     */
    public void setNames(List<CorporateBodyName> names) {
        this.names = names;
    }

    /**
     * @return the numbers
     */
    public List<CorporateBodyNumber> getNumbers() {
        return numbers;
    }

    /**
     * @param numbers the numbers to set
     */
    public void setNumbers(List<CorporateBodyNumber> numbers) {
        this.numbers = numbers;
    }

    /**
     * @return the places
     */
    public List<CorporateBodyPlace> getPlaces() {
        return places;
    }

    /**
     * @param places the places to set
     */
    public void setPlaces(List<CorporateBodyPlace> places) {
        this.places = places;
    }

    /**
     * @return the dates
     */
    public List<CorporateBodyDate> getDates() {
        return dates;
    }

    /**
     * @param dates the dates to set
     */
    public void setDates(List<CorporateBodyDate> dates) {
        this.dates = dates;
    }

    /**
     * @return the designations
     */
    public List<CorporateBodyDesignation> getDesignations() {
        return designations;
    }

    /**
     * @param designations the designations to set
     */
    public void setDesignations(List<CorporateBodyDesignation> designations) {
        this.designations = designations;
    }

    /**
     * @return the languages
     */
    public List<CorporateBodyLanguage> getLanguages() {
        return languages;
    }

    /**
     * @param languages the languages to set
     */
    public void setLanguages(List<CorporateBodyLanguage> languages) {
        this.languages = languages;
    }

    /**
     * @return the addresses
     */
    public List<CorporateBodyAddress> getAddresses() {
        return addresses;
    }

    /**
     * @param addresses the addresses to set
     */
    public void setAddresses(List<CorporateBodyAddress> addresses) {
        this.addresses = addresses;
    }

    /**
     * @return the activityFields
     */
    public List<CorporateBodyActivityField> getActivityFields() {
        return activityFields;
    }

    /**
     * @param activityFields the activityFields to set
     */
    public void setActivityFields(List<CorporateBodyActivityField> activityFields) {
        this.activityFields = activityFields;
    }

    /**
     * @return the histories
     */
    public List<CorporateBodyHistory> getHistories() {
        return histories;
    }

    /**
     * @param histories the histories to set
     */
    public void setHistories(List<CorporateBodyHistory> histories) {
        this.histories = histories;
    }

    /**
     * @return the notes
     */
    public List<CorporateBodyNote> getNotes() {
        return notes;
    }

    /**
     * @param notes the notes to set
     */
    public void setNotes(List<CorporateBodyNote> notes) {
        this.notes = notes;
    }

    /**
     * CorporateBodyJpa isRealizer for Expression.
     * Target end of Realizer
     * ExpressionToResponsibleParty relationship
     * for CorporateBodyJpa.
     * @return the isRealizerOfExpressions
     */
    public List<ExpressionToResponsibleParty> getIsRealizerOfExpressions() {
        return isRealizerOfExpressions;
    }

    /**
     * CorporateBodyJpa isComposer for Work.
     * Target end of Composer
     * WorkToResponsibleParty relationship
     * for CorporteBodyJpa.
     * @return the isComposerOfWorks
     */
    public List<WorkToResponsibleParty> getIsComposerOfWorks() {
        return isComposerOfWorks;
    }

    /**
     * CorporateBodyJpa isProducer for Manifestation.
     * Target end of Producer
     * ManifestationToResponsibleParty relationship
     * for CorporateBodyJpa.
     * @return the isProducerOfManifestations
     */
    public List<ManifestationToResponsibleParty> getIsProducerOfManifestations() {
        return isProducerOfManifestations;
    }
}
