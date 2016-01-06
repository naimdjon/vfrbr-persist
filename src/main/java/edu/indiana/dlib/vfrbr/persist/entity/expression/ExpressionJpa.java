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

import edu.indiana.dlib.vfrbr.persist.entity.VfrbrEntity;
import edu.indiana.dlib.vfrbr.persist.relation.ExpressionToManifestation;
import edu.indiana.dlib.vfrbr.persist.relation.ExpressionToResponsibleParty;
import edu.indiana.dlib.vfrbr.persist.relation.WorkToExpression;
import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;
import javax.persistence.*;

/**
 *  ExpressionJpa entity
 *
 */
@Entity
@Table(name = "EXPR_ENT")
public class ExpressionJpa
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
    @Column(name = "EXPR_ENT_ID")
    protected int id;

    /**
     * Version support for concurrency protection
     * (Persistence).
     */
    @Column(name = "EXPR_ENT_VERSION")
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
    @Column(name = "EXPR_ENT_URI",
            length = 512)
    protected String URI;

    /**
     *  titleOfTheExpression
     * (FRBR).
     */
    @OneToMany(cascade = {CascadeType.ALL},
               mappedBy = "expression")
    @OrderBy("listOrder ASC")
    protected List<ExpressionTitle> titles =
            new ArrayList<ExpressionTitle>();

    /**
     *  formOfExpression
     * (FRBR).
     */
    @OneToMany(cascade = {CascadeType.ALL},
               mappedBy = "expression")
    @OrderBy("listOrder ASC")
    protected List<ExpressionForm> forms =
            new ArrayList<ExpressionForm>();

    /**
     *  dateOfExpression
     * (FRBR).
     */
    @OneToMany(cascade = {CascadeType.ALL},
               mappedBy = "expression")
    @OrderBy("listOrder ASC")
    protected List<ExpressionDate> dates =
            new ArrayList<ExpressionDate>();

    /**
     *  languageOfExpression
     * (FRBR).
     */
    @OneToMany(cascade = {CascadeType.ALL},
               mappedBy = "expression")
    @OrderBy("listOrder ASC")
    protected List<ExpressionLanguage> languages =
            new ArrayList<ExpressionLanguage>();

    /**
     *  otherDistinguishingCharacteristic
     * (FRBR).
     */
    @OneToMany(cascade = {CascadeType.ALL},
               mappedBy = "expression")
    @OrderBy("listOrder ASC")
    protected List<ExpressionCharacteristic> characteristics =
            new ArrayList<ExpressionCharacteristic>();

    /**
     *  extentOfTheExpression
     * (FRBR).
     */
    @OneToMany(cascade = {CascadeType.ALL},
               mappedBy = "expression")
    @OrderBy("listOrder ASC")
    protected List<ExpressionExtent> extents =
            new ArrayList<ExpressionExtent>();

    /**
     *  summarizationOfContent
     * (FRBR).
     */
    @OneToMany(cascade = {CascadeType.ALL},
               mappedBy = "expression")
    @OrderBy("listOrder ASC")
    protected List<ExpressionSummarization> summarizations =
            new ArrayList<ExpressionSummarization>();

    /**
     *  contextForTheExpression
     * (FRBR).
     */
    @OneToMany(cascade = {CascadeType.ALL},
               mappedBy = "expression")
    @OrderBy("listOrder ASC")
    protected List<ExpressionContext> contexts =
            new ArrayList<ExpressionContext>();

    /**
     *  criticalResponseToTheExpression
     * (FRBR).
     */
    @OneToMany(cascade = {CascadeType.ALL},
               mappedBy = "expression")
    @OrderBy("listOrder ASC")
    protected List<ExpressionResponse> responses =
            new ArrayList<ExpressionResponse>();

    /**
     *  typeOfScore
     * (FRBR).
     */
    @OneToMany(cascade = {CascadeType.ALL},
               mappedBy = "expression")
    protected List<ExpressionScoreType> scoreType =
            new ArrayList<ExpressionScoreType>();

    /**
     *  mediumOfPerformance
     * (FRBR).
     */
    @OneToMany(cascade = {CascadeType.ALL},
               mappedBy = "expression")
    @OrderBy("listOrder ASC")
    protected List<ExpressionPerformanceMedium> performanceMediums =
            new ArrayList<ExpressionPerformanceMedium>();

    /**
     *  note 
     * (VFRBR).
     */
    @OneToMany(cascade = {CascadeType.ALL},
               mappedBy = "expression")
    @OrderBy("listOrder ASC")
    protected List<ExpressionNote> notes =
            new ArrayList<ExpressionNote>();

    /**
     *  placeOfPerformance 
     * (VFRBR).
     */
    @OneToMany(cascade = {CascadeType.ALL},
               mappedBy = "expression")
    protected List<ExpressionPerformancePlace> performancePlace =
            new ArrayList<ExpressionPerformancePlace>();

    /**
     *  key 
     * (VFRBR).
     */
    @OneToMany(cascade = {CascadeType.ALL},
               mappedBy = "expression")
    @OrderBy("listOrder ASC")
    protected List<ExpressionKey> keys =
            new ArrayList<ExpressionKey>();

    /**
     *  genreFormStyle
     * (VFRBR).
     */
    @OneToMany(cascade = {CascadeType.ALL},
               mappedBy = "expression")
    @OrderBy("listOrder ASC")
    protected List<ExpressionGenre> genres =
            new ArrayList<ExpressionGenre>();

    /*
     *     ---------------------
     * ---- relationship fields
     *     ---------------------
     */

    /* -- abridgement --
     *  ExpressionToExpression
     */

    /* -- adaptation --
     *  ExpressionToWork
     *  ExpressionToExpression
     */
    /**
     * ExpressionJpa hasAdaptation of Work.
     * Source end of Adaptation
     * ExpressionToWork relationship.
     */
    // TODO -- ExpressionJpa hasAdaptation of Work
    //
    /**
     * ExpressionJpa hasAdaptation of ExpressionJpa.
     * Source end of Adaptation
     * ExpressionToExpression relationship.
     */
    // TODO -- ExpressionJpa hasAdaptation of ExpressionJpa
    //
    /**
     * ExpressionJpa isAdaptation for ExpressionJpa.
     * Target end of Aaptation
     * ExpressionToExpression relationship.
     */
    // TODO -- ExpressionJpa isAdaptation for ExpressionJpa
    //

    /* -- arrangement --
     *  ExpressionToExpression
     */
    /**
     * ExpressionJpa hasArrangement of ExpressionJpa.
     * Source end of Arrangement
     * ExpressionToExpression relationship.
     */
    // TODO -- ExpressionJpa hasArrangement of ExpressionJpa
    //
    /**
     * ExpressionJpa isArrangement for ExpressionJpa.
     * Target end of Arrangement
     * ExpressionToExpression relationship.
     */
    // TODO -- ExpressionJpa isArrangment for ExpressionJpa
    //

    /* -- complement --
     *  ExpressionToWork
     *  ExpressionToExpression
     */
    /**
     * ExpressionJpa hasComplement of Work.
     * Subject end of Complement
     * ExpressionToWork relationship.
     */
    // TODO -- ExpressionJpa hasComplement of Work
    //
    /**
     * ExpressionJpa hasComplement of ExpressionJpa.
     * Source end of Complement
     * ExpressionToExpression relationship.
     */
    // TODO -- ExpressionJpa hasComplement of ExpressionJpa
    //
    /**
     * ExpressionJpa isComplement for ExpressionJpa.
     * Target end of Complement
     * ExpressionToExpression relationship.
     */
    // TODO -- ExpressionJpa isComplement for ExpressionJpa
    //

    /* -- embodiment --
     *  ExpressionToManifestation
     */
    /**
     * ExpressionJpa hasEmbodiment of Manifestation.
     * Source end of Embodiment
     * ExpressionToManifestation relationship.
     */
    @OneToMany(cascade = {CascadeType.PERSIST,
                          CascadeType.MERGE,
                          CascadeType.REFRESH},
               mappedBy = "sourceExpression")
    @OrderBy("listOrder ASC")
    protected List<ExpressionToManifestation> hasEmbodiments =
            new ArrayList<ExpressionToManifestation>();

    /* -- imitation --
     *  ExpressionToWork
     *  ExpressionToExpression
     */
    /**
     * ExpressionJpa hasImitation of Work.
     * Source end of Imitation
     * ExpressionToWork relationship.
     */
    // TODO -- ExpressionJpa hasImitation of Work
    //
    /**
     * ExpressionJpa hasImitation of ExpressionJpa.
     * Source end of Imitation
     * ExpressionToExpression relationship.
     */
    // TODO -- ExpressionJpa hasImitation of ExpressionJpa
    //
    /**
     * ExpressionJpa isImitation for ExpressionJpa.
     * Target end of Imitation
     * ExpressionToExpression relationship.
     */
    // TODO -- ExpressionJpa isImitation for ExpressionJpa
    //

    /* -- part --
     *  ExpressionToExpression
     */
    /**
     * ExpressionJpa hasPart of ExpressionJpa.
     * Source end of Part
     * ExpressionToExpression relationship.
     */
    // TODO -- ExpressionJpa hasPart of ExpressionJpa
    //
    /**
     * ExpressionJpa isPart for ExpressionJpa.
     * Target end of Part
     * ExpressionToExpression relationship.
     */
    // TODO -- ExpressionJpa isPart for ExpressionJpa
    //

    /* -- realization --
     *  WorkToExpression
     */
    /**
     * ExpressionJpa isRealization for Work.
     * Target end of Realization
     * WorkToExpression relationship.
     */
    @OneToMany(cascade = {CascadeType.PERSIST,
                          CascadeType.MERGE,
                          CascadeType.REFRESH},
               mappedBy = "targetExpression")
    protected List<WorkToExpression> isRealization =
            new ArrayList<WorkToExpression>();

    /* -- realizer --
     *      <CorporateBody>
     *      <Person>
     *  ExpressionToResponsibleParty
     */
    @OneToMany(cascade = {CascadeType.PERSIST,
                          CascadeType.MERGE,
                          CascadeType.REFRESH},
               mappedBy = "sourceExpression")
    @OrderBy("listOrder ASC")
    protected List<ExpressionToResponsibleParty> hasRealizers =
            new ArrayList<ExpressionToResponsibleParty>();

    /**
     * ExpressionJpa hasRealizer of CorporateBody.
     * Source end of Realizer
     * ExpressionToResponsibleParty
     * for CorporateBody.
     */
    // TODO -- ExpressionJpa hasRealizer of CorporateBody
    //
    /**
     * ExpressionJpa hasRealizer of Person.
     * Source end of Realizer
     * ExpressionToResponsibleParty relationship
     * for Person.
     */
    // TODO -- ExpressionJpa hasRealizer of Person
    //

    /* -- revision --
     *  ExpressionToExpression
     */
    /**
     * ExpressionJpa hasRevision of ExpressionJpa.
     * Source end of Revision
     * ExpressionToExpression relationship.
     */
    // TODO -- ExpressionJpa hasRevision of ExpressionJpa
    //
    /**
     * ExpressionJpa isRevision for ExpressionJpa.
     * Target end of Revision
     * ExpressionToExpression relationship.
     */
    // TODO -- ExpressionJpa isRevision for ExpressionJpa
    //

    /* -- subject --
     *  WorkToExpression
     */
    /**
     * ExpressionJpa isSubject for Work.
     * Target end of Subject
     * WorkToExpression relationship.
     */
    // TODO -- ExpressionJpa isSubject for Work
    //

    /* -- successor --
     *  ExpressionToWork
     *  ExpressionToExpression
     */
    /**
     * ExpressionJpa hasSuccessor of Work.
     * Source end of Successor
     * ExpressionToWork relationship.
     */
    // TODO -- ExpressionJpa hasSuccessor of Work
    //
    /**
     * ExpressionJpa hasSuccessor of ExpressionJpa.
     * Source end of Successor
     * ExpressionToExpression relationship.
     */
    // TODO -- ExpressionJpa hasSuccessor of ExpressionJpa
    //
    /**
     * ExpressionJpa isSuccesor for ExpressionJpa.
     * Target end of Succesor
     * ExpressionToExpression relationship.
     */
    // TODO -- ExpressionJpa isSuccesor for ExpressionJpa
    //

    /* -- summary --
     *  ExpressionToWork
     *  ExpressiontoExpression
     */
    /**
     * ExpressionJpa hasSummary of Work.
     * Source end of Summary
     * ExpressionToWork relationship.
     */
    // TODO -- ExpressionJpa hasSummary of Work
    //
    /**
     * ExpressionJpa hasSummary of ExpressionJpa.
     * Source end of Summary
     * ExpressionToExpression relationship.
     */
    // TODO -- ExpressionJpa hasSummary of ExpressionJpa
    //
    /**
     * ExpressionJpa isSummary for ExpressionJpa.
     * Target end of Summary
     * ExpressionToExpression relationship.
     */
    // TODO -- ExpressionJpa isSummary for ExpressionJpa
    //

    /* -- supplement --
     *  ExpressionToWork
     *  ExpressionToExpression
     */
    /**
     * ExpressionJpa hasSupplement of Work.
     * Source end of Supplement
     * ExpressionToWork relationship.
     */
    // TODO -- ExpressionJpa hasSupplement of Work
    //
    /**
     * ExpressionJpa hasSupplement of ExpressionJpa.
     * Source end of Supplement
     * ExpressionToExpression relationship.
     */
    // TODO -- ExpressionJpa hasSupplement of ExpressionJpa
    //
    /**
     * ExpressionJpa isSupplement for ExpressionJpa.
     * Target end of Supplement
     * ExpressionToExpression relationship.
     */
    // TODO -- ExpressionJpa isSupplement for ExpressionJpa
    //

    /* -- transformation --
     *  ExpressionToWork
     *  ExpressionToExpression
     */
    /**
     * ExpressionJpa hasTransformation of Work.
     * Target end of Transformation
     * ExpressionToWork relationship.
     */
    // TODO -- ExpressionJpa hasTransformation of Work
    //
    /**
     * ExpressionJpa hasTransformation of ExpressionJpa.
     * Source end of Transformation
     * ExpressionToExpression relationship.
     */
    // TODO -- ExpressionJpa hasTransformation of ExpressionJpa
    //
    /**
     * ExpressionJpa isTransformation for ExpressionJpa.
     * Target end of Transformation
     * ExpressionToExpression relationship.
     */
    // TODO -- ExpressionJpa isTransformation for ExpressionJpa

    /* -- translation --
     *  ExpressionToExpression
     */
    /**
     * ExpressionJpa hasTranslation of ExpressionJpa.
     * Source end of Translation
     * ExpressionToExpression relationship.
     */
    // TODO -- ExpressionJpa hasTranslation of ExpressionJpa
    //
    /**
     * ExpressionJpa isTranslation for ExpressionJpa.
     * Target end of Translation
     * ExpressionToExpression relationship.
     */
    // TODO -- ExpressionJpa isTranslation for ExpressionJpa
    //
    /**
     * Simple constructor.
     */
    public ExpressionJpa() {
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
     * @return the titles
     */
    public List<ExpressionTitle> getTitles() {
        return titles;
    }

    /**
     * @param titles the titles to set
     */
    public void setTitles(List<ExpressionTitle> titles) {
        this.titles = titles;
    }

    /**
     * @return the forms
     */
    public List<ExpressionForm> getForms() {
        return forms;
    }

    /**
     * @param forms the forms to set
     */
    public void setForms(List<ExpressionForm> forms) {
        this.forms = forms;
    }

    /**
     * @return the dates
     */
    public List<ExpressionDate> getDates() {
        return dates;
    }

    /**
     * @param dates the dates to set
     */
    public void setDates(List<ExpressionDate> dates) {
        this.dates = dates;
    }

    /**
     * @return the languages
     */
    public List<ExpressionLanguage> getLanguages() {
        return languages;
    }

    /**
     * @param languages the languages to set
     */
    public void setLanguages(List<ExpressionLanguage> languages) {
        this.languages = languages;
    }

    /**
     * @return the characteristics
     */
    public List<ExpressionCharacteristic> getCharacteristics() {
        return characteristics;
    }

    /**
     * @param characteristics the characteristics to set
     */
    public void setCharacteristics(
            List<ExpressionCharacteristic> characteristics) {
        this.characteristics = characteristics;
    }

    /**
     * @return the extents
     */
    public List<ExpressionExtent> getExtents() {
        return extents;
    }

    /**
     * @param extents the extents to set
     */
    public void setExtents(List<ExpressionExtent> extents) {
        this.extents = extents;
    }

    /**
     * @return the summarizations
     */
    public List<ExpressionSummarization> getSummarizations() {
        return summarizations;
    }

    /**
     * @param summarizations the summarizations to set
     */
    public void setSummarizations(List<ExpressionSummarization> summarizations) {
        this.summarizations = summarizations;
    }

    /**
     * @return the contexts
     */
    public List<ExpressionContext> getContexts() {
        return contexts;
    }

    /**
     * @param contexts the contexts to set
     */
    public void setContexts(List<ExpressionContext> contexts) {
        this.contexts = contexts;
    }

    /**
     * @return the responses
     */
    public List<ExpressionResponse> getResponses() {
        return responses;
    }

    /**
     * @param responses the responses to set
     */
    public void setResponses(List<ExpressionResponse> responses) {
        this.responses = responses;
    }

    /**
     * @return the scoreType
     */
    public List<ExpressionScoreType> getScoreType() {
        return scoreType;
    }

    /**
     * @param scoreType the scoreType to set
     */
    public void setScoreType(List<ExpressionScoreType> scoreType) {
        this.scoreType = scoreType;
    }

    /**
     * @return the performanceMediums
     */
    public List<ExpressionPerformanceMedium> getPerformanceMediums() {
        return performanceMediums;
    }

    /**
     * @param performanceMediums the performanceMediums to set
     */
    public void setPerformanceMediums(
            List<ExpressionPerformanceMedium> performanceMediums) {
        this.performanceMediums = performanceMediums;
    }

    /**
     * @return the notes
     */
    public List<ExpressionNote> getNotes() {
        return notes;
    }

    /**
     * @param notes the notes to set
     */
    public void setNotes(List<ExpressionNote> notes) {
        this.notes = notes;
    }

    /**
     * @return the performancePlace
     */
    public List<ExpressionPerformancePlace> getPerformancePlace() {
        return performancePlace;
    }

    /**
     * @param performancePlace the performancePlace to set
     */
    public void setPerformancePlace(
            List<ExpressionPerformancePlace> performancePlace) {
        this.performancePlace = performancePlace;
    }

    /**
     * @return the keys
     */
    public List<ExpressionKey> getKeys() {
        return keys;
    }

    /**
     * @param keys the keys to set
     */
    public void setKeys(List<ExpressionKey> keys) {
        this.keys = keys;
    }

    /**
     * @return the genres
     */
    public List<ExpressionGenre> getGenres() {
        return genres;
    }

    /**
     * @param genres the genres to set
     */
    public void setGenres(List<ExpressionGenre> genres) {
        this.genres = genres;
    }

    /**
     * @return the hasEmbodiments
     */
    public List<ExpressionToManifestation> getHasEmbodiments() {
        return hasEmbodiments;
    }

    /**
     * @param hasEmbodiments the hasEmbodiments to set
     */
    public void setHasEmbodiments(List<ExpressionToManifestation> hasEmbodiments) {
        this.hasEmbodiments = hasEmbodiments;
    }

    /**
     * @return the isRealization
     */
    public List<WorkToExpression> getIsRealization() {
        return isRealization;
    }

    /**
     * @param isRealization the isRealization to set
     */
    public void setIsRealization(List<WorkToExpression> isRealization) {
        this.isRealization = isRealization;
    }

    /**
     * @return the hasComposerPersons
     */
    public List<ExpressionToResponsibleParty> getHasRealizers() {
        return this.hasRealizers;
    }

    /**
     * @param hasComposerPersons the hasComposerPersons to set
     */
    public void setHasRealizers(
            List<ExpressionToResponsibleParty> hasRealizers) {
        this.hasRealizers = hasRealizers;
    }
}
