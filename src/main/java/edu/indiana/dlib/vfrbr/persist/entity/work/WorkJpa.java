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
package edu.indiana.dlib.vfrbr.persist.entity.work;

import edu.indiana.dlib.vfrbr.persist.entity.VfrbrEntity;
import edu.indiana.dlib.vfrbr.persist.relation.WorkHasComposer;
import edu.indiana.dlib.vfrbr.persist.relation.WorkHasCreator;
import edu.indiana.dlib.vfrbr.persist.relation.WorkToExpression;
import edu.indiana.dlib.vfrbr.persist.relation.WorkToWork;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

/**
 *  Work entity
 *
 */
@Entity
@Table(name = "WORK_ENT")
public class WorkJpa
        implements Serializable,
                   VfrbrEntity {

    /*
     * ---- persistence fields
     */
    /**
     * Database id
     * (Persistence).
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "WORK_ENT_ID")
    protected int id;

    /**
     * Version support for concurrency protection
     * (Persistence).
     */
    @Column(name = "WORK_ENT_VERSION")
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
    @Column(name = "WORK_ENT_URI",
            length = 512)
    protected String URI;

    /**
     * normalized name identifier
     * from NormalIdent
     *  content identifier
     */
    @Column(name = "WORK_ENT_AUTHIDENT",
            length = 2048)
    protected String authIdent;

    /**
     * uniformTitle (VFRBR).
     */
    @Column(name = "UNIFORM_TITLE",
            length = 2048)
    protected String uniformTitle;

    /**
     *  titleOfTheWork
     * (FRBR).
     */
    @OneToMany(cascade = {CascadeType.ALL},
               mappedBy = "work")
    @OrderBy("listOrder ASC")
    protected List<WorkTitle> titles =
            new ArrayList<WorkTitle>();

    /**
     *  formOfWork
     * (FRBR).
     */
    @OneToMany(cascade = {CascadeType.ALL},
               mappedBy = "work")
    @OrderBy("listOrder ASC")
    protected List<WorkForm> forms =
            new ArrayList<WorkForm>();

    /**
     *  dateOfTheWork
     * (FRBR).
     */
    @OneToMany(cascade = {CascadeType.ALL},
               mappedBy = "work")
    @OrderBy("listOrder ASC")
    protected List<WorkDate> dates =
            new ArrayList<WorkDate>();

    /**
     *  otherDistinguishingCharacteristic
     * (FRBR).
     */
    @OneToMany(cascade = {CascadeType.ALL},
               mappedBy = "work")
    @OrderBy("listOrder ASC")
    protected List<WorkCharacteristic> characteristics =
            new ArrayList<WorkCharacteristic>();

    /**
     *  intendedAudience
     * (FRBR).
     */
    @OneToMany(cascade = {CascadeType.ALL},
               mappedBy = "work")
    @OrderBy("listOrder ASC")
    protected List<WorkAudience> audiences =
            new ArrayList<WorkAudience>();

    /**
     *  contextForTheWork
     * (FRBR).
     */
    @OneToMany(cascade = {CascadeType.ALL},
               mappedBy = "work")
    @OrderBy("listOrder ASC")
    protected List<WorkContext> contexts =
            new ArrayList<WorkContext>();

    /**
     *  mediumOfPerformance
     * (FRBR).
     */
    @OneToMany(cascade = {CascadeType.ALL},
               mappedBy = "work")
    @OrderBy("listOrder ASC")
    protected List<WorkPerformanceMedium> performanceMediums =
            new ArrayList<WorkPerformanceMedium>();

    /**
     *  numericDesignation
     * (FRBR).
     */
    @OneToMany(cascade = {CascadeType.ALL},
               mappedBy = "work")
    @OrderBy("listOrder ASC")
    protected List<WorkDesignation> designations =
            new ArrayList<WorkDesignation>();

    /**
     *  key
     * (FRBR).
     */
    @OneToMany(cascade = {CascadeType.ALL},
               mappedBy = "work")
    @OrderBy("listOrder ASC")
    protected List<WorkKey> keys =
            new ArrayList<WorkKey>();

    /**
     *  subjectOfTheWork 
     * (FRAD).
     * Subject headings from MARC.
     */
    @OneToMany(cascade = {CascadeType.ALL},
               mappedBy = "work")
    @OrderBy("listOrder ASC")
    protected List<WorkSubjectHeading> subjectHeadings =
            new ArrayList<WorkSubjectHeading>();

    /**
     *  placeOfOriginOfTheWork 
     * (FRAD).
     */
    @OneToMany(cascade = {CascadeType.ALL},
               mappedBy = "work")
    @OrderBy("listOrder ASC")
    protected List<WorkOriginPlace> originPlaces =
            new ArrayList<WorkOriginPlace>();

    /**
     *  history 
     * (FRAD).
     */
    @OneToMany(cascade = {CascadeType.ALL},
               mappedBy = "work")
    @OrderBy("listOrder ASC")
    protected List<WorkHistory> histories =
            new ArrayList<WorkHistory>();

    /**
     *  note 
     * (VFRBR).
     */
    @OneToMany(cascade = {CascadeType.ALL},
               mappedBy = "work")
    @OrderBy("listOrder ASC")
    protected List<WorkNote> notes =
            new ArrayList<WorkNote>();

    /**
     *  language 
     * (VFRBR).
     */
    @OneToMany(cascade = {CascadeType.ALL},
               mappedBy = "work")
    @OrderBy("listOrder ASC")
    protected List<WorkLanguage> languages =
            new ArrayList<WorkLanguage>();

    /**
     *  placeOfComposition 
     * (VFRBR).
     */
    @OneToMany(cascade = {CascadeType.ALL},
               mappedBy = "work")
    @OrderBy("listOrder ASC")
    protected List<WorkCompositionPlace> compositionPlaces =
            new ArrayList<WorkCompositionPlace>();

    /*
     *     --------------------
     * ---- relationship fields
     *     --------------------
     */
    /* -- adaptation --
     *  WorkTowork
     *  ExpressionToWork
     */
    /**
     * Work hasAdaptation of Work.
     * Source end of Adaptation
     * WorkToWork relationship.
     */
    // TODO -- Work hasAdaptation of Work.
    //
    /**
     * Work isAdaptation for Work.
     * Target end of Adaptation
     * WorkToWork relationship.
     */
    // TODO -- Work is Adaptation for Work
    //
    /**
     * Work isAdaptation for Expression.
     * Target end of Adaptation
     * ExpressionToWork relationship.
     */
    // TODO -- Work isAdaptation for Expression
    //
    /* -- complement --
     *  WorkToWork
     *  ExpressionToWork
     */
    /**
     * Work hasComplement of Work.
     * Source end of Complement
     * WorkToWork relationship.
     */
    // TODO -- Work hasComplement of Work
    //
    /**
     * Work isComplement for Work.
     * Target end of Complement
     * WorkToWork relationship.
     */
    // TODO -- Work isComplement for Work
    //
    /**
     * Work isComplement for Expression.
     * Target end of Complement
     * ExpressionToWork relationship.
     */
    // TODO -- Work isComplement for Expression
    //
    /* -- creator --
     *      <CorporateBody>
     *      <Person>
     *  WorkToResponsibleParty
     */
    /**
     * Work hasCreator of CorporateBody.
     * Source end of Creator
     * WorkToResponsibleParty relationship
     * for CorporateBody.
     */
    @OneToMany(cascade = {CascadeType.PERSIST,
                          CascadeType.MERGE,
                          CascadeType.REFRESH},
               mappedBy = "sourceWork")
    @OrderBy("listOrder ASC")
    protected List<WorkHasCreator> hasCreatorCorporations =
            new ArrayList<WorkHasCreator>();

    /**
     * Work hasCreator of Person.
     * Source end of Creator
     * WorkToResponsibleParty relationship
     * for Person.
     */
    @OneToMany(cascade = {CascadeType.PERSIST,
                          CascadeType.MERGE,
                          CascadeType.REFRESH},
               mappedBy = "sourceWork")
    @OrderBy("listOrder ASC")
    protected List<WorkHasCreator> hasCreatorPersons =
            new ArrayList<WorkHasCreator>();

    /*
     * -- composer --
     *      <Person>, <CorporateBody>
     *  WorkToResponsibleParty
     */
    /**
     * Work hasComposer of Person.
     * Source end of Composer
     * WorkToResponsibleParty relationship
     * for Person.
     */
    @OneToMany(cascade = {CascadeType.PERSIST,
                          CascadeType.MERGE,
                          CascadeType.REFRESH},
               mappedBy = "sourceWork")
    @OrderBy("listOrder ASC")
    protected List<WorkHasComposer> hasComposerPersons =
            new ArrayList<WorkHasComposer>();

    /**
     * Work hasComposer of CorporateBody.
     * Source end of Composer
     * WorkToResponsibleParty relationship
     * for Corporatebody.
     */
    @OneToMany(cascade = {CascadeType.PERSIST,
                          CascadeType.MERGE,
                          CascadeType.REFRESH},
               mappedBy = "sourceWork")
    @OrderBy("listOrder ASC")
    protected List<WorkHasComposer> hasComposerCorporations =
            new ArrayList<WorkHasComposer>();
    //
    /* -- imitation --
     *  WorkToWork
     *  ExpressionToWork
     */

    /**
     * Work hasImitation of Work.
     * Source end of Imitation
     * WorkToWork relationship.
     */
    // TODO -- Work hasImitation of Work
    //
    /**
     * Work isImitation for Work.
     * Target end of Imitation
     * WorkToWork relationship.
     */
    // TODO -- Work isImitation for Work
    //
    /**
     * Work isImitation for Expression.
     * Target end of Imitation
     * ExpressionToWork relationship.
     */
    // TODO -- Work isImitation for Expression
    //
    /* -- part --
     *  WorkToWork
     */
    /**
     * Work hasPart of Work.
     * Source end of Part
     * WorkToWork relationship.
     */
    // TODO -- Work hasPart of Work
    //
    /**
     * Work isPart for Work.
     * Target end of Part
     * WorkToWork relationship.
     */
    // TODO -- Work isPart for Work
    //
    /* -- realization --
     *  WorkToExpression
     */
    /**
     * Work hasRealization of Expression.
     * Source end of Realization
     * WorkToExpression relationship.
     */
    @OneToMany(cascade = {CascadeType.PERSIST,
                          CascadeType.MERGE,
                          CascadeType.REFRESH},
               mappedBy = "sourceWork")
    @OrderBy("listOrder ASC")
    protected List<WorkToExpression> hasRealizations =
            new ArrayList<WorkToExpression>();

    //
    /* -- subject --
     *      <Work>
     *  WorkToWork
     *      <Expression>
     *  WorkToExpression
     *      <Manifestation>
     *  WorkToManifestation
     *      <Item>
     *  WorkToItem
     *      <CorporateBody>
     *      <Family>
     *      <Person>
     *  WorkToResponsibleParty
     *      <Subject>
     *  WorkToSubject
     */
    /**
     * Work hasSubject of Work.
     * Source end of Subject
     * WorkToWork relationship.
     */
    @OneToMany(cascade = {CascadeType.PERSIST,
                          CascadeType.MERGE,
                          CascadeType.REFRESH},
               mappedBy = "sourceWork")
    @OrderBy("listOrder ASC")
    protected List<WorkToWork> hasSubjectWorks =
            new ArrayList<WorkToWork>();

    /**
     * Work isSubject for Work.
     * Target end of Subject
     * WorkToWork relationship.
     */
    @OneToMany(cascade = {CascadeType.PERSIST,
                          CascadeType.MERGE,
                          CascadeType.REFRESH},
               mappedBy = "targetWork")
    @OrderBy("listOrder ASC")
    protected List<WorkToWork> isSubjectOfWorks =
            new ArrayList<WorkToWork>();

    /**
     * Work hasSubject of Expression.
     * Source end of Subject
     * WorkToExpression relationship.
     */
    // TODO -- Work hasSubject of Expression
    //
    /**
     * Work hasSubject of Manifestation.
     * Source end of Subject
     * WorkToManifestation relationship.
     */
    // TODO -- Work hasSubject of Manifestation
    //
    /**
     * Work hasSubject of Item.
     * Source end of Subject
     * WorkToItem relationship.
     */
    // TODO -- Work hasSubject of Item
    //
    /**
     * Work hasSubject of CorporateBody.
     * Source end of Subject
     * WorkToResponsibleParty relationship
     * for CorporateBody.
     */
    // TODO -- Work hasSubject of CorporateBody
    //
    /**
     * Work hasSubject of Family.
     * Source end of Subject
     * WorkToResponsibleParty relationship
     * for Family.
     */
    // TODO -- Work hasSubject of Family
    //
    /**
     * Work hasSubject of Person.
     * Source end of Subject
     * WorkToResponsibleParty relationship
     * for Person.
     */
    // TODO -- Work hasSubject of Person
    //
    /**
     * Work hasSubject of SubjectEntity.
     * Source end of Subject
     * WorkToSubjectEntity relationship.
     */
    // TODO -- Work hasSubject of SubjectEntity
    //

    /* -- successor --
     *  WorkToWork
     *  ExpressionToWork
     */
    /**
     * Work hasSuccessor of Work.
     * Source end of Successor
     * WorkToWork relationship.
     */
    // TODO -- Work hasSuccessor of Work
    //
    /**
     * Work isSuccessor for Work.
     * Target end of Successor
     * WorkToWork relationship.
     */
    // TODO -- Work isSuccessor for Work
    //
    /**
     * Work isSuccessor For Expression.
     * Target end of Succesor
     * ExpressionToWork relationship.
     */
    // TODO -- Work isSuccessor for Expression
    //
    /* -- summary --
     *  WorkToWork
     *  ExpressionToWork
     */
    /**
     * Work hasSummary of Work.
     * Source end of Summary
     * WorkToWork relationship.
     */
    // TODO -- Work has Summary of Work
    //
    /**
     * Work isSummary for Work.
     * Target end of Summary
     * WorkToWork relationship.
     */
    // TODO -- Work isSummary for Work
    //
    /**
     * Work isSummary for Expression.
     * Target end of Summary
     * ExpresstionToWork relationship.
     */
    // TODO -- Work isSummary for Expression
    //
    /* -- supplement --
     *  WorkToWork
     *  ExpressionToWork
     */
    /**
     * Work hasSupplement of Work.
     * Source end of Supplement
     * WorkToWork relationship.
     */
    // TODO -- Work hasSupplement of Work
    //
    /**
     * Work isSupplement for Work.
     * Target end of Supplement
     * WorkToWork relationship.
     */
    // TODO -- Work isSupplement for Work
    //
    /**
     * Work isSupplement for Expression.
     * Target end of Supplement
     * ExpressionToWork relationship.
     */
    // TODO -- Work isSupplement for Expression
    //
    /* -- transformation --
     *  WorkToWork
     *  ExpressionToWork
     */
    /**
     * Work hasTransformation of Work.
     * Source end of Transformation
     * WorkToWork relationship.
     */
    // TODO -- Work hasTransformation of Work
    //
    /**
     * Work isTransformation for Expression.
     * Target end of Transformation
     * ExpressionToWork relationship.
     */
    // TODO -- Work isTransformation for Expression
    //
    /**
     * Work isTransformation for Work.
     * Target end of Transformation
     * WorkToWork relationship.
     */
    // TODO -- Work isTransformation for Work
    //
    /*
     * ---- methods
     */
    /**
     * Simple constructor.
     */
    public WorkJpa() {
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
     * @return the uniformTitle
     */
    public String getUniformTitle() {
        return uniformTitle;
    }

    /**
     * @param uniformTitle the uniformTitle to set
     */
    public void setUniformTitle(String uniformTitle) {
        this.uniformTitle = uniformTitle;
    }

    /**
     * @return the titles
     */
    public List<WorkTitle> getTitles() {
        return titles;
    }

    /**
     * @param titles the titles to set
     */
    public void setTitles(List<WorkTitle> titles) {
        this.titles = titles;
    }

    /**
     * @param types an ordered list of title types
     * @return titles ordered bases on types param
     */
    public List<WorkTitle> getTitlesOrderedByType(List<String> types) {
        List<WorkTitle> returnTitles = new ArrayList<WorkTitle>();
        if (types == null) {
            return returnTitles;
        }
        for (String type : types) {
            for (WorkTitle currentTitle : this.titles) {
                if (currentTitle.getType() == null) {
                    if (type == null) {
                        returnTitles.add(currentTitle);
                    }
                } else if (currentTitle.getType().equals(type)) {
                    returnTitles.add(currentTitle);
                }
            }
        }
        return returnTitles;
    }

    /**
     * @return the forms
     */
    public List<WorkForm> getForms() {
        return forms;
    }

    /**
     * @param forms the forms to set
     */
    public void setForms(List<WorkForm> forms) {
        this.forms = forms;
    }

    /**
     * @return the dates
     */
    public List<WorkDate> getDates() {
        return dates;
    }

    /**
     * @param dates the dates to set
     */
    public void setDates(List<WorkDate> dates) {
        this.dates = dates;
    }

    /**
     * @return the characteristics
     */
    public List<WorkCharacteristic> getCharacteristics() {
        return characteristics;
    }

    /**
     * @param characteristics the characteristics to set
     */
    public void setCharacteristics(List<WorkCharacteristic> characteristics) {
        this.characteristics = characteristics;
    }

    /**
     * @return the audiences
     */
    public List<WorkAudience> getAudiences() {
        return audiences;
    }

    /**
     * @param audiences the audiences to set
     */
    public void setAudiences(List<WorkAudience> audiences) {
        this.audiences = audiences;
    }

    /**
     * @return the contexts
     */
    public List<WorkContext> getContexts() {
        return contexts;
    }

    /**
     * @param contexts the contexts to set
     */
    public void setContexts(List<WorkContext> contexts) {
        this.contexts = contexts;
    }

    /**
     * @return the performanceMediums
     */
    public List<WorkPerformanceMedium> getPerformanceMediums() {
        return performanceMediums;
    }

    /**
     * @param performanceMediums the performanceMediums to set
     */
    public void setPerformanceMediums(
            List<WorkPerformanceMedium> performanceMediums) {
        this.performanceMediums = performanceMediums;
    }

    /**
     * @return the designations
     */
    public List<WorkDesignation> getDesignations() {
        return designations;
    }

    /**
     * @param designations the designations to set
     */
    public void setDesignations(List<WorkDesignation> designations) {
        this.designations = designations;
    }

    /**
     * @return the keys
     */
    public List<WorkKey> getKeys() {
        return keys;
    }

    /**
     * @param keys the keys to set
     */
    public void setKeys(List<WorkKey> keys) {
        this.keys = keys;
    }

    /**
     * @return the subjectHeadings
     */
    public List<WorkSubjectHeading> getSubjectHeadings() {
        return subjectHeadings;
    }

    /**
     * @param subjectHeadings the subjectHeadings to set
     */
    public void setSubjectHeadings(List<WorkSubjectHeading> subjectHeadings) {
        this.subjectHeadings = subjectHeadings;
    }

    /**
     * @return the originPlaces
     */
    public List<WorkOriginPlace> getOriginPlaces() {
        return originPlaces;
    }

    /**
     * @param originPlaces the originPlaces to set
     */
    public void setOriginPlaces(List<WorkOriginPlace> originPlaces) {
        this.originPlaces = originPlaces;
    }

    /**
     * @return the histories
     */
    public List<WorkHistory> getHistories() {
        return histories;
    }

    /**
     * @param histories the histories to set
     */
    public void setHistories(List<WorkHistory> histories) {
        this.histories = histories;
    }

    /**
     * @return the notes
     */
    public List<WorkNote> getNotes() {
        return notes;
    }

    /**
     * @param notes the notes to set
     */
    public void setNotes(List<WorkNote> notes) {
        this.notes = notes;
    }

    /**
     * @return the languages
     */
    public List<WorkLanguage> getLanguages() {
        return languages;
    }

    /**
     * @param languages the languages to set
     */
    public void setLanguages(List<WorkLanguage> languages) {
        this.languages = languages;
    }

    /**
     * @return the compositionPlaces
     */
    public List<WorkCompositionPlace> getCompositionPlaces() {
        return compositionPlaces;
    }

    /**
     * @param compositionPlaces the compositionPlaces to set
     */
    public void setCompositionPlaces(
            List<WorkCompositionPlace> compositionPlaces) {
        this.compositionPlaces = compositionPlaces;
    }

    /**
     * Work hasCreator of CorporateBody.
     * Source end of Creator
     * WorkToResponsibleParty relationship
     * for CorporateBody.
     * @return the hasCreatorCorporations
     */
    public List<WorkHasCreator> getHasCreatorCorporations() {
        return hasCreatorCorporations;
    }

    /**
     * Work hasCreator of Person.
     * Source end of Creator
     * WorkToResponsibleParty relationship
     * for Person.
     * @return the hasCreatorPersons
     */
    public List<WorkHasCreator> getHasCreatorPersons() {
        return hasCreatorPersons;
    }

    /**
     * @return the hasComposerPersons
     */
    public List<WorkHasComposer> getHasComposerPersons() {
        return hasComposerPersons;
    }

    /**
     * @param hasComposerPersons the hasComposerPersons to set
     */
    public void setHasComposerPersons(
            List<WorkHasComposer> hasComposerPersons) {
        this.hasComposerPersons = hasComposerPersons;
    }

    /**
     * @return the hasRealizations
     */
    public List<WorkToExpression> getHasRealizations() {
        return hasRealizations;
    }

    /**
     * @param hasRealizations the hasRealizations to set
     */
    public void setHasRealizations(List<WorkToExpression> hasRealizations) {
        this.hasRealizations = hasRealizations;
    }

    /**
     * @return the hasSubjectWorks
     */
    public List<WorkToWork> getHasSubjectWorks() {
        return hasSubjectWorks;
    }

    /**
     * @param hasSubjectWorks the hasSubjectWorks to set
     */
    public void setHasSubjectWorks(List<WorkToWork> hasSubjectWorks) {
        this.hasSubjectWorks = hasSubjectWorks;
    }

    /**
     * @return the isSubjectOfWorks
     */
    public List<WorkToWork> getIsSubjectOfWorks() {
        return isSubjectOfWorks;
    }

    /**
     * @param isSubjectOfWorks the isSubjectOfWorks to set
     */
    public void setIsSubjectOfWorks(List<WorkToWork> isSubjectOfWorks) {
        this.isSubjectOfWorks = isSubjectOfWorks;
    }

    /**
     * normalized name identifier
     * from NormalIdent
     * content identifier
     * @return the nameIdent
     */
    public String getAuthIdent() {
        return authIdent;
    }

    /**
     * normalized name identifier
     * from NormalIdent
     * content identifier
     * @param nameIdent the nameIdent to set
     */
    public void setAuthIdent(String authIdent) {
        this.authIdent = authIdent;
    }

    /**
     * Work hasComposer of CorporateBody.
     * Source end of Composer
     * WorkToResponsibleParty relationship
     * for Corporatebody.
     * @return the hasComposerCorporations
     */
    public List<WorkHasComposer> getHasComposerCorporations() {
        return hasComposerCorporations;
    }
}
