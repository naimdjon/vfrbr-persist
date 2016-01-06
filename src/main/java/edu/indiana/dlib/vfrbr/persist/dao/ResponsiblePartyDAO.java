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

import edu.indiana.dlib.vfrbr.persist.entity.responsibleparty.ResponsiblePartyJpa;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class ResponsiblePartyDAO {

    private EntityManager em;

    public ResponsiblePartyDAO(EntityManager em) {
        this.em = em;
    }

    public int countName(String name) {

        if (name == null) {
            return -1;
        } else {
            Query qry = this.em.createNativeQuery(
                    "select count(*) \n"
                    + "from RESPON_ATTRIB \n"
                    + "where (RESPON_ATTRIB_CLASS = 'PersonName' \n"
                    + "   or RESPON_ATTRIB_CLASS = 'CorporateBodyName') \n"
                    + "  and (TEXT_VAL = ?1) \n");
            qry.setParameter(1, name);

            return ((Long) qry.getSingleResult()).intValue();
        }
    }

    public List<ResponsiblePartyJpa> getAuthName(String name) {

        List<ResponsiblePartyJpa> responList = new ArrayList<ResponsiblePartyJpa>();

        if (name != null) {
            Query qry = this.em.createQuery(
                    "select rp "
                    + "from ResponsiblePartyJpa rp "
                    + "where rp.authorizedName = ?1 ");
            qry.setParameter(1, name);

            /*
             * authorized name is not enforced to be unique
             * so allow for multiple rows
             * and let calling context deal with the list
             */

            responList.addAll(qry.getResultList());
        }
        // else return empty list

        return responList;
    }

    public List<ResponsiblePartyJpa> getByName(String name) {

        List<ResponsiblePartyJpa> responList = new ArrayList<ResponsiblePartyJpa>();

        if (name != null) {

            Query qry = this.em.createQuery(
                    "select pers "
                    + "from PersonJpa pers, in(pers.names) name "
                    + "where name.text = ?1 ");
            qry.setParameter(1, name);

            responList.addAll(qry.getResultList());

            Query qry2 = this.em.createQuery(
                    "select corp "
                    + "from CorporateBodyJpa corp, in(corp.names) name "
                    + "where name.text = ?1 ");
            qry2.setParameter(1, name);

            responList.addAll(qry2.getResultList());

        }
        // else return empty list

        return responList;
    }

    public List<ResponsiblePartyJpa> getByNameIdent(String nameIdent) {

        Query qry = this.em.createQuery(
                "select respon "
                + "from ResponsiblePartyJpa respon "
                + "where respon.nameIdent = ?1 ");

        qry.setParameter(1, nameIdent);

        return qry.getResultList();
    }

    public List<Integer> getAllIds() {
        Query qry = this.em.createQuery(
                "select rp.id from ResponsiblePartyJpa rp");

        return qry.getResultList();
    }

    public ResponsiblePartyJpa getById(Integer idInt) {
        return this.em.find(ResponsiblePartyJpa.class, idInt.intValue());
    }
}
