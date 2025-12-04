package com.codegnan.multithreading;

public class MyRunnable implements Runnable{

	@Override
	public void run() {
		for(int i=0; i<10; i++) {
//			Thread.yield();
			System.out.println(i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
