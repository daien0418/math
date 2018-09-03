package juc.join;

public class TestJoin implements Runnable {

	public static void main(String[] args) throws InterruptedException {
		Thread t = new Thread(new TestJoin());
		long start = System.currentTimeMillis();
		t.start();
		t.join(1000);// �ȴ��߳�t 1000����
		System.out.println(System.currentTimeMillis() - start);// ��ӡ��ʱ����
		System.out.println("Main finished");// ��ӡ���߳̽���
	}

	@Override
	public void run() {
//		synchronized (Thread.currentThread()) {
			for (int i = 1; i <= 5; i++) {
				try {
					Thread.sleep(1000);// ˯��5�룬ѭ����Ϊ�˷��������Ϣ
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("˯��" + i);
			}
			System.out.println("TestJoin finished");// t�߳̽���
//		}
	}

}
