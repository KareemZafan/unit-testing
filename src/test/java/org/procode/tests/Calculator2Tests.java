package org.procode.tests;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.EnabledForJreRange;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.JRE;
import org.junit.jupiter.api.condition.OS;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.procode.app.Calculator;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

@Execution(ExecutionMode.CONCURRENT)
public class Calculator2Tests {

    private static Calculator calculator;

    /*@BeforeEach
    void beforeEachTestCase() {
        calculator = new Calculator();
        System.out.println("Before Each test");
    }*/
    @BeforeAll
    static void beforeAll() {
        calculator = new Calculator();
        System.out.println("Before Class will run 1 time");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("After class will run 1 time");
    }

    @Tag("Apr")
    @DisplayName("ABC-1122 Addition Feature")
    void testAdd(double x , double y) {
        // Assertions
        assertEquals(12, calculator.add(6,6));
    }

    @Tag("Apr")
    @DisplayName("Subtraction Feature")
    @Test
    void testSub() {
        // Assertions
        assertEquals(0, calculator.sub(6, 6));
        assertEquals(12, calculator.sub(6, -6));
        assertNotNull(calculator);
    }

    @Tag("Apr")
    @Test
    @Timeout(value = 2,unit = TimeUnit.MICROSECONDS)
    void testMul() {
        // Assertions
        assertEquals(36, calculator.mul(6, 6));
    }

   // @EnabledForJreRange(min = JRE.JAVA_8, max = JRE.JAVA_15)
    @Test
    void testDiv() {
        // Assertions
        assertEquals(12, calculator.div(48, 4));
        assertEquals(-16, calculator.div(48, -3));

        Exception ex = assertThrowsExactly(ArithmeticException.class, () -> calculator.div(1, 0));

        assertEquals("Can not divide by zero", ex.getMessage());

    }

   /* @AfterEach
    void afterEachTestCase(){
        System.out.println("Close each resource");
    }*/

   // @EnabledOnOs(value = OS.WINDOWS)
    @Test
    void testSquareRoot() {
        assertEquals(3, calculator.squareRoot(9));
    }
}
