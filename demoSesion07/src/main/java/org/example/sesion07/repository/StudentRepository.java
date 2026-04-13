package org.example.sesion07.repository;

import org.example.sesion07.model.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class StudentRepository {

    List<Student> students = new ArrayList<>(
            Arrays.asList(
                    new Student(1, "Phạm Thành Đạt", false, 20, "Ninh Bình"),
                    new Student(2, "Trần Việt Anh", false, 20, "Hưng Yên"),
                    new Student(3, "Nguyễn Thị Phương", true, 20, "Thái Bình")
            )
    );

    public List<Student> getStudents() {
        return this.students;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

}