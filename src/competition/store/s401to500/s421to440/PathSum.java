package competition.store.s401to500.s421to440;

import java.util.ArrayList;
import java.util.List;

import competition.structure.TreeNode;

public class PathSum {

	// public int s = 0;

	public int pathSum(TreeNode root, int sum) {
		List<Integer> list = new ArrayList<Integer>();
		if (root != null)
			return find(root, list, sum);
		return 0;
	}

	private int find(TreeNode root, List<Integer> list, int sum) {
		int s = 0;
		List<Integer> newList = new ArrayList<Integer>();
		list.add(0);
		for (Integer integer : list) {
			if (root.val + integer == sum) {
				s++;
			}
			newList.add(integer + root.val);
		}
		list = newList;

		if (root.left != null)
			s = s + find(root.left, new ArrayList<>(list), sum);
		if (root.right != null)
			s = s + find(root.right, new ArrayList<>(list), sum);
		return s;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(10);
		root.left = new TreeNode(5);
		root.right = new TreeNode(-3);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(2);
		root.left.right.right = new TreeNode(1);
		root.left.left.left = new TreeNode(3);
		root.left.left.right = new TreeNode(-2);
		root.right.right = new TreeNode(11);

		PathSum pathSum = new PathSum();
		System.out.println(pathSum.pathSum(root, 1));

	}

}
