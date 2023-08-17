package linkedlist;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LinkedListTest {
    @Test
    void insertIntoLinkedList_ReturnValue(){
        LinkedList testLinkedList = new LinkedList();
        testLinkedList.insert(5);
        testLinkedList.insert(9);
        assertEquals("{ 9 } -> { 5 } -> NULL",testLinkedList.toString());
    }


    @Test void include_LinkedList_ReturnTrue(){
        LinkedList testLinkedList = new LinkedList();
        testLinkedList.insert(5);
        boolean acutal = testLinkedList.includes(5);
        assertEquals(true,acutal);
    }

    @Test void include_ValueDoesNotExist_LinkedList_ReturnFalse (){
        assertEquals(false,new LinkedList().includes(5));
    }



    @Test void printTheRight_Order_Of_TheLinkedList_Return_StringOrder() {
        LinkedList testLinkedList = new LinkedList();
        testLinkedList.insert(15);
        testLinkedList.insert(16);
        testLinkedList.insert(8);
        testLinkedList.insert(25);

        assertEquals("{ 25 } -> { 8 } -> { 16 } -> { 15 } -> NULL",testLinkedList.toString());
    }
}
