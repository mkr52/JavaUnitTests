package com.mkr.serviceTests;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

@Order(2)
public class ProductServiceTest {

    @BeforeAll
    static void setup() {
        System.out.println("Tests methods related to Product Service");
    }

    @Test
    void testCreateProduct_whenProductNameIsNull_throwsProductServiceException() {

    }
}
