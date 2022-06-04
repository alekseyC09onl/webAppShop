package com.tms.webappshop.service;

import com.tms.webappshop.dto.OrderDTO;
import com.tms.webappshop.entity.Order;
import com.tms.webappshop.exceptions.OrderException;
import com.tms.webappshop.mapper.OrderMapper;
import com.tms.webappshop.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    public Set<OrderDTO> getOrders() {
        return orderRepository.findAll().stream()
                .map(OrderMapper::mapToDTO)
                .collect(Collectors.toSet());
    }

    public OrderDTO createOrder(OrderDTO orderDTO) {
        orderRepository.save(OrderMapper.mapToEntity(orderDTO));
        return orderDTO;
    }

    public OrderDTO updateOrder(Integer id, OrderDTO orderDTO) throws OrderException {
        if (orderRepository.findById(id).isPresent()) {
            Order order = OrderMapper.mapToEntity(orderDTO);
            order.setId(id);
            orderRepository.save(order);
            return OrderMapper.mapToDTO(order);
        } else {
            throw new OrderException(("Order with id: " + id + " was not found"));
        }
    }

    public void deleteOrder(Integer id) throws OrderException {
        if (orderRepository.findById(id).isPresent()) {
//            Order order = orderRepository.getById(id);
            orderRepository.deleteById(id);
//            return OrderMapper.mapToDTO(order);
        } else {
            throw new OrderException(("Order with id: " + id + " was not found"));
        }
    }

    public OrderDTO getOrderById(Integer id) throws OrderException {
        if (orderRepository.findById(id).isPresent()) {
            return OrderMapper.mapToDTO(orderRepository.getById(id));
        } else {
            throw new OrderException(("Order with id: " + id + " was not found"));
        }
    }
}
