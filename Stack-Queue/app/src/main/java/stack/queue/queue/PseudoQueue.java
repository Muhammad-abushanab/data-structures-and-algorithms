package stack.queue.queue;

import stack.queue.stack.Stack;

public class PseudoQueue<T> {
    public Stack<T> stack1;
    public Stack<T> stack2;

    public PseudoQueue() {
        this.stack1 = new Stack<>();
        this.stack2 = new Stack<>();
    }

    public void enqueue(T value) {
        stack1.push(value);
    }

    public T dequeue() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push((T) stack1.pop());
            }
        }

        return stack2.pop();
    }

    public boolean isEmpty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "Queue is empty";
        }

        StringBuilder allValues = new StringBuilder();
        allValues.append("FRONT -> ");

        // Use a temporary stack to hold reversed elements
        Stack<T> tempStack = new Stack<>();

        // Transfer elements from stack1 to stack2 only if stack2 is empty
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }

        while (!stack2.isEmpty()) {
            T value = stack2.pop();
            allValues.append("{ ").append(value).append(" } -> ");
            tempStack.push(value);
        }

        // Transfer elements back to stack1
        while (!tempStack.isEmpty()) {
            stack1.push(tempStack.pop());
        }

        allValues.append("REAR");
        return allValues.toString();
    }
}
