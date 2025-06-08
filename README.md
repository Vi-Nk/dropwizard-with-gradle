# Dropwizard with Gradle Example

[![Java](https://img.shields.io/badge/Java-17%2B-blue.svg)](https://openjdk.java.net/)
[![Gradle](https://img.shields.io/badge/Gradle-8.5-brightgreen.svg)](https://gradle.org/)
[![Dropwizard](https://img.shields.io/badge/Dropwizard-4.0.14-orange.svg)](https://www.dropwizard.io/)
[![License](https://img.shields.io/badge/License-MIT-green.svg)](LICENSE)

This repository demonstrates how to set up a RESTful API server using Dropwizard framework with Gradle build system.

## Prerequisites

- Java 17 or higher
- Gradle 8.5 or higher (included via Gradle wrapper)

## Project Structure

```
dropwizard-with-gradle/
├── app/
│   ├── src/main/java/dev/vink/example/
│   │   ├── config/
│   │   │   └── AppConfig.java         # Configuration class
│   │   ├── data/
│   │   │   ├── Person.java           # Data model
│   │   │   └── PersonDatabase.java   # In-memory database
│   │   ├── resources/
│   │   │   ├── HealthCheckService.java # Health check implementation
│   │   │   └── PersonService.java     # REST endpoints
│   │   └── App.java                  # Application entry point
│   └── build.gradle                  # Project build configuration
├── config.yml                        # Server configuration
```

## Building the Application

To build the application, run:

```bash
./gradlew clean build
```

This will create two JAR files in `app/build/libs/`:
- `dropwizard-with-gradle-1.0.0.jar`: The application JAR with dependencies for dropwizard server
- `app-1.0.0.jar`: The simple application JAR without dependencies

## Running the Application

To start the server:

```bash
java -jar app/build/libs/dropwizard-with-gradle-1.0.0.jar server config.yml
```

The server will start with configuration passed in config.yml:
- Application port: 8080
- Admin port: 8081

## API Endpoints

### Person Management

- **GET** `/person` - List all persons
- **GET** `/person/{id}` - Get person by ID
- **POST** `/person/add` - Add a new person

Example POST request:
```json
{
    "firstName": "John",
    "lastName": "Doe",
    "email": "john.doe@example.com",
    "id": 1
}
```

### Health Check

- **GET** `/healthcheck` - View application health status

## Configuration

The application is configured via `config.yml`. Key configuration options:

```yaml
environment: development
apiVersion: v1

server:
  applicationConnectors:
    - type: http
      port: 8080
  adminConnectors:
    - type: http
      port: 8081

logging:
  level: INFO
  loggers:
    dev.vink.example: DEBUG
```

## Dependencies

- Dropwizard 4.0.14
- Guava 33.0.0-jre
- JUnit Jupiter 5.10.2 (for testing)

## Building with Shadow JAR

The project uses the Shadow plugin to create a fat JAR. To build it:

```bash
./gradlew shadowJar
```

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
