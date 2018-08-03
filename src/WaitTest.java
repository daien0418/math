import java.util.concurrent.locks.LockSupport;

public class WaitTest {
	private static Thread mainThread;

	public static void main(String[] args) throws InterruptedException {

		ThreadA ta = new ThreadA("ta");
		// ��ȡ���߳�
		mainThread = Thread.currentThread();

		System.out.println(Thread.currentThread().getName() + " start ta");
		ta.start();
//		Thread.sleep(1000);
		System.out.println(Thread.currentThread().getName() + " block");
		// ���߳�����
		LockSupport.park();

		System.out.println(Thread.currentThread().getName() + " continue");
	}

	static class ThreadA extends Thread {

		public ThreadA(String name) {
			super(name);
		}

		public void run() {
			System.out.println(Thread.currentThread().getName() + " wakup others");
			// ���ѡ����̡߳�
			LockSupport.unpark(mainThread);
		}
	}
}
