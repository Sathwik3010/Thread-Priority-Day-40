package com.codegnan.multithreading;

import java.util.Scanner;

class SumThreads extends Thread{
	private int[] arr;
	private String label;
	
	public SumThreads(String label, int[] arr, int priority) {
		this.label = label;
		this.arr = arr;
		this.setPriority(priority);
	}
	
	@Override
	public void run() {
		int sum=0;
		for(int n : arr) {
			sum += n;
		}
		System.out.print(label+": "+sum);
	}
}

public class Main31 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int len = sc.nextInt();
		int[] arr = new int[len];
		
		for(int i=0; i<len; i++) {
			arr[i]=sc.nextInt();
		}
		
		SumThreads high = new SumThreads("High",arr, Thread.MAX_PRIORITY);
		SumThreads normal = new SumThreads("Normal",arr, Thread.NORM_PRIORITY);

		high.start();
		try {
			high.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		normal.start();
		try {
			normal.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sc.close();
	}

}
