import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Relocktest {

	private ReentrantLock lock =  new ReentrantLock();
	private Condition condition = lock.newCondition();
	private ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();

	public void service(Object obj){
		synchronized (obj) {
			System.out.println(Thread.currentThread().getName()+"----start:"+System.currentTimeMillis());
			try {
				obj.wait(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+"-----end:"+System.currentTimeMillis());
		}
	}

	public void notifyservice(Object obj){
		synchronized (obj) {
			obj.notify();
		}
	}

	public static void main(String args[]){
		Relocktest relocktest = new Relocktest();
		Object object = new Object();
		Runnable runa = new Runnable() {

			@Override
			public void run() {
				relocktest.service(object);
			}
		};

		Runnable runb = new Runnable() {

			@Override
			public void run() {
				relocktest.notifyservice(object);
			}
		};
		Thread aThread = new Thread(runa);
		aThread.setName("A");
		aThread.start();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Thread bThread = new Thread(runb);
		bThread.setName("B");
		bThread.start();
	}

}
