package com.codegnan.multithreading;

import java.util.Scanner;

class SquareThread extends Thread{
	int n;
	String label;
	public SquareThread(int n, String label, int priority) {
		super();
		this.n = n;
		this.label = label;
		this.setPriority(priority);
	}
	
	public void run() {
		System.out.print(label+": ");
		for(int i=1; i<=n; i++) {
			System.out.print((i * i)+" ");
		}
		System.out.println();
	}
}

public class Main26 {

	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		SquareThread high = new SquareThread(n, "High", Thread.MAX_PRIORITY);
		SquareThread norm = new SquareThread(n, "Normal", Thread.NORM_PRIORITY);

		high.start();
		high.join();

		norm.start();
		
		norm.join();
		
		sc.close();
	}

}
