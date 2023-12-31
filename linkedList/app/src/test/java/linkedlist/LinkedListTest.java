package linkedlist;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LinkedListTest {
    @Test
    void insertIntoLinkedList_ReturnValue() {
        LinkedList testLinkedList = new LinkedList();
        testLinkedList.insert(5);
        testLinkedList.insert(9);
        assertEquals("{ 9 } -> { 5 } -> NULL", testLinkedList.toString());
    }


    @Test
    void include_LinkedList_ReturnTrue() {
        LinkedList testLinkedList = new LinkedList();
        testLinkedList.insert(5);
        boolean acutal = testLinkedList.includes(5);
        assertEquals(true, acutal);
    }

    @Test
    void include_ValueDoesNotExist_LinkedList_ReturnFalse() {
        assertEquals(false, new LinkedList().includes(5));
    }


    @Test
    void printTheRight_Order_Of_TheLinkedList_Return_StringOrder() {
        LinkedList testLinkedList = new LinkedList();
        testLinkedList.insert(15);
        testLinkedList.insert(16);
        testLinkedList.insert(8);
        testLinkedList.insert(25);

        assertEquals("{ 25 } -> { 8 } -> { 16 } -> { 15 } -> NULL", testLinkedList.toString());
    }


    @Test
    void appendOnEmpty_LinkedList_ReturnLinkedListWith_Value_HeadNode() {
        LinkedList testLinkedList = new LinkedList();
        testLinkedList.append(5);
        assertEquals("{ 5 } -> NULL", testLinkedList.toString());
    }

    @Test
    void appendOnValid_LinkedList_ReturnValueAt_TheEnd() {
        LinkedList testLinkedList = new LinkedList();
        testLinkedList.insert(10);
        testLinkedList.insert(25);
        testLinkedList.append(4);

        assertEquals("{ 25 } -> { 10 } -> { 4 } -> NULL", testLinkedList.toString());
    }

    @Test
    void delete_FromLinkedList_ReturnNULL() {
        LinkedList testLinkedList = new LinkedList();
        testLinkedList.insert(8);
        testLinkedList.delete(8);
        assertEquals("NULL", testLinkedList.toString());
    }

    @Test
    void delete_ValueNotExist_FromLinkedList_Return() {
        LinkedList testLinkedList = new LinkedList();
        testLinkedList.insert(8);
        testLinkedList.delete(15);
        assertEquals("{ 8 } -> NULL", testLinkedList.toString());
    }

    @Test
    void delete_FromEmptyLinkedList_ReturnNULL() {
        LinkedList testLinkedList = new LinkedList();
        testLinkedList.delete(10);
        assertEquals("NULL", testLinkedList.toString());
    }

    @Test
    void insertAfter_LinkedList_ReturnValueAfter() {
        LinkedList testLinkedList = new LinkedList();
        testLinkedList.insert(5);
        testLinkedList.insert(9);
        testLinkedList.insertAfter(6, 9);
        assertEquals("{ 9 } -> { 6 } -> { 5 } -> NULL", testLinkedList.toString());
    }

    @Test
    void insertBefore_LinkedList_ReturnValueBefore() {
        LinkedList testLinkedList = new LinkedList();
        testLinkedList.insert(5);
        testLinkedList.insert(9);
        testLinkedList.insertBefore(6, 5);
        assertEquals("{ 9 } -> { 6 } -> { 5 } -> NULL", testLinkedList.toString());
    }

    @Test
    void kth_From_End_InEmpty_LinkedList_ThrowIllegalArgumentException() {
        LinkedList testLinkedList = new LinkedList();
        assertThrows(IllegalArgumentException.class, () -> testLinkedList.kthFromEnd(5));
    }
    @Test void kth_From_End_validInput_ReturnValue(){
        LinkedList testLinkedList = new LinkedList();
        testLinkedList.insert(5);
        testLinkedList.insert(6);
        testLinkedList.insert(20);  // 20 -> 6 -> 5
        int actual = testLinkedList.kthFromEnd(2);
        assertEquals(20,actual);
    }
    @Test void kth_From_End_NumberIsBigger_ThanTheLinkedList_ReturnIllegalArgumentException(){
        LinkedList testLinkedList = new LinkedList();
        testLinkedList.insert(20);
        testLinkedList.insert(25);
        testLinkedList.insert(45); // 45 -> 25 -> 20
        assertThrows(IllegalArgumentException.class,()->testLinkedList.kthFromEnd(4));
    }
    @Test void kth_From_End_NegativeNumbers_ReturnIllegalArgumentException(){
        LinkedList testLinkedList = new LinkedList();
        testLinkedList.insert(20);
        testLinkedList.insert(25);
        testLinkedList.insert(45); // 45 -> 25 -> 20
        assertThrows(IllegalArgumentException.class,()->testLinkedList.kthFromEnd(-4));
    }
    @Test void kth_From_End_LinkedListOfSize1_ReturnValue(){
        LinkedList testLinkedList = new LinkedList();
        testLinkedList.insert(15);
        assertEquals(15,testLinkedList.kthFromEnd(0));
    }

    @Test void kth_From_End_K_IsTheSameAs_LinkedList_Size_ReturnNullPointerException() {
        LinkedList testLinkedList = new LinkedList();
        testLinkedList.insert(15);
        assertThrows(NullPointerException.class,() -> testLinkedList.kthFromEnd(1));
    }
    @Test void whenBothLinkedListHaveMultipleNodes_ShouldMergeTheNodes(){
        LinkedList list1 = new LinkedList();
        list1.append(1);
        list1.append(3);
        list1.append(2);

        LinkedList list2 = new LinkedList();
        list2.append(5);
        list2.append(9);
        list2.append(4);

        LinkedList linkedList = new LinkedList();
        LinkedList zippedList = linkedList.zipLists(list1, list2);
        assertEquals("{ 1 } -> { 5 } -> { 3 } -> { 9 } -> { 2 } -> { 4 } -> NULL",zippedList.toString());
    }
    @Test void whenOneOfTheLinkedListHasOnlyOneNode_ShouldMergeThem(){
        LinkedList list1 = new LinkedList();
        list1.append(1);

        LinkedList list2 = new LinkedList();
        list2.append(5);
        list2.append(9);
        list2.append(4);

        LinkedList linkedList = new LinkedList();
        LinkedList zippedList = linkedList.zipLists(list1, list2);
        assertEquals("{ 1 } -> { 5 } -> { 9 } -> { 4 } -> NULL",zippedList.toString());
    }
    @Test void whenBothLinkedListIsNull_ShouldReturnNull(){
        LinkedList list1 = new LinkedList();
        LinkedList list2 = new LinkedList();

        LinkedList linkedList = new LinkedList();
        LinkedList zippedList = linkedList.zipLists(list1, list2);
        assertEquals("NULL",zippedList.toString());
    }
 @Test
    void givenLinkedList_ReturnIt_InReverseOrder(){
     LinkedList list2 = new LinkedList();
     list2.insert(5);
     list2.insert(9);
     list2.insert(4);
     list2.reverse();
     assertEquals("{ 5 } -> { 9 } -> { 4 } -> NULL",list2.toString());
 }
 @Test
    void givenALinkedList_RotateKth() {
     LinkedList testLinkedList = new LinkedList();
     testLinkedList.insert(20);
     testLinkedList.insert(25);
     testLinkedList.insert(30);
     testLinkedList.insert(45); // 45 -> 30 -> 25 -> 20
     testLinkedList.rotateKthNode(2);
        assertEquals("{ 25 } -> { 20 } -> { 45 } -> { 30 } -> NULL",testLinkedList.toString());
 }
 @Test void deleteFromMiddle(){
     LinkedList testLinkedList = new LinkedList();
     testLinkedList.insert(20);
     testLinkedList.insert(25);
     testLinkedList.insert(30);
     testLinkedList.insert(45); // 45 -> 30 -> 25 -> 20
     testLinkedList.deleteFromMiddle();
     assertEquals("{ 45 } -> { 30 } -> { 20 } -> NULL",testLinkedList.toString());
     LinkedList testLinkedList2 = new LinkedList();
     testLinkedList2.insert(20);
     testLinkedList2.deleteFromMiddle();
     assertEquals("{ 20 } -> NULL",testLinkedList2.toString());
     LinkedList testLinkedList3 = new LinkedList();
     testLinkedList3.insert(20);
     testLinkedList3.insert(25);
     testLinkedList3.insert(30);
     testLinkedList3.deleteFromMiddle();
     assertEquals("{ 30 } -> { 20 } -> NULL",testLinkedList3.toString());
 }
}
