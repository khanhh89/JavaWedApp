package org.example.sesion04.repository;

import org.springframework.stereotype.Repository;

@Repository
public class OrderRepository {
    public String getAllOrder(){
        return "Lay toan bo don hang";
    }
    public String getOrderById(Long id){
        return "Thong tin don hang: "+id;
    }
}
