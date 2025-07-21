package service;

import it.fp8.gcutil.metadata.service.GcloudMetadata;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class GcloudMetadataTest {

    private static final String BASE_URL = "https://nginx-839315814860.europe-west1.run.app/computeMetadata/v1";
    private static final String ID_TOKEN = System.getenv("ID_TOKEN");
    @Test
    public void testGetProjectId() throws IOException, InterruptedException {
        var service = new GcloudMetadata("https://nginx-839315814860.europe-west1.run.app/computeMetadata/v1");
        String projectId = service.getProjectId();
        assertNotNull(projectId);
        assertFalse(projectId.isEmpty());
    }

    @Test
    public void testGetNumericProjectId() throws IOException, InterruptedException {
        var service = new GcloudMetadata("https://nginx-839315814860.europe-west1.run.app/computeMetadata/v1");
        String numericProjectId = service.getNumericProjectId();
        assertNotNull(numericProjectId);
        assertFalse(numericProjectId.isEmpty());
    }

    @Test
    public void testGetRegion() throws IOException, InterruptedException {
        var service = new GcloudMetadata("https://nginx-839315814860.europe-west1.run.app/computeMetadata/v1");
        String region = service.getRegion();
        assertNotNull(region);
        assertFalse(region.isEmpty());
    }

    @Test
    public void testGetZone() throws IOException, InterruptedException {
        var service = new GcloudMetadata("https://nginx-839315814860.europe-west1.run.app/computeMetadata/v1");
        String zone = service.getZone();
        assertNotNull(zone);
        assertFalse(zone.isEmpty());
    }

    @Test
    public void testGetEmailServiceAccount() throws IOException, InterruptedException {
        var service = new GcloudMetadata("https://nginx-839315814860.europe-west1.run.app/computeMetadata/v1");
        String emailServiceAccount = service.getServiceAccountEmail();
        assertNotNull(emailServiceAccount);
        assertFalse(emailServiceAccount.isEmpty());
    }
}
