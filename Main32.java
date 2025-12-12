package com.codegnan.multithreading;

import java.util.Scanner;

class PalindromeThread extends Thread{
	private int num;
	private String label;
	public PalindromeThread(int num, String label, int priority) {
		super();
		this.num = num;
		this.label = label;
		this.setPriority(priority);
	}
	
	public void run() {
		int original = num;
		int rev = 0;
		
		while(num>0) {
			rev = rev * 10 + num%10;
			num /=10;
		}
		
		if(rev == original)
			System.out.println(label+ ": Palindrom");
		else
			System.out.println(label+ ": Not Palindrom");
	}
}
public class Main32 {

	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		PalindromeThread high = new PalindromeThread(n, "High", Thread.MAX_PRIORITY);
		PalindromeThread normal = new PalindromeThread(n, "Normal", Thread.NORM_PRIORITY);

		high.start();
		high.join();
		
		normal.start();
		normal.join();
		sc.close();
	}

}
