package com.example.api_kokostore.application.controller;


import com.example.api_kokostore.application.dto.order.DetailOrderRequest;
import com.example.api_kokostore.application.service.OrderService;
import com.example.api_kokostore.domain.entities.OrderEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {


    @Autowired
    private OrderService orderService;


    @PostMapping("/create")
    public OrderEntity generateOrder(@RequestBody DetailOrderRequest request) {
        return orderService.createDetailOrder(request);
    }
}
