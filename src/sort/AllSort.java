package sort;
//dfs
public class AllSort {
	private int n = 2;
	private int[] book;
	private int[] a;

	public void init(int n) {
		this.n = n;
		book = new int[n+1];
		a = new int[n+1];
	}

	public void sort(int index) {
		if (index == n + 1) {
			if(a[1]*100+a[2]*10+a[3]+a[4]*100+a[5]*10+a[6] == a[7]*100+a[8]*10+a[9]){

				System.out.print(a[1]);
				System.out.print(a[2]);
				System.out.print(a[3]);
				System.out.print("+");
				System.out.print(a[4]);
				System.out.print(a[5]);
				System.out.print(a[6]);
				System.out.print("=");
				System.out.print(a[7]);
				System.out.print(a[8]);
				System.out.print(a[9]);
				System.out.print("\n");
			}
			return;
		}
		for (int i = 1; i <= n; i++) {
			if (book[i] == 0) {
				a[index] = i;
				book[i] = 1;
				sort(index + 1);
				book[i] = 0;
			}
		}
	}

	public static void main(String args[]) {
		AllSort sort = new AllSort();
		sort.init(9);
		sort.sort(1);
	}

}
