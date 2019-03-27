package juc.semaphore;

import java.util.concurrent.Semaphore;

public abstract class TaskCell implements Runnable {

	private Semaphore semaphore;

	public TaskCell(Semaphore semaphore) {
		this.semaphore = semaphore;
	}

	@Override
	public void run() {
		try {
			execute();
		} finally {
			semaphore.release(1);
		}
	}

	protected abstract void execute();

}
