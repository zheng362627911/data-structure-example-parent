package com.yeepay.linear.linked;

/**
 * Created by zhenghao on 2019/2/15
 * call me 201****397
 */
public class Main {

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<Integer>();
        linkedTest(linkedList);
    }

    private static void linkedTest(LinkedList<Integer> linkedList) {

        for (int i = 0; i < 10; i++) {
            //linkedList.add(i,0);
            linkedList.addLast(i);
        }

        System.out.println(linkedList);
        linkedList.reverse();
        System.out.println(linkedList);


      //  linkedList.add(100,5);
        System.out.println(linkedList);
        for (int i = 0; i < 5; i++) {
            linkedList.removeFirst();
        }
        System.out.println(linkedList);

    }
}
