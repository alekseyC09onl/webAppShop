package com.tms.webappshop.controllers;

import com.tms.webappshop.dto.ProductDTO;
import com.tms.webappshop.exceptions.ProductException;
import com.tms.webappshop.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/v2")
public class ProductController {

    private final ProductService productService;

    @GetMapping("/products")
    public String getListProduct(Model model) {
        model.addAttribute("productList", productService.getProducts());
        return "products";
    }

    @PostMapping("/admin/products")
    public String createProduct(@ModelAttribute("productDTO") @Valid ProductDTO productDTO, BindingResult bindingResult) throws ProductException {
        if (bindingResult.hasErrors()) {
            return "admin_add_product";
        }
        productService.createProduct(productDTO);
        return "redirect:/api/v2/admin/products";
    }

    @PutMapping("/admin/products/{id}")
    public String updateProduct(@ModelAttribute("productDTO") @Valid ProductDTO productDTO,
                                BindingResult bindingResult) throws ProductException {

        if (bindingResult.hasErrors()) {
            return "admin_update_product";
        }
        productService.updateProduct(productDTO);
        return "redirect:/api/v2/admin/products";
    }

    @DeleteMapping("/admin/products/{id}")
    public String deleteProduct(@PathVariable("id") Integer id) throws ProductException {
        productService.deleteProduct(id);
        return "redirect:/api/v2/admin/products";
    }

    @GetMapping("/admin/products")
    public String getListProductAdmin(Model model) {
        model.addAttribute("productList", productService.getProducts());
        return "admin_products";
    }

    @GetMapping("/admin/products/new")
    public String redirectAddMethod(Model model) {
        model.addAttribute("productDTO", ProductDTO.builder().build());
        return "admin_add_product";
    }

    @GetMapping("/admin/products/update/{id}")
    public String redirectUpdateMethod(@PathVariable("id") Integer id, Model model) throws ProductException {
        model.addAttribute("productDTO", productService.getProductById(id));
        return "admin_update_product";
    }

}
