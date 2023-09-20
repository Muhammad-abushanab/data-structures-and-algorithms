package tree;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class BinarySearchTreeTest {
    @Test
    public void givenSingleNodeTree_ShouldReturnRoot(){
        BinarySearchTree<String> bst = new BinarySearchTree<>();
        bst.add("Mohammad");
        assertEquals("[Mohammad]",bst.preOrderTraverse(bst.getRoot(),new ArrayList<>()).toString());
        assertEquals("[Mohammad]",bst.postOrderTraverse(bst.getRoot(),new ArrayList<>()).toString());
        assertEquals("[Mohammad]",bst.inOrderTraverse(bst.getRoot(),new ArrayList<>()).toString());
    }
    @Test
    public void givenATree_ShouldReturnTraversalInCorrectOrder(){
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        bst.add(15); // root
        bst.add(20); // right child
        bst.add(10); // left child
        bst.add(7); // left child of 10
        bst.add(12); // right child of 10
        bst.add(22); // right child of 20
        bst.add(17); // left child of 20
        bst.add(18); // right child of 17
        ArrayList<Integer> postOrderExpected = new ArrayList<>();
        postOrderExpected.add(7);
        postOrderExpected.add(12);
        postOrderExpected.add(10);
        postOrderExpected.add(18);
        postOrderExpected.add(17);
        postOrderExpected.add(22);
        postOrderExpected.add(20);
        postOrderExpected.add(15);
        assertArrayEquals(postOrderExpected.toArray(),bst.postOrderTraverse(bst.getRoot(),new ArrayList<>()).toArray());

        // In Order Traversal Test
        ArrayList<Integer> inOrderExpected = new ArrayList<>();
        inOrderExpected.add(7);
        inOrderExpected.add(10);
        inOrderExpected.add(12);
        inOrderExpected.add(15);
        inOrderExpected.add(17);
        inOrderExpected.add(18);
        inOrderExpected.add(20);
        inOrderExpected.add(22);
        assertArrayEquals(inOrderExpected.toArray(),bst.inOrderTraverse(bst.getRoot(),new ArrayList<>()).toArray());

        // Pre Order Traversal Test
        ArrayList<Integer> preOrderExpected = new ArrayList<>();
        preOrderExpected.add(15);
        preOrderExpected.add(10);
        preOrderExpected.add(7);
        preOrderExpected.add(12);
        preOrderExpected.add(20);
        preOrderExpected.add(17);
        preOrderExpected.add(18);
        preOrderExpected.add(22);
        assertArrayEquals(preOrderExpected.toArray(),bst.preOrderTraverse(bst.getRoot(),new ArrayList<>()).toArray());
    }
    @Test
    public void givenATree_WithNoNodes_findMaxShouldReturnNull(){
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        assertNull(bst.findMaxValue());
    }@Test
    public void givenATree_findMaxShouldReturnMaximum(){
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        bst.add(45);
        bst.add(235);
        bst.add(5);
        bst.add(40);
        bst.add(89);
        bst.add(1234);
        bst.add(0);
        assertEquals(1234,bst.findMaxValue());
    }
    @Test
    public void givenATree_TraversUsingBFS(){
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        bst.add(45); // root lvl 1
        bst.add(235); //right child of 45 lvl 2
        bst.add(5); // left child of 45 lvl 2
        bst.add(40); // right child of 5 lvl 3
        bst.add(89); // left child of 235 lvl 3
        bst.add(1234); // right child of 1234 lvl 3
        bst.add(0); // lef child of 5 lvl 3
        ArrayList<Integer> bstExpected = new ArrayList<>();
        bstExpected.add(45);
        bstExpected.add(5);
        bstExpected.add(235);
        bstExpected.add(0);
        bstExpected.add(40);
        bstExpected.add(89);
        bstExpected.add(1234);
        assertEquals(bstExpected, bst.breadthFirst());

        // Test when tree is empty
        BinarySearchTree<Integer> bst2 = new BinarySearchTree<>();
        bstExpected.clear();
        assertEquals(bstExpected, bst2.breadthFirst());
    }
}
