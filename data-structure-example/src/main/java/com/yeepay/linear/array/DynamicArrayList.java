package com.yeepay.linear.array;

import com.yeepay.linear.List;

/**
 * Created by zhenghao on 2019/1/30
 * call me 201****397
 */
public class DynamicArrayList<E> implements List<E> {

    // 当前元素数量,同时也是写指针，严格保证元素按顺序添加,不存在skip情况
    private int size;

    // 元素容器
    private Object[] data;

    public DynamicArrayList(int initCapacity) {
        this.data = new Object[initCapacity];
    }

    @Override
    public void add(E e) {
        ensureCapacity();
        data[size++] = e;
    }

    private void ensureCapacity() {
        if (size == data.length) {
            grow(data.length * 2);
        }
    }

    private void grow(int capacity) {
        Object[] newArray = new Object[capacity];
        for (int i = 0; i < size; i++) {
            newArray[i] = data[i];
        }
        data = newArray;
    }

    @Override
    public void add(E e, int index) {
        if (index > size || index < 0) {
            throw new IllegalArgumentException();
        }
        ensureCapacity();
        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = e;
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
        return remove(size - 1);
    }

    @Override
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException();
        }
        E old = (E) data[index];
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        data[size - 1] = null;
        size--;

        if (size <= data.length / 4 && data.length / 2 != 0) {
            grow(data.length / 2);
        }
        return old;
    }

    @Override
    public E removeFirst() {
        return remove(0);
    }

    @Override
    public E removeLast() {
        return remove(size - 1);
    }

    @Override
    public void set(int index, E e) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException();
        }
        data[index] = e;
    }

    @Override
    public E get(int index) {
        return (E) data[index];
    }

    @Override
    public boolean contains(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
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
        return size;
    }

    public static void main(String[] args) {
        System.out.println(0 / 2);
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("");
        stringBuffer.append("{");

        for (int i = 0; i < size; i++) {
            stringBuffer.append(data[i] + ",");
        }
        stringBuffer.delete(stringBuffer.length()-1,stringBuffer.length())
        .append("}");
        return stringBuffer.toString();
    }
}
