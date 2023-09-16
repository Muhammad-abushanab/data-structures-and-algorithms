package tree;

public class BinarySearchTree<T extends Comparable<T>> extends BinaryTree<T>{
    public BinarySearchTree(){
        super();
    }
    public void add(T value) {
        root = addHelper(root, value);
    }

    private Node<T> addHelper(Node<T> current, T value) {
        if (current == null) {
            return new Node<>(value);
        }

        if (value.compareTo(current.value) < 0) {
            current.leftChild = addHelper(current.leftChild, value);
        } else if (value.compareTo(current.value) > 0) {
            current.rightChild = addHelper(current.rightChild, value);
        }

        return current;
    }

    public boolean contains(T value) {
        return containsHelper(root, value);
    }

    private boolean containsHelper(Node<T> current, T value) {
        if (current == null) {
            return false;
        }

        if (value.equals(current.value)) {
            return true;
        }

        if (value.compareTo(current.value) < 0) {
            return containsHelper(current.leftChild, value);
        } else {
            return containsHelper(current.rightChild, value);
        }
    }

}
