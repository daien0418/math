package com.dai.en.juc.lock;
import java.util.concurrent.locks.ReentrantLock;

public class TryLockTest {

	public static void main(String args[]) {
		ReentrantLock lock = new ReentrantLock();
		Runnable runnable = new Runnable() {

			@Override
			public void run() {
					while (!lock.tryLock()) {
						System.out.println(Thread.currentThread().getName() + " failed: " + System.currentTimeMillis());
						try {
							Thread.sleep(500);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}

					System.out.println(Thread.currentThread().getName() + " success: " + System.currentTimeMillis());

					try {
						Thread.sleep(2000);
						System.out.println(Thread.currentThread().getName() + " end: " + System.currentTimeMillis());
					} catch (InterruptedException e) {
						e.printStackTrace();
					} finally {
					   lock.unlock();
				   }

			}
		};

		Thread aThread = new Thread(runnable);
		aThread.setName("A");
		aThread.start();
		Thread bThread = new Thread(runnable);
		bThread.setName("B");
		bThread.start();
	}
}
