package com.yeepay.linear.stack;

/**
 * Created by zhenghao on 2019/2/13
 * call me 201****397
 */
public interface Stack<E> {

    E pop();

    void push(E e);

    E peek();

    boolean isEmpty();

    int size();
}
