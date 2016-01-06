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

import edu.indiana.dlib.vfrbr.persist.entity.VfrbrEntity;
import edu.indiana.dlib.vfrbr.persist.relation.ManifestationToItem;
import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;
import javax.persistence.*;

/**
 *  ItemJpa entity
 *
 */
@Entity
@Table(name = "ITEM_ENT")
public class ItemJpa
        implements Serializable,
                   VfrbrEntity {

    /*
     *     --------------------
     * ---- persistence fields
     *     --------------------
     */
    /**
     * Database id
     * (Persistence).
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ITEM_ENT_ID")
    protected int id;

    /**
     * Version support for concurrency protection
     * (Persistence).
     */
    @Column(name = "ITEM_ENT_VERSION")
    @Version
    protected int version;

    /*
     *     ------------------
     * ---- attribute fields
     *     ------------------
     */
    /**
     * XML element attribute: identifier
     * of type xsd:anyURI
     * (VFRBR).
     */
    @Column(name = "ITEM_ENT_URI",
            length = 512)
    protected String URI;

    /**
     *  itemIdentifier
     * (FRBR).
     */
    @OneToMany(cascade = {CascadeType.ALL},
               mappedBy = "item")
    @OrderBy("listOrder ASC")
    protected List<ItemIdentifier> identifiers =
            new ArrayList<ItemIdentifier>();

    /**
     *  provenanceOfTheItem
     * (FRBR).
     */
    @OneToMany(cascade = {CascadeType.ALL},
               mappedBy = "item")
    @OrderBy("listOrder ASC")
    protected List<ItemProvenance> provenances =
            new ArrayList<ItemProvenance>();

    /**
     *  marksInscriptions
     * (FRBR).
     */
    @OneToMany(cascade = {CascadeType.ALL},
               mappedBy = "item")
    @OrderBy("listOrder ASC")
    protected List<ItemMark> marks =
            new ArrayList<ItemMark>();

    /**
     *  exhibitionHistory
     * (FRBR).
     */
    @OneToMany(cascade = {CascadeType.ALL},
               mappedBy = "item")
    @OrderBy("listOrder ASC")
    protected List<ItemExhibitionHistory> exhibitions =
            new ArrayList<ItemExhibitionHistory>();

    /**
     *  conditionOfTheItem
     * (FRBR).
     */
    @OneToMany(cascade = {CascadeType.ALL},
               mappedBy = "item")
    @OrderBy("listOrder ASC")
    protected List<ItemCondition> conditions =
            new ArrayList<ItemCondition>();

    /**
     *  treatmentHistory
     * (FRBR).
     */
    @OneToMany(cascade = {CascadeType.ALL},
               mappedBy = "item")
    @OrderBy("listOrder ASC")
    protected List<ItemTreatmentHistory> treatmentHistories =
            new ArrayList<ItemTreatmentHistory>();

    /**
     *  scheduledTreatment
     * (FRBR).
     */
    @OneToMany(cascade = {CascadeType.ALL},
               mappedBy = "item")
    @OrderBy("listOrder ASC")
    protected List<ItemTreatmentSchedule> treatmentSchedules =
            new ArrayList<ItemTreatmentSchedule>();

    /**
     *  accessRestrictionsOnTheItem
     * (FRBR).
     */
    @OneToMany(cascade = {CascadeType.ALL},
               mappedBy = "item")
    @OrderBy("listOrder ASC")
    protected List<ItemAccessRestriction> accessRestrictions =
            new ArrayList<ItemAccessRestriction>();

    /**
     *  locationOfItem
     * (FRAD).
     */
    @OneToOne(cascade = {CascadeType.ALL},
              mappedBy = "item")
    protected ItemLocation location;

    /**
     *  immediateSourceOfAcquisitionOfItem
     * (FRAD).
     */
    @OneToMany(cascade = {CascadeType.ALL},
               mappedBy = "item")
    @OrderBy("listOrder ASC")
    protected List<ItemAcquisitionSource> acquisitionSources =
            new ArrayList<ItemAcquisitionSource>();

    /**
     *  note
     * (VFRBR).
     */
    @OneToMany(cascade = {CascadeType.ALL},
               mappedBy = "item")
    @OrderBy("listOrder ASC")
    protected List<ItemNote> notes =
            new ArrayList<ItemNote>();

    /**
     *  callNumber
     * (VFRBR).
     */
    @OneToOne(cascade = {CascadeType.ALL},
              mappedBy = "item")
    protected ItemCallNumber callNumber;

    /**
     *  copyNumber
     * (VFRBR).
     */
    @OneToOne(cascade = {CascadeType.ALL},
              mappedBy = "item")
    protected ItemCopyNumber copyNumber;

    /*
     *     ---------------------
     * ---- relationship fields
     *     ---------------------
     */

    /* -- exemplification --
     *  ManifestationToItem
     */
    /**
     * ItemJpa isExemplification for Manifestation.
     * Target end of Exemplification
     * ManifestationToItem relationship.
     */
    @OneToMany(cascade = {CascadeType.PERSIST,
                          CascadeType.MERGE,
                          CascadeType.REFRESH},
               mappedBy = "targetItem")
    @OrderBy("listOrder ASC")
    protected List<ManifestationToItem> isExemplification =
            new ArrayList<ManifestationToItem>();

    /* -- owner --
     *      <CorporateBody>
     *      <Person>
     *  ItemToResponsibleParty
     */
    /**
     * ItemJpa hasOwner of CorporateBody.
     * Source end of Owner
     * ItemToResponsibleParty relationship
     * for CorporateBody.
     */
    // TODO -- ItemJpa hasOwner of CorporateBody
    //
    /**
     * ItemJpa hasOwner of Person.
     * Source end of Owner
     * ItemToResponsibleParty relationship
     * for Person.
     */
    // TODO -- ItemJpa hasOwner of Person
    //

    /* -- part --
     *  ItemToItem
     */
    /**
     * ItemJpa hasPart of ItemJpa.
     * Source end of Part
     * ItemToItem relationship.
     */
    // TODO -- ItemJpa hasPart of ItemJpa
    //
    /**
     * ItemJpa isPart for ItemJpa.
     * Target end of Part
     * ItemToItem relationship.
     */
    // TODO -- ItemJpa isPart of ItemJpa
    //

    /* -- reconfiguration --
     *  ItemToItem
     */
    /**
     * ItemJpa hasReconfiguration of ItemJpa.
     * Source end of Reconfiguration
     * ItemToItem relationship.
     */
    // TODO -- ItemJpa hasReconfiguration of ItemJpa
    //
    /**
     * ItemJpa isReconfiguration for ItemJpa.
     * Target end of Reconfiguration
     * ItemToItem relationship.
     */
    // TODO -- ItemJpa isReconfiguration for ItemJpa
    //

    /* -- reproduction --
     *  ManifestationToItem
     *  ItemToItem
     */
    /**
     * ItemJpa isReproduction for Manifestation.
     * Target end of Reproduction
     * ManifestationToItem relationship.
     */
    // TODO -- ItemJpa isReproduction for Manifestation
    //
    /**
     * ItemJpa hasReproduction of ItemJpa.
     * Source end of Reproduction
     * ItemToItem relationship.
     */
    // TODO -- ItemJpa hasReproduction of ItemJpa
    //
    /**
     * ItemJpa isReproduction for ItemJpa.
     * Target end of Reproduction
     * ItemToItem relationship.
     */
    // TODO -- ItemJpa isReproduction for ItemJpa
    //

    /* -- subject --
     *  WorkToItem
     */
    /**
     * ItemJpa isSubject for Work.
     * Target end of Subject
     * WorkToItem relationship.
     */
    // TODO -- ItemJpa isSubject for Work
    //
    /**
     * Simple constructor.
     */
    public ItemJpa() {
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

    /**
     * @return the identifiers
     */
    public List<ItemIdentifier> getIdentifiers() {
        return identifiers;
    }

    /**
     * @param identifiers the identifiers to set
     */
    public void setIdentifiers(List<ItemIdentifier> identifiers) {
        this.identifiers = identifiers;
    }

    /**
     * @return the provenances
     */
    public List<ItemProvenance> getProvenances() {
        return provenances;
    }

    /**
     * @param provenances the provenances to set
     */
    public void setProvenances(List<ItemProvenance> provenances) {
        this.provenances = provenances;
    }

    /**
     * @return the marks
     */
    public List<ItemMark> getMarks() {
        return marks;
    }

    /**
     * @param marks the marks to set
     */
    public void setMarks(List<ItemMark> marks) {
        this.marks = marks;
    }

    /**
     * @return the exhibitions
     */
    public List<ItemExhibitionHistory> getExhibitions() {
        return exhibitions;
    }

    /**
     * @param exhibitions the exhibitions to set
     */
    public void setExhibitions(List<ItemExhibitionHistory> exhibitions) {
        this.exhibitions = exhibitions;
    }

    /**
     * @return the conditions
     */
    public List<ItemCondition> getConditions() {
        return conditions;
    }

    /**
     * @param conditions the conditions to set
     */
    public void setConditions(List<ItemCondition> conditions) {
        this.conditions = conditions;
    }

    /**
     * @return the treatmentHistories
     */
    public List<ItemTreatmentHistory> getTreatmentHistories() {
        return treatmentHistories;
    }

    /**
     * @param treatmentHistories the treatmentHistories to set
     */
    public void setTreatmentHistories(
            List<ItemTreatmentHistory> treatmentHistories) {
        this.treatmentHistories = treatmentHistories;
    }

    /**
     * @return the treatmentSchedules
     */
    public List<ItemTreatmentSchedule> getTreatmentSchedules() {
        return treatmentSchedules;
    }

    /**
     * @param treatmentSchedules the treatmentSchedules to set
     */
    public void setTreatmentSchedules(
            List<ItemTreatmentSchedule> treatmentSchedules) {
        this.treatmentSchedules = treatmentSchedules;
    }

    /**
     * @return the accessRestrictions
     */
    public List<ItemAccessRestriction> getAccessRestrictions() {
        return accessRestrictions;
    }

    /**
     * @param accessRestrictions the accessRestrictions to set
     */
    public void setAccessRestrictions(
            List<ItemAccessRestriction> accessRestrictions) {
        this.accessRestrictions = accessRestrictions;
    }

    /**
     * @return the location
     */
    public ItemLocation getLocation() {
        return location;
    }

    /**
     * @param location the location to set
     */
    public void setLocation(ItemLocation location) {
        this.location = location;
    }

    /**
     * @return the acquisitionSources
     */
    public List<ItemAcquisitionSource> getAcquisitionSources() {
        return acquisitionSources;
    }

    /**
     * @param acquisitionSources the acquisitionSources to set
     */
    public void setAcquisitionSources(
            List<ItemAcquisitionSource> acquisitionSources) {
        this.acquisitionSources = acquisitionSources;
    }

    /**
     * @return the notes
     */
    public List<ItemNote> getNotes() {
        return notes;
    }

    /**
     * @param notes the notes to set
     */
    public void setNotes(List<ItemNote> notes) {
        this.notes = notes;
    }

    /**
     * @return the callNumber
     */
    public ItemCallNumber getCallNumber() {
        return callNumber;
    }

    /**
     * @param callNumber the callNumber to set
     */
    public void setCallNumber(ItemCallNumber callNumber) {
        this.callNumber = callNumber;
    }

    /**
     * @return the copyNumber
     */
    public ItemCopyNumber getCopyNumber() {
        return copyNumber;
    }

    /**
     * @param copyNumber the copyNumber to set
     */
    public void setCopyNumber(ItemCopyNumber copyNumber) {
        this.copyNumber = copyNumber;
    }

    /**
     * @return the isExemplification
     */
    public List<ManifestationToItem> getIsExemplification() {
        return isExemplification;
    }

    /**
     * @param isExemplification the isExemplification to set
     */
    public void setIsExemplification(List<ManifestationToItem> isExemplification) {
        this.isExemplification = isExemplification;
    }
}
