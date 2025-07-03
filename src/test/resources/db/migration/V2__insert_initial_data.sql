INSERT INTO student (name, email) VALUES
('John Doe', 'john.doe@example.com'),
('Jane Smith', 'jane.smith@example.com'),
('Alice Brown', 'alice.brown@example.com');

INSERT INTO course (name, description) VALUES
('Java Programming', 'Learn the basics of Java programming language'),
('Spring Boot', 'Build REST APIs with Spring Boot'),
('Database Design', 'Understand database normalization and design');

INSERT INTO enrollment (student_id, course_id, grade) VALUES
(1, 1, 'A'),
(1, 2, 'B'),
(2, 2, 'A'),
(3, 3, 'C');
