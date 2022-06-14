package com.tms.webappshop.dto;

import com.tms.webappshop.entity.Order;
import lombok.*;
import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.UniqueElements;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductDTO {

    private Integer id;

    @NotEmpty(message = "Product name should not be empty")
    private String nameProduct;

    @Min(value = 0, message = "Price should no be less 0")
    private BigDecimal price;

    private boolean availableProduct;

    private Set<Order> orderSet;
}
