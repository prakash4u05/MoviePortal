# Product Overview

This is an Employee Management Portal — a two-service web application for managing employee records (create, read, update, delete, search).

## Services

- **EmployeeRESTproj** — Backend REST API. Exposes CRUD endpoints for employee data backed by MongoDB. Runs on port `8888`.
- **EmployeeFacade** — Frontend facade service. Serves JSP-based UI pages and acts as a proxy/intermediary to the REST API. Runs on port `9999`.

## Core Domain

The central entity is `Employee`, with fields: `empid`, `fname`, `lname`, `age`, `department`, `salary`, `Gender`.

Key operations:
- Add a new employee
- Search employees by ID, name, or department
- Update employee details
- Delete an employee
