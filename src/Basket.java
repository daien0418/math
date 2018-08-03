
public class Basket {

	private int sum = 0;

	public synchronized void add() {
		try {
			while (sum == 8) {
				wait();
			}
			sum++;
			notify();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public synchronized void remove() {
		try {
			while (sum == 0) {
				wait();
			}
			sum--;
			notify();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
}
