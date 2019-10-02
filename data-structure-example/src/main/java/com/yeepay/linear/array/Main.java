package com.yeepay.linear.array;

import com.yeepay.linear.List;

/**
 * Created by zhenghao on 2019/2/13
 * call me 201****397
 */
public class Main {
    public static void main(String[] args) {
        List<Integer> arrayList = new DynamicArrayList<Integer>(5);
        for (int i = 0; i < 20; i++) {
            arrayList.add(i);
        }
        System.out.println(arrayList);

        for (int i = 0; i < 10; i++) {
            arrayList.remove(0);
        }

        System.out.println(arrayList);
    }
}
