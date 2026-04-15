package com.bai4.bai4.controller;

import com.bai4.bai4.dto.RegisterDTO;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/auth")
public class RegisterController {
    @GetMapping("/register")
    public String form(Model model) {
        model.addAttribute("user", new RegisterDTO());
        return "register-form";
    }

    @PostMapping("/register")
    public String submit(
            @Valid @ModelAttribute("user") RegisterDTO dto,
            BindingResult result,
            Model model
    ) {
        if (result.hasErrors()) {
            return "register-form";
        }

        model.addAttribute("msg", "Đăng ký thành công");
        return "register-form";
    }
}