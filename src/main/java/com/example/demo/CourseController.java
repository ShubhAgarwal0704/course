package com.example.demo;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;




@Controller
public class CourseController {
    private final CourseService service;

    public CourseController(CourseService service) {
        this.service = service;
    }

    @GetMapping(path = {"/", "/courses"})
    public String viewHomePage(Model mav) {
        List<Course> courses = service.retrieveAllCourses();
        mav.addAttribute("list_of_courses", courses);
        return "index";
    }

    @GetMapping("/addNew")
    public String addNewCourse(Model mav) {
        Course course = new Course();
        mav.addAttribute("course", course);
        return "addCourse";
    }

    @PostMapping("/save")
    public String createOrUpdateCourse(@ModelAttribute("course") Course course) {
        service.saveCourse(course);
        return "redirect:/";
    }

    @GetMapping("/deleteCourse/{id}")
    public String deleteStudent(@PathVariable int id) {
        service.removeCourse(id);
        return "redirect:/";
    }

    @GetMapping("/updateCourse/{id}")
    public String updateForm(@PathVariable(value = "id") int id, Model mav) {
        Course course = service.getById(id);
        mav.addAttribute("course", course);
        return "addCourse";
    }
}
