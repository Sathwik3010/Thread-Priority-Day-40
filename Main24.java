package com.codegnan.multithreading;

import java.util.Scanner;

class NumberThreads extends Thread{
	int n;
	boolean printOdd;
	String label;
	
	public NumberThreads(int n, boolean printOdd, String label, int priority) {
		super();
		this.n = n;
		this.printOdd = printOdd;
		this.label = label;
		this.setPriority(priority);
	}
	
	public void run() {
		System.out.print(label +": ");
		for(int i=1; i<=n;i++) {
			if(printOdd && i%2 == 1) {
				System.out.print(i+" ");
			} else if(!printOdd && i%2 == 0) {
				System.out.print(i+" ");
			}
		}
		System.out.println();
	}
}
public class Main24 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		NumberThreads normal = new NumberThreads(n, true, "Normal", Thread.NORM_PRIORITY);
		NumberThreads low = new NumberThreads(n, false, "Low", Thread.MIN_PRIORITY);
		
		normal.start();
		try {
			normal.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		low.start();
		try {
			low.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sc.close();
	}

}
