package com.tms.webappshop.restControllers;

import com.tms.webappshop.dto.OrderDTO;
import com.tms.webappshop.exceptions.OrderException;
import com.tms.webappshop.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class OrderRestController {

    private final OrderService orderService;

    @GetMapping("/orders")
    public Set<OrderDTO> getOrders() {
        return orderService.getOrders();
    }

    @PostMapping("/orders")
    public OrderDTO createOrder(@RequestBody OrderDTO orderDTO) {
        return orderService.createOrder(orderDTO);
    }

    @PutMapping("/orders/{id}")
    public OrderDTO updateOrder(@PathVariable("id") Integer id, @RequestBody OrderDTO orderDTO) throws OrderException {
        return orderService.updateOrder(id, orderDTO);
    }

    @DeleteMapping("/orders/{id}")
    public void deleteOrder(@PathVariable("id") Integer id) throws OrderException {
        orderService.deleteOrder(id);
    }

    @GetMapping("/orders/{id}")
    public OrderDTO getOrderById(@PathVariable("id") Integer id) throws OrderException {
        return orderService.getOrderById(id);
    }
}
