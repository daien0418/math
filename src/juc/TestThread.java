package juc;
public class TestThread {

	class Service{
		private boolean flag = true;
		int i;

		public void runService() {
				while(flag){
					try {
						Thread.sleep(300);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					if(flag){
						 i= 0;
//						System.out.println("真");
					}else{
						 i= 1;
//						System.out.println("假");
					}
//					System.out.println("ddd");
				}
			System.out.println("停下来了");
			System.out.println(i);
		}

		public void stopService(){
			flag = false;
		}
	}

	class Thread1 implements Runnable{

		private Service service;

		public Thread1(Service service) {
			this.service = service;
		}

		@Override
		public void run() {
			service.runService();
		}

	}

	class Thread2 implements Runnable{

		private Service service;

		public Thread2(Service service) {
			this.service = service;
		}

		@Override
		public void run() {
			service.stopService();
			System.out.println("已经设置停下了");
		}

	}

	public static void main(String args[]) throws InterruptedException {
		TestThread testThread =  new TestThread();
		Service service = testThread.new Service();
		Thread threada = new Thread(testThread.new Thread1(service));
		threada.start();
		Thread.sleep(1000);
		Thread threadb = new Thread(testThread.new Thread2(service));
		threadb.start();
	}

}
