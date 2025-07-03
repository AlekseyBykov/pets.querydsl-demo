package dev.abykov.pets.querydsl.demo.config;

import org.springframework.boot.test.context.TestConfiguration;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.utility.DockerImageName;

@TestConfiguration
public class TestContainerConfig {

    public static final PostgreSQLContainer<?> container;

    static {
        container = new PostgreSQLContainer<>(DockerImageName.parse("postgres:16.2"))
                .withDatabaseName("testdb")
                .withUsername("test")
                .withPassword("test");
        container.start();
    }
}
