package stack.queue;
import org.junit.jupiter.api.Test;
import stack.queue.queue.Queue;

import static org.junit.jupiter.api.Assertions.*;
public class QueueTest {
    @Test
    void givenAQueueTest_EnqueueAndDequeue() {
        Queue<Integer> queue = new Queue<>();
        queue.enqueue(150);
        queue.enqueue(15);
        queue.enqueue(1);

        assertEquals(150, queue.dequeue());
        assertEquals(15, queue.dequeue());
        assertEquals(1, queue.dequeue());
        assertTrue(queue.isEmpty());
    }

    @Test
    void whenPeekIntoQueue_ShouldReturnTheFrontValue() {
        Queue<String> queue = new Queue<>();
        queue.enqueue("Mohammad");
        queue.enqueue("Asac");

        assertEquals("Mohammad", queue.peek());
        queue.dequeue();
        assertEquals("Asac", queue.peek());
    }

    @Test
    void givenAQueue_TestWhetherItsEmptyOrNot_ShouldReturnNull() {
        Queue<Double> queue = new Queue<>();
        assertTrue(queue.isEmpty());

        assertNull(queue.dequeue());
        assertNull(queue.peek());
    }

    @Test
    void givenAQueuePrint_InRightOrder() {
        Queue<String> queue = new Queue<>();
        queue.enqueue("Mohammad");
        queue.enqueue("Asac");
        queue.enqueue("Luminus");

        assertEquals("front -> { Mohammad } -> { Asac } -> { Luminus } <- rear", queue.toString());
    }
}
