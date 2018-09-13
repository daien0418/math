package competition.store.q61to80;

import java.util.ArrayList;
import java.util.List;

public class Combine {

	/*
	 * / 123 4567 234 567 345 67 124 567 125 67 235 67 346 7 126 7 236 7 356 7
	 * 134 567 245 67 135 67 246 7 456 7 136 7 256 7 145 67 146 7 156 7
	 *
	 *
	 */
	public List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		List<Integer> temp = new ArrayList<Integer>();
		for (int i = 1; i < k; i++) {
			temp.add(i);
		}
		boolean over = false;

		while (true) {
			int tail = k == 1 ? 0 : temp.get(k - 2);
			for (int j = tail + 1; j <= n; j++) {
				List<Integer> newList = new ArrayList<Integer>(temp);
				newList.add(j);
				list.add(newList);
			}

			for (int j = k - 2; j >= 0; j--) {
				if (temp.get(j) < n - 1 - (k - 2 - j)) {
					temp.set(j, temp.get(j) + 1);

					for (int m = j + 1; m <= k - 2; m++) {
						temp.set(m, temp.get(j) + m - j);
					}
					break;
				} else {
					if (j == 0) {
						over = true;
					}
				}
			}
			if (k == 1) {
				break;
			}
			if (over) {
				break;
			}
		}

		return list;
	}

	public static void main(String[] args) {

	}

}
