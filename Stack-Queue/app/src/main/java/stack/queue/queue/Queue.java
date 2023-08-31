package stack.queue.queue;

import stack.queue.Node;

public class Queue<T> {
    private Node<T> front;
    private Node<T> rear;

    public void enqueue(T data) {
        Node<T> newNode = new Node<>(data);

        if (isEmpty()) {
            front = newNode;
            rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
    }

    public T dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return null;
        }

        T data = front.data;
        front = front.next;

        if (front == null) {
            rear = null;
        }

        return data;
    }

    public T peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return null;
        }

        return front.data;
    }

    public boolean isEmpty() {
        return front == null;
    }

    @Override
    public String toString() {
        Node<T> current = front;
        StringBuilder allValues = new StringBuilder();
        allValues.append("front -> ");
        while (current != null) {
            if (current.next != null) {
                allValues.append("{ ").append(current.data).append(" } -> ");
            } else {
                allValues.append("{ ").append(current.data).append(" } <- ");
            }
            current = current.next;
        }
        allValues.append("rear");
        return allValues.toString();
    }
}
