package com.mkr;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Test Math Operators for Calculator class")
class CalculatorTest {

    Calculator calculator;

    /**
     * Naming Convention:
     * test<System Under Test>_<Condition Or State Change>_<ExpectedResult>
     *
     */

    @BeforeAll
    static void setup() {
        System.out.println("Execute before all tests");
    }

    @AfterAll
    static void cleanup() {
        System.out.println("Execute after all tests");
    }

    @BeforeEach
    void init() {
        calculator = new Calculator();
        System.out.println("Executed before each test");
    }

    @AfterEach
    void tearDown() {
        System.out.println("Executed after each test");
    }

    @DisplayName("Test Integer Division") // Override the class-level display name and method name for this test
//    @Test
    @ParameterizedTest
//    @MethodSource()
//    @CsvSource( {
//            "10, 5, 2",
//            "12, 4, 3"
//    })
    @CsvFileSource(resources = "/integerDivision.csv")
    void testIntegerDivision_WhenDividendIsDividedByDivisor_ShouldReturnSuccess(int dividend, int divisor, int expectedResult) {
        // AAA - Arrange, Act, Assert
        // Arrange
//        Calculator calculator = new Calculator();
//        int dividend = 10;
//        int divisor = 5;
//        int expectedResult = 2;

        System.out.println("Integer Division Test: " + dividend + " / " + divisor + " = " + expectedResult);

        // Act
        int result = calculator.integerDivision(dividend, divisor);

        // Test with positive integers
        // Assert
        assertEquals(expectedResult, result);

        // Act and Assert
        assertEquals(3, calculator.integerDivision(9, 3), "9 divided by 3 should equal 3");

        // Conditional fail
//        fail("This test is intentionally failing to demonstrate the fail method.");
//
//        // Test with negative integers
//        assertEquals(-2, calculator.integerDivision(-10, 5));
//        assertEquals(-3, calculator.integerDivision(9, -3));
//
//        // Test with zero
//        assertEquals(0, calculator.integerDivision(0, 5));
//
//        // Test division by one
//        assertEquals(10, calculator.integerDivision(10, 1));
    }

    static Stream<Arguments> testIntegerDivision_WhenDividendIsDividedByDivisor_ShouldReturnSuccess() {
        return Stream.of(
                Arguments.of(10, 5, 2),
                Arguments.of(9, 3, 3),
                Arguments.of(20, 4, 5),
                Arguments.of(15, 3, 5)
        );
    }

//    @Disabled
    @DisplayName("Division by Zero Exception")
    @Test
    void testIntegerDivision_WhenDivisorIsZero_ShouldThrowArithmeticException() {
//        Calculator calculator = new Calculator();

        // Test division by zero
        ArithmeticException exception = assertThrows(ArithmeticException.class, () -> {
            calculator.integerDivision(10, 0);
        });

        // Verify the exception message
        assertEquals("/ by zero", exception.getMessage(), "Expected division by zero exception message");
    }


    @Test
    void testIntegerSubtraction_WhenMinuendIsSubtractedFromSubtrahend_ShouldReturnSuccess() {
//        Calculator calculator = new Calculator();

        // Test with positive integers
        assertEquals(5, calculator.integerSubtraction(10, 5));
        assertEquals(6, calculator.integerSubtraction(9, 3), "9 minus 3 should equal 6");

        assertEquals(28, calculator.integerSubtraction(30, 2),
                ()->"Result is not as expected"); // this lambda is only lazily evaluated if the assertion fails

        // Conditional fail
//        fail("This test is intentionally failing to demonstrate the fail method.");
    }

}