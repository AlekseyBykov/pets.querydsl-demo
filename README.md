# querydsl-demo

A **pet Spring Boot project** demonstrating QueryDSL usage with realistic practices.

## About

This project demonstrates:

- Generating **QueryDSL Q-classes** for JPA entities.
- Using **Spring Data JPA + QueryDSL** for type-safe dynamic queries.
- A simple **REST API** for searching courses.
- Integration tests with **Testcontainers** and PostgreSQL.

## How it works

- QueryDSL generates **Q-classes** (meta-models) for JPA entities during build time via Maven annotation processing.
- These classes are used for **type-safe queries** in repositories and services, avoiding fragile string-based queries.
- Tests use **Testcontainers**, running PostgreSQL in Docker to ensure realistic database testing.

## Tech stack

- Java 17
- Spring Boot 2.7.x
- Spring Data JPA
- QueryDSL 5.x
- PostgreSQL (via Testcontainers)
- JUnit 5 + Spring Test

## Running tests

Ensure you have Docker running, then:

```bash
./run-tests.sh
```

This script executes Maven tests with Testcontainers support.

## Fork notes

This project uses **official QueryDSL** (from Maven Central) without requiring a custom fork.

You might need a fork if:

- You require **SNAPSHOT** versions or unreleased features.
- You plan to upgrade to **Java 21 + Spring Boot 3.x**, where official QueryDSL support is still partial.
- You need to add custom **APT generation** modifications.

## Important

This project focuses **only on tests** as its primary use-case. There is no standalone application usage outside tests.

## Planned

- Advanced QueryDSL usage: dynamic predicates, projections (DTOs), pagination.
- GraphQL integration example.

## License
MIT License
