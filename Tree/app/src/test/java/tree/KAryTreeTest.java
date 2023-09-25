package tree;

import org.junit.jupiter.api.Test;
import tree.KaryTree.KaryTree;
import tree.KaryTree.Node;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class KAryTreeTest {
    @Test
    public void testFizzBuzzTree() {
        Node<Integer> root = new Node<>(15);
        Node<Integer> child1 = new Node<>(3);
        Node<Integer> child2 = new Node<>(5);
        Node<Integer> child3 = new Node<>(10);

        root.getChildren().add(child1);
        root.getChildren().add(child2);
        root.getChildren().add(child3);

        Node<Integer> grandChild1 = new Node<>(9);
        Node<Integer> grandChild2 = new Node<>(20);

        child1.getChildren().add(grandChild1);
        child3.getChildren().add(grandChild2);

        KaryTree<Integer> originalTree = new KaryTree<>(root.getValue());
        originalTree.getRoot().getChildren().addAll(root.getChildren());


        KaryTree<String> fizzBuzzTree = new KaryTree<>("FizzBuzz");
        for (Node<Integer> child : originalTree.getRoot().getChildren()) {
            Node<String> fizzBuzzChild = fizzBuzzTree.fizzBuzTree(child);
            fizzBuzzTree.getRoot().getChildren().add(fizzBuzzChild);
        }

        // Validate the transformed tree values
        Node<String> fizzBuzzRoot = fizzBuzzTree.getRoot();
        assertEquals("FizzBuzz", fizzBuzzRoot.getValue());
        assertEquals("Fizz", fizzBuzzRoot.getChildren().get(0).getValue());
        assertEquals("Buzz", fizzBuzzRoot.getChildren().get(1).getValue());
        assertEquals("Buzz", fizzBuzzRoot.getChildren().get(2).getValue());
        assertEquals("Fizz", fizzBuzzRoot.getChildren().get(0).getChildren().get(0).getValue());
    }
    @Test
    public void testFizzBuzzTreeEmptyTree() {
        KaryTree<Integer> emptyTree = new KaryTree<>(0);


        KaryTree<String> fizzBuzzTree = new KaryTree<>("FizzBuzz");
        fizzBuzzTree.fizzBuzTree(emptyTree.getRoot());


        Node<String> fizzBuzzRoot = fizzBuzzTree.getRoot();
        assertEquals(0, fizzBuzzRoot.getChildren().size());
    }
}
