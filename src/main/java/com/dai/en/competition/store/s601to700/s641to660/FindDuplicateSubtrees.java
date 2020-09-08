package com.dai.en.competition.store.s601to700.s641to660;

import java.util.ArrayList;
import java.util.List;

import com.dai.en.competition.structure.TreeNode;

public class FindDuplicateSubtrees {

	public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
		List<TreeNode> list = new ArrayList<>();
		if (root != null)
			find1(root, list);

		List<TreeNode> tempList = new ArrayList<>();
		for (TreeNode node : list) {

			boolean find = false;
			for (TreeNode node2 : tempList) {
				if (isSame(node, node2)) {
					find = true;
					break;
				}
			}

			if (!find) {
				tempList.add(node);
			}

		}
		return tempList;
	}

	private void find1(TreeNode root, List<TreeNode> list) {
		if (root == null)
			return;
		find(root.left, root.right, list);
		find1(root.left, list);
		find1(root.right, list);
	}

	private void find(TreeNode root1, TreeNode root2, List<TreeNode> list) {
		if (root1 == null || root2 == null)
			return;
		find2(root1, root2, list);
		find(root1.left, root2, list);
		find(root1.right, root2, list);
		return;
	}

	private boolean find2(TreeNode root1, TreeNode root2, List<TreeNode> list) {
		if (root1 == null || root2 == null)
			return false;
		if (isSame(root1, root2)) {
			list.add(root1);
			return true;
		}
		boolean leftF = find2(root1, root2.left, list);
		if (leftF)
			return true;
		boolean rightF = find2(root1, root2.right, list);
		if (rightF)
			return true;
		return false;
	}

	private boolean isSame(TreeNode root1, TreeNode root2) {
		if (root1 == null && root2 == null)
			return true;
		if ((root1 != null && root2 == null) || (root1 == null && root2 != null))
			return false;

		return root1.val == root2.val && isSame(root1.left, root2.left) && isSame(root1.right, root2.right);
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.right.left = new TreeNode(2);
		root.right.right = new TreeNode(4);
		root.right.left.left = new TreeNode(4);

		FindDuplicateSubtrees findDuplicateSubtrees = new FindDuplicateSubtrees();
		List<TreeNode> list = findDuplicateSubtrees.findDuplicateSubtrees(root);

		for (TreeNode node : list) {
			System.out.println(node.val);
		}
	}

}
