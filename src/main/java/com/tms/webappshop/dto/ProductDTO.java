package com.tms.webappshop.dto;

import com.tms.webappshop.entity.Order;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductDTO {

    private Integer id;

    private String nameProduct;

    private Double price;

    private boolean availableProduct;

    private Set<Order> orderSet;
}
