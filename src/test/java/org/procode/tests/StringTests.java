package org.procode.tests;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.platform.commons.util.StringUtils;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringTests {

    @ParameterizedTest
   // @ValueSource(strings = {"radar","12321","level", "maram"})
    @MethodSource("getPalindromeString")
    void testPalindromeStrings(String input){
       assertEquals(input, new StringBuilder(input).reverse().toString());
    }

    private static Stream<String> getPalindromeString(){
        return Stream.of("radar","12321","level","maram");
    }






}
