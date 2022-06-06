package com.tms.webappshop.mapper;

import com.tms.webappshop.dto.ProductDTO;
import com.tms.webappshop.entity.Product;

public class ProductMapper {

    public static ProductDTO mapToDTO(Product product) {
        return ProductDTO.builder()
                .id(product.getId())
                .nameProduct(product.getNameProduct())
                .price(product.getPrice())
                .availableProduct(product.isAvailableProduct())
                .orderSet(product.getOrderSet())
                .build();
    }

    public static Product mapToEntity(ProductDTO productDTO) {
        return Product.builder()
                .nameProduct(productDTO.getNameProduct())
                .price(productDTO.getPrice())
                .availableProduct(productDTO.isAvailableProduct())
                .orderSet(productDTO.getOrderSet())
                .build();
    }

}
