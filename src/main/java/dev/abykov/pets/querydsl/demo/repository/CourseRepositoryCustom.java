package dev.abykov.pets.querydsl.demo.repository;

import dev.abykov.pets.querydsl.demo.entity.Course;
import java.util.List;

public interface CourseRepositoryCustom {

    List<Course> findByNamePart(String namePart);

    List<Course> findByExactName(String name);
}
