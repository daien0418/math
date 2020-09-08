package com.dai.en.competition.store.s901to1000.s961to980;

import java.util.ArrayList;
import java.util.List;

import com.dai.en.competition.structure.TreeNode;

public class Flip971 {
	int[] voyage;
	int len = 0;
	List<Integer> list = new ArrayList<>();
	int index = 0;

	public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
		this.voyage = voyage;
		dfs(root);
		return list;
	}

	public void dfs(TreeNode node) {
		if (null == node) {
			return;
		}
		if (node.val != voyage[index++]) {
			list.clear();
			list.add(-1);
			return;
		}
		if (index < voyage.length && node.left != null && node.left.val != voyage[index]) {
			list.add(node.val);
			dfs(node.right);
			dfs(node.left);
		} else {
			dfs(node.left);
			dfs(node.right);
		}
	}
}
