package com.dai.en.competition.store.s501to600.s501to520;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.dai.en.competition.structure.TreeNode;

public class FindBottomLeftValue {

	public int findBottomLeftValue(TreeNode root) {
		Stack<TreeNode> inStack = new Stack<TreeNode>();
		Stack<TreeNode> outStack = new Stack<TreeNode>();
		List<Integer> list = new ArrayList<Integer>();
		int result = 0;
		if (root != null)
			inStack.push(root);
		while (!inStack.isEmpty()) {
			while (!inStack.isEmpty()) {
				TreeNode popNode = inStack.pop();
				list.add(popNode.val);
				if (popNode.left != null) {
					outStack.push(popNode.left);
				}
				if (popNode.right != null) {
					outStack.push(popNode.right);
				}
			}
			while (!outStack.isEmpty()) {
				inStack.push(outStack.pop());
			}
			result = list.get(0);
			list.clear();
		}

		return result;
	}

	public static void main(String[] args) {

	}

}
