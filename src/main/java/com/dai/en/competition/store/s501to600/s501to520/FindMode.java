package com.dai.en.competition.store.s501to600.s501to520;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.dai.en.competition.structure.TreeNode;

public class FindMode {

	public int[] findMode(TreeNode root) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		find(root, map);

		int times = 0;

		List<Integer> list = new ArrayList<Integer>();
		Iterator<Integer> iterator = map.keySet().iterator();
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

	private void find(TreeNode root, Map<Integer, Integer> map) {
		if (root == null)
			return;
		if (map.get(root.val) == null) {
			map.put(root.val, 1);
		} else {
			map.put(root.val, map.get(root.val) + 1);
		}

		find(root.left, map);
		find(root.right, map);
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.right = new TreeNode(2);
		root.right.left = new TreeNode(2);
		FindMode findMode = new FindMode();
		findMode.findMode(root);
	}

}
