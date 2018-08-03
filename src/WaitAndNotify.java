
public class WaitAndNotify {

	public class wait implements Runnable {

		Object lock;

		public wait(Object lock) {
			this.lock = lock;
		}

		@Override
		public void run() {
			synchronized (lock) {
				System.out.println(Thread.currentThread().getName()+":start wait");
				try {
					lock.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName()+":end wait");
			}
		}

	}

	public class notify implements Runnable {

		Object lock;

		public notify(Object lock) {
			this.lock = lock;
		}

		@Override
		public void run() {
			synchronized (lock) {
				System.out.println(Thread.currentThread().getName()+":start notify");
				lock.notify();
				System.out.println(Thread.currentThread().getName()+":end notify");
			}
		}

	}

	public static void main(String args[]) throws Exception{
		WaitAndNotify waitAndNotify =  new WaitAndNotify();
		Object lock = new Object();
		wait w = waitAndNotify.new wait(lock);
		notify n1 = waitAndNotify.new notify(lock);
		notify n2 = waitAndNotify.new notify(lock);
		Thread wT = new Thread(w);
		Thread nT1 = new Thread(n1);
		Thread nT2 = new Thread(n2);
		wT.start();
		nT1.start();
		nT2.start();
	}

}
