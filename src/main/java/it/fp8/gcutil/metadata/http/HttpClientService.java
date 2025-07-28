package it.fp8.gcutil.metadata.http;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Objects;

@AllArgsConstructor
@Slf4j
public class HttpClientService {

    private static final HttpClient CLIENT;
    private static final String METADATA_DISABLED = Objects.requireNonNullElse(System.getenv("METADATA_DISABLED"), "false");
    private static final String FP8_ENV = System.getenv("FP8_ENV");


    static {
        CLIENT = HttpClient.newHttpClient();
    }

    public String execute(String baserUrl, String endpointPath) throws IOException, InterruptedException {
        return execute(baserUrl, endpointPath, null);
    }

    public String execute(String baserUrl, String endpointPath, String env) throws IOException, InterruptedException {
        return execute(baserUrl, endpointPath, env, null);
    }

    public String execute(String baserUrl, String endpointPath, String env, String token) throws IOException, InterruptedException {

        // If local development, return associated environment variable if configured
        if (Boolean.parseBoolean(METADATA_DISABLED) ||
                (FP8_ENV != null && FP8_ENV.startsWith("local"))) {
            log.debug("Skipping metadata request for local development");
            if (env != null) {
                return System.getenv(env);
            }
            log.debug("Missing environment variable for endpoint: {} returning NULL", endpointPath);
            return null;
        }

        var url = URI.create(baserUrl + "/" + endpointPath);
        var builder = HttpRequest.newBuilder()
                .uri(url)
                .header("Metadata-Flavor", "Google");

        if (token != null && !token.isEmpty()) {
            builder.header("Authorization", "Bearer " + token);
        }
        var request = builder.build();

        var response = CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
        if (response.statusCode() > 299) {
            throw new RuntimeException("Failed to fetch data from endpoint: " + endpointPath + ", " +
                    "status code: " + response.statusCode());
        }
        return response.body();

    }

}
