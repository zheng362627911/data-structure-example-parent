package com.yeepay.linear.linked;

import com.yeepay.linear.List;

/**
 * Created by zhenghao on 2019/2/13
 * call me 201****397
 * 有虚拟头结点的单向链表
 */
public class DummyLinkedList<E> implements List<E> {
    @Override
    public void add(E e) {
        this.add(e,size());
    }

    @Override
    public void add(E e, int index) {

    }

    @Override
    public void addFirst(E e) {

    }

    @Override
    public void addLast(E e) {

    }

    @Override
    public E remove(E e) {
        return null;
    }

    @Override
    public E remove(int index) {
        return null;
    }

    @Override
    public E removeFirst() {
        return null;
    }

    @Override
    public E removeLast() {
        return null;
    }

    @Override
    public void set(int index, E e) {

    }

    @Override
    public E get(int index) {
        return null;
    }

    @Override
    public boolean contains(E e) {
        return false;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }
}
