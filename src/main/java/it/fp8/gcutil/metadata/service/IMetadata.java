package it.fp8.gcutil.metadata.service;

import java.io.IOException;

public interface IMetadata {

    /**
     * Returns the project ID of the Google Cloud project.
     *
     * @return the project ID
     */
    String getProjectId() throws IOException, InterruptedException;

    /**
     * Returns the numeric project ID of the Google Cloud project.
     *
     * @return the numeric project ID
     */
    String getNumericProjectId() throws IOException, InterruptedException;

    /**
     * Returns the region of the Google Cloud project.
     *
     * @return the region
     */
    String getRegion() throws IOException, InterruptedException;

    /**
     * Returns the zone of the Google Cloud project.
     *
     * @return the zone
     */
    String getZone() throws IOException, InterruptedException;

    /**
     * Return the email service account associated with the Google Cloud project.
     *
     * @return the email service account
     */
    String getServiceAccountEmail() throws IOException, InterruptedException;

}
