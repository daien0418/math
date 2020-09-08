package com.dai.en.competition.store.s501to600.s501to520;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.dai.en.competition.structure.TreeNode;

public class LargestValues {

	public List<Integer> largestValues(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
		Stack<TreeNode> inStack = new Stack<TreeNode>();
		Stack<TreeNode> outStack = new Stack<TreeNode>();
		if (root != null)
			inStack.push(root);
		while (!inStack.isEmpty()) {
			int max = Integer.MIN_VALUE;
			while (!inStack.isEmpty()) {
				TreeNode popNode = inStack.pop();
				if (popNode.val > max) {
					max = popNode.val;
				}
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
			list.add(max);
		}
		return list;
	}

	public static void main(String[] args) {

	}

}
