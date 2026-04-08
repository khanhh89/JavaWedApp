package org.example.sesion04.service;

import org.example.sesion04.dao.StudentDAO;
import org.example.sesion04.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class StudentService {
    // tiêm sự phụ thuộc
    @Autowired
    private StudentDAO studentDAO;
    public List<Student> getStudents() {
        List<Student> students =  studentDAO.getAll();
        return students;
    }
}
