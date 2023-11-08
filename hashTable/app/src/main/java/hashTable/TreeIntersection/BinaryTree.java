package hashTable.TreeIntersection;

import java.util.ArrayList;

public class BinaryTree {
    public Node root;
    public ArrayList<Integer> preOrderArr = new ArrayList<>();
    public ArrayList<Integer> inOrderArr = new ArrayList<>();
    public ArrayList<Integer> postOrderArr = new ArrayList<>();
    public ArrayList<Integer> breadthArr = new ArrayList<>();
    public Integer maxValue;

    public void preOrderTraverse(Node node) {
        if (root == null) {
            System.out.println("There is nothing in the tree");
            return;
        }

        if (node != null) {
            System.out.print(node.getKey() + " ");
            preOrderArr.add(node.getKey());

            preOrderTraverse(node.getLeft());
            preOrderTraverse(node.getRight());
        }
    }

    public void inOrderTraverse(Node node) {
        if (root == null) {
            System.out.println("There is nothing in the tree");
            return;
        }
        if (node != null) {
            inOrderTraverse(node.getLeft());

            System.out.print(node.getKey() + " ");
            inOrderArr.add(node.getKey());

            inOrderTraverse(node.getRight());
        }
    }

    public void postOrderTraverse(Node node) {
        if (root == null) {
            System.out.println("There is nothing in the tree");
            return;
        }
        if (node != null) {
            if (maxValue == null || maxValue < node.getKey()){
                maxValue = node.getKey();
            }
            postOrderTraverse(node.getLeft());
            postOrderTraverse(node.getRight());

            System.out.print(node.getKey() + " ");
            postOrderArr.add(node.getKey());
        }
    }
    public int getLeafCount(Node node) {
        if (node == null) {
            return 0;
        }
        if (node.getLeft() == null && node.getRight() == null) {
            return 1;
        }
        else {
            return getLeafCount(node.getLeft()) + getLeafCount(node.getRight());
        }
    }
    public boolean compareTwoTreesLeaves(BinaryTree binaryTree1, BinaryTree binaryTree2){
        int leavesNumTree1 = binaryTree1.getLeafCount(binaryTree1.getRoot());
        int leavesNumTree2 = binaryTree1.getLeafCount(binaryTree2.getRoot());

        return leavesNumTree1 == leavesNumTree2;
    }



    public Integer maximum(){
        Node node = root;
        postOrderTraverse(node);
        return maxValue;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public Node getRoot() {
        return root;
    }

    public ArrayList<Integer> getPreOrderArr() {
        return preOrderArr;
    }

    public ArrayList<Integer> getInOrderArr() {
        return inOrderArr;
    }

    public ArrayList<Integer> getPostOrderArr() {
        return postOrderArr;
    }
}
