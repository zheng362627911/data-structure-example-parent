package com.yeepay.linear;

/**
 * Created by zhenghao on 2019/1/28
 * call me 201****397
 */
public interface List<E> {

    void add(E e);

    void add(E e, int index);

    void addFirst(E e);

    void addLast(E e);

    E remove(E e);

    E remove(int index);

    E removeFirst();

    E removeLast();

    void set(int index, E e);

    E get(int index);

    boolean contains(E e);

    boolean isEmpty();

    int size();

}
