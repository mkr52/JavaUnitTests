package com.mkr;

import org.junit.jupiter.api.*;

//@TestMethodOrder(MethodOrderer.Random.class) // Random order for test execution
//@TestMethodOrder(MethodOrderer.MethodName.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS) // Default: new instance for each method
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class MethodOrderRandomTests {

    StringBuilder builder = new StringBuilder();

    @AfterEach
    void afterEach() {
        System.out.println("The state of instance after each test: " + builder.toString());
    }

    @Order(1)
    @Test
    void testD() {
        System.out.println("Running test D");
        builder.append("1");
    }

    @Test
    void testA() {
        System.out.println("Running test A");
        builder.append("3");
    }

    @Test
    void testB() {
        System.out.println("Running test B");
        builder.append("4");
    }

    @Order(2)
    @Test
    void testC() {
        System.out.println("Running test C");
        builder.append("2");
    }

}
