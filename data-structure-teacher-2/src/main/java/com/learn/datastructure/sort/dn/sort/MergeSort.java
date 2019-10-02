package com.learn.datastructure.sort.dn.sort;

public class MergeSort {
	public void mergeSort(int[] a,int left,int right){
		if(left<right){
			int middle = (left+right)/2;
			mergeSort(a, left, middle);
			mergeSort(a,middle+1,right);
			merge(a,left,middle,right);//�ϲ�
		}
	}

	private void merge(int[] a, int left, int middle, int right) {
		int [] tmpArray = new int[a.length];
		int rightStart = middle+1;
		int tmp = left;
		int third = left;
		//�Ƚ�����С������Ӧ�±�λ�õ������С��С���ȷŽ�������
		while(left<=middle&&rightStart<=right){
			if(a[left]<=a[rightStart]){
				tmpArray[third++] = a [left++];
			}else{
				tmpArray[third++] = a[rightStart++];
			}
		}
		//�����߻���������Ҫ���������������ʣ�µĿ�����������
		while(left<=middle){
			tmpArray[third++] = a[left++];
		}
		//����ұ߻�������......
		while(rightStart<=right){
			tmpArray[third++] = a[rightStart++];
		}
		while(tmp<=right){
			a[tmp] = tmpArray[tmp++];
		}
	}
	
	public static void main(String[] args){
		MergeSort mergeSort = new MergeSort();
		int [] a = new int[]{90,3,2,67,44,-9,87,65,11,9,2,8};
		mergeSort.mergeSort(a, 0, a.length-1);
		for(int n:a){
			System.out.print(" "+n);
		}
	}
}
