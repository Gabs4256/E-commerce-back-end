package com.ecommerce.controller;


import com.ecommerce.enums.Category;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(Model model, @RequestParam(required = false) Category category) {
        model.addAttribute("title", "Loja Online");
        model.addAttribute("categories", Category.values());
        model.addAttribute("categoriesFilter", category != null ? category : "ALL");
        return "index";
    }
}
