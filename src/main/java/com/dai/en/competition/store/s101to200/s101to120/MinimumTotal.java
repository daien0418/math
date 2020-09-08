package com.dai.en.competition.store.s101to200.s101to120;

import java.util.ArrayList;
import java.util.List;

public class MinimumTotal {

	public int minimumTotal(List<List<Integer>> triangle) {
		int ret = Integer.MAX_VALUE;
		List<Integer> list = new ArrayList<Integer>();

		for (int i = 0; i < triangle.size(); i++) {
			list.add(0);
			List<Integer> curList = triangle.get(i);
			for (int j = curList.size() - 1; j >= 0; j--) {
				int pre = j - 1;
				int aft = j;
				int min = 0;
				if (pre < 0) {
					min = list.get(aft);
				} else if (aft == list.size() - 1) {
					min = list.get(pre);
				} else {
					min = Math.min(list.get(pre), list.get(aft));
				}
				list.set(j, min + curList.get(j));
			}
		}

		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) < ret) {
				ret = list.get(i);
			}
		}

		return ret;
	}

	/**
	 * 采用迭代，时间久，超时
	 *
	 * @param index
	 * @param row
	 * @param triangle
	 * @return
	 */
	private int min(int index, int row, List<List<Integer>> triangle) {
		if (row == triangle.size() - 1) {
			return triangle.get(row).get(index);
		}
		int left = min(index, row + 1, triangle);
		int right = min(index + 1, row + 1, triangle);

		if (left > right) {
			return right + triangle.get(row).get(index);
		} else {
			return left + triangle.get(row).get(index);
		}
	}

	public static void main(String[] args) {
		List<List<Integer>> triangle = new ArrayList<List<Integer>>();
		List<Integer> newList = new ArrayList<Integer>();
		newList.add(2);
		triangle.add(newList);
		newList = new ArrayList<Integer>();
		newList.add(3);
		newList.add(4);
		triangle.add(newList);
		newList = new ArrayList<Integer>();
		newList.add(6);
		newList.add(5);
		newList.add(7);
		triangle.add(newList);
		newList = new ArrayList<Integer>();
		newList.add(4);
		newList.add(1);
		newList.add(8);
		newList.add(3);
		triangle.add(newList);

		MinimumTotal minimumTotal = new MinimumTotal();
		System.out.println(minimumTotal.minimumTotal(triangle));
	}

}
