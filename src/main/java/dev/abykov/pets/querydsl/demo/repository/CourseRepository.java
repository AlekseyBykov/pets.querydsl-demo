package dev.abykov.pets.querydsl.demo.repository;

import dev.abykov.pets.querydsl.demo.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface CourseRepository
        extends JpaRepository<Course, Long>,
        QuerydslPredicateExecutor<Course>,
        CourseRepositoryCustom {
}
