package com.yeepay.linear.stack;

import com.yeepay.linear.List;
import com.yeepay.linear.array.DynamicArrayList;

/**
 * Created by zhenghao on 2019/2/13
 * call me 201****397
 */
public class ArrayStack<E> implements Stack<E> {
    private List<E> list;

    public ArrayStack(int capacity) {
        list = new DynamicArrayList<E>(capacity);
    }

    @Override
    public E pop() {
        return list.remove(0);
    }

    @Override
    public void push(E e) {
        list.add(e, 0);
    }

    @Override
    public E peek() {
        return list.get(0);
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public String toString() {
        return list.toString();
    }
}
