package com.pedroviena.monolithapi.product.ProductDTOs;

public class ProductCreateDTO { 
    private String name;
    private String description;
    private String sku;
    private Double price;

    public ProductCreateDTO(String name, String description, String sku, Double price) {
        this.name = name;
        this.description = description;
        this.sku = sku;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getSku() {
        return sku;
    }

    public Double getPrice() {
        return price;
    }
    
}
