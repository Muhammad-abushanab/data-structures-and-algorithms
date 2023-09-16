package tree;

public class Node<T> {
    public T value;
    public Node<T> leftChild;
    public Node<T> rightChild;

    public Node(T value) {
        this.leftChild = null;
        this.rightChild = null;
        this.value = value;
    }
}
