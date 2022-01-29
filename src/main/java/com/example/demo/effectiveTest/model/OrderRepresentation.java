package com.example.demo.effectiveTest.model;

import com.example.demo.effectiveTest.dto.Item;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class OrderRepresentation {

    private final String id;
    private final String clientName;
    private final String deliveryAddress;
    private final List<Item> items;

}
