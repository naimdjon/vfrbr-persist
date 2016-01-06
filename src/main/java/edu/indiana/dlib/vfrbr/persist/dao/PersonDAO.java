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

import edu.indiana.dlib.vfrbr.persist.entity.responsibleparty.PersonJpa;
import java.util.ArrayList;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.apache.log4j.Logger;

/**
 *
 * @author pbmcelwa
 */
public class PersonDAO
        implements VfrbrEntityDAO {

    private static Logger log = Logger.getLogger(PersonDAO.class);

    private EntityManager em;

    /**
     * Protected constructor,
     * obtain instance from DAOFactory
     */
    protected PersonDAO(EntityManager em) {

        this.em = em;
    }

    /*
     * -- VfrbrEntityDAO Interface methods
     */
    @Override
    public int countAll() {
        Query qry = this.em.createQuery(
                "select count(pers) " + "from PersonJpa pers ");

        return ((Long) qry.getSingleResult()).intValue();
    }

    public int countByAuthIdent(String authIdent) {

        Query qry = this.em.createQuery(
                "select count(person) "
                + "from PersonJpa person "
                + "where person.authIdent = ?1 ");
        qry.setParameter(1, authIdent);

        return ((Long) qry.getSingleResult()).intValue();
    }

    public int countByNormalName(String normalName) {

        Query qry = this.em.createQuery(
                "select count(distinct person) "
                + "from PersonJpa person, "
                + "  in (person.names) name "
                + "where name.normal = ?1 ");
        qry.setParameter(1, normalName);

        return ((Long) qry.getSingleResult()).intValue();
    }

    public int countAuthName(String name) {

        if (name == null) {
            return -1;
        } else {
            Query qry = this.em.createQuery(
                    "select count(pers) " + "from PersonJpa pers "
                    + "where pers.authorizedName = ?1 ");
            qry.setParameter(1, name);

            return ((Long) qry.getSingleResult()).intValue();
        }
    }

    public int countName(String name) {

        if (name == null) {
            return -1;
        } else {

            Query qry = this.em.createNativeQuery(
                    "select count(*) "
                    + "from RESPON_ATTRIB "
                    + "where RESPON_ATTRIB_CLASS = 'PersonName' "
                    + "  and TEXT_VAL = ?1 ");

            qry.setParameter(1, name);

            return ((Long) qry.getSingleResult()).intValue();
        }
    }

    /**
     * Get the count of matching ResponsibleParties (Persons)
     * for the provided name, date, and designation.
     * At least the name is required.  Date is optional.
     * Designation is optional, but if used requires date also to be used.
     *
     * @param name
     * @param date
     * @param designation
     * @return the datebase count, or zero if no name provided.
     */
    public int countMatches(String name,
                            String date,
                            String designation) {

        int count = 0;

        if (name != null) {
            // have a non-null name, what about date and designation

            if (date != null) {
                // have non-null name and date, what about designation

                if (designation != null) {
                    // have non-null name, date, and designation
                    Query qry = this.em.createNativeQuery(
                            "select count(*) \n"
                            + "from \n"
                            + "  RESPON_ATTRIB name_rec, \n"
                            + "  RESPON_ATTRIB date_rec, \n"
                            + "  RESPON_ATTRIB desig_rec \n"
                            + "where name_rec.RESPON_ATTRIB_CLASS = 'PersonName' \n"
                            + "  and name_rec.TEXT_VAL = ?1 \n"
                            + "  and date_rec.RESPON_ENT_ID = name_rec.RESPON_ENT_ID \n"
                            + "  and date_rec.RESPON_ATTRIB_CLASS = 'PersonDate' \n"
                            + "  and date_rec.TEXT_VAL = ?2 \n"
                            + "  and desig_rec.RESPON_ENT_ID = name_rec.RESPON_ENT_ID \n"
                            + "  and desig_rec.RESPON_ATTRIB_CLASS = 'PersonDesignation' \n"
                            + "  and desig_rec.TEXT_VAL = ?3 \n");
                    qry.setParameter(1, name);
                    qry.setParameter(2, date);
                    qry.setParameter(3, designation);

                    count = ((Long) qry.getSingleResult()).intValue();
                } else {
                    // have non-null name and date
                    Query qry = this.em.createNativeQuery(
                            "select count(*) \n"
                            + "from \n"
                            + "  RESPON_ATTRIB name_rec, \n"
                            + "  RESPON_ATTRIB date_rec \n"
                            + "where name_rec.RESPON_ATTRIB_CLASS = 'PersonName' \n"
                            + "  and name_rec.TEXT_VAL = ?1 \n"
                            + "  and date_rec.RESPON_ENT_ID = name_rec.RESPON_ENT_ID \n"
                            + "  and date_rec.RESPON_ATTRIB_CLASS = 'PersonDate' \n"
                            + "  and date_rec.TEXT_VAL = ?2 \n");
                    qry.setParameter(1, name);
                    qry.setParameter(2, date);

                    count = ((Long) qry.getSingleResult()).intValue();
                }
            } else {
                // have only non-null name
                Query qry = this.em.createNativeQuery(
                        "select count(*) \n"
                        + "from RESPON_ATTRIB name_rec \n"
                        + "where name_rec.RESPON_ATTRIB_CLASS = 'PersonName' \n"
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

    @Override
    public List<PersonJpa> getAll() {

        Query qry = this.em.createQuery(
                "select person from PersonJpa person");

        return qry.getResultList();
    }

    public List<PersonJpa> getAuthName(String name) {

        List<PersonJpa> persons = new ArrayList<PersonJpa>();

        if (name != null) {
            Query qry = this.em.createQuery(
                    "select pers "
                    + "from PersonJpa pers "
                    + "where pers.authorizedName = ?1 ");
            qry.setParameter(1, name);

            /*
             * authorized name is not enforced to be unique
             * so allow for multiple rows
             * and let calling context deal with the list
             */

            persons.addAll(qry.getResultList());
        }

        return persons;
    }

    public List<PersonJpa> getByName(String name) {

        List<PersonJpa> persons = new ArrayList<PersonJpa>();

        if (name != null) {
            Query qry = this.em.createQuery(
                    "select pers " + "from PersonJpa pers, in(pers.names) name "
                    + "where name.text = ?1 ");
            qry.setParameter(1, name);

            persons.addAll(qry.getResultList());
        }

        return persons;
    }

    public List<PersonJpa> getByAuthIdent(String authIdent) {

        Query qry = this.em.createQuery(
                "select person "
                + "from PersonJpa person "
                + "where person.authIdent = ?1 ");

        qry.setParameter(1, authIdent);

        return qry.getResultList();
    }

    public List<PersonJpa> getByNormalName(String normalName) {

        Query qry = this.em.createQuery(
                "select distinct person "
                + "from PersonJpa person, "
                + "  in (person.names) name "
                + "where name.normal = ?1 ");
        qry.setParameter(1, normalName);

        return qry.getResultList();
    }

    @Override
    public List<Integer> getAllIds() {

        Query qry = this.em.createQuery(
                "select person.id from PersonJpa person");

        return qry.getResultList();
    }

    @Override
    public PersonJpa getById(Integer idInt) {

        return this.em.find(PersonJpa.class, idInt.intValue());
    }

    @Override
    public PersonJpa getNew() {

        return new PersonJpa();
    }

    @Override
    public <PersonJpa> void persist(PersonJpa person) {

        this.em.persist(person);
        // flush now so person can be found
        // via the countMatches native query
        this.em.flush();
    }

    /**
     *  Add a Person to Report1 of Group2 from bib record (no auth rec).
     * @param person PersonJpa to add to the report.
     * @param bibRecIdent Control Number of the MarcRecord.
     * @param bibFieldTag tag of the MarcDataField.
     * @param bibFieldString toString() of the MardDataField.
     */
    public void reportG2Bib(PersonJpa person,
                            String bibRecIdent,
                            String bibFieldTag,
                            String bibFieldString) {

        Query qry =
                this.em.createNativeQuery(""
                + "insert into FIZ_REP_G2BIB \n"
                + "set DB_ID = ?1, \n"
                + "    CONTRIB_TYPE = ?2, \n"
                + "    CONTRIB_NAME = ?3, \n"
                + "    CONTRIB_DATE = ?4, \n"
                + "    CONTRIB_AUTHIDENT = ?5, \n"
                + "    BIBREC_IDENT = ?6, \n"
                + "    BIBFIELD_TAG = ?7, \n"
                + "    BIBFIELD_STRING = ?8");
        // db_Id of Person
        qry.setParameter(1, person.getId());
        // contributor type
        qry.setParameter(2, "person");
        // contributor name
        qry.setParameter(3, person.getAuthorizedName());
        // contributor date
        if (!(person.getDates().isEmpty())) {
            qry.setParameter(4, person.getDates().get(0).getText());
        } else {
            qry.setParameter(4, null);
        }
        // contributor authident
        qry.setParameter(5, person.getAuthIdent());
        // identifier of the MARC bib Record
        qry.setParameter(6, bibRecIdent);
        // tag of the MARC Data Field
        qry.setParameter(7, bibFieldTag);
        // toString of the MarcDataField
        qry.setParameter(8, bibFieldString);

        qry.executeUpdate();
    }
}
