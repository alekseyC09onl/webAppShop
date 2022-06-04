package com.tms.webappshop.dto;

import com.tms.webappshop.entity.Product;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderDTO {

    private String orderNumber;

    private Set<Product> productSet;
}
