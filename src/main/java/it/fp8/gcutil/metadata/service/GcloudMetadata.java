package it.fp8.gcutil.metadata.service;

import it.fp8.gcutil.metadata.constant.Constants;
import it.fp8.gcutil.metadata.http.HttpClientService;
import lombok.AllArgsConstructor;

import java.io.IOException;
import java.util.Objects;

@AllArgsConstructor
public class GcloudMetadata implements IMetadata {

    private String baseUrl;

    @Override
    public String getProjectId() throws IOException, InterruptedException {
        var client = new HttpClientService();
        return client.execute(baseUrl, "project/project-id", Constants.GOOGLE_CLOUD_PROJECT);
    }

    @Override
    public String getNumericProjectId() throws IOException, InterruptedException {
        var client = new HttpClientService();
        return client.execute(baseUrl, "project/numeric-project-id");
    }

    @Override
    public String getRegion() throws IOException, InterruptedException {
        var client = new HttpClientService();
        var fullRegionPath = client.execute(baseUrl, "instance/region", Constants.GOOGLE_CLOUD_REGION);
        // Extract the region from the full path
        return Objects.requireNonNullElse(
                fullRegionPath.substring(fullRegionPath.lastIndexOf("/") + 1),
                "");
    }

    @Override
    public String getZone() throws IOException, InterruptedException {
        var client = new HttpClientService();
        var fullRegionPath = client.execute(baseUrl, "instance/zone", Constants.GOOGLE_CLOUD_ZONE);
        // Extract the region from the full path
        return Objects.requireNonNullElse(
                fullRegionPath.substring(fullRegionPath.lastIndexOf("/") + 1),
                "");
    }

    @Override
    public String getServiceAccountEmail() throws IOException, InterruptedException {
        var client = new HttpClientService();
        var sa = client.execute(baseUrl, "instance/service-accounts/");
        if (sa != null && sa.contains("/")) {
            // Extract the email service account from the full path
            var email = sa.substring(0, sa.indexOf("/"));

            // Extract the region from the full path
            return Objects.requireNonNullElse(
                    sa.substring(email.lastIndexOf("/") + 1),
                    "");
        }
        return null;
    }
}
