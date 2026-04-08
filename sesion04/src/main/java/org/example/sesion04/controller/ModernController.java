package org.example.sesion04.controller;

import org.example.sesion04.service.OrderService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/modern")
public class ModernController {
    private final OrderService orderService;
    public  ModernController(OrderService orderService) {
        this.orderService = orderService;
    }
    @RequestMapping
    public String getAll(){
        return orderService.getAllOrders();
    }
    @GetMapping("/{id}")
    public String getOrderById(@PathVariable Long id){
        return orderService.getOrderById(id);
    }
    @PostMapping
    public String create() {
        return "Tao don hang thanh cong";   
    }
    // bài 2
    @GetMapping("/bai2/menu")
    public String getMenu(@RequestParam(name = "category", required = false,defaultValue = "chay")String category){
        return "thuc don: " + category.toUpperCase();
    }
}
