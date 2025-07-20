package com.mkr;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

//@TestMethodOrder(MethodOrderer.Random.class) // Random order for test execution
//@TestMethodOrder(MethodOrderer.MethodName.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class MethodOrderRandomTests {

    @Order(1)
    @Test
    void testD() {
        System.out.println("Running test D");
    }

    @Test
    void testA() {
        System.out.println("Running test A");
    }

    @Test
    void testB() {
        System.out.println("Running test B");
    }

    @Order(2)
    @Test
    void testC() {
        System.out.println("Running test C");
    }

}
