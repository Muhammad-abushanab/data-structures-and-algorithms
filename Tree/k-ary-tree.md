# Breadth First Search

## Summary

To implement a function called fizzbuzzTree that Accepts an k-ary-tree
and checks if the value is divisable by 3 or 5 and return fizz , buzz respectivly if it's divisable by both returns fizzBuzz

## WhiteBoard

![K-ary-tree](./images/k-ary%20tree.jpg)

## Approach & Efficiency

- **Create a Node Class:**
    Define a Node class that contains an integer value and a list of child nodes.
- **Create a K-ary Tree Class:**
    Define a KaryTree class that contains a root node representing the root of the K-ary tree.
- **Implement FizzBuzz Transformation Method:**
    Create a method named fizzBuzzTree within the KaryTree class that takes a K-ary tree as input and returns a transformed K-ary tree.
- **Handle Node Checking:**
Inside fizzBuzzTree, check if the input node is null or not.
- **Create New Nodes with Transformed Values:**
    If the input node is not null, create a new node with a transformed value based on whether the original node's value is divisible by 3, 5, or both.
- **Iterate Through Child Nodes:**
Iterate through the child nodes of the original node.
For each child node:
Recursively call the fizzBuzzTree method to transform the child node and its subtree.

## Big O

Big o will be O(n) since we traverse the whole tree and that depends on the number of nodes in the tree

## Solution

### Code

```java
public class KaryTree<T> {
    private final Node<T> root;

    public KaryTree(T root) {
        this.root = new Node<>(root);
    }

    public Node<T> getRoot() {
        return root;
    }

    public Node<String> fizzBuzTree(Node<Integer> node) {
        if (node == null) return null;
        Node<String> fizzBuzzNode = new Node<>(fizzBuz(node.value));
        for (Node<Integer> child : node.getChildren()
        ) {
            fizzBuzzNode.getChildren().add(fizzBuzTree(child));
        }
        return fizzBuzzNode;
    }


    private String fizzBuz(int value) {
        if (value % 3 == 0 && value % 5 == 0) {
            return "FizzBuzz";
        } else if (value % 3 == 0) {
            return "Fizz";
        } else if (value % 5 == 0) {
            return "Buzz";
        } else return String.valueOf(value);
    }

    public void postorder(Node<T> root) {
        if (root == null) {
            return;
        }
        for (int i = 0; i < root.getChildren().size(); i++) {
            postorder(root.getChildren().get(i));
        }
        System.out.print(root.getValue() + " ");
    }
}

```

### Test

```java
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
```
