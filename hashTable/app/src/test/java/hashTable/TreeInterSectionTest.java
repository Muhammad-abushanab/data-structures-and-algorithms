package hashTable;


import hashTable.TreeIntersection.BinaryTree;
import hashTable.TreeIntersection.Node;
import hashTable.TreeIntersection.TreeInterSection;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TreeInterSectionTest {

    TreeInterSection treeInterSection = new TreeInterSection();
    BinaryTree binaryTree1;
    BinaryTree binaryTree2;
    BinaryTree binaryTree3;
    BinaryTree binaryTree4;

    @BeforeEach
    public void setup(){
        binaryTree1 = new BinaryTree();
        binaryTree2 = new BinaryTree();
        binaryTree3 = new BinaryTree();
        binaryTree4 = new BinaryTree();

        // adds nodes to the tree
        binaryTree1.setRoot(new Node(1));
        binaryTree1.getRoot().setLeft(new Node(2));
        binaryTree1.getRoot().setRight(new Node(41));
        binaryTree1.getRoot().getRight().setLeft(new Node(10));
        binaryTree1.getRoot().getRight().setRight(new Node(41));
        binaryTree1.getRoot().getLeft().setLeft(new Node(4));
        binaryTree1.getRoot().getLeft().setRight(new Node(8));

        binaryTree2.setRoot(new Node(9));
        binaryTree2.getRoot().setLeft(new Node(1));
        binaryTree2.getRoot().setRight(new Node(8));
        binaryTree2.getRoot().getRight().setLeft(new Node(107));
        binaryTree2.getRoot().getRight().setRight(new Node(21));
        binaryTree2.getRoot().getLeft().setLeft(new Node(41));
        binaryTree2.getRoot().getLeft().setRight(new Node(7));

        binaryTree3.setRoot(new Node(9));
        binaryTree3.getRoot().setLeft(new Node(11));
        binaryTree3.getRoot().setRight(new Node(8));

        binaryTree4.setRoot(new Node(1));
        binaryTree4.getRoot().setLeft(new Node(2));
        binaryTree4.getRoot().setRight(new Node(41));
    }

    @Test
    public void intersection(){
        List<Integer> list = treeInterSection.treeIntersection(binaryTree1,binaryTree2);

        assertTrue(list.contains(1));
        assertTrue(list.contains(8));
        assertTrue(list.contains(41));
        assertFalse(list.contains(7));
    }

    @Test
    public void intersection2(){
        List<Integer> list2 = treeInterSection.treeIntersection(binaryTree1,binaryTree3);
        assertTrue(list2.contains(8));
        assertFalse(list2.contains(41));
        assertFalse(list2.contains(7));
    }

    @Test
    public void intersection3(){
        List<Integer> list2 = treeInterSection.treeIntersection(binaryTree4,binaryTree3);

        assertEquals(0, list2.size());
        assertFalse(list2.contains(41));
        assertFalse(list2.contains(7));
    }


}
