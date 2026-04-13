package org.example.bt3sesion07.model;

import java.time.LocalDateTime;

public class Food {
    private Long id;
    private String name;
    private String category;
    private double imgaePath;
    private LocalDateTime createAt;
    private double price;
    public Food() {
    }

    public Food(Long id, String name, String category, double imgaePath, LocalDateTime createAt, double price) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.imgaePath = imgaePath;
        this.createAt = createAt;
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getImgaePath() {
        return imgaePath;
    }

    public void setImgaePath(double imgaePath) {
        this.imgaePath = imgaePath;
    }

    public LocalDateTime getCreateAt() {
        return createAt;
    }
    public double getPrice() {
        return price;
    }
    public void setCreateAt(LocalDateTime createAt) {
        this.createAt = createAt;
    }
}
