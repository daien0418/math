package competition.store.s101to200.s121to140;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

import competition.structure.TreeNode;

public class SumNumbers {

	public int sumNumbers(TreeNode root) {
		int sum = 0;
		int subSum = 0;

		Stack<TreeNode> stack = new Stack<TreeNode>();
		Set<TreeNode> set = new HashSet<TreeNode>();
		if (root != null) {
			stack.push(root);
		}

		while (!stack.isEmpty()) {
			TreeNode node = stack.pop();

			if (node.left == null && node.right == null) {
				if (!set.contains(node)) {
					subSum = subSum * 10 + node.val;
					sum = sum + subSum;
				}

				subSum = (subSum - node.val) / 10;
			} else {
				subSum = subSum * 10 + node.val;
				stack.push(node);
				if (node.right != null) {
					stack.push(node.right);
				}
				if (node.left != null) {
					stack.push(node.left);
				}
				set.add(node);
			}
			node.right = null;
			node.left = null;
		}

		return sum;
	}

	public static void main(String[] args) {

	}

}
