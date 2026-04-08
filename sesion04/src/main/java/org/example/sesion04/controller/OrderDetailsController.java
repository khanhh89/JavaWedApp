package org.example.sesion04.controller;

import org.example.sesion04.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderDetailsController {
    private  final OrderService orderService;
    @Autowired
    public OrderDetailsController(OrderService orderService){
        this.orderService = orderService;
    }
    @GetMapping("/bai3/orders/{id}")
    public String getOrderDetails(@PathVariable("id") Long id){
        return "chi tiet: " +id;
    }
}
