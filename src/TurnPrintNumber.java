
/**
 * �����ӡ
 *
 * @author daien
 * @date 2018��5��25��
 */
public class TurnPrintNumber {

	public static void main(String args[]){
		Object lock = new Object();
		new Thread(new Runnable() {

			@Override
			public void run() {
				try {
				for(int i=0;i<10;i++){
					synchronized (lock) {
						if(i%2==1){
							System.out.println(Thread.currentThread().getName()+"��ӡ��"+i);
							lock.notify();
						}else{
							lock.wait();
						}
					}
				}
				} catch (InterruptedException e) {

				}
			}
		}).start();
		new Thread(new Runnable() {

			@Override
			public void run() {
				try {
				for(int i=0;i<10;i++){
					synchronized (lock) {
						if(i%2==0){
							System.out.println(Thread.currentThread().getName()+"��ӡ��"+i);
							lock.notify();
						}else{
							lock.wait();
						}
					}
				}
				} catch (InterruptedException e) {
				}
			}
		}).start();
	}

}
