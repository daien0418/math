package juc.semaphore;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * 流水线执行框架 为了简便，线程池写在此类中了，开发中建议挪到别处
 *
 * @author daien
 * @date 2018年12月25日
 */
public class Pipeline implements Runnable {

	public static ExecutorService executorService = Executors.newCachedThreadPool();
	private Semaphore semaphore = new Semaphore(0);
	private List<TaskModel> tasks = new ArrayList<TaskModel>();

	public void add(TaskModel taskModel) {
		tasks.add(taskModel);
	}

	public Semaphore getSemaphore() {
		return semaphore;
	}

	@Override
	public void run() {
		long pstart = System.currentTimeMillis();

		for (TaskModel taskModel : tasks) {
			long start = System.currentTimeMillis();
			int initSemphore = semaphore.availablePermits();
			taskModel.excute();
			try {
				semaphore.tryAcquire(initSemphore + taskModel.getSize(), 60l, TimeUnit.SECONDS);
				System.out.println("任务组用时：" + (System.currentTimeMillis() - start));
			} catch (InterruptedException e) {
			}
		}

		System.out.println("流水线用时：" + (System.currentTimeMillis() - pstart));
		executorService.shutdown();
	}

}
