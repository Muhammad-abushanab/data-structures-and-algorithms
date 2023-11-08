package hashTable.TreeIntersection;

import hashTable.HashTable;

import java.util.ArrayList;
import java.util.List;

public class TreeInterSection {
    private final HashTable<Integer, Integer> hashMap = new HashTable<>();
    private final List<Integer> intersections = new ArrayList<>();
    public List<Integer> treeIntersection(BinaryTree tree1, BinaryTree tree2){
        if (tree1.root == null || tree2.root == null) {
            return null;
        }
        traverse(tree1.root);

        compare(tree2.root);

        return intersections;
    }

    public void traverse(Node node) {
        if (node != null) {
            int count = hashMap.get(node.getKey()) == null ? 1 : hashMap.get(node.getKey()) + 1;
            hashMap.set(node.getKey(),count);

            traverse(node.getLeft());
            traverse(node.getRight());
        }
    }

    public void compare(Node node){
        if (node != null) {
            if (hashMap.get(node.getKey()) != null){
                intersections.add(node.getKey());
            }
            compare(node.getLeft());
            compare(node.getRight());
        }
    }
}
