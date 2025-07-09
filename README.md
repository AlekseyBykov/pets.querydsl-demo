# querydsl-demo

A **pet Spring Boot project** demonstrating QueryDSL usage with realistic practices.

## About

Demonstrates:

- Generation of QueryDSL Q-classes for JPA entities.
- Usage of Spring Data JPA with QueryDSL for type-safe dynamic queries.
- A simple REST API for searching courses.
- Integration tests with Testcontainers and PostgreSQL.

## How it works

- QueryDSL generates Q-classes (meta-models) for JPA entities during build time via Maven annotation processing.
- These classes enable type-safe queries in repositories and services, avoiding fragile string-based queries.
- Tests run with Testcontainers, launching PostgreSQL in Docker for realistic database testing.

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

Uses official QueryDSL from Maven Central without a custom fork.

A fork may be required when:

- Using SNAPSHOT versions or unreleased features.
- Migrating to Java 21 and Spring Boot 3.x, where official QueryDSL support is partial.
- Customizing APT generation.

## Important

Designed primarily for test demonstrations. No standalone application use outside tests.

## License
MIT License
