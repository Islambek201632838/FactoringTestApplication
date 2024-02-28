package com.factoring.task.validation;

import com.factoring.task.dto.OrderDTO;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Service
public class ValidationService {

    public Map<String, String> validateOrderDTO(OrderDTO orderDTO, BindingResult bindingResult) {
        Map<String, String> errors = new HashMap<>();

        // Validate product name
        if (orderDTO.getProductName() == null || orderDTO.getProductName().isEmpty()) {
            errors.put("productName", "Product name is required");
        }

        // Validate product count
        if (orderDTO.getProductCount() <= 0) {
            errors.put("productCount", "Product count must be greater than 0");
        }

        // Validate price
        if (orderDTO.getPrice() == null || orderDTO.getPrice().compareTo(BigDecimal.ZERO) <= 0) {
            errors.put("price", "Price must be greater than 0");
        }

        // Add server-side validation errors if any
        if (bindingResult.hasErrors()) {
            for (FieldError error : bindingResult.getFieldErrors()) {
                errors.put(error.getField(), error.getDefaultMessage());
            }
        }

        return errors;
    }
}
