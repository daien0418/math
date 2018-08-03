public class Costumer implements Runnable {

	private String name;
	private Basket basket = null;

	public Costumer(String name, Basket basket) {
		this.name = name;
		this.basket = basket;
	}

	@Override
	public void run() {

		for (int i = 0; i < 10; i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			basket.remove();
			System.out.println(name + "ฯ๛ทัมห" + i);
		}

	}

}
