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
package edu.indiana.dlib.vfrbr.persist.dao;

import edu.indiana.dlib.vfrbr.persist.entity.manifestation.ManifestationJpa;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author pbmcelwa
 */
public class ManifestationDAO
        implements VfrbrEntityDAO {

    private EntityManager em;

    /**
     * Protected constructor,
     * obtain instance from DAOFactory.
     */
    protected ManifestationDAO(EntityManager em) {
        this.em = em;
    }

    @Override
    public int countAll() {

        Query qry = this.em.createNativeQuery(
                "select count(*) from MANIF_ENT");

        return ((Long) qry.getSingleResult()).intValue();
    }

    @Override
    public List<ManifestationJpa> getAll() {

        Query qry = this.em.createQuery(
                "select manif from ManifestationJpa manif");

        return qry.getResultList();
    }

    @Override
    public List<Integer> getAllIds() {

        Query qry = this.em.createQuery(
                "select manif.id from ManifestationJpa manif");

        return qry.getResultList();
    }

    @Override
    public ManifestationJpa getById(Integer idInt) {

        return this.em.find(ManifestationJpa.class, idInt.intValue());
    }

    @Override
    public ManifestationJpa getNew() {

        return new ManifestationJpa();
    }

    @Override
    public <ManifestationJpa> void persist(ManifestationJpa manif) {

        this.em.persist(manif);
    }

    public void reportManifNoWork(ManifestationJpa manif,
                                  String marcBibRecId,
                                  String marcBibRecGroup,
                                  String marcFileName,
                                  int marcFileRecNum) {
        
        Query qry = this.em.createNativeQuery(""
                + "insert into FIZ_REP_MANIFNOWORK \n"
                + "set DB_ID               = ?1, \n"
                + "    TITLE               = ?2, \n"
                + "    CONTRIB_TYPE        = ?3, \n"
                + "    CONTRIB_AUTHNAME    = ?4, \n"
                + "    CONTRIB_AUTHIDENT   = ?5, \n"
                + "    CONTRIB_ROLE        = ?6, \n"
                + "    BIBREC_ID           = ?7, \n"
                + "    BIBREC_GROUP        = ?8, \n"
                + "    MARC_FILENAME       = ?9, \n"
                + "    MARC_RECNUM         = ?10 \n");

        // -- manif.id
        qry.setParameter(1, manif.getId());

        // -- manif.titles(0).text
        if (manif.getTitles().isEmpty()) {
            qry.setParameter(2, null);
        } else {
            qry.setParameter(2, manif.getTitles().get(0).getText());
        }

        // contributor
        if (!manif.getHasProducerPersons().isEmpty()) {
            // person contributor
            // -- type
            qry.setParameter(3, "person");
            // -- authorizedName
            qry.setParameter(4, manif.getHasProducerPersons().get(0).
                    getTargetResponsibleParty().getAuthorizedName());
            // -- authIdent
            qry.setParameter(5, manif.getHasProducerPersons().get(0).
                    getTargetResponsibleParty().getAuthIdent());
            // -- role
            qry.setParameter(6, "producedBy");

        } else if (!manif.getHasProducerCorporateBodies().isEmpty()) {
            // corporateBody contributor
            // -- type
            qry.setParameter(3, "corporateBody");
            // -- authorizedName
            qry.setParameter(4, manif.getHasProducerCorporateBodies().get(0).
                    getTargetResponsibleParty().getAuthorizedName());
            // -- authIdent
            qry.setParameter(5, manif.getHasProducerCorporateBodies().get(0).
                    getTargetResponsibleParty().getAuthIdent());
            // -- role
            qry.setParameter(6, "producedBy");
        } else {
            // no contributor
            // -- type
            qry.setParameter(3, "null");
            // -- authorizedName
            qry.setParameter(4, "null");
            // -- authIdent
            qry.setParameter(5, "null");
            // -- role
            qry.setParameter(6, "null");
        }

        // -- MARC bib rec id (control number)
        qry.setParameter(7, marcBibRecId);

        // -- MARC bib rec group type
        qry.setParameter(8, marcBibRecGroup);

        // -- MARC data file name
        qry.setParameter(9, marcFileName);

        // -- MARC data file record number
        qry.setParameter(10, marcFileRecNum);

        qry.executeUpdate();
    }
}
