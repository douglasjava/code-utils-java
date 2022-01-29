package com.example.demo.effectiveTest.repository;

import com.example.demo.effectiveTest.model.OrderRepresentation;

public interface OrderRepresentationRepository {

    OrderRepresentation save(OrderRepresentation orderRepresentation);

    OrderRepresentation findByClientName(String clientName);

}
