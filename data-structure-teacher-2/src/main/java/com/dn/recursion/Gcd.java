package com.dn.recursion;

public class Gcd {
	// (m>n)m��n�����Լ�� = n ��m%n�����Լ��
	// 36 24  12 = 24��12 = 12�� 0
	
	public int gcd(int m,int n){
		if(n == 0){
			return m;
		}else{
			return gcd(n,m%n);
		}
	}
	
	
	public static void main(String[] args){
		Gcd gcd = new Gcd();
		int x = gcd.gcd(99,55);
		System.out.println("x��"+x);
	}
}
