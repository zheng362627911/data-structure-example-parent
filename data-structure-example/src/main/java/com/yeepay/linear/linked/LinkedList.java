package com.yeepay.linear.linked;

import com.yeepay.linear.List;

/**
 * Created by zhenghao on 2019/2/13
 * call me 201****397
 * 没有虚拟头结点的单向链表
 */
public class LinkedList<E> implements List<E> {
    private Node<E> head;
    private int size;

    @Override
    public void add(E e) {
        this.add(e, size);
    }

    @Override
    public void add(E e, int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException();
        }

        if (null == head) {
            head = new Node<E>(e, null);
            size++;
            return;
        }

        if(index == 0){
            head = new Node<E>(e, head);
            size++;
            return;
        }

        Node<E> preIndex = head;
        for (int i = 0; i < index - 1; i++) {
            preIndex = preIndex.next;
        }

        preIndex.next = new Node<E>(e, preIndex.next);
        size++;
    }

    @Override
    public void addFirst(E e) {
        add(e, 0);
    }

    @Override
    public void addLast(E e) {
        add(e, size);
    }

    @Override
    public E remove(E e) {
        Node<E> cur = head;
        while (cur != null) {
            if (cur.e.equals(e)) {
                break;
            }
            cur = cur.next;
        }
        if (cur == null) {
            return null;
        }
        size--;
        return (E) cur.e;
    }

    @Override
    public E remove(int index) {
        if (index < 0 || index > size)
            return null;
        E e = null;
        if (index == 0) {
            e = head == null ? null : head.e;
            head = head.next;
            size--;
        } else {
            Node<E> preIndex = head;
            for (int i = 0; i < index - 1; i++) {
                preIndex = preIndex.next;
            }
            Node<E> deleteNode = preIndex.next;
            preIndex.next = deleteNode.next;
            size--;
            deleteNode.next = null;
            e = deleteNode.e;
        }
        return e;
    }

    @Override
    public E removeFirst() {
        return remove(0);
    }

    @Override
    public E removeLast() {
        return remove(size);
    }

    @Override
    public void set(int index, E e) {
        if (index < 0 || index > size) {
            return;
        }
        if (null == head) {
            throw new IllegalArgumentException();
        }
        Node cur = head;
        for (int i = 0; i < index; i++) {
            cur = head.next;
        }
        cur.e = e;
    }

    @Override
    public E get(int index) {
        if (index < 0 || index > size) {
            return null;
        }
        if (null == head) {
            return null;
        }

        Node<E> cur = head;
        for (int i = 0; i < index ; i++) {
            cur = cur.next;
        }

        return cur.e;
    }

    @Override
    public boolean contains(E e) {
        if(size == 0){
            return false;
        }
        Node cur = head;
        for (int i = 0; i < size; i++) {
            if(cur.e.equals(e)){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return 0;
    }

    private class Node<E> {
        private E e;
        private Node<E> next;

        public Node() {
        }

        public Node(E e, Node<E> nex) {
            this.e = e;
            this.next = nex;
        }
    }

    @Override
    public String toString() {
        if (size == 0 || null == head) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer("");
        Node cur = head;
        for (int i = 0; i < size; i++) {
            stringBuffer.append(cur.e).append(",");
            cur = cur.next;
        }
        return stringBuffer.toString();
    }

    public void reverse(){
        Node cur = head;
        Node pre = null;
        Node next = cur.next;
        while (next != null){
            cur.next = pre;
            pre = cur;
            cur = next;
            next = cur.next;
        }
        cur.next = pre;
        head = cur;
    }
}
