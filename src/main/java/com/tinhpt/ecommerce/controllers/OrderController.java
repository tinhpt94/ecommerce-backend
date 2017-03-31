package com.tinhpt.ecommerce.controllers;

import com.tinhpt.ecommerce.models.OrderRequest;
import com.tinhpt.ecommerce.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @RequestMapping(
            value = "orders",
            method = RequestMethod.POST
    )
    public ResponseEntity create(@RequestBody OrderRequest order) {
        int orderID;
        try {
            orderID = orderService.create(order);
        } catch (Exception e) {
            return ResponseEntity.status(400).body("");
        }
        ;
        return ResponseEntity.status(201).body(orderID);
    }

    @RequestMapping(value = "orders",
            method = RequestMethod.GET
    )
    public ResponseEntity fetchAll() {
        try {
            return ResponseEntity.ok(orderService.fetchAll());
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @RequestMapping(value = "/orders/{id}",
            method = RequestMethod.GET
    )
    public ResponseEntity fetchAll(@PathVariable(value = "id") int id) {
        try {
            return ResponseEntity.ok(orderService.fetchById(id));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
