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

import edu.indiana.dlib.vfrbr.persist.entity.subject.EventJpa;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author pbmcelwa
 */
public class EventDAO
        implements VfrbrEntityDAO {

    private EntityManager em;

    /**
     * Protected constructor,
     * obtain instance from DAOFactory
     */
    protected EventDAO(EntityManager em) {

        this.em = em;
    }

    /*
     * -- VfrbrEntityDAO Interface methods
     */
    @Override
    public int countAll() {
        Query qry = this.em.createNativeQuery(
                "select count(*) from SUBJ_ENT " +
                "where SUBJ_CLASS = 'Event'");

        return ((Long) qry.getSingleResult()).intValue();
    }

    @Override
    public List<EventJpa> getAll() {

        Query qry = this.em.createQuery(
                "select event from EventJpa event");

        return qry.getResultList();
    }

    @Override
    public List<Integer> getAllIds() {

        Query qry = this.em.createQuery(
                "select event.id from EventJpa event");

        return qry.getResultList();
    }

    @Override
    public EventJpa getById(Integer idInt) {

        return this.em.find(EventJpa.class, idInt.intValue());
    }

    @Override
    public EventJpa getNew() {

        return new EventJpa();
    }

    @Override
    public <EventJpa> void persist(EventJpa event) {

        this.em.persist(event);
    }
}
