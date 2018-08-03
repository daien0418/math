import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;

public class Join {

	class Td extends Thread{

		@Override
		public void run() {
				try {
					Thread.sleep(10000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
		}

	}


	public static void main (String args[])
	{
			System.out.println(args.length);
			Join join = new Join();
			Td td = join.new Td();
			td.start();
			try {
				td.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("end");
	}

}
