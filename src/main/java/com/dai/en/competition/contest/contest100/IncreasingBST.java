package com.dai.en.competition.contest.contest100;

import com.dai.en.competition.structure.TreeNode;

public class IncreasingBST {

	public TreeNode increasingBST(TreeNode root) {
		TreeNode left = root.left;
		TreeNode right = root.right;
		TreeNode retL = null;
		if (left != null) {
			root.left = null;
			retL = increasingBST(left);
			TreeNode temp = retL;
			while (temp.right != null) {
				temp = temp.right;
			}
			temp.right = root;
		}
		if (right != null) {
			root.right = increasingBST(right);
		}
		return left!=null?retL:root;
	}

	public static void main(String[] args) {

	}

}
