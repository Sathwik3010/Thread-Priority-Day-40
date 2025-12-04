package com.codegnan.multithreading;

public class ThreadDemo {

	public static void main(String[] args) {
		MyThread t = new MyThread();
		t.start();
//		t.start();

		for(int i=0; i<200;i++) {
			System.out.println("main thread");
		}
//		t.run();
	}

}
