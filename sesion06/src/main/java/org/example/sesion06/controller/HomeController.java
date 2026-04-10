package org.example.sesion06.controller;

import org.example.sesion06.model.Books;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/books")
public class HomeController {
    private final List<Books> list = Arrays.asList(
            new Books(1, "Lap trinh Java", "Java", 50000),
            new Books(2, "Lap trinh C", "C", 40000),
            new Books(3, "Cach nau an", "Nau an", 30000),
            new Books(4, "Hoc Spring Boot", "Spring", 60000)
    );

    @GetMapping
    public String listBooks(Model model) {
        model.addAttribute("books", list);
        model.addAttribute("pageTitle", "Danh sach sach");
        return "books";
    }

    @GetMapping("/{id}")
    public String bookDetail(@PathVariable("id") int id, Model model) {
        Books book = list.stream().filter(b -> b.getId() == id).findFirst().orElse(null);
        model.addAttribute("book", book);
        model.addAttribute("pageTitle", book != null ? "Chi tiet sach" : "Khong tim thay sach");
        return "book-detail";
    }
}
