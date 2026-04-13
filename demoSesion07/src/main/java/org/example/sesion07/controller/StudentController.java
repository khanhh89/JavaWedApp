package org.example.sesion07.controller;

import org.example.sesion07.model.Student;
import org.example.sesion07.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping
public class StudentController {

    // Cơ chế Dependency Injection
    @Autowired
    private StudentRepository studentRepository;

    @GetMapping
    public String home(Model model) {
        // Gửi dữ liệu sang view
        model.addAttribute(
                "students",
                studentRepository.getStudents()
        );
        return "home";
    }

    @GetMapping("/view-add")
    public String viewAdd(Model model) {
        model.addAttribute("student", new Student());
        return "form-add";
    }

    @PostMapping("/handle-add")
    public String handleAdd(
            @ModelAttribute(name = "student") Student student
    ) {
        System.out.println(student);
        studentRepository.addStudent(student);
        return "redirect:/";
    }

}