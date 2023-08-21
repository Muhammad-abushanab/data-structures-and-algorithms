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

    @Test void appendOnEmpty_LinkedList_ReturnLinkedListWith_Value_HeadNode(){
        LinkedList testLinkedList = new LinkedList();
        testLinkedList.append(5);
        assertEquals("{ 5 } -> NULL",testLinkedList.toString());
    }

    @Test void appendOnValid_LinkedList_ReturnValueAt_TheEnd(){
        LinkedList testLinkedList = new LinkedList();
        testLinkedList.insert(10);
        testLinkedList.insert(25);
        testLinkedList.append(4);

        assertEquals("{ 25 } -> { 10 } -> { 4 } -> NULL",testLinkedList.toString());
    }
    @Test void delete_FromLinkedList_ReturnNULL() {
        LinkedList testLinkedList = new LinkedList();
        testLinkedList.insert(8);
        testLinkedList.delete(8);
        assertEquals("NULL",testLinkedList.toString());
    }
    @Test void delete_ValueNotExist_FromLinkedList_Return() {
        LinkedList testLinkedList = new LinkedList();
        testLinkedList.insert(8);
        testLinkedList.delete(15);
        assertEquals("{ 8 } -> NULL",testLinkedList.toString());
    }

    @Test void delete_FromEmptyLinkedList_ReturnNULL(){
        LinkedList testLinkedList = new LinkedList();
        testLinkedList.delete(10);
        assertEquals("NULL",testLinkedList.toString());
    }

    @Test void insertAfter_LinkedList_ReturnValueAfter(){
        LinkedList testLinkedList = new LinkedList();
        testLinkedList.insert(5);
        testLinkedList.insert(9);
        testLinkedList.insertAfter(6,9);
        assertEquals("{ 9 } -> { 6 } -> { 5 } -> NULL",testLinkedList.toString());
    }
    @Test void insertBefore_LinkedList_ReturnValueBefore(){
        LinkedList testLinkedList = new LinkedList();
        testLinkedList.insert(5);
        testLinkedList.insert(9);
        testLinkedList.insertBefore(6,5);
        assertEquals("{ 9 } -> { 6 } -> { 5 } -> NULL",testLinkedList.toString());
    }
}
