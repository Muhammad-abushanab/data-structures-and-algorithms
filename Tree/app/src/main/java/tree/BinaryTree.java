package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree<T extends Comparable<T>> {
    protected Node<T> root;

    public BinaryTree() {
        this.root = null;
    }

    public ArrayList<T> preOrderTraverse(Node<T> node, ArrayList<T> traversal) {
        if (root == null) {
            throw new NullPointerException("Tree is Empty");
        }
        if (node != null) {
            traversal.add(node.value);
            preOrderTraverse(node.leftChild, traversal);
            preOrderTraverse(node.rightChild, traversal);
        }
        return traversal;
    }

    public ArrayList<T> inOrderTraverse(Node<T> node, ArrayList<T> traversal) {
        if (root == null) {
            throw new NullPointerException("Tree is Empty");
        }
        if (node != null) {
            inOrderTraverse(node.leftChild, traversal);
            traversal.add(node.value);
            inOrderTraverse(node.rightChild, traversal);
        }
        return traversal;
    }

    public ArrayList<T> postOrderTraverse(Node<T> node, ArrayList<T> traversal) {
        if (root == null) {
            throw new NullPointerException("Tree is Empty");
        }
        if (node != null) {
            postOrderTraverse(node.leftChild, traversal);
            postOrderTraverse(node.rightChild, traversal);
            traversal.add(node.value);
        }
        return traversal;
    }

    public T findMaxValue() {
        return findMaxValue(root);
    }

    private T findMaxValue(Node<T> node) {
        if (node == null)
            return null;

        T maxValue = node.value;
        T leftMax = findMaxValue(node.leftChild);
        T rightMax = findMaxValue(node.rightChild);

        if (leftMax != null && leftMax.compareTo(maxValue) > 0)
            maxValue = leftMax;

        if (rightMax != null && rightMax.compareTo(maxValue) > 0)
            maxValue = rightMax;

        return maxValue;
    }
    public ArrayList<T> breadthFirst() {
        ArrayList<T> traversal = new ArrayList<>();
        if (root == null) {
            return traversal;
        }

        Queue<Node<T>> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            Node<T> currentNode = queue.poll();
            traversal.add(currentNode.value);

            if (currentNode.leftChild != null) {
                queue.offer(currentNode.leftChild);
            }

            if (currentNode.rightChild != null) {
                queue.offer(currentNode.rightChild);
            }
        }

        return traversal;
    }


    public Node<T> getRoot() {
        return root;
    }

}
