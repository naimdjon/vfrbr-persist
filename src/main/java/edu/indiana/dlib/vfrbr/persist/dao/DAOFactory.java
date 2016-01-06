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

import java.util.Properties;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TransactionRequiredException;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

/**
 *  Factory for entity DAO modules
 * and initialization of persistence context.
 *
 * @author pbmcelwa
 */
@Repository
public class DAOFactory {

    private static Logger log = Logger.getLogger(DAOFactory.class);

    private String puName = "vfrbr-jpa";

    private EntityManagerFactory emf;

    private EntityManager em;

    private final Properties jdbcProps;

    /**
     * New DAOFactory with jdbc properties from properties file.
     */
    public DAOFactory() {
        // invoke constructor with Properties parameter
        this(new JdbcProps().getJdbcProperties());

    }

    @Deprecated
    public DAOFactory(String persistUnitName) {

        this.puName = persistUnitName;
        this.jdbcProps = new JdbcProps().getJdbcProperties();

        try {

            log.info("Creating EMF with PU " + this.puName
                    + "\n and jdbcProps: \n"
                    + jdbcProps.toString());

            // create the entity manager factory
            this.emf = Persistence.createEntityManagerFactory(this.puName,
                                                              jdbcProps);
            log.info("EMF created.");

            /*
             * test the connectability
             */
            Query qry = this.getEntityManager().createQuery(
                    "select count(manif) "
                    + "from ManifestationJpa manif");
            int manifCount = ((Long) qry.getSingleResult()).intValue();
            log.info("Connected to db with " + manifCount + " manifestations.");



        } catch (Exception ex) {
            log.fatal(
                    "Exception encountered instantiating DAOFactory and EntityManagerFactory",
                      ex);
        }
    }

    /**
     *  Construct a DAOFactory instance
     * for a persistence unit context.
     *
     * @param persistUnitName persistence unit name for the persistence context
     */
    public DAOFactory(Properties jdbcProperties) {

        jdbcProps = jdbcProperties;

        try {

            log.info("Creating EMF with PU " + this.puName
                    + "\n and jdbcProps: \n"
                    + jdbcProps.toString());

            // create the entity manager factory
            this.emf = Persistence.createEntityManagerFactory(this.puName,
                                                              jdbcProps);
            log.info("EMF created.");

            /*
             * test the connectability
             */
            Query qry = this.getEntityManager().createQuery(
                    "select count(manif) "
                    + "from ManifestationJpa manif");
            int manifCount = ((Long) qry.getSingleResult()).intValue();
            log.info("Connected to db with " + manifCount + " manifestations.");



        } catch (Exception ex) {
            log.fatal(
                    "Exception encountered instantiating DAOFactory and EntityManagerFactory",
                      ex);
        }
    }

    public EntityManagerFactory getEntityManagerFactory() {

        return this.emf;
    }

    public EntityManager getEntityManager() {

        if (null == this.em) {
            this.em = emf.createEntityManager();
        }

        if (!this.em.isOpen()) {
            this.em = emf.createEntityManager();
        }

        return this.em;
    }

    public void flushClearEntityManager() {
        try {
            em.flush();
        } catch (TransactionRequiredException tre) {
            //ignore TransactionRequiredException
        }
        em.clear();
    }

    public void closeEntityManager() {
        if (null != em) {
            em.close();
            em = null;
        }
    }

    /**
     * Get a new ConceptDAO
     * iniitalized with the current EntityManagerFactory.
     *
     * @return new ConceptDAO
     */
    public ConceptDAO newConceptDAO() {

        return new ConceptDAO(this.getEntityManager());
    }

    /**
     * Get a new CorporateBodyDAO
     * iniitalized with the current EntityManagerFactory.
     *
     * @return new CorporateBodyDAO
     */
    public CorporateBodyDAO newCorporateBodyDAO() {

        return new CorporateBodyDAO(this.getEntityManager());
    }

    /**
     * Get a new EventDAO
     * iniitalized with the current EntityManagerFactory.
     *
     * @return new EventDAO
     */
    public EventDAO newEventDAO() {

        return new EventDAO(this.getEntityManager());
    }

