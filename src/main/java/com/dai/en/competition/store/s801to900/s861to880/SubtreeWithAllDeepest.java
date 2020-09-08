package com.dai.en.competition.store.s801to900.s861to880;

import java.util.ArrayList;
import java.util.List;

import com.dai.en.competition.structure.TreeNode;

public class SubtreeWithAllDeepest {

	List<List<TreeNode>> setList = new ArrayList<List<TreeNode>>();

	public TreeNode subtreeWithAllDeepest(TreeNode root) {
		generatePath(root, new ArrayList<TreeNode>());
		List<List<TreeNode>> tempList = new ArrayList<List<TreeNode>>();
		int len = 0;
		for (List<TreeNode> list : setList) {
			if (list.size() > len) {
				tempList.clear();
				tempList.add(list);
				len = list.size();
			} else if (list.size() == len) {
				tempList.add(list);
			}
		}

		TreeNode resultNode = null;
		for (int i = 0; i < len; i++) {
			TreeNode temp = null;
			boolean interupt = false;
			for (List<TreeNode> list : tempList) {
				if (list.get(i) != temp) {
					if (temp == null) {
						temp = list.get(i);
					} else {
						interupt = true;
						break;
					}
				}
			}
			if (!interupt) {
				resultNode = temp;
			} else {
				break;
			}
		}

		return resultNode;
	}

	private void generatePath(TreeNode root, List<TreeNode> list) {
		if (root == null) {
			setList.add(new ArrayList<TreeNode>(list));
			return;
		}
		list.add(root);
		generatePath(root.left, new ArrayList<TreeNode>(list));
		generatePath(root.right, new ArrayList<TreeNode>(list));
	}

	public static void main(String[] args) {

	}

}
