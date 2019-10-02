package com.learn.datastructure.sort.dn.sort;
/**
 * ֱ�Ӳ�������
 * @author Administrator
 *
 */
public class InsertSort {
	public static void main(String [] args){
		int[] a = {49,38,65,97,23,22,76,1,5,8,2,0,-1};
		//ֱ�Ӳ�������ʼ
		for(int i = 1;i<a.length;i++){
			int temp = a[i];//�±�����ֵ���ȴ����뵽ǰ�����������
			int j;
			for(j = i-1;j>=0;j--){
				//������temp������������һ��
				if(a[j]>temp){
					a[j+1] = a[j];
				}else{
					break;
				}
			}
			a[j+1] = temp;
		}
		System.out.println("�����");
		for(int i = 0;i<a.length;i++){
			System.out.println(" "+a[i]);
		}
	}
}
