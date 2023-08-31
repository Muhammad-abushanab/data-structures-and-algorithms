package stack.queue.stack;

import stack.queue.Node;

public class Stack<T> {
    private Node<T> top;

    public void push(T data) {
        Node<T> newNode = new Node<>(data);
        newNode.next = top;
        top = newNode;
    }

    public T pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return  null;
        }

        T data = top.data;
        top = top.next;
        return data;
    }

    public T peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return null;
        }

        return top.data;
    }

    public boolean isEmpty() {
        return top == null;
    }
    @Override
    public String toString() {
        Node<T> current = top;
        StringBuilder allValues = new StringBuilder();
        allValues.append("TOP -> ");

        while (current != null) {
            allValues.append("{ ").append(current.data).append(" } -> ");
            current = current.next;
        }

        allValues.append("NULL");
        return allValues.toString();
    }
}
