package tree.KaryTree;

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

