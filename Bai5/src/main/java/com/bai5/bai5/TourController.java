package com.bai5.bai5;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/tour")
public class TourController {
    @GetMapping("/create")
    public String showForm(Model model) {
        model.addAttribute("tour", new TourDto());
        return "create-tour";
    }

    @PostMapping("/create")
    public String saveTour(@Valid @ModelAttribute("tour") TourDto tour, BindingResult result) {
        if (result.hasErrors()) {
            return "create-tour";
        }
        return "redirect:/tour/success";
    }
}
