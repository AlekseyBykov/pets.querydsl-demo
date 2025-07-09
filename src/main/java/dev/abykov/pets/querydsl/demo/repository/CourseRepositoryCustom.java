package dev.abykov.pets.querydsl.demo.repository;

import com.querydsl.core.Tuple;
import dev.abykov.pets.querydsl.demo.entity.Course;
import java.util.List;

public interface CourseRepositoryCustom {

    List<Course> findByNamePart(String namePart);

    List<Course> findByExactName(String name);

    List<Course> findByNameAndDescription(String name, String description);

    List<Course> findByNameOrDescriptionContaining(String keyword);

    List<Course> searchCourses(String name, String description);

    List<Course> findAllOrderByNameAsc();

    List<Course> findPaged(int page, int size);

    long countAll();

    List<Tuple> countByCategory();
}
