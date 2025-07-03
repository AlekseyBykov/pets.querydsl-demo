package dev.abykov.pets.querydsl.demo.service;

import dev.abykov.pets.querydsl.demo.config.TestContainerConfig;
import dev.abykov.pets.querydsl.demo.entity.Course;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ContextConfiguration(classes = {TestContainerConfig.class})
class CourseServiceTest {

    @Autowired
    private CourseService courseService;

    @DynamicPropertySource
    static void overrideProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", TestContainerConfig.container::getJdbcUrl);
        registry.add("spring.datasource.username", TestContainerConfig.container::getUsername);
        registry.add("spring.datasource.password", TestContainerConfig.container::getPassword);
        registry.add("spring.datasource.driver-class-name", () -> "org.postgresql.Driver");
        registry.add("spring.jpa.hibernate.ddl-auto", () -> "none"); // Flyway cteates schema
    }

    @Test
    void findAllCourses_shouldReturnAllCourses() {
        List<Course> courses = courseService.findAllCourses();

        assertThat(courses).hasSize(3);

        assertThat(courses).extracting(Course::getName)
                .containsExactlyInAnyOrder(
                        "Java Programming",
                        "Spring Boot",
                        "Database Design"
                );

        assertThat(courses).extracting(Course::getDescription)
                .contains(
                        "Learn the basics of Java programming language",
                        "Build REST APIs with Spring Boot",
                        "Understand database normalization and design"
                );
    }

    @Test
    void searchCourses_shouldReturnMatchingCoursesForJava() {
        List<Course> result = courseService.findCoursesByName("Java");

        assertThat(result)
                .hasSize(1)
                .extracting(Course::getName)
                .containsExactly("Java Programming");
    }

    @Test
    void searchCourses_shouldReturnMatchingCoursesForSpring() {
        List<Course> result = courseService.findCoursesByName("Spring");

        assertThat(result)
                .hasSize(1)
                .extracting(Course::getName)
                .containsExactly("Spring Boot");
    }

    @Test
    void searchCourses_shouldReturnEmptyListWhenNoMatch() {
        List<Course> result = courseService.findCoursesByName("Kotlin");

        assertThat(result).isEmpty();
    }
}
