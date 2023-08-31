package stack.queue;
import org.junit.jupiter.api.Test;
import stack.queue.stack.Stack;

import static org.junit.jupiter.api.Assertions.*;
public class StackTest {
    @Test
    void givenStackTestWhetherItPopsOrPush() {
        Stack<Integer> stack = new Stack<>();
        stack.push(150);
        stack.push(15);
        stack.push(1);

        assertEquals(1, stack.pop());
        assertEquals(15, stack.pop());
        assertEquals(150, stack.pop());
        assertTrue(stack.isEmpty());
    }

    @Test
    void whenPeekIntoStack_ShouldReturnTheTopValue() {
        Stack<String> stack = new Stack<>();
        stack.push("Mohammad");
        stack.push("Asac");

        assertEquals("Asac", stack.peek());
        assertEquals("Asac", stack.peek());
        stack.pop();
        assertEquals("Mohammad", stack.peek());
    }

    @Test
    void givenEmptyStack_ShouldReturnNull() {
        Stack<Double> stack = new Stack<>();
        assertTrue(stack.isEmpty());

        assertNull(stack.pop());
        assertNull(stack.peek());
    }

    @Test
    void givenStackPrintIt_ShouldReturnInRightOrder() {
        Stack<String> stack = new Stack<>();
        stack.push("Mohammad");
        stack.push("Asac");
        stack.push("Luminus");

        assertEquals("TOP -> { Luminus } -> { Asac } -> { Mohammad } -> NULL", stack.toString());
    }
}
