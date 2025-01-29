# CEP Search Project Integrating WireMock, MySQL, and Java API

This project aims to simulate a ZIP code lookup service using WireMock inside a Docker container. The MySQL database is also in a Docker container and is used by the Java API to register the performed searches along with the timestamp of the request.

## Solution Overview

## Project Structure

- **WireMock**: Mock service for simulating ZIP code lookups.
- **MySQL**: Database that stores the performed searches.
- **Java API**: API that interacts with the WireMock service, executes searches, and registers the data in the database.

## Requirements

- Docker and Docker Compose installed on your system.
- Java 8 or later.
- Maven for managing Java dependencies (if applicable).

## How to Run the Project

### Step 1: Start the Docker Containers

To start the containers with WireMock and MySQL, run the following command in the directory where the `docker-compose.yml` file is located:

> docker-compose up -d  

This command will start two containers:

- **WireMock**: A mock server for simulating ZIP code lookups.  
- **MySQL**: A MySQL database to store searches performed by the API.  

### Step 2: Verify if the Containers are Running

After executing the command above, you can check if the containers are running correctly with:

> docker ps  

The `wiremock` and `mysql` containers should appear in the list.

### Step 3: Access MySQL in the Container

To access MySQL inside the container, run the following command:

> docker exec -it <container_id> mysql -u root -p  

Replace `<container_id>` with the ID of the MySQL container, which you can obtain using **docker ps**.
