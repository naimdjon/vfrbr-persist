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

import edu.indiana.dlib.vfrbr.persist.entity.responsibleparty.CorporateBodyJpa;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author pbmcelwa
 */
public class CorporateBodyDAO
        implements VfrbrEntityDAO {

    private EntityManager em;

    /**
     * Protected constructor,
     * obtain instance from DAOFactory
     */
    protected CorporateBodyDAO(EntityManager em) {

        this.em = em;
    }

    /*
     * -- VfrbrEntityDAO Interface methods
     */
    @Override
    public int countAll() {

        Query qry = this.em.createNativeQuery(
                "select count(*) from RESPON_ENT \n"
                + "where RESPON_CLASS = 'CorporateBody' \n");

        return ((Long) qry.getSingleResult()).intValue();
    }

    public int countByAuthIdent(String authIdent) {

        Query qry = this.em.createQuery(
                "select count(corp) "
                + "from CorporateBodyJpa corp "
                + "where corp.authIdent = ?1 ");
        qry.setParameter(1, authIdent);

        return ((Long) qry.getSingleResult()).intValue();
    }

    public int countName(String name) {

        if (name == null) {
            return -1;
        } else {
            Query qry = this.em.createQuery(
                    "select count(corp) "
                    + "from CorporateBodyJpa corp, in(corp.names) name "
                    + "where name.text = ?1 ");
            qry.setParameter(1, name);

            return ((Long) qry.getSingleResult()).intValue();
        }
    }

    public int countByNormalName(String normalName) {

        if (normalName == null) {
            return -1;
        } else {
            Query qry = this.em.createQuery(
                    "select count(distinct corp) "
                    + "from CorporateBodyJpa corp,"
                    + "  in (corp.names) name "
                    + "where name.normal = ?1 ");
            qry.setParameter(1, normalName);

            return ((Long) qry.getSingleResult()).intValue();
        }
    }

    /**
     * Query for matching corporateBody in persistence.
     * @param name nameOfTheCorporateBody (CorporateBodyName)
     * @param place placeAssociatedWithTheCorporateBody (CorporateBodyPlace)
     * @param date dateAssociatedWithTheCorporateBody (CorporateBodyDate)
     * @return int count of matches
     */
    public int countMatches(String name,
                            String place,
                            String date) {
        int count = 0;

        if (name != null) {
            // have a non-null name, what about date and place

            if (date != null) {
                // have non-null name and date, what about place

                if (place != null) {
                    // have non-null name, date, and place
                    Query qry = this.em.createNativeQuery(
                            "select count(*) \n"
                            + "from \n"
                            + "  RESPON_ATTRIB name_rec, \n"
                            + "  RESPON_ATTRIB date_rec, \n"
                            + "  RESPON_ATTRIB place_rec \n"
                            + "where name_rec.RESPON_ATTRIB_CLASS = 'CorporateBodyName' \n"
                            + "  and name_rec.TEXT_VAL = ?1 \n"
                            + "  and date_rec.RESPON_ENT_ID = name_rec.RESPON_ENT_ID \n"
                            + "  and date_rec.RESPON_ATTRIB_CLASS = 'CorporateBodyDate' \n"
                            + "  and date_rec.TEXT_VAL = ?2 \n"
                            + "  and desig_rec.RESPON_ENT_ID = name_rec.RESPON_ENT_ID \n"
                            + "  and desig_rec.RESPON_ATTRIB_CLASS = 'CorporateBodyPlace' \n"
                            + "  and desig_rec.TEXT_VAL = ?3 \n");
                    qry.setParameter(1, name);
                    qry.setParameter(2, date);
                    qry.setParameter(3, place);

                    count = ((Long) qry.getSingleResult()).intValue();
                } else {
                    // have non-null name and date
                    Query qry = this.em.createNativeQuery(
                            "select count(*) \n"
                            + "from \n"
                            + "  RESPON_ATTRIB name_rec, \n"
                            + "  RESPON_ATTRIB date_rec \n"
                            + "where name_rec.RESPON_ATTRIB_CLASS = 'CorporateBodyName' \n"
                            + "  and name_rec.TEXT_VAL = ?1 \n"
                            + "  and date_rec.RESPON_ENT_ID = name_rec.RESPON_ENT_ID \n"
                            + "  and date_rec.RESPON_ATTRIB_CLASS = 'CorporateBodyDate' \n"
                            + "  and date_rec.TEXT_VAL = ?2 \n");
                    qry.setParameter(1, name);
                    qry.setParameter(2, date);

                    count = ((Long) qry.getSingleResult()).intValue();
                }
            } else {
                // have only non-null name
                Query qry = this.em.createNativeQuery(
                        "select count(*) \n"
                        + "from \n"
                        + "  RESPON_ATTRIB name_rec \n"
                        + "where name_rec.RESPON_ATTRIB_CLASS = 'CorporateBodyName' \n"
                        + "  and name_rec.TEXT_VAL = ?1 \n");
                qry.setParameter(1, name);

                count = ((Long) qry.getSingleResult()).intValue();
            }

        } else {
            // without a name can not query
            // (zero would be false information)

            count = -1;
        }

        return count;
    }

    public List<CorporateBodyJpa> getByAuthIdent(String authIdent) {

        Query qry = this.em.createQuery(
                "select corp "
                + "from CorporateBodyJpa corp "
                + "where corp.authIdent = ?1 ");

        qry.setParameter(1, authIdent);

        return qry.getResultList();
    }

    public List<CorporateBodyJpa> getByNormalName(String normalName) {

        Query qry = this.em.createQuery(
                "select distinct corp "
                + "from CorporateBodyJpa corp,"
                + "  in (corp.names) name "
                + "where name.normal = ?1 ");
        qry.setParameter(1, normalName);

        return qry.getResultList();
    }

    @Override
    public List<CorporateBodyJpa> getAll() {

        Query qry = this.em.createQuery(
                "select corp from CorporateBodyJpa corp");

        return qry.getResultList();
    }

    @Override
    public List<Integer> getAllIds() {

        Query qry = this.em.createQuery(
                "select corp.id from CorporateBodyJpa corp");

        return qry.getResultList();
    }

    @Override
    public CorporateBodyJpa getById(Integer idInt) {

        return this.em.find(CorporateBodyJpa.class, idInt.intValue());
    }

    @Override
    public CorporateBodyJpa getNew() {

        return new CorporateBodyJpa();
    }

    @Override
    public <CorporateBodyJpa> void persist(CorporateBodyJpa corp) {

        this.em.persist(corp);
        // flush this now so can be found
        // by the countMatches native query
        this.em.flush();
    }

    /**
     *  Add a CorporateBody to Report1 of Group2 from bib record (no auth rec).
     * @param corporate CorporateBodyJpa to add to the report.
     * @param bibRecIdent Control Number of the MarcRecord.
     * @param bibFieldTag tag of the MarcDataField.
     * @param bibFieldString toString() of the MardDataField.
     */
    public void reportG2Bib(CorporateBodyJpa corporate,
                            String bibRecIdent,
                            String bibFieldTag,
                            String bibFieldString) {

        Query qry =
                this.em.createNativeQuery("insert into FIZ_REP_G2BIB \n"
                + "set DB_ID = ?1, \n"
                + "    CONTRIB_TYPE = ?2, \n"
                + "    CONTRIB_NAME = ?3, \n"
                + "    CONTRIB_DATE = ?4, \n"
                + "    CONTRIB_AUTHIDENT = ?5, \n"
                + "    BIBREC_IDENT = ?6, \n"
                + "    BIBFIELD_TAG = ?7, \n"
                + "    BIBFIELD_STRING = ?8");
        // db_Id of Person
        qry.setParameter(1, corporate.getId());
        // contributor type
        qry.setParameter(2, "corporateBody");
        // contributor name
        qry.setParameter(3, corporate.getAuthorizedName());
        // contributor date
        if (!(corporate.getDates().isEmpty())) {
            qry.setParameter(4, corporate.getDates().get(0).getText());
        } else {
            qry.setParameter(4, null);
        }
        // contributor authident
        qry.setParameter(5, corporate.getAuthIdent());
        // identifier of the MARC bib Record
        qry.setParameter(6, bibRecIdent);
        // tag of the MARC Data Field
        qry.setParameter(7, bibFieldTag);
        // toString of the MarcDataField
        qry.setParameter(8, bibFieldString);

        qry.executeUpdate();
    }
}
