package stack.queue;
import org.junit.jupiter.api.Test;
import stack.queue.queue.PseudoQueue;

import static org.junit.jupiter.api.Assertions.*;
public class PseudoQueueTest {
    @Test
    public void enqueueIntoQueue_And_ReturnValues() throws Exception {
        PseudoQueue<Integer> queue = new PseudoQueue<>();
        assertTrue(queue.isEmpty());

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        assertFalse(queue.isEmpty());
        assertEquals(1, queue.dequeue());
        assertEquals(2, queue.dequeue());
        assertEquals(3, queue.dequeue());

        assertTrue(queue.isEmpty());
    }

    @Test
    public void whenEmptyQueue_ReturnException() {
        PseudoQueue<Integer> queue = new PseudoQueue<>();
        assertTrue(queue.isEmpty());

        assertThrows(Exception.class, queue::dequeue);
    }

    @Test
    public void givenAQueue_ReturnToString() throws Exception {
        PseudoQueue<Integer> queue = new PseudoQueue<>();
        assertTrue(queue.isEmpty());

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
//        queue.dequeue();
        String expected = "FRONT -> { 1 } -> { 2 } -> { 3 } -> REAR";
        assertEquals(expected, queue.toString());

    }
    @Test
    void givenAQueue_DequeueReturnValues(){
        PseudoQueue<Integer> queue = new PseudoQueue<>();
        queue.enqueue(4);
        queue.enqueue(45);
        queue.enqueue(15);
        queue.dequeue();
        assertEquals("FRONT -> { 45 } -> { 15 } -> REAR",queue.toString());
    }
}
