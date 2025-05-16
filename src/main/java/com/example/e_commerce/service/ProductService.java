package com.example.e_commerce.service;

import com.example.e_commerce.entity.Product;
import com.example.e_commerce.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
         return productRepository.findAll();
    }

    public Optional<Product> getOneProduct(Long productId) {
        return productRepository.findById(productId);
    }

    public Product createOneProduct(Product newProduct) {
        return productRepository.save(newProduct);
    }

    public Product updateOneProduct(Long productId, Product updatedProduct) {
        Optional<Product> product = productRepository.findById(productId);
        if(product.isPresent()){
            Product foundProduct = product.get();
            foundProduct.setProductName(updatedProduct.getProductName());
            foundProduct.setCategory(updatedProduct.getCategory());
            foundProduct.setImage(updatedProduct.getImage());
            foundProduct.setPrice(updatedProduct.getPrice());
            productRepository.save(foundProduct);
            return foundProduct;
        }
        else
            return null;
    }

    public void deleteOneProduct(Long productId) {
        productRepository.deleteById(productId);
    }
}
