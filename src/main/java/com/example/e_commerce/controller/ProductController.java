package com.example.e_commerce.controller;

import com.example.e_commerce.entity.Product;
import com.example.e_commerce.repository.ProductRepository;
import com.example.e_commerce.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductController {

    private ProductService productService;
    private ProductRepository productRepository;

    public ProductController(ProductService productService, ProductRepository productRepository) {
        this.productService = productService;
        this.productRepository= productRepository;
    }

    @GetMapping("/{productId}")
    public Optional<Product> getOneProduct(@PathVariable Long productId){
        return productService.getOneProduct(productId);
    }

    @PostMapping
    public Product createOneProduct(@RequestBody Product newProduct){
        return productService.createOneProduct(newProduct);
    }

    @PutMapping("/{productId}")
    public Product updateOneProduct(@PathVariable Long productId, @RequestBody Product updatedProduct){
        return productService.updateOneProduct(productId,updatedProduct);
    }

    @DeleteMapping("/{productId}")
    public void deleteOneProduct(@PathVariable Long productId){
        productService.deleteOneProduct(productId);
    }
}
