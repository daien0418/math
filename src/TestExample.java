
public class TestExample {
	public static int x=100;

	public static void main(String args[]){
		TestExample a =new TestExample();
		a.x++;
		TestExample b=new TestExample();
		b.x++;
		a = new TestExample();
		a.x--;
		TestExample.x++;
		System.out.println(x);
	}


	 static class InTest{

	}
}
