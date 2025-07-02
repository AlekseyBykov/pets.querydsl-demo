# querydsl-demo

Sample Spring Boot project demonstrating QueryDSL usage.

## About

This project demonstrates:

- Generating QueryDSL Q-classes
- Using Spring Data JPA with QueryDSL
- A simple API for searching courses

## How it works

QueryDSL mechanics:

- QueryDSL generates **Q-classes** (meta-model classes) for JPA entities during build.
- These classes are used for **type-safe queries** in repositories and services.
- Generation is performed via Maven annotation processing during `mvn compile`.

## Tech stack

- Java 17
- Spring Boot 2.7.x
- Spring Data JPA
- QueryDSL 5.x
- H2 Database
- JUnit 5 + MockMvc

## Fork notes

This project uses official QueryDSL (from Maven Central) without requiring a custom fork.

You might need a fork if:

- You want to use QueryDSL SNAPSHOT or custom branches.
- You plan to upgrade to Java 21 + Spring Boot 3.x, where official QueryDSL support is still partial.
- You need to add custom APT generation modifications.

## License
MIT License
