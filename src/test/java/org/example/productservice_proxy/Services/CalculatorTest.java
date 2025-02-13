package org.example.productservice_proxy.Services;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void Test_addTwoInteger_ReturnInteger() {
        Calculator calculator = new Calculator();
        int result = calculator.add(1, 2);
        assertEquals(3, result);
    }
    @Test
    void Test_DividebyZero_ReturnInteger() {
        Calculator calculator = new Calculator();
       assertThrows(ArithmeticException.class, () -> calculator.divide(1, 0));
    }
}