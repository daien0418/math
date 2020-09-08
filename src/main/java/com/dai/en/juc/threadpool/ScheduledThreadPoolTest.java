package com.dai.en.juc.threadpool;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ScheduledThreadPoolTest {

	public static void main(String args[]) {
		Runnable runnable = new InnerTask();
		ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(10);
		scheduledExecutorService.schedule(runnable, 10, TimeUnit.SECONDS);
		scheduledExecutorService.schedule(runnable, 10, TimeUnit.SECONDS);
		scheduledExecutorService.schedule(runnable, 10, TimeUnit.SECONDS);
		BlockingQueue<Runnable> blockingQueue = ((ScheduledThreadPoolExecutor) scheduledExecutorService).getQueue();
		System.out.println("");
	}

	static class InnerTask implements Runnable {

		@Override
		public void run() {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName());
		}

	}

}
