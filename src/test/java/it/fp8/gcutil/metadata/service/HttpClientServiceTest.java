package it.fp8.gcutil.metadata.service;

import it.fp8.gcutil.metadata.http.HttpClientService;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HttpClientServiceTest{

    private static final String BASE_URL = "https://nginx-839315814860.europe-west1.run.app/computeMetadata/v1";
    private static final String ID_TOKEN = System.getenv("ID_TOKEN");

    @Test
    void testExecute() throws IOException, InterruptedException {
        // Arrange
        HttpClientService httpClientService1 = new HttpClientService();

        String response1 = httpClientService1.execute(BASE_URL, "project/project-id", null, ID_TOKEN);

        // Assert
        assertEquals(response1, "fp8netes-dev");
    }
}