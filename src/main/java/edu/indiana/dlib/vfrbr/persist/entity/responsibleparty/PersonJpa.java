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
 *  PersonJpa ResponsiblePartyJpa
 */
@Entity
@DiscriminatorValue("Person")
public class PersonJpa
        extends ResponsiblePartyJpa {

    /*
     *     ------------------
     * ---- attribute fields
     *     ------------------
     */
    /**
     *  nameOfPerson
     * (FRBR).
     */
    @OneToMany(cascade = {CascadeType.ALL},
               mappedBy = "responsibleParty")
    @OrderBy("listOrder ASC")
    protected List<PersonName> names =
            new ArrayList<PersonName>();

    /**
     *  datesOfPerson
     * (FRBR).
     */
    @OneToMany(cascade = {CascadeType.ALL},
               mappedBy = "responsibleParty")
    @OrderBy("listOrder ASC")
    protected List<PersonDate> dates =
            new ArrayList<PersonDate>();

    /**
     *  titleOfPerson
     * (FRBR).
     */
    @OneToMany(cascade = {CascadeType.ALL},
               mappedBy = "responsibleParty")
    @OrderBy("listOrder ASC")
    protected List<PersonTitle> titles =
            new ArrayList<PersonTitle>();

    /**
     *  otherDesignationAssociatedWithThePerson
     * (FRBR).
     */
    @OneToMany(cascade = {CascadeType.ALL},
               mappedBy = "responsibleParty")
    @OrderBy("listOrder ASC")
    protected List<PersonDesignation> designations =
            new ArrayList<PersonDesignation>();

    /**
     *  gender
     * (FRAD).
     */
    @OneToMany(cascade = {CascadeType.ALL},
               mappedBy = "responsibleParty")
    @OrderBy("listOrder ASC")
    protected List<PersonGender> genders =
            new ArrayList<PersonGender>();

    /**
     *  placeOfBirth
     * (FRAD).
     */
    @OneToMany(cascade = {CascadeType.ALL},
               mappedBy = "responsibleParty")
    @OrderBy("listOrder ASC")
    protected List<PersonBirthPlace> birthPlaces =
            new ArrayList<PersonBirthPlace>();

    /**
     *  placeOfDeath
     * (FRAD).
     */
    @OneToMany(cascade = {CascadeType.ALL},
               mappedBy = "responsibleParty")
    @OrderBy("listOrder ASC")
    protected List<PersonDeathPlace> deathPlaces =
            new ArrayList<PersonDeathPlace>();

    /**
     *  country
     * (FRAD).
     */
    @OneToMany(cascade = {CascadeType.ALL},
               mappedBy = "responsibleParty")
    @OrderBy("listOrder ASC")
    protected List<PersonCountry> countries =
            new ArrayList<PersonCountry>();

    /**
     *  placeOfResidence
     * (FRAD).
     */
    @OneToMany(cascade = {CascadeType.ALL},
               mappedBy = "responsibleParty")
    @OrderBy("listOrder ASC")
    protected List<PersonResidencePlace> residencePlaces =
            new ArrayList<PersonResidencePlace>();

    /**
     *  affiliation
     * (FRAD).
     */
    @OneToMany(cascade = {CascadeType.ALL},
               mappedBy = "responsibleParty")
    @OrderBy("listOrder ASC")
    protected List<PersonAffiliation> affiliations =
            new ArrayList<PersonAffiliation>();

    /**
     *  address
     * (FRAD).
     */
    @OneToMany(cascade = {CascadeType.ALL},
               mappedBy = "responsibleParty")
    @OrderBy("listOrder ASC")
    protected List<PersonAddress> addresses =
            new ArrayList<PersonAddress>();

    /**
     *  languageOfPerson
     * (FRAD).
     */
    @OneToMany(cascade = {CascadeType.ALL},
               mappedBy = "responsibleParty")
    @OrderBy("listOrder ASC")
    protected List<PersonLanguage> languages =
            new ArrayList<PersonLanguage>();

    /**
     *  fieldOfActivity
     * (FRAD).
     */
    @OneToMany(cascade = {CascadeType.ALL},
               mappedBy = "responsibleParty")
    @OrderBy("listOrder ASC")
    protected List<PersonActivityField> activityFields =
            new ArrayList<PersonActivityField>();

    /**
     *  professionOccupation
     * (FRAD).
     */
    @OneToMany(cascade = {CascadeType.ALL},
               mappedBy = "responsibleParty")
    @OrderBy("listOrder ASC")
    protected List<PersonProfession> professions =
            new ArrayList<PersonProfession>();

    /**
     *  biographyHistory
     * (FRAD).
     */
    @OneToMany(cascade = {CascadeType.ALL},
               mappedBy = "responsibleParty")
    @OrderBy("listOrder ASC")
    protected List<PersonBiography> biographies =
            new ArrayList<PersonBiography>();

    /**
     *  note
     * (VFRBR).
     */
    @OneToMany(cascade = {CascadeType.ALL},
               mappedBy = "responsibleParty")
    @OrderBy("listOrder ASC")
    protected List<PersonNote> notes =
            new ArrayList<PersonNote>();

    /*
     *     ---------------------
     * ---- relationship fields
     *     ---------------------
     */

    /* -- attribution --
     *  PersonToPerson
     */
    /**
     * PersonJpa hasAttribution of PersonJpa.
     * Source end of Attribution
     * PersonToPerson relationship.
     */
    // TODO -- PersonJpa hasAttribution of PersonJpa
    //
    /**
     * PersonJpa isAttribution for PersonJpa.
     * Target end of Attribution
     * PersonToPerson relationship.
     */
    // TODO -- PersonJpa isAttribution for PersonJpa
    //

    /* -- child --
     *  PersonToPerson
     */
    /**
     * PersonJpa hasChild of PersonJpa.
     * Source end of Child
     * PersonToPerson relationship.
     */
    // TODO -- PersonJpa hasChild of PersonJpa
    //
    /**
     * PersonJpa isChild for PersonJpa.
     * Target end of Child
     * PersonToPerson relationship.
     */
    // TODO -- PersonJpa isChild for PersonJpa
    //

    /* -- creator --
     *  WorkToResponsibleParty
     * Work to <PersonJpa>
     */
    /**
     * PersonJpa isCreator for Work.
     * Target end of Creator
     * WorkToResponsibleParty relationship
     * for PersonJpa.
     */
    // TODO -- PersonJpa isCreator for Work
    //
    /* -- composer --
     *  WorkToResponsibleParty
     * Work to PersonJpa
     */
    /**
     * PersonJpa isComposer for Work.
     * Target end of Composer
     * WorkToResponsibleParty relationship
     * for PersonJpa.
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
     * PersonJpa isMember for CorporateBody.
     * Target end of Member
     * CorporateBodyToPerson relationship.
     */
    // TODO -- PersonJpa isMember for CorporateBody
    //

    /* -- member --
     *  FamilyToPerson
     */
    /**
     * PersonJpa isMember for Family.
     * Target end of Member
     * FamilyToPerson relationship.
     */
    // TODO -- PersonJpa isMember for Family
    //

    /* -- owner --
     *  ItemToResponsibleParty
     * Item to <PersonJpa>
     */
    /**
     * PersonJpa isOwner for Item.
     * Target end of Owner
     * ItemToResponsibleParty relationship
     * for PersonJpa.
     */
    // TODO -- PersonJpa isOwner for Item
    //

    /* -- producer --
     *  ManifestationToResponsibleParty
     * Manifestation to <PersonJpa>
     */
    /**
     * PersonJpa isProducer for Manifestation.
     * Target end of Producer
     * ManifestationToResponsibleParty
     * for PersonJpa.
     */
    @OneToMany(cascade = {CascadeType.PERSIST,
                          CascadeType.MERGE,
                          CascadeType.REFRESH},
               mappedBy = "targetResponsibleParty")
    @OrderBy("listOrder ASC")
    protected List<ManifestationToResponsibleParty> isProducerOfManifestations =
            new ArrayList<ManifestationToResponsibleParty>();

    /* -- pseudonym --
     *  PersonToPerson
     */
    /**
     * PersonJpa hasPseudonym of PersonJpa.
     * Source end of Pseudonym
     * PersonToPerson relationship.
     */
    // TODO -- PersonJpa hasPseudonym of PersonJpa
    //
    /**
     * PersonJpa isPseudonym for PersonJpa.
     * Target end of Pseudonym
     * PersonToPerson relationship.
     */
    // TODO -- PersonJpa isPseudonym for PersonJpa
    //

    /* -- realizer --
     *  ExpressionToResponsibleParty
     * Expression to <PersonJpa>
     */
    /**
     * PersonJpa isRealizer for Expression.
     * Target end of Realizer
     * ExpressionToResponsibleParty relationship
     * for PersonJpa.
     */
    @OneToMany(cascade = {CascadeType.PERSIST,
                          CascadeType.MERGE,
                          CascadeType.REFRESH},
               mappedBy = "targetResponsibleParty")
    @OrderBy("listOrder ASC")
    protected List<ExpressionToResponsibleParty> isRealizerOfExpressions =
            new ArrayList<ExpressionToResponsibleParty>();

    /* -- sibling --
     *  PersonToPerson
     */
    /**
     * PersonJpa hasSibling of PersonJpa.
     * Source end of Sibiling
     * PersonToPerson relationship.
     */
    // TODO -- PersonJpa hasSibling of PersonJpa
    //
    /**
     * PersonJpa isSibling for PersonJpa.
     * Target end of Sibling
     * PersonToPerson relationship.
     */
    // TODO -- PersonJpa isSibling for PersonJpa
    //

    /* -- subject --
     *  WorkToResponsibleParty
     * Work to <PersonJpa>
     */
    /**
     * PersonJpa isSubject for Work.
     * Target end of Subject
     * WorkToResponsibleParty relationship
     * for PersonJpa.
     */
    // TODO -- PersonJpa isSubject for Work
    //
    /**
     * Simple constructor.
     */
    public PersonJpa() {
    }

    public String getIdentString() {
        StringBuilder identBuff = new StringBuilder();
        char separator = '/';

        // name
        if (authorizedName != null) {
            // authorizedName if not null
            identBuff.append(authorizedName);
        } else if (getNames().isEmpty()) {
            // if no names use "<null>"
            identBuff.append("<null>");
        } else {
            // use names[0]
            identBuff.append(getNames().get(0));
        }

        // date
        identBuff.append(separator);
        if (getDates().isEmpty()) {
            // if no dates use "<null>"
            identBuff.append("<null>");
        } else {
            identBuff.append(getNames().get(0));
        }

        // designation
        identBuff.append(separator);
        if (getDesignations().isEmpty()) {
            // if no designations use "<null>"
            identBuff.append("<null>");
        } else {
            identBuff.append(getDesignations().get(0));
        }
        
        return identBuff.toString();
    }

    /**
     * @return the names
     */
    public List<PersonName> getNames() {
        return names;
    }

    /**
     * @param names the names to set
     */
    public void setNames(List<PersonName> names) {
        this.names = names;
    }

    /**
     * @return the dates
     */
    public List<PersonDate> getDates() {
        return dates;
    }

    /**
     * @param dates the dates to set
     */
    public void setDates(List<PersonDate> dates) {
        this.dates = dates;
    }

    /**
     * @return the titles
     */
    public List<PersonTitle> getTitles() {
        return titles;
    }

    /**
     * @param titles the titles to set
     */
    public void setTitles(List<PersonTitle> titles) {
        this.titles = titles;
    }

    /**
     * @return the designations
     */
    public List<PersonDesignation> getDesignations() {
        return designations;
    }

    /**
     * @param designations the designations to set
     */
    public void setDesignations(List<PersonDesignation> designations) {
        this.designations = designations;
    }

    /**
     * @return the genders
     */
    public List<PersonGender> getGenders() {
        return genders;
    }

    /**
     * @param genders the genders to set
     */
    public void setGenders(List<PersonGender> genders) {
        this.genders = genders;
    }

    /**
     * @return the birthPlaces
     */
    public List<PersonBirthPlace> getBirthPlaces() {
        return birthPlaces;
    }

    /**
     * @param birthPlaces the birthPlaces to set
     */
    public void setBirthPlaces(List<PersonBirthPlace> birthPlaces) {
        this.birthPlaces = birthPlaces;
    }

    /**
     * @return the deathPlaces
     */
    public List<PersonDeathPlace> getDeathPlaces() {
        return deathPlaces;
    }

    /**
     * @param deathPlaces the deathPlaces to set
     */
    public void setDeathPlaces(List<PersonDeathPlace> deathPlaces) {
        this.deathPlaces = deathPlaces;
    }

    /**
     * @return the countries
     */
    public List<PersonCountry> getCountries() {
        return countries;
    }

    /**
     * @param countries the countries to set
     */
    public void setCountries(List<PersonCountry> countries) {
        this.countries = countries;
    }

    /**
     * @return the residencePlaces
     */
    public List<PersonResidencePlace> getResidencePlaces() {
        return residencePlaces;
    }

    /**
     * @param residencePlaces the residencePlaces to set
     */
    public void setResidencePlaces(List<PersonResidencePlace> residencePlaces) {
        this.residencePlaces = residencePlaces;
    }

    /**
     * @return the affiliations
     */
    public List<PersonAffiliation> getAffiliations() {
        return affiliations;
    }

    /**
     * @param affiliations the affiliations to set
     */
    public void setAffiliations(List<PersonAffiliation> affiliations) {
        this.affiliations = affiliations;
    }

    /**
     * @return the addresses
     */
    public List<PersonAddress> getAddresses() {
        return addresses;
    }

    /**
     * @param addresses the addresses to set
     */
    public void setAddresses(List<PersonAddress> addresses) {
        this.addresses = addresses;
    }

    /**
     * @return the languages
     */
    public List<PersonLanguage> getLanguages() {
        return languages;
    }

    /**
     * @param languages the languages to set
     */
    public void setLanguages(List<PersonLanguage> languages) {
        this.languages = languages;
    }

    /**
     * @return the activityFields
     */
    public List<PersonActivityField> getActivityFields() {
        return activityFields;
    }

    /**
     * @param activityFields the activityFields to set
     */
    public void setActivityFields(List<PersonActivityField> activityFields) {
        this.activityFields = activityFields;
    }

    /**
     * @return the professions
     */
    public List<PersonProfession> getProfessions() {
        return professions;
    }

    /**
     * @param professions the professions to set
     */
    public void setProfessions(List<PersonProfession> professions) {
        this.professions = professions;
    }

    /**
     * @return the biographies
     */
    public List<PersonBiography> getBiographies() {
        return biographies;
    }

    /**
     * @param biographies the biographies to set
     */
    public void setBiographies(List<PersonBiography> biographies) {
        this.biographies = biographies;
    }

    /**
     * @return the notes
     */
    public List<PersonNote> getNotes() {
        return notes;
    }

    /**
     * @param notes the notes to set
     */
    public void setNotes(List<PersonNote> notes) {
        this.notes = notes;
    }

    /**
     * @return the isComposerOfWorks
     */
    public List<WorkToResponsibleParty> getIsComposerOfWorks() {
        return isComposerOfWorks;
    }

    /**
     * @param isComposerOfWorks the isComposerOfWorks to set
     */
    public void setIsComposerOfWorks(List<WorkToResponsibleParty> isComposerOfWorks) {
        this.isComposerOfWorks = isComposerOfWorks;
    }

    /**
     * @return the isRealizerOfExpressions
     */
    public List<ExpressionToResponsibleParty> getIsRealizerOfExpressions() {
        return isRealizerOfExpressions;
    }

    /**
     * PersonJpa isProducer for Manifestation.
     * Target end of Producer
     * ManifestationToResponsibleParty
     * for PersonJpa.
     * @return the isProducerOfManifestations
     */
    public List<ManifestationToResponsibleParty> getIsProducerOfManifestations() {
        return isProducerOfManifestations;
    }
}
