package com.yeepay.linear.tree;

/**
 * Created by zhenghao on 2019/2/15
 * call me 201****397
 */
public class Main {
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree<Integer>();
        tree.add(3);
        tree.add(0);
        tree.add(1);
        tree.add(6);
        tree.add(4);
        tree.add(15);
        tree.add(8);
        tree.add(67);

        tree.middlePolling();

        tree.removeMax();
        tree.middlePolling();

        tree.removeMin();
        tree.middlePolling();
    }
}
