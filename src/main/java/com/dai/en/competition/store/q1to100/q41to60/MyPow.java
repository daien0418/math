package com.dai.en.competition.store.q1to100.q41to60;

public class MyPow {

	public double myPow(double x, int n) {
		if (n == 0)
			return 1;
		double ret = 1d;
		int n2 = Math.abs(n);
		for (int i = 0; i < n2; i++) {
			ret = ret * x;
		}

		if (n > 0) {
			return ret;
		} else {
			return 1 / ret;
		}
	}

	public static void main(String[] args) {
		MyPow myPow = new MyPow();
		System.out.println(myPow.myPow(2.0, 2147483647));
	}

}
