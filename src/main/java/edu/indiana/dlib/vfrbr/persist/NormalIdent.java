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
package edu.indiana.dlib.vfrbr.persist;

import java.text.Normalizer;
import java.text.Normalizer.Form;

/**
 * Used in support of
 *  ResponsibleParty.authIdent,
 *  PersonName.normal,
 *  CorporateBodyName.normal,
 *  Work.authIdent.
 * AuthIdent and name.normal are used
 * in processing MARC records
 * for checking for already persisted matches.
 *
 * @author pbmcelwa
 */
public class NormalIdent {

    private static String ident;

    /**
     *  Get authIdent of the same form as authority record cach file nameing.
     * @param value
     * @return
     */
    public static String getAuthIdent(String value) {
        ident = value;

        if (ident != null) {

            // canonical decomposition
            ident = Normalizer.normalize(ident, Form.NFKD);

            // remove non-ascii characters
            ident = ident.replaceAll("[^\\p{ASCII}]", "");

            // lowercase
            ident = ident.toLowerCase();

            // remove all non-(letter, number, dash, underscore, colon, space)
            ident = ident.replaceAll("[^a-z0-9\\-_: ]", "");

            // replace multiple spaces with single spaces
            ident = ident.replaceAll(" +", " ");

            // omit any trailing colon
            ident = ident.replaceAll(":$", "");

            // remove any trailing dash
            ident = ident.replaceAll("\\-$", "");

            // omit leading and trailing whitespace
            ident = ident.trim();

            // replace spaces with underscores
            ident = ident.replaceAll(" ", "_");

        } else {
            // normalIdent for null is empty String
            ident = "";
        }

        return ident;
    }

    /**
     *  Get normalIdent of the same form as authority record cache file naming
     * with the addition that dashes are changed to spaces.
     * @param value
     * @return
     */
    public static String getNormalIdent(String value) {
        ident = value;

        if (ident != null) {

            // canonical decomposition
            ident = Normalizer.normalize(ident, Form.NFKD);

            // remove non-ascii characters
            ident = ident.replaceAll("[^\\p{ASCII}]", "");

            // lowercase
            ident = ident.toLowerCase();

            // remove all non-(letter, number, dash, underscore, colon, space)
            ident = ident.replaceAll("[^a-z0-9\\-_: ]", "");

            // replace dashes with spaces
            ident = ident.replaceAll("-", " ");

            // replace multiple spaces with single spaces
            ident = ident.replaceAll(" +", " ");

            // omit any trailing colon
            ident = ident.replaceAll(":$", "");

            // remove any trailing dash
            ident = ident.replaceAll("\\-$", "");

            // omit leading and trailing whitespace
            ident = ident.trim();

            // replace spaces with underscores
            ident = ident.replaceAll(" ", "_");



        } else {
            // normalIdent for null is empty String
            ident = "";
        }

        return ident;
    }
}
