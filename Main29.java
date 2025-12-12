package com.codegnan.multithreading;

import java.util.Scanner;

class ReverseThread extends Thread{
	private String str;
	private String label;
	
	public ReverseThread(String label, String str, int priority) {
		super();
		this.label = label;
		this.str = str;
		this.setPriority(priority);
	}
	
	public void run() {
		String rev = new StringBuilder(str).reverse().toString();
		System.out.println(label +": "+rev);
	}
}
public class Main29 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		
		ReverseThread high = new ReverseThread("High", s, Thread.MAX_PRIORITY);
		ReverseThread normal = new ReverseThread("Normal", s, Thread.NORM_PRIORITY);
		ReverseThread low = new ReverseThread("Low", s, Thread.MIN_PRIORITY);

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
