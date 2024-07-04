package com.example.demo;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class CourseService {
    private final CourseRepository repo;

    public CourseService(CourseRepository repo) {
        this.repo = repo;
    }

    public List<Course> retrieveAllCourses() {
        return repo.findAll();
    }

    public void saveCourse(Course course) {
        if (course.getId() == 0) {
            int maxId = repo.findAll().stream().mapToInt(Course::getId).max().orElse(100);
            course.setId(maxId + 1);
        }
        repo.save(course);
        System.out.println(course);
    }

    public void removeCourse(int id) {
        repo.deleteById(id);
    }

    public Course getById(int id) {
        return repo.findById(id).orElse(null);
    }
}
