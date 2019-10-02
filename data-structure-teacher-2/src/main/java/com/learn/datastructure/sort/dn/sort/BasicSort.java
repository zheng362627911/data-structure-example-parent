package com.learn.datastructure.sort.dn.sort;

import java.util.ArrayList;
import java.util.List;

public class BasicSort {
	public void sort(int [] array){
		int max = 0;//��ȡ���ֵ
		for(int i = 0;i<array.length;i++){
			if(max<array[i]){
				max = array[i];
			}
		}
		int times = 0;//��ȡ���ֵλ��
		while(max>0){
			max = max/10;
			times++;
		}
		List<ArrayList> queue = new ArrayList<ArrayList>();//��ά����
		for(int i = 0;i<10;i++){
			ArrayList q = new ArrayList<>();
			queue.add(q);
		}
		for(int i = 0;i<times;i++){
			for(int j = 0;j<array.length;j++){
				//��ȡ��Ӧ��λ��ֵ��iΪ0�Ǹ�λ��1��10λ��2�ǰ�λ��
				int x = array[j]%(int)Math.pow(10, i+1)/(int)Math.pow(10, i);
				ArrayList q = queue.get(x);
				q.add(array[j]);//��Ԫ����ӽ���Ӧ�±�����
//				queue.set(x,q);//����
			}
			//��ʼ�ռ�
			int count = 0;
			for(int j = 0;j<10;j++){
				while(queue.get(j).size()>0){
					ArrayList<Integer> q = queue.get(j);//�õ�ÿһ������
					array[count] = q.get(0);
					q.remove(0);
					count++;
				}
			}
		}
	}
	
	public static void main(String[] args){
		BasicSort basicSort = new BasicSort();
		int [] a = {136,2,6,8,9,2,8,11,23,56,34,90,89,29,145,209,320,78,3};
		basicSort.sort(a);
		for(int n:a){
			System.out.print(" "+n);
		}
	}
}
