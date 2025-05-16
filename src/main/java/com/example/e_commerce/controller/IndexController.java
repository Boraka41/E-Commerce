package com.example.e_commerce.controller;

import com.example.e_commerce.entity.Product;
import com.example.e_commerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class IndexController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/index")
    public ModelAndView index() {
        List<String> categories = productRepository.findDistinctCategories();

        ModelAndView modelAndView = new ModelAndView("index");  // "index" view'ını kullan
        modelAndView.addObject("categories", categories);  // Kategorileri modele ekle
        return modelAndView;
    }

    @GetMapping("/products")
    public ModelAndView getProductsByCategory(@RequestParam("category") String category) {
        List<Product> products = productRepository.findByCategory(category);

        ModelAndView modelAndView = new ModelAndView("products");  // "products" view'ını kullan
        modelAndView.addObject("category", category);  // Kategoriyi modele ekle
        modelAndView.addObject("products", products); // Ürünleri modele ekle
        return modelAndView;
    }

    @GetMapping("/login")
    public ModelAndView login(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }

    @GetMapping("/checkout")
    public ModelAndView checkout(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("checkout");
        return modelAndView;
    }

}
