package com.dai.en.competition.store.s501to600.s501to520;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.dai.en.competition.structure.TreeNode;

public class FindFrequentTreeSum {

	public int[] findFrequentTreeSum(TreeNode root) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		cal(root, map);

		List<Integer> list = new ArrayList<Integer>();
		Iterator<Integer> iterator = map.keySet().iterator();
		int times = 0;
		while (iterator.hasNext()) {
			Integer key = iterator.next();
			if (map.get(key) > times) {
				list.clear();
				list.add(key);
				times = map.get(key);
			} else if (map.get(key) == times) {
				list.add(key);
			}
		}

		int[] result = new int[list.size()];

		for (int i = 0; i < list.size(); i++) {
			result[i] = list.get(i);
		}

		return result;
	}

	private void cal(TreeNode root, Map<Integer, Integer> map) {
		if (root == null)
			return;
		int sum = TreeSum(root);
		if (map.containsKey(sum)) {
			map.put(sum, map.get(sum) + 1);
		} else {
			map.put(sum, 1);
		}
		if (root.left != null)
			cal(root.left, map);
		if (root.right != null)
			cal(root.right, map);
	}

	private int TreeSum(TreeNode root) {
		if (root == null)
			return 0;

		return root.val + TreeSum(root.left) + TreeSum(root.right);
	}

	public static void main(String[] args) {

	}

}
