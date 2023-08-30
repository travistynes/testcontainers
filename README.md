# Spring Boot Testcontainers Demo

This project shows how to use Testcontainers with Spring Boot.

In this project, an Oracle database is started in a Docker container when the tests are run. The database is seeded with data from a SQL script. After tests are run, the database container is stopped.

JPA repositories are tested against a real Oracle database without having to install Oracle locally. This is very useful for testing the JPA entity configuration and SQL queries.

This also allows for a test-driven development style and makes it easier for developers to start writing and testing code without the need to connect to an external database or install the database locally.

## Requirements

* Java 17
* Gradle
* Docker

Note: Docker must be running on your machine and should be able to run without sudo (as a non-root user). To configure docker to run as a non-root user, see [the documentation](https://docs.docker.com/engine/install/linux-postinstall/)

## Running the tests

```shell
./gradlew test
```
To run a specific test class and view the SQL queries being run against the database, use the following command:

```shell
./gradlew test --tests *UserRepositoryTest --info
```

### Reference Documentation
For further reference, please consider the following sections:

* [Testcontainers](https://java.testcontainers.org/)
* [Official Gradle documentation](https://docs.gradle.org)
* [Spring Boot Testcontainers support](https://docs.spring.io/spring-boot/docs/3.1.3/reference/html/features.html#features.testing.testcontainers)
* [Spring Data JPA](https://docs.spring.io/spring-boot/docs/3.1.3/reference/htmlsingle/index.html#data.sql.jpa-and-spring-data)

### Guides
The following guides illustrate how to use some features concretely:

* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)
