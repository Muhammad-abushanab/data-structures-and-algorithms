package linkedlist;

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
