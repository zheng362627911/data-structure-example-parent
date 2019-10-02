package com.learn.datastructure.sort.dn.sort;


public class HeapSort {
//������
	public static void main(String[] args){
		int[] array = {39,44,1,0,8,66,23,67,9,15,100,70,22,3,6,54};
		HeapSort heapSort = new HeapSort();
		heapSort.heapSort(array);
		for(int i = 0;i<array.length;i++){
			System.out.println(" "+array[i]);
		}
	}
	
	public void heapSort(int [] a){
		if(a == null||a.length<=1){
			return;
		}
		//�������
		buildMaxHeap(a);
		for(int i = a.length-1;i>=1;i--){
			//���Ԫ���Ѿ��������±�Ϊ0�ĵط�
			exchangeElements(a, 0, i);//ÿ������һ�Σ��ͳ���һ����Ԫ��
			maxHeap(a, i, 0);
		}
	}

	
	private void buildMaxHeap(int[] a) {
		int half = (a.length -1)/2;//���賤��Ϊ9
		for(int i = half;i>=0;i--){
			//ֻ�����43210
			maxHeap(a,a.length,i);
		}
	}

	//length��ʾ���ڹ����ѵ����鳤��Ԫ������
	private void maxHeap(int[] a, int length, int i) {
		int left = i*2+1;
		int right = i*2+2;
		int largest = i;
		if(left<length&&a[left]>a[i]){
			largest = left;
		}
		if(right<length&&a[right]>a[largest]){
			largest = right;
		}
		if(i!=largest){
			//�������ݽ���
			exchangeElements(a,i,largest);
			maxHeap(a, length, largest);
		}
	}

	//������a����������±�Ԫ�ؽ���
	private void exchangeElements(int[] a, int i, int largest) {
		int temp = a[i];
		a[i] = a[largest];
		a[largest] = temp;
	}
}
