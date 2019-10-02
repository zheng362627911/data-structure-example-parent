package com.yeepay.linear.queue;

import com.yeepay.linear.array.DynamicArrayList;

/**
 * Created by zhenghao on 2019/2/13
 * call me 201****397
 */
public class ArrayQueue<E> implements Queue<E> {

    private final DynamicArrayList<E> list;

    public ArrayQueue(int capacity){
        list = new DynamicArrayList<E>(capacity);
    }
    @Override
    public void add(E e) {
        list.addLast(e);
    }

    @Override
    public E poll() {
        return list.remove(0);
    }

    @Override
    public E peek() {
        return list.get(0);
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public String toString() {
        return list.toString();
    }
}
