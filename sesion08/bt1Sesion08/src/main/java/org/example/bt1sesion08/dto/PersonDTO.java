package org.example.bt1sesion08.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import org.springframework.format.annotation.DateTimeFormat;

public class PersonDTO {
    @Min(1)
    private Long id;
    @NotBlank(message = "Tên không được để trống")
    private String name;
    private String gender;
    @Past(message = "Không được lớn hơn ngày hiện tại")
    @DateTimeFormat(pattern = "yyyy-MM-dd")

    private String birthDate;
    @Min(value = 15, message = "Tuổi phải lớn hơn 15")
    private Integer age;
    @Pattern(regexp="^[a-zA-Z0-9._%+-]+@[a-zA-Z]+\\.[a-zA-Z]{2,4}$", message = "Email không hợp lệ")
    private String email;

    public PersonDTO() {
    }

    public PersonDTO(Long id, String name, String gender, String birthDate, Integer age, String email) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.birthDate = birthDate;
        this.age = age;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
