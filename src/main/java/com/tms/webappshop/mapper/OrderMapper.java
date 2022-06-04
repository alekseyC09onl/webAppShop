package com.tms.webappshop.mapper;

import com.tms.webappshop.dto.OrderDTO;
import com.tms.webappshop.entity.Order;

public class OrderMapper {

    public static OrderDTO mapToDTO(Order order) {
        return OrderDTO.builder()
                .orderNumber(order.getOrderNumber())
                .productSet(order.getProductSet())
                .build();
    }

    public static Order mapToEntity(OrderDTO orderDTO) {
        return Order.builder()
                .orderNumber(orderDTO.getOrderNumber())
                .productSet(orderDTO.getProductSet())
                .build();
    }
}
