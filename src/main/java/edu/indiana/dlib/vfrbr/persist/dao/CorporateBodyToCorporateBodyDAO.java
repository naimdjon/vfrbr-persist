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

import edu.indiana.dlib.vfrbr.persist.relation.CorporateBodyToCorporateBody;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author pbmcelwa
 */
public class CorporateBodyToCorporateBodyDAO
        implements VfrbrRelationDAO {

    private EntityManager em;

    /**
     * Protected constructor,
     * obtain instance from DAOFactory
     */
    protected CorporateBodyToCorporateBodyDAO(EntityManager em) {

        this.em = em;
    }

    /*
     * -- VfrbrRelationDAO Interface methods
     */
    @Override
    public int countAll() {

        Query qry = this.em.createQuery(
                "select count(assoc) " + "from CorporateBodyToCorporateBody assoc");

        return ((Long) qry.getSingleResult()).intValue();
    }

    @Override
    public int countType(String type) {

        Query qry = this.em.createQuery(""
                + "select count(assoc) "
                + "from CorporateBodyToCorporateBody assoc "
                + "where assoc.relType = ?1");
        qry.setParameter(1, type);

        return ((Long) qry.getSingleResult()).intValue();
    }

    @Override
    public int countRole(String role) {

        Query qry = this.em.createQuery(
                "select count(assoc) " + "from CorporateBodyToCorporateBody assoc " + "where assoc.relRole = ?1");
        qry.setParameter(1, role);

        return ((Long) qry.getSingleResult()).intValue();
    }

    @Override
    public List<CorporateBodyToCorporateBody> getAll() {

        Query qry = this.em.createQuery(
                "select assoc " + "from CorporateBodyToCorporateBody assoc");

        return qry.getResultList();
    }

    @Override
    public List<CorporateBodyToCorporateBody> getType(String type) {

        Query qry = this.em.createQuery(""
                + "select assoc "
                + "from CorporateBodyToCorporateBody assoc "
                + "where assoc.relType = ?1");
        qry.setParameter(1, type);

        return qry.getResultList();
    }

    @Override
    public List<CorporateBodyToCorporateBody> getRole(String role) {

        Query qry = this.em.createQuery(
                "select assoc " + "from CorporateBodyToCorporateBody assoc " + "where assoc.relRole = ?1");
        qry.setParameter(1, role);

        return qry.getResultList();
    }

    @Override
    public List<Integer> getAllIds() {

        Query qry = this.em.createQuery(
                "select assoc.id " + "from CorporateBodyToCorporateBody assoc");

        return qry.getResultList();
    }

    @Override
    public List<Integer> getTypeIds(String type) {

        Query qry = this.em.createQuery(""
                + "select assoc.id "
                + "from CorporateBodyToCorporateBody assoc "
                + "where assoc.relType = ?1");
        qry.setParameter(1, type);

        return qry.getResultList();
    }

    @Override
    public List<Integer> getRoleIds(String role) {

        Query qry = this.em.createQuery(""
                + "select assoc.id "
                + "from CorporateBodyToCorporateBody assoc "
                + "where assoc.relRole = ?1");
        qry.setParameter(1, role);

        return qry.getResultList();
    }

    @Override
    public CorporateBodyToCorporateBody getById(Integer idInt) {

        return this.em.find(CorporateBodyToCorporateBody.class,
                            idInt.intValue());
    }

    @Override
    public CorporateBodyToCorporateBody getNew() {

        return new CorporateBodyToCorporateBody();
    }
}
