package com.factoring.task.controller;

import com.factoring.task.dto.OrderDTO;
import com.factoring.task.service.OrderService;
import com.factoring.task.validation.ValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.BindingResult;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("api/orders")
public class OrderController {
    private final OrderService orderService;
    private final ValidationService validationService;
    @Autowired
    public OrderController(OrderService orderService, ValidationService validationService) {
        this.orderService = orderService;
        this.validationService = validationService;
    }
    @PostMapping
    public ResponseEntity<?> createOrder(@Validated @RequestBody OrderDTO orderDTO, BindingResult bindingResult) {
        Map<String, String> errors = validationService.validateOrderDTO(orderDTO, bindingResult); // Validation user input
        if (!errors.isEmpty()) {
            return ResponseEntity.badRequest().body(errors);
        }
        OrderDTO createdOrder = orderService.createOrder(orderDTO);
        return new ResponseEntity<>(createdOrder, HttpStatus.CREATED);
    }
}
