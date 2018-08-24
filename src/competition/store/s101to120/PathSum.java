package competition.store.s101to120;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

import competition.structure.TreeNode;

public class PathSum {

	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		Set<TreeNode> set = new HashSet<TreeNode>();

		if (root != null)
			stack.push(root);

		int temp = 0;
		List<Integer> subList = new ArrayList<Integer>();

		while (!stack.isEmpty()) {
			TreeNode node = stack.pop();
			if (node.right == null && node.left == null) {
				if (set.contains(node)) {
					subList.remove(subList.size() - 1);
				} else {
					temp = 0;
					for (int val : subList) {
						temp = temp + val;
					}
					if (temp == sum - node.val) {
						List<Integer> newList = new ArrayList<Integer>(subList);
						newList.add(node.val);
						list.add(newList);
					}
				}
			} else {
				subList.add(node.val);
				stack.push(node);
				set.add(node);
				if (node.right != null) {
					stack.push(node.right);
					node.right = null;

				}
				if (node.left != null) {
					stack.push(node.left);
					node.left = null;
				}
			}
		}

		return list;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(4);
		root.right = new TreeNode(8);
		root.left.left = new TreeNode(11);
		root.left.left.left= new TreeNode(7);
		root.left.left.right= new TreeNode(2);
		root.right.left = new TreeNode(13);
		root.right.right = new TreeNode(4);
		root.right.right.right = new TreeNode(1);

		PathSum pathSum = new PathSum();
		List<List<Integer>> list =pathSum.pathSum(root, 22);
		System.out.println(list);
	}

}
