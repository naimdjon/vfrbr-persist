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

import edu.indiana.dlib.vfrbr.persist.entity.work.WorkJpa;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.SqlResultSetMapping;

/**
 *
 * @author pbmcelwa
 */
public class WorkDAO
        implements VfrbrEntityDAO {

    private EntityManager em;

    /**
     * Protected constructor,
     * obtain instance from DAOFactory
     */
    protected WorkDAO(EntityManager em) {

        this.em = em;
    }

    /*
     * -- VfrbrEntityDAO Interface methods
     */
    @Override
    public int countAll() {
        Query qry = this.em.createQuery(
                "select count(work) "
                + "from WorkJpa work ");

        return ((Long) qry.getSingleResult()).intValue();
    }

    public int countByAuthIdent(String authIdent) {
        Query qry = this.em.createQuery(
                "select count(work) "
                + "from WorkJpa work "
                + "where work.authIdent = ?1 ");
        qry.setParameter(1, authIdent);

        return ((Long) qry.getSingleResult()).intValue();
    }

    public int countUnifTitle(String title) {
        Query qry = this.em.createQuery(
                "select count(work) "
                + "from WorkJpa work "
                + "where work.uniformTitle = ?1 ");
        qry.setParameter(1, title);

        return ((Long) qry.getSingleResult()).intValue();
    }

    public int countTitle(String title) {
        Query qry = this.em.createQuery(
                "select count(work) "
                + "from WorkJpa work, in(work.titles) title "
                + "where title.text = ?1 ");
        qry.setParameter(1, title);

        return ((Long) qry.getSingleResult()).intValue();
    }

    @Override
    public List<WorkJpa> getAll() {

        Query qry = this.em.createQuery(
                "select work from WorkJpa work");

        return qry.getResultList();
    }

    @Override
    public List<Integer> getAllIds() {

        Query qry = this.em.createQuery(
                "select work.id from WorkJpa work");

        return qry.getResultList();
    }

    @Override
    public WorkJpa getById(Integer idInt) {

        return this.em.find(WorkJpa.class, idInt.intValue());
    }

    public List<WorkJpa> getByUnifTitleAndComposer(String unifTitle,
                                                   String compAuthName) {
        /*
         * return list
         * leave calling context free to treat multiplicity
         */

        Query qry =
                this.em.createQuery(
                "select work "
                + "from WorkJpa work, "
                + "  in(work.hasComposerPersons) hasComposers "
                + "where work.uniformTitle = ?1"
                + "  and hasComposers.targetResponsibleParty.authorizedName = ?2");
        qry.setParameter(1, unifTitle);
        qry.setParameter(2, compAuthName);

        return qry.getResultList();
    }

    public List<WorkJpa> getByAuthIdent(String authIdent) {

        Query qry = this.em.createQuery(
                "select work "
                + "from WorkJpa work "
                + "where work.authIdent = ?1 ");

        qry.setParameter(1, authIdent);

        return qry.getResultList();
    }

    @Override
    public WorkJpa getNew() {

        return new WorkJpa();
    }

    @Override
    public <WorkJpa> void persist(WorkJpa work) {

        this.em.persist(work);
    }

    /**
     *  Persist data to provide frbrization reports on Works.
     * 
     * @param work
     * @param workIdentGroup
     * @param workIdentAlgorithm
     * @param marcBibRecId
     * @param marcBibFieldTag
     * @param marcAuthRecId
     * @param frbrFileRec
     */
    public void reportWorks(WorkJpa work,
                            String workIdentGroup,
                            String workIdentAlgorithm,
                            String marcBibRecId,
                            String marcBibFieldTag,
                            String marcAuthRecId,
                            String marcFileName,
                            int marcFileRecNum) {
        Query qry =
                this.em.createNativeQuery(""
                + "insert into FIZ_REP_WORK \n"
                + "set DB_ID           = ?1, \n"
                + "    UNIFORM_TITLE   = ?2, \n"
                + "    CMP_AUTH_NAME   = ?3, \n"
                + "    DATE_TEXT       = ?4, \n"
                + "    IDENT_GROUP     = ?5, \n"
                + "    IDENT_ALGOR     = ?6, \n"
                + "    BIBREC_ID       = ?7, \n"
                + "    BIBFIELD_TAG    = ?8, \n"
                + "    AUTHREC_ID      = ?9, \n"
                + "    MARC_FILENAME   = ?10, \n"
                + "    MARC_RECNUM     = ?11 \n");

        //  -- work.id
        qry.setParameter(1, work.getId());

        //  -- work.uniformTitle
        qry.setParameter(2, work.getUniformTitle());

        //  -- work.composers(0).authorizedName
        if (!work.getHasComposerPersons().isEmpty()) {
            qry.setParameter(3, work.getHasComposerPersons().get(0).
                    getTargetResponsibleParty().getAuthorizedName());

        } else if (!work.getHasComposerCorporations().isEmpty()) {
            qry.setParameter(3, work.getHasComposerCorporations().get(0).
                    getTargetResponsibleParty().getAuthorizedName());

        } else {
            qry.setParameter(3, null);
        }

        //  -- work.dates(0).text
        if (work.getDates().isEmpty()) {
            qry.setParameter(4, null);
        } else {
            qry.setParameter(4, work.getDates().get(0).getText());
        }

        //  -- work identification (marcRec) group
        qry.setParameter(5, workIdentGroup);

        //  -- work identification algorithim step
        qry.setParameter(6, workIdentAlgorithm);

        //  -- MARC bib rec control number
        qry.setParameter(7, marcBibRecId);

        //  -- MARC bib rec field tag (work field)
        qry.setParameter(8, marcBibFieldTag);

        //  -- MARC auth rec control number
        qry.setParameter(9, marcAuthRecId);

        //  -- MARC source file name
        qry.setParameter(10, marcFileName);

        //  -- MARC record number in source file
        qry.setParameter(11, marcFileRecNum);

        qry.executeUpdate();

    }
    /*
     * -- inititial (legacy) methods
     */

    @Deprecated
    public int workCount() {
        Query qry = this.em.createNativeQuery(
                "select count(*) from WORK_ENT");

        return ((Long) qry.getSingleResult()).intValue();
    }

    @Deprecated
    public List<WorkJpa> allWorks() {

        Query qry = this.em.createQuery(
                "select work from WorkJpa work");

        return qry.getResultList();
    }

    @Deprecated
    public List<Integer> allWorkIds() {

        Query qry = this.em.createQuery(
                "select work.id from WorkJpa work");

        return qry.getResultList();
    }

    @Deprecated
    public WorkJpa findWorkById(Integer idInt) {

//        Query qry = this.em.createQuery(
//                "select work from WorkJpa work " +
//                "where work.id = ?1");
//
//        qry.setParameter(1, idInt.intValue());
//
//        return (WorkJpa)qry.getSingleResult();

        return this.em.find(WorkJpa.class, idInt.intValue());
    }

    @Deprecated
    public WorkJpa newWork() {

        return new WorkJpa();
    }

    @Deprecated
    public void persistWork(WorkJpa work) {

        this.em.persist(work);
    }

    @Deprecated
    public void removeWork(WorkJpa work) {

        this.em.remove(work);
    }
}
