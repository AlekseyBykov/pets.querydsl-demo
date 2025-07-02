package dev.abykov.pets.querydsl.demo.controller;

import dev.abykov.pets.querydsl.demo.PetsQuerydslDemoApplication;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(classes = PetsQuerydslDemoApplication.class)
@AutoConfigureMockMvc
public class CourseControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testSearchCourses() throws Exception {
        mockMvc.perform(get("/courses/search")
                        .param("q", "Math"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$").isArray());
    }
}
