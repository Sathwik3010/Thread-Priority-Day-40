package com.codegnan.multithreading;

import java.util.Scanner;

class PrintThread extends Thread{
	int n;
	String s;
	String label;
	public PrintThread(int n, String s, String label, int priority) {
		super();
		this.n = n;
		this.s = s;
		this.label = label;
		this.setPriority(priority);
	}
	
	@Override
	public void run() {
		System.out.print(label + ": ");
		for(int i=1; i<=n; i++) {
			System.out.print(s);
			if(i<n)
				System.out.print(" ");
		}
		System.out.println();
	}
}


public class Main22 {

	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.nextLine();
		String s = sc.nextLine();
		
		PrintThread high  = new PrintThread(n, s, "High", Thread.MAX_PRIORITY);
		PrintThread normal = new PrintThread(n, s, "low", Thread.NORM_PRIORITY);
		
		high.start();
		high.join();
		
		normal.start();
		normal.join();
		sc.close();
	}

}
