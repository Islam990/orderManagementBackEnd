package com.islamGad.orderManagementBackEnd.services;

import com.islamGad.orderManagementBackEnd.DTO.OrderDto;
import com.islamGad.orderManagementBackEnd.DTO.ProductDTO;
import com.islamGad.orderManagementBackEnd.models.OrderPojo;
import com.islamGad.orderManagementBackEnd.models.Product;
import com.islamGad.orderManagementBackEnd.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {


    private OrderRepository orderRepository;


    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public OrderDto createOrders(OrderDto orderDto) {

        OrderPojo order = new OrderPojo();
        List<Product> productList = new ArrayList<>();
        for (ProductDTO orderItemDto : orderDto.getProductList()) {
            Product product = new Product();
            product.setName(orderItemDto.getName());
            product.setPrice(orderItemDto.getPrice());
            product.setOrder(order);
            product.setQuantity(orderItemDto.getQuantity());
            productList.add(product);
        }
        order.setProductList(productList);
        OrderPojo savedOrder = orderRepository.save(order);
        orderDto.setId(savedOrder.getId());
        return orderDto;
    }

    public List<OrderDto> getOrders() {

        List<OrderPojo> orderDtoList = orderRepository.findAll();

        List<OrderDto> orderDtos = new ArrayList<>();

        for (OrderPojo order : orderDtoList) {
            OrderDto orderDto = new OrderDto();

            orderDto.setId(order.getId());
            orderDto.setDate(order.getDate());
            List<ProductDTO> productDTOList = new ArrayList<>();

            for (Product product : order.getProductList()) {
                ProductDTO productDTO = new ProductDTO();
                productDTO.setId(product.getId());
                productDTO.setName(product.getName());
                productDTO.setPrice(product.getPrice());
                productDTO.setQuantity(product.getQuantity());
                productDTO.setId(product.getId());
                productDTOList.add(productDTO);
            }

            orderDto.setProductList(productDTOList);
            orderDtos.add(orderDto);
        }

        return orderDtos;

    }
}

