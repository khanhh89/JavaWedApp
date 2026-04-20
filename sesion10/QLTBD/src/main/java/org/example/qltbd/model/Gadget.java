package org.example.qltbd.model;

import jakarta.validation.constraints.*;
public class Gadget {

    private Long id;

    @NotBlank(message = "Tên sản phẩm không được để trống")
    @Size(min = 3, max = 100, message = "Tên phải từ 3 đến 100 ký tự")
    private String productName;

    @NotBlank(message = "Hãng không được để trống")
    @Pattern(regexp = "^[^\\s]+$", message = "Không được chứa khoảng trắng")
    private String brand;

    @NotNull(message = "Số lượng không được để trống")
    @Min(value = 0, message = "Số lượng phải >= 0")
    private Integer stockQuantity;

    private String productImage;

    public Gadget() {}

    public Gadget(Long id, String productName, String brand, Integer stockQuantity, String productImage) {
        this.id = id;
        this.productName = productName;
        this.brand = brand;
        this.stockQuantity = stockQuantity;
        this.productImage = productImage;
    }

    // getter setter
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getProductName() { return productName; }
    public void setProductName(String productName) { this.productName = productName; }

    public String getBrand() { return brand; }
    public void setBrand(String brand) { this.brand = brand; }

    public Integer getStockQuantity() { return stockQuantity; }
    public void setStockQuantity(Integer stockQuantity) { this.stockQuantity = stockQuantity; }

    public String getProductImage() { return productImage; }
    public void setProductImage(String productImage) { this.productImage = productImage; }
}