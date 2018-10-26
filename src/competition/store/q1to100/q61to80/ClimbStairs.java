package competition.store.q1to100.q61to80;

import java.math.BigInteger;

public class ClimbStairs {

	public int climbStairs(int n) {

		int ret = 0;

		int divBy2 = n / 2;
		for (int i = 0; i <= divBy2; i++) {
			if (i == 0) {
				ret = ret + 1;
				continue;
			}
			int sum = i + n - i * 2;
			ret = ret + cal(i, sum);
		}

		return ret;
	}

	private int cal(int sub, int sum) {
		if (sub == 1) {
			return sum;
		}

		if (sub == sum) {
			return 1;
		}

		BigInteger div = new BigInteger("1");
		BigInteger divBy = new BigInteger("1");
		for (int i = sum; i > sum - sub; i--) {
			div = div.multiply(new BigInteger(String.valueOf(i)));
		}

		for (int i = 1; i <= sub; i++) {
			divBy = divBy.multiply(new BigInteger(String.valueOf(i)));
		}

		return div.divide(divBy).intValue();
	}

	public static void main(String[] args) {
		ClimbStairs climbStairs = new ClimbStairs();
		System.out.println(climbStairs.climbStairs(44));
	}

}
