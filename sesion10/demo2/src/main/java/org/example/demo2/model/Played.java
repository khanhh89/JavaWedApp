package org.example.demo2.model;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class Played {
    private Long id; // Đã đổi ID -> id để chuẩn Java Bean naming
    
    @NotBlank(message = "Không được để trống!!!")
    @Size(min =3, max = 50, message = "Nhập từ 3-50 kí tự")
    private String name;
    
    @NotBlank(message = "Không được để trống")
    private String position;
    
    @Min(value = 1, message = ">0")
    @Max(value = 99, message = "<=99")
    private Integer jerseyNumber;
    
    private String avatar;

    public Played() {
    }

    public Played(Long id, String name, String position, Integer jerseyNumber, String avatar) {
        this.id = id;
        this.name = name;
        this.position = position;
        this.jerseyNumber = jerseyNumber;
        this.avatar = avatar;
    }

    public Long getId() { // Đã sửa tên getter
        return id;
    }

    public void setId(Long id) { // Đã sửa tên setter và gán giá trị
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Integer getJerseyNumber() {
        return jerseyNumber;
    }

    public void setJerseyNumber(Integer jerseyNumber) {
        this.jerseyNumber = jerseyNumber;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar; // Sửa lỗi setter bị trống
    }
}