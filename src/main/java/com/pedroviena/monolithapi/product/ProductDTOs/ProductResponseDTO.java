package com.pedroviena.monolithapi.product.ProductDTOs;

public class ProductResponseDTO { 
    private Long id;
    private String name;
    private String description;
    private String sku;
    private Double price;

    public ProductResponseDTO(Long id, String name, String description, String sku, Double price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.sku = sku;
        this.price = price;
    }

    public Long getId() {
        return id;
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
