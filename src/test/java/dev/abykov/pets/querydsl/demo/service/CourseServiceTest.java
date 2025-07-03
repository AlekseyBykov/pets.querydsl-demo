package dev.abykov.pets.querydsl.demo.service;

import dev.abykov.pets.querydsl.demo.config.TestContainerConfig;
import dev.abykov.pets.querydsl.demo.entity.Course;
import dev.abykov.pets.querydsl.demo.repository.CourseRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.utility.DockerImageName;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ContextConfiguration(classes = {TestContainerConfig.class})
class CourseServiceTest {

    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private CourseService courseService;

    @Autowired
    private PostgreSQLContainer<?> postgresContainer;

    @DynamicPropertySource
    static void overrideProperties(DynamicPropertyRegistry registry) {
        PostgreSQLContainer<?> container = new PostgreSQLContainer<>(DockerImageName.parse("postgres:16.2"))
                .withDatabaseName("testdb")
                .withUsername("test")
                .withPassword("test");
        container.start();

        registry.add("spring.datasource.url", container::getJdbcUrl);
        registry.add("spring.datasource.username", container::getUsername);
        registry.add("spring.datasource.password", container::getPassword);
        registry.add("spring.jpa.hibernate.ddl-auto", () -> "create-drop");
    }

    @BeforeEach
    void setUp() {
        courseRepository.save(new Course(null, "Mathematics", "Algebra and Geometry"));
        courseRepository.save(new Course(null, "Physics", "Mechanics and Optics"));
    }

    @Test
    void searchCourses_shouldReturnMatchingCourses() {
        List<Course> result = courseService.findCoursesByName("Math");

        assertThat(result).hasSize(1);
        assertThat(result.get(0).getName()).isEqualTo("Mathematics");
    }
}
