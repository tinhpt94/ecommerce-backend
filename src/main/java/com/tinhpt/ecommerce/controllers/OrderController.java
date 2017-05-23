package com.tinhpt.ecommerce.controllers;

import com.tinhpt.ecommerce.models.OrderRequest;
import com.tinhpt.ecommerce.models.OrderUpdate;
import com.tinhpt.ecommerce.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@CrossOrigin(value = "*", maxAge = 3600, allowCredentials = "true")
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
    public ResponseEntity fetchByDate(@RequestParam("fromDate") @DateTimeFormat(pattern = "dd-MM-yyyy") Date fromDate,
                                      @RequestParam("toDate") @DateTimeFormat(pattern = "dd-MM-yyyy") Date toDate) {
        try {
            return ResponseEntity.ok(orderService.fetchByDate(fromDate, toDate));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @RequestMapping(value = "orders-user",
            method = RequestMethod.GET
    )
    public ResponseEntity fetchByUserId(@RequestParam(value = "userId") int userId) {
        try {
            return ResponseEntity.ok(orderService.fetchByUserId(userId));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @RequestMapping(value = "/orders/{id}",
            method = RequestMethod.GET
    )
    public ResponseEntity fetchById(@PathVariable(value = "id") int id) {
        try {
            return ResponseEntity.ok(orderService.fetchById(id));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @RequestMapping(value = "/orders",
            method = RequestMethod.PUT)
    public ResponseEntity updateOrder(@RequestBody OrderUpdate orderUpdate) {
        try {
            return ResponseEntity.ok(orderService.updateOrder(orderUpdate));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
