package com.ecommerce.controller;

import com.ecommerce.model.Product;
import com.ecommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;


@Controller
public class ProductController {

    @Autowired
    private ProductRepository productRepository;


    @GetMapping("/product")
    public String product(Model model) {
        if(model.containsAttribute("adminSection")){
            model.addAttribute("adminSection", model.getAttribute("adminSection"));
        }else {
            model.addAttribute("adminSection", "product");
        }
        if (model.containsAttribute("product")){
            model.addAttribute("product", model.getAttribute("product"));
        }else {
            model.addAttribute("product", new Product());
        }
        model.addAttribute("products", productRepository.findAll());
        return "admin";
    }

    @PostMapping("/product/save")
    public String saveProduct(@ModelAttribute Product product) {
        System.out.println("Saving product: " + product);
        productRepository.save(product);
        return "redirect:/product";
    }

    @GetMapping("/product/edit/{id}")
    public String editProduct(@PathVariable long id, RedirectAttributes redirectAttributes){
        System.out.println("Editing product with ID: " + id);
        Optional<Product> product = productRepository.findById(id);
        if (product.isPresent()){
            System.out.println("Product found: " + product.get());
            redirectAttributes.addFlashAttribute("product", product.get());
        } else {
            System.out.println("Product not found with ID: " + id);
        }
        return "redirect:/product";
    }

    @GetMapping("/product/delete/{id}")
    public String deleteProduct(@PathVariable long id, RedirectAttributes redirectAttributes){
        System.out.println("Deleting product with ID: " + id);
        Optional<Product> product = productRepository.findById(id);
        if (product.isPresent()){
            redirectAttributes.addFlashAttribute("product", product.get());
            redirectAttributes.addFlashAttribute("adminSection", "productDelete");
        }else {
            System.out.println("Product not found with ID: " + id);
        }return "redirect:/product";
    }

    @GetMapping("/product/delete/confirmation/{id}")
    public String confirmDeleteProduct(@PathVariable long id){
        System.out.println("Confirming deletion of product with ID: " + id);
        productRepository.deleteById(id);
        return "redirect:/product";
    }

}
