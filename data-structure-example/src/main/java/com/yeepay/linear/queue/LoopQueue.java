package com.yeepay.linear.queue;

/**
 * Created by zhenghao on 2019/2/13
 * call me 201****397
 */
public class LoopQueue<E> implements Queue<E> {
    // 头指针，永远指向第一个可读元素
    private int readIndex;
    // 写指针，永远指向下一个可写元素
    private int writeIndex;
    // size
    private int size;

    private Object[] data;

    public LoopQueue(int capacity) {
        data = new Object[capacity + 1];
    }

    @Override
    public void add(E e) {
        if (!isWrite()) {
            // System.out.println("loopArray is not Write");
            // return;
            grow(data.length * 2);
        }
        data[writeIndex] = e;
        /**
         * array length = 8 ;
         *
         * writeIndex = 0 ; (0+1)%8=1;
         * writeIndex = 1 ; (1+1)%8=2;
         * ....
         * writeIndex = 5 ; (5+1)%8=6;
         * writeIndex = 6 ; (6+1)%8=7;
         * writeIndex = 7 ; (7+1)%8=0;
         * writeIndex = 0 ; (1+1)%8=1;
         * ....
         */
        writeIndex = (writeIndex + 1) % data.length;
        size++;
    }

    private void grow(int capacity) {
        Object[] newArray = new Object[capacity + 1];
        for (int i = 0; i <= size; i++) {
            newArray[i] = data[readIndex];
            readIndex = (readIndex + 1) % data.length;
        }
        data = newArray;
        writeIndex = size;
        readIndex = 0;
    }


    @Override
    public E poll() {
        E element = null;
        if (isRead()) {
            element = (E) data[readIndex];
            data[readIndex] = null;
            size--;
            readIndex = (readIndex + 1) % data.length;
        }
        return element;
    }

    @Override
    public E peek() {
        return (E) data[readIndex];
    }

    @Override
    public int size() {
        if (writeIndex < readIndex) {
            return data.length - readIndex + writeIndex;
        }
        return writeIndex - readIndex;
    }

    @Override
    public boolean isEmpty() {
        return readIndex == writeIndex;
    }

    private boolean isRead() {
        return readIndex != writeIndex;
    }

    /**
     * 可写指针加一位如果等于可读指针，则队列满了，多预留一位意思是维护writeIndex一定是指向可写的位置的语义
     * 换言之 writeIndex == readIndex 时一定是为空
     * 往writeIndex位置处写入元素时，就要考虑writeIndex+1处是否可写，如果不可写了则认为队列满了
     * (writeIndex + 1) % data.length == readIndex 一定是队列满了
     *
     * @return
     */
    private boolean isWrite() {
        return (writeIndex + 1) % data.length != readIndex;
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("");
        if (readIndex == writeIndex) {
            return stringBuffer.toString();
        }
        for (int i = readIndex; i != writeIndex; i = (i + 1) % data.length) {
            stringBuffer.append(data[i] + ",");
        }
        return stringBuffer.toString();
    }
}
