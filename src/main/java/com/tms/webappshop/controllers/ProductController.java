package com.tms.webappshop.controllers;

import com.tms.webappshop.dto.ProductDTO;
import com.tms.webappshop.exceptions.ProductException;
import com.tms.webappshop.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class ProductController {

    private final ProductService productService;

    @GetMapping("/products")
    public Set<ProductDTO> getProducts() {
        return productService.getProducts();
    }

    @PostMapping("/products")
    public ProductDTO createProduct(@RequestBody ProductDTO productDTO) {
        return productService.createProduct(productDTO);
    }

    @PutMapping("/products/{id}")
    public ProductDTO updateProduct(@PathVariable("id") Integer id, @RequestBody ProductDTO productDTO) throws ProductException {
        return productService.updateProduct(id, productDTO);
    }

    @DeleteMapping("/products/{id}")
    public void deleteProduct(@PathVariable("id") Integer id) throws ProductException {
        productService.deleteProduct(id);
    }

    @GetMapping("/products/{id}")
    public ProductDTO getProductById(@PathVariable("id") Integer id) throws ProductException {
        return productService.getProductById(id);
    }

}
