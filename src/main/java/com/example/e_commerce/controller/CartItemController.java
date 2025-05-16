package com.example.e_commerce.controller;

import com.example.e_commerce.entity.Cart;
import com.example.e_commerce.entity.CartItem;
import com.example.e_commerce.repository.CartRepository;
import com.example.e_commerce.request.CartItemRequest;
import com.example.e_commerce.service.CartItemService;
import com.example.e_commerce.service.UserService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.example.e_commerce.entity.User;

import java.security.Principal;

@Controller
@RequestMapping("/cart-item")
public class CartItemController {

    private final CartItemService cartItemService;

    public CartItemController(CartItemService cartItemService) {
        this.cartItemService = cartItemService;
    }

    @PostMapping("/add")
    public String addProductToCart(@RequestParam Long productId,
                                   @RequestParam Integer quantity,
                                   Principal principal) {
        String username = principal.getName();
        cartItemService.addProductToCartByUsername(username, productId, quantity);

        return "redirect:/cart";
    }





}
