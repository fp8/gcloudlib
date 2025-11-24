# Gcloud Metadata Utility

This library provides a simple way to retrieve metadata information from Google Cloud endpoints. 
It is designed to interact with the Google Cloud Metadata Server and fetch details such as project ID, numeric project ID, region, zone, and service account email.

## Features

- Retrieve Google Cloud project ID
- Fetch numeric project ID
- Get region and zone information
- Access service account email
- Built-in HTTP client for metadata requests

## Installation
Generate library locally with `mvn clean install -DskipTests`
then add the following dependency to your `pom.xml`:

```xml
<dependency>
    <groupId>it.fp8.gcutil</groupId>
    <artifactId>gcloud-metadata</artifactId>
    <version>{version}</version>
</dependency>
```

## Usage

If you want to skip the call to google service set env variable `METADATA_DISABLED` to `true`.

```java
    var service = new GcloudMetadata("{baseUrl}");
    String projectId = service.getProjectId();
```

## Run Test
To run the tests, you can use the following command to get the token 

```
gcloud auth print-identity-token
```

then paste the result into ID_TOKEN enviroment before running the tests.

