# Testcontainers Demo

This project shows how to use Testcontainers with Spring Boot. An Oracle database is started in a Docker container when the tests are run. The database is seeded with data from a SQL script. After tests are run, the database container is stopped.

JPA repositories are tested against a real Oracle database without having to install Oracle locally. This is very useful for testing the JPA entity configuration and SQL queries.

## Requirements

* Java 17
* Gradle
* Docker

### Reference Documentation
For further reference, please consider the following sections:

* [Testcontainers](https://java.testcontainers.org/)
* [Official Gradle documentation](https://docs.gradle.org)
* [Spring Boot Testcontainers support](https://docs.spring.io/spring-boot/docs/3.1.3/reference/html/features.html#features.testing.testcontainers)
* [Spring Data JPA](https://docs.spring.io/spring-boot/docs/3.1.3/reference/htmlsingle/index.html#data.sql.jpa-and-spring-data)

### Guides
The following guides illustrate how to use some features concretely:

* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)
