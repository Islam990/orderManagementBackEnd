package com.islamGad.orderManagementBackEnd.controllers;

import com.islamGad.orderManagementBackEnd.DTO.OrderDto;
import com.islamGad.orderManagementBackEnd.services.OrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("getOrders")
    public List<OrderDto> getAllOrders(){
        return orderService.getOrders();
    }

    @PostMapping("createOrder")
    public OrderDto getOrders(@RequestBody OrderDto orderDto){
        return orderService.createOrders(orderDto);
    }

}
