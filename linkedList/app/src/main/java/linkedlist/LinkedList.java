package linkedlist;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class LinkedList {
    Node head;
    public LinkedList(){
        this.head = null;
    }
    public void insert(int value){
        Node addNode = new Node(value);
        addNode.next = head;
        head = addNode;
    }

    public boolean includes(int value) {
        Node current = head;
        while (current != null) {
            if(current.value == value) {
                return true;
            }
            current = current.next;
        }
        return false;
    }
    public void append(int value){
        Node addNode = new Node(value);
        if(head == null) {
            head = addNode;
            return;
        }
        Node current = head;
        while(current.next != null) {
            current = current.next;
        }
        current.next = addNode;
    }
    public void insertAfter(int value, int after) {
        Node current = head;
        while (current != null) {
            if (current.value == after) {
                Node addNode = new Node(value);
                addNode.next = current.next;
                current.next = addNode;
                break;
            }
            current = current.next;
        }
        System.out.println("Could not insert maybe the " + after +" does not exist try include");
    }
    public void insertBefore(int value, int before) {
        if (head == null) {
            System.out.println("Cannot insert before empty list");
            return;
        }

        if (head.value == before) {
            Node addNode = new Node(value);
            addNode.next = head;
            head = addNode;
            return;
        }

        Node current = head;
        while (current.next != null) {
            if (current.next.value == before) {
                Node addNode = new Node(value);
                addNode.next = current.next;
                current.next = addNode;
                break;
            }
            current = current.next;
        }
        System.out.println("Could not insert maybe the " + before +" does not exist try include");
    }
    public void delete(int value) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        if (head.value == value) {
            head = head.next;
            return;
        }

        Node current = head;
        while (current.next != null) {
            if (current.next.value == value) {
                current.next = current.next.next;
                return;
            }
            current = current.next;
        }
        System.out.println("Value does not exist");
    }
    public int kthFromEnd(int k) {
        if (head == null || k < 0) {
            throw new IllegalArgumentException("Invalid input");
        }
        int size = 0;
        Node current = head;

        while (current != null) {
            size++;
            current = current.next;
        }

        if (k == size) {
            throw new NullPointerException("k is equal to the list size");
        }
        Node p1 = head;
        Node p2 = head;

        for (int i = 0; i < k; i++) {
            if (p2 == null) {
                throw new IllegalArgumentException("k is larger than the list size");
            }
            p2 = p2.next;
        }

        while (p2.next != null) {
            p1 = p1.next;
            p2 = p2.next;
        }

        return p1.value;
    }

    public  LinkedList zipLists(LinkedList list1, LinkedList list2) {
        LinkedList zipList = new LinkedList();

        Node current1 = list1.head;
        Node current2 = list2.head;

        while (current1 != null && current2 != null) {
            zipList.append(current1.value);
            zipList.append(current2.value);
            current1 = current1.next;
            current2 = current2.next;
        }

        while (current1 != null) {
            zipList.append(current1.value);
            current1 = current1.next;
        }

        while (current2 != null) {
            zipList.append(current2.value);
            current2 = current2.next;
        }

        return zipList;
    }
    public void reverse() {
        Node prev = null;
        Node current = head;
        Node next = null;

        while (current != null) {
            next = current.next;
            current.next = prev;

            prev = current;
            current = next;
        }

        head = prev;
    }

    public String toString(){
        String result = "";
        Node current = head;
        while (current != null) {
            result += "{ " + current.value + " } -> ";
            current = current.next;
        }
        result += "NULL";
        return result;
    }
}