    /**
     * Get a new ExpressionDAO
     * iniitalized with the current EntityManagerFactory.
     *
     * @return new ExpressionDAO
     */
    public ExpressionDAO newExpressionDAO() {

        return new ExpressionDAO(this.getEntityManager());
    }

    /**
     * Get a new FamilyDAO
     * iniitalized with the current EntityManagerFactory.
     *
     * @return new FamilyDAO
     */
    public FamilyDAO newFamilyDAO() {

        return new FamilyDAO(this.getEntityManager());
    }

    /**
     * Get a new ItemDAO
     * iniitalized with the current EntityManagerFactory.
     *
     * @return new ItemDAO
     */
    public ItemDAO newItemDAO() {

        return new ItemDAO(this.getEntityManager());
    }

    /**
     * Get a new ManifestationDAO
     * iniitalized with the current EntityManagerFactory.
     *
     * @return new ManifestationDAO
     */
    public ManifestationDAO newManifestationDAO() {

        return new ManifestationDAO(this.getEntityManager());
    }

    /**
     * Get a new ObjectDAO
     * iniitalized with the current EntityManagerFactory.
     *
     * @return new ObjectDAO
     */
    public ObjectDAO newObjectDAO() {

        return new ObjectDAO(this.getEntityManager());
    }

    /**
     * Get a new PersonDAO
     * iniitalized with the current EntityManagerFactory.
     *
     * @return new PersonDAO
     */
    public PersonDAO newPersonDAO() {

        return new PersonDAO(this.getEntityManager());
    }

    /**
     * Get a new PlaceDAO
     * iniitalized with the current EntityManagerFactory.
     *
     * @return new PlaceDAO
     */
    public PlaceDAO newPlaceDAO() {

        return new PlaceDAO(this.getEntityManager());
    }

    /**
     * Get a new ResponsiblePartyDAO
     * iniitalized with the current EntityManagerFactory.
     *
     * @return new ResponsiblePartyDAO
     */
    public ResponsiblePartyDAO newResponsiblePartyDAO() {

        return new ResponsiblePartyDAO(this.getEntityManager());
    }

    /**
     * Get a new WorkDAO
     * iniitalized with the current EntityManagerFactory.
     *
     * @return new WorkDAO
     */
    public WorkDAO newWorkDAO() {

        return new WorkDAO(this.getEntityManager());
    }

    /**
     * Get a new CorporateBodyToCorporateBodyDAO
     * iniitalized with the current EntityManagerFactory.
     *
     * @return new CorporateBodyToCorporateBodyDAO
     */
    public CorporateBodyToCorporateBodyDAO newCorporateBodyToCorporateBodyDAO() {

        return new CorporateBodyToCorporateBodyDAO(this.getEntityManager());
    }

    /**
     * Get a new CorporateBodyToPersonDAO
     * iniitalized with the current EntityManagerFactory.
     *
     * @return new CorporateBodyToPersonDAO
     */
    public CorporateBodyToPersonDAO newCorporateBodyToPersonDAO() {

        return new CorporateBodyToPersonDAO(this.getEntityManager());
    }

    /**
     * Get a new ExpressionToExpressionDAO
     * iniitalized with the current EntityManagerFactory.
     *
     * @return new ExpressionToExpressionDAO
     */
    public ExpressionToExpressionDAO newExpressionToExpressionDAO() {

        return new ExpressionToExpressionDAO(this.getEntityManager());
    }

    /**
     * Get a new ExpressionToManifestationDAO
     * iniitalized with the current EntityManagerFactory.
     *
     * @return new ExpressionToManifestationDAO
     */
    public ExpressionToManifestationDAO newExpressionToManifestationDAO() {

        return new ExpressionToManifestationDAO(this.getEntityManager());
    }

    /**
     * Get a new ExpressionToResponsiblePartyDAO
     * iniitalized with the current EntityManagerFactory.
     *
     * @return new ExpressionToResponsiblePartyDAO
     */
    public ExpressionToResponsiblePartyDAO newExpressionToResponsiblePartyDAO() {

        return new ExpressionToResponsiblePartyDAO(this.getEntityManager());
    }

    /**
     * Get a new ExpressionToWorkDAO
     * iniitalized with the current EntityManagerFactory.
     *
     * @return new ExpressionToWorkDAO
     */
    public ExpressionToWorkDAO newExpressionToWorkDAO() {

        return new ExpressionToWorkDAO(this.getEntityManager());
    }

