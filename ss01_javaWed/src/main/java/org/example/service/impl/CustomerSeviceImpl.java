package org.example.service.impl;

import org.example.service.CustomerService;
import org.example.service.OrderSevice;

public class CustomerSeviceImpl implements CustomerService {
    //Tiêm sự phụ thuộc
    final private OrderSevice orderSevice;   //field
    // cách tiêm DI - 3
    //1. Constructer
    public CustomerSeviceImpl(OrderSevice orderSevice) {
        this.orderSevice = orderSevice;
    }
    //2. Setter
    public void setOrderSevice(OrderSevice orderSevice) {
//        this.orderSevice = orderSevice;
    }

    //3. Field

    @Override
    public void eat() {

    }

    @Override
    public void sleep() {
        System.out.println("Dang ngu de thu gian");
    }
}
