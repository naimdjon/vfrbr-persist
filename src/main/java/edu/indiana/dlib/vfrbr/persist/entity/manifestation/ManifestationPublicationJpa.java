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

import java.io.Serializable;
import javax.persistence.*;

/**
 *  Publication attribute collection for ManifestationJpa.
 */
@Entity
@Table(name = "MANIF_PUB")
public class ManifestationPublicationJpa
        implements Serializable {

    /**
     * Database id
     * (Persistence)
     */
    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MANIF_PUB_ID")
    protected int id;

    /**
     * The ManifestationJpa entity of this attribute
     * (Persistence).
     */
    @ManyToOne
    @JoinColumn(name = "MANIF_ENT_ID",
                referencedColumnName = "MANIF_ENT_ID",
                nullable = false)
    protected ManifestationJpa manifestation;

    /**
     * Version support for concurrency protection
     * (Persistence).
     */
    @Column(name = "MANIF_PUB_VERSION")
    @Version
    protected int version;

    /**
     * The ordering for a list
     * of multiple publications
     * (VFRBR).
     */
    @Column(name = "MANIF_PUB_LIST_ORDER")
    protected int listOrder;

    /**
     * placeOfPublicationDistribution
     */
    @OneToOne(cascade = {CascadeType.ALL},
              mappedBy = "manifestationPublication")
    protected ManifestationPublicationPlace place;

    /**
     * publisherDistributor
     */
    @OneToOne(cascade = {CascadeType.ALL},
              mappedBy = "manifestationPublication")
    protected ManifestationPublicationPublisher publisher;

    /**
     * dateOfPublicationDistribution
     */
    @OneToOne(cascade = {CascadeType.ALL},
              mappedBy = "manifestationPublication")
    protected ManifestationPublicationDate date;

    /*
     * ---- constructors
     */
    public ManifestationPublicationJpa() {
    }

    public ManifestationPublicationJpa(
            ManifestationJpa manifestation) {
        this.setManifestation(manifestation);
    }

    public ManifestationPublicationJpa(
            ManifestationJpa manifestation,
            ManifestationPublicationPlace place,
            ManifestationPublicationPublisher publisher,
            ManifestationPublicationDate date) {
        this.setManifestation(manifestation);
        this.setPlace(place);
        this.setDate(date);
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @return the manifestation
     */
    public ManifestationJpa getManifestation() {
        return manifestation;
    }

    /**
     * @param manifestation the manifestation to set
     */
    public void setManifestation(ManifestationJpa manifestation) {
        this.manifestation = manifestation;
    }

    /**
     * @return the version
     */
    public int getVersion() {
        return version;
    }

    /**
     * @return the listOrder
     */
    public int getListOrder() {
        return listOrder;
    }

    /**
     * @param listOrder the listOrder to set
     */
    public void setListOrder(int listOrder) {
        this.listOrder = listOrder;
    }

    /**
     * @return the place
     */
    public ManifestationPublicationPlace getPlace() {
        return place;
    }

    /**
     * @param place the place to set
     */
    public void setPlace(ManifestationPublicationPlace place) {
        this.place = place;
    }

    /**
     * @return the publisher
     */
    public ManifestationPublicationPublisher getPublisher() {
        return publisher;
    }

    /**
     * @param publisher the publisher to set
     */
    public void setPublisher(ManifestationPublicationPublisher publisher) {
        this.publisher = publisher;
    }

    /**
     * @return the date
     */
    public ManifestationPublicationDate getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(ManifestationPublicationDate date) {
        this.date = date;
    }
}
