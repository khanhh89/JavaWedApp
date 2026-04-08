package org.example.sesion04.dao;

import org.example.sesion04.model.Student;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@Repository
public class StudentDAO {
    List<Student> students = new ArrayList<>(
            Arrays.asList(
                    new Student(1, "Khanhdao", 20, true),
                   new Student(2, "daoKhanh", 20, true),
                    new Student(3, "Cu", 20, false)
            )
    );
    // phương thức lấy về danh sánh
    public List<Student> getAll() {
        return this.students;
    }
    // tìm kiếm
    public List<Student> search(String keyword){
        return students.stream().filter(student -> student.getFullName().contains(keyword)).toList();
    }
}
