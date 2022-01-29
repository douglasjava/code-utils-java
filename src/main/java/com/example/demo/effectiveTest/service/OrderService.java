package com.example.demo.effectiveTest.service;

import com.example.demo.effectiveTest.dto.Order;
import com.example.demo.effectiveTest.exception.ValidationException;
import com.example.demo.effectiveTest.model.OrderRepresentation;
import com.example.demo.effectiveTest.repository.OrderRepresentationRepository;
import com.example.demo.effectiveTest.validator.OrderValidator;
import lombok.AllArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
public class OrderService {

    private final OrderRepresentationRepository repository;
    private final OrderValidator validator;

    public OrderRepresentation save(Order order) {

        validator.validateNewOrder(order);

        OrderRepresentation orderRepresentation = order.toOrderRepresentation(UUID.randomUUID().toString());

        OrderRepresentation alreadyHasOrder = repository.findByClientName(order.getClientName());

        if (alreadyHasOrder != null) {
            throw new ValidationException("Client already has a order.");
        }

        return repository.save(orderRepresentation);

    }

}