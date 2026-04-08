package org.example.sesion04.controller;

import org.example.sesion04.dao.StudentDAO;
import org.example.sesion04.model.Student;
import org.example.sesion04.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// đánh dấu bean là controller
@Controller
// đánh dấu đây là đường dẫn đến controller
@RequestMapping
public class HomeController {
    @Autowired
    private StudentDAO studentDAO;

    // chức năng 1 có đường dẫn là gì
    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String home(Model model) {
        List<Student> students = studentService.getStudents();
        // Gửi danh sách sinh viên sang View
        model.addAttribute("students", students);
        // Gửi tiêu đề (title) sang View
        model.addAttribute("title", "Home");
        return "home";
    }
    /**
     * Các anotation không khác gì bean dùng để khỏi tạo và sử dụng DI
     * @Component: đánh dấu là bean để khởi tạo và không có ngữ nghia
     * @Controller: Đánh dấu là bean và mục đích là điều hướng
     * @Service: Đánh dấu là bean và mục đích là nghiệp vụ
     * @Repository: Đánh dấu là bean và mục đích là lưu trữ
     * @Autowired: Dùng để tiêm sự phụ thuộc(DI - dependency injection)
     */
    @Autowired
    private StudentService studentService;
    @RequestMapping(value = "/students", method = RequestMethod.GET)
    public String students() {
        List<Student> students = studentService.getStudents();
        System.out.println(students);
        return "students";
    }
    /**
     * Biến thể của requetMapping
     * @Getmapping: đại diện phương thức GET
     * @PostMapping: Đại diện cho phương thức Post
     * @PutMapping: đại diện cho PUT
     * @DeleteMapping: đại diện cho DELETE
     * @PatchMapping: đại diện cho PATCH
     */
    //tìm kiếm
    @GetMapping("/search")
    public String search(@RequestParam(name = "keyword", defaultValue = "")String keyword, Model model) {
        System.out.println("Noi dung: " + keyword);
        List<Student> students = studentDAO.search(keyword);

        model.addAttribute("students", students);
        model.addAttribute("title", "Search");
        return "home";
    }
    // trang chi tiết
    //id ở đường dẫn có thể đựt theo tùy biến
    @GetMapping("/detail{id}")
    public String detail(@PathVariable(name = "id") int id) {
        System.out.println("Gia tri tren duong dan: " + id);
        return "home";
    }
}
