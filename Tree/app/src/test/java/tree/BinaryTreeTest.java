package tree;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class BinaryTreeTest {
    @Test
    public void givenEmptyTree_ShouldThrowAnException() {
        BinaryTree<Integer> bst = new BinaryTree<>();
        assertThrows(NullPointerException.class, () -> {
            bst.preOrderTraverse(bst.getRoot(), new ArrayList<>());
        });
        assertThrows(NullPointerException.class, () -> {
            bst.inOrderTraverse(bst.getRoot(), new ArrayList<>());
        });
        assertThrows(NullPointerException.class, () -> {
            bst.postOrderTraverse(bst.getRoot(), new ArrayList<>());
        });
    }

}
