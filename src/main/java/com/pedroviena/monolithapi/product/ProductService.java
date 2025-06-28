package com.pedroviena.monolithapi.product;
import org.springframework.stereotype.Service;
import com.pedroviena.monolithapi.product.ProductDTOs.ProductCreateDTO;
import com.pedroviena.monolithapi.product.ProductDTOs.ProductResponseDTO;

import java.util.List; // Para usar a interface List
import java.util.stream.Collectors; // Para usar o .collect(Collectors.toList())

public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ProductResponseDTO createProduct(ProductCreateDTO productCreateDTO) {
        Product product = new Product();
        product.setName(productCreateDTO.getName());
        product.setDescription(productCreateDTO.getDescription());
        product.setSku(productCreateDTO.getSku());
        product.setPrice(BigDecimal.valueOf(productCreateDTO.getPrice()));

        Product savedProduct = productRepository.save(product);
        return new ProductResponseDTO(savedProduct.getId(), savedProduct.getName(), savedProduct.getDescription(), savedProduct.getSku(), savedProduct.getPrice().doubleValue());
    }

    public ProductResponseDTO getProductById(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        return new ProductResponseDTO(product.getId(), product.getName(), product.getDescription(), product.getSku(), product.getPrice().doubleValue());
    }

    public ProductResponseDTO getProductBySku(String sku) {
        Product product = productRepository.findBySku(sku)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        return new ProductResponseDTO(product.getId(), product.getName(), product.getDescription(), product.getSku(), product.getPrice().doubleValue());
    }

    public List<ProductResponseDTO> getAllProducts() {
        return productRepository.findAll().stream()
                .map(product -> new ProductResponseDTO(product.getId(), product.getName(), product.getDescription(), product.getSku(), product.getPrice().doubleValue()))
                .collect(Collectors.toList());
    }

    public ProductResponseDTO updateProduct(Long id, ProductCreateDTO productCreateDTO) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        product.setName(productCreateDTO.getName());
        product.setDescription(productCreateDTO.getDescription());
        product.setSku(productCreateDTO.getSku());
        product.setPrice(BigDecimal.valueOf(productCreateDTO.getPrice()));

        Product updatedProduct = productRepository.save(product);
        return new ProductResponseDTO(updatedProduct.getId(), updatedProduct.getName(), updatedProduct.getDescription(), updatedProduct.getSku(), updatedProduct.getPrice().doubleValue());
    }

    public void deleteProduct(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        productRepository.delete(product);
    }

    public List<ProductResponseDTO> searchProducts(String query) {
        return productRepository.findAll().stream()
                .filter(product -> product.getName().toLowerCase().contains(query.toLowerCase()) ||
                                  product.getDescription().toLowerCase().contains(query.toLowerCase()))
                .map(product -> new ProductResponseDTO(product.getId(), product.getName(), product.getDescription(), product.getSku(), product.getPrice().doubleValue()))
                .collect(Collectors.toList());
    }

    public List<ProductResponseDTO> getProductsByPriceRange(Double minPrice, Double maxPrice) {
        return productRepository.findAll().stream()
                .filter(product -> product.getPrice().doubleValue() >= minPrice && product.getPrice().doubleValue() <= maxPrice)
                .map(product -> new ProductResponseDTO(product.getId(), product.getName(), product.getDescription(), product.getSku(), product.getPrice().doubleValue()))
                .collect(Collectors.toList());
    }

}
