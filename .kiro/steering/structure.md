# Project Structure

The workspace contains two independent Spring Boot services, each with its own Maven build.

```
MoviePortal/
├── EmployeeRESTproj/          # Backend REST API (port 8888)
│   ├── pom.xml
│   └── src/main/java/com/Apple/employeeREST/EmployeeRESTproj/
│       ├── controller/        # @RestController — HTTP endpoints
│       ├── Service/           # @Service interface + Impl — business logic
│       ├── DAO/               # MongoRepository interfaces — data access
│       ├── Model/             # @Document POJOs (Employee)
│       └── EmployeeResTprojApplication.java
│
├── EmployeeFacade/            # Frontend facade + UI (port 9999)
│   ├── pom.xml
│   └── src/main/java/com/Apple/EmployeeFacade/EmployeeFacade/
│       ├── Controller/        # @Controller — view routing + JSON proxy endpoints
│       ├── Service/           # @Service interface + Impl — calls REST API via RESTEasy/RestTemplate
│       ├── Model/             # Shared Employee POJO (mirrors backend model)
│       └── EmployeeFacadeApplication.java
│   └── src/main/webapp/WEB-INF/jsp/
│       ├── start.jsp          # Landing page
│       ├── home.jsp           # Search + add employee
│       ├── addDetails.jsp     # Add employee form
│       ├── empSearch.jsp      # Search form
│       ├── Update.jsp         # Update form
│       └── index.jsp
│   └── src/main/resources/
│       ├── application.properties
│       └── static/css/        # Shared CSS (basestyle.css)
│
└── .kiro/steering/            # AI assistant steering rules
```

## Architecture Pattern

Both services follow the same layered pattern:

```
Controller → Service (interface) → ServiceImpl → DAO (EmployeeRESTproj only)
```

- **EmployeeRESTproj**: Controller → Service → DAO (MongoRepository) → MongoDB
- **EmployeeFacade**: Controller → Service → HTTP calls to EmployeeRESTproj

## Package Naming

- REST service: `com.Apple.employeeREST.EmployeeRESTproj.<layer>`
- Facade service: `com.Apple.EmployeeFacade.EmployeeFacade.<layer>`

Note the inconsistent casing (`employeeREST` vs `EmployeeFacade`) — match the existing convention per service when adding new classes.

## Key Conventions

- Service layer is always defined as an interface first, then a separate `*Impl` class
- Controllers use `@RequestMapping` (not the shorthand `@GetMapping`/`@PostMapping`)
- MongoDB queries use `@Query` annotations with JSON-style query strings
- `@CrossOrigin(origins = "http://localhost:9999")` is set on the REST controller to allow requests from the facade
- JSP views live under `WEB-INF/jsp/` and are resolved via `spring.mvc.view.prefix/suffix` in `application.properties`
- Frontend interactions use jQuery AJAX calls that hit the backend REST API directly or through facade endpoints
