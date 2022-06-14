package com.tms.webappshop.service;

import com.tms.webappshop.dto.ProductDTO;
import com.tms.webappshop.entity.Product;
import com.tms.webappshop.exceptions.ProductException;
import com.tms.webappshop.mapper.ProductMapper;
import com.tms.webappshop.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public List<ProductDTO> getProducts() {
        return productRepository.findAll().stream()
                .map(ProductMapper::mapToDTO)
                .sorted((o1, o2) -> o2.getId().compareTo(o1.getId()))
                .collect(Collectors.toList());
    }

    public ProductDTO createProduct(ProductDTO productDTO) throws ProductException {
        if (productRepository.findProductByNameProduct(productDTO.getNameProduct()).isPresent()) {
            throw new ProductException("Product with name: " + productDTO.getNameProduct() + " is already exist");
        }
        productRepository.save(ProductMapper.mapToEntity(productDTO));
        return productDTO;
    }

    public ProductDTO updateProduct(ProductDTO productDTO) throws ProductException {
        if (productRepository.findById(productDTO.getId()).isPresent()) {
            if (productRepository.findProductByNameProduct(productDTO.getNameProduct()).isPresent()) {
                throw new ProductException("Product with name: " + productDTO.getNameProduct() + " is already exist");
            }
            Product product = ProductMapper.mapToEntity(productDTO);
            product.setId(productDTO.getId());
            productRepository.save(product);
            return ProductMapper.mapToDTO(product);
        } else {
            throw new ProductException(("Product with id: " + productDTO.getId() + " was not found"));
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
