package com.yeepay.linear.queue;

/**
 * Created by zhenghao on 2019/2/13
 * call me 201****397
 */
public interface Queue<E> {

    void add(E e);

    E poll();

    E peek();

    int size();

    boolean isEmpty();
}
