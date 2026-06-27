# Tech Stack

## Language & Runtime
- Java 8
- Spring Boot 1.5.9.RELEASE

## Frameworks & Libraries
- **Spring MVC** — REST controllers and view routing
- **Spring Data MongoDB** — Repository layer via `MongoRepository`
- **RESTEasy (JBoss)** — JAX-RS client used in EmployeeFacade to call the backend REST API
- **Spring RestTemplate** — Also used in EmployeeFacade for some outbound HTTP calls
- **Tomcat Embed Jasper + JSTL** — JSP rendering in EmployeeFacade
- **Spring Boot Actuator** — Health and metrics endpoints (both services)
- **Spring Boot DevTools** — Hot reload during development
- **jQuery** — Frontend AJAX calls in JSP pages
- **Jackson** — JSON serialization/deserialization

## Database
- MongoDB on `localhost:27017`, database name: `EmployeeDB`

## Build System
- Maven (Maven Wrapper included: `mvnw` / `mvnw.cmd`)
- Each service has its own `pom.xml`

## Common Commands

Run from within each service directory (`EmployeeRESTproj/` or `EmployeeFacade/`):

```bash
# Build (skip tests)
./mvnw clean package -DskipTests

# Run the application
./mvnw spring-boot:run

# Run tests
./mvnw test
```

## Service Ports
| Service           | Port |
|-------------------|------|
| EmployeeRESTproj  | 8888 |
| EmployeeFacade    | 9999 |

## Notes
- Spring Security is present as a commented-out dependency in `EmployeeRESTproj` — not currently active.
- `EmployeeFacade` has hardcoded backend URLs pointing to `localhost:8888`. The REST service must be running before starting the facade.
