# Release Notes

## 0.1.0
- Added `GcloudMetadata` class to interact with Google Cloud Metadata Server.
- Implemented the following metadata retrieval methods:
    - `getProjectId()`: Fetches the Google Cloud project ID.
    - `getNumericProjectId()`: Retrieves the numeric project ID.
    - `getRegion()`: Extracts the region from the metadata server.
    - `getZone()`: Extracts the zone from the metadata server.
    - `getServiceAccountEmail()`: Retrieves the service account email.

