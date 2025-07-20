package com.mkr.serviceTests;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

@Order(3)
public class OrderServiceTest {

    @BeforeAll
    static void setup() {
        System.out.println("Tests methods related to Order Service");
    }

    @Test
    void testCreateOrder_whenProductIdIsNull_throwsOrdersServiceException() {

    }
}
