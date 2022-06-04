package com.tms.webappshop.service;

import com.tms.webappshop.dto.ProductDTO;
import com.tms.webappshop.entity.Product;
import com.tms.webappshop.exceptions.ProductException;
import com.tms.webappshop.mapper.ProductMapper;
import com.tms.webappshop.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public Set<ProductDTO> getProducts() {
        return productRepository.findAll().stream()
                .map(ProductMapper::mapToDTO)
                .collect(Collectors.toSet());
    }

    public ProductDTO createProduct(ProductDTO productDTO) {
        productRepository.save(ProductMapper.mapToEntity(productDTO));
        return productDTO;
    }

    public ProductDTO updateProduct(Integer id, ProductDTO productDTO) throws ProductException {
        if (productRepository.findById(id).isPresent()) {
            Product product = ProductMapper.mapToEntity(productDTO);
            product.setId(id);
            productRepository.save(product);
            return ProductMapper.mapToDTO(product);
        } else {
            throw new ProductException(("Product with id: " + id + " was not found"));
        }
    }

    public void deleteProduct(Integer id) throws ProductException {
        if (productRepository.findById(id).isPresent()) {
//            Product product = productRepository.getById(id);
            productRepository.deleteById(id);
//            return ProductMapper.mapToDTO(product);
        } else {
            throw new ProductException(("Product with id: " + id + " was not found"));
        }
    }

    public ProductDTO getProductById(Integer id) throws ProductException {
        if (productRepository.findById(id).isPresent()) {
            return ProductMapper.mapToDTO(productRepository.getById(id));
        } else {
            throw new ProductException(("Product with id: " + id + " was not found"));
        }
    }
}
