package com.codegnan.multithreading;

import java.util.Scanner;

class NumberThread extends Thread {
	int n;
	String label;
	public NumberThread(int n, String label, int priority) {
		super();
		this.n = n;
		this.label = label;
		this.setPriority(priority);
	}
	
	@Override
	public void run() {
		System.out.print(label +": ");
		for(int i=1; i<=n; i++) {
			System.out.print(i);
			if(i<n)
				System.out.print(" ");
		}
		System.out.println();
	}
}
public class Main21 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a number");
		int n = sc.nextInt();
		
		NumberThread high = new NumberThread(n, "High", Thread.MAX_PRIORITY);
		NumberThread low = new NumberThread(n, "Low", Thread.MIN_PRIORITY);
		
		high.start();
		
		try {
			high.join();
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
