package juc.semaphore;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * ��ˮ��ִ�п�� Ϊ�˼�㣬�̳߳�д�ڴ������ˣ������н���Ų����
 *
 * @author daien
 * @date 2018��12��25��
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
				System.out.println("��������ʱ��" + (System.currentTimeMillis() - start));
			} catch (InterruptedException e) {
			}
		}

		System.out.println("��ˮ����ʱ��" + (System.currentTimeMillis() - pstart));
		executorService.shutdown();
	}

}
