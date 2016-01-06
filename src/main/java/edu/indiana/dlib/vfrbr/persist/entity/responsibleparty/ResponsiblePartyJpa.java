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

import edu.indiana.dlib.vfrbr.persist.entity.VfrbrEntity;
import java.io.Serializable;
import javax.persistence.*;

/**
 * root for "responsible party" entities.
 * Entities that can act as parties of responsiblity (or subjects)
 * for products.
 */
@Entity
@Table(name = "RESPON_ENT")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "RESPON_CLASS",
                     discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("ResponsibleParty")
public class ResponsiblePartyJpa
        implements Serializable,
                   VfrbrEntity {

    /**
     * Database id
     * (Persistence).
     */
    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RESPON_ENT_ID")
    protected int id;

    /**
     * Version to support concurrency processing
     * (Persistence).
     */
    @Column(name = "RESPON_ENT_VERSION")
    @Version
    protected int version;

    /**
     * XML element attribute: identifier
     * of type xsd:anyURI
     * (VFRBR).
     */
    @Column(name = "RESPON_ENT_URI",
            length = 512)
    protected String URI;

    /**
     * normalized name identifier
     * from NormalIdent
     *  content identifier
     */
    @Column(name = "RESPON_ENT_AUTHIDENT",
            length = 2024)
    protected String authIdent;

    /**
     * authorizedName of the ResponsiblePartyJpa.
     * Initially used for Person contributor.
     * (VFRBR).
     */
    @Column(name = "AUTHORIZED_NAME",
            length = 2024)
    protected String authorizedName;

    /**
     * Catalog status.
     * Initially used for Person contributor.
     * (VFRBR).
     */
    @Column(name = "CATALOG_STATUS",
            length = 64)
    protected String catalogStatus;

    /**
     * Catalog source.
     * Initially used for Person contributor.
     * (VFRBR)
     */
    @Column(name = "CATALOG_SOURCE",
            length = 64)
    protected String catalogSource;

    /**
     * ResponsiblePartyJpa root for Person, Family, CorporateBody
     *
     * Not intended to be instantiated, hence protected constructor.
     */
    protected ResponsiblePartyJpa() {
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
     * @return the authorizedName
     */
    public String getAuthorizedName() {
        return authorizedName;
    }

    /**
     * @param authorizedName the authorizedName to set
     */
    public void setAuthorizedName(String authorizedName) {
        this.authorizedName = authorizedName;
    }

    /**
     * @return the catalogStatus
     */
    public String getCatalogStatus() {
        return catalogStatus;
    }

    /**
     * @param catalogStatus the catalogStatus to set
     */
    public void setCatalogStatus(String catalogStatus) {
        this.catalogStatus = catalogStatus;
    }

    /**
     * @return the catalogSource
     */
    public String getCatalogSource() {
        return catalogSource;
    }

    /**
     * @param catalogSource the catalogSource to set
     */
    public void setCatalogSource(String catalogSource) {
        this.catalogSource = catalogSource;
    }

    /**
     * normalized name identifier
     * from NormalIdent
     * content identifier
     * @return the authIdent
     */
    public String getAuthIdent() {
        return authIdent;
    }

    /**
     * normalized name identifier
     * from NormalIdent
     * content identifier
     * @param authIdent the authIdent to set
     */
    public void setAuthIdent(String authIdent) {
        this.authIdent = authIdent;
    }
}
