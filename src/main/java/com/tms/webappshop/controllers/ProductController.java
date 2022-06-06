package com.tms.webappshop.controllers;

import com.tms.webappshop.dto.ProductDTO;
import com.tms.webappshop.exceptions.ProductException;
import com.tms.webappshop.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

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

    @GetMapping("/products/{id}")
    public String getProductById(@PathVariable("id") Integer id, Model model) throws ProductException {
        model.addAttribute("productDTO", productService.getProductById(id));
        return "current_product";
    }

    @PostMapping("/admin/products")
    public String createProduct(@ModelAttribute("productDTO") ProductDTO productDTO
            /*@RequestParam("nameProduct") String nameProduct,
            @RequestParam("price") Double price,
            @RequestParam("available") boolean available,
            Model model*/) {

//        ProductDTO productDTO = ProductDTO.builder()
//                .nameProduct(nameProduct)
//                .price(price)
//                .availableProduct(available)
//                .build();
        productService.createProduct(productDTO);
        return "redirect:/api/v2/admin/products";
    }

    @PutMapping("/admin/products/{id}")
    public String updateProduct(@PathVariable("id") Integer id, Model model) throws ProductException {

        return productService.updateProduct(productDTO);
    }

    @DeleteMapping("/admin/products/{id}")
    public void deleteProduct(@PathVariable("id") Integer id) throws ProductException {
        productService.deleteProduct(id);
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

    @GetMapping("/admin/products/update")
    public String redirectUpdateMethod() {
        return "admin_update_product";
    }

    @GetMapping("/admin/products/delete")
    public String redirectDeleteMethod() {
        return "admin_delete_product";
    }

}
