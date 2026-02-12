package com.ecommerce.Controller;

import com.ecommerce.Product;
import com.ecommerce.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class ProductController {

    @Autowired
    private ProductRepository productRepository;


    @GetMapping("/product")
    public String dashboard(Model model) {
        model.addAttribute("adminSection", "product");
        model.addAttribute("product", new Product());
        model.addAttribute("products", productRepository.findAll());
        return "admin";
    }

    @PostMapping("/product/save")
    public String saveProduct(@ModelAttribute Product product) {
        System.out.println("Saving product: " + product);
        productRepository.save(product);
        return "redirect:/product";
    }
}
