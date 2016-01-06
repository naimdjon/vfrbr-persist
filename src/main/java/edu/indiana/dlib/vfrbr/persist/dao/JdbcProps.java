/**
 * Copyright 2009-2011, Trustees of Indiana University
 * All rights reserved.
 * <p/>
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 * <p/>
 * Redistributions of source code must retain the above copyright notice,
 * this list of conditions and the following disclaimer.
 * <p/>
 * Redistributions in binary form must reproduce the above copyright notice,
 * this list of conditions and the following disclaimer in the documentation
 * and/or other materials provided with the distribution.
 * <p/>
 * Neither the name of Indiana University nor the names of its
 * contributors may be used to endorse or promote products derived from this
 * software without specific prior written permission.
 * <p/>
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

import org.apache.log4j.Logger;

import java.io.InputStream;
import java.util.Properties;

/**
 *  Access to jdbc connection properties.
 * Used for creating direct jdbc queries,
 * and also passed to the EntityManagerFactory.
 *
 * Expects a properties file jdbc.properties
 * to be within ClassLoader resource scope
 * or class variable usePU set to local hard-code property set.
 *
 * @author pbmcelwa
 */
public class JdbcProps {

    private static Logger log =
            Logger.getLogger(JdbcProps.class);

    private final Properties jdbcProps;

    /**
     * Get the jdbc properties from "jdbc.properties" properties file
     */
    protected JdbcProps() {

        jdbcProps = new Properties();

        try {
            ClassLoader loader = null;
            // first, try our Class ClassLoader
            loader = JdbcProps.class.getClassLoader();
            if (loader == null) {
                // interesting enough for information
                log.warn("JdbcProps.class.getClassLoader() returned null,"
                        + " trying SystemClassLoader");
                // this could only mean that our ClassLoader is the SystemClassLoader
                loader = ClassLoader.getSystemClassLoader();

                if (loader == null) {
                    // deeper problem (logged in catch block)
                    throw new Exception(
                            "ClassLoader.getSystemClassLoader() returned null !!!");
                } else {
                    log.warn("got SystemClassLoader, continuing...");
                }
            }

            // have a ClassLoader, try getting the properties file
            InputStream inputStream = null;
            try {
                inputStream = loader.getResourceAsStream("jdbc.properties");
            } catch (Exception ex) {
                log.error("loader.getResourceAsStream returned exception:", ex);

            }
            if (inputStream == null) {
                // didn't get a file
                // log this as an error
                throw new Exception(
                        "ClassLoader.getResourceAsStream(\"jdbc.properties\")"
                                + " returned null, no jdbc properties, aborting...");
            } else {
                // we found a file, load that
                jdbcProps.load(inputStream);
                log.warn("loaded jdbc.properties file.");
            }

        } catch (Exception ex) {
            log.error(ex);
        }
    }

    /**
     * Use the jdbc properties given.
     */
    protected JdbcProps(Properties jdbcProperties) {

        jdbcProps = jdbcProperties;
    }

    /**
     *
     * @return String property value for javax.persistence.jdbc.url
     */
    protected final String getUrl() {

        return jdbcProps.getProperty("javax.persistence.jdbc.url");
    }

    /**
     *
     * @return String property value for javax.persistence.jdbc.user
     */
    protected final String getUser() {

        return jdbcProps.getProperty("javax.persistence.jdbc.user");
    }

    /**
     *
     * @return String property value for javax.persistence.jdbc.password
     */
    protected final String getPassword() {
        return System.getProperty("javax.persistence.jdbc.password", jdbcProps.getProperty("javax.persistence.jdbc.password"));
    }

    /**
     * Used by DAOFactory in creating the EntityManagerFactory.
     *
     * @return Properties for jdbc connection
     */
    protected final Properties getJdbcProperties() {

        return jdbcProps;
    }
}
