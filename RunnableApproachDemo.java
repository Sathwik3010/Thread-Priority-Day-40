package com.codegnan.multithreading;

public class RunnableApproachDemo {

	public static void main(String[] args) {
//		System.out.println(Thread.currentThread().getName()+"-----"+ Thread.currentThread().getPriority());
		Runnable r = new MyRunnable();
		Thread t = new Thread(r);
		t.start();
		try {
			t.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int i=0; i<10; i++) {
			System.out.println("Main Thread");
		}
//		System.out.println(t.getName()+"-----"+ t.getPriority());
//		t.setName("Sathwik");
//		t.setPriority(7);
//		System.out.println(t.getName()+"-----"+ t.getPriority());


//		t.start();
		//	t.run();
//		for(int i=20; i>10; i--) {
//			System.out.println(i);
//		}
	}
}
