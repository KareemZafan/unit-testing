package org.procode.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.procode.app.MyStack;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

public class StackTests {

    private MyStack stack;

    @BeforeEach
    void setUp(){
        stack = new MyStack();
    }

    @Test
    void testPush(){
        stack.push(1);
        stack.push(2);
        stack.push(3);

        assertEquals(3, stack.getSize());
        assertEquals(List.of(1,2,3),stack.getCurrentStack());
    }

    @Test
    void testPop() throws Exception {

        assertThrowsExactly(Exception.class,()->stack.pop());
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(44);
        stack.push(55);

        int value= stack.pop();
        assertEquals(55, value);
        assertEquals(44,stack.getPeek());
        assertEquals(4, stack.getSize());
        assertEquals(List.of(1, 2, 3,44), stack.getCurrentStack());
    }
}
