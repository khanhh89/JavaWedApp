package org.example.sesion07.model;

public class Food {
    private String name;
    private String imgUrl;
    private String displayPath;
    private int price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getDisplayPath() {
        return displayPath;
    }

    public void setDisplayPath(String displayPath) {
        this.displayPath = displayPath;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;

    }

    public void setId(String string) {
    }

    public void setPhysicalPath(String absolutePath) {
    }

    public String getId() {
        return null;
    }
}