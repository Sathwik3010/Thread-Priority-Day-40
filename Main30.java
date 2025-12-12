package com.codegnan.multithreading;

import java.util.Scanner;

class PrimeThread extends Thread{
	private int n;
	private String label;
	
	public PrimeThread(int n, String label, int priority) {
		super();
		this.n = n;
		this.label = label;
		this.setPriority(priority);
	}
	
	private boolean isPrime(int x) {
		if(x<2)
			return false;
		
		for(int i=2; i<= x/2; i++) {
			if(x % i == 0)
				return false;
		}
		return true;
	}
	
	public void run() {
		StringBuilder sb = new StringBuilder();
		for(int i=2; i<=n; i++) {
			if(isPrime(i))
				sb.append(i).append(" ");
		}
		if(sb.length()==0)
            System.out.println(label + ": 0");
		else
			System.out.println(label +": "+sb.toString().trim());
	}
}
public class Main30 {

	public static void main(String[] args) throws InterruptedException {
		Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        PrimeThread normal = new PrimeThread(n, "Normal", Thread.NORM_PRIORITY);
        PrimeThread low = new PrimeThread(n, "Low", Thread.MIN_PRIORITY);
        
        normal.start();
        normal.join();
        
        low.start();
        low.join();
        sc.close();
	}

}
