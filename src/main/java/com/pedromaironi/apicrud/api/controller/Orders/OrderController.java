package com.pedromaironi.apicrud.api.controller.Orders;

import com.pedromaironi.apicrud.api.repository.OrderRepository;
import com.pedromaironi.apicrud.model.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @GetMapping("/getOrders")
    public List<Orders> getOrders() {
        return orderRepository.findAll();
    }

    @PostMapping("/create")
    public ResponseEntity<Orders> createOrder(@RequestBody Orders order) {
        try {
            Orders newOrder = orderRepository.save(order);
            return new ResponseEntity<>(newOrder, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
