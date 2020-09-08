package com.dai.en.competition.store.s501to600.s521to540;

import java.util.Stack;

import com.dai.en.competition.structure.TreeNode;

public class GetMinimumDifference {

	public int getMinimumDifference(TreeNode root) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		if (root != null)
			stack.push(root);
		int min = Integer.MAX_VALUE;
		TreeNode fisrtNode = null;
		while (!stack.isEmpty()) {
			TreeNode popNode = stack.pop();
			if (popNode.left == null && popNode.right == null) {
				if (fisrtNode == null) {
					fisrtNode = popNode;
				} else {
					if (Math.abs(fisrtNode.val - popNode.val) < min) {
						min = Math.abs(fisrtNode.val - popNode.val);
					}
					fisrtNode = popNode;
				}
			} else {
				if (popNode.right != null)
					stack.push(popNode.right);
				stack.push(popNode);
				if (popNode.left != null)
					stack.push(popNode.left);
				popNode.left = null;
				popNode.right = null;
			}
		}

		return min;
	}

	public static void main(String[] args) {

	}

}
