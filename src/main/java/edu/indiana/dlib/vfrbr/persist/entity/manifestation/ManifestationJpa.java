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
package edu.indiana.dlib.vfrbr.persist.entity.manifestation;

import edu.indiana.dlib.vfrbr.persist.entity.VfrbrEntity;
import edu.indiana.dlib.vfrbr.persist.relation.ExpressionToManifestation;
import edu.indiana.dlib.vfrbr.persist.relation.ManifestationToItem;
import edu.indiana.dlib.vfrbr.persist.relation.ManifestationToResponsibleParty;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

/**
 *  ManifestationJpa entity
 *
 */
@Entity
@Table(name = "MANIF_ENT")
public class ManifestationJpa
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
    @Column(name = "MANIF_ENT_ID")
    protected int id;

    /**
     * Version support to concurrency protection
     * (Persistence).
     */
    @Column(name = "MANIF_ENT_VERSION")
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
    @Column(name = "MANIF_ENT_URI",
            length = 512)
    protected String URI;

    /**
     *  formOfExpression
     * Denormalized to the Manifestion
     * for performan determination of form
     * at the Manifestation level
     * and for Manifestations with no Work/Expression
     */
    @Column(name = "EXPR_FORM",
            length = 64)
    protected String formOfExpression;

    /**
     *  titleOfTheManifestation
     * (FRBR).
     */
    @OneToMany(cascade = {CascadeType.ALL},
               mappedBy = "manifestation")
    @OrderBy("listOrder ASC")
    protected List<ManifestationTitle> titles =
            new ArrayList<ManifestationTitle>();

    /**
     *  statementOfResponsibility
     * (FRBR).
     */
    @OneToMany(cascade = {CascadeType.ALL},
               mappedBy = "manifestation")
    protected List<ManifestationResponsibility> responsibilities =
            new ArrayList<ManifestationResponsibility>();

    /**
     *  editionIssueDesignation
     * (FRBR).
     */
    @OneToMany(cascade = {CascadeType.ALL},
               mappedBy = "manifestation")
    protected List<ManifestationDesignation> designations =
            new ArrayList<ManifestationDesignation>();

    /**
     * publication:
     *  placeOfPublicationDistribution
     *  publisherDistributor
     *  dateOfPublicationDistribution
     * (FRBR/VFRBR).
     */
    @OneToMany(cascade = {CascadeType.ALL},
               mappedBy = "manifestation")
    @OrderBy("listOrder ASC")
    protected List<ManifestationPublicationJpa> publications =
            new ArrayList<ManifestationPublicationJpa>();

    /**
     *  fabricatorManufacturer
     * (FRBR).
     */
    @OneToMany(cascade = {CascadeType.ALL},
               mappedBy = "manifestation")
    @OrderBy("listOrder ASC")
    protected List<ManifestationFabricator> fabricators =
            new ArrayList<ManifestationFabricator>();

    /**
     *  seriesStatement
     * (FRBR).
     */
    @OneToMany(cascade = {CascadeType.ALL},
               mappedBy = "manifestation")
    @OrderBy("listOrder ASC")
    protected List<ManifestationSeriesStatement> seriesStmts =
            new ArrayList<ManifestationSeriesStatement>();

    /**
     *  formOfCarrier
     * (FRBR).
     */
    @OneToMany(cascade = {CascadeType.ALL},
               mappedBy = "manifestation")
    @OrderBy("listOrder ASC")
    protected List<ManifestationCarrierForm> carrierForms =
            new ArrayList<ManifestationCarrierForm>();

    /**
     *  extentOfTheCarrier
     * (FRBR).
     */
    @OneToMany(cascade = {CascadeType.ALL},
               mappedBy = "manifestation")
    @OrderBy("listOrder ASC")
    protected List<ManifestationCarrierExtent> carrierExtents =
            new ArrayList<ManifestationCarrierExtent>();

    /**
     *  physicalMedium
     * (FRBR).
     */
    @OneToMany(cascade = {CascadeType.ALL},
               mappedBy = "manifestation")
    @OrderBy("listOrder ASC")
    protected List<ManifestationPhysicalMedium> physicalMediums =
            new ArrayList<ManifestationPhysicalMedium>();

    /**
     *  captureMode
     * (FRBR).
     */
    @OneToMany(cascade = {CascadeType.ALL},
               mappedBy = "manifestation")
    @OrderBy("listOrder ASC")
    protected List<ManifestationCaptureMode> captureModes =
            new ArrayList<ManifestationCaptureMode>();

    /**
     *  dimensionsOfTheCarrier
     * (FRBR).
     */
    @OneToMany(cascade = {CascadeType.ALL},
               mappedBy = "manifestation")
    @OrderBy("listOrder ASC")
    protected List<ManifestationCarrierDimension> carrierDimensions =
            new ArrayList<ManifestationCarrierDimension>();

    /**
     *  manifestationIdentifier
     * (FRBR).
     */
    @OneToMany(cascade = {CascadeType.ALL},
               mappedBy = "manifestation")
    @OrderBy("listOrder ASC")
    protected List<ManifestationIdentifier> identifiers =
            new ArrayList<ManifestationIdentifier>();

    /**
     *  sourceForAcquisitionAccessAuthority
     * (FRBR).
     */
    @OneToMany(cascade = {CascadeType.ALL},
               mappedBy = "manifestation")
    @OrderBy("listOrder ASC")
    protected List<ManifestationAAASource> acqAccAuthSources =
            new ArrayList<ManifestationAAASource>();

    /**
     *  accessRestrictionsOnTheManifestation
     * (FRBR).
     */
    @OneToMany(cascade = {CascadeType.ALL},
               mappedBy = "manifestation")
    @OrderBy("listOrder ASC")
    protected List<ManifestationAccessRestriction> accessRestrictions =
            new ArrayList<ManifestationAccessRestriction>();

    /**
     *  playingSpeed
     * (FRBR).
     */
    @OneToMany(cascade = {CascadeType.ALL},
               mappedBy = "manifestation")
    @OrderBy("listOrder ASC")
    protected List<ManifestationPlayingSpeed> playingSpeeds =
            new ArrayList<ManifestationPlayingSpeed>();

    /**
     *  tapeConfiguration
     * (FRBR).
     */
    @OneToMany(cascade = {CascadeType.ALL},
               mappedBy = "manifestation")
    @OrderBy("listOrder ASC")
    protected List<ManifestationTapeConfiguration> tapeConfigs =
            new ArrayList<ManifestationTapeConfiguration>();

    /**
     *  kindOfSound
     * (FRBR).
     */
    @OneToMany(cascade = {CascadeType.ALL},
               mappedBy = "manifestation")
    @OrderBy("listOrder ASC")
    protected List<ManifestationSoundKind> soundKinds =
            new ArrayList<ManifestationSoundKind>();

    /**
     *  specialReproductionCharacteristic
     * (FRBR).
     */
    @OneToMany(cascade = {CascadeType.ALL},
               mappedBy = "manifestation")
    @OrderBy("listOrder ASC")
    protected List<ManifestationReproductionCharacteristic> reproChars =
            new ArrayList<ManifestationReproductionCharacteristic>();

    /**
     * fileCharacteristics
     * (FRBR).
     */
    @OneToMany(cascade = {CascadeType.ALL},
               mappedBy = "manifestation")
    @OrderBy("listOrder ASC")
    protected List<ManifestationFileCharacteristic> fileChars =
            new ArrayList<ManifestationFileCharacteristic>();

    /**
     *  modeOfAccess
     * (FRBR).
     */
    @OneToMany(cascade = {CascadeType.ALL},
               mappedBy = "manifestation")
    @OrderBy("listOrder ASC")
    protected List<ManifestationAccessMode> accessModes =
            new ArrayList<ManifestationAccessMode>();

    /**
     *  accessAddress
     * (FRBR).
     */
    @OneToMany(cascade = {CascadeType.ALL},
               mappedBy = "manifestation")
    @OrderBy("listOrder ASC")
    protected List<ManifestationAccessAddress> accessAddresses =
            new ArrayList<ManifestationAccessAddress>();

    /**
     *  note
     * (VFRBR).
     */
    @OneToMany(cascade = {CascadeType.ALL},
               mappedBy = "manifestation")
    @OrderBy("listOrder ASC")
    protected List<ManifestationNote> notes =
            new ArrayList<ManifestationNote>();

    /**
     *  languageOfAccompanyingMaterials
     * (VFRBR).
     */
    @OneToMany(cascade = {CascadeType.ALL},
               mappedBy = "manifestation")
    @OrderBy("listOrder ASC")
    protected List<ManifestationAccompanyingLanguage> accompLangs =
            new ArrayList<ManifestationAccompanyingLanguage>();

    /*
     *     ---------------------
     * ---- relationship fields
     *     ---------------------
     */

    /* -- alternate --
     *  ManifestationToManifestation
     */
    /**
     * ManifestationJpa hasAlternate of ManifestationJpa.
     * Source end of Alternate
     * ManifestationToManifestation relationship.
     */
    // TODO -- ManifestationJpa hasAlternate ManifestationJpa
    //
    /**
     * ManifestationJpa isAlternate for ManifestationJpa.
     * Target end of Alternate
     * ManifestationToManifestation relationship.
     */
    // TODO -- ManifestationJpa isAlternate for ManifestationJpa

    /* -- embodiment --
     *  ExpressionToManifestation
     */
    /**
     * ManifestationJpa isEmbodiment for Expression.
     * Target end of Embodiment
     * ExpressionToManifestation relationship.
     */
    @OneToMany(cascade = {CascadeType.PERSIST,
                          CascadeType.MERGE,
                          CascadeType.REFRESH},
               mappedBy = "targetManifestation")
    @OrderBy("listOrder ASC")
    protected List<ExpressionToManifestation> isEmbodiment =
            new ArrayList<ExpressionToManifestation>();

    /* -- exemplification --
     *  ManifestationToItem
     */
    /**
     * ManifestationJpa hasExemplification of Item.
     * Source end of Exemplification
     * ManifestationToItem relationship.
     */
    @OneToMany(cascade = {CascadeType.PERSIST,
                          CascadeType.MERGE,
                          CascadeType.REFRESH},
               mappedBy = "sourceManifestation")
    @OrderBy("listOrder ASC")
    protected List<ManifestationToItem> hasExemplifications =
            new ArrayList<ManifestationToItem>();

    /* -- part --
     *  ManifestationToManifestation
     */
    /**
     * ManifestationJpa hasPart of ManifestationJpa.
     * Source end of Part 
     * ManifestationToManifestation relationship.
     */
    // TODO -- ManifestationJpa hasPart of ManifestationJpa
    //
    /**
     * ManifestationJpa isPart for ManifestationJpa.
     * Target end of Part 
     * ManifestationToManifestation relationship.
     */
    // TODO -- ManifestationJpa isPart for ManifestationJpa
    //

    /* -- producer --
     *      <CorporateBody>
     *      <Person>
     *  ManifestationToResponsibleParty
     */
    /**
     * ManifestationJpa hasProducer of CorporateBody.
     * Source end of Producer
     * ManifestationToResponsibleParty
     * for CorporateBody.
     */
    @OneToMany(cascade = {CascadeType.PERSIST,
                          CascadeType.MERGE,
                          CascadeType.REFRESH},
               mappedBy = "sourceManifestation")
    @OrderBy("listOrder ASC")
    protected List<ManifestationToResponsibleParty> hasProducerCorporateBodies =
            new ArrayList<ManifestationToResponsibleParty>();

    /**
     * ManifestationJpa hasProducer of Person.
     * Source end of Producer
     * ManifestationToResponsibleParty
     * for Person.
     */
    @OneToMany(cascade = {CascadeType.PERSIST,
                          CascadeType.MERGE,
                          CascadeType.REFRESH},
               mappedBy = "sourceManifestation")
    @OrderBy("listOrder ASC")
    protected List<ManifestationToResponsibleParty> hasProducerPersons =
            new ArrayList<ManifestationToResponsibleParty>();

    /* -- reproduction --
     *  ManifestationToManifestation
     *  ManifestationToItem
     */
    /**
     * ManifestationJpa hasReproduction of ManifestationJpa.
     * Source end of Reproduction
     * ManifestationToManifestation relationship.
     */
    // TODO -- ManifestationJpa hasReproduction of ManifestationJpa
    //
    /**
     * ManifestationJpa isReproduction for ManifestationJpa.
     * Target end of Reproduction
     * ManifestationToManifestation relationship.
     */
    // TODO -- ManifestationJpa isReproduction for ManifestationJpa
    //
    /**
     * ManifestationJpa hasReproduction of Item.
     * Source end of Reproduction
     * ManifestationToItem relationship.
     */
    // TODO -- ManifestationJpa hasReproduction of Item
    //

    /* -- subject --
     *  WorkToManifestation
     */
    /**
     * ManifestationJpa isSubject for Work.
     * Target end of Subject
     * WorkToManifestation relationship.
     */
    // TODO -- ManifestationJpa isSubject for Work
    //
    /**
     * Simple constructor
     */
    public ManifestationJpa() {
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
     * formOfExpression
     * Denormalized to the Manifestion
     * for performan determination of form
     * at the Manifestation level
     * and for Manifestations with no Work/Expression
     * @return the formOfExpression
     */
    public String getFormOfExpression() {
        return formOfExpression;
    }

    /**
     * formOfExpression
     * Denormalized to the Manifestion
     * for performan determination of form
     * at the Manifestation level
     * and for Manifestations with no Work/Expression
     * @param formOfExpression the formOfExpression to set
     */
    public void setFormOfExpression(String formOfExpression) {
        this.formOfExpression = formOfExpression;
    }

    /**
     * @return the titles
     */
    public List<ManifestationTitle> getTitles() {
        return titles;
    }

    /**
     * @param titles the titles to set
     */
    public void setTitles(List<ManifestationTitle> titles) {
        this.titles = titles;
    }

    /**
     * @return the responsibility
     */
    public List<ManifestationResponsibility> getResponsibilities() {
        return responsibilities;
    }

    /**
     * @param responsibility the responsibility to set
     */
    public void setResponsibilities(
            List<ManifestationResponsibility> responsibilities) {
        this.responsibilities = responsibilities;
    }

    /**
     * @return the designation
     */
    public List<ManifestationDesignation> getDesignations() {
        return designations;
    }

    /**
     * @param designation the designation to set
     */
    public void setDesignations(List<ManifestationDesignation> designations) {
        this.designations = designations;
    }

    /**
     * @return the publications
     */
    public List<ManifestationPublicationJpa> getPublications() {
        return publications;
    }

    /**
     * @param publications the publications to set
     */
    public void setPublications(List<ManifestationPublicationJpa> publications) {
        this.publications = publications;
    }

    /**
     * @return the fabricators
     */
    public List<ManifestationFabricator> getFabricators() {
        return fabricators;
    }

    /**
     * @param fabricators the fabricators to set
     */
    public void setFabricators(List<ManifestationFabricator> fabricators) {
        this.fabricators = fabricators;
    }

    /**
     * @return the seriesStmts
     */
    public List<ManifestationSeriesStatement> getSeriesStmts() {
        return seriesStmts;
    }

    /**
     * @param seriesStmts the seriesStmts to set
     */
    public void setSeriesStmts(List<ManifestationSeriesStatement> seriesStmts) {
        this.seriesStmts = seriesStmts;
    }

    /**
     * @return the carrierForms
     */
    public List<ManifestationCarrierForm> getCarrierForms() {
        return carrierForms;
    }

    /**
     * @param carrierForms the carrierForms to set
     */
    public void setCarrierForms(List<ManifestationCarrierForm> carrierForms) {
        this.carrierForms = carrierForms;
    }

    /**
     * @return the carrierExtents
     */
    public List<ManifestationCarrierExtent> getCarrierExtents() {
        return carrierExtents;
    }

    /**
     * @param carrierExtents the carrierExtents to set
     */
    public void setCarrierExtents(
            List<ManifestationCarrierExtent> carrierExtents) {
        this.carrierExtents = carrierExtents;
    }

    /**
     * @return the physicalMediums
     */
    public List<ManifestationPhysicalMedium> getPhysicalMediums() {
        return physicalMediums;
    }

    /**
     * @param physicalMediums the physicalMediums to set
     */
    public void setPhysicalMediums(
            List<ManifestationPhysicalMedium> physicalMediums) {
        this.physicalMediums = physicalMediums;
    }

    /**
     * @return the captureModes
     */
    public List<ManifestationCaptureMode> getCaptureModes() {
        return captureModes;
    }

    /**
     * @param captureModes the captureModes to set
     */
    public void setCaptureModes(List<ManifestationCaptureMode> captureModes) {
        this.captureModes = captureModes;
    }

    /**
     * @return the carrierDimensions
     */
    public List<ManifestationCarrierDimension> getCarrierDimensions() {
        return carrierDimensions;
    }

    /**
     * @param carrierDimensions the carrierDimensions to set
     */
    public void setCarrierDimensions(
            List<ManifestationCarrierDimension> carrierDimensions) {
        this.carrierDimensions = carrierDimensions;
    }

    /**
     * @return the identifiers
     */
    public List<ManifestationIdentifier> getIdentifiers() {
        return identifiers;
    }

    /**
     * @param identifiers the identifiers to set
     */
    public void setIdentifiers(List<ManifestationIdentifier> identifiers) {
        this.identifiers = identifiers;
    }

    /**
     * @return the acqAccAuthSources
     */
    public List<ManifestationAAASource> getAcqAccAuthSources() {
        return acqAccAuthSources;
    }

    /**
     * @param acqAccAuthSources the acqAccAuthSources to set
     */
    public void setAcqAccAuthSources(
            List<ManifestationAAASource> acqAccAuthSources) {
        this.acqAccAuthSources = acqAccAuthSources;
    }

    /**
     * @return the accessRestrictions
     */
    public List<ManifestationAccessRestriction> getAccessRestrictions() {
        return accessRestrictions;
    }

    /**
     * @param accessRestrictions the accessRestrictions to set
     */
    public void setAccessRestrictions(
            List<ManifestationAccessRestriction> accessRestrictions) {
        this.accessRestrictions = accessRestrictions;
    }

    /**
     * @return the playingSpeeds
     */
    public List<ManifestationPlayingSpeed> getPlayingSpeeds() {
        return playingSpeeds;
    }

    /**
     * @param playingSpeeds the playingSpeeds to set
     */
    public void setPlayingSpeeds(List<ManifestationPlayingSpeed> playingSpeeds) {
        this.playingSpeeds = playingSpeeds;
    }

    /**
     * @return the tapeConfigs
     */
    public List<ManifestationTapeConfiguration> getTapeConfigs() {
        return tapeConfigs;
    }

    /**
     * @param tapeConfigs the tapeConfigs to set
     */
    public void setTapeConfigs(List<ManifestationTapeConfiguration> tapeConfigs) {
        this.tapeConfigs = tapeConfigs;
    }

    /**
     * @return the soundKinds
     */
    public List<ManifestationSoundKind> getSoundKinds() {
        return soundKinds;
    }

    /**
     * @param soundKinds the soundKinds to set
     */
    public void setSoundKinds(List<ManifestationSoundKind> soundKinds) {
        this.soundKinds = soundKinds;
    }

    /**
     * @return the reproChars
     */
    public List<ManifestationReproductionCharacteristic> getReproChars() {
        return reproChars;
    }

    /**
     * @param reproChars the reproChars to set
     */
    public void setReproChars(
            List<ManifestationReproductionCharacteristic> reproChars) {
        this.reproChars = reproChars;
    }

    /**
     * @return the fileChars
     */
    public List<ManifestationFileCharacteristic> getFileChars() {
        return fileChars;
    }

    /**
     * @param fileChars the fileChars to set
     */
    public void setFileChars(List<ManifestationFileCharacteristic> fileChars) {
        this.fileChars = fileChars;
    }

    /**
     * @return the accessModes
     */
    public List<ManifestationAccessMode> getAccessModes() {
        return accessModes;
    }

    /**
     * @param accessModes the accessModes to set
     */
    public void setAccessModes(List<ManifestationAccessMode> accessModes) {
        this.accessModes = accessModes;
    }

    /**
     * @return the accessAddresses
     */
    public List<ManifestationAccessAddress> getAccessAddresses() {
        return accessAddresses;
    }

    /**
     * @param accessAddresses the accessAddresses to set
     */
    public void setAccessAddresses(
            List<ManifestationAccessAddress> accessAddresses) {
        this.accessAddresses = accessAddresses;
    }

    /**
     * @return the notes
     */
    public List<ManifestationNote> getNotes() {
        return notes;
    }

    /**
     * @param notes the notes to set
     */
    public void setNotes(List<ManifestationNote> notes) {
        this.notes = notes;
    }

    /**
     * @return the accompLangs
     */
    public List<ManifestationAccompanyingLanguage> getAccompLangs() {
        return accompLangs;
    }

    /**
     * @param accompLangs the accompLangs to set
     */
    public void setAccompLangs(
            List<ManifestationAccompanyingLanguage> accompLangs) {
        this.accompLangs = accompLangs;
    }

    /**
     * @return the isEmbodiment
     */
    public List<ExpressionToManifestation> getIsEmbodiment() {
        return isEmbodiment;
    }

    /**
     * @param isEmbodiment the isEmbodiment to set
     */
    public void setIsEmbodiment(List<ExpressionToManifestation> isEmbodiment) {
        this.isEmbodiment = isEmbodiment;
    }

    /**
     * @return the hasExemplifications
     */
    public List<ManifestationToItem> getHasExemplifications() {
        return hasExemplifications;
    }

    /**
     * @param hasExemplifications the hasExemplifications to set
     */
    public void setHasExemplifications(
            List<ManifestationToItem> hasExemplifications) {
        this.hasExemplifications = hasExemplifications;
    }

    /**
     * ManifestationJpa hasProducer of CorporateBody.
     * Source end of Producer
     * ManifestationToResponsibleParty
     * for CorporateBody.
     * @return the hasProducerCorporateBodies
     */
    public List<ManifestationToResponsibleParty> getHasProducerCorporateBodies() {
        return hasProducerCorporateBodies;
    }

    /**
     * ManifestationJpa hasProducer of Person.
     * Source end of Producer
     * ManifestationToResponsibleParty
     * for Person.
     * @return the hasProducerPersons
     */
    public List<ManifestationToResponsibleParty> getHasProducerPersons() {
        return hasProducerPersons;
    }
}
