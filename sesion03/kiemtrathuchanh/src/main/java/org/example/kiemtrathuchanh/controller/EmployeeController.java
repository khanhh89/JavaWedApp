package org.example.kiemtrathuchanh.controller;

import org.example.kiemtrathuchanh.model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class EmployeeController {

    @GetMapping("/employee-list")
    public String showEmployeeList(Model model) {

        List<Employee> employees = new ArrayList<>();

        employees.add(new Employee(1, "Nguyen Van A", "IT", 12000));
        employees.add(new Employee(2, "Tran Thi B", "HR", 8000));
        employees.add(new Employee(3, "Le Van C", "Finance", 15000));

        model.addAttribute("employees", employees);

        return "employee-list";
    }
}