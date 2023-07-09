package com.islamGad.orderManagementBackEnd.controllers;

import com.islamGad.orderManagementBackEnd.DTO.OrderDto;
import com.islamGad.orderManagementBackEnd.ProductListDuplicationException;
import com.islamGad.orderManagementBackEnd.services.OrderService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("getOrders")
    public ResponseEntity<List<OrderDto>> getAllOrders() {
        return ResponseEntity.ok(orderService.getOrders());
    }

    @PostMapping("createOrder")
    public ResponseEntity<OrderDto> getOrders(@Valid @RequestBody OrderDto orderDto) {

        // Handle each product should exist one time in the order
        int distinctSize = orderDto.getProductList().stream().collect(Collectors.groupingBy(product -> product.getName())).size();
        if (distinctSize != orderDto.getProductList().size()) {
            throw new ProductListDuplicationException("Each product should exist one time in the order");
        }

        orderService.createOrders(orderDto);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().build().toUri();
        return ResponseEntity.created(location).build();
    }

}
