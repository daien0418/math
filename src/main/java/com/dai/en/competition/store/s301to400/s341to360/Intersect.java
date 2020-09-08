package com.dai.en.competition.store.s301to400.s341to360;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Intersect {

	public int[] intersect(int[] nums1, int[] nums2) {
		List<Integer> list = new ArrayList<Integer>();
		if (nums1 != null && nums2 != null && nums1.length != 0 && nums2.length != 0) {
			Map<Integer, Integer> map = new HashMap<Integer, Integer>();
			for (int n : nums1) {
				if (map.containsKey(n)) {
					map.put(n, map.get(n) + 1);
				} else {
					map.put(n, 1);
				}
			}

			for (int n : nums2) {
				if (map.containsKey(n)) {
					list.add(n);
					if (map.get(n) == 1) {
						map.remove(n);
					} else {
						map.put(n, map.get(n) - 1);
					}
				}
			}
		}

		int[] result = new int[list.size()];
		int i = 0;
		for (int n : list) {
			result[i++] = n;
		}

		return result;
	}

	public static void main(String[] args) {

	}

}
