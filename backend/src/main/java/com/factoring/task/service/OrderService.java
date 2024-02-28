package com.factoring.task.service;

import com.factoring.task.dto.OrderDTO;
import com.factoring.task.entity.Order;
import com.factoring.task.repository.OrderRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;
    private final ModelMapper modelMapper = new ModelMapper();


    public OrderDTO createOrder(OrderDTO orderDTO) {
        Order order = modelMapper.map(orderDTO, Order.class);
        Order savedOrder = orderRepository.save(order);
        return modelMapper.map(savedOrder, OrderDTO.class);
    }

    public OrderDTO getOrderById(int id) {
        return orderRepository.findById(id)
                .map(order -> modelMapper.map(order, OrderDTO.class))
                .orElse(null);
    }

    public OrderDTO updateOrder(OrderDTO orderDTO) {
        Order order = modelMapper.map(orderDTO, Order.class);
        Order updatedOrder = orderRepository.save(order);
        return modelMapper.map(updatedOrder, OrderDTO.class);
    }

    public List<OrderDTO> getAllOrders() {
        return orderRepository.findAll().stream()
                .map(order -> modelMapper.map(order, OrderDTO.class))
                .collect(Collectors.toList());
    }

    public void deleteOrder(int id) {
        orderRepository.deleteById(id);
    }
}
