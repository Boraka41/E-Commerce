package com.example.e_commerce.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.e_commerce.entity.User;
import com.example.e_commerce.service.UserService;
import jakarta.validation.Valid;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;
import java.util.Optional;

@Controller
public class ProfileController {

    private final UserService userService;

    public ProfileController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/profile")
    public String showProfile(@AuthenticationPrincipal UserDetails currentUser, Model model) {
        String username = currentUser.getUsername();
        Optional<User> user = userService.findByUsername(username);
        model.addAttribute("user", user);
        return "profile";
    }

    @PostMapping("/update-profile")
    public String updateProfile(@ModelAttribute("user") User updatedUser, Principal principal) {
        String username = principal.getName();
        Optional<User> existingUserOpt = userService.findByUsername(username);
        if (existingUserOpt.isEmpty()) {
            return "redirect:/login?error";
        }

        User existingUser = existingUserOpt.get();
        Long userId = existingUser.getId();

        userService.updateOneUser(userId, updatedUser);

        return "redirect:/profile";

    }


}
