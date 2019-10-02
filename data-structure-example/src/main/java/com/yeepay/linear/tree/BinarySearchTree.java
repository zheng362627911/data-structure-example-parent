package com.yeepay.linear.tree;

/**
 * Created by zhenghao on 2019/2/15
 * call me 201****397
 */
public class BinarySearchTree<E extends Comparable<E>> {

    private Node<E> root;
    private int size;

    public void add(E e) {
        root = add0(root, e);
    }

    /**
     * 添加指定元素到指定根节点的树下
     *
     * @param curNode 指定根节点
     * @param e       指定元素
     * @return 返回根节点地址
     */
    private Node<E> add0(Node<E> curNode, E e) {
        if (null == curNode) {
            size++;
            return new Node<E>(e, null, null);
        }

        // curNode.e < e
        if (curNode.e.compareTo(e) < 0) {
            curNode.right = add0(curNode.right, e);
        }
        // curNode.e = e
        else if (curNode.e.compareTo(e) == 0) {
            // 如果插入元素是当前节点，那么什么都不做
        }
        // curNode.e > e;
        else {
            curNode.left = add0(curNode.left, e);
        }

        return curNode;
    }

    public void remove(E e) {
        root = remove(root, e);
    }


    public void middlePolling() {
        middlePolling(root);
    }

    /**
     * 中序遍历
     */
    private void middlePolling(Node<E> node) {
        if (node == null) {
            return;
        }
        middlePolling(node.left);
        System.out.println(node.e);
        middlePolling(node.right);

    }

    private Node<E> remove(Node<E> curNode, E e) {
        if (curNode == null) {
            return null;
        }
        //
        if (curNode.e.compareTo(e) < 0) {
            curNode.right = remove(curNode.right, e);
        } else if (curNode.e.compareTo(e) > 0) {
            curNode.left = remove(curNode.left, e);
        } else {
            // curNode.e.compareTo(e) == 0 当前节点就是待删除节点 ;
            // 当前节点只有左子树
            if (curNode.left != null && curNode.right == null) {
                size--;
                curNode = curNode.left;
            } else if (curNode.right != null && curNode.left == null) {
                size--;
                curNode = curNode.right;
            } else if (curNode.right == null && curNode.left == null) {
                size--;
                curNode = null;
            } else {
                // 当前节点既有左子树又有又子树
                // 方式1：找出左子树中的最大值替代待删除节点，维持住二叉树性质 node = max(curNode.left) ; remove(curNode.left, node.e)
                Node<E> node = maximun(curNode.left);
                curNode.left = remove(curNode.left, node.e);
                node.left = curNode.left;
                node.right = curNode.right;
                curNode = node;
                size--;
                // 方式2：找出右子树中的最小值替代待删除节点，维持住二叉树性质 node = min(curNode.right) ; remove(curNode.right, node.e)
            }
        }
        return curNode;
    }

    private Node<E> maximun(Node<E> node) {
        if (node == null) {
            return null;
        }
        if (node.right == null) {
            return node;
        }
        return maximun(node.right);
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void removeMax() {
        root = removeMax(root);
    }


    private Node<E> removeMax(Node<E> node) {
        if (null == node) {
            return null;
        }

        if(null == node.right){
            size --;
            return node.left;
        }
        node.right = removeMax(node.right);
        return node;
    }

    public void removeMin() {
        root = removeMin(root);
    }

    private Node<E> removeMin(Node<E> node) {
        if(null == node){
            return null;
        }

        if(null == node.left){
            size--;
            return node.right;
        }
        node.left = removeMin(node.left);
        return node;
    }


    private class Node<E> {
        private E e;
        private Node<E> left;
        private Node<E> right;

        public Node(E e, Node<E> left, Node<E> right) {
            this.e = e;
            this.left = left;
            this.right = right;
        }

        public E getE() {
            return e;
        }

        public void setE(E e) {
            this.e = e;
        }

        public Node<E> getLeft() {
            return left;
        }

        public void setLeft(Node<E> left) {
            this.left = left;
        }

        public Node<E> getRight() {
            return right;
        }

        public void setRight(Node<E> right) {
            this.right = right;
        }
    }


    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        generateBSTString(root, 0, res);
        return res.toString();
    }

    // 生成以node为根节点，深度为depth的描述二叉树的字符串
    private void generateBSTString(Node node, int depth, StringBuilder res) {

        if (node == null) {
            res.append(generateDepthString(depth) + "null\n");
            return;
        }

        res.append(generateDepthString(depth) + node.e + "\n");
        generateBSTString(node.left, depth + 1, res);
        generateBSTString(node.right, depth + 1, res);
    }

    private String generateDepthString(int depth) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < depth; i++)
            res.append("-");
        return res.toString();
    }
}
