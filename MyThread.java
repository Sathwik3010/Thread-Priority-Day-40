package com.codegnan.multithreading;

public class MyThread extends Thread{
	public void run() {
		for(int i=0;i<200; i++) {
			System.out.println("Child Thread");
//			System.out.println(i);
		}
	}
}
