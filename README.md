# Directions
To run this application please clone or download and extract the master branch and then execute `mvnw spring-boot:run` from withing the root folder of this project.

A postman collection with some test requests has been included at `src/test/resources/Devices_Test.postman_collection.json`.

# Decisions
- I assumed that the error message for invalid serial numbers could be interpreted to mean valid serial numbers matched *^[a-zA-Z0-9-]$*
- I chose to implement the simplest form of this application, using an in-memory database and no form of authentication or authorization
- I elected to neglect unit testing and automated system testing in favor of manual tests via Postman
- I assumed there was no need for any uniqueness constraints on the device fields
