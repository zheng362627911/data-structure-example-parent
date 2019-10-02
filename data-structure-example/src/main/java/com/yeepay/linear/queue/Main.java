package com.yeepay.linear.queue;

/**
 * Created by zhenghao on 2019/2/13
 * call me 201****397
 */
public class Main {

    public static void main(String[] args) {
        Queue<Integer> queue = new ArrayQueue<Integer>(10);
        Queue<Integer> loopQueue = new LoopQueue<Integer>(10);
        queueTest(loopQueue);
    }

    private static void queueTest(Queue<Integer> queue) {
        for (int i = 0; i < 10; i++) {
            queue.add(i);
        }
        System.out.println(queue);
        System.out.println(queue.size());

        for (int i = 0; i < 5; i++) {
            queue.poll();
        }
        System.out.println(queue);
        System.out.println(queue.size());
        for (int i = 0; i < 6; i++) {
            queue.add(i);
        }
        System.out.println(queue);
        System.out.println(queue.size());

    }

}
