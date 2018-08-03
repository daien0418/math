public class Produce implements Runnable {

	public int flag = 1;
	private String name;
	private Basket basket = null;

	public Produce(String name, Basket basket) {
		this.name = name;
		this.basket = basket;
	}

	@Override
	public void run() {

		for (int i = 0; i < 10; i++) {
			try {
				Thread.sleep(30);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			basket.add();
			System.out.println(name + "Éú²úÁË" + i);
		}

	}

}
