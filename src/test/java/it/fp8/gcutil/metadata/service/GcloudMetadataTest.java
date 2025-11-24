package it.fp8.gcutil.metadata.service;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class GcloudMetadataTest {

    private static final String BASE_URL = "https://nginx-839315814860.europe-west1.run.app/computeMetadata/v1";

    @Test
    public void testGetProjectId() throws IOException, InterruptedException {
        var service = new GcloudMetadata(BASE_URL);
        String projectId = service.getProjectId();
        assertNotNull(projectId);
        assertFalse(projectId.isEmpty());
    }

    @Test
    public void testGetNumericProjectId() throws IOException, InterruptedException {
        var service = new GcloudMetadata(BASE_URL);
        String numericProjectId = service.getNumericProjectId();
        assertNotNull(numericProjectId);
        assertFalse(numericProjectId.isEmpty());
    }

    @Test
    public void testGetRegion() throws IOException, InterruptedException {
        var service = new GcloudMetadata(BASE_URL);
        String region = service.getRegion();
        assertNotNull(region);
        assertFalse(region.isEmpty());
    }

    @Test
    public void testGetZone() throws IOException, InterruptedException {
        var service = new GcloudMetadata(BASE_URL);
        String zone = service.getZone();
        assertNotNull(zone);
        assertFalse(zone.isEmpty());
    }

    @Test
    public void testGetEmailServiceAccount() throws IOException, InterruptedException {
        var service = new GcloudMetadata(BASE_URL);
        String emailServiceAccount = service.getServiceAccountEmail();
        assertNotNull(emailServiceAccount);
        assertFalse(emailServiceAccount.isEmpty());
    }
}
