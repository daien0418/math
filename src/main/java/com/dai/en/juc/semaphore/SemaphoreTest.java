package com.dai.en.juc.semaphore;

import java.util.concurrent.Semaphore;

public class SemaphoreTest {

	public static void main(String args[]) {
		Pipeline pipeline = new Pipeline();
		TaskModel taskModel = new TaskModel();
		taskModel.add(new Task1(pipeline.getSemaphore()));
		taskModel.add(new Task2(pipeline.getSemaphore()));
		taskModel.setRunningType(0);
		pipeline.add(taskModel);

		TaskModel taskModel2 = new TaskModel();
		taskModel2.add(new Task3(pipeline.getSemaphore()));
		taskModel2.add(new Task4(pipeline.getSemaphore()));
		pipeline.add(taskModel2);

		pipeline.executorService.submit(pipeline);
	}

}

class Task1 extends TaskCell {

	public Task1(Semaphore semaphore) {
		super(semaphore);
	}

	@Override
	protected void execute() {
		System.out.println("task1");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}

class Task2 extends TaskCell {

	public Task2(Semaphore semaphore) {
		super(semaphore);
	}

	@Override
	protected void execute() {
		System.out.println("task2");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}

class Task3 extends TaskCell {

	public Task3(Semaphore semaphore) {
		super(semaphore);
	}

	@Override
	protected void execute() {
		System.out.println("task3");
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}

class Task4 extends TaskCell {

	public Task4(Semaphore semaphore) {
		super(semaphore);
	}

	@Override
	protected void execute() {
		System.out.println("task4");
		try {
			Thread.sleep(9000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
