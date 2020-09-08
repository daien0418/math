package com.dai.en.competition.store.q1to100.q41to60;

import java.util.ArrayList;
import java.util.List;

public class GetPermutation {

	public String getPermutation(int n, int k) {
		List<String> data = new ArrayList<String>();
		String ret = "";
		for (int i = 1; i <= n; i++) {
			data.add(String.valueOf(i));
		}

		int jc = njc(n - 1);

		for (int i = n - 1; i >= 0; i--) {
			if (k == 0) {
				if (data.size() > 0) {
					for (int j = data.size() - 1; j >= 0; j--) {
						ret = ret + data.get(j);
					}
				}
				break;
			}
			int s = k / jc;
			int y = k % jc;
			if (y != 0) {
				ret = ret + data.get(s);
				data.remove(s);
			} else {
				ret = ret + data.get(s - 1);
				data.remove(s - 1);
			}

			k = y;
			if (i != 0) {
				jc = jc / i;
			}
		}

		return ret;
	}

	private int njc(int n) {
		if (n == 1 || n == 0)
			return 1;
		return n * njc(n - 1);
	}

	public static void main(String[] args) {
		GetPermutation getPermutation = new GetPermutation();
		System.out.println(getPermutation.getPermutation(4, 9));
	}

}
