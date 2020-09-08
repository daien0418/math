package com.dai.en.competition.store.s201to300.s241to260;

import java.util.ArrayList;
import java.util.List;

import com.dai.en.competition.structure.TreeNode;

public class BinaryTreePaths {

	public List<String> binaryTreePaths(TreeNode root) {
		List<String> list = new ArrayList<String>();
		dfs(root, list, "");
		return list;
	}

	public void dfs(TreeNode node, List<String> list, String temp) {
		if (node.left == null && node.right == null) {
			list.add(temp + node.val);
			return;
		}
		temp = temp.concat(String.valueOf(node.val)+"->");
		if (node.left != null)
			dfs(node.left, list, temp);
		if (node.right != null)
			dfs(node.right, list, temp);
	}

	public static void main(String[] args) {
		BinaryTreePaths binaryTreePaths = new BinaryTreePaths();
		TreeNode root = new TreeNode(6);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(4);
		root.left.right.left = new TreeNode(3);
		root.left.right.right = new TreeNode(5);
		root.right = new TreeNode(8);
		root.right.left = new TreeNode(7);
		root.right.right = new TreeNode(9);
		List<String> list = binaryTreePaths.binaryTreePaths(root);
		for (String string : list) {
			System.out.println(string);
		}
	}

}
