package org.example.bt2sesion07.model;
public class Dish {
    private String name;
    private String category;

    public Dish() {
    }

    public Dish(String name, String category) {
        this.name = name;
        this.category = category;
    }

    // Getter & Setter
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
}