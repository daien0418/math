package com.dai.en.competition.store.s701to800.s781to800;

import java.util.Stack;

import com.dai.en.competition.structure.TreeNode;

public class MinDiffInBST {

	public int minDiffInBST(TreeNode root) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		if (root != null)
			stack.push(root);

		TreeNode first = null;
		int min = Integer.MAX_VALUE;
		while (!stack.isEmpty()) {
			TreeNode popNode = stack.pop();
			if (popNode.left != null) {
				stack.push(popNode);
				stack.push(popNode.left);
				popNode.left = null;
				continue;
			}

			if (first == null) {
				first = popNode;
			} else {
				int tempMin = Math.abs(popNode.val - first.val);
				if (tempMin < min) {
					min = tempMin;
				}
				first = popNode;
			}

			if (popNode.right != null)
				stack.push(popNode.right);
		}

		return min;
	}

	public static void main(String[] args) {

	}

}
