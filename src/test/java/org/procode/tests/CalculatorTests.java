package org.procode.tests;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.EnabledForJreRange;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.JRE;
import org.junit.jupiter.api.condition.OS;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.procode.app.Calculator;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@Execution(ExecutionMode.CONCURRENT)
public class CalculatorTests {

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
    @ParameterizedTest
    @CsvFileSource(resources = "/testData.csv", numLinesToSkip = 1 )
    @Order(3)
    void testAdd(String x , String y, String s) {
       assertEquals(Double.parseDouble(s),calculator.add(Double.parseDouble(x),Double.parseDouble(y)));
    }

    @Tag("Apr")
    @DisplayName("Subtraction Feature")
    @Test
    @Order(1)
    void testSub() {
        // Assertions
        assertEquals(0, calculator.sub(6, 6));
        assertEquals(12, calculator.sub(6, -6));
        assertNotNull(calculator);
    }

    @Tag("Apr")
    @Order(4)
    @RepeatedTest(4)
    void testMul() {
        // Assertions
        assertEquals(36, calculator.mul(6, 6));
    }

   /* @AfterEach
    void afterEachTestCase(){
        System.out.println("Close each resource");
    }*/

    @EnabledOnOs(value = OS.WINDOWS)
    @Test
    void testSquareRoot() {
        assertEquals(3, calculator.squareRoot(9));
    }
}