    /**
     * Get a new FamilyToPersonDAO
     * iniitalized with the current EntityManagerFactory.
     *
     * @return new FamilyToPersonDAO
     */
    public FamilyToPersonDAO newFamilyToPersonDAO() {

        return new FamilyToPersonDAO(this.getEntityManager());
    }

    /**
     * Get a new ItemToItemDAO
     * iniitalized with the current EntityManagerFactory.
     *
     * @return new ItemToItemDAO
     */
    public ItemToItemDAO newItemToItemDAO() {

        return new ItemToItemDAO(this.getEntityManager());
    }

    /**
     * Get a new ItemToResponsiblePartyDAO
     * iniitalized with the current EntityManagerFactory.
     *
     * @return new ItemToResponsiblePartyDAO
     */
    public ItemToResponsiblePartyDAO newItemToResponsiblePartyDAO() {

        return new ItemToResponsiblePartyDAO(this.getEntityManager());
    }

    /**
     * Get a new ManifestationToItemDAO
     * iniitalized with the current EntityManagerFactory.
     *
     * @return new ManifestationToItemDAO
     */
    public ManifestationToItemDAO newManifestationToItemDAO() {

        return new ManifestationToItemDAO(this.getEntityManager());
    }

    /**
     * Get a new ManifestationToManifestationDAO
     * iniitalized with the current EntityManagerFactory.
     *
     * @return new ManifestationToManifestationDAO
     */
    public ManifestationToManifestationDAO newManifestationToManifestationDAO() {

        return new ManifestationToManifestationDAO(this.getEntityManager());
    }

    /**
     * Get a new ManifestationToResponsiblePartyDAO
     * iniitalized with the current EntityManagerFactory.
     *
     * @return new ManifestationToResponsiblePartyDAO
     */
    public ManifestationToResponsiblePartyDAO newManifestationToResponsiblePartyDAO() {

        return new ManifestationToResponsiblePartyDAO(this.getEntityManager());
    }

    /**
     * Get a new PersonToPersonDAO
     * iniitalized with the current EntityManagerFactory.
     *
     * @return new PersonToPersonDAO
     */
    public PersonToPersonDAO newPersonToPersonDAO() {

        return new PersonToPersonDAO(this.getEntityManager());
    }

    /**
     * Get a new WorkToExpressionDAO
     * iniitalized with the current EntityManagerFactory.
     *
     * @return new WorkToExpressionDAO
     */
    public WorkToExpressionDAO newWorkToExpressionDAO() {

        return new WorkToExpressionDAO(this.getEntityManager());
    }

    /**
     * Get a new WorkToItemDAO
     * iniitalized with the current EntityManagerFactory.
     *
     * @return new WorkToItemDAO
     */
    public WorkToItemDAO newWorkToItemDAO() {

        return new WorkToItemDAO(this.getEntityManager());
    }

    /**
     * Get a new WorkToManifestationDAO
     * iniitalized with the current EntityManagerFactory.
     *
     * @return new WorkToManifestationDAO
     */
    public WorkToManifestationDAO newWorkToManifestationDAO() {

        return new WorkToManifestationDAO(this.getEntityManager());
    }

    /**
     * Get a new WorkToResponsiblePartyDAO
     * iniitalized with the current EntityManagerFactory.
     *
     * @return new WorkToResponsiblePartyDAO
     */
    public WorkToResponsiblePartyDAO newWorkToResponsiblePartyDAO() {

        return new WorkToResponsiblePartyDAO(this.getEntityManager());
    }

    /**
     * Get a new WorkToSubjectEntityDAO
     * iniitalized with the current EntityManagerFactory.
     *
     * @return new WorkToSubjectEntityDAO
     */
    public WorkToSubjectEntityDAO newWorkToSubjectEntityDAO() {

        return new WorkToSubjectEntityDAO(this.getEntityManager());
    }

    /**
     * Get a new WorkToWorkDAO
     * iniitalized with the current EntityManagerFactory.
     *
     * @return new WorkToWorkDAO
     */
    public WorkToWorkDAO newWorkToWorkDAO() {

        return new WorkToWorkDAO(this.getEntityManager());
    }
}
