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
